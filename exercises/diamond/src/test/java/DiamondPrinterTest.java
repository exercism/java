import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class DiamondPrinterTest {

    @Test
    public void testOneByOneDiamond() {
        List<String> output = new DiamondPrinter().printToList('A');
        assertThat(output, is(singletonList("A")));
    }

    @Ignore
    @Test
    public void testTwoByTwoDiamond() {
        List<String> output = new DiamondPrinter().printToList('B');
        assertThat(output, is(asList(" A ",
                                     "B B",
                                     " A ")));
    }

    @Ignore
    @Test
    public void testThreeByThreeDiamond() {
        List<String> output = new DiamondPrinter().printToList('C');
        assertThat(output, is(asList("  A  ",
                                     " B B ",
                                     "C   C",
                                     " B B ",
                                     "  A  ")));
    }

    @Ignore
    @Test
    public void testFiveByFiveDiamond() {
        List<String> output = new DiamondPrinter().printToList('E');
        assertThat(output, is(asList("    A    ",
                                     "   B B   ",
                                     "  C   C  ",
                                     " D     D ",
                                     "E       E",
                                     " D     D ",
                                     "  C   C  ",
                                     "   B B   ",
                                     "    A    ")));
    }

    @Ignore
    @Test
    public void testFullDiamond() {
        List<String> output = new DiamondPrinter().printToList('Z');
        assertThat(output, is(asList("                         A                         ",
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
                                     "                         A                         ")));
    }

}
