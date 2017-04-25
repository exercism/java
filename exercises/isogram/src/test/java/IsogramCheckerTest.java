import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsogramCheckerTest {

    @Test
    public void testIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("duplicates"));
    }

    @Ignore
    @Test
    public void testNotIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("eleven"));
    }

    @Ignore
    @Test
    public void testMediumLongIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("subdermatoglyphic"));
    }

    @Ignore
    @Test
    public void testCaseInsensitive() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("Alphabet"));
    }

    @Ignore
    @Test
    public void testIsogramWithHyphen() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("thumbscrew-japingly"));
    }

    @Ignore
    @Test
    public void testIgnoresMultipleHyphens() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Hjelmqvist-Gryb-Zock-Pfund-Wax"));
    }

    @Ignore
    @Test
    public void testWorksWithGermanLetters() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Heizölrückstoßabdämpfung"));
    }

    @Ignore
    @Test
    public void testIgnoresSpaces() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("the quick brown fox"));
    }

    @Ignore
    @Test
    public void testIgnoresSpaces2() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Emily Jung Schwartzkopf"));
    }

    @Ignore
    @Test
    public void testDuplicateAccentedLetters() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("éléphant"));
    }

}
