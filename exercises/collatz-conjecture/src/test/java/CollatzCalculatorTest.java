import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> collatzCalculator.computeStepCount(0));

        assertThat(expected)
            .hasMessage("Only natural numbers are allowed");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeIntegerIsConsideredInvalidInput() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> collatzCalculator.computeStepCount(-15));

        assertThat(expected)
            .hasMessage("Only natural numbers are allowed");
    }

}
