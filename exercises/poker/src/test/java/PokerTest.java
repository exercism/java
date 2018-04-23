import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PokerTest {
    @Test
    public void oneHand() {
        String hand = "4S 5S 7H 8D JC";
        assertEquals(Arrays.asList(hand), new Poker(Arrays.asList(hand)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingVsOnePair() {
        String nothing = "4S 5H 6S 8D JH";
        String pairOf4 = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(pairOf4), new Poker(Arrays.asList(nothing, pairOf4)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoPairs() {
        String pairOf2 = "4S 2H 6S 2D JH";
        String pairOf4 = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(pairOf4), new Poker(Arrays.asList(pairOf2, pairOf4)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void onePairVsDoublePair() {
        String pairOf8 = "2S 8H 6S 8D JH";
        String doublePair = "4S 5H 4S 8D 5H";
        assertEquals(Arrays.asList(doublePair), new Poker(Arrays.asList(pairOf8, doublePair)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoDoublePairs() {
        String doublePair2And8 = "2S 8H 2S 8D JH";
        String doublePair4And5 = "4S 5H 4S 8D 5H";
        assertEquals(Arrays.asList(doublePair2And8), new Poker(Arrays.asList(doublePair2And8, doublePair4And5)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void doublePairVsThree() {
        String doublePair2And8 = "2S 8H 2S 8D JH";
        String threeOf4 = "4S 5H 4S 8D 4H";
        assertEquals(Arrays.asList(threeOf4), new Poker(Arrays.asList(doublePair2And8, threeOf4)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoThrees() {
        String threeOf2 = "2S 2H 2S 8D JH";
        String threeOf1 = "4S AH AS 8D AH";
        assertEquals(Arrays.asList(threeOf1), new Poker(Arrays.asList(threeOf2, threeOf1)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void threeVsStraight() {
        String threeOf4 = "4S 5H 4S 8D 4H";
        String straight = "3S 4H 2S 6D 5H";
        assertEquals(Arrays.asList(straight), new Poker(Arrays.asList(threeOf4, straight)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoStraights() {
        String straightTo8 = "4S 6H 7S 8D 5H";
        String straightTo9 = "5S 7H 8S 9D 6H";
        assertEquals(Arrays.asList(straightTo9), new Poker(Arrays.asList(straightTo8, straightTo9)).getBestHands());

        String straightTo1 = "AS QH KS TD JH";
        String straightTo5 = "4S AH 3S 2D 5H";
        assertEquals(Arrays.asList(straightTo1), new Poker(Arrays.asList(straightTo1, straightTo5)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void straightVsFlush() {
        String straightTo8 = "4S 6H 7S 8D 5H";
        String flushTo7 = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(flushTo7), new Poker(Arrays.asList(straightTo8, flushTo7)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoFlushes() {
        String flushTo8 = "3H 6H 7H 8H 5H";
        String flushTo7 = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(flushTo8), new Poker(Arrays.asList(flushTo8, flushTo7)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void flushVsFull() {
        String flushTo8 = "3H 6H 7H 8H 5H";
        String full = "4S 5H 4S 5D 4H";
        assertEquals(Arrays.asList(full), new Poker(Arrays.asList(full, flushTo8)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoFulls() {
        String fullOf4By9 = "4H 4S 4D 9S 9D";
        String fullOf5By8 = "5H 5S 5D 8S 8D";
        assertEquals(Arrays.asList(fullOf5By8), new Poker(Arrays.asList(fullOf4By9, fullOf5By8)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullVsSquare() {
        String full = "4S 5H 4S 5D 4H";
        String squareOf3 = "3S 3H 2S 3D 3H";
        assertEquals(Arrays.asList(squareOf3), new Poker(Arrays.asList(full, squareOf3)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoSquares() {
        String squareOf2 = "2S 2H 2S 8D 2H";
        String squareOf5 = "4S 5H 5S 5D 5H";
        assertEquals(Arrays.asList(squareOf5), new Poker(Arrays.asList(squareOf2, squareOf5)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void squareVsStraightFlush() {
        String squareOf5 = "4S 5H 5S 5D 5H";
        String straightFlushTo9 = "5S 7S 8S 9S 6S";
        assertEquals(Arrays.asList(straightFlushTo9), new Poker(Arrays.asList(squareOf5, straightFlushTo9)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoStraightFlushes() {
        String straightFlushTo8 = "4H 6H 7H 8H 5H";
        String straightFlushTo9 = "5S 7S 8S 9S 6S";
        assertEquals(Arrays.asList(straightFlushTo9), new Poker(Arrays.asList(straightFlushTo8, straightFlushTo9)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void threeHandWithTie() {
        String spadeStraightTo9 = "9S 8S 7S 6S 5S";
        String diamondStraightTo9 = "9D 8D 7D 6D 5D";
        String threeOf4 = "4D 4S 4H QS KS";
        assertEquals(Arrays.asList(spadeStraightTo9, diamondStraightTo9), new Poker(Arrays.asList(spadeStraightTo9, diamondStraightTo9, threeOf4)).getBestHands());
    }

    @Ignore("Remove to run test")
    @Test
    public void straightTo5AgainstAPairOfJacks() {
        String straightTo5 = "2S 4D 5C 3S AS";
        String twoJacks = "JD 8D 7D JC 5D";
        assertEquals(Arrays.asList(straightTo5), new Poker(Arrays.asList(straightTo5, twoJacks)).getBestHands());
    }
}
