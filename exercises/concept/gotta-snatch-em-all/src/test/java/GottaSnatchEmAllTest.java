import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GottaSnatchEmAllTest {

    @Test
    @Tag("task:1")
    @DisplayName("newCollection returns an empty set when given an empty list")
    void testNewCollectionEmptyList() {
        assertThat(GottaSnatchEmAll.newCollection(List.of())).isEmpty();
    }

    @Test
    @Tag("task:1")
    @DisplayName("newCollection returns a set with one card when given a list with one card")
    void testNewCollectionSingletonList() {
        List<String> cards = List.of("Bleakachu");
        Set<String> expected = Set.of("Bleakachu");
        assertThat(GottaSnatchEmAll.newCollection(cards)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("newCollection returns a set with one card when given a list with one repeated card")
    void testNewCollectionListWithDuplicates() {
        List<String> cards = List.of("Bleakachu", "Bleakachu");
        Set<String> expected = Set.of("Bleakachu");
        assertThat(GottaSnatchEmAll.newCollection(cards)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("newCollection returns a set with two cards when given a list with two unique cards")
    void testNewCollectionListWithoutDuplicates() {
        List<String> cards = List.of("Bleakachu", "Newthree");
        Set<String> expected = Set.of("Bleakachu", "Newthree");
        assertThat(GottaSnatchEmAll.newCollection(cards)).isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("addCard returns true when the collection does not yet contain the new card")
    void testAddCardReturnsTrueWhenCardNotInCollection() {
        Set<String> collection = new HashSet<>();
        assertThat(GottaSnatchEmAll.addCard("Veevee", collection)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("addCard returns false when the collection already contains the new card")
    void testAddCardReturnsFalseWhenCardAlreadyInCollection() {
        Set<String> collection = new HashSet<>(Set.of("Veevee"));
        assertThat(GottaSnatchEmAll.addCard("Veevee", collection)).isFalse();
    }

    @Test
    @Tag("task:2")
    @DisplayName("addCard adds the card to the collection when it is a new card")
    void testAddCardShouldAddNewCardToCollection() {
        Set<String> collection = new HashSet<>();
        Set<String> expected = Set.of("Veevee");
        GottaSnatchEmAll.addCard("Veevee", collection);
        assertThat(collection).isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("addCard doesn't add the card to the collection when it already contains the new card")
    void testAddCardShouldNotAddExistingCardToCollection() {
        Set<String> collection = new HashSet<>(Set.of("Veevee"));
        Set<String> expected = Set.of("Veevee");
        GottaSnatchEmAll.addCard("Veevee", collection);
        assertThat(collection).isEqualTo(expected);
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns false when both collections are empty")
    void testCanTradeBothCollectionsEmpty() {
        Set<String> myCollection = new HashSet<>();
        Set<String> theirCollection = new HashSet<>();
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns false when my collections is empty")
    void testCanTradeMyCollectionsEmpty() {
        Set<String> myCollection = new HashSet<>();
        Set<String> theirCollection = new HashSet<>(Set.of("Bleakachu"));
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns false when their collections is empty")
    void testCanTradeTheirCollectionsEmpty() {
        Set<String> myCollection = new HashSet<>(Set.of("Bleakachu"));
        Set<String> theirCollection = new HashSet<>();
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns false when both collections have the same cards")
    void testCanTradeBothCollectionsHaveSameCards() {
        Set<String> myCollection = new HashSet<>(Set.of("Gyros", "Garilord"));
        Set<String> theirCollection = new HashSet<>(Set.of("Garilord", "Gyros"));
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns true when both collections have unique cards")
    void testCanTradeBothCollectionsHaveUniqueCards() {
        Set<String> myCollection = new HashSet<>(Set.of("Gyros"));
        Set<String> theirCollection = new HashSet<>(Set.of("Garilord"));
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns true when both collections have at least one card the other doesn't have")
    void testCanTradeBothCollectionsMixedCards() {
        Set<String> myCollection = new HashSet<>(Set.of("Gyros", "Garilord", "Bleakachu"));
        Set<String> theirCollection = new HashSet<>(Set.of("Garilord", "Veevee", "Gyros"));
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns true when my collection is a non-empty subset of their collection")
    void testCanTradeMyCollectionSubsetOfTheirCollection() {
        Set<String> myCollection = new HashSet<>(Set.of("Gyros", "Garilord"));
        Set<String> theirCollection = new HashSet<>(Set.of("Garilord", "Veevee", "Gyros"));
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("canTrade returns false when their collection is a non-empty subset of my collection")
    void testCanTradeTheirCollectionSubsetOfMyCollection() {
        Set<String> myCollection = new HashSet<>(Set.of("Garilord", "Veevee", "Gyros"));
        Set<String> theirCollection = new HashSet<>(Set.of("Gyros", "Garilord"));
        assertThat(GottaSnatchEmAll.canTrade(myCollection, theirCollection)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("commonCards returns an empty set when all cards are different")
    void testCommonCardsAllCardsDifferent() {
        List<Set<String>> collections = List.of(
                Set.of("Veevee"),
                Set.of("Bleakachu"),
                Set.of("Wigglycream")
        );
        Set<String> expected = Set.of();
        assertThat(GottaSnatchEmAll.commonCards(collections)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("commonCards returns a set with all cards when given a single collection")
    void testCommonCardsSingleCollection() {
        List<Set<String>> collections = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried")
        );
        Set<String> expected = Set.of("Veevee", "Wigglycream", "Mayofried");
        assertThat(GottaSnatchEmAll.commonCards(collections)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("commonCards returns a set with cards present in all given collections")
    void testCommonCardsMultipleCollections() {
        List<Set<String>> collections = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried"),
                Set.of("Gyros", "Wigglycream", "Shazam"),
                Set.of("Cooltentbro", "Mayofried", "Wigglycream")
        );
        Set<String> expected = Set.of("Wigglycream");
        assertThat(GottaSnatchEmAll.commonCards(collections)).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("allCards returns a set with all cards when given a single collection")
    void testAllCardsSingleCollection() {
        List<Set<String>> collections = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried")
        );
        Set<String> expected = Set.of("Veevee", "Wigglycream", "Mayofried");
        assertThat(GottaSnatchEmAll.allCards(collections)).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("allCards returns a set with all cards when given multiple collections")
    void testAllCardsMultipleCollections() {
        List<Set<String>> collections = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried"),
                Set.of("Gyros", "Wigglycream", "Shazam"),
                Set.of("Cooltentbro", "Mayofried", "Wigglycream")
        );
        Set<String> expected = Set.of("Cooltentbro", "Gyros", "Mayofried", "Shazam", "Veevee", "Wigglycream");
        assertThat(GottaSnatchEmAll.allCards(collections)).isEqualTo(expected);
    }
}
