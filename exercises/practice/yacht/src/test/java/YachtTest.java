import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YachtTest {

    @Test
    public void yacht() {
        Yacht yacht = new Yacht(new int[]{ 5, 5, 5, 5, 5 }, YachtCategory.YACHT);
        assertEquals(50, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void notYacht() {
        Yacht yacht = new Yacht(new int[]{ 1, 3, 3, 2, 5 }, YachtCategory.YACHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void ones() {
        Yacht yacht =  new Yacht(new int[]{ 1, 1, 1, 3, 5 }, YachtCategory.ONES);
        assertEquals(3, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void onesOutOfOrder() {
        Yacht yacht = new Yacht(new int[]{ 3, 1, 1, 5, 1 }, YachtCategory.ONES);
        assertEquals(3, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void noOnes() {
        Yacht yacht = new Yacht(new int[]{ 4, 3, 6, 5, 5 }, YachtCategory.ONES);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void twos() {
        Yacht yacht = new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.TWOS);
        assertEquals(2, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fours() {
        Yacht yacht = new Yacht(new int[]{ 1, 4, 1, 4, 1 }, YachtCategory.FOURS);
        assertEquals(8, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtCountedAsThrees() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.THREES);
        assertEquals(15, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtOfThreesCountedAsFives() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FIVES);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void sixes() {
        Yacht yacht = new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.SIXES);
        assertEquals(6, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseTwoSmallThreeBig() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 4, 4, 4 }, YachtCategory.FULL_HOUSE);
        assertEquals(16, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseThreeSmallTwoBig() {
        Yacht yacht = new Yacht(new int[]{ 5, 3, 3, 5, 3 }, YachtCategory.FULL_HOUSE);
        assertEquals(19, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoPairIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 4, 4, 5 }, YachtCategory.FULL_HOUSE);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourOfAKindIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{ 1, 4, 4, 4, 4 }, YachtCategory.FULL_HOUSE);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.FULL_HOUSE);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourOfAKind() {
        Yacht yacht = new Yacht(new int[]{ 6, 6, 4, 6, 6 }, YachtCategory.FOUR_OF_A_KIND);
        assertEquals(24, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtCanBeScoredAsFourOfAKind() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FOUR_OF_A_KIND);
        assertEquals(12, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fullHouseIsNotFourOfAKind() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 5, 5 }, YachtCategory.FOUR_OF_A_KIND);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void littleStraight() {
        Yacht yacht = new Yacht(new int[]{ 3, 5, 4, 1, 2 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(30, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void littleStraightAsBigStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 2, 3, 4, 5 }, YachtCategory.BIG_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void fourInOrderButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 1, 2, 3, 4 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void noPairsButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 2, 3, 4, 6 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void minimumIs1MaximumIs5ButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 1, 3, 4, 5 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void bigStraight() {
        Yacht yacht = new Yacht(new int[]{ 4, 6, 2, 5, 3 }, YachtCategory.BIG_STRAIGHT);
        assertEquals(30, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void bigStraightAsLittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 6, 5, 4, 3, 2 }, YachtCategory.LITTLE_STRAIGHT);
        assertEquals(0, yacht.score());
    }
    
    @Ignore("Remove to run test")
    @Test
    public void noPairsButNotABigStraight() {
        Yacht yacht = new Yacht(new int[]{ 6, 5, 4, 3, 1 }, YachtCategory.BIG_STRAIGHT);
        assertEquals(0, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void choice() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 5, 6, 6 }, YachtCategory.CHOICE);
        assertEquals(23, yacht.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void yachtAsChoice() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.CHOICE);
        assertEquals(10, yacht.score());
    }

}
