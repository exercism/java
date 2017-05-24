import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * version: 1.1.0
 */
public class DifferenceOfSquaresCalculatorTest {

    private DifferenceOfSquaresCalculator calculator;

    @Before
    public void setUp() {
        calculator = new DifferenceOfSquaresCalculator();
    }

    @Test
    public void testSquareOfSum1() {
        final int expected = 1;
        final int actual = calculator.computeSquareOfSumTo(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSum5() {
        final int expected = 225;
        final int actual = calculator.computeSquareOfSumTo(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSum100() {
        final int expected = 25502500;
        final int actual = calculator.computeSquareOfSumTo(100);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquares1() {
        final int expected = 1;
        final int actual = calculator.computeSumOfSquaresTo(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquares5() {
        final int expected = 55;
        final int actual = calculator.computeSumOfSquaresTo(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquares100() {
        final int expected = 338350;
        final int actual = calculator.computeSumOfSquaresTo(100);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquares1() {
        final int expected = 0;
        final int actual = calculator.computeDifferenceOfSquares(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquares5() {
        final int expected = 170;
        final int actual = calculator.computeDifferenceOfSquares(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquares100() {
        final int expected = 25164150;
        final int actual = calculator.computeDifferenceOfSquares(100);
        assertEquals(expected, actual);
    }

}
