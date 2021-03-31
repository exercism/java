import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsogramCheckerTest {

    @Test
    public void testEmptyString() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram(""));
    }

    @Test
    public void testLowercaseIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("isogram"));
    }

    @Test
    public void testNotIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("eleven"));
    }

    @Test
    public void testDuplicateEndAlphabet() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("zzyzx"));
    }

    @Test
    public void testMediumLongIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("subdermatoglyphic"));
    }

    @Test
    public void testCaseInsensitive() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("Alphabet"));
    }

    @Test
    public void testDuplicatMixedCase() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("alphAbet"));
    }

    @Test
    public void testIsogramWithHyphen() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("thumbscrew-japingly"));
    }

    @Test
    public void testIsogramWithDuplicatedCharAfterHyphen() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("thumbscrew-jappingly"));
    }

    @Test
    public void testIsogramWithDuplicatedHyphen() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("six-year-old"));
    }

    @Test
    public void testMadeUpNameThatIsAnIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertTrue(iso.isIsogram("Emily Jung Schwartzkopf"));
    }

    @Test
    public void testDuplicatedCharacterInTheMiddleIsNotIsogram() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("accentor"));
    }

    @Test
    public void testSameFirstAndLast() {
        IsogramChecker iso = new IsogramChecker();
        assertFalse(iso.isIsogram("angola"));
    }

}
