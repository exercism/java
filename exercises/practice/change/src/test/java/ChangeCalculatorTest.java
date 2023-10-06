import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class ChangeCalculatorTest {

    @Test
    public void testChangeThatCanBeGivenInASingleCoin() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertThat(changeCalculator.computeMostEfficientChange(25)).isEqualTo(singletonList(25));
    }

    @Ignore("Remove to run test")
    @Test
    public void testChangeThatMustBeGivenInMultipleCoins() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertThat(changeCalculator.computeMostEfficientChange(15)).isEqualTo(asList(5, 10));
    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testLilliputianCurrency() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 4, 15, 20, 50));

        assertThat(changeCalculator.computeMostEfficientChange(23)).isEqualTo(asList(4, 4, 15));

    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testLowerElbonianCurrency() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertThat(changeCalculator.computeMostEfficientChange(63)).isEqualTo(asList(21, 21, 21));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeAmountOfChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5, 10, 20, 50, 100));

        assertThat(changeCalculator.computeMostEfficientChange(999))
                .isEqualTo(asList(2, 2, 5, 20, 20, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100));
    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testPossibleChangeWithoutUnitCoinAvailable() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(2, 5, 10, 20, 50));

        assertThat(changeCalculator.computeMostEfficientChange(21)).isEqualTo(asList(2, 2, 2, 5, 10));
    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testAnotherPossibleChangeWithoutUnitCoinAvailable() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(4, 5));

        assertThat(changeCalculator.computeMostEfficientChange(27)).isEqualTo(asList(4, 4, 4, 5, 5, 5));
    }

    @Ignore("Remove to run test")
    @Test
    public void testZeroChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertThat(changeCalculator.computeMostEfficientChange(0)).isEqualTo(emptyList());
    }

    @Ignore("Remove to run test")
    @Test
    public void testChangeLessThanSmallestCoinInCurrencyCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> changeCalculator.computeMostEfficientChange(3))
                .withMessage("The total 3 cannot be represented in the given currency.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testChangeLargerThanAllCoinsInCurrencyThatCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> changeCalculator.computeMostEfficientChange(94))
                .withMessage("The total 94 cannot be represented in the given currency.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeChangeIsRejected() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> changeCalculator.computeMostEfficientChange(-5))
                .withMessage("Negative totals are not allowed.");
    }

}
