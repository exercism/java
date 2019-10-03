class Connect {
    String findWinner(String[] board) {
        // parse
        String[][] values = new String[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            values[i] = board[i].substring(i).split(" ");
        }

        int lineCount = values.length,
            columnCount = values[0].length;

        // mark starting points
        // O starts at the top
        for (int i = 0; i < columnCount; i++) {
            if (values[0][i].equals("O")) values[0][i] = "o";
        }
        // X starts on the left
        for (int i = 0; i < lineCount; i++) {
            if (values[i][0].equals("X")) values[i][0] = "x";
        }


        // go through and connect
        boolean changes;
        do {
            changes = false;
            for (int line = 0; line < lineCount && !changes; line++) {
                for (int column = 0; column < columnCount && !changes; column++) {
                    if (values[line][column].equals("O") && checkSurroundingsFor(values, line, column, "o")) {
                        values[line][column] = "o";
                        changes = true;
                    } else if (values[line][column].equals("X") && checkSurroundingsFor(values, line, column, "x")) {
                        values[line][column] = "x";
                        changes = true;
                    }
                }
            }
        } while (changes);

        // check for winner
        String winner = "";
        // O wins at the bottom
        for (int i = 0; i < columnCount; i++) {
            if (values[lineCount - 1][i].equals("o")) winner = "O";
        }
        // X wins on the right
        for (int i = 0; i < lineCount; i++) {
            if (values[i][columnCount - 1].equals("x")) winner = "X";
        }

        return winner;
    }

    boolean checkSurroundingsFor(String[][] values, int line, int column, String character) {
        boolean isFirstLine = line == 0,
                isLastLine = line == values.length - 1,
                isFirstColumn = column == 0,
                isLastColumn = column == values[0].length - 1;

        // top left
        if (!isFirstLine && values[line - 1][column].equals(character)) return true;
        // top right
        if (!isFirstLine && !isLastColumn && values[line - 1][column + 1].equals(character)) return true;
        // left
        if (!isFirstColumn && values[line][column - 1].equals(character)) return true;
        // right
        if (!isLastColumn && values[line][column + 1].equals(character)) return true;
        // bottom left
        if (!isLastLine && !isFirstColumn && values[line + 1][column - 1].equals(character)) return true;
        // bottom right
        if (!isLastLine && values[line + 1][column].equals(character)) return true;
        // no match
        return false;
    }
}