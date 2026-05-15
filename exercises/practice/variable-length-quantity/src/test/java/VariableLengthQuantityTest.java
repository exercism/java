import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class VariableLengthQuantityTest {

    private VariableLengthQuantity variableLengthQuantity =
        new VariableLengthQuantity();

    @Test
    @DisplayName("zero")
    public void testZero() {
        List<String> expected = Arrays.asList("0x0");
        List<Long> numbers = Arrays.asList(0x0L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("arbitrary single byte")
    public void testArbitrarySingleByte() {
        List<String> expected = Arrays.asList("0x40");
        List<Long> numbers = Arrays.asList(0x40L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("asymmetric single byte")
    public void testAsymmetricSingleByte() {
        List<String> expected = Arrays.asList("0x53");
        List<Long> numbers = Arrays.asList(0x53L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("largest single byte")
    public void testLargestSingleByte() {
        List<String> expected = Arrays.asList("0x7f");
        List<Long> numbers = Arrays.asList(0x7fL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("smallest double byte")
    public void testSmallestDoubleByte() {
        List<String> expected = Arrays.asList("0x81", "0x0");
        List<Long> numbers = Arrays.asList(0x80L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("arbitrary double byte")
    public void testArbitraryDoubleByte() {
        List<String> expected = Arrays.asList("0xc0", "0x0");
        List<Long> numbers = Arrays.asList(0x2000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("asymmetric double byte")
    public void testAsymmetricDoubleByte() {
        List<String> expected = Arrays.asList("0x81", "0x2d");
        List<Long> numbers = Arrays.asList(0xadL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("largest double byte")
    public void testLargestDoubleByte() {
        List<String> expected = Arrays.asList("0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0x3fffL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("smallest triple byte")
    public void testSmallestTripleByte() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x4000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("arbitrary triple byte")
    public void testArbitraryTripleByte() {
        List<String> expected = Arrays.asList("0xc0", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x100000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("asymmetric triple byte")
    public void testAsymmetricTripleByte() {
        List<String> expected = Arrays.asList("0x87", "0xab", "0x1c");
        List<Long> numbers = Arrays.asList(0x1d59cL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("largest triple byte")
    public void testLargestTripleByte() {
        List<String> expected = Arrays.asList("0xff", "0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0x1fffffL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("smallest quadruple byte")
    public void testSmallestQuadrupleByte() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x200000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("arbitrary quadruple byte")
    public void testArbitraryQuadrupleByte() {
        List<String> expected = Arrays.asList("0xc0", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x8000000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("asymmetric quadruple byte")
    public void testAsymmetricQuadrupleByte() {
        List<String> expected = Arrays.asList("0x81", "0xd5", "0xee", "0x4");
        List<Long> numbers = Arrays.asList(0x357704L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("largest quadruple byte")
    public void testLargestQuadrupleByte() {
        List<String> expected = Arrays.asList("0xff", "0xff", "0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0xfffffffL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("smallest quintuple byte")
    public void testSmallestQuintupleByte() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x10000000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("arbitrary quintuple byte")
    public void testArbitraryQuintupleByte() {
        List<String> expected = Arrays.asList("0x8f", "0xf8", "0x80", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0xff000000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("asymmetric quintuple byte")
    public void testAsymmetricQuintupleByte() {
        List<String> expected = Arrays.asList("0x88", "0xb3", "0x95", "0xc2", "0x5");
        List<Long> numbers = Arrays.asList(0x86656105L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("maximum 32-bit integer input")
    public void testMaximum32BitIntegerInput() {
        List<String> expected = Arrays.asList("0x8f", "0xff", "0xff", "0xff", "0x7f");
        List<Long> numbers = Arrays.asList(0xffffffffL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two single-byte values")
    public void testTwoSingleByteValues() {
        List<String> expected = Arrays.asList("0x40", "0x7f");
        List<Long> numbers = Arrays.asList(0x40L, 0x7fL);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two multi-byte values")
    public void testTwoMultiByteValues() {
        List<String> expected = Arrays.asList("0x81", "0x80", "0x0", "0xc8", "0xe8", "0x56");
        List<Long> numbers = Arrays.asList(0x4000L, 0x123456L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("many multi-byte values")
    public void testManyMultiByteValues() {
        List<String> expected = Arrays.asList("0xc0", "0x0", "0xc8", "0xe8",
                                              "0x56", "0xff", "0xff", "0xff",
                                              "0x7f", "0x0", "0xff", "0x7f",
                                              "0x81", "0x80", "0x0");
        List<Long> numbers = Arrays.asList(0x2000L, 0x123456L, 0xfffffffL,
                                           0x0L, 0x3fffL, 0x4000L);

        assertThat(variableLengthQuantity.encode(numbers)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("one byte")
    public void testDecodeOneByte() {
        List<String> expected = Arrays.asList("0x7f");
        List<Long> bytes = Arrays.asList(0x7fL);

        assertThat(variableLengthQuantity.decode(bytes)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two bytes")
    public void testDecodeTwoBytes() {
        List<String> expected = Arrays.asList("0x2000");
        List<Long> bytes = Arrays.asList(0xc0L, 0x0L);

        assertThat(variableLengthQuantity.decode(bytes)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("three bytes")
    public void testDecodeThreeBytes() {
        List<String> expected = Arrays.asList("0x1fffff");
        List<Long> bytes = Arrays.asList(0xffL, 0xffL, 0x7fL);

        assertThat(variableLengthQuantity.decode(bytes)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("four bytes")
    public void testDecodeFourBytes() {
        List<String> expected = Arrays.asList("0x200000");
        List<Long> bytes = Arrays.asList(0x81L, 0x80L, 0x80L, 0x0L);

        assertThat(variableLengthQuantity.decode(bytes)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("maximum 32-bit integer")
    public void testDecodeMaximum32BitInteger() {
        List<String> expected = Arrays.asList("0xffffffff");
        List<Long> bytes = Arrays.asList(0x8fL, 0xffL, 0xffL, 0xffL, 0x7fL);

        assertThat(variableLengthQuantity.decode(bytes)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("incomplete sequence causes error")
    public void testCannotDecodeIncompleteSequence() {
        List<Long> bytes = Arrays.asList(0xffL);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> variableLengthQuantity.decode(bytes))
                .withMessage("Invalid variable-length quantity encoding");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("incomplete sequence causes error, even if value is zero")
    public void testCannotDecodeIncompleteSequenceEvenIfValueIsZero() {
        List<Long> bytes = Arrays.asList(0x80L);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> variableLengthQuantity.decode(bytes))
                .withMessage("Invalid variable-length quantity encoding");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple values")
    public void testDecodeMultipleBytes() {
        List<String> expected = Arrays.asList("0x2000", "0x123456",
                                              "0xfffffff", "0x0", "0x3fff",
                                              "0x4000");
        List<Long> bytes = Arrays.asList(0xc0L, 0x0L, 0xc8L, 0xe8L, 0x56L,
                                         0xffL, 0xffL, 0xffL, 0x7fL, 0x0L,
                                         0xffL, 0x7fL, 0x81L, 0x80L, 0x0L);

        assertThat(variableLengthQuantity.decode(bytes)).isEqualTo(expected);
    }
}
