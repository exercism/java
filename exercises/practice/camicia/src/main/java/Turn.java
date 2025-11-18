import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

class Turn {
    private final int roundNumber;
    private final ArrayDeque<Card> playerADeck;
    private final ArrayDeque<Card> playerBDeck;
    private final Penalty penalty;
    private ArrayDeque<Card> pile = new ArrayDeque<>();
    private Turn previousRound;
    private Player playerPlacedLastPaymentCard;
    private int trick = 0;
    private int playedCardCounter = 0;

    private Player player;
    private Card playedCard;
    private Player nextPlayer;

    Turn(List<String> playerAList, List<String> playerBList) {
        roundNumber = 0;
        playerADeck = playerAList.stream()
                .map(Card::new)
                .collect(Collectors.toCollection(ArrayDeque::new));

        playerBDeck = playerBList.stream()
                .map(Card::new)
                .collect(Collectors.toCollection(ArrayDeque::new));

        penalty = new Penalty();
    }

    Turn(Turn previousRound) {
        this.roundNumber = previousRound.roundNumber + 1;
        this.playerADeck = new ArrayDeque<>(previousRound.playerADeck);
        this.playerBDeck = new ArrayDeque<>(previousRound.playerBDeck);
        this.previousRound = previousRound;
        this.pile = previousRound.pile;
        this.penalty = previousRound.penalty;
        this.trick = previousRound.trick;
        this.playedCardCounter = previousRound.playedCardCounter;
        this.player = previousRound.nextPlayer;
        this.playerPlacedLastPaymentCard = previousRound.playerPlacedLastPaymentCard;
    }

    boolean playTurn() {
        if (isInitialRound()) {
            defineNextPlayer();
            return false;
        }

        nextMove();
        defineNextPlayer();
        return win();
    }

    boolean isInitialRound() {
        return roundNumber == 0;
    }

    private boolean win() {
        return getCards(player).size() == totalCards();
    }

    private void nextMove() {
        if (collectPile()) {
            return;
        }

        playCard();
    }

    private void playCard() {
        if (getCards(player).isEmpty()) {
            // player cannot play
            return;
        }

        playedCard = switch (player) {
            case A -> playerADeck.removeFirst();
            case B -> playerBDeck.removeFirst();
        };

        pile.add(playedCard);
        increasePlayedCard();
        deductPenalty();
        setPlayerPlacedLastPaymentCard();
    }

    private void increasePlayedCard() {
        playedCardCounter++;
    }

    private void deductPenalty() {
        if (penalty == null) {
            return;
        }

        if (!player.equals(penalty.getPlayer())) {
            return;
        }

        if (playedCard.isPaymentCard()) {
            penalty.set(opponent(player), playedCard);
            return;
        }

        penalty.deduct();
    }

    private void definePenalty(Card playedCard) {
        if (!playedCard.isPaymentCard()) {
            return;
        }

        Player penaltyPlayer = opponent(player);
        penalty.set(penaltyPlayer, playedCard);
    }

    private void setPlayerPlacedLastPaymentCard() {
        if (!playedCard.isPaymentCard()) {
            return;
        }

        this.playerPlacedLastPaymentCard = player;
        definePenalty(playedCard);
    }

    private boolean collectPile() {
        boolean opponentDeckExhausted = isOpponentDeckExhausted();
        boolean opponentUnableToPayPenalty = isOpponentUnableToPayPenalty();
        boolean penaltyFullyPaidByOpponent = isPenaltyFullyPaidByOpponent();

        if (opponentDeckExhausted || opponentUnableToPayPenalty || penaltyFullyPaidByOpponent) {
            switch (player) {
                case A -> playerADeck.addAll(pile);
                case B -> playerBDeck.addAll(pile);
            }

            pile.clear();

            trick++;

            if (isPenaltyFullyPaidByOpponent()) {
                nextPlayer = player;
                penalty.clear();
            }

            return true;
        }

        return false;
    }

    private boolean isPenaltyFullyPaidByOpponent() {
        Player otherPlayer = opponent(player);

        return player.equals(playerPlacedLastPaymentCard) &&
                penalty.isFullyPaid(otherPlayer);
    }

    private boolean isOpponentUnableToPayPenalty() {
        Player opponent = opponent(player);

        return opponent.equals(previousRound.player) &&
                isPenaltyActive(opponent) &&
                getCards(opponent).isEmpty();
    }

    private boolean isOpponentDeckExhausted() {
        Player opponent = opponent(player);

        return opponent.equals(previousRound.player) &&
                previousRound.playedCard == null &&
                getCards(opponent).isEmpty();
    }

    private int totalCards() {
        return playerADeck.size() + playerBDeck.size() + pile.size();
    }

    private void defineNextPlayer() {
        if (nextPlayer != null) {
            return;
        }

        if (isInitialRound()) {
            nextPlayer = Player.A;
            return;
        }

        if (isPenaltyActive()) {
            if (isPlayerDeckEmpty(penalty.getPlayer())) {
                nextPlayer = opponent(player);
            } else {
                nextPlayer = penalty.getPlayer();
            }
            return;
        }

        if (penalty.isFullyPaid()) {
            nextPlayer = playerPlacedLastPaymentCard;
            return;
        }

        nextPlayer = opponent(player);
    }

    private boolean isPenaltyActive() {
        return penalty != null && penalty.isActive();
    }

    private boolean isPenaltyActive(Player player) {
        return penalty != null && penalty.isActive(player);
    }

    private boolean isPlayerDeckEmpty(Player player) {
        return switch (player) {
            case A -> playerADeck.isEmpty();
            case B -> playerBDeck.isEmpty();
        };
    }

    private Player opponent(Player player) {
        if (player == null) {
            return Player.A;
        }


        return switch (player) {
            case Player.A -> Player.B;
            case Player.B -> Player.A;
        };
    }

    private Deque<Card> getCards(Player player) {
        return switch (player) {
            case A -> playerADeck;
            case B -> playerBDeck;
        };
    }

    int getPlayedCardCounter() {
        return playedCardCounter;
    }

    int getTrick() {
        return trick;
    }

    @Override
    public String toString() {
        return roundNumber + "." +
                " player=" + player +
                ", playedCard=" + playedCard +
                ", nextPlayer=" + nextPlayer +
                ", DeckA=" + playerADeck +
                ", DeckB=" + playerBDeck +
                ", pile=" + pile +
                ", penalty=" + penalty +
                ", trick=" + trick
                ;
    }

    enum Player {
        A,
        B
    }

}
