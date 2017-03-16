import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Ignore;
import org.junit.Test;

public class PokerTest
{
    @Test
    public void One_hand()
    {
        final String hand = "4S 5S 7H 8D JC";
        assertEquals(Arrays.asList(hand),Poker.BestHands(Arrays.asList(hand)));
    }

    @Test
    @Ignore
    public void Nothing_vs_one_pair()
    {
        final String nothing = "4S 5H 6S 8D JH";
        final String pairOf4 = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(pairOf4), Poker.BestHands(Arrays.asList(nothing, pairOf4)));
    }

    @Test
    @Ignore
    public void Two_pairs()
    {
        final String pairOf2 = "4S 2H 6S 2D JH";
        final String pairOf4 = "2S 4H 6S 4D JH";
        assertEquals(Arrays.asList(pairOf4), Poker.BestHands(Arrays.asList(pairOf2,pairOf4)));
    }

    @Test
    @Ignore
    public void One_pair_vs_double_pair()
    {
        final String pairOf8 = "2S 8H 6S 8D JH";
        final String doublePair = "4S 5H 4S 8D 5H";
        assertEquals(Arrays.asList(doublePair), Poker.BestHands(Arrays.asList(pairOf8, doublePair)));
    }

    @Test
    @Ignore
    public void Two_double_pairs()
    {
        final String doublePair2And8 = "2S 8H 2S 8D JH";
        final String doublePair4And5 = "4S 5H 4S 8D 5H";
        assertEquals(Arrays.asList(doublePair2And8), Poker.BestHands(Arrays.asList(doublePair2And8, doublePair4And5)));
    }

    @Test
    @Ignore
    public void Double_pair_vs_three()
    {
        final String doublePair2And8 = "2S 8H 2S 8D JH";
        final String threeOf4 = "4S 5H 4S 8D 4H";
        assertEquals(Arrays.asList(threeOf4 ), Poker.BestHands(Arrays.asList(doublePair2And8, threeOf4 )));
    }

    @Test
    @Ignore
    public void Two_threes()
    {
        final String threeOf2 = "2S 2H 2S 8D JH";
        final String threeOf1 = "4S AH AS 8D AH";
        assertEquals(Arrays.asList(threeOf1), Poker.BestHands(Arrays.asList(threeOf2, threeOf1)));
    }

    @Test
    @Ignore
    public void Three_vs_straight()
    {
        final String threeOf4 = "4S 5H 4S 8D 4H";
        final String straight = "3S 4H 2S 6D 5H";
        assertEquals(Arrays.asList(straight), Poker.BestHands(Arrays.asList(threeOf4, straight )));
    }

    @Test
    @Ignore
    public void Two_straights()
    {
        final String straightTo8 = "4S 6H 7S 8D 5H";
        final String straightTo9 = "5S 7H 8S 9D 6H";
        assertEquals(Arrays.asList(straightTo9 ), Poker.BestHands(Arrays.asList(straightTo8, straightTo9 )));

        final String straightTo1 = "AS QH KS TD JH";
        final String straightTo5 = "4S AH 3S 2D 5H";
        assertEquals(Arrays.asList(straightTo1), Poker.BestHands(Arrays.asList(straightTo1, straightTo5)));
    }

    @Test
    @Ignore
    public void Straight_vs_flush()
    {
        final String straightTo8 = "4S 6H 7S 8D 5H";
        final String flushTo7 = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(flushTo7 ), Poker.BestHands(Arrays.asList(straightTo8, flushTo7 )));
    }

    @Test
    @Ignore
    public void Two_flushes()
    {
        final String flushTo8 = "3H 6H 7H 8H 5H";
        final String flushTo7 = "2S 4S 5S 6S 7S";
        assertEquals(Arrays.asList(flushTo8), Poker.BestHands(Arrays.asList(flushTo8, flushTo7)));
    }

    @Test
    @Ignore
    public void Flush_vs_full()
    {
        final String flushTo8 = "3H 6H 7H 8H 5H";
        final String full = "4S 5H 4S 5D 4H";
        assertEquals(Arrays.asList(full ), Poker.BestHands(Arrays.asList(full, flushTo8)));
    }

    @Test
    @Ignore
    public void Two_fulls()
    {
        final String fullOf4By9 = "4H 4S 4D 9S 9D";
        final String fullOf5By8 = "5H 5S 5D 8S 8D";
        assertEquals(Arrays.asList(fullOf5By8 ), Poker.BestHands(Arrays.asList(fullOf4By9, fullOf5By8)));
    }

    @Test
    @Ignore
    public void Full_vs_square()
    {
        final String full = "4S 5H 4S 5D 4H";
        final String squareOf3 = "3S 3H 2S 3D 3H";
        assertEquals(Arrays.asList(squareOf3 ), Poker.BestHands(Arrays.asList(full, squareOf3 )));
    }

    @Test
    @Ignore
    public void Two_squares()
    {
        final String squareOf2 = "2S 2H 2S 8D 2H";
        final String squareOf5 = "4S 5H 5S 5D 5H";
        assertEquals(Arrays.asList(squareOf5), Poker.BestHands(Arrays.asList(squareOf2, squareOf5)));
    }

    @Test
    @Ignore
    public void Square_vs_straight_flush()
    {
        final String squareOf5 = "4S 5H 5S 5D 5H";
        final String straightFlushTo9 = "5S 7S 8S 9S 6S";
        assertEquals(Arrays.asList(straightFlushTo9 ), Poker.BestHands(Arrays.asList(squareOf5, straightFlushTo9 )));
    }

    @Test
    @Ignore
    public void Two_straight_flushes()
    {
        final String straightFlushTo8 = "4H 6H 7H 8H 5H";
        final String straightFlushTo9 = "5S 7S 8S 9S 6S";
        assertEquals(Arrays.asList(straightFlushTo9 ), Poker.BestHands(Arrays.asList(straightFlushTo8, straightFlushTo9)));
    }

    @Test
    @Ignore
    public void Three_hand_with_tie()
    {
        final String spadeStraightTo9 = "9S 8S 7S 6S 5S";
        final String diamondStraightTo9 = "9D 8D 7D 6D 5D";
        final String threeOf4 = "4D 4S 4H QS KS";
        assertEquals(Arrays.asList(spadeStraightTo9, diamondStraightTo9), Poker.BestHands(Arrays.asList(spadeStraightTo9, diamondStraightTo9, threeOf4)));
    }

    @Test
    @Ignore
    public void Straight_to_5_against_a_pair_of_jacks()
    {
        final String straightTo5 = "2S 4D 5C 3S AS";
        final String twoJacks = "JD 8D 7D JC 5D";
        assertEquals(Arrays.asList(straightTo5), Poker.BestHands(Arrays.asList(straightTo5, twoJacks)));
    }
}
