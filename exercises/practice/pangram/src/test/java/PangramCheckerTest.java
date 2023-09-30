import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PangramCheckerTest {

    private PangramChecker pangramChecker;

    @Before
    public void setup() {
        pangramChecker = new PangramChecker();
    }

    @Test
    public void emptySentenceIsNotPangram() {
        assertThat(pangramChecker.isPangram("")).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void perfectLowerCasePhraseIsPangram() {
        assertThat(pangramChecker.isPangram("abcdefghijklmnopqrstuvwxyz")).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void phraseWithOnlyLowerCaseIsPangram() {
        assertThat(pangramChecker.isPangram("the quick brown fox jumps over the lazy dog")).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void phraseMissingCharacterXIsNotPangram() {
        assertThat(pangramChecker.isPangram("a quick movement of the enemy will jeopardize five gunboats")).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void phraseMissingCharacterHIsNotPangram() {
        assertThat(pangramChecker.isPangram("five boxing wizards jump quickly at it")).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void phraseWithUnderscoresIsPangram() {
        assertThat(pangramChecker.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog")).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void phraseWithNumbersIsPangram() {
        assertThat(pangramChecker.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs")).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void phraseWithMissingLettersReplacedByNumbersIsNotPangram() {
        assertThat(pangramChecker.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog")).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void phraseWithMixedCaseAndPunctuationIsPangram() {
        assertThat(pangramChecker.isPangram("\"Five quacking Zephyrs jolt my wax bed.\"")).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void caseInsensitivePhraseIsNotPangram() {
        assertThat(pangramChecker.isPangram("the quick brown fox jumps over with lazy FX")).isFalse();
    }
}
