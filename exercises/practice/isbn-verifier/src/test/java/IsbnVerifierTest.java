import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsbnVerifierTest {
    private IsbnVerifier isbnVerifier;

    @BeforeEach
    public void setUp() {
        isbnVerifier = new IsbnVerifier();
    }

    @Test
    @DisplayName("valid isbn")
    public void validIsbnNumber() {
        assertThat(isbnVerifier.isValid("3-598-21508-8")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid isbn check digit")
    public void invalidIsbnCheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-21508-9")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid isbn with a check digit of 10")
    public void validIsbnNumberWithCheckDigitOfTen() {
        assertThat(isbnVerifier.isValid("3-598-21507-X")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("")
    public void validIsbnNumberWithCheckDigitPaddedWithLettersIsInvalid() {
        assertThat(isbnVerifier.isValid("ABCDEFG3-598-21507-XQWERTYUI")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("check digit is a character other than X")
    public void checkDigitIsACharacterOtherThanX() {
        assertThat(isbnVerifier.isValid("3-598-21507-A")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid check digit in isbn is not treated as zero")
    public void invalidCheckDigitInIsbn() {
        assertThat(isbnVerifier.isValid("4-598-21507-B")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid character in isbn is not treated as zero")
    public void invalidCharacterInIsbn() {
        assertThat(isbnVerifier.isValid("3-598-P1581-X")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("X is only valid as a check digit")
    public void xIsOnlyValidAsACheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-2X507-9")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("valid isbn without separating dashes")
    public void validIsbnWithoutSeparatingDashes() {
        assertThat(isbnVerifier.isValid("3598215088")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("isbn without separating dashes and X as check digit")
    public void isbnWithoutSeparatingDashesAndXAsCheckDigit() {
        assertThat(isbnVerifier.isValid("359821507X")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("isbn without check digit and dashes")
    public void isbnWithoutCheckDigitAndDashes() {
        assertThat(isbnVerifier.isValid("359821507")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("too long isbn and no dashes")
    public void tooLongIsbnAndNoDashes() {
        assertThat(isbnVerifier.isValid("3598215078X")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("too short isbn")
    public void tooShortIsbn() {
        assertThat(isbnVerifier.isValid("00")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("isbn without check digit")
    public void isbnWithoutCheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-21507")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("check digit of X should not be used for 0")
    public void checkDigitOfXShouldNotBeUsedForZero() {
        assertThat(isbnVerifier.isValid("3-598-21515-X")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty isbn")
    public void emptyIsbn() {
        assertThat(isbnVerifier.isValid("")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("input is 9 characters")
    public void inputIsNineCharacters() {
        assertThat(isbnVerifier.isValid("134456729")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid characters are not ignored after checking length")
    public void invalidCharactersAreNotIgnoredAfterCheckingLength() {
        assertThat(isbnVerifier.isValid("3132P34035")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("invalid characters are not ignored before checking length")
    public void invalidCharactersAreNotIgnoredBeforeCheckingLength() {
        assertThat(isbnVerifier.isValid("3598P215088")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("input is too long but contains a valid isbn")
    public void inputIsTooLongButContainsAValidIsbn() {
        assertThat(isbnVerifier.isValid("98245726788")).isFalse();
    }
}
