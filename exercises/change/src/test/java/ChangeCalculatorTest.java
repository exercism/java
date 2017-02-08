import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public final class ChangeCalculatorTest {

    /*
     * See https://github.com/junit-team/junit4/wiki/Rules for information on JUnit Rules in general and
     * ExpectedExceptions in particular.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testChangeThatCanBeGivenInASingleCoin() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertEquals(
                singletonList(25),
                changeCalculator.computeMostEfficientChange(25));
    }

    @Ignore
    @Test
    public void testChangeThatMustBeGivenInMultipleCoins() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 25, 100));

        assertEquals(
                asList(5, 10),
                changeCalculator.computeMostEfficientChange(15));
    }

    @Ignore
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testLilliputianCurrencyForWhichGreedyAlgorithmFails() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 4, 15, 20, 50));

        assertEquals(
                asList(4, 4, 15),
                changeCalculator.computeMostEfficientChange(23));
    }

    @Ignore
    @Test
    // https://en.wikipedia.org/wiki/Change-making_problem#Greedy_method
    public void testLowerElbonianCurrencyForWhichGreedyAlgorithmFails() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertEquals(
                asList(21, 21, 21),
                changeCalculator.computeMostEfficientChange(63));
    }

    @Ignore
    @Test
    public void testLargeAmountOfChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5, 10, 20, 50, 100));

        assertEquals(
                asList(2, 2, 5, 20, 20, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100),
                changeCalculator.computeMostEfficientChange(999));
    }

    @Ignore
    @Test
    public void testZeroChange() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 5, 10, 21, 25));

        assertEquals(
                emptyList(),
                changeCalculator.computeMostEfficientChange(0));
    }

    @Ignore
    @Test
    public void testChangeLessThanSmallestCoinInCurrencyCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The total 3 cannot be represented in the given currency.");

        changeCalculator.computeMostEfficientChange(3);
    }

    @Ignore
    @Test
    public void testChangeLargerThanAllCoinsInCurrencyThatCannotBeRepresented() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(5, 10));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The total 94 cannot be represented in the given currency.");

        changeCalculator.computeMostEfficientChange(94);
    }

    @Ignore
    @Test
    public void testNegativeChangeIsRejected() {
        ChangeCalculator changeCalculator = new ChangeCalculator(asList(1, 2, 5));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negative totals are not allowed.");

        changeCalculator.computeMostEfficientChange(-5);
    }

}
