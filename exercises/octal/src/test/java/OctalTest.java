import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class OctalTest {

    @Test
    public void testCovertDecimalOneToOctal() {
        Octal octal = new Octal("1");
        assertEquals(1, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertDecimalTenToOctal() {
        Octal octal = new Octal("10");
        assertEquals(8, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertDecimalSeventeenToOctal() {
        Octal octal = new Octal("17");
        assertEquals(15, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertElevenToOctal() {
        Octal octal = new Octal("11");
        assertEquals(9, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertDecimalElevenWithZeroToOctal() {
        Octal octal = new Octal("011");
        assertEquals(9, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeDigitDecimalToOctal() {
        Octal octal = new Octal("130");
        assertEquals(88, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallFourDigitDecimalToOctal() {
        Octal octal = new Octal("2047");
        assertEquals(1063, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeFourDigitDecimalToOctal() {
        Octal octal = new Octal("7777");
        assertEquals(4095, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSevenDigitDecimalToOctal() {
        Octal octal = new Octal("1234567");
        assertEquals(342391, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidStringFirst() {
        Octal octal = new Octal("carrot");
        assertEquals(0, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidStringSecond() {
        Octal octal = new Octal("abc1z");
        assertEquals(0, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidDecimalEight() {
        Octal octal = new Octal("8");
        assertEquals(0, octal.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidNumberNine() {
        Octal octal = new Octal("9");
        assertEquals(0, octal.getDecimal());
    }

}
