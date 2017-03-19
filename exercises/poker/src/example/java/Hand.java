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

public class Hand {
	private String input;
	private int score;

	public Hand(String hand) {
		this.input = hand;
		this.score = scoreHand(parseCards(hand));
	}

	public int getScore() {
		return score;
	}

	public String getInput() {
		return input;
	}

	private static List<Card> parseCards(String hand) {
		ArrayList<Card> parsedCards = new ArrayList<Card>();
		String[] parseString = hand.split(" ");
		for (int i = 0; i < parseString.length; i++) {
			parsedCards.add(new Card(parseString[i]));
		}
		return parsedCards;
	}

	private static Map<Integer, Integer> getFrequencyMap(List<Card> cards) {
		Map<Integer, Integer> frequencymap = new HashMap<Integer, Integer>() ;
		for (Card c : cards) {
			if (frequencymap.containsKey(c.getRank())) {
				frequencymap.put(c.getRank(), frequencymap.get(c.getRank()) + 1);
			} else {
				frequencymap.put(c.getRank(), 1);
			}
		}
		return frequencymap;
	}

	private static int scoreHand(List<Card> cards) {
		List<Card> cardsByRank = new ArrayList<Card>();

		cardsByRank = cards.stream().sorted(Comparator.comparing(Card::getRank)).unordered()
				.collect(Collectors.toList());

		Map<Integer, Integer> frequencymap = getFrequencyMap(cards);
		List<Integer> ranks = frequencymap.entrySet().stream().map(x -> x.getKey())
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		frequencymap = frequencymap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		List<Integer> rankCounts = frequencymap.entrySet().stream().map(x -> x.getValue())
				.collect(Collectors.toList());

		List<Integer> suits = cards.stream().map(s -> s.getSuit()).collect(Collectors.toList());

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
			return (700 + (cardsByRank.get(0)).getRank());
		}
		if (rankCounts.equals(Arrays.asList(3, 2))) {
			return 600 + cardsByRank.get(0).getRank();
		}
		if (flush) {
			return 500 + frequencymap.keySet().iterator().next();
		}
		if (straight) {
			return 400 + frequencymap.keySet().iterator().next();
		}
		if (rankCounts.equals(Arrays.asList(3, 1, 1))) {
			return 300 + cardsByRank.get(0).getRank();
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