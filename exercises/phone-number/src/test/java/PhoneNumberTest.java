import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PhoneNumberTest {
    private final static String wrongLengthExceptionMessage = "Number must be 10 or 11 digits";
    private final static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "Can only have 11 digits if number starts with '1'";
    private final static String illegalCharacterExceptionMessage =
            "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void cleansNumber() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("(123) 456-7890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore
    @Test
    public void cleansNumberWithDots() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("123.456.7890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore
    @Test
    public void cleansNumberWithMultipleSpaces() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("123 456   7890   ").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore
    @Test
    public void invalidWhen9Digits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(wrongLengthExceptionMessage);
        new PhoneNumber("123456789");
    }

    @Ignore
    @Test
    public void invalidWhen11Digits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
        new PhoneNumber("21234567890");
    }

    @Ignore
    @Test
    public void validWhen11DigitsAndFirstIs1() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("11234567890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Ignore
    @Test
    public void invalidWhen12Digits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(wrongLengthExceptionMessage);
        new PhoneNumber("321234567890");
    }

    @Ignore
    @Test
    public void invalidWithLetters() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalCharacterExceptionMessage);
        new PhoneNumber("123-abc-7890");
    }

    @Ignore
    @Test
    public void invalidWithPunctuation() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalCharacterExceptionMessage);
        new PhoneNumber("123-@:!-7890");
    }

    @Ignore
    @Test
    public void invalidWithRightNumberOfDigitsButLettersMixedIn() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(illegalCharacterExceptionMessage);
        new PhoneNumber("1a2b3c4d5e6f7g8h9i0j");
    }
}
