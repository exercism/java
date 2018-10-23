class Card {
    private int rank;
    private int suit;

    Card(String card) {
        rank = parseRank(card);
        suit = parseSuit(card);
    }

    int getRank() {
        return rank;
    }

    int getSuit() {
        return suit;
    }

    private int parseRank(String card) {
        if (card.substring(0, 2).equals("10")) {
            return 10;
        }
        return "..23456789TJQKA".indexOf(card.charAt(0));
    }

    private int parseSuit(String card) {
        return ".HSDC".indexOf(card.charAt(card.length() - 1));
    }
}
