import java.util.Arrays;

class HighScores {
    private final int[] highScores;
    public HighScores(int[] highScores) {
        this.highScores = highScores;
    }

    int[] scores() {
        return highScores;
    }

    int latest() {
        return highScores[highScores.length - 1];
    }

    int personalBest() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int[] personalTopThree() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
