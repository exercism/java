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
        assertEquals(setOf("e", "s"), last.guess);
        assertEquals(setOf("a", "o"), last.misses);
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
        assertEquals(setOf("c", "e", "r", "s", "t"), last.guess);
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
        assertEquals(setOf("a", "b", "d", "f", "g", "h"), last.misses);
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
        ObservableEmitter<String>[] emitters = new ObservableEmitter[2];
        Runnable emit = () -> {
            emitters[0].onNext("secret");
            Stream.of("a", "e", "o", "s", "c", "r", "g", "t").forEach(emitters[1]::onNext);
            emitters[0].onNext("abba");
            Stream.of("a", "e", "s", "b").forEach(emitters[1]::onNext);
            emitters[0].onComplete();
        };
        Observable<String> words = Observable.create(
            emitter -> {
                emitters[0] = emitter;
                if (emitters[1] != null) {
                    emit.run();
                }
            });
        Observable<String> letters = Observable.create(
            emitter -> {
                emitters[1] = emitter;
                if (emitters[0] != null) {
                    emit.run();
                }
            });
        Observable<Output> outputs = hangman.play(words, letters);

        List<Output> results = new ArrayList<>();
        Disposable subscription = outputs.filter(output -> output.status != Status.PLAYING)
            .subscribe(results::add);
        try {
            assertEquals(2, results.size());

            Output first = results.get(0);
            assertEquals("secret", first.discovered);
            assertEquals(setOf("s", "e", "c", "r", "t"), first.guess);
            assertEquals(setOf("a", "o", "g"), first.misses);
            assertEquals(Status.WIN, first.status);

            Output second = results.get(1);
            assertEquals("abba", second.discovered);
            assertEquals(setOf("a", "b"), second.guess);
            assertEquals(setOf("e", "s"), second.misses);
            assertEquals(Status.WIN, first.status);
        } finally {
            subscription.dispose();
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotPlayAGuessTwice() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("e", "c", "s", "c"));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Letter c was already played");
        result.blockingLast();
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotPlayAMissTwice() {
        Observable<Output> result = hangman.play(
            Observable.fromArray("secret"),
            Observable.fromArray("e", "a", "s", "a"));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Letter a was already played");
        result.blockingLast();
    }

    private static <T> Set<T> setOf(T... values) {
        Set<T> set = new HashSet<>();
        Collections.addAll(set, values);
        return set;
    }
}
