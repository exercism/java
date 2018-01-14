import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class TransposeTest {
    private Transpose transpose;

    @Before
    public void setup() {
        transpose = new Transpose();
    }

    @Test
    public void emptyString() {
        String input = "";

        String expected = "";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoCharactersInARow() {
        String input = "A1";

        String expected = "A" +
                          "\n1";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoCharactersInAColumn() {
        String input = "A\n" +
                       "1";

        String expected = "A1";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void simple() {
        String input = "ABC\n" +
                       "123";

        String expected = "A1\n" +
                          "B2\n" +
                          "C3";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void singleLine() {
        String input = "Single line.";

        String expected = "S\n" +
                          "i\n" +
                          "n\n" +
                          "g\n" +
                          "l\n" +
                          "e\n" +
                          " \n" +
                          "l\n" +
                          "i\n" +
                          "n\n" +
                          "e\n" +
                          ".";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void firstLineLongerThanSecondLine() {
        String input = "The fourth line.\n" +
                       "The fifth line.";

        String expected = "TT\n" +
                          "hh\n" +
                          "ee\n" +
                          "  \n" +
                          "ff\n" +
                          "oi\n" +
                          "uf\n" +
                          "rt\n" +
                          "th\n" +
                          "h \n" +
                          " l\n" +
                          "li\n" +
                          "in\n" +
                          "ne\n" +
                          "e.\n" +
                          ".";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void secondLineLongerThanFirstLine() {
        String input = "The first line.\n" +
                       "The second line.";

        String expected = "TT\n" +
                          "hh\n" +
                          "ee\n" +
                          "  \n" +
                          "fs\n" +
                          "ie\n" +
                          "rc\n" +
                          "so\n" +
                          "tn\n" +
                          " d\n" +
                          "l \n" +
                          "il\n" +
                          "ni\n" +
                          "en\n" +
                          ".e\n" +
                          " .";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void mixedLineLength() {
        String input = "The longest line.\n" +
                       "A long line.\n" +
                       "A longer line.\n" +
                       "A line.";

        String expected = "TAAA\n" +
                          "h   \n" +
                          "elll\n" +
                          " ooi\n" +
                          "lnnn\n" +
                          "ogge\n" +
                          "n e.\n" +
                          "glr\n" +
                          "ei \n" +
                          "snl\n" +
                          "tei\n" +
                          " .n\n" +
                          "l e\n" +
                          "i .\n" +
                          "n\n" +
                          "e\n" +
                          ".";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void square() {
        String input = "HEART\n" +
                       "EMBER\n" +
                       "ABUSE\n" +
                       "RESIN\n" +
                       "TREND";

        String expected = "HEART\n" +
                          "EMBER\n" +
                          "ABUSE\n" +
                          "RESIN\n" +
                          "TREND";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void rectangle() {
        String input = "FRACTURE\n" +
                       "OUTLINED\n" +
                       "BLOOMING\n" +
                       "SEPTETTE";

        String expected = "FOBS\n" +
                          "RULE\n" +
                          "ATOP\n" +
                          "CLOT\n" +
                          "TIME\n" +
                          "UNIT\n" +
                          "RENT\n" +
                          "EDGE";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void triangle() {
        String input = "T\n" +
                       "EE\n" +
                       "AAA\n" +
                       "SSSS\n" +
                       "EEEEE\n" +
                       "RRRRRR";

        String expected = "TEASER\n" +
                          " EASER\n" +
                          "  ASER\n" +
                          "   SER\n" +
                          "    ER\n" +
                          "     R";

        assertEquals(expected, transpose.transpose(input));
    }

}
