import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Poker {
	private static class Card {
		private int rank;
		private int Suit;

		public Card(String card) {
			rank = Parserank(card);
			Suit = ParseSuit(card);
		}

		public int getRank() {
			return rank;
		}
	}

	private static class Hand {
		private String input;
		private int score;

		public Hand(String hand) {
			this.input = hand;
			this.score = ScoreHand(ParseCards(hand));
		}
		
		public int getScore() {
			return score;
		}

		public String getInput() {
			return input;
		}
	}

	public static List<String> BestHands(List<String> hands) {
		ArrayList<Hand> scoredHands = new ArrayList<Hand>();

		for (String s : hands) {
			scoredHands.add(new Hand(s));
		}

		int maxscore = scoredHands.stream().map(h -> h.getScore()).max(Comparator.naturalOrder()).get();
		return scoredHands.stream().filter(h -> h.getScore() == maxscore).map(h -> h.getInput())
				.collect(Collectors.toList());
	}

	public static List<Card> ParseCards(String hand) {
		ArrayList<Card> parseCards = new ArrayList<Card>();
		String[] parseString = hand.split(" ");
		for (int i = 0; i < parseString.length; i++) {
			parseCards.add(new Poker.Card(parseString[i]));
		}
		return parseCards;
	}

	public static int Parserank(String card) {
		return "..23456789TJQKA".indexOf(card.charAt(0));
	}

	public static int ParseSuit(String card) {
		return ".HSDC".indexOf(card.charAt(1));
	}

	private static int ScoreHand(List<Card> cards) {

		List<Card> cardsByrank = new ArrayList<Card>();

		cardsByrank = cards.stream().sorted(Comparator.comparing(Card::getRank)).unordered()
				.collect(Collectors.toList());

		Map<Integer, Integer> frequencymap = new HashMap<Integer, Integer>();
		for (Card c : cards) {
			if (frequencymap.containsKey(c.rank)) {
				frequencymap.put(c.getRank(), frequencymap.get(c.getRank()) + 1);
			} else {
				frequencymap.put(c.getRank(), 1);
			}
		}

		List<Integer> ranks = frequencymap.entrySet().stream().map(x -> x.getKey()).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		frequencymap = frequencymap.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		List<Integer> rankCounts = frequencymap.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());

		List<Integer> suits = cards.stream().map(s -> s.Suit).collect(Collectors.toList());

		if (ranks.equals(Arrays.asList(14, 5, 4, 3, 2))) {
			ranks = Arrays.asList(5, 4, 3, 2, 1);
		}

		boolean flush = suits.stream().distinct().count() == 1;
		boolean straight = ranks.stream().distinct().count() == 5 && ranks.get(0) - ranks.get(4) == 4;
		Iterator<Integer> itr = frequencymap.keySet().iterator();
		int pairA = itr.next();

		if (straight && flush) {
			return 800 + frequencymap.keySet().iterator().next();
		}
		if (rankCounts.equals(Arrays.asList(4, 1))) {
			return (700 + (cardsByrank.get(0)).getRank());
		}
		if (rankCounts.equals(Arrays.asList(3, 2))) {
			return 600 + cardsByrank.get(0).getRank();
		}
		if (flush) {
			return 500 + frequencymap.keySet().iterator().next();
		}
		if (straight) {
			return 400 + frequencymap.keySet().iterator().next();
		}
		if (rankCounts.equals(Arrays.asList(3, 1, 1))) {
			return 300 + cardsByrank.get(0).getRank();
		}
		if (rankCounts.equals(Arrays.asList(2, 2, 1))) {
			return 200 + Math.max(pairA, itr.next());
		}
		if (rankCounts.equals(Arrays.asList(2, 1, 1, 1))) {
			return 100 + pairA;
		}
		Collections.sort(ranks, (a, b) -> b.compareTo(a));
		Collections.reverse(ranks);
		return ranks.get(0);
	}
}