import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BaseConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSingleBitOneToDecimal() {
        final BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        final int[] expectedDigits = new int[]{1};
        final int[] actualDigits = baseConverter.convertToBase(10);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinaryToSingleDecimal() {
        final BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1});

        final int[] expectedDigits = new int[]{5};
        final int[] actualDigits = baseConverter.convertToBase(10);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleDecimalToBinary() {
        final BaseConverter baseConverter = new BaseConverter(10, new int[]{5});

        final int[] expectedDigits = new int[]{1, 0, 1};
        final int[] actualDigits = baseConverter.convertToBase(2);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinaryToMultipleDecimal() {
        final BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        final int[] expectedDigits = new int[]{4, 2};
        final int[] actualDigits = baseConverter.convertToBase(10);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecimalToBinary() {
        final BaseConverter baseConverter = new BaseConverter(10, new int[]{4, 2});

        final int[] expectedDigits = new int[]{1, 0, 1, 0, 1, 0};
        final int[] actualDigits = baseConverter.convertToBase(2);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTrinaryToHexadecimal() {
        final BaseConverter baseConverter = new BaseConverter(3, new int[]{1, 1, 2, 0});

        final int[] expectedDigits = new int[]{2, 10};
        final int[] actualDigits = baseConverter.convertToBase(16);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testHexadecimalToTrinary() {
        final BaseConverter baseConverter = new BaseConverter(16, new int[]{2, 10});

        final int[] expectedDigits = new int[]{1, 1, 2, 0};
        final int[] actualDigits = baseConverter.convertToBase(3);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void test15BitInteger() {
        final BaseConverter baseConverter = new BaseConverter(97, new int[]{3, 46, 60});

        final int[] expectedDigits = new int[]{6, 10, 45};
        final int[] actualDigits = baseConverter.convertToBase(73);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testEmptyDigits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply at least one digit.");

        new BaseConverter(2, new int[]{});
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleZero() {
        final BaseConverter baseConverter = new BaseConverter(10, new int[]{0});

        final int[] expectedDigits = new int[]{0};
        final int[] actualDigits = baseConverter.convertToBase(2);

        assertArrayEquals(
                String.format(
                        "Expected digits: %s but found digits: %s",
                        Arrays.toString(expectedDigits),
                        Arrays.toString(actualDigits)),
                expectedDigits,
                actualDigits);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultipleZeros() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Digits may not contain leading zeros.");

        new BaseConverter(10, new int[]{0, 0, 0});
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeadingZeros() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Digits may not contain leading zeros.");

        new BaseConverter(7, new int[]{0, 6, 0});
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstBaseIsOne() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        new BaseConverter(1, new int[]{});
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstBaseIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        new BaseConverter(0, new int[]{});
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstBaseIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        new BaseConverter(-2, new int[]{});
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativeDigit() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Digits may not be negative.");

        new BaseConverter(2, new int[]{1, -1, 1, 0, 1, 0});
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidPositiveDigit() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("All digits must be strictly less than the base.");

        new BaseConverter(2, new int[]{1, 2, 1, 0, 1, 0});
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsOne() {
        final BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        baseConverter.convertToBase(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsZero() {
        final BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        baseConverter.convertToBase(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsNegative() {
        final BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        baseConverter.convertToBase(-7);
    }

}
