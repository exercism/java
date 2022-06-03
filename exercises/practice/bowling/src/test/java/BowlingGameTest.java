import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

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

    @Ignore("Remove to run test")
    @Test
    public void shouldBeAbleToScoreAGameWithNoStrikesOrSpares() {
        int[] rolls = {3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(90);
    }

    @Ignore("Remove to run test")
    @Test
    public void aSpareFollowedByZerosIsWorthTenPoints() {
        int[] rolls = {6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(10);
    }

    @Ignore("Remove to run test")
    @Test
    public void pointsScoredInTheRollAfterASpareAreCountedTwice() {
        int[] rolls = {6, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(16);
    }

    @Ignore("Remove to run test")
    @Test
    public void consecutiveSparesEachGetAOneRollBonus() {
        int[] rolls = {5, 5, 3, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(31);
    }

    @Ignore("Remove to run test")
    @Test
    public void aSpareInTheLastFrameGetsAOneRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 7};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(17);
    }

    @Ignore("Remove to run test")
    @Test
    public void aStrikeEarnsTenPointsInFrameWithASingleRoll() {
        int[] rolls = {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(10);
    }

    @Ignore("Remove to run test")
    @Test
    public void pointsScoredInTheTwoRollsAfterAStrikeAreCountedTwiceAsABonus() {
        int[] rolls = {10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(26);
    }

    @Ignore("Remove to run test")
    @Test
    public void consecutiveStrikesEachGetTheTwoRollBonus() {
        int[] rolls = {10, 10, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(81);
    }

    @Ignore("Remove to run test")
    @Test
    public void aStrikeInTheLastFrameGetsATwoRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 1};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(18);
    }

    @Ignore("Remove to run test")
    @Test
    public void rollingASpareWithTheTwoRollBonusDoesNotGetABonusRoll() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 3};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(20);
    }

    @Ignore("Remove to run test")
    @Test
    public void strikesWithTheTwoRollBonusDoNotGetBonusRolls() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(30);
    }

    @Ignore("Remove to run test")
    @Test
    public void aStrikeWithTheOneRollBonusAfterASpareInTheLastFrameDoesNotGetABonus() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(20);
    }

    @Ignore("Remove to run test")
    @Test
    public void allStrikesIsAPerfectGame() {
        int[] rolls = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        playGame(rolls);
        assertThat(game.score()).isEqualTo(300);
    }

    @Ignore("Remove to run test")
    @Test
    public void rollsCanNotScoreNegativePoints() {
        int[] rolls = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Negative roll is invalid");
    }

    @Ignore("Remove to run test")
    @Test
    public void aRollCanNotScoreMoreThan10Points() {
        int[] rolls = {11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Pin count exceeds pins on the lane");
    }

    @Ignore("Remove to run test")
    @Test
    public void twoRollsInAFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Pin count exceeds pins on the lane");
    }

    @Ignore("Remove to run test")
    @Test
    public void bonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 0};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Pin count exceeds pins on the lane");
    }

    @Ignore("Remove to run test")
    @Test
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5, 6};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Pin count exceeds pins on the lane");
    }

    @Ignore("Remove to run test")
    @Test
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanScoreMoreThan10PointsIfOneIsAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 6};

        playGame(rolls);

        assertThat(game.score()).isEqualTo(26);
    }

    @Ignore("Remove to run test")
    @Test
    public void theSecondBonusRollsAfterAStrikeInTheLastFrameCanNotBeAStrikeIfTheFirstOneIsNotAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 10};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Pin count exceeds pins on the lane");
    }

    @Ignore("Remove to run test")
    @Test
    public void secondBonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 11};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Pin count exceeds pins on the lane");
    }

    @Ignore("Remove to run test")
    @Test
    public void anUnstartedGameCanNotBeScored() {
        int[] rolls = new int[0];

        playGame(rolls);

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, game::score);

        assertThat(expected)
            .hasMessage("Score cannot be taken until the end of the game");
    }

    @Ignore("Remove to run test")
    @Test
    public void anIncompleteGameCanNotBeScored() {
        int[] rolls = {0, 0};

        playGame(rolls);

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, game::score);

        assertThat(expected)
            .hasMessage("Score cannot be taken until the end of the game");
    }

    @Ignore("Remove to run test")
    @Test
    public void canNotRollIfGameAlreadyHasTenFrames() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Cannot roll after game is over");
    }

    @Ignore("Remove to run test")
    @Test
    public void bonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};

        playGame(rolls);

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, game::score);

        assertThat(expected)
            .hasMessage("Score cannot be taken until the end of the game");
    }

    @Ignore("Remove to run test")
    @Test
    public void bothBonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10};

        playGame(rolls);

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, game::score);

        assertThat(expected)
            .hasMessage("Score cannot be taken until the end of the game");
    }

    @Ignore("Remove to run test")
    @Test
    public void bonusRollForASpareInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3};

        playGame(rolls);

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, game::score);

        assertThat(expected)
            .hasMessage("Score cannot be taken until the end of the game");
    }

    @Ignore("Remove to run test")
    @Test
    public void canNotRollAfterBonusRollForSpare() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 2, 2};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Cannot roll after game is over");
    }

    @Ignore("Remove to run test")
    @Test
    public void canNotRollAfterBonusRollForStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 3, 2, 2};

        IllegalStateException expected =
            assertThrows(IllegalStateException.class, () -> playGame(rolls));

        assertThat(expected).hasMessage("Cannot roll after game is over");
    }
}
