import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsogramCheckerTest {

    @Test
    public void testEmptyString() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLowercaseIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("isogram"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testNotIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("eleven"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDuplicateEndAlphabet() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("zzyzx"));
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
    public void testDuplicatMixedCase() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("alphAbet"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testIsogramWithHyphen() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("thumbscrew-japingly"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testIsogramWithDuplicatedHyphen() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("six-year-old"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMadeUpNameThatIsAnIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Emily Jung Schwartzkopf"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDuplicatedCharacterInTheMiddleIsNotIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("accentor"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSameFirstAndLast() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("angola"));
    }

}
