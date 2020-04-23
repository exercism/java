import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

public class DiamondPrinterTest {

    private DiamondPrinter diamondPrinter;

    @Before
    public void setUp() {
        diamondPrinter = new DiamondPrinter();
    }

    @Test
    public void testOneByOneDiamond() {
        assertThat(diamondPrinter.printToList('A'))
            .containsExactly("A");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoByTwoDiamond() {
        assertThat(diamondPrinter.printToList('B'))
            .containsExactly(
                " A ",
                "B B",
                " A ");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeByThreeDiamond() {
        assertThat(diamondPrinter.printToList('C'))
            .containsExactly(
                "  A  ",
                " B B ",
                "C   C",
                " B B ",
                "  A  ");
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourByFourDiamond() {
        assertThat(diamondPrinter.printToList('D'))
            .containsExactly(
                "   A   ",
                "  B B  ",
                " C   C ",
                "D     D",
                " C   C ",
                "  B B  ",
                "   A   ");
    }

    @Ignore("Remove to run test")
    @Test
    public void testFullDiamond() {
        assertThat(diamondPrinter.printToList('Z'))
            .containsExactly(
                "                         A                         ",
                "                        B B                        ",
                "                       C   C                       ",
                "                      D     D                      ",
                "                     E       E                     ",
                "                    F         F                    ",
                "                   G           G                   ",
                "                  H             H                  ",
                "                 I               I                 ",
                "                J                 J                ",
                "               K                   K               ",
                "              L                     L              ",
                "             M                       M             ",
                "            N                         N            ",
                "           O                           O           ",
                "          P                             P          ",
                "         Q                               Q         ",
                "        R                                 R        ",
                "       S                                   S       ",
                "      T                                     T      ",
                "     U                                       U     ",
                "    V                                         V    ",
                "   W                                           W   ",
                "  X                                             X  ",
                " Y                                               Y ",
                "Z                                                 Z",
                " Y                                               Y ",
                "  X                                             X  ",
                "   W                                           W   ",
                "    V                                         V    ",
                "     U                                       U     ",
                "      T                                     T      ",
                "       S                                   S       ",
                "        R                                 R        ",
                "         Q                               Q         ",
                "          P                             P          ",
                "           O                           O           ",
                "            N                         N            ",
                "             M                       M             ",
                "              L                     L              ",
                "               K                   K               ",
                "                J                 J                ",
                "                 I               I                 ",
                "                  H             H                  ",
                "                   G           G                   ",
                "                    F         F                    ",
                "                     E       E                     ",
                "                      D     D                      ",
                "                       C   C                       ",
                "                        B B                        ",
                "                         A                         ");
    }

}
