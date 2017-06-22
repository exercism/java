public class Card {
	private int rank;
	private int suit;

	public Card(String card) {
		rank = parseRank(card);
		suit = parseSuit(card);
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	private int parseRank(String card) {
		return "..23456789TJQKA".indexOf(card.charAt(0));
	}

	private int parseSuit(String card) {
		return ".HSDC".indexOf(card.charAt(1));
	}
}