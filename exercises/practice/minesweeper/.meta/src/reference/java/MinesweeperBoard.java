import java.util.ArrayList;
import java.util.List;

final class MinesweeperBoard {

    private static final char MINE_CHAR = '*';

    private static final char SPACE_CHAR = ' ';

    private final List<String> rawRepresentation;

    private final int numberOfRows;

    private final int numberOfColumns;

    MinesweeperBoard(final List<String> rawRepresentation) {
        this.rawRepresentation = rawRepresentation;
        this.numberOfRows = rawRepresentation.size();
        this.numberOfColumns = rawRepresentation.isEmpty() ? 0 : rawRepresentation.get(0).length();
    }

    List<String> withNumbers() {
        final List<String> result = new ArrayList<>();

        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            result.add(getRowWithNumbers(rowNumber));
        }

        return result;
    }

    private String getRowWithNumbers(final int rowNumber) {
        StringBuilder result = new StringBuilder(numberOfColumns);

        for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
            result.append(getCellNumber(rowNumber, columnNumber));
        }

        return result.toString();
    }

    private char getCellNumber(final int rowNumber, final int columnNumber) {
        // If (rowNumber, columnNumber) is a mine, we're done.
        if (rawRepresentation.get(rowNumber).charAt(columnNumber) == MINE_CHAR) {
            return MINE_CHAR;
        }

        final int mineCount = computeMineCountAround(rowNumber, columnNumber);

        // If computed count is positive, add it to the annotated row. Otherwise, add a blank space.
        return mineCount > 0 ? Character.forDigit(mineCount, 10) : SPACE_CHAR;
    }

    private int computeMineCountAround(final int rowNumber, final int columnNumber) {
        int result = 0;

        // Compute row and column ranges to inspect (respecting board edges).
        final int minRowToInspect = Math.max(rowNumber - 1, 0);
        final int maxRowToInspect = Math.min(rowNumber + 1, numberOfRows - 1);
        final int minColToInspect = Math.max(columnNumber - 1, 0);
        final int maxColToInspect = Math.min(columnNumber + 1, numberOfColumns - 1);

        // Count mines in the cells surrounding (row, col).
        for (int rowToInspect = minRowToInspect; rowToInspect <= maxRowToInspect; rowToInspect++) {
            for (int colToInspect = minColToInspect; colToInspect <= maxColToInspect; colToInspect++) {
                if (rawRepresentation.get(rowToInspect).charAt(colToInspect) == MINE_CHAR) {
                    result += 1;
                }
            }
        }

        return result;
    }

}
