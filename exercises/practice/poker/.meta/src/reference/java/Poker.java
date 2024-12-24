import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Poker {

    private List<String> hands;
    private List<Integer> numericalValues;
    private List<Integer> counts;

    public Poker(List<String> hands) {
        this.hands = hands;
    }

    public List<String> getBestHands() {
        List<String> bestHands = new ArrayList<>();
        bestHands.add(hands.get(0));

        for (int i = 1; i < hands.size(); i++) {
            if (getHandRank(hands.get(i)) > getHandRank(bestHands.get(0))) {
                bestHands.set(0, hands.get(i));
            } else if (getHandRank(hands.get(i)) == getHandRank(bestHands.get(0))) {
                getHandRank(bestHands.get(0));
                List<Integer> firstHand = counts;

                getHandRank(hands.get(i));
                List<Integer> secondHand = counts;

                if (firstHand.equals(secondHand)) {
                    bestHands.add(hands.get(i));
                } else {
                    for (int j = 4; j >= 2; j--) {
                        if (firstHand.contains(j) && secondHand.contains(j)) {
                            if (firstHand.lastIndexOf(j) < secondHand.lastIndexOf(j)) {
                                bestHands.set(0, hands.get(i));
                                break;
                            } else if (firstHand.lastIndexOf(j) > secondHand.lastIndexOf(j)) {
                                break;
                            } else if (firstHand.lastIndexOf(j) == secondHand.lastIndexOf(j) && j == 2) {
                                if (firstHand.indexOf(j) < secondHand.indexOf(j)) {
                                    bestHands.set(0, hands.get(i));
                                }
                            }
                        }
                    }
                    for (int k = firstHand.size() - 1; k >= 0; k--) {
                        if (firstHand.get(k) <= 1 && secondHand.get(k) <= 1) {
                            if (firstHand.get(k) < secondHand.get(k)) {
                                bestHands.set(0, hands.get(i));
                                break;
                            } else if (firstHand.get(k) > secondHand.get(k)) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return bestHands;
    }

    public int getHandRank(String hand) {
        String[] cards = hand.split(" ");
        List<String> values = new ArrayList<>();
        List<String> suits = new ArrayList<>();
        for (String card : cards) {
            if (card.length() == 2) {
                values.add(card.substring(0, 1));
                suits.add(card.substring(1));
            } else {
                values.add(card.substring(0, 2));
                suits.add(card.substring(2));
            }
        }

        for (int i = 0; i < values.size(); i++) {
            switch (values.get(i)) {
                case "J" -> values.set(i, "11");
                case "Q" -> values.set(i, "12");
                case "K" -> values.set(i, "13");
                case "A" -> {
                    if (values.contains("2") && values.contains("3") && values.contains("4") && values.contains("5")) {
                        values.set(i, "1");
                    } else {
                        values.set(i, "14");
                    }
                }
            }
        }

        numericalValues = new ArrayList<>();
        for (String value : values) {
            numericalValues.add(Integer.valueOf(value));
        }
        Collections.sort(numericalValues);

        List<Integer> possibleValues = new ArrayList<>();
        counts = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
            counts.add(i - 1, countOccurrences(i));
            possibleValues.add(i);
        }

        boolean isStraight = Collections.indexOfSubList(possibleValues, numericalValues) != -1;

        boolean isFlush = suits.stream().distinct().count() == 1;

        if (isStraight & isFlush) {
            return 8; // straight flush
        } else if (counts.contains(4)) {
            return 7; // four of a kind
        } else if (counts.contains(3) && counts.contains(2)) {
            return 6; // full house
        } else if (isFlush) {
            return 5; // flush
        } else if (isStraight) {
            return 4; // straight
        } else if (counts.contains(3)) {
            return 3; // three of a kind
        } else if (counts.stream().filter(value -> value == 2).count() == 2) {
            return 2; // two pair
        } else if (counts.contains(2)) {
            return 1; // pair
        } else {
            return 0; // high card
        }
    }

    public int countOccurrences(int valueToFind) {
        return (int) numericalValues.stream().filter(value -> value.equals(valueToFind)).count();
    }  
}
