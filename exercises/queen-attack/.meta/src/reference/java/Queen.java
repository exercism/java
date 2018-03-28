final class Queen {

    private final int row;

    private final int column;

    Queen(final int row, final int column) throws IllegalArgumentException {
        this.row = row;
        this.column = column;

        validatePosition();
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    private void validatePosition() throws IllegalArgumentException {
        validatePositionComponent(row, "row");
        validatePositionComponent(column, "column");
    }

    private void validatePositionComponent(final int value, final String componentName)
            throws IllegalArgumentException {

        if (value < 0) {
            throw new IllegalArgumentException("Queen position must have positive " + componentName + ".");
        }

        if (value > 7) {
            throw new IllegalArgumentException("Queen position must have " + componentName + " <= 7.");
        }
    }

}
