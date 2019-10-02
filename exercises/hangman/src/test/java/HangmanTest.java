import io.reactivex.Observable;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

class HangmanTest {

    @Test
    public void initialization() {
        final Observable<Hangman.Output> result = Hangman.play(
                Observable.fromArray("secret"),
                Observable.fromArray());
        final Hangman.Output init = result.first(null).blockingGet();
        Assert.assertNotNull(init);
        assertEquals("secret", init.secret);
        assertEquals("______", init.discovered);
        assertEquals(Collections.emptySet(), init.guess);
        assertEquals(Collections.emptySet(), init.misses);
        assertEquals(Collections.emptyList(), init.parts);
        assertEquals(Hangman.Status.PLAYING, init.status);
    }

    @Test
    public void failure() {
        assertEquals(true, false);
    }

}
