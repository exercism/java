import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Camicia {

    private Status status;
    private int cards;
    private int tricks;

    private enum Player {
        PLAYER_A, PLAYER_B
    }

    private enum Status {
        FINISHED, LOOP
    }

    private static int penaltyOf(String card) {
        return switch (card) {
            case "J" -> 1;
            case "Q" -> 2;
            case "K" -> 3;
            case "A" -> 4;
            default -> 0;
        };
    }

    private static boolean isPaymentCard(String card) {
        return penaltyOf(card) > 0;
    }

    /**
     * Return a snapshot of the current state
     */
    private static String stateKey(Deque<String> deckA, Deque<String> deckB) {
        StringBuilder sb = new StringBuilder();

        for (String card : deckA) {
            sb.append(isPaymentCard(card) ? card : "N");
        }

        sb.append('|');

        for (String card : deckB) {
            sb.append(isPaymentCard(card) ? card : "N");
        }

        return sb.toString();
    }

    private static Player otherPlayer(Player player) {
        return player == Player.PLAYER_A ? Player.PLAYER_B : Player.PLAYER_A;
    }

    private static Deque<String> deckOf(Player player, Deque<String> deckA, Deque<String> deckB) {
        return player == Player.PLAYER_A ? deckA : deckB;
    }

    public static CamiciaResult simulateGame(List<String> playerA, List<String> playerB) {
        Deque<String> deckA = new ArrayDeque<>(playerA);
        Deque<String> deckB = new ArrayDeque<>(playerB);

        int cardsPlayed = 0;
        int tricksCount = 0;
        Player current = Player.PLAYER_A;

        Set<String> seenStates = new HashSet<>();

        while (true) {
            String key = stateKey(deckA, deckB);
            // Key already exists, which means this is a loop
            if (!seenStates.add(key)) {
                return finishGame(Status.LOOP, cardsPlayed, tricksCount);
            }

            // Otherwise, play next round
            RoundResult result = playRound(deckA, deckB, current);

            cardsPlayed += result.pileSize();
            tricksCount++;

            // Check if someone wins and finish the game
            if (hasWinner(deckA, deckB)) {
                return finishGame(Status.FINISHED, cardsPlayed, tricksCount);
            }

            // Otherwise, play next round
            current = result.nextStarter();
        }
    }

    private static RoundResult playRound(Deque<String> deckA, Deque<String> deckB, Player startingPlayer) {
        Deque<String> pile = new ArrayDeque<>(); // cards played in this round
        Player currentPlayer = startingPlayer;
        int pendingPenalty = 0;

        while (true) {
            Deque<String> currentPlayerDeck = deckOf(currentPlayer, deckA, deckB);
            Player opponent = otherPlayer(currentPlayer);
            Deque<String> opponentDeck = deckOf(opponent, deckA, deckB);

            // Current player deck is empty, opponent collects all pile, end this round
            if (currentPlayerDeck.isEmpty()) {
                opponentDeck.addAll(pile);
                return new RoundResult(opponent, pile.size());
            }

            // Otherwise, current player plays 1 card, add to pile
            String card = currentPlayerDeck.poll();
            pile.addLast(card);

            // Current player must pay off pending penalty
            if (pendingPenalty > 0) {
                // And player reveals a payment card
                if (isPaymentCard(card)) {
                    // reset penalty based on new card, switch turn
                    pendingPenalty = penaltyOf(card);
                    currentPlayer = opponent;
                } else {
                    // Otherwise, deduct penalty
                    pendingPenalty--;
                    // No pending penalty
                    if (pendingPenalty == 0) {
                        // Opponent collects all pile and win the round
                        deckOf(opponent, deckA, deckB).addAll(pile);
                        return new RoundResult(opponent, pile.size());
                    }
                }
            } else {
                // Normal gameplay, without pending penalty
                // If player reveals a payment card, update penalty
                if (isPaymentCard(card)) {
                    pendingPenalty = penaltyOf(card);
                }
                currentPlayer = opponent;
            }
        }
    }

    private static CamiciaResult finishGame(Status status, int cardsPlayed, int tricksCount) {
        return new CamiciaResult(status == null ? null : status.toString().toLowerCase(), cardsPlayed, tricksCount);
    }

    private static boolean hasWinner(Deque<String> deckA, Deque<String> deckB) {
        return deckA.isEmpty() || deckB.isEmpty();
    }

    /**
     * Immutable round result
     */
    private record RoundResult(Player nextStarter, int pileSize) {
    }
}
