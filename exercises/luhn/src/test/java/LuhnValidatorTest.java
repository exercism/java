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
    public void testStringsContainingNonDigitInvalid() {
        assertFalse(luhnValidator.isValid("055a 444 285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testStringContainingPunctuationInvalid() {
        assertFalse(luhnValidator.isValid("055-444-285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testStringContainingSymbolsInvalid() {
        assertFalse(luhnValidator.isValid("055£ 444$ 285"));
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
    public void testStringsWithNonDigitsInvalid() {
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
