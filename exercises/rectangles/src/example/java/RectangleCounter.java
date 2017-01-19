import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;

final class RectangleCounter {

    int countRectangles(final String[] rawGrid) {
        final int nRows = rawGrid.length;
        if (nRows == 0) return 0;

        final int nCols = rawGrid[0].length();
        if (nCols == 0) return 0;

        return new Grid(nRows, nCols, rawGrid).countRectangles();
    }

    private static final class Grid {

        private enum Entry {
            CORNER,
            HLINE,
            VLINE,
            SPACE;

            private static Entry fromChar(final char rawGridEntry) {
                switch (rawGridEntry) {
                    case '+': return CORNER;
                    case '-': return HLINE;
                    case '|': return VLINE;
                    case ' ': return SPACE;
                    default:  throw new IllegalStateException("Grid entry " + rawGridEntry + " not recognized.");
                }
            }
        }

        private int nRows, nCols;
        private final Entry[][] entries;

        private Grid(final int nRows, final int nCols, final String[] rawGrid) {
            this.nRows = nRows;
            this.nCols = nCols;
            this.entries = new Entry[nRows][nCols];

            for (int nRow = 0; nRow < nRows; nRow++) {
                for (int nCol = 0; nCol < nCols; nCol++) {
                    entries[nRow][nCol] = Entry.fromChar(rawGrid[nRow].charAt(nCol));
                }
            }
        }

        private int countRectangles() {
            int result = 0;

            for (int topRow = 0; topRow < nRows - 1; topRow++) {

                for (int leftCol = 0; leftCol < nCols - 1; leftCol++) {

                    // Only check rectangles that lie below/to the right of our current coordinate:
                    for (int bottomRow = topRow + 1; bottomRow < nRows; bottomRow++) {

                        for (int rightCol = leftCol + 1; rightCol < nCols; rightCol++) {

                            if (formsRectangle(topRow, bottomRow, leftCol, rightCol)) {
                                result++;
                            }
                        }
                    }
                }
            }

            return result;
        }

        private boolean formsRectangle(
                final int topRow,
                final int bottomRow,
                final int leftCol,
                final int rightCol) {

            return entries[topRow][leftCol].equals(Entry.CORNER)
                    && entries[topRow][rightCol].equals(Entry.CORNER)
                    && entries[bottomRow][leftCol].equals(Entry.CORNER)
                    && entries[bottomRow][rightCol].equals(Entry.CORNER)
                    && isHorizontalLineSegment(topRow, leftCol, rightCol)
                    && isHorizontalLineSegment(bottomRow, leftCol, rightCol)
                    && isVerticalLineSegment(leftCol, topRow, bottomRow)
                    && isVerticalLineSegment(rightCol, topRow, bottomRow);
        }

        private boolean isHorizontalLineSegment(final int row, final int leftCol, final int rightCol) {
            return stream(copyOfRange(getRow(row), leftCol, rightCol))
                    .allMatch(entry -> entry.equals(Entry.HLINE) || entry.equals(Entry.CORNER));
        }

        private boolean isVerticalLineSegment(final int col, final int topRow, final int bottomRow) {
            return stream(copyOfRange(getCol(col), topRow, bottomRow))
                    .allMatch(entry -> entry.equals(Entry.VLINE) || entry.equals(Entry.CORNER));
        }

        private Entry[] getRow(final int number) {
            return entries[number];
        }

        private Entry[] getCol(final int number) {
            final Entry[] result = new Entry[nRows];

            for (int nRow = 0; nRow < nRows; nRow++) {
                result[nRow] = entries[nRow][number];
            }

            return result;
        }

    }

}
