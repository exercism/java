import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferenceOfSquaresCalculatorTest {

    private DifferenceOfSquaresCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new DifferenceOfSquaresCalculator();
    }

    @Test
    @DisplayName("square of sum 1")
    public void testSquareOfSumUpToOne() {
        int expected = 1;
        int actual = calculator.computeSquareOfSumTo(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("square of sum 5")
    public void testSquareOfSumUpToFive() {
        int expected = 225;
        int actual = calculator.computeSquareOfSumTo(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("square of sum 100")
    public void testSquareOfSumUpToHundred() {
        int expected = 25502500;
        int actual = calculator.computeSquareOfSumTo(100);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sum of squares 1")
    public void testSumOfSquaresUpToOne() {
        int expected = 1;
        int actual = calculator.computeSumOfSquaresTo(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sum of squares 5")
    public void testSumOfSquaresUpToFive() {
        int expected = 55;
        int actual = calculator.computeSumOfSquaresTo(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sum of squares 100")
    public void testSumOfSquaresUpToHundred() {
        int expected = 338350;
        int actual = calculator.computeSumOfSquaresTo(100);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference of squares 1")
    public void testDifferenceOfSquaresUpToOne() {
        int expected = 0;
        int actual = calculator.computeDifferenceOfSquares(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference of squares 5")
    public void testDifferenceOfSquaresUpToFive() {
        int expected = 170;
        int actual = calculator.computeDifferenceOfSquares(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference of squares 100")
    public void testDifferenceOfSquaresUpToHundred() {
        int expected = 25164150;
        int actual = calculator.computeDifferenceOfSquares(100);
        assertThat(actual).isEqualTo(expected);
    }

}
