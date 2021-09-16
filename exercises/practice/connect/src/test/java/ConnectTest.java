import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConnectTest {

    private Connect cut;

    @Before
    public void initialize() {
        cut = new Connect();
    }

    @Test
    public void anEmptyBoardHasNoWinner() {

        //GIVEN
        var board = new String[]{
                ". . . . .",
                " . . . . .",
                "  . . . . .",
                "   . . . . .",
                "    . . . . ."
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.NONE, winner);
    }

    @Ignore("Remove to run test")
    @Test
    public void xCanWinOnA1x1Board() {

        //GIVEN
        var board = new String[]{
                "X"
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.PLAYER_X, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void oCanWinOnA1x1Board() {

        //GIVEN
        var board = new String[]{
                "O"
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.PLAYER_O, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void onlyEdgesDoesNotMakeAWinner() {

        //GIVEN
        var board = new String[]{
                "O O O X",
                " X . . X",
                "  X . . X",
                "   X O O O"
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.NONE, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void illegalDiagonalDoesNotMakeAWinner() {

        //GIVEN
        var board = new String[]{
                "X O . .",
                " O X X X",
                "  O X O .",
                "   . O X .",
                "    X X O O"
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.NONE, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void nobodyWinsCrossingAdjacentAngles() {

        //GIVEN
        var board = new String[]{
                "X . . .",
                " . X O .",
                "  O . X O",
                "   . O . X",
                "    . . O ."
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.NONE, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void xWinsCrossingFromLeftToRight() {

        //GIVEN
        var board = new String[]{
                ". O . .",
                " O X X X",
                "  O X O .",
                "   X X O X",
                "    . O X ."
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.PLAYER_X, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void oWinsCrossingFromTopToBottom() {

        //GIVEN
        var board = new String[]{
                ". O . .",
                " O X X X",
                "  O O O .",
                "   X X O X",
                "    . O X ."
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.PLAYER_O, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void xWinsUsingConvolutedPath() {

        //GIVEN
        var board = new String[]{
                ". X X . .",
                " X . X . X",
                "  . X . X .",
                "   . X X . .",
                "    O O O O O"
        };

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.PLAYER_X, winner);

    }

    @Ignore("Remove to run test")
    @Test
    public void xWinsUsingASpiralPath() {

        //GIVEN
        var board = new String[]{
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

        //WHEN
        var winner = cut.computeWinner(board);

        //THEN
        assertEquals(Connect.Winner.PLAYER_X, winner);

    }
}
