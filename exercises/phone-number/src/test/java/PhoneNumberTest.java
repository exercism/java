import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PhoneNumberTest {
    private static String wrongLengthExceptionMessage = "incorrect number of digits";
    private static String moreThan11DigitsExceptionMessage = "more than 11 digits";
    private static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "11 digits must start with 1";
    private static String illegalCharacterExceptionMessage =
            "letters not permitted";
    private static String illegalPunctuationExceptionMessage =
            "punctuations not permitted";
    private static String areaCodeStartsWithZeroExceptionMessage =
            "area code cannot start with zero";
    private static String areaCodeStartsWithOneExceptionMessage =
            "area code cannot start with one";
    private static String exchangeCodeStartsWithZeroExceptionMessage =
            "exchange code cannot start with zero";
    private static String exchangeCodeStartsWithOneExceptionMessage =
            "exchange code cannot start with one";
    
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
        expectedException.expectMessage(moreThan11DigitsExceptionMessage);
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
        expectedException.expectMessage(illegalPunctuationExceptionMessage);
        new PhoneNumber("123-@:!-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith0() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(areaCodeStartsWithZeroExceptionMessage);
        new PhoneNumber("(023) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(areaCodeStartsWithOneExceptionMessage);
        new PhoneNumber("(123) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith0() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(exchangeCodeStartsWithZeroExceptionMessage);
        new PhoneNumber("(223) 056-7890");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(exchangeCodeStartsWithOneExceptionMessage);
        new PhoneNumber("(223) 156-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith0OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(areaCodeStartsWithZeroExceptionMessage);
        new PhoneNumber("1 (023) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith1OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(areaCodeStartsWithOneExceptionMessage);
        new PhoneNumber("1 (123) 456-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith0OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(exchangeCodeStartsWithZeroExceptionMessage);
        new PhoneNumber("1 (223) 056-7890");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith1OnValid11DigitNumber() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(exchangeCodeStartsWithOneExceptionMessage);
        new PhoneNumber("1 (223) 156-7890");
    }
}
