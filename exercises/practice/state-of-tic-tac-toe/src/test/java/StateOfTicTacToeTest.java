package stateoftictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class StateOfTicTacToeTest {

    @Test
    public void testStateOfTicTacToe() {
        for (TestCase c : TestCases.testCases) {
            String description = c.description;
            String[] board = c.board;
            State expected = c.expected;
            boolean wantErr = c.wantErr;

            try {
                State result = StateOfTicTacToe.StateOfTicTacToe(board);

                if (wantErr) {
                    fail(String.format("\n Board: %s \n Expected error but got none", arrayToString(board)));
                }

                assertEquals(String.format("\n Board: %s \n Expected: %s \n Got: %s", arrayToString(board), expected, result), expected, result);
            } catch (Exception e) {
                if (!wantErr) {
                    fail(String.format("\n Board: %s \n Expected no errors but got error: %s", arrayToString(board), e.getMessage()));
                }
            }
        }
    }

    private String arrayToString(String[] array) {
        StringBuilder result = new StringBuilder("[");
        for (String element : array) {
            result.append("\"").append(element).append("\", ");
        }
        if (array.length > 0) {
            result.setLength(result.length() - 2); // Remove trailing comma and space
        }
        result.append("]");
        return result.toString();
    }
}
