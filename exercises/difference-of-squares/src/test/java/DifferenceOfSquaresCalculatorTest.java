import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class DifferenceOfSquaresCalculatorTest {
    private DifferenceOfSquaresCalculator calculator;

    @Before
    public void setUp() {
        calculator = new DifferenceOfSquaresCalculator();
    }

    @Test
    public void testSquareOfSum5() {
        final int expected = 225;
        final int actual = calculator.computeSquareOfSumTo(5);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testSquareOfSum10() {
        final int expected = 3025;
        final int actual = calculator.computeSquareOfSumTo(10);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testSquareOfSum100() {
        final int expected = 25502500;
        final int actual = calculator.computeSquareOfSumTo(100);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testSumOfSquares5() {
        final int expected = 55;
        final int actual = calculator.computeSumOfSquaresTo(5);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testSumOfSquares10() {
        final int expected = 385;
        final int actual = calculator.computeSumOfSquaresTo(10);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testSumOfSquares100() {
        final int expected = 338350;
        final int actual = calculator.computeSumOfSquaresTo(100);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testDifferenceOfSquares0() {
        final int expected = 0;
        final int actual = calculator.computeDifferenceOfSquares(0);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testDifferenceOfSquares5() {
        final int expected = 170;
        final int actual = calculator.computeDifferenceOfSquares(5);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testDifferenceOfSquares10() {
        final int expected = 2640;
        final int actual = calculator.computeDifferenceOfSquares(10);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void testDifferenceOfSquares100() {
        final int expected = 25164150;
        final int actual = calculator.computeDifferenceOfSquares(100);
        assertEquals(expected, actual);
    }

}
