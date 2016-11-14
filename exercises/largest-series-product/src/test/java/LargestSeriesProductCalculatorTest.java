import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public final class LargestSeriesProductCalculatorTest {

    /*
     * See https://github.com/junit-team/junit4/wiki/Rules for information on JUnit Rules in general and
     * ExpectedExceptions in particular.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        final long expectedProduct = 72;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersNotInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("576802143");
        final long expectedProduct = 48;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductWhenSeriesLengthEqualsStringToSearchLength() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("29");
        final long expectedProduct = 18;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        final long expectedProduct = 504;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersNotInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("1027839564");
        final long expectedProduct = 270;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthFiveWithNumbersInOrder() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0123456789");
        final long expectedProduct = 15120;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(5);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductInLongStringToSearchV1() {
        final LargestSeriesProductCalculator calculator
                = new LargestSeriesProductCalculator("73167176531330624919225119674426574742355349194934");

        final long expectedProduct = 23520;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(6);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductInLongStringToSearchV2() {
        final LargestSeriesProductCalculator calculator
                = new LargestSeriesProductCalculator("52677741234314237566414902593461595376319419139427");

        final long expectedProduct = 28350;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(6);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductInLongStringToSearchFromProjectEuler() {
        final LargestSeriesProductCalculator calculator
                = new LargestSeriesProductCalculator("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");

        final long expectedProduct = 23514624000L;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(13);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllDigitsAreZeroes() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("0000");
        final long expectedProduct = 0;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllSeriesOfGivenLengthContainZero() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("99099");
        final long expectedProduct = 0;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testSeriesLengthLongerThanLengthOfStringToTestIsRejected() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("123");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(
                "Series length must be less than or equal to the length of the string to search.");

        calculator.calculateLargestProductForSeriesLength(4);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfLength0ForEmptyStringToSearch() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("");
        final long expectedProduct = 1;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(0);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testCorrectlyCalculatesLargestProductOfLength0ForNonEmptyStringToSearch() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("123");
        final long expectedProduct = 1;

        final long actualProduct = calculator.calculateLargestProductForSeriesLength(0);

        assertEquals(expectedProduct, actualProduct);
    }

    @Ignore
    @Test
    public void testEmptyStringToSearchAndSeriesOfNonZeroLengthIsRejected() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(
                "Series length must be less than or equal to the length of the string to search.");

        calculator.calculateLargestProductForSeriesLength(1);
    }

    @Ignore
    @Test
    public void testStringToSearchContainingNonDigitCharacterIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("String to search may only contains digits.");

        new LargestSeriesProductCalculator("1234a5");
    }

    @Ignore
    @Test
    public void testNegativeSeriesLengthIsRejected() {
        final LargestSeriesProductCalculator calculator = new LargestSeriesProductCalculator("12345");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Series length must be non-negative.");

        calculator.calculateLargestProductForSeriesLength(-1);
    }

    @Ignore
    @Test
    public void testNullStringToSearchIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("String to search must be non-null.");

        new LargestSeriesProductCalculator(null);
    }

}
