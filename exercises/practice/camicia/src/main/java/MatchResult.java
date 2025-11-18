class MatchResult {
    /**
     * Match status: finished or loop
     */
    Status status;

    /**
     * Total number of cards played throughout the game
     */
    int cards;

    /**
     * Number of times the central pile was collected
     */
    int tricks;

    private MatchResult() {

    }

    private MatchResult(Status status, int cards, int tricks) {
        this.status = status;
        this.cards = cards;
        this.tricks = tricks;
    }

    Status getStatus() {
        return status;
    }

    int getCards() {
        return cards;
    }

    int getTricks() {
        return tricks;
    }

    static MatchBuilder builder() {
        return new MatchBuilder();
    }

    static final class MatchBuilder {
        private Status status;
        private int cards;
        private int tricks;

        private MatchBuilder() {
        }

        MatchBuilder withStatus(Status status) {
            this.status = status;
            return this;
        }

        MatchBuilder withCards(int cards) {
            this.cards = cards;
            return this;
        }

        MatchBuilder withTricks(int tricks) {
            this.tricks = tricks;
            return this;
        }

        MatchResult build() {
            return new MatchResult(status, cards, tricks);
        }
    }

    enum Status {
        FINISHED,
        LOOP
    }
}