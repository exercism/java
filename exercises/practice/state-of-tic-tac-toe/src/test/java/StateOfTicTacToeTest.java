import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    public void testFinishedGameWhereXWonViaLeftColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOO", "X  ", "X  "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaMiddleColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OXO", " X ", " X "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaRightColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OOX", "  X", "  X"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaLeftColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OXX", "OX ", "O  "})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaMiddleColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", " OX", " O "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaRightColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXO", " XO", "  O"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaTopRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXX", "XOO", "O  "})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaMiddleRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"O  ", "XXX", " O "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaBottomRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{" OO", "O X", "XXX"})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaTopRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OOO", "XXO", "XX "})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaMiddleRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XX ", "OOO", "X  "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaBottomRowVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", " XX", "OOO"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaFallingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOO", " X ", "  X"})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaRisingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"O X", "OX ", "X  "})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaFallingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"OXX", "OOX", "X O"})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereOWonViaRisingDiagonalVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"  O", " OX", "OXX"})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaARowAndAColumnVictory() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXX", "XOO", "XOO"})
        ).isEqualTo(GameState.WIN);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFinishedGameWhereXWonViaTwoDiagonalVictories() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", "OXO", "XOX"})
        ).isEqualTo(GameState.WIN);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testDraw() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XOX", "XXO", "OXO"})
        ).isEqualTo(GameState.DRAW);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testAnotherDraw() {
        
        assertThat(
            stateOfTicTacToe.determineState(new String[]{"XXO", "OXX", "XOO"})
        ).isEqualTo(GameState.DRAW);
    }

    @Disabled("Remove to run test")
    @Test
    public void testOngoingGameOneMoveIn() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"   ", "X  ", "   "})
        ).isEqualTo(GameState.ONGOING);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testOngoingGameTwoMovesIn() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"O  ", " X ", "   "})
        ).isEqualTo(GameState.ONGOING);
    }

    @Disabled("Remove to run test")
    @Test
    public void testOngoingGameFiveMovesIn() {

        assertThat(
            stateOfTicTacToe.determineState(new String[]{"X  ", " XO", "OX "})
        ).isEqualTo(GameState.ONGOING);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInvalidBoardXWentTwice() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"XX ", "   ", "   "}))
            .withMessage("Wrong turn order: X went twice");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testInvalidBoardOStarted() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"OOX", "   ", "   "}))
            .withMessage("Wrong turn order: O started");
    }

    @Disabled("Remove to run test")
    @Test
    public void testInvalidBoard() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"XXX", "OOO", "   "}))
            .withMessage("Impossible board: game should have ended after the game was won");
    }

    @Disabled("Remove to run test")
    @Test
    public void testInvalidBoardPlayersKeptPlayingAfterAWin() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> stateOfTicTacToe.determineState(new String[]{"XXX", "OOO", "XOX"}))
            .withMessage("Impossible board: game should have ended after the game was won");
    }
}
