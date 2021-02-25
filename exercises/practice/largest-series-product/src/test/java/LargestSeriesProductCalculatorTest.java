import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class LargestSeriesProductCalculatorTest {

    @Test
    public void testCorrectlyCalculatesLargestProductWhenSeriesLengthEqualsStringToSearchLength() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("29");
        long expectedProduct = 18;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersInOrder() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        long expectedProduct = 72;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersNotInOrder() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("576802143");
        long expectedProduct = 48;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersInOrder() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        long expectedProduct = 504;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersNotInOrder() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("1027839564");
        long expectedProduct = 270;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthFiveWithNumbersInOrder() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        long expectedProduct = 15120;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(5);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductInLongStringToSearchV1() {
        LargestSeriesProductCalculator calculator
                = new LargestSeriesProductCalculator("73167176531330624919225119674426574742355349194934");

        long expectedProduct = 23520;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(6);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllDigitsAreZeroes() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0000");
        long expectedProduct = 0;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllSeriesOfGivenLengthContainZero() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("99099");
        long expectedProduct = 0;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSeriesLengthLongerThanLengthOfStringToTestIsRejected() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("123");

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateLargestProductForSeriesLength(4));

        assertThat(expected)
            .hasMessage(
                "Series length must be less than or equal to the length of the string to search.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLength0ForEmptyStringToSearch() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("");
        long expectedProduct = 1;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(0);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCorrectlyCalculatesLargestProductOfLength0ForNonEmptyStringToSearch() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("123");
        long expectedProduct = 1;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(0);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore("Remove to run test")
    @Test
    public void testEmptyStringToSearchAndSeriesOfNonZeroLengthIsRejected() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("");

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateLargestProductForSeriesLength(1));

        assertThat(expected)
            .hasMessage(
                "Series length must be less than or equal to the length of the string to search.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testStringToSearchContainingNonDigitCharacterIsRejected() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new LargestSeriesProductCalculator("1234a5"));

        assertThat(expected)
            .hasMessage("String to search may only contain digits.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeSeriesLengthIsRejected() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("12345");

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateLargestProductForSeriesLength(-1));

        assertThat(expected)
            .hasMessage("Series length must be non-negative.");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void testForIntegerOverflow() {
        LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("9999999999");
        long expectedProduct = 3486784401L;

        long actualProduct = calculator.calculateLargestProductForSeriesLength(10);

        assertEquals(expectedProduct, actualProduct);
    }

}
