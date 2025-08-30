import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("should be able to score a game with all zeros")
    public void shouldBeAbleToScoreAGameWithAllZeros() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isZero();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("should be able to score a game with no strikes or spares")
    public void shouldBeAbleToScoreAGameWithNoStrikesOrSpares() {
        int[] rolls = {3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(90);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a spare followed by zeros is worth ten points")
    public void aSpareFollowedByZerosIsWorthTenPoints() {
        int[] rolls = {6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("points scored in the roll after a spare are counted twice")
    public void pointsScoredInTheRollAfterASpareAreCountedTwice() {
        int[] rolls = {6, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(16);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("consecutive spares each get a one roll bonus")
    public void consecutiveSparesEachGetAOneRollBonus() {
        int[] rolls = {5, 5, 3, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(31);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a spare in the last frame gets a one roll bonus that is counted once")
    public void aSpareInTheLastFrameGetsAOneRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 7};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(17);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a strike earns ten points in a frame with a single roll")
    public void aStrikeEarnsTenPointsInFrameWithASingleRoll() {
        int[] rolls = {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("points scored in the two rolls after a strike are counted twice as a bonus")
    public void pointsScoredInTheTwoRollsAfterAStrikeAreCountedTwiceAsABonus() {
        int[] rolls = {10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(26);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("consecutive strikes each get the two roll bonus")
    public void consecutiveStrikesEachGetTheTwoRollBonus() {
        int[] rolls = {10, 10, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(81);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a strike in the last frame gets a two roll bonus that is counted once")
    public void aStrikeInTheLastFrameGetsATwoRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 1};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(18);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("rolling a spare with the two roll bonus does not get a bonus roll")
    public void rollingASpareWithTheTwoRollBonusDoesNotGetABonusRoll() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 3};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(20);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("strikes with the two roll bonus do not get bonus rolls")
    public void strikesWithTheTwoRollBonusDoNotGetBonusRolls() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(30);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last two strikes followed by only last bonus with non strike points")
    public void lastTwoStrikesFollowedByOnlyLastBonusWithNonStrikePoints() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 1};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(31);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a strike with the one roll bonus after a spare in the last frame does not get a bonus")
    public void aStrikeWithTheOneRollBonusAfterASpareInTheLastFrameDoesNotGetABonus() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(20);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("all strikes is a perfect game")
    public void allStrikesIsAPerfectGame() {
        int[] rolls = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(300);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("rolls cannot score negative points")
    public void rollsCanNotScoreNegativePoints() {
        int[] rolls = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Negative roll is invalid");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a roll cannot score more than 10 points")
    public void aRollCanNotScoreMoreThan10Points() {
        int[] rolls = {11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two rolls in a frame cannot score more than 10 points")
    public void twoRollsInAFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("bonus roll after a strike in the last frame cannot score more than 10 points")
    public void bonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two bonus rolls after a strike in the last frame cannot score more than 10 points")
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5, 6};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two bonus rolls after a strike in the last frame can score more than 10 points if one is a strike")
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanScoreMoreThan10PointsIfOneIsAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 6};

        playGame(rolls);

        assertThat(game.score()).isEqualTo(26);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the second bonus rolls after a strike in the last frame cannot be a strike if the first one is not a strike")
    public void theSecondBonusRollsAfterAStrikeInTheLastFrameCanNotBeAStrikeIfTheFirstOneIsNotAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 10};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("second bonus roll after a strike in the last frame cannot score more than 10 points")
    public void secondBonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 11};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Pin count exceeds pins on the lane");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("an unstarted game cannot be scored")
    public void anUnstartedGameCanNotBeScored() {
        int[] rolls = new int[0];

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("an incomplete game cannot be scored")
    public void anIncompleteGameCanNotBeScored() {
        int[] rolls = {0, 0};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot roll if game already has ten frames")
    public void canNotRollIfGameAlreadyHasTenFrames() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Cannot roll after game is over");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("bonus rolls for a strike in the last frame must be rolled before score can be calculated")
    public void bonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("both bonus rolls for a strike in the last frame must be rolled before score can be calculated")
    public void bothBonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("bonus roll for a spare in the last frame must be rolled before score can be calculated")
    public void bonusRollForASpareInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3};

        playGame(rolls);

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(game::score)
            .withMessage("Score cannot be taken until the end of the game");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot roll after bonus roll for spare")
    public void canNotRollAfterBonusRollForSpare() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 2, 2};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Cannot roll after game is over");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot roll after bonus rolls for strike")
    public void canNotRollAfterBonusRollForStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 3, 2, 2};

        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> playGame(rolls))
            .withMessage("Cannot roll after game is over");
    }
}
