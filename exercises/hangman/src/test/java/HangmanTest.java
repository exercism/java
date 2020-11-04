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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        assertNotNull(init);
        assertEquals("secret", init.secret);
        assertEquals("______", init.discovered);
        assertEquals(Collections.emptySet(), init.guess);
        assertEquals(Collections.emptySet(), init.misses);
        assertEquals(Collections.emptyList(), init.parts);
        assertEquals(Status.PLAYING, init.status);
    }

    @Ignore("Remove to run test")
    @Test
    public void firstGuess() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("e"));
        Output last = result.blockingLast();
        assertEquals("_e__e_", last.discovered);
        assertEquals(Collections.singleton("e"), last.guess);
        assertEquals(Collections.emptySet(), last.misses);
        assertEquals(Collections.emptyList(), last.parts);
        assertEquals(Status.PLAYING, last.status);
    }

    @Ignore("Remove to run test")
    @Test
    public void firstMiss() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a"));
        Output last = result.blockingLast();
        assertEquals("______", last.discovered);
        assertEquals(Collections.emptySet(), last.guess);
        assertEquals(Collections.singleton("a"), last.misses);
        assertEquals(Collections.singletonList(Part.HEAD), last.parts);
        assertEquals(Status.PLAYING, last.status);
    }

    @Ignore("Remove to run test")
    @Test
    public void gameInProgress() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a", "e", "o", "s"));
        Output last = result.blockingLast();
        assertEquals("se__e_", last.discovered);
        assertEquals(Set.of("e", "s"), last.guess);
        assertEquals(Set.of("a", "o"), last.misses);
        assertEquals(
            Arrays.asList(
                Part.HEAD,
                Part.BODY),
            last.parts);
        assertEquals(Status.PLAYING, last.status);
    }

    @Ignore("Remove to run test")
    @Test
    public void wonGame() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a", "e", "o", "s", "c", "r", "g", "t"));
        Output last = result.blockingLast();
        assertEquals("secret", last.discovered);
        assertEquals(Set.of("c", "e", "r", "s", "t"), last.guess);
        assertEquals(Status.WIN, last.status);
    }

    @Ignore("Remove to run test")
    @Test
    public void lostGame() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("a", "b", "c", "d", "e", "f", "g", "h"));
        Output last = result.blockingLast();
        assertEquals("_ec_e_", last.discovered);
        assertEquals(Set.of("a", "b", "d", "f", "g", "h"), last.misses);
        assertEquals(Status.LOSS, last.status);
        assertEquals(
            Arrays.asList(
                Part.HEAD,
                Part.BODY,
                Part.LEFT_ARM,
                Part.RIGHT_ARM,
                Part.LEFT_LEG,
                Part.RIGHT_LEG),
            last.parts);
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
            assertEquals(2, results.size());

            Output first = results.get(0);
            assertEquals("secret", first.discovered);
            assertEquals(Set.of("s", "e", "c", "r", "t"), first.guess);
            assertEquals(Set.of("a", "o", "g"), first.misses);
            assertEquals(Status.WIN, first.status);

            Output second = results.get(1);
            assertEquals("abba", second.discovered);
            assertEquals(Set.of("a", "b"), second.guess);
            assertEquals(Set.of("e", "s"), second.misses);
            assertEquals(Status.WIN, first.status);
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
