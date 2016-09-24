import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PangramTest {


    @Test
    public void emptySentence() {
        assertFalse(Pangrams.isPangram(""));
    }

    @Ignore
    @Test
    public void testLowercasePangram() {
        assertTrue(Pangrams.isPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Ignore
    @Test
    public void missingCharacterX() {
        assertFalse(Pangrams.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
    }

    @Ignore
    @Test
    public void mixedCaseAndPunctuation() {
        assertTrue(Pangrams.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
    }

    @Ignore
    @Test
    public void nonAsciiCharacters() {
        assertTrue(Pangrams.isPangram("Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich."));
    }

}
