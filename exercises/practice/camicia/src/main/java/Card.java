class Card {

    private final String symbol;
    private final int penalty;

    protected Card(String symbol) {
        this.symbol = symbol;
        this.penalty = getPenalty(symbol);
    }

    int getPenalty() {
        return penalty;
    }

    public boolean isPaymentCard() {
        return switch (symbol) {
            case "J", "Q", "K", "A" -> true;
            default -> false;
        };
    }

    @Override
    public String toString() {
        return symbol;
    }

    static int getPenalty(String card) {
        return switch (card) {
            case "J" -> 1;
            case "Q" -> 2;
            case "K" -> 3;
            case "A" -> 4;
            default -> 0;
        };
    }
}
