import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimeCalculatorTest {

    private PrimeCalculator primeCalculator = new PrimeCalculator();

    @Test
    @DisplayName("first prime")
    public void testFirstPrime() {
        assertThat(primeCalculator.nth(1)).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("second prime")
    public void testSecondPrime() {
        assertThat(primeCalculator.nth(2)).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sixth prime")
    public void testSixthPrime() {
        assertThat(primeCalculator.nth(6)).isEqualTo(13);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("big prime")
    public void testBigPrime() {
        assertThat(primeCalculator.nth(10001)).isEqualTo(104743);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("there is no zeroth prime")
    public void testUndefinedPrime() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> primeCalculator.nth(0));
    }

}
