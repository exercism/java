import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSumUpToFive() {
        int expected = 225;
        int actual = calculator.computeSquareOfSumTo(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareOfSumUpToHundred() {
        int expected = 25502500;
        int actual = calculator.computeSquareOfSumTo(100);
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquaresUpToOne() {
        int expected = 1;
        int actual = calculator.computeSumOfSquaresTo(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquaresUpToFive() {
        int expected = 55;
        int actual = calculator.computeSumOfSquaresTo(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfSquaresUpToHundred() {
        int expected = 338350;
        int actual = calculator.computeSumOfSquaresTo(100);
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquaresUpToOne() {
        int expected = 0;
        int actual = calculator.computeDifferenceOfSquares(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquaresUpToFive() {
        int expected = 170;
        int actual = calculator.computeDifferenceOfSquares(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDifferenceOfSquaresUpToHundred() {
        int expected = 25164150;
        int actual = calculator.computeDifferenceOfSquares(100);
        assertThat(actual).isEqualTo(expected);
    }

}
