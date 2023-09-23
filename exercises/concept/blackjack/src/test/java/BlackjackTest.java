import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class BlackjackTest {

    private Blackjack blackjack;

    @BeforeEach
    public void setUp() {
        blackjack = new Blackjack();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name ace")
    public void correctParsesAce () {
        assertThat(blackjack.parseCard("ace")).isEqualTo(11);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name two")
    public void correctParsesTwo () {
        assertThat(blackjack.parseCard("two")).isEqualTo(2);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name three")
    public void correctParsesThree () {
        assertThat(blackjack.parseCard("three")).isEqualTo(3);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name four")
    public void correctParsesFour () {
        assertThat(blackjack.parseCard("four")).isEqualTo(4);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name five")
    public void correctParsesFive () {
        assertThat(blackjack.parseCard("five")).isEqualTo(5);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name six")
    public void correctParsesSix () {
        assertThat(blackjack.parseCard("six")).isEqualTo(6);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name seven")
    public void correctParsesSeven () {
        assertThat(blackjack.parseCard("seven")).isEqualTo(7);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name eight")
    public void correctParsesEight () {
        assertThat(blackjack.parseCard("eight")).isEqualTo(8);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name nine")
    public void correctParsesNine () {
        assertThat(blackjack.parseCard("nine")).isEqualTo(9);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name ten")
    public void correctParsesTen () {
        assertThat(blackjack.parseCard("ten")).isEqualTo(10);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name jack")
    public void correctParsesJack () {
        assertThat(blackjack.parseCard("jack")).isEqualTo(10);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name queen")
    public void correctParsesQueen () {
        assertThat(blackjack.parseCard("queen")).isEqualTo(10);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The parseCard returns the correct numerical value for card name king")
    public void correctParsesKing () {
        assertThat(blackjack.parseCard("king")).isEqualTo(10);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns true with ten and ace")
    public void blackjackWithTenAceSecond() {
        assertThat(blackjack.isBlackjack("ten", "ace")).isEqualTo(true);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns true with jack and ace")
    public void blackjackWithJackAceSecond() {
        assertThat(blackjack.isBlackjack("jack", "ace")).isEqualTo(true);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns true with queen and ace")
    public void blackjackWithQueenAceSecond() {
        assertThat(blackjack.isBlackjack("queen", "ace")).isEqualTo(true);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns true with king and ace")
    public void blackjackWithKingAceSecond() {
        assertThat(blackjack.isBlackjack("king", "ace")).isEqualTo(true);
    }   
    
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns false with ace and five")
    public void noBlackjackWithFive() {
        assertThat(blackjack.isBlackjack("ace", "five")).isEqualTo(false);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns false with ace and nine")
    public void noBlackjackWithNine() {
        assertThat(blackjack.isBlackjack("ace", "nine")).isEqualTo(false);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns false with ace and ace")
    public void noBlackjackWithTwoAces() {
        assertThat(blackjack.isBlackjack("ace", "ace")).isEqualTo(false);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns false with queen and jack")
    public void noBlackjackWithTwoFigures() {
        assertThat(blackjack.isBlackjack("queen", "jack")).isEqualTo(false);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns false with king and five")
    public void noBlackjackWithKingAndFive() {
        assertThat(blackjack.isBlackjack("king", "five")).isEqualTo(false);
    }
    
    @Test
    @Tag("task:2")
    @DisplayName("The isBlackjack method returns false with eight and five")
    public void noBlackjackWithEightAndFive() {
        assertThat(blackjack.isBlackjack("eight", "five")).isEqualTo(false);
    }
    
    @Test
    @Tag("task:3")
    @DisplayName("The firstTurn method returns strategy Split given ace-ace and dealer ace")
    public void firstTurnWithAceAceAndDealerAce () {
        assertThat(blackjack.firstTurn("ace", "ace", "ace")).isEqualTo("P");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The firstTurn method returns strategy Stand given jack-ace and dealer ace")
    public void firstTurnWithJackAceAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "ace", "ace")).isEqualTo("S");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The firstTurn method returns strategy Stand given ace-king and dealer queen")
    public void firstTurnWithAceKingAndDealerQueen () {
        assertThat(blackjack.firstTurn("ace", "king", "queen")).isEqualTo("S");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The firstTurn method returns strategy Automatically Win given ten-ace and dealer five")
    public void firstTurnWithTenAceAndDealerFive () {
        assertThat(blackjack.firstTurn("ten", "ace", "five")).isEqualTo("W");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The firstTurn method returns strategy Automatically Win given king-ace and dealer nine")
    public void firstTurnWithKingAceAndDealerNine () {
        assertThat(blackjack.firstTurn("king", "ace", "nine")).isEqualTo("W");
    }
    
    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given jack-jack and dealer ace")
    public void firstTurnWithJackJackAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "jack", "ace")).isEqualTo("S");
    }
    
    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given king-king and dealer ace")
    public void firstTurnWithKingKingAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "king", "ace")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given two-two and dealer ace")
    public void firstTurnWithTwoTwoAndDealerAce () {
        assertThat(blackjack.firstTurn("two", "two", "ace")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given five-five and dealer ace")
    public void firstTurnWithFiveFiveAndAce () {
        assertThat(blackjack.firstTurn("five", "five", "ace")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given king-ten and dealer ace")
    public void firstTurnWithKingTenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "ten", "ace")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given nine-ten and dealer ace")
    public void firstTurnWithNineTenAndDealerAce () {
        assertThat(blackjack.firstTurn("nine", "ten", "ace")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given eight-ten and dealer ace")
    public void firstTurnWithEightTenAndDealerAce () {
        assertThat(blackjack.firstTurn("eight", "ten", "ace")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given king-seven and dealer ace")
    public void firstTurnWithKingSevenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "seven", "ace")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given six-ten and dealer six")
    public void firstTurnWithSixTenAndDealerSix () {
        assertThat(blackjack.firstTurn("six", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given six-ten and dealer seven")
    public void firstTurnWithSixTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("six", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given six-ten and dealer ace")
    public void firstTurnWithSixTenAndDealerAce () {
        assertThat(blackjack.firstTurn("six", "ten", "ace")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given five-ten and dealer six")
    public void firstTurnWithFiveTenAndDealerSix () {
        assertThat(blackjack.firstTurn("five", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given five-ten and dealer seven")
    public void firstTurnWithFiveTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("five", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given five-ten and dealer king")
    public void firstTurnWithFiveTenAndDealerKing () {
        assertThat(blackjack.firstTurn("five", "ten", "king")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given four-ten and dealer six")
    public void firstTurnWithFourTenAndDealerSix () {
        assertThat(blackjack.firstTurn("four", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given four-ten and dealer seven")
    public void firstTurnWithFourTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("four", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given four-ten and dealer queen")
    public void firstTurnWithFourTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("four", "ten", "queen")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given three-ten and dealer six")
    public void firstTurnWithThreeTenAndDealerSix () {
        assertThat(blackjack.firstTurn("three", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given three-ten and dealer seven")
    public void firstTurnWithThreeTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("three", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given three-ten and dealer queen")
    public void firstTurnWithThreeTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("three", "ten", "queen")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Stand given two-ten and dealer six")
    public void firstTurnWithTwoTenAndDealerSix () {
        assertThat(blackjack.firstTurn("two", "ten", "six")).isEqualTo("S");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given two-ten and dealer seven")
    public void firstTurnWithTwoTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("two", "ten", "seven")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given two-ten and dealer queen")
    public void firstTurnWithTwoTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "ten", "queen")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given two-nine and dealer queen")
    public void firstTurnWithTwoNineAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "nine", "queen")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given two-eight and dealer two")
    public void firstTurnWithTwoEightAndDealerTwo () {
        assertThat(blackjack.firstTurn("two", "eight", "two")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given two-three and dealer queen")
    public void firstTurnWithTwoThreeAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "three", "queen")).isEqualTo("H");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The firstTurn method returns strategy Hit given two-two and dealer five")
    public void firstTurnWithTwoTwoAndDealerFive () {
        assertThat(blackjack.firstTurn("two", "two", "five")).isEqualTo("H");
    }

}
