import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Poker {
	private final List<String> bestHands;

	public Poker(final List<String> hands) {
		bestHands = bestHands(hands);
	}

	public List<String> getBestHands() {
		return bestHands;
	}

	public List<String> bestHands(final List<String> hands) {
		ArrayList<Hand> scoredHands = new ArrayList<Hand>();

		for (String s : hands) {
			scoredHands.add(new Hand(s));
		}
		int maxscore = scoredHands.stream().map(h -> h.getScore()).max(Comparator.naturalOrder()).get();
		return scoredHands.stream().filter(h -> h.getScore() == maxscore).map(h -> h.getInput())
				.collect(Collectors.toList());
	}
}
