import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HangmanTest {

    @Test
    public void initialization() {
        final Observable<Hangman.Output> result = Hangman.play(
                Observable.fromArray("secret"),
                Observable.fromArray());
        final Hangman.Output init = result.blockingFirst();
        assertNotNull(init);
        assertEquals("secret", init.secret);
        assertEquals("______", init.discovered);
        assertEquals(Collections.emptySet(), init.guess);
        assertEquals(Collections.emptySet(), init.misses);
        assertEquals(Collections.emptyList(), init.parts);
        assertEquals(Hangman.Status.PLAYING, init.status);
    }

    @Test
    public void firstGuess() {
        final Observable<Hangman.Output> result = Hangman.play(
                Observable.fromArray("secret"),
                Observable.fromArray("e"));
        final Hangman.Output last = result.blockingLast();
        assertEquals("_e__e_", last.discovered);
        assertEquals(Collections.singleton("e"), last.guess);
        assertEquals(Collections.emptySet(), last.misses);
        assertEquals(Collections.emptyList(), last.parts);
        assertEquals(Hangman.Status.PLAYING, last.status);
    }

    @Test
    public void firstMiss() {
        final Observable<Hangman.Output> result = Hangman.play(
                Observable.fromArray("secret"),
                Observable.fromArray("a"));
        final Hangman.Output last = result.blockingLast();
        assertEquals("______", last.discovered);
        assertEquals(Collections.emptySet(), last.guess);
        assertEquals(Collections.singleton("a"), last.misses);
        assertEquals(Collections.singletonList(Hangman.Part.HEAD), last.parts);
        assertEquals(Hangman.Status.PLAYING, last.status);
    }

    @Test
    public void gameInProgress() {
        final Observable<Hangman.Output> result = Hangman.play(
                Observable.fromArray("secret"),
                Observable.fromArray("a", "e", "o", "s"));
        final Hangman.Output last = result.blockingLast();
        assertEquals("se__e_", last.discovered);
        assertEquals(setOf("e", "s"), last.guess);
        assertEquals(setOf("a", "o"), last.misses);
        assertEquals(
                Arrays.asList(
                        Hangman.Part.HEAD,
                        Hangman.Part.BODY),
                last.parts);
        assertEquals(Hangman.Status.PLAYING, last.status);
    }

    @Test
    public void wonGame() {
        final Observable<Hangman.Output> result = Hangman.play(
                Observable.fromArray("secret"),
                Observable.fromArray("a", "e", "o", "s", "c", "r", "g", "t"));
        final Hangman.Output last = result.blockingLast();
        assertEquals("secret", last.discovered);
        assertEquals(setOf("c", "e", "r", "s", "t"), last.guess);
        assertEquals(Hangman.Status.WIN, last.status);
    }

    @Test
    public void lostGame() {
        final Observable<Hangman.Output> result = Hangman.play(
                Observable.fromArray("secret"),
                Observable.fromArray("a", "b", "c", "d", "e", "f", "g", "h"));
        final Hangman.Output last = result.blockingLast();
        assertEquals("_ec_e_", last.discovered);
        assertEquals(setOf("a", "b", "d", "f", "g", "h"), last.misses);
        assertEquals(Hangman.Status.LOSS, last.status);
        assertEquals(
                Arrays.asList(
                        Hangman.Part.HEAD,
                        Hangman.Part.BODY,
                        Hangman.Part.LEFT_ARM,
                        Hangman.Part.RIGHT_ARM,
                        Hangman.Part.LEFT_LEG,
                        Hangman.Part.RIGHT_LEG),
                last.parts);
    }

    @Test
    public void consecutiveGames() {
        final ObservableEmitter<String>[] emitters = new ObservableEmitter[2];
        final Runnable emit = () -> {
            emitters[0].onNext("secret");
            Stream.of( "a", "e", "o", "s", "c", "r", "g", "t").forEach(emitters[1]::onNext);
            emitters[0].onNext("abba");
            Stream.of("a", "e", "s", "b").forEach(emitters[1]::onNext);
            emitters[0].onComplete();
        };
        final Observable<String> words = Observable.create(
                emitter -> {
                    emitters[0] = emitter;
                    if (emitters[1] != null) {
                        emit.run();
                    }
                });
        final Observable<String> letters = Observable.create(
                emitter -> {
                    emitters[1] = emitter;
                    if (emitters[0] != null) {
                        emit.run();
                    }
                });
        final Observable<Hangman.Output> outputs = Hangman.play(words, letters);

        final List<Hangman.Output> results = new ArrayList<>();
        final Disposable subscription = outputs.filter(output -> output.status != Hangman.Status.PLAYING)
            .subscribe(results::add);
        try {
            assertEquals(2, results.size());

            final Hangman.Output first = results.get(0);
            assertEquals("secret", first.discovered);
            assertEquals(setOf("s", "e", "c", "r", "t"), first.guess);
            assertEquals(setOf("a", "o", "g"), first.misses);
            assertEquals(Hangman.Status.WIN, first.status);

            final Hangman.Output second = results.get(1);
            assertEquals("abba", second.discovered);
            assertEquals(setOf("a", "b"), second.guess);
            assertEquals(setOf("e", "s"), second.misses);
            assertEquals(Hangman.Status.WIN, first.status);
        } finally {
            subscription.dispose();
        }
    }

    private static <T> Set<T> setOf(final T... values) {
        final Set<T> set = new HashSet<>();
        Collections.addAll(set, values);
        return set;
    }
}
