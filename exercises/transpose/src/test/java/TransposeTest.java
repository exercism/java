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
    public void twoCharsInARow() {
        String input = "A1";

        String expected = "A" +
                          "\n1";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoCharsInAColumn() {
        String input = "A\n" +
                       "1";

        String expected = "A1";

        assertEquals(expected, transpose.transpose(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void simpleMatrix() {
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
    public void firstLineLongerThanSecond() {
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
    public void secondLineLongerThanFirst() {
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

    @Ignore("Remove to run test")
    @Test
    public void manyLines() {
        String input = "Chor. Two households, both alike in dignity,\n" +
                       "In fair Verona, where we lay our scene,\n" +
                       "From ancient grudge break to new mutiny,\n" +
                       "Where civil blood makes civil hands unclean.\n" +
                       "From forth the fatal loins of these two foes\n" +
                       "A pair of star-cross'd lovers take their life;\n" +
                       "Whose misadventur'd piteous overthrows\n" +
                       "Doth with their death bury their parents' strife.\n" +
                       "The fearful passage of their death-mark'd love,\n" +
                       "And the continuance of their parents' rage,\n" +
                       "Which, but their children's end, naught could remove,\n" +
                       "Is now the two hours' traffic of our stage;\n" +
                       "The which if you with patient ears attend,\n" +
                       "What here shall miss, our toil shall strive to mend.";

        String expected = "CIFWFAWDTAWITW\n" +
                          "hnrhr hohnhshh\n" +
                          "o oeopotedi ea\n" +
                          "rfmrmash  cn t\n" +
                          ".a e ie fthow \n" +
                          " ia fr weh,whh\n" +
                          "Trnco miae  ie\n" +
                          "w ciroitr btcr\n" +
                          "oVivtfshfcuhhe\n" +
                          " eeih a uote  \n" +
                          "hrnl sdtln  is\n" +
                          "oot ttvh tttfh\n" +
                          "un bhaeepihw a\n" +
                          "saglernianeoyl\n" +
                          "e,ro -trsui ol\n" +
                          "h uofcu sarhu \n" +
                          "owddarrdan o m\n" +
                          "lhg to'egccuwi\n" +
                          "deemasdaeehris\n" +
                          "sr als t  ists\n" +
                          ",ebk 'phool'h,\n" +
                          "  reldi ffd   \n" +
                          "bweso tb  rtpo\n" +
                          "oea ileutterau\n" +
                          "t kcnoorhhnatr\n" +
                          "hl isvuyee'fi \n" +
                          " atv es iisfet\n" +
                          "ayoior trr ino\n" +
                          "l  lfsoh  ecti\n" +
                          "ion   vedpn  l\n" +
                          "kuehtteieadoe \n" +
                          "erwaharrar,fas\n" +
                          "   nekt te  rh\n" +
                          "ismdsehphnnosa\n" +
                          "ncuse ra-tau l\n" +
                          " et  tormsural\n" +
                          "dniuthwea'g t \n" +
                          "iennwesnr hsts\n" +
                          "g,ycoi tkrttet\n" +
                          "n ,l r s'a anr\n" +
                          "i  ef  'dgcgdi\n" +
                          "t  aol   eoe,v\n" +
                          "y  nei sl,u; e\n" +
                          ",  .sf to l   \n" +
                          "     e rv d  t\n" +
                          "     ; ie    o\n" +
                          "       f, r   \n" +
                          "       e  e  m\n" +
                          "       .  m  e\n" +
                          "          o  n\n" +
                          "          v  d\n" +
                          "          e  .\n" +
                          "          ,";

        assertEquals(expected, transpose.transpose(input));
    }
}
