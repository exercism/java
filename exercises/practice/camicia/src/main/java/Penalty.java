class Penalty {
    private Turn.Player player;
    private int penalty;

    Penalty() {
    }

    Turn.Player getPlayer() {
        return player;
    }

    int getPenalty() {
        return penalty;
    }

    public void set(Turn.Player player, Card card) {
        this.player = player;
        this.penalty = card.getPenalty();
    }

    void deduct() {
        if (penalty > 0) {
            penalty -= 1;
        }
    }

    boolean isActive(){
        return penalty > 0;
    }

    boolean isActive(Turn.Player player) {
        return player != null && player.equals(this.player) && penalty > 0;
    }

    boolean isFullyPaid() {
        return player != null && penalty == 0;
    }

    boolean isFullyPaid(Turn.Player player) {
        return player != null && player.equals(this.player) && penalty == 0;
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
