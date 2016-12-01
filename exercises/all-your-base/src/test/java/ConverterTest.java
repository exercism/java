
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConverterTest {

    /*
     * See https://github.com/junit-team/junit4/wiki/Rules for information on JUnit Rules in general and
     * ExpectedExceptions in particular.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

     @Test
    public void singleBitOneToDecimal() {
        final List<Integer> inputDigits = Collections.unmodifiableList(Arrays.asList(1));
        final List<Integer> expected = Collections.unmodifiableList(Arrays.asList(1));
        final List<Integer> actual = Converter.convert(inputDigits, 2, 10);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void binaryToSingleDecimal() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1, 0, 1));
        final List<Integer> expected = Collections.unmodifiableList(Arrays.asList(5));
        final List<Integer> actual = Converter.convert(inputDigits, 2, 10);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void singleDecimalToBinary() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(5));
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(1, 0, 1));
        final List<Integer> actual = Converter.convert(inputDigits, 10, 2);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void binaryToMultipleDecimal() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1, 0, 1, 0, 1, 0));
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(4, 2));
        final List<Integer> actual = Converter.convert(inputDigits, 2, 10);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void decimalToBinary() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(4, 2));
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(1, 0, 1, 0, 1, 0));
        final List<Integer> actual = Converter.convert(inputDigits, 10, 2);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void trinaryToHexadecimal() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1, 1, 2, 0));
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(2, 10));
        final List<Integer> actual = Converter.convert(inputDigits, 3, 16);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void hexadecimalToTrinary() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(2, 10));
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(1, 1, 2, 0));
        final List<Integer> actual = Converter.convert(inputDigits, 16, 3);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void fifteenBitInteger() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(3, 46, 60));
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(6, 10, 45));
        final List<Integer> actual = Converter.convert(inputDigits, 97, 73);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void emptyList() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(new ArrayList<Integer>(0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_LIST_EMPTY);
        Converter.convert(inputDigits, 2, 10);
    }

    // @Test
    public void singleZero() {
        final List<Integer> inputDigits = Collections.unmodifiableList(Arrays.asList(0));
        final List<Integer> expected = Collections.unmodifiableList(Arrays.asList(0));
        final List<Integer> actual = Converter.convert(inputDigits, 10, 2);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    // @Test
    public void multipleZeros() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(0, 0, 0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_LIST_LEADING_ZEROES);
        Converter.convert(inputDigits, 10, 2);
    }

    // @Test
    public void leadingZeros() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(0, 6, 0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_LIST_LEADING_ZEROES);
        Converter.convert(inputDigits, 7, 10);
    }

    // @Test
    public void negativeDigit() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1, -1, 1, 0, 1, 0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_LIST_WRONG_DIGITS);
        Converter.convert(inputDigits, 2, 10);
    }

    // @Test
    public void invalidPositiveDigit() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1, 2, 1, 0, 1, 0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_LIST_WRONG_DIGITS);
        Converter.convert(inputDigits, 2, 10);
    }

    // @Test
    public void firstBaseIsOne() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(new ArrayList<Integer>(0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_INPUT_BASE);
        Converter.convert(inputDigits, 1, 10);
    }

    // @Test
    public void secondBaseIsOne() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1, 0, 1, 0, 1, 0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_OUTPUT_BASE);
        Converter.convert(inputDigits, 2, 1);
    }

    // @Test
    public void firstBaseIsZero() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(new ArrayList<Integer>(0));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_INPUT_BASE);
        Converter.convert(inputDigits, 0, 10);
    }

    // @Test
    public void secondBaseIsZero() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(7));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_OUTPUT_BASE);
        Converter.convert(inputDigits, 10, 0);
    }

    // @Test
    public void firstBaseIsNegative() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_INPUT_BASE);
        Converter.convert(inputDigits, -2, 10);
    }

    // @Test
    public void secondBaseIsNegative() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_OUTPUT_BASE);
        Converter.convert(inputDigits, 2, -7);
    }

    // @Test
    public void bothBasesAreNegative() {
        final List<Integer> inputDigits
                = Collections.unmodifiableList(Arrays.asList(1));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Converter.ERROR_INPUT_BASE);
        Converter.convert(inputDigits, -2, -7);
    }
}
