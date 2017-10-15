import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CollatzCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CollatzCalculator collatzCalculator;

    @Before
    public void setUp() {
        collatzCalculator = new CollatzCalculator();
    }

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
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Only natural numbers are allowed");

        collatzCalculator.computeStepCount(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeIntegerIsConsideredInvalidInput() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Only natural numbers are allowed");

        collatzCalculator.computeStepCount(-15);
    }

}
