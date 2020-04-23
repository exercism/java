import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class PhoneNumberTest {

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
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("123456789"));

        assertThat(expected)
            .hasMessage("incorrect number of digits");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWhen11DigitsDoesNotStartWith1() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("22234567890"));

        assertThat(expected)
            .hasMessage("11 digits must start with 1");
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
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("321234567890"));

        assertThat(expected)
            .hasMessage("more than 11 digits");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWithLetters() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("123-abc-7890"));

        assertThat(expected)
            .hasMessage("letters not permitted");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidWithPunctuations() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("123-@:!-7890"));

        assertThat(expected)
            .hasMessage("punctuations not permitted");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith0() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("(023) 456-7890"));

        assertThat(expected)
            .hasMessage("area code cannot start with zero");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith1() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("(123) 456-7890"));

        assertThat(expected)
            .hasMessage("area code cannot start with one");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith0() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("(223) 056-7890"));

        assertThat(expected)
            .hasMessage("exchange code cannot start with zero");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith1() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("(223) 156-7890"));

        assertThat(expected)
            .hasMessage("exchange code cannot start with one");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith0OnValid11DigitNumber() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("1 (023) 456-7890"));

        assertThat(expected)
            .hasMessage("area code cannot start with zero");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfAreaCodeStartsWith1OnValid11DigitNumber() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("1 (123) 456-7890"));

        assertThat(expected)
            .hasMessage("area code cannot start with one");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith0OnValid11DigitNumber() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("1 (223) 056-7890"));

        assertThat(expected)
            .hasMessage("exchange code cannot start with zero");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void invalidIfExchangeCodeStartsWith1OnValid11DigitNumber() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("1 (223) 156-7890"));

        assertThat(expected)
            .hasMessage("exchange code cannot start with one");
    }
}
