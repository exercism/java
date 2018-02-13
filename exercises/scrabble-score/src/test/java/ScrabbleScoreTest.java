import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScrabbleScoreTest {

    private Scrabble scrabble;

    @Test
    public void testALowerCaseLetter() {
        scrabble = new Scrabble("a");
        assertEquals(1, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAUpperCaseLetter() {
        scrabble = new Scrabble("A");
        assertEquals(1, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAValuableLetter() {
        scrabble = new Scrabble("f");
        assertEquals(4, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAShortWord() {
        scrabble = new Scrabble("at");
        assertEquals(2, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAShortValuableWord() {
        scrabble = new Scrabble("zoo");
        assertEquals(12, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAMediumWord() {
        scrabble = new Scrabble("street");
        assertEquals(6, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAMediumValuableWord() {
        scrabble = new Scrabble("quirky");
        assertEquals(22, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testALongMixCaseWord() {
        scrabble = new Scrabble("OxyphenButazone");
        assertEquals(41, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAEnglishLikeWord() {
        scrabble = new Scrabble("pinata");
        assertEquals(8, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAnEmptyInput() {
        scrabble = new Scrabble("");
        assertEquals(0, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testEntireAlphabetAvailable() {
        scrabble = new Scrabble("abcdefghijklmnopqrstuvwxyz");
        assertEquals(87, scrabble.getScore());
    }

}
