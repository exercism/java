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
    public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValid() {
        assertTrue(new LuhnValidator().isValid("046 454 286"));
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

}
