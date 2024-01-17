import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsbnVerifierTest {
    private IsbnVerifier isbnVerifier;

    @BeforeEach
    public void setUp() {
        isbnVerifier = new IsbnVerifier();
    }

    @Test
    public void validIsbnNumber() {
        assertThat(isbnVerifier.isValid("3-598-21508-8")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidIsbnCheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-21508-9")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void validIsbnNumberWithCheckDigitOfTen() {
        assertThat(isbnVerifier.isValid("3-598-21507-X")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void validIsbnNumberWithCheckDigitPaddedWithLettersIsInvalid() {
        assertThat(isbnVerifier.isValid("ABCDEFG3-598-21507-XQWERTYUI")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void checkDigitIsACharacterOtherThanX() {
        assertThat(isbnVerifier.isValid("3-598-21507-A")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidCheckDigitInIsbn() {
        assertThat(isbnVerifier.isValid("4-598-21507-B")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidCharacterInIsbn() {
        assertThat(isbnVerifier.isValid("3-598-P1581-X")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void xIsOnlyValidAsACheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-2X507-9")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void validIsbnWithoutSeparatingDashes() {
        assertThat(isbnVerifier.isValid("3598215088")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void isbnWithoutSeparatingDashesAndXAsCheckDigit() {
        assertThat(isbnVerifier.isValid("359821507X")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void isbnWithoutCheckDigitAndDashes() {
        assertThat(isbnVerifier.isValid("359821507")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void tooLongIsbnAndNoDashes() {
        assertThat(isbnVerifier.isValid("3598215078X")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void tooShortIsbn() {
        assertThat(isbnVerifier.isValid("00")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void isbnWithoutCheckDigit() {
        assertThat(isbnVerifier.isValid("3-598-21507")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void checkDigitOfXShouldNotBeUsedForZero() {
        assertThat(isbnVerifier.isValid("3-598-21515-X")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void emptyIsbn() {
        assertThat(isbnVerifier.isValid("")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void inputIsNineCharacters() {
        assertThat(isbnVerifier.isValid("134456729")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidCharactersAreNotIgnoredAfterCheckingLength() {
        assertThat(isbnVerifier.isValid("3132P34035")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidCharactersAreNotIgnoredBeforeCheckingLength() {
        assertThat(isbnVerifier.isValid("3598P215088")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void inputIsTooLongButContainsAValidIsbn() {
        assertThat(isbnVerifier.isValid("98245726788")).isFalse();
    }
}
