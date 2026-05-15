import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsCalculatorTest {

    private PrimeFactorsCalculator primeFactorsCalculator;

    @BeforeEach
    public void setUp() {
        primeFactorsCalculator = new PrimeFactorsCalculator();
    }

    @Test
    @DisplayName("no factors")
    public void testNoFactors() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(1L)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("prime number")
    public void testPrimeNumber() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(2L)).containsExactly(2L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("another prime number")
    public void testAnotherPrimeNumber() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(3L)).containsExactly(3L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("square of a prime")
    public void testSquareOfAPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(9L)).containsExactly(3L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("product of first prime")
    public void testProductOfFirstPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(4L)).containsExactly(2L, 2L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cube of a prime")
    public void testCubeOfAPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(8L)).containsExactly(2L, 2L, 2L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("product of second prime")
    public void testProductOfSecondPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(625L)).containsExactly(5L, 5L, 5L, 5L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("product of third prime")
    public void testProductOfThirdPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(27L)).containsExactly(3L, 3L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("product of first and second prime")
    public void testProductOfFirstAndSecondPrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(6L)).containsExactly(2L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("product of primes and non-primes")
    public void testProductOfPrimesAndNonPrimes() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(12L)).containsExactly(2L, 2L, 3L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("product of primes")
    public void testProductOfPrimes() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(901255L)).containsExactly(5L, 17L, 23L, 461L);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("factors include a large prime")
    public void testFactorsIncludingALargePrime() {
        assertThat(primeFactorsCalculator.calculatePrimeFactorsOf(93819012551L)).containsExactly(11L, 9539L, 894119L);
    }

}
