import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.*;


public class BlackjackTest {

    private Blackjack blackjack;

    @Before
    public void setUp() {
        blackjack = new Blackjack();
    }

    @Test
    public void correctParsesAce () {
        assertThat(blackjack.parseCard("ace")).isEqualTo(11);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesTwo () {
        assertThat(blackjack.parseCard("two")).isEqualTo(2);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesThree () {
        assertThat(blackjack.parseCard("three")).isEqualTo(3);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesFour () {
        assertThat(blackjack.parseCard("four")).isEqualTo(4);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesFive () {
        assertThat(blackjack.parseCard("five")).isEqualTo(5);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesSix () {
        assertThat(blackjack.parseCard("six")).isEqualTo(6);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesSeven () {
        assertThat(blackjack.parseCard("seven")).isEqualTo(7);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesEight () {
        assertThat(blackjack.parseCard("eight")).isEqualTo(8);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesNine () {
        assertThat(blackjack.parseCard("nine")).isEqualTo(9);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesTen () {
        assertThat(blackjack.parseCard("ten")).isEqualTo(10);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesJack () {
        assertThat(blackjack.parseCard("jack")).isEqualTo(10);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesQueen () {
        assertThat(blackjack.parseCard("queen")).isEqualTo(10);
    }

    @Test
    @Ignore("Remove to run the test")
    public void correctParsesKing () {
        assertThat(blackjack.parseCard("king")).isEqualTo(10);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void blackjackWithTenAceSecond() {
        assertThat(blackjack.isBlackjack("ten", "ace")).isEqualTo(true);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void blackjackWithJackAceSecond() {
        assertThat(blackjack.isBlackjack("jack", "ace")).isEqualTo(true);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void blackjackWithQueenAceSecond() {
        assertThat(blackjack.isBlackjack("queen", "ace")).isEqualTo(true);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void blackjackWithKingAceSecond() {
        assertThat(blackjack.isBlackjack("king", "ace")).isEqualTo(true);
    }   
    
    
    @Test
    @Ignore("Remove to run the test")
    public void noBlackjackWithFive() {
        assertThat(blackjack.isBlackjack("ace", "five")).isEqualTo(false);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void noBlackjackWithNine() {
        assertThat(blackjack.isBlackjack("ace", "nine")).isEqualTo(false);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void noBlackjackWithTwoAces() {
        assertThat(blackjack.isBlackjack("ace", "ace")).isEqualTo(false);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void noBlackjackWithTwoFigures() {
        assertThat(blackjack.isBlackjack("queen", "jack")).isEqualTo(false);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void noBlackjackWithKingAndFive() {
        assertThat(blackjack.isBlackjack("king", "five")).isEqualTo(false);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void noBlackjackWithEightAndFive() {
        assertThat(blackjack.isBlackjack("eight", "five")).isEqualTo(false);
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithAceAceAndDealerAce () {
        assertThat(blackjack.firstTurn("ace", "ace", "ace")).isEqualTo("P");
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithJackJackAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "jack", "ace")).isEqualTo("S");
    }
    
    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithKingKingAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "king", "ace")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoTwoAndDealerAce () {
        assertThat(blackjack.firstTurn("two", "two", "ace")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithFiveFiveAndAce () {
        assertThat(blackjack.firstTurn("five", "five", "ace")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithJackAceAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "ace", "ace")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithAceKingAndDealerQueen () {
        assertThat(blackjack.firstTurn("ace", "king", "queen")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTenAceAndDealerFive () {
        assertThat(blackjack.firstTurn("ten", "ace", "five")).isEqualTo("W");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithKingAceAndDealerNine () {
        assertThat(blackjack.firstTurn("king", "ace", "nine")).isEqualTo("W");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithKingTenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "ten", "ace")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithNineTenAndDealerAce () {
        assertThat(blackjack.firstTurn("nine", "ten", "ace")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithEightTenAndDealerAce () {
        assertThat(blackjack.firstTurn("eight", "ten", "ace")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithKingSevenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "seven", "ace")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithSixTenAndDealerSix () {
        assertThat(blackjack.firstTurn("six", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithSixTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("six", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithSixTenAndDealerAce () {
        assertThat(blackjack.firstTurn("six", "ten", "ace")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithFiveTenAndDealerSix () {
        assertThat(blackjack.firstTurn("five", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithFiveTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("five", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithFiveTenAndDealerKing () {
        assertThat(blackjack.firstTurn("five", "ten", "king")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithFourTenAndDealerSix () {
        assertThat(blackjack.firstTurn("four", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithFourTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("four", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithFourTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("four", "ten", "queen")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithThreeTenAndDealerSix () {
        assertThat(blackjack.firstTurn("three", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithThreeTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("three", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithThreeTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("three", "ten", "queen")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoTenAndDealerSix () {
        assertThat(blackjack.firstTurn("two", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("two", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "ten", "queen")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoNineAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "nine", "queen")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoEightAndDealerTwo () {
        assertThat(blackjack.firstTurn("two", "eight", "two")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoThreeAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "three", "queen")).isEqualTo("H");
    }

    @Test
    @Ignore("Remove to run the test")
    public void firstTurnWithTwoTwoAndDealerFive () {
        assertThat(blackjack.firstTurn("two", "two", "five")).isEqualTo("H");
    }

}
