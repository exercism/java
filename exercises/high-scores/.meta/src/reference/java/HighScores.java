class HighScores {
    private final int[] highScores;
    public HighScores(int[] highScores) {
        this.highScores = highScores;
    }

    int[] scores() {
        return highScores;
    }

    int latest() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int personalBest() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int[] personalTopThree() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
