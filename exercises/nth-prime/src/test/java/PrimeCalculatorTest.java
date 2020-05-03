import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class PrimeCalculatorTest {

    private PrimeCalculator primeCalculator = new PrimeCalculator();

    @Test
    public void testFirstPrime() {
        assertThat(primeCalculator.nth(1)).isEqualTo(2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondPrime() {
        assertThat(primeCalculator.nth(2)).isEqualTo(3);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSixthPrime() {
        assertThat(primeCalculator.nth(6)).isEqualTo(13);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBigPrime() {
        assertThat(primeCalculator.nth(10001)).isEqualTo(104743);
    }

    @Ignore("Remove to run test")
    @Test
    public void testUndefinedPrime() {
        assertThrows(
            IllegalArgumentException.class,
            () -> primeCalculator.nth(0));
    }

}
