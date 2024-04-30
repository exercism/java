import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsCalculatorTest {

    private PrimeFactorsCalculator primeFactorsCalculator;

    @BeforeEach
    public void setUp() {
        primeFactorsCalculator = new PrimeFactorsCalculator();
    }

    @Test
    public void testNoFactors() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(1L)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testPrimeNumber() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(2L)).containsExactly(2L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAnotherPrimeNumber() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(3L)).containsExactly(3L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSquareOfAPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(9L)).containsExactly(3L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testProductOfFirstPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(4L)).containsExactly(2L, 2L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCubeOfAPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(8L)).containsExactly(2L, 2L, 2L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testProductOfSecondPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(625L)).containsExactly(5L, 5L, 5L, 5L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testProductOfThirdPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(27L)).containsExactly(3L, 3L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testProductOfFirstAndSecondPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(6L)).containsExactly(2L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testProductOfPrimesAndNonPrimes() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(12L)).containsExactly(2L, 2L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testProductOfPrimes() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(901255L)).containsExactly(5L, 17L, 23L, 461L);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFactorsIncludingALargePrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(93819012551L)).containsExactly(11L, 9539L, 894119L);
    }

}
