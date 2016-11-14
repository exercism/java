public final class QueenAttackCalculator {

    private final BoardCoordinate whiteQueenCoordinate;

    private final BoardCoordinate blackQueenCoordinate;

    public QueenAttackCalculator(final BoardCoordinate whiteQueenCoordinate, final BoardCoordinate blackQueenCoordinate)
            throws IllegalArgumentException {

        this.whiteQueenCoordinate = whiteQueenCoordinate;
        this.blackQueenCoordinate = blackQueenCoordinate;

        validateInputs();
    }

    public boolean canQueensAttackOneAnother() {
        return queensShareFile() || queensShareRank() || queensShareDiagonal();
    }

    private void validateInputs() throws IllegalArgumentException {
        if (whiteQueenCoordinate == null || blackQueenCoordinate == null) {
            throw new IllegalArgumentException("You must supply valid board coordinates for both Queens.");
        }

        if (queensShareBoardCoordinate()) {
            throw new IllegalArgumentException("Queens may not occupy the same board coordinate.");
        }
    }

    private boolean queensShareRank() {
        return differenceBetweenRanks() == 0;
    }

    private boolean queensShareFile() {
        return differenceBetweenFiles() == 0;
    }

    private boolean queensShareBoardCoordinate() {
        return queensShareRank() && queensShareFile();
    }

    private boolean queensShareDiagonal() {
        return differenceBetweenRanks() == differenceBetweenFiles();
    }

    private int differenceBetweenRanks() {
        return Math.abs(whiteQueenCoordinate.getRank() - blackQueenCoordinate.getRank());
    }

    private int differenceBetweenFiles() {
        return Math.abs(whiteQueenCoordinate.getFile() - blackQueenCoordinate.getFile());
    }

}
