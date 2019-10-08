import java.util.Arrays;
import java.util.OptionalInt;

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
        OptionalInt personalBest = Arrays.stream(highScores).max();
        return personalBest.orElse(0);
    }

    int[] personalTopThree() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
