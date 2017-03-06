import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PangramsTest {
    private Pangrams pangrams;

    @Before
    public void setup() {
        pangrams = new Pangrams();
    }


    @Test
    public void emptySentenceIsNotPangram() {
        assertFalse(pangrams.isPangram(""));
    }

    @Ignore
    @Test
    public void pangramWithOnlyLowerCaseLettersIsRecognizedAsPangram() {
        assertTrue(pangrams.isPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Ignore
    @Test
    public void phraseMissingCharacterXIsNotPangram() {
        assertFalse(pangrams.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
    }

    @Ignore
    @Test
    public void anotherPhraseMissingCharacterXIsNotPangram() {
        assertFalse(pangrams.isPangram("the quick brown fish jumps over the lazy dog"));
    }

    @Ignore
    @Test
    public void pangramWithUnderscoresIsRecognizedAsPangram() {
        assertTrue(pangrams.isPangram("\"the_quick_brown_fox_jumps_over_the_lazy_dog\""));
    }

    @Ignore
    @Test
    public void pangramWithNumbersIsRecognizedAsPangram() {
        assertTrue(pangrams.isPangram("\"the 1 quick brown fox jumps over the 2 lazy dogs\""));
    }

    @Ignore
    @Test
    public void phraseWithMissingLettersReplacedByNumbersIsNotPangram() {
        assertFalse(pangrams.isPangram("\"7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog\""));
    }

    @Ignore
    @Test
    public void pangramWithMixedCaseAndPunctuationIsRecognizedAsPangram() {
        assertTrue(pangrams.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
    }

    @Ignore
    @Test
    public void pangramWithNonAsciiCharactersIsRecognizedAsPangram() {
        assertTrue(pangrams.isPangram("Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich."));
    }


    @Ignore
    @Test
    public void panagramInAlphabetOtherThanAsciiIsNotRecognizedAsPangram() {
        assertFalse(pangrams.isPangram("Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства."));
    }

    @Ignore
    @Test
    public void upperAndLowerCaseVersionsOfTheSameCharacterShouldNotBeCountedSeparately() {
        assertFalse(pangrams.isPangram("the quick brown fox jumped over the lazy FOX"));
    }
}
