import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PhoneNumberTest {

    @Test
    @DisplayName("Cleans common formatted number to digits only")
    public void cleansTheNumber() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("(223) 456-7890").getNumber();

        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Cleans numbers with dots to digits only")
    public void cleansNumbersWithDots() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("223.456.7890").getNumber();

        assertThat(actualNumber).isEqualTo(expectedNumber);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Cleans numbers with multiple spaces")
    public void cleansNumbersWithMultipleSpaces() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("223 456   7890   ").getNumber();

        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Nine digit numbers are invalid")
    public void invalidWhen9Digits() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("123456789"))
                .withMessage("must not be fewer than 10 digits");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Eleven digits not starting with 1 are invalid")
    public void invalidWhen11DigitsDoesNotStartWith1() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("22234567890"))
                .withMessage("11 digits must start with 1");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Eleven digits starting with 1 are accepted and trimmed")
    public void validWhen11DigitsAndStartingWith1() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("12234567890").getNumber();

        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Valid 11-digit number with punctuation is accepted")
    public void validWhen11DigitsAndStartingWith1EvenWithPunctuation() {
        String expectedNumber = "2234567890";
        String actualNumber = new PhoneNumber("+1 (223) 456-7890").getNumber();

        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("More than 11 digits is invalid")
    public void invalidWhenMoreThan11Digits() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("321234567890"))
                .withMessage("must not be greater than 11 digits");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Letters in number are not permitted")
    public void invalidWithLetters() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("523-abc-7890"))
                .withMessage("letters not permitted");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Unsupported punctuations are not permitted")
    public void invalidWithPunctuations() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("523-@:!-7890"))
                .withMessage("punctuations not permitted");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Area code starting with 0 is invalid")
    public void invalidIfAreaCodeStartsWith0() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("(023) 456-7890"))
                .withMessage("area code cannot start with zero");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Area code starting with 1 is invalid")
    public void invalidIfAreaCodeStartsWith1() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("(123) 456-7890"))
                .withMessage("area code cannot start with one");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exchange code starting with 0 is invalid")
    public void invalidIfExchangeCodeStartsWith0() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("(223) 056-7890"))
                .withMessage("exchange code cannot start with zero");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exchange code starting with 1 is invalid")
    public void invalidIfExchangeCodeStartsWith1() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("(223) 156-7890"))
                .withMessage("exchange code cannot start with one");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Area code starting with 0 invalid on valid 11-digit number")
    public void invalidIfAreaCodeStartsWith0OnValid11DigitNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("1 (023) 456-7890"))
                .withMessage("area code cannot start with zero");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Area code starting with 1 invalid on valid 11-digit number")
    public void invalidIfAreaCodeStartsWith1OnValid11DigitNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("1 (123) 456-7890"))
                .withMessage("area code cannot start with one");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exchange code starting with 0 invalid on valid 11-digit number")
    public void invalidIfExchangeCodeStartsWith0OnValid11DigitNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("1 (223) 056-7890"))
                .withMessage("exchange code cannot start with zero");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exchange code starting with 1 invalid on valid 11-digit number")
    public void invalidIfExchangeCodeStartsWith1OnValid11DigitNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PhoneNumber("1 (223) 156-7890"))
                .withMessage("exchange code cannot start with one");
    }
}
