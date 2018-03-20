import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    private BowlingGame game;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        game = new BowlingGame();
    }

    private void playGame(int[] rolls) {
        for (int pins : rolls) {
            game.roll(pins);
        }
    }

    @Test
    public void shouldBeAbleToScoreAGameWithAllZeros() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertEquals(0, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void shouldBeAbleToScoreAGameWithNoStrikesOrSpares() {
        int[] rolls = {3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6};

        playGame(rolls);
        assertEquals(90, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void aSpareFollowedByZerosIsWorthTenPoints() {
        int[] rolls = {6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertEquals(10, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void pointsScoredInTheRollAfterASpareAreCountedTwice() {
        int[] rolls = {6, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertEquals(16, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void consecutiveSparesEachGetAOneRollBonus() {
        int[] rolls = {5, 5, 3, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertEquals(31, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void aSpareInTheLastFrameGetsAOneRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 7};

        playGame(rolls);
        assertEquals(17, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void aStrikeEarnsTenPointsInFrameWithASingleRoll() {
        int[] rolls = {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertEquals(10, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void pointsScoredInTheTwoRollsAfterAStrikeAreCountedTwiceAsABonus() {
        int[] rolls = {10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertEquals(26, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void consecutiveStrikesEachGetTheTwoRollBonus() {
        int[] rolls = {10, 10, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);
        assertEquals(81, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void aStrikeInTheLastFrameGetsATwoRollBonusThatIsCountedOnce() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 1};

        playGame(rolls);
        assertEquals(18, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void rollingASpareWithTheTwoRollBonusDoesNotGetABonusRoll() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 3};

        playGame(rolls);
        assertEquals(20, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void strikesWithTheTwoRollBonusDoNotGetBonusRolls() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10};

        playGame(rolls);
        assertEquals(30, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void aStrikeWithTheOneRollBonusAfterASpareInTheLastFrameDoesNotGetABonus() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 10};

        playGame(rolls);
        assertEquals(20, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void allStrikesIsAPerfectGame() {
        int[] rolls = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        playGame(rolls);
        assertEquals(300, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void rollsCanNotScoreNegativePoints() {
        int[] rolls = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Negative roll is invalid");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void aRollCanNotScoreMoreThan10Points() {
        int[] rolls = {11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Pin count exceeds pins on the lane");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void twoRollsInAFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Pin count exceeds pins on the lane");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void bonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 0};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Pin count exceeds pins on the lane");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5, 6};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Pin count exceeds pins on the lane");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanScoreMoreThan10PointsIfOneIsAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 6};

        playGame(rolls);

        assertEquals(26, game.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void theSecondBonusRollsAfterAStrikeInTheLastFrameCanNotBeAStrikeIfTheFirstOneIsNotAStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 10};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Pin count exceeds pins on the lane");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void secondBonusRollAfterAStrikeInTheLastFrameCanNotScoreMoreThan10Points() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 11};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Pin count exceeds pins on the lane");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void anUnstartedGameCanNotBeScored() {
        int[] rolls = new int[0];

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Score cannot be taken until the end of the game");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void anIncompleteGameCanNotBeScored() {
        int[] rolls = {0, 0};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Score cannot be taken until the end of the game");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void canNotRollIfGameAlreadyHasTenFrames() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Cannot roll after game is over");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void bonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Score cannot be taken until the end of the game");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void bothBonusRollsForAStrikeInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Score cannot be taken until the end of the game");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void bonusRollForASpareInTheLastFrameMustBeRolledBeforeScoreCanBeCalculated() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Score cannot be taken until the end of the game");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void canNotRollAfterBonusRollForSpare() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 2, 2};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Cannot roll after game is over");

        game.score();
    }

    @Ignore("Remove to run test")
    @Test
    public void canNotRollAfterBonusRollForStrike() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 3, 2, 2};

        playGame(rolls);

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Cannot roll after game is over");

        game.score();
    }
}
