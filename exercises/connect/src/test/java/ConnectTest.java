import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConnectTest {

    @Test
    public void testEmptyBoard() {
        String[] board = new String[]{
                ". . . . .",
                " . . . . .",
                "  . . . . .",
                "   . . . . .",
                "    . . . . ."
        };
        assertThat(new Connect().findWinner(board), is(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void testOnlySmallX() {
        String[] board = new String[]{
                "X"
        };
        assertThat(new Connect().findWinner(board), is("X"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testOnlySmallO() {
        String[] board = new String[]{
                "O"
        };
        assertThat(new Connect().findWinner(board), is("O"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testOnlyEdges() {
        String[] board = new String[]{
                "O O O X",
                " X . . X",
                "  X . . X",
                "   X O O O"
        };
        assertThat(new Connect().findWinner(board), is(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void testIllegalDiagonals() {
        String[] board = new String[]{
                "X O . .",
                " O X X X",
                "  O X O .",
                "   . O X .",
                "    X X O O"
        };
        assertThat(new Connect().findWinner(board), is(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdjacentAngles() {
        String[] board = new String[]{
                "X . . .",
                " . X O .",
                "  O . X O",
                "   . O . X",
                "    . . O ."
        };
        assertThat(new Connect().findWinner(board), is(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void testXWins() {
        String[] board = new String[]{
                ". O . .",
                " O X X X",
                "  O X O .",
                "   X X O X",
                "    . O X ."
        };
        assertThat(new Connect().findWinner(board), is("X"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testOWins() {
        String[] board = new String[]{
                ". O . .",
                " O X X X",
                "  O O O .",
                "   X X O X",
                "    . O X ."
        };
        assertThat(new Connect().findWinner(board), is("O"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testXWinsConvoluted() {
        String[] board = new String[]{
                ". X X . .",
                " X . X . X",
                "  . X . X .",
                "   . X X . .",
                "    O O O O O"
        };
        assertThat(new Connect().findWinner(board), is("X"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testXWinsSpiral() {
        String[] board = new String[]{
                "O X X X X X X X X",
                " O X O O O O O O O",
                "  O X O X X X X X O",
                "   O X O X O O O X O",
                "    O X O X X X O X O",
                "     O X O O O X O X O",
                "      O X X X X X O X O",
                "       O O O O O O O X O",
                "        X X X X X X X X O"
        };
        assertThat(new Connect().findWinner(board), is("X"));
    }

}
