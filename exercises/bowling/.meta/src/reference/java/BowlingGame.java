import java.util.ArrayList;
import java.util.List;

class BowlingGame {
    private static final int NUMBER_OF_FRAMES = 10;
    private static final int MAXIMUM_FRAME_SCORE = 10;
    private List<Integer> rolls = new ArrayList<>();

    void roll(int pins) {
        rolls.add(pins);
    }

    int score() {
        int score = 0;
        int frameIndex = 0;

        for (int i = 1; i <= NUMBER_OF_FRAMES; i++) {
            if (rolls.size() <= frameIndex) {
                throw new IllegalStateException("Score cannot be taken until the end of the game");
            }

            if (isStrike(frameIndex)) {
                if (rolls.size() <= frameIndex + 2) {
                    throw new IllegalStateException("Score cannot be taken until the end of the game");
                }

                int strikeBonus = strikeBonus(frameIndex);
                if (strikeBonus > MAXIMUM_FRAME_SCORE && !isStrike(frameIndex + 1) || spareBonus(frameIndex) > 10) {
                    throw new IllegalStateException("Pin count exceeds pins on the lane");
                }

                score += 10 + strikeBonus;
                frameIndex += i == NUMBER_OF_FRAMES ? 3 : 1;
            } else if (isSpare(frameIndex)) {
                if (rolls.size() <= frameIndex + 2) {
                    throw new IllegalStateException("Score cannot be taken until the end of the game");
                }

                score += 10 + spareBonus(frameIndex);
                frameIndex += i == NUMBER_OF_FRAMES ? 3 : 2;
            } else {
                int frameScore = frameScore(frameIndex);
                if (frameScore < 0) {
                    throw new IllegalStateException("Negative roll is invalid");
                } else if (frameScore > 10) {
                    throw new IllegalStateException("Pin count exceeds pins on the lane");
                }

                score += frameScore;
                frameIndex += 2;
            }
        }

        if (!correctNumberOfRolls(frameIndex)) {
            throw new IllegalStateException("Cannot roll after game is over");
        }

        return score;
    }

    private boolean correctNumberOfRolls(int frameIndex) {
        return frameIndex == rolls.size();
    }

    private boolean isStrike(int frameIndex) {
        return rolls.get(frameIndex) == MAXIMUM_FRAME_SCORE;
    }

    private boolean isSpare(int frameIndex) {
        return rolls.get(frameIndex) + rolls.get(frameIndex + 1) == MAXIMUM_FRAME_SCORE;
    }

    private int strikeBonus(int frameIndex) {
        return rolls.get(frameIndex + 1) + rolls.get(frameIndex + 2);
    }

    private int spareBonus(int frameIndex) {
        return rolls.get(frameIndex + 2);
    }

    private int frameScore(int frameIndex) {
        return rolls.get(frameIndex) + rolls.get(frameIndex + 1);
    }
}
