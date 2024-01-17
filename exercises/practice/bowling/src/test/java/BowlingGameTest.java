import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BowlingGameTest {
    private BowlingGame game = new BowlingGame();

    private void playGame(int[] rolls) {
        for (int pins : rolls) {
            game.roll(pins);
        }
    }

    @Test
    public void shouldBeAbleToScoreAGameWithAllZeros() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isZero();
    }

    @Disabled("Remove to run test")
    @Test
    public void shouldBeAbleToScoreAGameWithNoStrikesOrSpares() {
        int[] rolls = {3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(90);
    }

    @Disabled("Remove to run test")
    @Test
    public void aSpareFollowedByZerosIsWorthTenPoints() {
        int[] rolls = {6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    public void pointsScoredInTheRollAfterASpareAreCountedTwice() {
        int[] rolls = {6, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(16);
    }

    @Disabled("Remove to run test")
    @Test
    public void consecutiveSparesEachGetAOneRollBonus() {
        int[] rolls = {5, 5, 3, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(31);
    }

    @Disabled("Remove to run test")
    @Test
    public void aSpareInTheLastFrameGetsAOneRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 7};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(17);
    }

    @Disabled("Remove to run test")
    @Test
    public void aStrikeEarnsTenPointsInFrameWithASingleRoll() {
        int[] rolls = {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    public void pointsScoredInTheTwoRollsAfterAStrikeAreCountedTwiceAsABonus() {
        int[] rolls = {10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(26);
    }

    @Disabled("Remove to run test")
    @Test
    public void consecutiveStrikesEachGetTheTwoRollBonus() {
        int[] rolls = {10, 10, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(81);
    }

    @Disabled("Remove to run test")
    @Test
    public void aStrikeInTheLastFrameGetsATwoRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 1};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(18);
    }

    @Disabled("Remove to run test")
    @Test
    public void rollingASpareWithTheTwoRollBonusDoesNotGetABonusRoll() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 3};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(20);
    }

    @Disabled("Remove to run test")
    @Test
    public void strikesWithTheTwoRollBonusDoNotGetBonusRolls() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(30);
    }

    @Disabled("Remove to run test")
    @Test
    public void lastTwoStrikesFollowedByOnlyLastBonusWithNonStrikePoints() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 1};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(31);
    }

    @Disabled("Remove to run test")
    @Test
    public void aStrikeWithTheOneRollBonusAfterASpareInTheLastFrameDoesNotGetABonus() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(20);
    }

    @Disabled("Remove to run test")
    @Test
    public void allStrikesIsAPerfectGame() {
        int[] rolls = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(300);
    }

    @Disabled("Remove to run test")
    @Test
    public void rollsCanNotScoreNegativePoints() {
        int[] rolls = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Negative roll is invalid");
    }

    @Disabled("Remove to run test")
    @Test
    public void aRollCanNotScoreMoreThan10Points() {
        int[] rolls = {11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    public void twoRollsInAFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    public void bonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5, 6};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanScoreMoreThan10PointsIfOneIsAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 6};

        playGame(rolls);

        assertThat(game.score()).isEqualTo(26);
    }

    @Disabled("Remove to run test")
    @Test
    public void theSecondBonusRollsAfterAStrikeInTheLastFrameCanNotBeAStrikeIfTheFirstOneIsNotAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 10};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    public void secondBonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 11};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    public void anUnstartedGameCanNotBeScored() {
        int[] rolls = new int[0];

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    public void anIncompleteGameCanNotBeScored() {
        int[] rolls = {0, 0};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    public void canNotRollIfGameAlreadyHasTenFrames() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Cannot roll after game is over");
    }

    @Disabled("Remove to run test")
    @Test
    public void bonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    public void bothBonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    public void bonusRollForASpareInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    public void canNotRollAfterBonusRollForSpare() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 2, 2};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Cannot roll after game is over");
    }

    @Disabled("Remove to run test")
    @Test
    public void canNotRollAfterBonusRollForStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 3, 2, 2};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Cannot roll after game is over");
    }
}
