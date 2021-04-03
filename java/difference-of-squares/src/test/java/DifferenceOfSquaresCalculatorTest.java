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
        int expected = 1;
        int actual = calculator.computeSquareOfSumTo(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSquareOfSumUpToFive() {
        int expected = 225;
        int actual = calculator.computeSquareOfSumTo(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testSquareOfSumUpToHundred() {
        int expected = 25502500;
        int actual = calculator.computeSquareOfSumTo(100);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumOfSquaresUpToOne() {
        int expected = 1;
        int actual = calculator.computeSumOfSquaresTo(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumOfSquaresUpToFive() {
        int expected = 55;
        int actual = calculator.computeSumOfSquaresTo(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumOfSquaresUpToHundred() {
        int expected = 338350;
        int actual = calculator.computeSumOfSquaresTo(100);
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceOfSquaresUpToOne() {
        int expected = 0;
        int actual = calculator.computeDifferenceOfSquares(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceOfSquaresUpToFive() {
        int expected = 170;
        int actual = calculator.computeDifferenceOfSquares(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceOfSquaresUpToHundred() {
        int expected = 25164150;
        int actual = calculator.computeDifferenceOfSquares(100);
        assertEquals(expected, actual);
    }

}
