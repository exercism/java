import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerTest {
    @Test
    public void oneHand() {
        String hand = "4S 5S 7H 8D JC";
        assertThat(new Poker(Collections.singletonList(hand)).getBestHands())
            .containsExactly(hand);
    }

    @Disabled("Remove to run test")
    @Test
    public void highestCardWins() {
        String highest8 = "4D 5S 6S 8D 3C";
        String highest10 = "2S 4C 7S 9H 10H";
        String highestJ = "3S 4S 5D 6H JH";
        assertThat(new Poker(Arrays.asList(highest8, highest10, highestJ)).getBestHands())
            .containsExactly(highestJ);
    }

    @Disabled("Remove to run test")
    @Test
    public void tieHasMultipleWinners() {
        String highest8 = "4D 5S 6S 8D 3C";
        String highest10 = "2S 4C 7S 9H 10H";
        String highestJh = "3S 4S 5D 6H JH";
        String highestJd = "3H 4H 5C 6C JD";
        assertThat(new Poker(Arrays.asList(highest8, highest10, highestJh, highestJd)).getBestHands())
            .containsExactly(highestJh, highestJd);
    }

    @Disabled("Remove to run test")
    @Test
    public void sameHighCards() {
        String nextHighest3 = "3S 5H 6S 8D 7H";
        String nextHighest2 = "2S 5D 6D 8C 7S";
        assertThat(new Poker(Arrays.asList(nextHighest3, nextHighest2)).getBestHands())
            .containsExactly(nextHighest3);
    }

    @Disabled("Remove to run test")
    @Test
    public void nothingVsOnePair() {
        String nothing = "4S 5H 6C 8D KH";
        String pairOf4 = "2S 4H 6S 4D JH";
        assertThat(new Poker(Arrays.asList(nothing, pairOf4)).getBestHands())
            .containsExactly(pairOf4);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoPairs() {
        String pairOf2 = "4S 2H 6S 2D JH";
        String pairOf4 = "2S 4H 6C 4D JD";
        assertThat(new Poker(Arrays.asList(pairOf2, pairOf4)).getBestHands())
            .containsExactly(pairOf4);
    }

    @Disabled("Remove to run test")
    @Test
    public void onePairVsDoublePair() {
        String pairOf8 = "2S 8H 6S 8D JH";
        String doublePair = "4S 5H 4C 8C 5C";
        assertThat(new Poker(Arrays.asList(pairOf8, doublePair)).getBestHands())
            .containsExactly(doublePair);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoDoublePairs() {
        String doublePair2And8 = "2S 8H 2D 8D 3H";
        String doublePair4And5 = "4S 5H 4C 8S 5D";
        assertThat(new Poker(Arrays.asList(doublePair2And8, doublePair4And5)).getBestHands())
            .containsExactly(doublePair2And8);
    }

    @Disabled("Remove to run test")
    @Test
    public void sameHighestPair() {
        String doublePair2AndQ = "2S QS 2C QD JH";
        String doublePairJAndQ = "JD QH JS 8D QC";
        assertThat(new Poker(Arrays.asList(doublePairJAndQ, doublePair2AndQ)).getBestHands())
            .containsExactly(doublePairJAndQ);
    }

    @Disabled("Remove to run test")
    @Test
    public void identicallyRankedPairs() {
        String kicker8 = "JD QH JS 8D QC";
        String kicker2 = "JS QS JC 2D QD";
        assertThat(new Poker(Arrays.asList(kicker8, kicker2)).getBestHands())
            .containsExactly(kicker8);
    }

    @Disabled("Remove to run test")
    @Test
    public void doublePairVsThree() {
        String doublePair2And8 = "2S 8H 2H 8D JH";
        String threeOf4 = "4S 5H 4C 8S 4H";
        assertThat(new Poker(Arrays.asList(doublePair2And8, threeOf4)).getBestHands())
            .containsExactly(threeOf4);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoThrees() {
        String threeOf2 = "2S 2H 2C 8D JH";
        String threeOf1 = "4S AH AS 8C AD";
        assertThat(new Poker(Arrays.asList(threeOf2, threeOf1)).getBestHands())
            .containsExactly(threeOf1);
    }

    @Disabled("Remove to run test")
    @Test
    public void sameThreesMultipleDecks() {
        String remainingCard7 = "4S AH AS 7C AD";
        String remainingCard8 = "4S AH AS 8C AD";
        assertThat(new Poker(Arrays.asList(remainingCard7, remainingCard8)).getBestHands())
            .containsExactly(remainingCard8);
    }

    @Disabled("Remove to run test")
    @Test
    public void threeVsStraight() {
        String threeOf4 = "4S 5H 4C 8D 4H";
        String straight = "3S 4D 2S 6D 5C";
        assertThat(new Poker(Arrays.asList(threeOf4, straight)).getBestHands())
            .containsExactly(straight);
    }

    @Disabled("Remove to run test")
    @Test
    public void acesCanEndAStraight() {
        String hand = "4S 5H 4C 8D 4H";
        String straightEndsA = "10D JH QS KD AC";
        assertThat(new Poker(Arrays.asList(hand, straightEndsA)).getBestHands())
            .containsExactly(straightEndsA);
    }

    @Disabled("Remove to run test")
    @Test
    public void acesCanStartAStraight() {
        String hand = "4S 5H 4C 8D 4H";
        String straightStartA = "4D AH 3S 2D 5C";
        assertThat(new Poker(Arrays.asList(hand, straightStartA)).getBestHands())
            .containsExactly(straightStartA);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoStraights() {
        String straightTo8 = "4S 6C 7S 8D 5H";
        String straightTo9 = "5S 7H 8S 9D 6H";
        assertThat(new Poker(Arrays.asList(straightTo8, straightTo9)).getBestHands())
            .containsExactly(straightTo9);
    }

    @Disabled("Remove to run test")
    @Test
    public void theLowestStraightStartsWithAce() {
        String straight = "2H 3C 4D 5D 6H";
        String straightStartA = "4S AH 3S 2D 5H";
        assertThat(new Poker(Arrays.asList(straight, straightStartA)).getBestHands())
            .containsExactly(straight);
    }

    @Disabled("Remove to run test")
    @Test
    public void straightVsFlush() {
        String straightTo8 = "4C 6H 7D 8D 5H";
        String flushTo7 = "2S 4S 5S 6S 7S";
        assertThat(new Poker(Arrays.asList(straightTo8, flushTo7)).getBestHands())
            .containsExactly(flushTo7);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoFlushes() {
        String flushTo8 = "4H 7H 8H 9H 6H";
        String flushTo7 = "2S 4S 5S 6S 7S";
        assertThat(new Poker(Arrays.asList(flushTo8, flushTo7)).getBestHands())
            .containsExactly(flushTo8);
    }

    @Disabled("Remove to run test")
    @Test
    public void flushVsFull() {
        String flushTo8 = "3H 6H 7H 8H 5H";
        String full = "4S 5H 4C 5D 4H";
        assertThat(new Poker(Arrays.asList(full, flushTo8)).getBestHands())
            .containsExactly(full);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoFulls() {
        String fullOf4By9 = "4H 4S 4D 9S 9D";
        String fullOf5By8 = "5H 5S 5D 8S 8D";
        assertThat(new Poker(Arrays.asList(fullOf4By9, fullOf5By8)).getBestHands())
            .containsExactly(fullOf5By8);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoFullssameThripletMultipleDecks() {
        String fullOf5By9 = "5H 5S 5D 9S 9D";
        String fullOf5By8 = "5H 5S 5D 8S 8D";
        assertThat(new Poker(Arrays.asList(fullOf5By9, fullOf5By8)).getBestHands())
            .containsExactly(fullOf5By9);
    }

    @Disabled("Remove to run test")
    @Test
    public void fullVsSquare() {
        String full = "4S 5H 4D 5D 4H";
        String squareOf3 = "3S 3H 2S 3D 3C";
        assertThat(new Poker(Arrays.asList(full, squareOf3)).getBestHands())
            .containsExactly(squareOf3);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoSquares() {
        String squareOf2 = "2S 2H 2C 8D 2D";
        String squareOf5 = "4S 5H 5S 5D 5C";
        assertThat(new Poker(Arrays.asList(squareOf2, squareOf5)).getBestHands())
            .containsExactly(squareOf5);
    }

    @Disabled("Remove to run test")
    @Test
    public void sameSquaresMultipleDecks() {
        String kicker2 = "3S 3H 2S 3D 3C";
        String kicker4 = "3S 3H 4S 3D 3C";
        assertThat(new Poker(Arrays.asList(kicker2, kicker4)).getBestHands())
            .containsExactly(kicker4);
    }

    @Disabled("Remove to run test")
    @Test
    public void squareVsStraightFlush() {
        String squareOf5 = "4S 5H 5S 5D 5C";
        String straightFlushTo9 = "7S 8S 9S 6S 10S";
        assertThat(new Poker(Arrays.asList(squareOf5, straightFlushTo9)).getBestHands())
            .containsExactly(straightFlushTo9);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoStraightFlushes() {
        String straightFlushTo8 = "4H 6H 7H 8H 5H";
        String straightFlushTo9 = "5S 7S 8S 9S 6S";
        assertThat(new Poker(Arrays.asList(straightFlushTo8, straightFlushTo9)).getBestHands())
            .containsExactly(straightFlushTo9);
    }
}
