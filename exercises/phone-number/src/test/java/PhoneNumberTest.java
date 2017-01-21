import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PhoneNumberTest {

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
    public void validWhen11DigitsAndFirstIs1() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("11234567890").getNumber();

        assertEquals(
            expectedNumber, actualNumber
        );
    }

    @Ignore
    @Test
    public void invalidWhenOnly11Digits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Can only have 11 digits if number starts with '1'");
        new PhoneNumber("21234567890").getNumber();
    }

    @Ignore
    @Test
    public void invalidWhen9Digits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Number must be 10 or 11 digits");
        new PhoneNumber("123456789").getNumber();
    }

    @Ignore
    @Test
    public void areaCode() {
        final String expectedAreaCode = "123";
        final String actualAreaCode = new PhoneNumber("1234567890").getAreaCode();

        assertEquals(
            expectedAreaCode, actualAreaCode
        );
    }

    @Ignore
    @Test
    public void prettyPrint() {
        final String expectedPrettyNumber = "(123) 456-7890";
        final String actualPrettyNumber = new PhoneNumber("1234567890").pretty();

        assertEquals(
            expectedPrettyNumber, actualPrettyNumber
        );
    }

    @Ignore
    @Test
    public void prettyPrintWithFullUSPhoneNumber() {
        final String expectedPrettyNumber = "(123) 456-7890";
        final String actualPrettyNumber = new PhoneNumber("11234567890").pretty();

        assertEquals(
            expectedPrettyNumber, actualPrettyNumber
        );
    }

}
