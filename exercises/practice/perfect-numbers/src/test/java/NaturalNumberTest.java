import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NaturalNumberTest {

    @Test
    @DisplayName("Small perfect number (6) is classified as PERFECT")
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(6).getClassification()).isEqualTo(Classification.PERFECT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Medium perfect number (28) is classified as PERFECT")
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(28).getClassification()).isEqualTo(Classification.PERFECT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Large perfect number is classified as PERFECT")
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(33550336).getClassification()).isEqualTo(Classification.PERFECT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Small abundant number is classified as ABUNDANT")
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(12).getClassification()).isEqualTo(Classification.ABUNDANT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Medium abundant number is classified as ABUNDANT")
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(30).getClassification()).isEqualTo(Classification.ABUNDANT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Large abundant number is classified as ABUNDANT")
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(33550335).getClassification()).isEqualTo(Classification.ABUNDANT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Smallest prime number (2) is classified as DEFICIENT")
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(2).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Smallest non-prime deficient number (4) is classified as DEFICIENT")
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(4).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Medium deficient number is classified as DEFICIENT")
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(32).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Large deficient number is classified as DEFICIENT")
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(33550337).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("One is classified as DEFICIENT (no proper divisors)")
    /*
     * The number 1 has no proper divisors (https://en.wikipedia.org/wiki/Divisor#Further_notions_and_facts), and the
     * additive identity is 0, so the aliquot sum of 1 should be 0. Hence 1 should be classified as deficient.
     */
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        assertThat(new NaturalNumber(1).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Zero is rejected as not a natural number")
    public void testThatNonNegativeIntegerIsRejected() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new NaturalNumber(0))
            .withMessage("You must supply a natural number (positive integer)");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Negative integers are rejected")
    public void testThatNegativeIntegerIsRejected() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new NaturalNumber(-1))
            .withMessage("You must supply a natural number (positive integer)");
    }

}
