final class BoardCoordinate {

    private final int row;

    private final int column;

    BoardCoordinate(final int row, final int column) throws IllegalArgumentException {
        this.row = row;
        this.column = column;

        validateInputs();
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    private void validateInputs() throws IllegalArgumentException {
        validateCoordinateComponent(row, "row");
        validateCoordinateComponent(column, "column");
    }

    private void validateCoordinateComponent(final int value, final String componentName)
            throws IllegalArgumentException {

        if (value < 0) {
            throw new IllegalArgumentException("Coordinate must have positive " + componentName + ".");
        }

        if (value > 7) {
            throw new IllegalArgumentException("Coordinate must have " + componentName + " <= 7.");
        }
    }

}
