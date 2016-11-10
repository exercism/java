import java.util.Arrays;

public final class QueenAttackCalculator {

    private final int[] queen1Coordinates;

    private final int[] queen2Coordinates;

    public QueenAttackCalculator(final int[] queen1Coordinates, final int[] queen2Coordinates)
            throws IllegalArgumentException {

        this.queen1Coordinates = queen1Coordinates;
        this.queen2Coordinates = queen2Coordinates;

        validateInputs();
    }

    public boolean canQueensAttackOneAnother() {
        return queensShareFile() || queensShareRank() || queensShareDiagonal();
    }

    private void validateInputs() throws IllegalArgumentException {
        if (queen1Coordinates == null
                || queen2Coordinates == null
                || queen1Coordinates.length != 2
                || queen2Coordinates.length != 2) {

            throw new IllegalArgumentException("You must supply valid 2-dimensional coordinate arrays for both Queens.");
        }

        final int[] rankCoordinates = new int[2];
        rankCoordinates[0] = queen1Coordinates[0];
        rankCoordinates[1] = queen2Coordinates[0];
        Arrays.sort(rankCoordinates);

        if (rankCoordinates[0] < 0) {
            throw new IllegalArgumentException("Queens must both have positive rank.");
        }

        if (rankCoordinates[1] > 7) {
            throw new IllegalArgumentException("Queens must both have rank <= 7.");
        }

        final int[] fileCoordinates = new int[2];
        fileCoordinates[0] = queen1Coordinates[1];
        fileCoordinates[1] = queen2Coordinates[1];
        Arrays.sort(fileCoordinates);

        if (fileCoordinates[0] < 0) {
            throw new IllegalArgumentException("Queens must both have positive file.");
        }

        if (fileCoordinates[1] > 7) {
            throw new IllegalArgumentException("Queens must both have file <= 7.");
        }

        if (queensShareSquare()) {
            throw new IllegalArgumentException("Queens must not occupy the same square.");
        }
    }

    private boolean queensShareRank() {
        return differenceBetweenRanks() == 0;
    }

    private boolean queensShareFile() {
        return differenceBetweenFiles() == 0;
    }

    private boolean queensShareSquare() {
        return queensShareRank() && queensShareFile();
    }

    private boolean queensShareDiagonal() {
        return differenceBetweenRanks() == differenceBetweenFiles();
    }

    private int differenceBetweenRanks() {
        return Math.abs(queen1Coordinates[0] - queen2Coordinates[0]);
    }

    private int differenceBetweenFiles() {
        return Math.abs(queen1Coordinates[1] - queen2Coordinates[1]);
    }

}
