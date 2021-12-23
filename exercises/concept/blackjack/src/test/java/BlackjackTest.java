import org.junit.Before;
import org.junit.Test;

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
    public void correctParsesTwo () {
        assertThat(blackjack.parseCard("two")).isEqualTo(2);
    }

    @Test
    public void correctParsesThree () {
        assertThat(blackjack.parseCard("three")).isEqualTo(3);
    }

    @Test
    public void correctParsesFour () {
        assertThat(blackjack.parseCard("four")).isEqualTo(4);
    }

    @Test
    public void correctParsesFive () {
        assertThat(blackjack.parseCard("five")).isEqualTo(5);
    }

    @Test
    public void correctParsesSix () {
        assertThat(blackjack.parseCard("six")).isEqualTo(6);
    }

    @Test
    public void correctParsesSeven () {
        assertThat(blackjack.parseCard("seven")).isEqualTo(7);
    }

    @Test
    public void correctParsesEight () {
        assertThat(blackjack.parseCard("eight")).isEqualTo(8);
    }

    @Test
    public void correctParsesNine () {
        assertThat(blackjack.parseCard("nine")).isEqualTo(9);
    }

    @Test
    public void correctParsesTen () {
        assertThat(blackjack.parseCard("ten")).isEqualTo(10);
    }

    @Test
    public void correctParsesJack () {
        assertThat(blackjack.parseCard("jack")).isEqualTo(10);
    }

    @Test
    public void correctParsesQueen () {
        assertThat(blackjack.parseCard("queen")).isEqualTo(10);
    }

    @Test
    public void correctParsesKing () {
        assertThat(blackjack.parseCard("king")).isEqualTo(10);
    }
    
    @Test
    public void blackjackWithTenAceSecond() {
        assertThat(blackjack.isBlackjack("ten", "ace")).isEqualTo(true);
    }
    
    @Test
    public void blackjackWithJackAceSecond() {
        assertThat(blackjack.isBlackjack("jack", "ace")).isEqualTo(true);
    }
    
    @Test
    public void blackjackWithQueenAceSecond() {
        assertThat(blackjack.isBlackjack("queen", "ace")).isEqualTo(true);
    }
    
    @Test
    public void blackjackWithKingAceSecond() {
        assertThat(blackjack.isBlackjack("king", "ace")).isEqualTo(true);
    }   
    
    
    @Test
    public void noBlackjackWithFive() {
        assertThat(blackjack.isBlackjack("ace", "five")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithNine() {
        assertThat(blackjack.isBlackjack("ace", "nine")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithTwoAces() {
        assertThat(blackjack.isBlackjack("ace", "ace")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithTwoFigures() {
        assertThat(blackjack.isBlackjack("queen", "jack")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithKingAndFive() {
        assertThat(blackjack.isBlackjack("king", "five")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithEightAndFive() {
        assertThat(blackjack.isBlackjack("eight", "five")).isEqualTo(false);
    }
    
    @Test
    public void firstTurnWithAceAceAndDealerAce () {
        assertThat(blackjack.firstTurn("ace", "ace", "ace")).isEqualTo("P");
    }
    
    @Test
    public void firstTurnWithJackJackAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "jack", "ace")).isEqualTo("S");
    }
    
    @Test
    public void firstTurnWithKingKingAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "king", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTwoTwoAndDealerAce () {
        assertThat(blackjack.firstTurn("two", "two", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFiveFiveAndAce () {
        assertThat(blackjack.firstTurn("five", "five", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithJackAceAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "ace", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithAceKingAndDealerQueen () {
        assertThat(blackjack.firstTurn("ace", "king", "queen")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTenAceAndDealerFive () {
        assertThat(blackjack.firstTurn("ten", "ace", "five")).isEqualTo("W");
    }

    @Test
    public void firstTurnWithKingAceAndDealerNine () {
        assertThat(blackjack.firstTurn("king", "ace", "nine")).isEqualTo("W");
    }

    @Test
    public void firstTurnWithKingTenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithNineTenAndDealerAce () {
        assertThat(blackjack.firstTurn("nine", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithEightTenAndDealerAce () {
        assertThat(blackjack.firstTurn("eight", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithKingSevenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "seven", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithSixTenAndDealerSix () {
        assertThat(blackjack.firstTurn("six", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithSixTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("six", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithSixTenAndDealerAce () {
        assertThat(blackjack.firstTurn("six", "ten", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerSix () {
        assertThat(blackjack.firstTurn("five", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("five", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerKing () {
        assertThat(blackjack.firstTurn("five", "ten", "king")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFourTenAndDealerSix () {
        assertThat(blackjack.firstTurn("four", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFourTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("four", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFourTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("four", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerSix () {
        assertThat(blackjack.firstTurn("three", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("three", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("three", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerSix () {
        assertThat(blackjack.firstTurn("two", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("two", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoNineAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "nine", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoEightAndDealerTwo () {
        assertThat(blackjack.firstTurn("two", "eight", "two")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoThreeAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "three", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoTwoAndDealerFive () {
        assertThat(blackjack.firstTurn("two", "two", "five")).isEqualTo("H");
    }

}
