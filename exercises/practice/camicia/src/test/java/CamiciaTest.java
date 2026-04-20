import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamiciaTest {
    private static final String FINISHED = "finished";
    private static final String LOOP = "loop";

    private Camicia simulateGame(List<String> playerA, List<String> playerB) {
        Camicia camicia = new Camicia();
        camicia.simulateGame(playerA, playerB);

        return camicia;
    }

    @Test
    @DisplayName("two cards, one trick")
    public void twoCardsOneTrick() {
        List<String> playerA = List.of("2");
        List<String> playerB = List.of("3");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(2, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Test
    @DisplayName("three cards, one trick")
    public void threeCardsOneTrick() {
        List<String> playerA = List.of("2", "4");
        List<String> playerB = List.of("3");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(3, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Test
    @DisplayName("four cards, one trick")
    public void fourCardsOneTrick() {
        List<String> playerA = List.of("2", "4");
        List<String> playerB = List.of("3", "5", "6");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(4, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Test
    @DisplayName("the ace reigns supreme")
    public void theAceReignsSupreme() {
        List<String> playerA = List.of("2", "A");
        List<String> playerB = List.of("3", "4", "5", "6", "7");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(7, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the king beats ace")
    public void theKingBeatsAce() {
        List<String> playerA = List.of("2", "A");
        List<String> playerB = List.of("3", "4", "5", "6", "K");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(7, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the queen seduces the king")
    public void theQueenSeducesTheKing() {
        List<String> playerA = List.of("2", "A", "7", "8", "Q");
        List<String> playerB = List.of("3", "4", "5", "6", "K");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(10, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the jack betrays the queen")
    public void theJackBetraysTheQueen() {
        List<String> playerA = List.of("2", "A", "7", "8", "Q");
        List<String> playerB = List.of("3", "4", "5", "6", "K", "9", "J");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(12, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the 10 just wants to put on a show")
    public void theTenJustWantsToPutOnAShow() {
        List<String> playerA = List.of("2", "A", "7", "8", "Q", "10");
        List<String> playerB = List.of("3", "4", "5", "6", "K", "9", "J");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(13, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("simple loop with decks of 3 cards")
    public void simpleLoopWithDecksOfThreeCards() {
        List<String> playerA = List.of("J", "2", "3");
        List<String> playerB = List.of("4", "J", "5");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(LOOP, camicia.getStatus());
        assertEquals(8, camicia.getCards());
        assertEquals(3, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the story is starting to get a bit complicated")
    public void theStoryIsStartingToGetAbitComplicated() {
        List<String> playerA = List.of(
                "2", "6", "6", "J", "4", "K", "Q", "10", "K", "J", "Q", "2", "3", "K", "5", "6", "Q", "Q", "A", "A",
                "6", "9", "K", "A", "8", "K", "2", "A", "9", "A", "Q", "4", "K", "K", "K", "3", "5", "K", "8", "Q",
                "3", "Q", "7", "J", "K", "J", "9", "J", "3", "3", "K", "K", "Q", "A", "K", "7", "10", "A", "Q", "7",
                "10", "J", "4", "5", "J", "9", "10", "Q", "J", "J", "K", "6", "10", "J", "6", "Q", "J", "5", "J", "Q",
                "Q", "8", "3", "8", "A", "2", "6", "9", "K", "7", "J", "K", "K", "8", "K", "Q", "6", "10", "J", "10",
                "J", "Q", "J", "10", "3", "8", "K", "A", "6", "9", "K", "2", "A", "A", "10", "J", "6", "A", "4", "J",
                "A", "J", "J", "6", "2", "J", "3", "K", "2", "5", "9", "J", "9", "6", "K", "A", "5", "Q", "J", "2",
                "Q", "K", "A", "3", "K", "J", "K", "2", "5", "6", "Q", "J", "Q", "Q", "J", "2", "J", "9", "Q", "7",
                "7", "A", "Q", "7", "Q", "J", "K", "J", "A", "7", "7", "8", "Q", "10", "J", "10", "J", "J", "9", "2",
                "A", "2"
        );
        List<String> playerB = List.of(
                "7", "2", "10", "K", "8", "2", "J", "9", "A", "5", "6", "J", "Q", "6", "K", "6", "5", "A", "4", "Q",
                "7", "J", "7", "10", "2", "Q", "8", "2", "2", "K", "J", "A", "5", "5", "A", "4", "Q", "6", "Q", "K",
                "10", "8", "Q", "2", "10", "J", "A", "Q", "8", "Q", "Q", "J", "J", "A", "A", "9", "10", "J", "K", "4",
                "Q", "10", "10", "J", "K", "10", "2", "J", "7", "A", "K", "K", "J", "A", "J", "10", "8", "K", "A", "7",
                "Q", "Q", "J", "3", "Q", "4", "A", "3", "A", "Q", "Q", "Q", "5", "4", "K", "J", "10", "A", "Q", "J",
                "6", "J", "A", "10", "A", "5", "8", "3", "K", "5", "9", "Q", "8", "7", "7", "J", "7", "Q", "Q", "Q",
                "A", "7", "8", "9", "A", "Q", "A", "K", "8", "A", "A", "J", "8", "4", "8", "K", "J", "A", "10", "Q",
                "8", "J", "8", "6", "10", "Q", "J", "J", "A", "A", "J", "5", "Q", "6", "J", "K", "Q", "8", "K", "4",
                "Q", "Q", "6", "J", "K", "4", "7", "J", "J", "9", "9", "A", "Q", "Q", "K", "A", "6", "5", "K"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(361, camicia.getCards());
        assertEquals(1, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two tricks")
    public void twoTricks() {
        List<String> playerA = List.of("J");
        List<String> playerB = List.of("3", "J");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(5, camicia.getCards());
        assertEquals(2, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more tricks")
    public void moreTricks() {
        List<String> playerA = List.of("J", "2", "4");
        List<String> playerB = List.of("3", "J", "A");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(12, camicia.getCards());
        assertEquals(4, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("simple loop with decks of 4 cards")
    public void simpleLoopWithDecksOfFourCards() {
        List<String> playerA = List.of("2", "3", "J", "6");
        List<String> playerB = List.of("K", "5", "J", "7");

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(LOOP, camicia.getStatus());
        assertEquals(16, camicia.getCards());
        assertEquals(4, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("easy card combination")
    public void easyCardCombination() {
        List<String> playerA = List.of(
                "4", "8", "7", "5", "4", "10", "3", "9", "7", "3", "10", "10", "6", "8", "2", "8", "5", "4", "5",
                "9", "6", "5", "2", "8", "10", "9"
        );
        List<String> playerB = List.of(
                "6", "9", "4", "7", "2", "2", "3", "6", "7", "3", "A", "A", "A", "A", "K", "K", "K", "K", "Q", "Q",
                "Q", "Q", "J", "J", "J", "J"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(40, camicia.getCards());
        assertEquals(4, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("easy card combination, inverted decks")
    public void easyCardCombinationInvertedDecks() {
        List<String> playerA = List.of(
                "3", "3", "5", "7", "3", "2", "10", "7", "6", "7", "A", "A", "A", "A", "K", "K", "K", "K", "Q",
                "Q", "Q", "Q", "J", "J", "J", "J"
        );
        List<String> playerB = List.of(
                "5", "10", "8", "2", "6", "7", "2", "4", "9", "2", "6", "10", "10", "5", "4", "8", "4", "8", "6",
                "9", "8", "5", "9", "3", "4", "9"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(40, camicia.getCards());
        assertEquals(4, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("mirrored decks")
    public void mirroredDecks() {
        List<String> playerA = List.of(
                "2", "A", "3", "A", "3", "K", "4", "K", "2", "Q", "2", "Q", "10", "J", "5", "J", "6", "10", "2",
                "9", "10", "7", "3", "9", "6", "9"
        );
        List<String> playerB = List.of(
                "6", "A", "4", "A", "7", "K", "4", "K", "7", "Q", "7", "Q", "5", "J", "8", "J", "4", "5", "8",
                "9", "10", "6", "8", "3", "8", "5"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(59, camicia.getCards());
        assertEquals(4, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("opposite decks")
    public void oppositeDecks() {
        List<String> playerA = List.of(
                "4", "A", "9", "A", "4", "K", "9", "K", "6", "Q", "8", "Q", "8", "J", "10", "J", "9", "8", "4",
                "6", "3", "6", "5", "2", "4", "3"
        );
        List<String> playerB = List.of(
                "10", "7", "3", "2", "9", "2", "7", "8", "7", "5", "J", "7", "J", "10", "Q", "10", "Q", "3", "K",
                "5", "K", "6", "A", "2", "A", "5"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(151, camicia.getCards());
        assertEquals(21, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("random decks #1")
    public void randomDecksOne() {
        List<String> playerA = List.of(
                "K", "10", "9", "8", "J", "8", "6", "9", "7", "A", "K", "5", "4", "4", "J", "5", "J", "4", "3",
                "5", "8", "6", "7", "7", "4", "9"
        );
        List<String> playerB = List.of(
                "6", "3", "K", "A", "Q", "10", "A", "2", "Q", "8", "2", "10", "10", "2", "Q", "3", "K", "9", "7",
                "A", "3", "Q", "5", "J", "2", "6"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(542, camicia.getCards());
        assertEquals(76, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("random decks #2")
    public void randomDecksTwo() {
        List<String> playerA = List.of(
                "8", "A", "4", "8", "5", "Q", "J", "2", "6", "2", "9", "7", "K", "A", "8", "10", "K", "8", "10",
                "9", "K", "6", "7", "3", "K", "9"
        );
        List<String> playerB = List.of(
                "10", "5", "2", "6", "Q", "J", "A", "9", "5", "5", "3", "7", "3", "J", "A", "2", "Q", "3", "J",
                "Q", "4", "10", "4", "7", "4", "6"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(327, camicia.getCards());
        assertEquals(42, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Kleber 1999")
    public void kleber1999() {
        List<String> playerA = List.of(
                "4", "8", "9", "J", "Q", "8", "5", "5", "K", "2", "A", "9", "8", "5", "10", "A", "4", "J", "3",
                "K", "6", "9", "2", "Q", "K", "7"
        );
        List<String> playerB = List.of(
                "10", "J", "3", "2", "4", "10", "4", "7", "5", "3", "6", "6", "7", "A", "J", "Q", "A", "7", "2",
                "10", "3", "K", "9", "6", "8", "Q"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(5790, camicia.getCards());
        assertEquals(805, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Collins 2006")
    public void collins2006() {
        List<String> playerA = List.of(
                "A", "8", "Q", "K", "9", "10", "3", "7", "4", "2", "Q", "3", "2", "10", "9", "K", "A", "8", "7",
                "7", "4", "5", "J", "9", "2", "10"
        );
        List<String> playerB = List.of(
                "4", "J", "A", "K", "8", "5", "6", "6", "A", "6", "5", "Q", "4", "6", "10", "8", "J", "2", "5",
                "7", "Q", "J", "3", "3", "K", "9"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(6913, camicia.getCards());
        assertEquals(960, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Mann and Wu 2007")
    public void mannAndWu2007() {
        List<String> playerA = List.of(
                "K", "2", "K", "K", "3", "3", "6", "10", "K", "6", "A", "2", "5", "5", "7", "9", "J", "A", "A",
                "3", "4", "Q", "4", "8", "J", "6"
        );
        List<String> playerB = List.of(
                "4", "5", "2", "Q", "7", "9", "9", "Q", "7", "J", "9", "8", "10", "3", "10", "J", "4", "10", "8",
                "6", "8", "7", "A", "Q", "5", "2"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(7157, camicia.getCards());
        assertEquals(1007, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Nessler 2012")
    public void nessler2012() {
        List<String> playerA = List.of(
                "10", "3", "6", "7", "Q", "2", "9", "8", "2", "8", "4", "A", "10", "6", "K", "2", "10", "A", "5",
                "A", "2", "4", "Q", "J", "K", "4"
        );
        List<String> playerB = List.of(
                "10", "Q", "4", "6", "J", "9", "3", "J", "9", "3", "3", "Q", "K", "5", "9", "5", "K", "6", "5",
                "7", "8", "J", "A", "7", "8", "7"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(7207, camicia.getCards());
        assertEquals(1015, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Anderson 2013")
    public void anderson2013() {
        List<String> playerA = List.of(
                "6", "7", "A", "3", "Q", "3", "5", "J", "3", "2", "J", "7", "4", "5", "Q", "10", "5", "A", "J",
                "2", "K", "8", "9", "9", "K", "3"
        );
        List<String> playerB = List.of(
                "4", "J", "6", "9", "8", "5", "10", "7", "9", "Q", "2", "7", "10", "8", "4", "10", "A", "6", "4",
                "A", "6", "8", "Q", "K", "K", "2"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(7225, camicia.getCards());
        assertEquals(1016, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Rucklidge 2014")
    public void rucklidge2014() {
        List<String> playerA = List.of(
                "8", "J", "2", "9", "4", "4", "5", "8", "Q", "3", "9", "3", "6", "2", "8", "A", "A", "A", "9",
                "4", "7", "2", "5", "Q", "Q", "3"
        );
        List<String> playerB = List.of(
                "K", "7", "10", "6", "3", "J", "A", "7", "6", "5", "5", "8", "10", "9", "10", "4", "2", "7", "K",
                "Q", "10", "K", "6", "J", "J", "K"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(7959, camicia.getCards());
        assertEquals(1122, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Nessler 2021")
    public void nessler2021() {
        List<String> playerA = List.of(
                "7", "2", "3", "4", "K", "9", "6", "10", "A", "8", "9", "Q", "7", "A", "4", "8", "J", "J", "A",
                "4", "3", "2", "5", "6", "6", "J"
        );
        List<String> playerB = List.of(
                "3", "10", "8", "9", "8", "K", "K", "2", "5", "5", "7", "6", "4", "3", "5", "7", "A", "9", "J",
                "K", "2", "Q", "10", "Q", "10", "Q"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(7972, camicia.getCards());
        assertEquals(1106, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Nessler 2022")
    public void nessler2022() {
        List<String> playerA = List.of(
                "2", "10", "10", "A", "J", "3", "8", "Q", "2", "5", "5", "5", "9", "2", "4", "3", "10", "Q", "A",
                "K", "Q", "J", "J", "9", "Q", "K"
        );
        List<String> playerB = List.of(
                "10", "7", "6", "3", "6", "A", "8", "9", "4", "3", "K", "J", "6", "K", "4", "9", "7", "8", "5",
                "7", "8", "2", "A", "7", "4", "6"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(FINISHED, camicia.getStatus());
        assertEquals(8344, camicia.getCards());
        assertEquals(1164, camicia.getTricks());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Casella 2024, first infinite game found")
    public void casella2024FirstInfiniteGameFound() {
        List<String> playerA = List.of(
                "2", "8", "4", "K", "5", "2", "3", "Q", "6", "K", "Q", "A", "J", "3", "5", "9", "8", "3", "A",
                "A", "J", "4", "4", "J", "7", "5"
        );
        List<String> playerB = List.of(
                "7", "7", "8", "6", "10", "10", "6", "10", "7", "2", "Q", "6", "3", "2", "4", "K", "Q", "10", "J",
                "5", "9", "8", "9", "9", "K", "A"
        );

        Camicia camicia = simulateGame(playerA, playerB);

        assertEquals(LOOP, camicia.getStatus());
        assertEquals(474, camicia.getCards());
        assertEquals(66, camicia.getTricks());
    }
}
