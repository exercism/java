import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSetTest {

    @Test
    @DisplayName("Returns true if the set contains no elements")
    public void setsWithNoElementsAreEmpty() {
        CustomSet<Integer> customSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.isEmpty()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sets with elements are not empty")
    public void setsWithElementsAreNotEmpty() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.singletonList('1'));
        assertThat(customSet.isEmpty()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("nothing is contained in an empty set")
    public void nothingIsContainedInAnEmptySet() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.contains("1")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when the element is in the set")
    public void whenTheElementIsInTheSet() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(1, 2, 3));
        assertThat(customSet.contains(1)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when the element is not in the set")
    public void whenTheElementIsNotInTheSet() {
        CustomSet<Character> customSet = new CustomSet<>(Arrays.asList('1', '2', '3'));
        assertThat(customSet.contains('4')).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty set is a subset of another empty set")
    public void emptySetIsASubsetOfAnotherEmptySet() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<String> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.isSubset(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty set is a subset of non-empty set")
    public void emptySetIsASubsetOfNonEmptySet() {
        CustomSet<Integer> customSet = new CustomSet<>(Collections.singletonList(1));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.isSubset(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("non-empty set is not a subset of empty set")
    public void nonEmptySetIsNotASubsetOfEmptySet() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<Character> secondCustomSet = new CustomSet<>(Collections.singletonList('1'));
        assertThat(customSet.isSubset(secondCustomSet)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("set is a subset of set with exact same elements")
    public void setIsASubsetOfSetWithExactSameElements() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        assertThat(customSet.isSubset(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("set is a subset of larger set with same elements")
    public void setIsASubsetOfLargerSetWithSameElements() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(4, 1, 2, 3));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Arrays.asList(1, 2, 3));
        assertThat(customSet.isSubset(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("set is not a subset of set that does not contain its elements")
    public void setIsNotASubsetOfSetThatDoesNotContainItsElements() {
        CustomSet<Character> customSet = new CustomSet<>(Arrays.asList('4', '1', '3'));
        CustomSet<Character> secondCustomSet = new CustomSet<>(Arrays.asList('1', '2', '3'));
        assertThat(customSet.isSubset(secondCustomSet)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the empty set is disjoint with itself")
    public void theEmptySetIsDisjointWithItself() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<String> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.isDisjoint(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty set is disjoint with non-empty set")
    public void emptySetIsDisjointWithNonEmptySet() {
        CustomSet<Integer> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Collections.singletonList(1));
        assertThat(customSet.isDisjoint(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("non-empty set is disjoint with empty set")
    public void nonEmptySetIsDisjointWithEmptySet() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.singletonList('1'));
        CustomSet<Character> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.isDisjoint(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sets are not disjoint if they share an element")
    public void setsAreNotDisjointIfTheyShareAnElement() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("2", "3"));
        assertThat(customSet.isDisjoint(secondCustomSet)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sets are disjoint if they share no elements")
    public void setsAreDisjointIfTheyShareNoElements() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(1, 2));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Arrays.asList(3, 4));
        assertThat(customSet.isDisjoint(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty sets are equal")
    public void emptySetsAreEqual() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<Character> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.equals(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty set is not equal to non-empty set")
    public void emptySetIsNotEqualToNonEmptySet() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        assertThat(customSet.equals(secondCustomSet)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("non-empty set is not equal to empty set")
    public void nonEmptySetIsNotEqualToEmptySet() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(1, 2, 3));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertThat(customSet.equals(secondCustomSet)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sets with the same elements are equal")
    public void setsWithTheSameElementsAreEqual() {
        CustomSet<Character> customSet = new CustomSet<>(Arrays.asList('1', '2'));
        CustomSet<Character> secondCustomSet = new CustomSet<>(Arrays.asList('2', '1'));
        assertThat(customSet.equals(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sets with different elements are not equal")
    public void setsWithDifferentElementsAreNotEqual() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "4"));
        assertThat(customSet.equals(secondCustomSet)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("set is not equal to larger set with same elements")
    public void setIsNotEqualToLargerSetWithSameElements() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "3", "4"));
        assertThat(customSet.equals(secondCustomSet)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("set is equal to a set constructed from an array with duplicates")
    public void secondSetWithDuplicatesIsEqualToFirstSet() {
        CustomSet<String> customSet = new CustomSet<>(Collections.singletonList("1"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "1"));
        assertThat(customSet.equals(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference removes all duplicates in the first set")
    public void firstSetWithDuplicatesIsEqualToSecondSet() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "1"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Collections.singletonList("1"));
        assertThat(customSet.equals(secondCustomSet)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add to empty set")
    public void addToEmptySet() {
        int element = 3;
        CustomSet<Integer> expected = new CustomSet<>(Collections.unmodifiableList(Collections.singletonList(element)));
        CustomSet<Integer> actual = new CustomSet<>(Collections.emptyList());

        actual.add(element);

        assertThat(actual).isNotNull();
        assertThat(actual.equals(expected)).isTrue();
        assertThat(actual.isEmpty()).isFalse();

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add to non-empty set")
    public void addToNonEmptySet() {
        char element = '3';
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(
                Arrays.asList('1', '2', '3', '4')));
        CustomSet<Character> actual = new CustomSet<>(Arrays.asList('1', '2', '4'));

        actual.add(element);

        assertThat(actual).isNotNull();
        assertThat(actual.equals(expected)).isTrue();
        assertThat(actual.isEmpty()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("adding an existing element does not change the set")
    public void addingAnExistingElementDoesNotChangeTheSet() {
        String element = "3";
        CustomSet<String> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList("1", "2", "3")));
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("1", "2", "3"));

        actual.add(element);

        assertThat(actual).isNotNull();
        assertThat(actual.equals(expected)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("intersection of two empty sets is an empty set")
    public void intersectionOfTwoEmptySetsIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<Integer>(Collections.emptyList())
                .getIntersection(new CustomSet<>(Collections.emptyList()));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("intersection of an empty set and non-empty set is an empty set")
    public void intersectionOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        CustomSet<Character> actual = new CustomSet<Character>(Collections.emptyList())
                .getIntersection(new CustomSet<>(Arrays.asList('3', '2', '5')));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("intersection of a non-empty set and an empty set is an empty set")
    public void intersectionOfANonEmptySetAndAnEmptySetIsAnEmptySet() {
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("1", "2", "3", "4"))
                .getIntersection(new CustomSet<>(Collections.emptyList()));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isTrue();

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("intersection of two sets with no shared elements is an empty set")
    public void intersectionOfTwoSetsWithNoSharedElementsIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<>(Arrays.asList(1, 2, 3))
                .getIntersection(new CustomSet<>(Arrays.asList(4, 5, 6)));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("intersection of two sets with shared elements is a set of the shared elements")
    public void intersectionOfTwoSetsWithSharedElementsIsASetOfTheSharedElements() {
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList('2', '3')));
        CustomSet<Character> actual = new CustomSet<>(Arrays.asList('1', '2', '3', '4'))
                .getIntersection(new CustomSet<>(Arrays.asList('3', '2', '5')));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isFalse();
        assertThat(actual.equals(expected)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference of two empty sets is an empty set")
    public void differenceOfTwoEmptySetsIsAnEmptySet() {
        CustomSet<String> actual = new CustomSet<String>(Collections.emptyList())
                .getDifference(new CustomSet<>(Collections.emptyList()));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference of empty set and non-empty set is an empty set")
    public void differenceOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<Integer>(Collections.emptyList())
                .getDifference(new CustomSet<>(Arrays.asList(3, 2, 5)));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference of a non-empty set and an empty set is the non-empty set")
    public void differenceOfANonEmptySetAndAnEmptySetIsTheNonEmptySet() {
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(
                Arrays.asList('1', '2', '3', '4')));
        CustomSet<Character> actual = new CustomSet<>(Arrays.asList('1', '2', '3', '4'))
                .getDifference(new CustomSet<>(Collections.emptyList()));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isFalse();
        assertThat(actual.equals(expected)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("difference of two non-empty sets is a set of elements that are only in the first set")
    public void differenceOfTwoNonEmptySetsIsASetOfElementsThatAreOnlyInTheFirstSet() {
        CustomSet<String> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList("1", "3")));
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("3", "2", "1"))
                .getDifference(new CustomSet<>(Arrays.asList("2", "4")));


        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isFalse();
        assertThat(actual.equals(expected)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("union of empty sets is an empty set")
    public void unionOfTwoEmptySetsIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<Integer>(Collections.emptyList())
                .getUnion(new CustomSet<>(Collections.emptyList()));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("union of an empty set and non-empty set is the non-empty set")
    public void unionOfAnEmptySetAndNonEmptySetIsTheNonEmptySet() {
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(Collections.singletonList('2')));
        CustomSet<Character> actual = new CustomSet<Character>(Collections.emptyList())
                .getUnion(new CustomSet<>(Collections.singletonList('2')));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isFalse();
        assertThat(actual.equals(expected)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("union of a non-empty set and empty set is the non-empty set")
    public void unionOfANonEmptySetAndAnEmptySetIsTheNonEmptySet() {
        CustomSet<String> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList("1", "3")));
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("1", "3"))
                .getUnion(new CustomSet<>(Collections.emptyList()));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isFalse();
        assertThat(actual.equals(expected)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("union of non-empty sets contains all unique elements")
    public void unionOfTwoNonEmptySetsContainsAllUniqueElements() {
        CustomSet<Integer> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList(3, 2, 1)));
        CustomSet<Integer> actual = new CustomSet<>(Arrays.asList(1, 3))
                .getUnion(new CustomSet<>(Arrays.asList(2, 3)));

        assertThat(actual).isNotNull();
        assertThat(actual.isEmpty()).isFalse();
        assertThat(actual.equals(expected)).isTrue();
    }

}
