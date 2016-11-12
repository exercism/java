public final class BoardCoordinate {

    private final int rank;

    private final int file;

    public BoardCoordinate(final int rank, final int file) throws IllegalArgumentException {
        this.rank = rank;
        this.file = file;

        validateInputs();
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    private void validateInputs() throws IllegalArgumentException {
        validateCoordinateComponent(rank, "rank");
        validateCoordinateComponent(file, "file");
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
