import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsogramCheckerTest {

    @Test
    public void testIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("duplicates"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testNotIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("eleven"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMediumLongIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("subdermatoglyphic"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitive() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("Alphabet"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testIsogramWithHyphen() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("thumbscrew-japingly"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testIgnoresMultipleHyphens() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Hjelmqvist-Gryb-Zock-Pfund-Wax"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWorksWithGermanLetters() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Heizölrückstoßabdämpfung"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testIgnoresSpaces() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("the quick brown fox"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testIgnoresSpaces2() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Emily Jung Schwartzkopf"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDuplicateAccentedLetters() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("éléphant"));
    }

}
