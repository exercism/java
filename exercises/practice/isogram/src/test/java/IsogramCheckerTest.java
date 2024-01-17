import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsogramCheckerTest {
    private IsogramChecker isogramChecker;
    
    @BeforeEach
    public void setUp() {
        isogramChecker = new IsogramChecker();
    }

    @Test
    public void testEmptyString() {
        assertThat(isogramChecker.isIsogram("")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testLowercaseIsogram() {
        assertThat(isogramChecker.isIsogram("isogram")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testNotIsogram() {
        assertThat(isogramChecker.isIsogram("eleven")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testDuplicateEndAlphabet() {
        assertThat(isogramChecker.isIsogram("zzyzx")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testMediumLongIsogram() {
        assertThat(isogramChecker.isIsogram("subdermatoglyphic")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testCaseInsensitive() {
        assertThat(isogramChecker.isIsogram("Alphabet")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testDuplicateMixedCase() {
        assertThat(isogramChecker.isIsogram("alphAbet")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testIsogramWithHyphen() {
        assertThat(isogramChecker.isIsogram("thumbscrew-japingly")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testIsogramWithDuplicatedCharAfterHyphen() {
        assertThat(isogramChecker.isIsogram("thumbscrew-jappingly")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testIsogramWithDuplicatedHyphen() {
        assertThat(isogramChecker.isIsogram("six-year-old")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testMadeUpNameThatIsAnIsogram() {
        assertThat(isogramChecker.isIsogram("Emily Jung Schwartzkopf")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void testDuplicatedCharacterInTheMiddleIsNotIsogram() {
        assertThat(isogramChecker.isIsogram("accentor")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testSameFirstAndLast() {
        assertThat(new IsogramChecker().isIsogram("angola")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testDuplicatedCharacterAndTwoHyphens() {
        assertThat(new IsogramChecker().isIsogram("up-to-date")).isFalse();
    }
}
