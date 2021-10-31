import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HangmanTest {

    private Hangman hangman;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init() {
        hangman = new Hangman();
    }

    @Test
    public void initialization() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray());
        Output init = result.blockingFirst();

        assertThat(init).isNotNull();
        assertThat(init.secret).isEqualTo("secret");
        assertThat(init.discovered).isEqualTo("______");
        assertThat(init.guess).isEmpty();
        assertThat(init.misses).isEmpty();
        assertThat(init.parts).isEmpty();
        assertThat(init.status).isEqualTo(Status.PLAYING);
    }

    @Ignore("Remove to run test")
    @Test
    public void firstGuess() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("e"));

        Output last = result.blockingLast();
        assertThat(last.discovered).isEqualTo("_e__e_");
        assertThat(last.guess).containsExactly("e");
        assertThat(last.misses).isEmpty();
        assertThat(last.parts).isEmpty();
        assertThat(last.status).isEqualTo(Status.PLAYING);
    }

    @Ignore("Remove to run test")
    @Test
    public void firstMiss() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a"));
        Output last = result.blockingLast();

        assertThat(last.discovered).isEqualTo("______");
        assertThat(last.guess).isEmpty();
        assertThat(last.misses).containsExactly("a");
        assertThat(last.parts).containsExactly(Part.HEAD);
        assertThat(last.status).isEqualTo(Status.PLAYING);
    }

    @Ignore("Remove to run test")
    @Test
    public void gameInProgress() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a", "e", "o", "s"));
        Output last = result.blockingLast();

        assertThat(last.discovered).isEqualTo("se__e_");
        assertThat(last.guess).containsExactlyInAnyOrder("e", "s");
        assertThat(last.misses).containsExactlyInAnyOrder("a", "o");
        assertThat(last.parts).containsExactlyInAnyOrder(Part.HEAD, Part.BODY);
        assertThat(last.status).isEqualTo(Status.PLAYING);
    }

    @Ignore("Remove to run test")
    @Test
    public void wonGame() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a", "e", "o", "s", "c", "r", "g", "t"));
        Output last = result.blockingLast();

        assertThat(last.discovered).isEqualTo("secret");
        assertThat(last.guess).containsExactlyInAnyOrder("c", "e", "r", "s", "t");
        assertThat(last.status).isEqualTo(Status.WIN);
    }

    @Ignore("Remove to run test")
    @Test
    public void lostGame() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a", "b", "c", "d", "e", "f", "g", "h"));
        Output last = result.blockingLast();

        assertThat(last.discovered).isEqualTo("_ec_e_");
        assertThat(last.misses).containsExactlyInAnyOrder("a", "b", "d", "f", "g", "h");
        assertThat(last.status).isEqualTo(Status.LOSS);
        assertThat(last.parts).containsExactlyInAnyOrder(
                Part.HEAD,
                Part.BODY,
                Part.LEFT_ARM,
                Part.RIGHT_ARM,
                Part.LEFT_LEG,
                Part.RIGHT_LEG
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void consecutiveGames() {
        // This test setup is more complex because we have to order the emission of values in the
        // different observers.
        // 1. Word observable receives the work to guess
        // 2. Letter observable receives the various letters tried
        // 3. Word observable receives the new word to guess
        // 4. Letter observable receiveds the letters for the second word

        // Emitters respectively for the word and letter observables
        ObservableEmitter<String>[] emitters = new ObservableEmitter[2];
        Runnable emit = () -> {
            // Process sending the inputs in the right order
            emitters[0].onNext("secret");
            Stream.of("a", "e", "o", "s", "c", "r", "g", "t").forEach(emitters[1]::onNext);
            emitters[0].onNext("abba");
            Stream.of("a", "e", "s", "b").forEach(emitters[1]::onNext);
            emitters[0].onComplete();
        };
        Observable<String> words = createWordObservable(emitters, emit);
        Observable<String> letters = createLetterObservable(emitters, emit);
        Observable<Output> outputs = hangman.play(words, letters);

        // We collect the results of the game
        List<Output> results = new ArrayList<>();
        Disposable subscription = outputs.filter(output -> output.status != Status.PLAYING)
            .subscribe(results::add);
        try {
            assertThat(results.size()).isEqualTo(2);

            Output first = results.get(0);
            assertThat(first.discovered).isEqualTo("secret");
            assertThat(first.guess).containsExactlyInAnyOrder("s", "e", "c", "r", "t");
            assertThat(first.misses).containsExactlyInAnyOrder("a", "o", "g");
            assertThat(first.status).isEqualTo(Status.WIN);

            Output second = results.get(1);
            assertThat(second.discovered).isEqualTo("abba");
            assertThat(second.guess).containsExactlyInAnyOrder("a", "b");
            assertThat(second.misses).containsExactlyInAnyOrder("e", "s");
            assertThat(first.status).isEqualTo(Status.WIN);
        } finally {
            subscription.dispose();
        }
    }

    Observable createWordObservable(ObservableEmitter[] emitters, Runnable emit) {
        return Observable.create(
            emitter -> {
                // A new subscription was created for words, record it.
                emitters[0] = emitter;
                if (emitters[1] != null) {
                    // Start emitting only when both word and letter observable have subscriptions
                    emit.run();
                }
            });
    }

    Observable createLetterObservable(ObservableEmitter[] emitters, Runnable emit) {
        return Observable.create(
            emitter -> {
                // A new subscription was created for letters, record it.
                emitters[1] = emitter;
                if (emitters[0] != null) {
                    // Start emitting only when both word and letter observable have subscriptions
                    emit.run();
                }
            });
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotPlayAGuessTwice() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("e", "c", "s", "c"));

        assertThatThrownBy(() -> result.blockingLast())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Letter c was already played");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotPlayAMissTwice() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("e", "a", "s", "a"));

        assertThatThrownBy(() -> result.blockingLast())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Letter a was already played");
    }
}
