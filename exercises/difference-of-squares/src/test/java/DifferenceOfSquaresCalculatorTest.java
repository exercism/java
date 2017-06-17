import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * version: 1.1.0, plus tests that exercise double return values
 */
public class DifferenceOfSquaresCalculatorTest {

    // This is sufficient accuracy since we're expecting doubles that represent integer values.
    private static final double EQUALITY_TOLERANCE = 0.1;

    private DifferenceOfSquaresCalculator calculator;

    @Before
    public void setUp() {
        calculator = new DifferenceOfSquaresCalculator();
    }

    @Test
    public void testSquareOfSum1() {
        final double expected = 1;
        final double actual = calculator.computeSquareOfSumTo(1);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSum5() {
        final double expected = 225;
        final double actual = calculator.computeSquareOfSumTo(5);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSum100() {
        final double expected = 25502500;
        final double actual = calculator.computeSquareOfSumTo(100);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSum2000() {
        final double expected = 4004001000000d;
        final double actual = calculator.computeSquareOfSumTo(2000);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquares1() {
        final double expected = 1;
        final double actual = calculator.computeSumOfSquaresTo(1);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquares5() {
        final double expected = 55;
        final double actual = calculator.computeSumOfSquaresTo(5);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquares100() {
        final double expected = 338350;
        final double actual = calculator.computeSumOfSquaresTo(100);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquares2000() {
        final double expected = 2668667000d;
        final double actual = calculator.computeSumOfSquaresTo(2000);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquares1() {
        final double expected = 0;
        final double actual = calculator.computeDifferenceOfSquares(1);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquares5() {
        final double expected = 170;
        final double actual = calculator.computeDifferenceOfSquares(5);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquares2000() {
        final double expected = 4001332333000d;
        final double actual = calculator.computeDifferenceOfSquares(2000);
        assertEquals(expected, actual, EQUALITY_TOLERANCE);
    }

}
