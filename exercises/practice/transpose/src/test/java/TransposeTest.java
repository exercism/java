import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

public class TransposeTest {
    private Transpose transpose;

    @Before
    public void setup() {
        transpose = new Transpose();
    }

    @Test
    public void emptyString() {
        assertThat(transpose.transpose("")).isEqualTo("");
    }

    @Ignore("Remove to run test")
    @Test
    public void twoCharactersInARow() {
        assertThat(transpose.transpose("A1"))
            .isEqualTo(
                "A" +
                "\n1");
    }

    @Ignore("Remove to run test")
    @Test
    public void twoCharactersInAColumn() {
        assertThat(
            transpose.transpose(
                "A\n" +
                "1"))
            .isEqualTo("A1");
    }

    @Ignore("Remove to run test")
    @Test
    public void simple() {
        assertThat(
            transpose.transpose(
                "ABC\n" +
                "123"))
            .isEqualTo(
                "A1\n" +
                "B2\n" +
                "C3");
    }

    @Ignore("Remove to run test")
    @Test
    public void singleLine() {
        assertThat(transpose.transpose("Single line."))
            .isEqualTo(
                "S\n" +
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
                ".");
    }

    @Ignore("Remove to run test")
    @Test
    public void firstLineLongerThanSecondLine() {
        assertThat(
            transpose.transpose(
                "The fourth line.\n" +
                "The fifth line."))
            .isEqualTo(
                "TT\n" +
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
                ".");
    }

    @Ignore("Remove to run test")
    @Test
    public void secondLineLongerThanFirstLine() {
        assertThat(
            transpose.transpose(
                "The first line.\n" +
                "The second line."))
            .isEqualTo(
                "TT\n" +
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
                " .");
    }

    @Ignore("Remove to run test")
    @Test
    public void mixedLineLength() {
        assertThat(
            transpose.transpose(
                "The longest line.\n" +
                "A long line.\n" +
                "A longer line.\n" +
                "A line."))
            .isEqualTo(
                "TAAA\n" +
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
                ".");
    }

    @Ignore("Remove to run test")
    @Test
    public void square() {
        assertThat(
            transpose.transpose(
                "HEART\n" +
                "EMBER\n" +
                "ABUSE\n" +
                "RESIN\n" +
                "TREND"))
            .isEqualTo(
                "HEART\n" +
                "EMBER\n" +
                "ABUSE\n" +
                "RESIN\n" +
                "TREND");
    }

    @Ignore("Remove to run test")
    @Test
    public void rectangle() {
        assertThat(
            transpose.transpose(
                "FRACTURE\n" +
                "OUTLINED\n" +
                "BLOOMING\n" +
                "SEPTETTE"))
            .isEqualTo(
                "FOBS\n" +
                "RULE\n" +
                "ATOP\n" +
                "CLOT\n" +
                "TIME\n" +
                "UNIT\n" +
                "RENT\n" +
                "EDGE");
    }

    @Ignore("Remove to run test")
    @Test
    public void triangle() {
        assertThat(
            transpose.transpose(
                "T\n" +
                "EE\n" +
                "AAA\n" +
                "SSSS\n" +
                "EEEEE\n" +
                "RRRRRR"))
            .isEqualTo(
                "TEASER\n" +
                " EASER\n" +
                "  ASER\n" +
                "   SER\n" +
                "    ER\n" +
                "     R");
    }
}
