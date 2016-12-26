import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PangramsTest {


    @Test
    public void sentenceEmpty() {
        assertFalse(Pangrams.isPangram(""));
    }

    @Ignore
    @Test
    public void pangramWithOnlyLowerCase() {
        assertTrue(Pangrams.isPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Ignore
    @Test
    public void missingCharacterX() {
        assertFalse(Pangrams.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
    }

    @Ignore
    @Test
    public void anotherMissingCharacterX() {
        assertFalse(Pangrams.isPangram("the quick brown fish jumps over the lazy dog"));
    }

    @Ignore
    @Test
    public void pangramWithUnderscores() {
        assertTrue(Pangrams.isPangram("\"the_quick_brown_fox_jumps_over_the_lazy_dog\""));
    }

    @Ignore
    @Test
    public void pangramWithNumbers() {
        assertTrue(Pangrams.isPangram("\"the 1 quick brown fox jumps over the 2 lazy dogs\""));
    }

    @Ignore
    @Test
    public void missingLettersReplacedByNumbers() {
        assertFalse(Pangrams.isPangram("\"7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog\""));
    }

    @Ignore
    @Test
    public void pangramWithMixedCaseAndPunctuation() {
        assertTrue(Pangrams.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
    }

    @Ignore
    @Test
    public void pangramWithNonAsciiCharacters() {
        assertTrue(Pangrams.isPangram("Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich."));
    }


    @Ignore
    @Test
    public void panagramInAlphabetOtherThanAscii() {
        assertFalse(Pangrams.isPangram("Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства."));
    }
}
