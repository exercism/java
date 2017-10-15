import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DifferenceOfSquaresCalculatorTest {

    private DifferenceOfSquaresCalculator calculator;

    @Before
    public void setUp() {
        calculator = new DifferenceOfSquaresCalculator();
    }

    @Test
    public void testSquareOfSumUpToOne() {
        final int expected = 1;
        final int actual = calculator.computeSquareOfSumTo(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSumUpToFive() {
        final int expected = 225;
        final int actual = calculator.computeSquareOfSumTo(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSumUpToHundred() {
        final int expected = 25502500;
        final int actual = calculator.computeSquareOfSumTo(100);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquaresUpToOne() {
        final int expected = 1;
        final int actual = calculator.computeSumOfSquaresTo(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquaresUpToFive() {
        final int expected = 55;
        final int actual = calculator.computeSumOfSquaresTo(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquaresUpToHundred() {
        final int expected = 338350;
        final int actual = calculator.computeSumOfSquaresTo(100);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquaresUpToOne() {
        final int expected = 0;
        final int actual = calculator.computeDifferenceOfSquares(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquaresUpToFive() {
        final int expected = 170;
        final int actual = calculator.computeDifferenceOfSquares(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquaresUpToHundred() {
        final int expected = 25164150;
        final int actual = calculator.computeDifferenceOfSquares(100);
        assertEquals(expected, actual);
    }

}
