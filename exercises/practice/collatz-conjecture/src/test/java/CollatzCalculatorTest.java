import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CollatzCalculatorTest {

    private CollatzCalculator collatzCalculator = new CollatzCalculator();

    @Test
    public void testZeroStepsRequiredWhenStartingFrom1() {
        assertThat(collatzCalculator.computeStepCount(1)).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectNumberOfStepsWhenAllStepsAreDivisions() {
        assertThat(collatzCalculator.computeStepCount(16)).isEqualTo(4);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectNumberOfStepsWhenBothStepTypesAreNeeded() {
        assertThat(collatzCalculator.computeStepCount(12)).isEqualTo(9);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAVeryLargeInput() {
        assertThat(collatzCalculator.computeStepCount(1000000)).isEqualTo(152);
    }

    @Ignore("Remove to run test")
    @Test
    public void testZeroIsConsideredInvalidInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> collatzCalculator.computeStepCount(0))
                .withMessage("Only natural numbers are allowed");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeIntegerIsConsideredInvalidInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> collatzCalculator.computeStepCount(-15))
                .withMessage("Only natural numbers are allowed");
    }

}
