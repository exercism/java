import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LuhnValidatorTest {
    private LuhnValidator luhnValidator;

    @BeforeEach
    public void setUp() {
        luhnValidator = new LuhnValidator();
    }

    @Test
    public void testSingleDigitStringInvalid() {
        assertThat(luhnValidator.isValid("1")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testSingleZeroIsInvalid() {
        assertThat(luhnValidator.isValid("0")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testSimpleValidSINReversedRemainsValid() {
        assertThat(luhnValidator.isValid("059")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testSimpleValidSINReversedBecomesInvalid() {
        assertThat(luhnValidator.isValid("59")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testValidCanadianSINValid() {
        assertThat(luhnValidator.isValid("055 444 285")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testInvalidCanadianSINInvalid() {
        assertThat(luhnValidator.isValid("055 444 286")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testInvalidCreditCardInvalid() {
        assertThat(luhnValidator.isValid("8273 1232 7352 0569")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testInvalidLongNumberWithAnEvenRemainder() {
        assertThat(luhnValidator.isValid("1 2345 6789 1234 5678 9012")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testInvalidLongNumberWithARemainderDivisibleBy5() {
        assertThat(luhnValidator.isValid("1 2345 6789 1234 5678 9013")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testValidNumberWithAnEvenNumberOfDigits() {
        assertThat(luhnValidator.isValid("095 245 88")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testValidNumberWithAnOddNumberOfSpaces() {
        assertThat(luhnValidator.isValid("234 567 891 234")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testValidStringsWithANonDigitAtEndInvalid() {
        assertThat(luhnValidator.isValid("059a")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testStringContainingPunctuationInvalid() {
        assertThat(luhnValidator.isValid("055-444-285")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testStringContainingSymbolsInvalid() {
        assertThat(luhnValidator.isValid("055# 444$ 285")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testSingleSpaceWithZeroInvalid() {
        assertThat(luhnValidator.isValid(" 0")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testMoreThanSingleZeroValid() {
        assertThat(luhnValidator.isValid("0000 0")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testDigitNineConvertedToOutputNine() {
        assertThat(luhnValidator.isValid("091")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testVeryLongInputIsValid() {
        assertThat(luhnValidator.isValid("9999999999 9999999999 9999999999 9999999999")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testValidLuhnWithOddNumberOfDigitsAndNonZeroFirstDigit() {
        assertThat(luhnValidator.isValid("109")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testUsingASCIIValueForNonDoubledNonDigitNotAllowed() {
        assertThat(luhnValidator.isValid("055b 444 285")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testUsingASCIIValueForDoubledNonDigitNotAllowed() {
        assertThat(luhnValidator.isValid(":9")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testNonNumericNonSpaceCharInMiddleWithSumDivisibleBy10IsNotAllowed() {
        assertThat(luhnValidator.isValid("59%59")).isFalse();
    }

    /* The following test diverges from the canonical test data. This is because the corresponding canonical test does
     * not account for Java specific functions (such as Character.getNumericValue()), which can be part of incorrect yet
     * passing implementations. For more detail, check out issue #972 here:
     * (https://github.com/exercism/java/issues/972).
     */
    @Disabled("Remove to run test")
    @Test
    public void testStringContainingSymbolsInvalidJavaTrackSpecific() {
        assertThat(luhnValidator.isValid("85&")).isFalse();
    }
}
