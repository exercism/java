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
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        int[] expectedDigits = new int[]{1};
        int[] actualDigits = baseConverter.convertToBase(10);

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
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1});

        int[] expectedDigits = new int[]{5};
        int[] actualDigits = baseConverter.convertToBase(10);

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
        BaseConverter baseConverter = new BaseConverter(10, new int[]{5});

        int[] expectedDigits = new int[]{1, 0, 1};
        int[] actualDigits = baseConverter.convertToBase(2);

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
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        int[] expectedDigits = new int[]{4, 2};
        int[] actualDigits = baseConverter.convertToBase(10);

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
        BaseConverter baseConverter = new BaseConverter(10, new int[]{4, 2});

        int[] expectedDigits = new int[]{1, 0, 1, 0, 1, 0};
        int[] actualDigits = baseConverter.convertToBase(2);

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
        BaseConverter baseConverter = new BaseConverter(3, new int[]{1, 1, 2, 0});

        int[] expectedDigits = new int[]{2, 10};
        int[] actualDigits = baseConverter.convertToBase(16);

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
        BaseConverter baseConverter = new BaseConverter(16, new int[]{2, 10});

        int[] expectedDigits = new int[]{1, 1, 2, 0};
        int[] actualDigits = baseConverter.convertToBase(3);

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
        BaseConverter baseConverter = new BaseConverter(97, new int[]{3, 46, 60});

        int[] expectedDigits = new int[]{6, 10, 45};
        int[] actualDigits = baseConverter.convertToBase(73);

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
        BaseConverter baseConverter = new BaseConverter(2, new int[]{});

        int[] expectedDigits = new int[]{0};
        int[] actualDigits = baseConverter.convertToBase(10);

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
    public void testSingleZero() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{0});

        int[] expectedDigits = new int[]{0};
        int[] actualDigits = baseConverter.convertToBase(2);

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
        BaseConverter baseConverter = new BaseConverter(10, new int[]{0, 0, 0});

        int[] expectedDigits = new int[]{0};
        int[] actualDigits = baseConverter.convertToBase(2);

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
    public void testLeadingZeros() {
        BaseConverter baseConverter = new BaseConverter(7, new int[]{0, 6, 0});

        int[] expectedDigits = new int[]{4, 2};
        int[] actualDigits = baseConverter.convertToBase(10);

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
    public void testFirstBaseIsOne() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        new BaseConverter(1, new int[]{1});
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
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        baseConverter.convertToBase(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsZero() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{7});

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        baseConverter.convertToBase(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondBaseIsNegative() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Bases must be at least 2.");

        baseConverter.convertToBase(-7);
    }

}
