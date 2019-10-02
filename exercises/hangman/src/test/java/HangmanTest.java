import io.reactivex.Observable;
import org.junit.Assert;
import org.junit.Test;

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
    }

    @Test
    public void failure() {
        assertEquals(true, false);
    }

}
