import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class LargestSeriesProductCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCorrectlyCalculatesLargestProductWhenSeriesLengthEqualsStringToSearchLength() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("29");
        final long expectedProduct = 18;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        final long expectedProduct = 72;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersNotInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("576802143");
        final long expectedProduct = 48;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        final long expectedProduct = 504;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersNotInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("1027839564");
        final long expectedProduct = 270;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthFiveWithNumbersInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        final long expectedProduct = 15120;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(5);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductInLongStringToSearchV1() {
        final LargestSeriesProductCalculator calculator
                = new LargestSeriesProductCalculator("73167176531330624919225119674426574742355349194934");

        final long expectedProduct = 23520;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(6);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllDigitsAreZeroes() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0000");
        final long expectedProduct = 0;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllSeriesOfGivenLengthContainZero() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("99099");
        final long expectedProduct = 0;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSeriesLengthLongerThanLengthOfStringToTestIsRejected() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("123");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(
                "Series length must be less than or equal to the length of the string to search.");

        calculator.calculateLargestProductForSeriesLength(4);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLength0ForEmptyStringToSearch() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("");
        final long expectedProduct = 1;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(0);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLength0ForNonEmptyStringToSearch() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("123");
        final long expectedProduct = 1;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(0);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testEmptyStringToSearchAndSeriesOfNonZeroLengthIsRejected() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(
                "Series length must be less than or equal to the length of the string to search.");

        calculator.calculateLargestProductForSeriesLength(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testStringToSearchContainingNonDigitCharacterIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("String to search may only contain digits.");

        new LargestSeriesProductCalculator("1234a5");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeSeriesLengthIsRejected() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("12345");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Series length must be non-negative.");

        calculator.calculateLargestProductForSeriesLength(-1);
    }

}
