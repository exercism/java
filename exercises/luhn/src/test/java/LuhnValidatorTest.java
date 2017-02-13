import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LuhnValidatorTest {

    @Test
    public void testThatSingleDigitStringIsNotValid() {
        assertFalse(new LuhnValidator().isValid("1"));
    }

    @Ignore
    @Test
    public void testThatTheStringConsistingOfASingleZeroIsInvalid() {
        assertFalse(new LuhnValidator().isValid("0"));
    }

    @Ignore
    @Test
    public void testThatASimpleValidNumberIsIdentifiedAsValid() {
        assertTrue(new LuhnValidator().isValid(" 5 9 "));
    }

    @Ignore
    @Test
    public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV1() {
        assertTrue(new LuhnValidator().isValid("046 454 286"));
    }

    @Ignore
    @Test
    public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV2() {
        assertTrue(new LuhnValidator().isValid("055 444 285"));
    }

    @Ignore
    @Test
    public void testThatAnInvalidCanadianSocialInsuranceNumberIsIdentifiedAsInvalid() {
        assertFalse(new LuhnValidator().isValid("046 454 287"));
    }

    @Ignore
    @Test
    public void testThatAnInvalidCreditCardIsIdentifiedAsInvalid() {
        assertFalse(new LuhnValidator().isValid("8273 1232 7352 0569"));
    }

    @Ignore
    @Test
    public void testThatAddingANonDigitCharacterToAValidStringInvalidatesTheString() {
        assertFalse(new LuhnValidator().isValid("046a 454 286"));
    }

    @Ignore
    @Test
    public void testThatStringContainingPunctuationIsInvalid() {
        assertFalse(new LuhnValidator().isValid("055-444-285"));
    }

    @Ignore
    @Test
    public void testThatStringContainingSymbolsIsInvalid() {
        assertFalse(new LuhnValidator().isValid("055£ 444$ 285"));
    }

    @Ignore
    @Test
    public void testThatTheStringConsistingOfASpaceAndASingleZeroIsInvalid() {
        assertFalse(new LuhnValidator().isValid(" 0"));
    }

    @Ignore
    @Test
    public void testThatStringContainingMultipleZerosIsValid() {
        assertTrue(new LuhnValidator().isValid(" 00000"));
    }

    @Ignore
    @Test
    public void testThatDoublingNineIsHandledCorrectly() {
        assertTrue(new LuhnValidator().isValid("091"));
    }

}
