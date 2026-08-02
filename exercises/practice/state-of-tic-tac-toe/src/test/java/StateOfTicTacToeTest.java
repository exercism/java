package exercises.practice.state_of_tic_tac_toe; // Apne project ke according package line rehne dena agar lagi ho

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StateOfTicTacToeTest {
    private StateOfTicTacToe stateOfTicTacToe;

    @BeforeEach
    public void setup() {
        stateOfTicTacToe = new StateOfTicTacToe();
    }
    
    @Test
    @DisplayName("Finished game where X won via left column victory")
    public void testFinishedGameWhereXWonViaLeftColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOO", "X  ", "X  "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where X won via middle column victory")
    public void testFinishedGameWhereXWonViaMiddleColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OXO", " X ", " X "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where X won via right column victory")
    public void testFinishedGameWhereXWonViaRightColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OOX", "  X", "  X"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where O won via left column victory")
    public void testFinishedGameWhereOWonViaLeftColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OXX", "OX ", "O  "})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where O won via middle column victory")
    public void testFinishedGameWhereOWonViaMiddleColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", " OX", " O "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where O won via right column victory")
    public void testFinishedGameWhereOWonViaRightColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXO", " XO", "  O"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where X won via top row victory")
    public void testFinishedGameWhereXWonViaTopRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXX", "XOO", "O  "})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where X won via middle row victory")
    public void testFinishedGameWhereXWonViaMiddleRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"O  ", "XXX", " O "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where X won via bottom row victory")
    public void testFinishedGameWhereXWonViaBottomRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{" OO", "O X", "XXX"})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where O won via top row victory")
    public void testFinishedGameWhereOWonViaTopRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OOO", "XXO", "XX "})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where O won via middle row victory")
    public void testFinishedGameWhereOWonViaMiddleRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XX ", "OOO", "X  "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where O won via bottom row victory")
    public void testFinishedGameWhereOWonViaBottomRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", " XX", "OOO"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where X won via falling diagonal victory")
    public void testFinishedGameWhereXWonViaFallingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOO", " X ", "  X"})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where X won via rising diagonal victory")
    public void testFinishedGameWhereXWonViaRisingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"O X", "OX ", "X  "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Finished game where O won via falling diagonal victory")
    public void testFinishedGameWhereOWonViaFallingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OXX", "OOX", "X O"})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where O won via rising diagonal victory")
    public void testFinishedGameWhereOWonViaRisingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"  O", " OX", "OXX"})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where X won via a row and a column victory")
    public void testFinishedGameWhereXWonViaARowAndAColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXX", "XOO", "XOO"})
        ).isEqualTo(GameState.WIN);
    }

    @Test
    @DisplayName("Finished game where X won via two diagonal victories")
    public void testFinishedGameWhereXWonViaTwoDiagonalVictories() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", "OXO", "XOX"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Test
    @DisplayName("Drawn games")
    public void testDraw() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", "XXO", "OXO"})
        ).isEqualTo(GameState.DRAW);
    }
    
    @Test
    @DisplayName("Another draw")
    public void testAnotherDraw() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXO", "OXX", "XOO"})
        ).isEqualTo(GameState.DRAW);
    }

    @Test
    @DisplayName("Ongoing game: one move in")
    public void testOngoingGameOneMoveIn() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"   ", "X  ", "   "})
        ).isEqualTo(GameState.ONGOING);
    }
    
    @Test
    @DisplayName("Ongoing game: two moves in")
    public void testOngoingGameTwoMovesIn() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"O  ", " X ", "   "})
        ).isEqualTo(GameState.ONGOING);
    }

    @Test
    @DisplayName("Ongoing game: five moves in")
    public void testOngoingGameFiveMovesIn() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"X  ", " XO", "OX "})
        ).isEqualTo(GameState.ONGOING);
    }

    @Test
    @DisplayName("Invalid board: X went twice")
    public void testInvalidBoardXWentTwice() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"XX ", "   ", "   "}))
            .withMessage("Wrong turn order: X went twice");
    }
    
    @Test
    @DisplayName("Invalid board: O started")
    public void testInvalidBoardOStarted() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"OOX", "   ", "   "}))
            .withMessage("Wrong turn order: O started");
    }

    @Test
    @DisplayName("Invalid board")
    public void testInvalidBoard() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"XXX", "OOO", "   "}))
            .withMessage("Impossible board: game should have ended after the game was won");
    }

    @Test
    @DisplayName("Invalid board: players kept playing after a win")
    public void testInvalidBoardPlayersKeptPlayingAfterAWin() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"XXX", "OOO", "XOX"}))
            .withMessage("Impossible board: game should have ended after the game was won");
    }

    @Test
    @DisplayName("Invalid board: O kept playing after X wins")
    public void testInvalidBoardOKeptPlayingAfterXWins() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"OO ", "XXX", " O "}))
            .withMessage("Impossible board: game should have ended after the game was won");
    }

    @Test
    @DisplayName("Invalid board: X kept playing after O wins")
    public void testInvalidBoardXKeptPlayingAfterOWins() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"XX ", "OOO", " XX"}))
            .withMessage("Impossible board: game should have ended after the game was won");
    }
}

