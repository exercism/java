import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YachtTest {

    private Yacht yacht;

    @Test
    public void yacht() {
        yacht = new Yacht(new int[]{ 5, 5, 5, 5, 5 }, YachtCategory.YACHT);
        assertEquals(50, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void notYacht() {
        yacht = new Yacht(new int[]{ 1, 3, 3, 2, 5 }, YachtCategory.YACHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void ones() {
        yacht =  new Yacht(new int[]{ 1, 1, 1, 3, 5 }, YachtCategory.ONES);
        assertEquals(3, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void onesOutOfOrder() {
        yacht = new Yacht(new int[]{ 3, 1, 1, 5, 1 }, YachtCategory.ONES);
        assertEquals(3, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void noOnes() {
        yacht = new Yacht(new int[]{ 4, 3, 6, 5, 5 }, YachtCategory.ONES);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void twos() {
        yacht = new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.TWOS);
        assertEquals(2, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fours() {
        yacht = new Yacht(new int[]{ 1, 4, 1, 4, 1 }, YachtCategory.FOURS);
        assertEquals(8, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtCountedAsThrees() {
        yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.THREES);
        assertEquals(15, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtOfThreesCountedAsFives() {
        yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FIVES);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void sixes() {
        yacht = new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.SIXES);
        assertEquals(6, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseTwoSmallThreeBig() {
        yacht = new Yacht(new int[]{ 2, 2, 4, 4, 4 }, YachtCategory.FULL_HOUSE);
        assertEquals(16, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseThreeSmallTwoBig() {
        yacht = new Yacht(new int[]{ 5, 3, 3, 5, 3 }, YachtCategory.FULL_HOUSE);
        assertEquals(19, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoPairIsNotAFullHouse() {
        yacht = new Yacht(new int[]{ 2, 2, 4, 4, 5 }, YachtCategory.FULL_HOUSE);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourOfAKindIsNotAFullHouse() {
        yacht = new Yacht(new int[]{ 1, 4, 4, 4, 4 }, YachtCategory.FULL_HOUSE);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtIsNotAFullHouse() {
        yacht = new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.FULL_HOUSE);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourOfAKind() {
        yacht = new Yacht(new int[]{ 6, 6, 4, 6, 6 }, YachtCategory.FOUR_OF_A_KIND);
        assertEquals(24, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtCantBeScoredAsFourOfAKind() {
        yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FOUR_OF_A_KIND);
        assertEquals(12, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseIsNotFourOfAKind() {
        yacht = new Yacht(new int[]{ 3, 3, 3, 5, 5 }, YachtCategory.FOUR_OF_A_KIND);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void littleStraight() {
        yacht = new Yacht(new int[]{ 3, 5, 4, 1, 2 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(30, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void littleStraightAsBigStraight() {
        yacht = new Yacht(new int[]{ 1, 2, 3, 4, 5 }, YachtCategory.BIG_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourInOrderButNotALittleStraight() {
        yacht = new Yacht(new int[]{ 1, 1, 2, 3, 4 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void noPairsButNotALittleStraight() {
        yacht = new Yacht(new int[]{ 1, 2, 3, 4, 6 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void minimumIs1MaximumIs5ButNotALittleStraight() {
        yacht = new Yacht(new int[]{ 1, 1, 3, 4, 5 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void bigStraight() {
        yacht = new Yacht(new int[]{ 4, 6, 2, 5, 3 }, YachtCategory.BIG_STRAIGHT);
        assertEquals(30, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void bigStraightAsLittleStraight() {
        yacht = new Yacht(new int[]{ 6, 5, 4, 3, 2 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void choice() {
        yacht = new Yacht(new int[]{ 3, 3, 5, 6, 6 }, YachtCategory.CHOICE);
        assertEquals(23, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtAsChoice() {
        yacht = new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.CHOICE);
        assertEquals(10, yacht.score());
    }

}
