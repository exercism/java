import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PokerTest {
    @Test
    public void oneHand() {
        final String hand = "4S 5S 7H 8D JC";
        assertEquals(Arrays.asList(hand), new Poker(Arrays.asList(hand)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void highestCardOfAllHandsWins() {
        final String handOne = "4D 5S 6S 8D 3C";
        final String handTwo = "2S 4C 7S 9H 10H";
        final String handThree = "3S 4S 5D 6H JH";
        assertEquals(Arrays.asList(handThree), new Poker(Arrays.asList(handOne, handTwo, handThree)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void tieHasMultipleWinners() {
        final String handOne = "4D 5S 6S 8D 3C";
        final String handTwo = "2S 4C 7S 9H 10H";
        final String handThree = "3S 4S 5D 6H JH";
        final String handFour = "3H 4H 5C 6C JD";
        assertEquals(Arrays.asList(handThree, handFour), new Poker(Arrays.asList(handOne, handTwo, handThree, handFour)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleHandsWithSameHighCardComparesNextHighest() {
        final String handOne = "3S 5H 6S 8D 7H";
        final String handTwo = "2S 5D 6D 8C 7S";
        assertEquals(Arrays.asList(handOne), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void onePairBeatsHighCard() {
        final String handOne = "4S 5H 6C 8D KH";
        final String handTwo = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void highestPairWins() {
        final String handOne = "4S 2H 6S 2D JH";
        final String handTwo = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoPairsBeatsOnePair() {
        final String handOne = "2S 8H 6S 8D JH";
        final String handTwo = "4S 5H 4S 8D 5H";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothTwoPairsHighestPairWins() {
        final String handOne = "2S 8H 2D 8D 3H";
        final String handTwo = "4S 5H 4C 8S 5D";
        assertEquals(Arrays.asList(handOne), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothTwoPairsSameHighestPairLowPairWins() {
        final String handOne = "2S QS 2C QD JH";
        final String handTwo = "JD QH JS 8D QC";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothTwoPairsSamePairsKickerWins() {
        final String handOne = "JD QH JS 8D QC";
        final String handTwo = "JS QS JC 2D QD";
        assertEquals(Arrays.asList(handOne), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void threeOfAKindBeatsTwoPair() {
        final String handOne = "2S 8H 2H 8D JH";
        final String handTwo = "4S 5H 4C 8S 4H";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothHandsThreeOfAKindHighestTripletWins() {
        final String handOne = "2S 2H 2C 8D JH";
        final String handTwo = "4S AH AS 8C AD";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleDecksHandsHaveSameThreeOfAKindRemainingHighestCardWins() {
        final String handOne = "4S AH AS 7C AD";
        final String handTwo = "4S AH AS 8C AD";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void straightBeatsThreeOfAKind() {
        final String handOne = "4S 5H 4C 8D 4H";
        final String handTwo = "3S 4D 2S 6D 5C";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void acesCanEndAStraight() {
        final String handOne = "4S 5H 4C 8D 4H";
        final String handTwo = "10D JH QS KD AC";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void acesCanStartAStraight() {
        final String handOne = "4S 5H 4C 8D 4H";
        final String handTwo = "4D AH 3S 2D 5C";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothHandsWithAStraightTieGoesToHighestCard() {
        final String handOne = "4S 6C 7S 8D 5H";
        final String handTwo = "5S 7H 8S 9D 6H";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void fiveHighStraightIsLowestScoringStraight() {
        final String handOne = "2H 3C 4D 5D 6H";
        final String handTwo = "4S AH 3S 2D 5H";
        assertEquals(Arrays.asList(handOne), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void flushBeatsAStraight() {
        final String handOne = "4C 6H 7D 8D 5H";
        final String handTwo = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothHandsWithAFlushTieGoesToHighCard() {
        final String handOne = "4H 7H 8H 9H 6H";
        final String handTwo = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(handOne), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseBeatsAFlush() {
        final String handOne = "3H 6H 7H 8H 5H";
        final String handTwo = "4S 5H 4C 5D 4H";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothHandsWithAFullHouseTieGoesToHighestTriplet() {
        final String handOne = "4H 4S 4D 9S 9D";
        final String handTwo = "5H 5S 5D 8S 8D";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleDecksHandsHaveFullHouseWithSameTripletTieGoesToPair() {
        final String handOne = "5H 5S 5D 9S 9D";
        final String handTwo = "5H 5S 5D 8S 8D";
        assertEquals(Arrays.asList(handOne), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourOfAKindBeatsFullHouse() {
        final String handOne = "4S 5H 4D 5D 4H";
        final String handTwo = "3S 3H 2S 3D 3C";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothHandsHaveFourOfAKindTieGoesToHighQuad() {
        final String handOne = "2S 2H 2C 8D 2D";
        final String handTwo = "4S 5H 5S 5D 5C";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleDecksHandsHaveSameFourOfAKindTieGoesToKicker() {
        final String handOne = "3S 3H 2S 3D 3C";
        final String handTwo = "3S 3H 4S 3D 3C";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void straightFlushBeatsFourOfAKind() {
        final String handOne = "4S 5H 5S 5D 5C";
        final String handTwo = "7S 8S 9S 6S 10S";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void bothHandsHaveStraightFlushTieGoesToHighestCard() {
        final String handOne = "4H 6H 7H 8H 5H";
        final String handTwo = "5S 7S 8S 9S 6S";
        assertEquals(Arrays.asList(handTwo), new Poker(Arrays.asList(handOne, handTwo)).getBestHands());
    }

}
