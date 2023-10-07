import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsCalculatorTest {

    private PrimeFactorsCalculator primeFactorsCalculator;

    @Before
    public void setUp() {
        primeFactorsCalculator = new PrimeFactorsCalculator();
    }

    @Test
    public void testNoFactors() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(1L)).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testPrimeNumber() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(2L)).containsExactly(2L);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfAPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(9L)).containsExactly(3L, 3L);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCubeOfAPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(8L)).containsExactly(2L, 2L, 2L);
    }

    @Ignore("Remove to run test")
    @Test
    public void testProductOfPrimesAndNonPrimes() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(12L)).containsExactly(2L, 2L, 3L);
    }

    @Ignore("Remove to run test")
    @Test
    public void testProductOfPrimes() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(901255L)).containsExactly(5L, 17L, 23L, 461L);
    }

    @Ignore("Remove to run test")
    @Test
    public void testFactorsIncludingALargePrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(93819012551L)).containsExactly(11L, 9539L, 894119L);
    }

}
