import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LuhnValidatorTest {
    private LuhnValidator luhnValidator;

    @Before
    public void setUp() {
        luhnValidator = new LuhnValidator();
    }

    @Test
    public void testSingleDigitStringInvalid() {
        assertFalse(luhnValidator.isValid("1"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleZeroIsInvalid() {
        assertFalse(luhnValidator.isValid("0"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSimpleValidSINReversedRemainsValid() {
        assertTrue(luhnValidator.isValid("059"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSimpleValidSINReversedBecomesInvalid() {
        assertTrue(luhnValidator.isValid("59"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidCanadianSINValid() {
        assertTrue(luhnValidator.isValid("055 444 285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidCanadianSINInvalid() {
        assertFalse(luhnValidator.isValid("055 444 286"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidCreditCardInvalid() {
        assertFalse(luhnValidator.isValid("8273 1232 7352 0569"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidLongNumberWithAnEvenRemainder() {
        assertFalse(luhnValidator.isValid("1 2345 6789 1234 5678 9012"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidNumberWithAnEvenNumberOfDigits() {
        assertTrue(luhnValidator.isValid("095 245 88"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidNumberWithAnOddNumberOfSpaces() {
        assertTrue(luhnValidator.isValid("234 567 891 234"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidStringsWithANonDigitAtEndInvalid() {
        assertFalse(luhnValidator.isValid("059a"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testStringContainingPunctuationInvalid() {
        assertFalse(luhnValidator.isValid("055-444-285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testStringContainingSymbolsInvalid() {
        assertFalse(luhnValidator.isValid("055# 444$ 285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleSpaceWithZeroInvalid() {
        assertFalse(luhnValidator.isValid(" 0"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMoreThanSingleZeroValid() {
        assertTrue(luhnValidator.isValid("0000 0"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDigitNineConvertedToOutputNine() {
        assertTrue(luhnValidator.isValid("091"));
    }


    @Ignore("Remove to run test")
    @Test
    public void testUsingASCIIValueForNonDoubledNonDigitNotAllowed() {
        assertFalse(luhnValidator.isValid("055b 444 285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testUsingASCIIValueForDoubledNonDigitNotAllowed() {
        assertFalse(luhnValidator.isValid(":9"));
    }

    /* The following test diverges from the canonical test data. This is because the corresponding canonical test does
     * not account for Java specific functions (such as Character.getNumericValue()), which can be part of incorrect yet
     * passing implementations. For more detail, check out issue #972 here:
     * (https://github.com/exercism/java/issues/972).
    */
    @Ignore("Remove to run test")
    @Test
    public void testStringContainingSymbolsInvalidJavaTrackSpecific() {
        assertFalse(luhnValidator.isValid("85&"));
    }
}
