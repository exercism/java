import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import org.junit.Ignore;

public class PokerTest {
    @Test
    public void oneHand() {
        final String hand = "4S 5S 7H 8D JC";
        assertEquals(Arrays.asList(hand),new Poker(Arrays.asList(hand)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void nothingVsOnePair() {
        final String nothing = "4S 5H 6S 8D JH";
        final String pairOf4 = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(pairOf4),new Poker(Arrays.asList(nothing, pairOf4)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoPairs() {
        final String pairOf2 = "4S 2H 6S 2D JH";
        final String pairOf4 = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(pairOf4), new Poker(Arrays.asList(pairOf2,pairOf4)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void onePairVsDoublePair() {
        final String pairOf8 = "2S 8H 6S 8D JH";
        final String doublePair = "4S 5H 4S 8D 5H";
        assertEquals(Arrays.asList(doublePair),  new Poker(Arrays.asList(pairOf8, doublePair)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoDoublePairs() {
        final String doublePair2And8 = "2S 8H 2S 8D JH";
        final String doublePair4And5 = "4S 5H 4S 8D 5H";
        assertEquals(Arrays.asList(doublePair2And8), new Poker(Arrays.asList(doublePair2And8, doublePair4And5)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void doublePairVsThree() {
        final String doublePair2And8 = "2S 8H 2S 8D JH";
        final String threeOf4 = "4S 5H 4S 8D 4H";
        assertEquals(Arrays.asList(threeOf4 ), new Poker(Arrays.asList(doublePair2And8, threeOf4)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoThrees() {
        final String threeOf2 = "2S 2H 2S 8D JH";
        final String threeOf1 = "4S AH AS 8D AH";
        assertEquals(Arrays.asList(threeOf1), new Poker(Arrays.asList(threeOf2, threeOf1)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void threeVsStraight() {
        final String threeOf4 = "4S 5H 4S 8D 4H";
        final String straight = "3S 4H 2S 6D 5H";
        assertEquals(Arrays.asList(straight), new Poker(Arrays.asList(threeOf4, straight)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoStraights() {
        final String straightTo8 = "4S 6H 7S 8D 5H";
        final String straightTo9 = "5S 7H 8S 9D 6H";
        assertEquals(Arrays.asList(straightTo9 ), new Poker(Arrays.asList(straightTo8, straightTo9)).getBestHands());

        final String straightTo1 = "AS QH KS TD JH";
        final String straightTo5 = "4S AH 3S 2D 5H";
        assertEquals(Arrays.asList(straightTo1), new Poker(Arrays.asList(straightTo1, straightTo5)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void straightVsFlush() {
        final String straightTo8 = "4S 6H 7S 8D 5H";
        final String flushTo7 = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(flushTo7 ), new Poker(Arrays.asList(straightTo8, flushTo7)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoFlushes() {
        final String flushTo8 = "3H 6H 7H 8H 5H";
        final String flushTo7 = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(flushTo8), new Poker(Arrays.asList(flushTo8, flushTo7)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void flushVsFull() {
        final String flushTo8 = "3H 6H 7H 8H 5H";
        final String full = "4S 5H 4S 5D 4H";
        assertEquals(Arrays.asList(full ), new Poker(Arrays.asList(full, flushTo8)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoFulls() {
        final String fullOf4By9 = "4H 4S 4D 9S 9D";
        final String fullOf5By8 = "5H 5S 5D 8S 8D";
        assertEquals(Arrays.asList(fullOf5By8 ), new Poker(Arrays.asList(fullOf4By9, fullOf5By8)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void fullVsSquare() {
        final String full = "4S 5H 4S 5D 4H";
        final String squareOf3 = "3S 3H 2S 3D 3H";
        assertEquals(Arrays.asList(squareOf3 ), new Poker(Arrays.asList(full, squareOf3)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoSquares() {
        final String squareOf2 = "2S 2H 2S 8D 2H";
        final String squareOf5 = "4S 5H 5S 5D 5H";
        assertEquals(Arrays.asList(squareOf5), new Poker(Arrays.asList(squareOf2, squareOf5)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void squareVsStraightFlush() {
        final String squareOf5 = "4S 5H 5S 5D 5H";
        final String straightFlushTo9 = "5S 7S 8S 9S 6S";
        assertEquals(Arrays.asList(straightFlushTo9 ), new Poker(Arrays.asList(squareOf5, straightFlushTo9)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void twoStraightFlushes() {
        final String straightFlushTo8 = "4H 6H 7H 8H 5H";
        final String straightFlushTo9 = "5S 7S 8S 9S 6S";
        assertEquals(Arrays.asList(straightFlushTo9 ), new Poker(Arrays.asList(straightFlushTo8, straightFlushTo9)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void threeHandWithTie() {
        final String spadeStraightTo9 = "9S 8S 7S 6S 5S";
        final String diamondStraightTo9 = "9D 8D 7D 6D 5D";
        final String threeOf4 = "4D 4S 4H QS KS";
        assertEquals(Arrays.asList(spadeStraightTo9, diamondStraightTo9), new Poker(Arrays.asList(spadeStraightTo9, diamondStraightTo9, threeOf4)).getBestHands());
    }

    @Test
    @Ignore("Remove to run test")
    public void straightTo5AgainstAPairOfJacks() {
        final String straightTo5 = "2S 4D 5C 3S AS";
        final String twoJacks = "JD 8D 7D JC 5D";
        assertEquals(Arrays.asList(straightTo5), new Poker(Arrays.asList(straightTo5, twoJacks)).getBestHands());
    }
}
