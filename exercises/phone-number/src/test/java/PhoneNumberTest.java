import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PhoneNumberTest {
    private static String wrongLengthExceptionMessage = "Number must be 10 or 11 digits";
    private static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "Can only have 11 digits if number starts with '1'";
    private static String illegalCharacterExceptionMessage =
            "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.";
    private static String illegalAreaOrExchangeCodeMessage =
            "Illegal Area Or Exchange Code. Only 2-9 are valid digits";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void cleansTheNumber() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("(223) 456-7890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void cleansNumbersWithDots() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("223.456.7890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void cleansNumbersWithMultipleSpaces() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("223 456   7890   ").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWhen9Digits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(wrongLengthExceptionMessage);
        new PhoneNumber("123456789");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWhen11DigitsDoesNotStartWith1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
        new PhoneNumber("22234567890");
    }

    @Ignore("Remove to run test")
    @Test
    public void validWhen11DigitsAndStartingWith1() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("12234567890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }
    
    @Ignore("Remove to run test")
    @Test
    public void validWhen11DigitsAndStartingWith1EvenWithPunctuation() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("+1 (223) 456-7890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWhenMoreThan11Digits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(wrongLengthExceptionMessage);
        new PhoneNumber("321234567890");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWithLetters() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalCharacterExceptionMessage);
        new PhoneNumber("123-abc-7890");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWithPunctuations() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalCharacterExceptionMessage);
        new PhoneNumber("123-@:!-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith0() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("(023) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("(123) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith0() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("(223) 056-7890");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("(223) 156-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith0OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("1 (023) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith1OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("1 (123) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith0OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("1 (223) 056-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith1OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalAreaOrExchangeCodeMessage);
        new PhoneNumber("1 (223) 156-7890");
    }
}
