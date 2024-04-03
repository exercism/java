import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        Set<String> myUniqueCards = new HashSet<>(myCollection);
        Set<String> theirUniqueCards = new HashSet<>(theirCollection);
        myUniqueCards.removeAll(theirCollection);
        theirUniqueCards.removeAll(myCollection);
        return !myUniqueCards.isEmpty() && !theirUniqueCards.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        if (collections.isEmpty()) {
            return Set.of();
        }

        Set<String> commonCards = new HashSet<>(collections.get(0));
        for (int i = 1; i < collections.size(); i++) {
            commonCards.retainAll(collections.get(i));
        }
        return commonCards;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();
        for (Set<String> collection : collections) {
            allCards.addAll(collection);
        }
        return allCards;
    }
}
