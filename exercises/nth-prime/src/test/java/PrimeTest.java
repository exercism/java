import org.junit.Test;
import org.junit.Ignore;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PrimeTest {

    @Test
    public void testFirstPrime() {
        assertThat(Prime.nth(1), is(2));
    }

    @Ignore
    @Test
    public void testSecondPrime() {
        assertThat(Prime.nth(2), is(3));
    }

    @Ignore
    @Test
    public void testSixthPrime() {
        assertThat(Prime.nth(6), is(13));
    }

    @Ignore
    @Test
    public void testBigPrime() {
        assertThat(Prime.nth(10001), is(104743));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testUndefinedPrime() {
        Prime.nth(0);
    }
}
