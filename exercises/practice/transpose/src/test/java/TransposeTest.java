import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TransposeTest {
    private Transpose transpose;

    @BeforeEach
    public void setup() {
        transpose = new Transpose();
    }

    @Test
    public void emptyString() {
        assertThat(transpose.transpose("")).isEqualTo("");
    }

    @Disabled("Remove to run test")
    @Test
    public void twoCharactersInARow() {
        assertThat(transpose.transpose("A1"))
            .isEqualTo(
                "A" +
                "\n1");
    }

    @Disabled("Remove to run test")
    @Test
    public void twoCharactersInAColumn() {
        assertThat(
            transpose.transpose(
                "A\n" +
                "1"))
            .isEqualTo("A1");
    }

    @Disabled("Remove to run test")
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

    @Disabled("Remove to run test")
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

    @Disabled("Remove to run test")
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

    @Disabled("Remove to run test")
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

    @Disabled("Remove to run test")
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

    @Disabled("Remove to run test")
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

    @Disabled("Remove to run test")
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

    @Disabled("Remove to run test")
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
    
    @Disabled("Remove to run test")
    @Test
    public void jaggedTriangle() {
        assertThat(
            transpose.transpose(
                "11\n" +
                "2\n" +
                "3333\n" +
                "444\n" +
                "555555\n" +
                "66666"))
            .isEqualTo(
                "123456\n" +
                "1 3456\n" +
                "  3456\n" +
                "  3 56\n" +
                "    56\n" +
                "    5");
    }
}
