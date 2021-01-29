import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import org.junit.Ignore;
import org.junit.Test;

public class ChangeCalculatorTest {

    @Test
    public void testChangeThatCanBeGivenInASingleCoin() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertEquals(
                singletonList(25),
                changeCalculator.computeMostEfficientChange(25));
    }

    @Ignore("Remove to run test")
    @Test
    public void testChangeThatMustBeGivenInMultipleCoins() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertEquals(
                asList(5, 10),
                changeCalculator.computeMostEfficientChange(15));
    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testLilliputianCurrency() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 4, 15, 20, 50));

        assertEquals(
                asList(4, 4, 15),
                changeCalculator.computeMostEfficientChange(23));
    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testLowerElbonianCurrency() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertEquals(
                asList(21, 21, 21),
                changeCalculator.computeMostEfficientChange(63));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeAmountOfChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5, 10, 20, 50, 100));

        assertEquals(
                asList(2, 2, 5, 20, 20, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100),
                changeCalculator.computeMostEfficientChange(999));
    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testPossibleChangeWithoutUnitCoinAvailable() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(2, 5, 10, 20, 50));

        assertEquals(
                asList(2, 2, 2, 5, 10),
                changeCalculator.computeMostEfficientChange(21));
    }

    @Ignore("Remove to run test")
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testAnotherPossibleChangeWithoutUnitCoinAvailable() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(4, 5));

        assertEquals(
                asList(4, 4, 4, 5, 5, 5),
                changeCalculator.computeMostEfficientChange(27));
    }

    @Ignore("Remove to run test")
    @Test
    public void testZeroChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertEquals(
                emptyList(),
                changeCalculator.computeMostEfficientChange(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testChangeLessThanSmallestCoinInCurrencyCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> changeCalculator.computeMostEfficientChange(3));

        assertThat(expected)
            .hasMessage("The total 3 cannot be represented in the given currency.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testChangeLargerThanAllCoinsInCurrencyThatCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> changeCalculator.computeMostEfficientChange(94));

        assertThat(expected)
            .hasMessage("The total 94 cannot be represented in the given currency.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeChangeIsRejected() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5));

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> changeCalculator.computeMostEfficientChange(-5));

        assertThat(expected)
            .hasMessage("Negative totals are not allowed.");
    }

}
