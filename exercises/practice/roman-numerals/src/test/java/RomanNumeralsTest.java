import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @Test
    @DisplayName("1 is I")
    public void test1ToRomanNumberI() {
        romanNumerals = new RomanNumerals(1);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("I");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("2 is II")
    public void test2ToRomanNumberII() {
        romanNumerals = new RomanNumerals(2);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("II");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("3 is III")
    public void test3ToRomanNumberIII() {
        romanNumerals = new RomanNumerals(3);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("III");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("4 is IV")
    public void test4ToRomanNumberIV() {
        romanNumerals = new RomanNumerals(4);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("IV");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("5 is V")
    public void test5ToRomanNumberV() {
        romanNumerals = new RomanNumerals(5);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("V");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("6 is VI")
    public void test6ToRomanNumberVI() {
        romanNumerals = new RomanNumerals(6);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("VI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("9 is IX")
    public void test9ToRomanNumberIX() {
        romanNumerals = new RomanNumerals(9);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("IX");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("16 is XVI")
    public void test16ToRomanNumberXVI() {
        romanNumerals = new RomanNumerals(16);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("XVI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("27 is XXVII")
    public void test27ToRomanNumberXXVII() {
        romanNumerals = new RomanNumerals(27);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("XXVII");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("48 is XLVIII")
    public void test48ToRomanNumberXLVIII() {
        romanNumerals = new RomanNumerals(48);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("XLVIII");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("49 is XLIX")
    public void test49ToRomanNumberXLIX() {
        romanNumerals = new RomanNumerals(49);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("XLIX");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("59 is LIX")
    public void test59ToRomanNumberLIX() {
        romanNumerals = new RomanNumerals(59);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("LIX");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("66 is LXVI")
    public void test66ToRomanNumberLXVI() {
        romanNumerals = new RomanNumerals(66);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("LXVI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("93 is XCIII")
    public void test93ToRomanNumberXCIII() {
        romanNumerals = new RomanNumerals(93);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("XCIII");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("141 is CXLI")
    public void test141ToRomanNumberCXLI() {
        romanNumerals = new RomanNumerals(141);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("CXLI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("163 is CLXIII")
    public void test163ToRomanNumberCLXIII() {
        romanNumerals = new RomanNumerals(163);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("CLXIII");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("166 is CLXVI")
    public void test166ToRomanNumberCLXVI() {
        romanNumerals = new RomanNumerals(166);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("CLXVI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("402 is CDII")
    public void test402ToRomanNumberCDII() {
        romanNumerals = new RomanNumerals(402);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("CDII");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("575 is DLXXV")
    public void test575ToRomanNumberDLXXV() {
        romanNumerals = new RomanNumerals(575);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("DLXXV");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("666 is DCLXVI")
    public void test666ToRomanNumberDCLXVI() {
        romanNumerals = new RomanNumerals(666);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("DCLXVI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("911 is CMXI")
    public void test911ToRomanNumberCMXI() {
        romanNumerals = new RomanNumerals(911);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("CMXI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("1024 is MXXIV")
    public void test1024ToRomanNumberMXXIV() {
        romanNumerals = new RomanNumerals(1024);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("MXXIV");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("1666 is MDCLXVI")
    public void test1666ToRomanNumberMDCLXVI() {
        romanNumerals = new RomanNumerals(1666);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("MDCLXVI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("3000 is MMM")
    public void test3000ToRomanNumberMMM() {
        romanNumerals = new RomanNumerals(3000);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("MMM");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("3001 is MMMI")
    public void test3001ToRomanNumberMMMI() {
        romanNumerals = new RomanNumerals(3001);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("MMMI");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("3888 is MMMDCCCLXXXVIII")
    public void test3888ToRomanNumberMMMDCCCLXXXVIII() {
        romanNumerals = new RomanNumerals(3888);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("MMMDCCCLXXXVIII");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("3999 is MMMCMXCIX")
    public void test3999ToRomanNumberMMMCMXCIX() {
        romanNumerals = new RomanNumerals(3999);
        assertThat(romanNumerals.getRomanNumeral()).isEqualTo("MMMCMXCIX");
    }
}
