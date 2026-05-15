import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ChangeCalculatorTest {

    @Test
    @DisplayName("change for 1 cent")
    public void testChangeForOneCent() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25));

        assertThat(changeCalculator.computeMostEfficientChange(1))
                .containsExactly(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("single coin change")
    public void testChangeThatCanBeGivenInASingleCoin() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertThat(changeCalculator.computeMostEfficientChange(25))
            .containsExactly(25);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple coin change")
    public void testChangeThatMustBeGivenInMultipleCoins() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertThat(changeCalculator.computeMostEfficientChange(15))
            .containsExactly(5, 10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("change with Lilliputian Coins")
    public void testLilliputianCurrency() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 4, 15, 20, 50));

        assertThat(changeCalculator.computeMostEfficientChange(23))
            .containsExactly(4, 4, 15);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("change with Lower Elbonia Coins")
    public void testLowerElbonianCurrency() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertThat(changeCalculator.computeMostEfficientChange(63))
            .containsExactly(21, 21, 21);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("large target values")
    public void testLargeAmountOfChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5, 10, 20, 50, 100));

        assertThat(changeCalculator.computeMostEfficientChange(999))
            .containsExactly(2, 2, 5, 20, 20, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("possible change without unit coins available")
    public void testPossibleChangeWithoutUnitCoinAvailable() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(2, 5, 10, 20, 50));

        assertThat(changeCalculator.computeMostEfficientChange(21))
            .containsExactly(2, 2, 2, 5, 10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("another possible change without unit coins available")
    public void testAnotherPossibleChangeWithoutUnitCoinAvailable() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(4, 5));

        assertThat(changeCalculator.computeMostEfficientChange(27))
            .containsExactly(4, 4, 4, 5, 5, 5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a greedy approach is not optimal")
    public void testAGreedyApproachIsNotOptimal() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 10, 11));

        assertThat(changeCalculator.computeMostEfficientChange(20))
            .containsExactly(10, 10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no coins make 0 change")
    public void testZeroChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertThat(changeCalculator.computeMostEfficientChange(0))
            .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("error testing for change smaller than the smallest of coins")
    public void testChangeLessThanSmallestCoinInCurrencyCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> changeCalculator.computeMostEfficientChange(3))
                .withMessage("The total 3 cannot be represented in the given currency.");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("error if no combination can add up to target")
    public void testChangeLargerThanAllCoinsInCurrencyThatCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> changeCalculator.computeMostEfficientChange(94))
                .withMessage("The total 94 cannot be represented in the given currency.");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot find negative change values")
    public void testNegativeChangeIsRejected() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> changeCalculator.computeMostEfficientChange(-5))
                .withMessage("Negative totals are not allowed.");
    }

}
