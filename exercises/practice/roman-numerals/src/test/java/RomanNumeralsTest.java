import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {

    private RomanNumeral romanNumeral;

    @Test
    public void test1ToRomanNumberI() {
        romanNumeral = new RomanNumeral(1);
        assertEquals("I", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test2ToRomanNumberII() {
        romanNumeral = new RomanNumeral(2);
        assertEquals("II", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test3ToRomanNumberIII() {
        romanNumeral = new RomanNumeral(3);
        assertEquals("III", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test4ToRomanNumberIV() {
        romanNumeral = new RomanNumeral(4);
        assertEquals("IV", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test5ToRomanNumberV() {
        romanNumeral = new RomanNumeral(5);
        assertEquals("V", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test6ToRomanNumberVI() {
        romanNumeral = new RomanNumeral(6);
        assertEquals("VI", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test9ToRomanNumberIX() {
        romanNumeral = new RomanNumeral(9);
        assertEquals("IX", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test27ToRomanNumberXXVII() {
        romanNumeral = new RomanNumeral(27);
        assertEquals("XXVII", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test48ToRomanNumberXLVIII() {
        romanNumeral = new RomanNumeral(48);
        assertEquals("XLVIII", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test49ToRomanNumberXLIX() {
        romanNumeral = new RomanNumeral(49);
        assertEquals("XLIX", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test59ToRomanNumberLIX() {
        romanNumeral = new RomanNumeral(59);
        assertEquals("LIX", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test93ToRomanNumberXCIII() {
        romanNumeral = new RomanNumeral(93);
        assertEquals("XCIII", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test141ToRomanNumberCXLI() {
        romanNumeral = new RomanNumeral(141);
        assertEquals("CXLI", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test163ToRomanNumberCLXIII() {
        romanNumeral = new RomanNumeral(163);
        assertEquals("CLXIII", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test402ToRomanNumberCDII() {
        romanNumeral = new RomanNumeral(402);
        assertEquals("CDII", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test575ToRomanNumberDLXXV() {
        romanNumeral = new RomanNumeral(575);
        assertEquals("DLXXV", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test911ToRomanNumberCMXI() {
        romanNumeral = new RomanNumeral(911);
        assertEquals("CMXI", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test1024ToRomanNumberMXXIV() {
        romanNumeral = new RomanNumeral(1024);
        assertEquals("MXXIV", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void test3000ToRomanNumberMMM() {
        romanNumeral = new RomanNumeral(3000);
        assertEquals("MMM", romanNumeral.getRomanNumeral());
    }

}
