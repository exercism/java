import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class BaseConverterTest {

    @Test
    public void testSingleBitOneToDecimal() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinaryToSingleDecimal() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(5);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleDecimalToBinary() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{5});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(1, 0, 1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinaryToMultipleDecimal() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(4, 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecimalToBinary() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{4, 2});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(1, 0, 1, 0, 1, 0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTrinaryToHexadecimal() {
        BaseConverter baseConverter = new BaseConverter(3, new int[]{1, 1, 2, 0});

        assertThat(baseConverter.convertToBase(16))
                .containsExactly(2, 10);
    }

    @Ignore("Remove to run test")
    @Test
    public void testHexadecimalToTrinary() {
        BaseConverter baseConverter = new BaseConverter(16, new int[]{2, 10});

        assertThat(baseConverter.convertToBase(3))
                .containsExactly(1, 1, 2, 0);
    }

    @Ignore("Remove to run test")
    @Test
    public void test15BitInteger() {
        BaseConverter baseConverter = new BaseConverter(97, new int[]{3, 46, 60});

        assertThat(baseConverter.convertToBase(73))
                .containsExactly(6, 10, 45);
    }

    @Ignore("Remove to run test")
    @Test
    public void testEmptyDigits() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleZero() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{0});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultipleZeros() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{0, 0, 0});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeadingZeros() {
        BaseConverter baseConverter = new BaseConverter(7, new int[]{0, 6, 0});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(4, 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstBaseIsOne() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new BaseConverter(1, new int[]{1}));

        assertThat(expected).hasMessage("Bases must be at least 2.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstBaseIsZero() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new BaseConverter(0, new int[]{1}));

        assertThat(expected).hasMessage("Bases must be at least 2.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstBaseIsNegative() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new BaseConverter(-2, new int[]{1}));

        assertThat(expected).hasMessage("Bases must be at least 2.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeDigit() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new BaseConverter(2, new int[]{1, -1, 1, 0, 1, 0}));

        assertThat(expected).hasMessage("Digits may not be negative.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidPositiveDigit() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new BaseConverter(2, new int[]{1, 2, 1, 0, 1, 0}));

        assertThat(expected)
            .hasMessage("All digits must be strictly less than the base.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsOne() {
        BaseConverter baseConverter =
            new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> baseConverter.convertToBase(1));

        assertThat(expected).hasMessage("Bases must be at least 2.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsZero() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{7});

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> baseConverter.convertToBase(0));

        assertThat(expected).hasMessage("Bases must be at least 2.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsNegative() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> baseConverter.convertToBase(-7));

        assertThat(expected).hasMessage("Bases must be at least 2.");
    }

}
