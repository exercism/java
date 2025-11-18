class Penalty {
    private Player player;
    private int penalty;

    Penalty() {
    }

    Player getPlayer() {
        return player;
    }

    int getPenalty() {
        return penalty;
    }

    void set(Player player, Card card) {
        this.player = player;
        this.penalty = card.getPenalty();
    }

    void deduct() {
        if (penalty > 0) {
            penalty -= 1;
        }
    }

    void clear() {
        this.player = null;
        this.penalty = 0;
    }

    @Override
    public String toString() {
        return player + ":" + penalty;
    }
}
