import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LuhnValidatorTest {
    private LuhnValidator luhnValidator;

    @BeforeEach
    public void setUp() {
        luhnValidator = new LuhnValidator();
    }

    @Test
    @DisplayName("single digit strings can not be valid")
    public void testSingleDigitStringInvalid() {
        assertThat(luhnValidator.isValid("1")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a single zero is invalid")
    public void testSingleZeroIsInvalid() {
        assertThat(luhnValidator.isValid("0")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a simple valid SIN that remains valid if reversed")
    public void testSimpleValidSINReversedRemainsValid() {
        assertThat(luhnValidator.isValid("059")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a simple valid SIN that becomes invalid if reversed")
    public void testSimpleValidSINReversedBecomesInvalid() {
        assertThat(luhnValidator.isValid("59")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a valid Canadian SIN")
    public void testValidCanadianSINValid() {
        assertThat(luhnValidator.isValid("055 444 285")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid Canadian SIN")
    public void testInvalidCanadianSINInvalid() {
        assertThat(luhnValidator.isValid("055 444 286")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid credit card")
    public void testInvalidCreditCardInvalid() {
        assertThat(luhnValidator.isValid("8273 1232 7352 0569")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid long number with an even remainder")
    public void testInvalidLongNumberWithAnEvenRemainder() {
        assertThat(luhnValidator.isValid("1 2345 6789 1234 5678 9012")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid long number with a remainder divisible by 5")
    public void testInvalidLongNumberWithARemainderDivisibleBy5() {
        assertThat(luhnValidator.isValid("1 2345 6789 1234 5678 9013")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid number with an even number of digits")
    public void testValidNumberWithAnEvenNumberOfDigits() {
        assertThat(luhnValidator.isValid("095 245 88")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid number with an odd number of spaces")
    public void testValidNumberWithAnOddNumberOfSpaces() {
        assertThat(luhnValidator.isValid("234 567 891 234")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid strings with a non-digit added at the end become invalid")
    public void testValidStringsWithANonDigitAtEndInvalid() {
        assertThat(luhnValidator.isValid("059a")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid strings with punctuation included become invalid")
    public void testStringContainingPunctuationInvalid() {
        assertThat(luhnValidator.isValid("055-444-285")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid strings with symbols included become invalid")
    public void testStringContainingSymbolsInvalid() {
        assertThat(luhnValidator.isValid("055# 444$ 285")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("single zero with space is invalid")
    public void testSingleSpaceWithZeroInvalid() {
        assertThat(luhnValidator.isValid(" 0")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than a single zero is valid")
    public void testMoreThanSingleZeroValid() {
        assertThat(luhnValidator.isValid("0000 0")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("input digit 9 is correctly converted to output digit 9")
    public void testDigitNineConvertedToOutputNine() {
        assertThat(luhnValidator.isValid("091")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("very long input is valid")
    public void testVeryLongInputIsValid() {
        assertThat(luhnValidator.isValid("9999999999 9999999999 9999999999 9999999999")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid luhn with an odd number of digits and non zero first digit")
    public void testValidLuhnWithOddNumberOfDigitsAndNonZeroFirstDigit() {
        assertThat(luhnValidator.isValid("109")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("using ascii value for non-doubled non-digit isn't allowed")
    public void testUsingASCIIValueForNonDoubledNonDigitNotAllowed() {
        assertThat(luhnValidator.isValid("055b 444 285")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("using ascii value for doubled non-digit isn't allowed")
    public void testUsingASCIIValueForDoubledNonDigitNotAllowed() {
        assertThat(luhnValidator.isValid(":9")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("non-numeric, non-space char in the middle with a sum that's divisible by 10 isn't allowed")
    public void testNonNumericNonSpaceCharInMiddleWithSumDivisibleBy10IsNotAllowed() {
        assertThat(luhnValidator.isValid("59%59")).isFalse();
    }

    /* The following test diverges from the canonical test data. This is because the corresponding canonical test does
     * not account for Java specific functions (such as * Character.getNumericValue()), which can be part of incorrect yet
     * passing implementations. For more detail, check out issue #972 here:
     * (https://github.com/exercism/java/issues/972).
     */
    @Disabled("Remove to run test")
    @Test
    public void testStringContainingSymbolsInvalidJavaTrackSpecific() {
        assertThat(luhnValidator.isValid("85&")).isFalse();
    }
}
