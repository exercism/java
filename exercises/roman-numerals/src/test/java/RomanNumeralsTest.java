import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {

    private RomanNumeral romanNumeral;

    @Test
    public void testSingleDigitArabicToRomanNumber() {
        romanNumeral = new RomanNumeral(1);
        assertEquals("I", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(2);
        assertEquals("II", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(3);
        assertEquals("III", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(4);
        assertEquals("IV", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(5);
        assertEquals("V", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(6);
        assertEquals("VI", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(9);
        assertEquals("IX", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDoubleDigitArabicToRomanNumber() {
        romanNumeral = new RomanNumeral(27);
        assertEquals("XXVII", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(48);
        assertEquals("XLVIII", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(59);
        assertEquals("LIX", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(93);
        assertEquals("XCIII", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeDigitArabicToRomanNumber() {
        romanNumeral = new RomanNumeral(141);
        assertEquals("CXLI", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(163);
        assertEquals("CLXIII", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(402);
        assertEquals("CDII", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(575);
        assertEquals("DLXXV", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(911);
        assertEquals("CMXI", romanNumeral.getRomanNumeral());
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourDigitArabicToRomanNumber() {
        romanNumeral = new RomanNumeral(1024);
        assertEquals("MXXIV", romanNumeral.getRomanNumeral());

        romanNumeral = new RomanNumeral(3000);
        assertEquals("MMM", romanNumeral.getRomanNumeral());
    }

}
