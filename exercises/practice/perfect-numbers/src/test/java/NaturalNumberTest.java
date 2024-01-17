import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NaturalNumberTest {

    @Test
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(6).getClassification()).isEqualTo(Classification.PERFECT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(28).getClassification()).isEqualTo(Classification.PERFECT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(33550336).getClassification()).isEqualTo(Classification.PERFECT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(12).getClassification()).isEqualTo(Classification.ABUNDANT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(30).getClassification()).isEqualTo(Classification.ABUNDANT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(33550335).getClassification()).isEqualTo(Classification.ABUNDANT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(2).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(4).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(32).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        assertThat(new NaturalNumber(33550337).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    /*
     * The number 1 has no proper divisors (https://en.wikipedia.org/wiki/Divisor#Further_notions_and_facts), and the
     * additive identity is 0, so the aliquot sum of 1 should be 0. Hence 1 should be classified as deficient.
     */
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        assertThat(new NaturalNumber(1).getClassification()).isEqualTo(Classification.DEFICIENT);
    }

    @Disabled("Remove to run test")
    @Test
    public void testThatNonNegativeIntegerIsRejected() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new NaturalNumber(0))
            .withMessage("You must supply a natural number (positive integer)");
    }

    @Disabled("Remove to run test")
    @Test
    public void testThatNegativeIntegerIsRejected() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new NaturalNumber(-1))
            .withMessage("You must supply a natural number (positive integer)");
    }

}
