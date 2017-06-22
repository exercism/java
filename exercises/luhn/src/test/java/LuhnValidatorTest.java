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
    public void testThatSingleDigitStringIsNotValid() {
        assertFalse(luhnValidator.isValid("1"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatTheStringConsistingOfASingleZeroIsInvalid() {
        assertFalse(luhnValidator.isValid("0"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatASimpleValidNumberIsIdentifiedAsValid() {
        assertTrue(luhnValidator.isValid(" 5 9 "));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV1() {
        assertTrue(luhnValidator.isValid("046 454 286"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV2() {
        assertTrue(luhnValidator.isValid("055 444 285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatAnInvalidCanadianSocialInsuranceNumberIsIdentifiedAsInvalid() {
        assertFalse(luhnValidator.isValid("046 454 287"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatAnInvalidCreditCardIsIdentifiedAsInvalid() {
        assertFalse(luhnValidator.isValid("8273 1232 7352 0569"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatAddingANonDigitCharacterToAValidStringInvalidatesTheString() {
        assertFalse(luhnValidator.isValid("046a 454 286"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatStringContainingPunctuationIsInvalid() {
        assertFalse(luhnValidator.isValid("055-444-285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatStringContainingSymbolsIsInvalid() {
        assertFalse(luhnValidator.isValid("055£ 444$ 285"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatTheStringConsistingOfASpaceAndASingleZeroIsInvalid() {
        assertFalse(luhnValidator.isValid(" 0"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatStringContainingMultipleZerosIsValid() {
        assertTrue(luhnValidator.isValid(" 00000"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatDoublingNineIsHandledCorrectly() {
        assertTrue(luhnValidator.isValid("091"));
    }

}
