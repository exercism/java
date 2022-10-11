import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class CollatzCalculatorTest {

    private CollatzCalculator collatzCalculator = new CollatzCalculator();

    @Test
    public void testZeroStepsRequiredWhenStartingFrom1() {
        assertEquals(0, collatzCalculator.computeStepCount(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectNumberOfStepsWhenAllStepsAreDivisions() {
        assertEquals(4, collatzCalculator.computeStepCount(16));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectNumberOfStepsWhenBothStepTypesAreNeeded() {
        assertEquals(9, collatzCalculator.computeStepCount(12));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAVeryLargeInput() {
        assertEquals(152, collatzCalculator.computeStepCount(1000000));
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
