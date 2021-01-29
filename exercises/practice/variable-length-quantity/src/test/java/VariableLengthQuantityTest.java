import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class VariableLengthQuantityTest {

    private VariableLengthQuantity variableLengthQuantity =
        new VariableLengthQuantity();

    @Test
    public void testZero() {
        List<String> expected = Arrays.asList("0x0");
        List<Long> numbers = Arrays.asList(0x0L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testArbitrarySingleByte() {
        List<String> expected = Arrays.asList("0x40");
        List<Long> numbers = Arrays.asList(0x40L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargestSingleByte() {
        List<String> expected = Arrays.asList("0x7f");
        List<Long> numbers = Arrays.asList(0x7fL);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestDoubleByte() {
        List<String> expected = Arrays.asList("0x81", "0x0");
        List<Long> numbers = Arrays.asList(0x80L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testArbitraryDoubleByte() {
        List<String> expected = Arrays.asList("0xc0", "0x0");
        List<Long> numbers = Arrays.asList(0x2000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargestDoubleByte() {
        List<String> expected = Arrays.asList("0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0x3fffL);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestTripleByte() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x4000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testArbitraryTripleByte() {
        List<String> expected = Arrays.asList("0xc0", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x100000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargestTripleByte() {
        List<String> expected = Arrays.asList("0xff", "0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0x1fffffL);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestQuadrupleByte() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x200000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testArbitraryQuadrupleByte() {
        List<String> expected = Arrays.asList("0xc0", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x8000000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargestQuadrupleByte() {
        List<String> expected = Arrays.asList("0xff", "0xff", "0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0xfffffffL);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestQuintupleByte() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x10000000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testArbitraryQuintupleByte() {
        List<String> expected = Arrays.asList("0x8f", "0xf8", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0xff000000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMaximum32BitIntegerInput() {
        List<String> expected = Arrays.asList("0x8f", "0xff", "0xff", "0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0xffffffffL);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoSingleByteValues() {
        List<String> expected = Arrays.asList("0x40", "0x7f");
        List<Long> numbers = Arrays.asList(0x40L, 0x7fL);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoMultiByteValues() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x0", "0xc8", "0xe8", "0x56");
        List<Long> numbers = Arrays.asList(0x4000L, 0x123456L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testManyMultiByteValues() {
        List<String> expected = Arrays.asList("0xc0", "0x0", "0xc8", "0xe8",
                                              "0x56", "0xff", "0xff", "0xff",
                                              "0x7f", "0x0", "0xff", "0x7f",
                                              "0x81", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x2000L, 0x123456L, 0xfffffffL,
                                           0x0L, 0x3fffL, 0x4000L);

        assertEquals(expected, variableLengthQuantity.encode(numbers));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeOneByte() {
        List<String> expected = Arrays.asList("0x7f");
        List<Long> bytes = Arrays.asList(0x7fL);

        assertEquals(expected, variableLengthQuantity.decode(bytes));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeTwoBytes() {
        List<String> expected = Arrays.asList("0x2000");
        List<Long> bytes = Arrays.asList(0xc0L, 0x0L);

        assertEquals(expected, variableLengthQuantity.decode(bytes));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeThreeBytes() {
        List<String> expected = Arrays.asList("0x1fffff");
        List<Long> bytes = Arrays.asList(0xffL, 0xffL, 0x7fL);

        assertEquals(expected, variableLengthQuantity.decode(bytes));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeFourBytes() {
        List<String> expected = Arrays.asList("0x200000");
        List<Long> bytes = Arrays.asList(0x81L, 0x80L, 0x80L, 0x0L);

        assertEquals(expected, variableLengthQuantity.decode(bytes));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeMaximum32BitInteger() {
        List<String> expected = Arrays.asList("0xffffffff");
        List<Long> bytes = Arrays.asList(0x8fL, 0xffL, 0xffL, 0xffL, 0x7fL);

        assertEquals(expected, variableLengthQuantity.decode(bytes));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCannotDecodeIncompleteSequence() {
        List<Long> bytes = Arrays.asList(0xffL);

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> variableLengthQuantity.decode(bytes));

        assertThat(expected)
            .hasMessage("Invalid variable-length quantity encoding");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCannotDecodeIncompleteSequenceEvenIfValueIsZero() {
        List<Long> bytes = Arrays.asList(0x80L);

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> variableLengthQuantity.decode(bytes));

        assertThat(expected)
            .hasMessage("Invalid variable-length quantity encoding");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeMultipleBytes() {
        List<String> expected = Arrays.asList("0x2000", "0x123456",
                                              "0xfffffff", "0x0", "0x3fff",
                                              "0x4000");
        List<Long> bytes = Arrays.asList(0xc0L, 0x0L, 0xc8L, 0xe8L, 0x56L,
                                         0xffL, 0xffL, 0xffL, 0x7fL, 0x0L,
                                         0xffL, 0x7fL, 0x81L, 0x80L, 0x0L);

        assertEquals(expected, variableLengthQuantity.decode(bytes));
    }
}
