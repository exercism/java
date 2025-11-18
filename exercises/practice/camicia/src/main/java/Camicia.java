import java.util.*;

class Camicia {

    private MatchResult matchResult;

    void simulateGame(List<String> playerAList, List<String> playerBList) {
        Turn initialTurn = new Turn(playerAList, playerBList);
        boolean win = initialTurn.playTurn();
        System.out.println(initialTurn);
        Turn turn = initialTurn;

        while (!win) {
            Turn newTurn = new Turn(turn);
            win = newTurn.playTurn();
            System.out.println(newTurn);

            turn = newTurn;
        }

        matchResult = MatchResult.builder()
                .withStatus(MatchResult.Status.FINISHED)
                .withCards(turn.getPlayedCardCounter())
                .withTricks(turn.getTrick())
                .build();
    }

    String getStatus() {
        return matchResult.getStatus().name().toLowerCase();
    }

    int getCards() {
        return matchResult.getCards();
    }

    int getTricks() {
        return matchResult.getTricks();
    }
}