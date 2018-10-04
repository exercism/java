import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YachtTest {

    @Test
    public void yacht() {
        int expected = 50;
        assertEquals(expected, new Yacht(new int[]{ 5, 5, 5, 5, 5 }, YachtCategory.YACHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void notYacht() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 1, 3, 3, 2, 5 }, YachtCategory.YACHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void ones() {
        int expected = 3;
        assertEquals(expected, new Yacht(new int[]{ 1, 1, 1, 3, 5 }, YachtCategory.ONES).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void onesOutOfOrder() {
        int expected = 3;
        assertEquals(expected, new Yacht(new int[]{ 3, 1, 1, 5, 1 }, YachtCategory.ONES).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void noOnes() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 4, 3, 6, 5, 5 }, YachtCategory.ONES).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void twos() {
        int expected = 2;
        assertEquals(expected, new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.TWOS).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fours() {
        int expected = 8;
        assertEquals(expected, new Yacht(new int[]{ 1, 4, 1, 4, 1 }, YachtCategory.FOURS).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtCountedAsThrees() {
        int expected = 15;
        assertEquals(expected, new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.THREES).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtOfThreesCountedAsFives() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FIVES).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void sixes() {
        int expected = 6;
        assertEquals(expected, new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.SIXES).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseTwoSmallThreeBig() {
        int expected = 16;
        assertEquals(expected, new Yacht(new int[]{ 2, 2, 4, 4, 4 }, YachtCategory.FULL_HOUSE).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseThreeSmallTwoBig() {
        int expected = 19;
        assertEquals(expected, new Yacht(new int[]{ 5, 3, 3, 5, 3 }, YachtCategory.FULL_HOUSE).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoPairIsNotAFullHouse() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 2, 2, 4, 4, 5 }, YachtCategory.FULL_HOUSE).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourOfAKindIsNotAFullHouse() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 1, 4, 4, 4, 4 }, YachtCategory.FULL_HOUSE).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtIsNotAFullHouse() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.FULL_HOUSE).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourOfAKind() {
        int expected = 24;
        assertEquals(expected, new Yacht(new int[]{ 6, 6, 4, 6, 6 }, YachtCategory.FOUR_OF_A_KIND).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtCantBeScoredAsFourOfAKind() {
        int expected = 12;
        assertEquals(expected, new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FOUR_OF_A_KIND).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseIsNotFourOfAKind() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 3, 3, 3, 5, 5 }, YachtCategory.FOUR_OF_A_KIND).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void littleStraight() {
        int expected = 30;
        assertEquals(expected, new Yacht(new int[]{ 3, 5, 4, 1, 2 }, YachtCategory.LITTLE_STRAIGHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void littleStraightAsBigStraight() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 1, 2, 3, 4, 5 }, YachtCategory.BIG_STRAIGHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourInOrderButNotALittleStraight() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 1, 1, 2, 3, 4 }, YachtCategory.LITTLE_STRAIGHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void noPairsButNotALittleStraight() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 1, 2, 3, 4, 6 }, YachtCategory.LITTLE_STRAIGHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void minimumIs1MaximumIs5ButNotALittleStraight() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 1, 1, 3, 4, 5 }, YachtCategory.LITTLE_STRAIGHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void bigStraight() {
        int expected = 30;
        assertEquals(expected, new Yacht(new int[]{ 4, 6, 2, 5, 3 }, YachtCategory.BIG_STRAIGHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void bigStraightAsLittleStraight() {
        int expected = 0;
        assertEquals(expected, new Yacht(new int[]{ 6, 5, 4, 3, 2 }, YachtCategory.LITTLE_STRAIGHT).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void choice() {
        int expected = 23;
        assertEquals(expected, new Yacht(new int[]{ 3, 3, 5, 6, 6 }, YachtCategory.CHOICE).score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtAsChoice() {
        int expected = 10;
        assertEquals(expected, new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.CHOICE).score());
    }

}