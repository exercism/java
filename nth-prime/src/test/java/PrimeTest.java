import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeTest {
    @Test
    public void testFirstPrime() {
        assertThat(Prime.nth(1)).isEqualTo(2);
    }

    @Test
    public void testSecondPrime() {
        assertThat(Prime.nth(2)).isEqualTo(3);
    }

    @Test
    public void testSixthPrime() {
        assertThat(Prime.nth(6)).isEqualTo(13);
    }

    @Test
    public void testBigPrime() {
        assertThat(Prime.nth(10001)).isEqualTo(104743);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUndefinedPrime() {
        Prime.nth(0);
    }
}
