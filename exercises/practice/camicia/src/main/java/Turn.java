import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

class Turn {
    private final int roundNumber;
    private final ArrayDeque<Card> playerACards;
    private final ArrayDeque<Card> playerBCards;
    private ArrayDeque<Card> pile = new ArrayDeque<>();
    private Penalty penalty;
    private Turn previousRound;
    private Player playerPlacedLastPaymentCard;
    private int trick = 0;
    private int playedCardCounter = 0;

    private Player player;
    private Card playedCard;

    Turn(List<String> playerAList, List<String> playerBList) {
        roundNumber = 0;
        playerACards = playerAList.stream()
                .map(Card::new)
                .collect(Collectors.toCollection(ArrayDeque::new));

        playerBCards = playerBList.stream()
                .map(Card::new)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    Turn(Turn previousRound) {
        this.roundNumber = previousRound.roundNumber + 1;
        this.playerACards = previousRound.playerACards;
        this.playerBCards = previousRound.playerBCards;
        this.previousRound = previousRound;
        this.pile = previousRound.pile;
        this.penalty = previousRound.penalty;
        this.playerPlacedLastPaymentCard = previousRound.playerPlacedLastPaymentCard;
        this.trick = previousRound.trick;
        this.playedCardCounter = previousRound.playedCardCounter;
    }

    boolean playTurn() {
        if (isInitialRound()) {
            return false;
        }

        if (isFirstRound()) {
            return playFirstTurn();
        }

        player = definePlayer(previousRound);
        nextMove();
        return win();
    }

    private boolean playFirstTurn() {
        player = Player.A;
        nextMove();

        return win();
    }

    boolean isInitialRound() {
        return roundNumber == 0;
    }

    boolean isFirstRound() {
        return roundNumber == 1;
    }

    private boolean win() {
        return getCards(player).size() == totalCards();
    }

    private Card nextMove() {
        if (collectPile()) {
            return null;
        }

        return playCard();
    }

    private Card playCard() {
        if (getCards(player).isEmpty()) {
            // player cannot play
            return null;
        }

        playedCard = switch (player) {
            case A -> playerACards.removeFirst();
            case B -> playerBCards.removeFirst();
        };

        pile.add(playedCard);
        increasePlayedCard();
        deductPenalty();
        setPlayerPlacedLastPaymentCard();
        return playedCard;
    }

    private void increasePlayedCard() {
        playedCardCounter++;
    }

    private void deductPenalty() {
        if (penalty == null){
            return;
        }

        if(!player.equals(penalty.getPlayer())) {
            return;
        }

        if (playedCard.isPaymentCard()) {
            penalty = new Penalty(passPlayer(player), playedCard.getPenalty());
            return;
        }

        penalty.deduct();
    }

    private void definePenalty(Card playedCard) {
        if (!playedCard.isPaymentCard()) {
            return;
        }

        Player penaltyPlayer = passPlayer(player);
        this.penalty = new Penalty(penaltyPlayer, playedCard.getPenalty());
    }

    private void setPlayerPlacedLastPaymentCard() {
        if (!playedCard.isPaymentCard()) {
            return;
        }

        this.playerPlacedLastPaymentCard = player;
        definePenalty(playedCard);
    }

    private boolean collectPile() {
        Player otherPlayer = passPlayer(player);

        boolean otherPlayerCanPlayNoMore = otherPlayer.equals(previousRound.player) &&
                previousRound.playedCard == null &&
                getCards(otherPlayer).isEmpty();

        boolean otherPlayerHasToPayPenalty = getCards(otherPlayer).isEmpty() &&
                penalty != null &&
                penalty.getPlayer().equals(otherPlayer) &&
                penalty.getPenalty() > 0;

        boolean currentPlayerPlacedLastPaymentCard = player.equals(playerPlacedLastPaymentCard) &&
                penalty != null &&
                !penalty.isInterrupted();

        if (otherPlayerCanPlayNoMore || otherPlayerHasToPayPenalty || currentPlayerPlacedLastPaymentCard) {
            switch (player) {
                case A -> playerACards.addAll(pile);
                case B -> playerBCards.addAll(pile);
            }

            pile.clear();

            trick++;

            return true;
        }

        return false;
    }

    private int totalCards() {
        return playerACards.size() + playerBCards.size() + pile.size();
    }

    private Player definePlayer(Turn previousRound) {
        Penalty previousPenalty = previousRound.penalty;

        if (previousPenalty != null && previousPenalty.getPenalty() > 0 && !getCards(previousPenalty.getPlayer()).isEmpty()) {
            return previousRound.penalty.player;
        }

        return passPlayer(previousRound.player);
    }

    private Player passPlayer(Player player) {
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
            case A -> playerACards;
            case B -> playerBCards;
        };
    }

    int getPlayedCardCounter() {
        return playedCardCounter;
    }

    int getTrick() {
        return trick;
    }

    public Card getPlayedCard() {
        return playedCard;
    }

    @Override
    public String toString() {
        return "MatchRound{" +
                "roundNumber=" + roundNumber +
                ", player=" + player +
                ", playedCard=" + playedCard +
                ", playerACards=" + playerACards +
                ", playerBCards=" + playerBCards +
                ", pile=" + pile +
                ", penalty=" + penalty +
                ", trick=" + trick +
                '}';
    }

    enum Player {
        A,
        B
    }

    class Penalty {
        private Player player;
        private int penalty;
        private boolean interrupted = false;

        Penalty(Player player, int penalty) {
            this.player = player;
            this.penalty = penalty;
        }

        Player getPlayer() {
            return player;
        }

        int getPenalty() {
            return penalty;
        }

        void deduct() {
            if (penalty > 0) {
                penalty -= 1;
            }
        }

        public void setInterrupted(boolean interrupted) {
            this.interrupted = interrupted;
        }

        public boolean isInterrupted() {
            return interrupted;
        }

        @Override
        public String toString() {
            return "Penalty{" +
                    "player=" + player +
                    ", penalty=" + penalty +
                    '}';
        }
    }

}
