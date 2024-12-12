class Card {
    private final int rank;
    private final int suit;

    Card(String card) {
        this.rank = parseRank(card);
        this.suit = parseSuit(card);
    }

    int getRank() {
        return rank;
    }

    int getSuit() {
        return suit;
    }

    private int parseRank(String card) {
        if (card.startsWith("10")) return 10;
        return "..23456789TJQKA".indexOf(card.charAt(0));
    }

    private int parseSuit(String card) {
        return ".HSDC".indexOf(card.charAt(card.length() - 1));
    }
}
