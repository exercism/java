final class QueenAttackCalculator {

    private final BoardCoordinate whiteQueenCoordinate;

    private final BoardCoordinate blackQueenCoordinate;

    QueenAttackCalculator(final BoardCoordinate whiteQueenCoordinate, final BoardCoordinate blackQueenCoordinate)
            throws IllegalArgumentException {

        this.whiteQueenCoordinate = whiteQueenCoordinate;
        this.blackQueenCoordinate = blackQueenCoordinate;

        validateInputs();
    }

    boolean canQueensAttackOneAnother() {
        return queensShareColumn() || queensShareRow() || queensShareDiagonal();
    }

    private void validateInputs() throws IllegalArgumentException {
        if (whiteQueenCoordinate == null || blackQueenCoordinate == null) {
            throw new IllegalArgumentException("You must supply valid board coordinates for both Queens.");
        }

        if (queensShareBoardCoordinate()) {
            throw new IllegalArgumentException("Queens may not occupy the same board coordinate.");
        }
    }

    private boolean queensShareRow() {
        return differenceBetweenRows() == 0;
    }

    private boolean queensShareColumn() {
        return differenceBetweenColumns() == 0;
    }

    private boolean queensShareBoardCoordinate() {
        return queensShareRow() && queensShareColumn();
    }

    private boolean queensShareDiagonal() {
        return differenceBetweenRows() == differenceBetweenColumns();
    }

    private int differenceBetweenRows() {
        return Math.abs(whiteQueenCoordinate.getRow() - blackQueenCoordinate.getRow());
    }

    private int differenceBetweenColumns() {
        return Math.abs(whiteQueenCoordinate.getColumn() - blackQueenCoordinate.getColumn());
    }

}
