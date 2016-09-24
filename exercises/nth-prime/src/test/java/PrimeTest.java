import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeTest {

    @Test
    public void testFirstPrime() {
        assertThat(Prime.nth(1)).isEqualTo(2);
    }

    @Ignore
    @Test
    public void testSecondPrime() {
        assertThat(Prime.nth(2)).isEqualTo(3);
    }

    @Ignore
    @Test
    public void testSixthPrime() {
        assertThat(Prime.nth(6)).isEqualTo(13);
    }

    @Ignore
    @Test
    public void testBigPrime() {
        assertThat(Prime.nth(10001)).isEqualTo(104743);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testUndefinedPrime() {
        Prime.nth(0);
    }
}
