import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LuhnTest {

    @Test
    public void checkDigitIsRightMostDigit() {
        Luhn luhn = new Luhn(34567);
        int expectedOutput = 7;

        assertEquals(expectedOutput, luhn.getCheckDigit());
    }

    @Test
    public void addendsDoublesEveryOtherNumberFromRight() {
        Luhn luhn = new Luhn(12121);
        int[] expectedOutput = new int[]{1, 4, 1, 4, 1};

        assertArrayEquals(expectedOutput, luhn.getAddends());
    }

    @Test
    public void addendsSubtracts9WhenDoubledNumberIsMoreThan9() {
        Luhn luhn = new Luhn(8631);
        int[] expectedOutput = new int[]{7, 6, 6, 1};

        assertArrayEquals(expectedOutput, luhn.getAddends());
    }

    @Test
    public void checkSumAddsAddendsTogether1() {
        Luhn luhn = new Luhn(4913);
        int expectedOutput = 22;

        assertEquals(expectedOutput, luhn.getCheckSum());
    }

    @Test
    public void checkSumAddsAddendsTogether2() {
        Luhn luhn = new Luhn(201773);
        int expectedOutput = 21;

        assertEquals(expectedOutput, luhn.getCheckSum());
    }

    @Test
    public void numberIsValidWhenChecksumMod10IsZero1() {
        Luhn luhn = new Luhn(738);
        boolean expectedOutput = false;

        assertEquals(expectedOutput, luhn.isValid());
    }

    @Test
    public void numberIsValidWhenChecksumMod10IsZero2() {
        Luhn luhn = new Luhn(8739567);
        boolean expectedOutput = true;

        assertEquals(expectedOutput, luhn.isValid());
    }

    @Test
    public void luhnCanCreateSimpleNumbersWithValidCheckDigit() {
        long expectedOutput = 1230;

        assertEquals(expectedOutput, Luhn.create(123));
    }

    @Test
    public void luhnCanCreateLargeNumbersWithValidCheckDigit() {
        long expectedOutput = 8739567;

        assertEquals(expectedOutput, Luhn.create(873956));
    }

    @Test
    public void luhnCanCreateHugeNumbersWithValidCheckDigit() {
        long expectedOutput = 8372637564L;

        assertEquals(expectedOutput, Luhn.create(837263756));
    }
}
