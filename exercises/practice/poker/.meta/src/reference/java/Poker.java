import java.util.*;
import java.util.stream.Collectors;

class Poker {
    private final List<String> bestHands;

    Poker(List<String> hands) {
        this.bestHands = evaluateBestHands(hands);
    }

    List<String> getBestHands() {
        return bestHands;
    }

    private List<String> evaluateBestHands(List<String> hands) {
        List<Hand> parsedHands = hands.stream()
            .map(Hand::new)
            .collect(Collectors.toList());

        int maxScore = parsedHands.stream()
            .mapToInt(Hand::calculateScore)
            .max()
            .orElse(0);

        return parsedHands.stream()
            .filter(hand -> hand.calculateScore() == maxScore)
            .map(Hand::getOriginal)
            .collect(Collectors.toList());
    }
}
