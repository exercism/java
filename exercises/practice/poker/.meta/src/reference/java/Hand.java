import java.util.*;
import java.util.stream.Collectors;

class Hand {
    private final String original;
    private final List<Card> cards;

    Hand(String hand) {
        this.original = hand;
        this.cards = parseCards(hand);
    }

    String getOriginal() {
        return original;
    }

    int calculateScore() {
        Map<Integer, Long> rankFrequency = cards.stream()
            .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));

        List<Integer> ranks = rankFrequency.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        boolean isFlush = cards.stream()
            .map(Card::getSuit)
            .distinct()
            .count() == 1;

        boolean isStraight = ranks.size() == 5 &&
            (ranks.get(0) - ranks.get(4) == 4 || ranks.equals(Arrays.asList(14, 5, 4, 3, 2)));

        if (ranks.equals(Arrays.asList(14, 5, 4, 3, 2))) {
            ranks = Arrays.asList(5, 4, 3, 2, 1);
        }

        List<Long> frequencies = new ArrayList<>(rankFrequency.values());
        frequencies.sort(Collections.reverseOrder());

        if (isStraight && isFlush) return 800 + ranks.get(0);
        if (frequencies.equals(Arrays.asList(4L, 1L))) return 700 + ranks.get(0);
        if (frequencies.equals(Arrays.asList(3L, 2L))) return 600 + ranks.get(0) * 10 + ranks.get(1);
        if (isFlush) return 500 + ranks.get(0);
        if (isStraight) return 400 + ranks.get(0);
        if (frequencies.equals(Arrays.asList(3L, 1L, 1L))) return 300 + ranks.get(0) * 10 + ranks.get(1);
        if (frequencies.equals(Arrays.asList(2L, 2L, 1L))) return 200 + ranks.get(0) * 10 + ranks.get(1);
        if (frequencies.equals(Arrays.asList(2L, 1L, 1L, 1L))) return 100 + ranks.get(0);

        return ranks.stream().reduce(0, (sum, rank) -> sum * 10 + rank);
    }

    private List<Card> parseCards(String hand) {
        return Arrays.stream(hand.split(" "))
            .map(Card::new)
            .collect(Collectors.toList());
    }
}
