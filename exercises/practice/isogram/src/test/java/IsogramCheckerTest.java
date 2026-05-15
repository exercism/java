import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsogramCheckerTest {
    private IsogramChecker isogramChecker;
    
    @BeforeEach
    public void setUp() {
        isogramChecker = new IsogramChecker();
    }

    @Test
    @DisplayName("empty string")
    public void testEmptyString() {
        assertThat(isogramChecker.isIsogram("")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("isogram with only lower case characters")
    public void testLowercaseIsogram() {
        assertThat(isogramChecker.isIsogram("isogram")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("word with one duplicated character")
    public void testNotIsogram() {
        assertThat(isogramChecker.isIsogram("eleven")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("word with one duplicated character from the end of the alphabet")
    public void testDuplicateEndAlphabet() {
        assertThat(isogramChecker.isIsogram("zzyzx")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("longest reported english isogram")
    public void testMediumLongIsogram() {
        assertThat(isogramChecker.isIsogram("subdermatoglyphic")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("word with duplicated character in mixed case")
    public void testCaseInsensitive() {
        assertThat(isogramChecker.isIsogram("Alphabet")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("word with duplicated character in mixed case, lowercase first")
    public void testDuplicateMixedCase() {
        assertThat(isogramChecker.isIsogram("alphAbet")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("hypothetical isogrammic word with hyphen")
    public void testIsogramWithHyphen() {
        assertThat(isogramChecker.isIsogram("thumbscrew-japingly")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("hypothetical word with duplicated character following hyphen")
    public void testIsogramWithDuplicatedCharAfterHyphen() {
        assertThat(isogramChecker.isIsogram("thumbscrew-jappingly")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("isogram with duplicated hyphen")
    public void testIsogramWithDuplicatedHyphen() {
        assertThat(isogramChecker.isIsogram("six-year-old")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("made-up name that is an isogram")
    public void testMadeUpNameThatIsAnIsogram() {
        assertThat(isogramChecker.isIsogram("Emily Jung Schwartzkopf")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("duplicated character in the middle")
    public void testDuplicatedCharacterInTheMiddleIsNotIsogram() {
        assertThat(isogramChecker.isIsogram("accentor")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("same first and last characters")
    public void testSameFirstAndLast() {
        assertThat(new IsogramChecker().isIsogram("angola")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("word with duplicated character and with two hyphens")
    public void testDuplicatedCharacterAndTwoHyphens() {
        assertThat(new IsogramChecker().isIsogram("up-to-date")).isFalse();
    }
}
