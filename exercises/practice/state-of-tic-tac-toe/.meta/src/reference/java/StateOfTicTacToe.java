package stateoftictactoe;

import java.util.Arrays;

public class StateOfTicTacToe {

    // Enum to represent the possible states of the Tic-Tac-Toe game
    public enum State {
        WIN, ONGOING, DRAW
    }

    /**
     * Determines the state of the Tic-Tac-Toe game based on the current board.
     *
     * @param board An array of strings representing the Tic-Tac-Toe board.
     * @return The current state of the game (WIN, ONGOING, or DRAW).
     * @throws IllegalArgumentException If the turn order is incorrect.
     */
    public static State stateOfTicTacToe(String[] board) {
        int xCount = countOccurrences(board, 'X');
        int oCount = countOccurrences(board, 'O');

        // Check for incorrect turn orders
        if (oCount > xCount) {
            throw new IllegalArgumentException("Wrong turn order: O started");
        }

        if (xCount > oCount + 1) {
            throw new IllegalArgumentException("Wrong turn order: X went twice");
        }

        // Check for a win by 'X' or 'O'
        if (checkWin(board, 'X')) {
            return State.WIN;
        }

        if (checkWin(board, 'O')) {
            return State.WIN;
        }

        // Check for an ongoing game or a draw
        if (xCount + oCount < 9) {
            return State.ONGOING;
        }

        return State.DRAW;
    }

    // Helper method to count occurrences of a player ('X' or 'O') in the rows
    private static int countOccurrences(String[] rows, char player) {
        return Arrays.stream(rows).mapToInt(row -> (int) row.chars().filter(ch -> ch == player).count()).sum();
    }

    // Helper method to check for a win by a player ('X' or 'O') in rows, columns, or diagonals
    private static boolean checkWin(String[] board, char player) {
        for (String row : board) {
            if (row.equals(new String(new char[] { player, player, player }))) {
                return true; // Win in a row
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0].charAt(col) == player && board[1].charAt(col) == player && board[2].charAt(col) == player) {
                return true; // Win in a column
            }
        }

        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true; // Win in the main diagonal
        }

        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true; // Win in the other diagonal
        }

        return false;
    }
}
