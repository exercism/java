import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YachtTest {

    @Test
    @DisplayName("Yacht")
    public void yacht() {
        Yacht yacht = new Yacht(new int[]{ 5, 5, 5, 5, 5 }, YachtCategory.YACHT);
        assertThat(yacht.score()).isEqualTo(50);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Not Yacht")
    public void notYacht() {
        Yacht yacht = new Yacht(new int[]{ 1, 3, 3, 2, 5 }, YachtCategory.YACHT);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ones")
    public void ones() {
        Yacht yacht =  new Yacht(new int[]{ 1, 1, 1, 3, 5 }, YachtCategory.ONES);
        assertThat(yacht.score()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ones, out of order")
    public void onesOutOfOrder() {
        Yacht yacht = new Yacht(new int[]{ 3, 1, 1, 5, 1 }, YachtCategory.ONES);
        assertThat(yacht.score()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("No ones")
    public void noOnes() {
        Yacht yacht = new Yacht(new int[]{ 4, 3, 6, 5, 5 }, YachtCategory.ONES);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Twos")
    public void twos() {
        Yacht yacht = new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.TWOS);
        assertThat(yacht.score()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Fours")
    public void fours() {
        Yacht yacht = new Yacht(new int[]{ 1, 4, 1, 4, 1 }, YachtCategory.FOURS);
        assertThat(yacht.score()).isEqualTo(8);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Yacht counted as threes")
    public void yachtCountedAsThrees() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.THREES);
        assertThat(yacht.score()).isEqualTo(15);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Yacht of 3s counted as fives")
    public void yachtOfThreesCountedAsFives() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FIVES);
        assertThat(yacht.score()).isEqualTo(0);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Fives")
    public void fives() {
        Yacht yacht = new Yacht(new int[]{ 1, 5, 3, 5, 3 }, YachtCategory.FIVES);
        assertThat(yacht.score()).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Sixes")
    public void sixes() {
        Yacht yacht = new Yacht(new int[]{ 2, 3, 4, 5, 6 }, YachtCategory.SIXES);
        assertThat(yacht.score()).isEqualTo(6);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Full house two small, three big")
    public void fullHouseTwoSmallThreeBig() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 4, 4, 4 }, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isEqualTo(16);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Full house three small, two big")
    public void fullHouseThreeSmallTwoBig() {
        Yacht yacht = new Yacht(new int[]{ 5, 3, 3, 5, 3 }, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isEqualTo(19);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two pair is not a full house")
    public void twoPairIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 4, 4, 5 }, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Four of a kind is not a full house")
    public void fourOfAKindIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{ 1, 4, 4, 4, 4 }, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Yacht is not a full house")
    public void yachtIsNotAFullHouse() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.FULL_HOUSE);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Four of a Kind")
    public void fourOfAKind() {
        Yacht yacht = new Yacht(new int[]{ 6, 6, 4, 6, 6 }, YachtCategory.FOUR_OF_A_KIND);
        assertThat(yacht.score()).isEqualTo(24);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Yacht can be scored as Four of a Kind")
    public void yachtCanBeScoredAsFourOfAKind() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 3, 3 }, YachtCategory.FOUR_OF_A_KIND);
        assertThat(yacht.score()).isEqualTo(12);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Full house is not Four of a Kind")
    public void fullHouseIsNotFourOfAKind() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 3, 5, 5 }, YachtCategory.FOUR_OF_A_KIND);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Little Straight")
    public void littleStraight() {
        Yacht yacht = new Yacht(new int[]{ 3, 5, 4, 1, 2 }, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(30);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Little Straight as Big Straight")
    public void littleStraightAsBigStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 2, 3, 4, 5 }, YachtCategory.BIG_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Four in order but not a little straight")
    public void fourInOrderButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 1, 2, 3, 4 }, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("No pairs but not a little straight")
    public void noPairsButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 2, 3, 4, 6 }, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Minimum is 1, maximum is 5, but not a little straight")
    public void minimumIs1MaximumIs5ButNotALittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 1, 1, 3, 4, 5 }, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Big Straight")
    public void bigStraight() {
        Yacht yacht = new Yacht(new int[]{ 4, 6, 2, 5, 3 }, YachtCategory.BIG_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(30);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Big Straight as little straight")
    public void bigStraightAsLittleStraight() {
        Yacht yacht = new Yacht(new int[]{ 6, 5, 4, 3, 2 }, YachtCategory.LITTLE_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(0);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("No pairs but not a big straight")
    public void noPairsButNotABigStraight() {
        Yacht yacht = new Yacht(new int[]{ 6, 5, 4, 3, 1 }, YachtCategory.BIG_STRAIGHT);
        assertThat(yacht.score()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Choice")
    public void choice() {
        Yacht yacht = new Yacht(new int[]{ 3, 3, 5, 6, 6 }, YachtCategory.CHOICE);
        assertThat(yacht.score()).isEqualTo(23);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Yacht as choice")
    public void yachtAsChoice() {
        Yacht yacht = new Yacht(new int[]{ 2, 2, 2, 2, 2 }, YachtCategory.CHOICE);
        assertThat(yacht.score()).isEqualTo(10);
    }

}
