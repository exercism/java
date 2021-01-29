import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;

final class RectangleCounter {

    int countRectangles(final String[] rawGrid) {
        final int nRows = rawGrid.length;
        if (nRows == 0) {
            return 0;
        }
        final int nCols = rawGrid[0].length();
        if (nCols == 0) {
            return 0;
        }
        return new Grid(nRows, nCols, rawGrid).countRectangles();
    }

    private static final class Grid {

        private enum Tile {
            CORNER,
            HORIZONTAL_WALL,
            VERTICAL_WALL,
            SPACE;

            private static Tile fromChar(final char rawGridTile) {
                switch (rawGridTile) {
                    case '+': return CORNER;
                    case '-': return HORIZONTAL_WALL;
                    case '|': return VERTICAL_WALL;
                    case ' ': return SPACE;
                    default:  throw new IllegalStateException("Grid tile " + rawGridTile + " not recognized.");
                }
            }

            private boolean isHorizontalConnector() {
                return this == CORNER || this == HORIZONTAL_WALL;
            }

            private boolean isVerticalConnector() {
                return this == CORNER || this == VERTICAL_WALL;
            }
        }

        private int nRows, nCols;
        private final Tile[][] tiles;

        private Grid(final int nRows, final int nCols, final String[] rawGrid) {
            this.nRows = nRows;
            this.nCols = nCols;
            this.tiles = new Tile[nRows][nCols];

            for (int nRow = 0; nRow < nRows; nRow++) {
                for (int nCol = 0; nCol < nCols; nCol++) {
                    tiles[nRow][nCol] = Tile.fromChar(rawGrid[nRow].charAt(nCol));
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

            return tiles[topRow][leftCol].equals(Tile.CORNER)
                    && tiles[topRow][rightCol].equals(Tile.CORNER)
                    && tiles[bottomRow][leftCol].equals(Tile.CORNER)
                    && tiles[bottomRow][rightCol].equals(Tile.CORNER)
                    && isHorizontalLineSegment(topRow, leftCol, rightCol)
                    && isHorizontalLineSegment(bottomRow, leftCol, rightCol)
                    && isVerticalLineSegment(leftCol, topRow, bottomRow)
                    && isVerticalLineSegment(rightCol, topRow, bottomRow);
        }

        private boolean isHorizontalLineSegment(final int row, final int leftCol, final int rightCol) {
            return stream(copyOfRange(getRow(row), leftCol, rightCol))
                    .allMatch(Tile::isHorizontalConnector);
        }

        private boolean isVerticalLineSegment(final int col, final int topRow, final int bottomRow) {
            return stream(copyOfRange(getCol(col), topRow, bottomRow))
                    .allMatch(Tile::isVerticalConnector);
        }

        private Tile[] getRow(final int number) {
            return tiles[number];
        }

        private Tile[] getCol(final int number) {
            final Tile[] result = new Tile[nRows];

            for (int nRow = 0; nRow < nRows; nRow++) {
                result[nRow] = tiles[nRow][number];
            }

            return result;
        }

    }

}
