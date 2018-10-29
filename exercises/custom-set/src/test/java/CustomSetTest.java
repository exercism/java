import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class CustomSetTest {

    @Test
    public void setsWithNoElementsAreEmpty() {
        CustomSet<Integer> customSet = new CustomSet<>(Collections.emptyList());
        assertTrue(customSet.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void setsWithElementsAreNotEmpty() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.singletonList('1'));
        assertFalse(customSet.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsContainedInAnEmptySet() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        assertFalse(customSet.contains("1"));
    }

    @Ignore("Remove to run test")
    @Test
    public void whenTheElementIsInTheSet() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(1, 2, 3));
        assertTrue(customSet.contains(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void whenTheElementIsNotInTheSet() {
        CustomSet<Character> customSet = new CustomSet<>(Arrays.asList('1', '2', '3'));
        assertFalse(customSet.contains('4'));
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsASubsetOfAnotherEmptySet() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<String> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertTrue(customSet.isSubset(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsASubsetOfNonEmptySet() {
        CustomSet<Integer> customSet = new CustomSet<>(Collections.singletonList(1));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertTrue(customSet.isSubset(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void nonEmptySetIsNotASubsetOfEmptySet() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<Character> secondCustomSet = new CustomSet<>(Collections.singletonList('1'));
        assertFalse(customSet.isSubset(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setIsASubsetOfSetWithExactSameElements() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        assertTrue(customSet.isSubset(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setIsASubsetOfLargerSetWithSameElements() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(4, 1, 2, 3));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Arrays.asList(1, 2, 3));
        assertTrue(customSet.isSubset(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setIsNotASubsetOfSetThatDoesNotContainItsElements() {
        CustomSet<Character> customSet = new CustomSet<>(Arrays.asList('4', '1', '3'));
        CustomSet<Character> secondCustomSet = new CustomSet<>(Arrays.asList('1', '2', '3'));
        assertFalse(customSet.isSubset(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void theEmptySetIsDisjointWithItself() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<String> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertTrue(customSet.isDisjoint(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsDisjointWithNonEmptySet() {
        CustomSet<Integer> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Collections.singletonList(1));
        assertTrue(customSet.isDisjoint(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void nonEmptySetIsDisjointWithEmptySet() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.singletonList('1'));
        CustomSet<Character> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertTrue(customSet.isDisjoint(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setsAreNotDisjointIfTheyShareAnElement() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("2", "3"));
        assertFalse(customSet.isDisjoint(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setsAreDisjointIfTheyShareNoElements() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(1, 2));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Arrays.asList(3, 4));
        assertTrue(customSet.isDisjoint(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetsAreEqual() {
        CustomSet<Character> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<Character> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertTrue(customSet.equals(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsNotEqualToNonEmptySet() {
        CustomSet<String> customSet = new CustomSet<>(Collections.emptyList());
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        assertFalse(customSet.equals(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void nonEmptySetIsNotEqualToEmptySet() {
        CustomSet<Integer> customSet = new CustomSet<>(Arrays.asList(1, 2, 3));
        CustomSet<Integer> secondCustomSet = new CustomSet<>(Collections.emptyList());
        assertFalse(customSet.equals(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setsWithTheSameElementsAreEqual() {
        CustomSet<Character> customSet = new CustomSet<>(Arrays.asList('1', '2'));
        CustomSet<Character> secondCustomSet = new CustomSet<>(Arrays.asList('2', '1'));
        assertTrue(customSet.equals(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setsWithDifferentElementsAreNotEqual() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "4"));
        assertFalse(customSet.equals(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void setIsNotEqualToLargerSetWithSameElements() {
        CustomSet<String> customSet = new CustomSet<>(Arrays.asList("1", "2", "3"));
        CustomSet<String> secondCustomSet = new CustomSet<>(Arrays.asList("1", "2", "3", "4"));
        assertFalse(customSet.equals(secondCustomSet));
    }

    @Ignore("Remove to run test")
    @Test
    public void addToEmptySet() {
        int element = 3;
        CustomSet<Integer> expected = new CustomSet<>(Collections.unmodifiableList(Collections.singletonList(element)));
        CustomSet<Integer> actual = new CustomSet<>(Collections.emptyList());

        actual.add(element);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void addToNonEmptySet() {
        char element = '3';
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(
            Arrays.asList('1', '2', '3', '4')));
        CustomSet<Character> actual = new CustomSet<>(Arrays.asList('1', '2', '4'));

        actual.add(element);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void addingAnExistingElementDoesNotChangeTheSet() {
        String element = "3";
        CustomSet<String> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList("1", "2", "3")));
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("1", "2", "3"));

        actual.add(element);

        assertNotNull(actual);
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfTwoEmptySetsIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<Integer>(Collections.emptyList())
                .getIntersection(new CustomSet<>(Collections.emptyList()));

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        CustomSet<Character> actual = new CustomSet<Character>(Collections.emptyList())
                .getIntersection(new CustomSet<>(Arrays.asList('3', '2', '5')));

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfANonEmptySetAndAnEmptySetIsAnEmptySet() {
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("1", "2", "3", "4"))
                .getIntersection(new CustomSet<>(Collections.emptyList()));

        assertNotNull(actual);
        assertTrue(actual.isEmpty());

    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfTwoSetsWithNoSharedElementsIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<>(Arrays.asList(1, 2, 3))
                .getIntersection(new CustomSet<>(Arrays.asList(4, 5, 6)));

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfTwoSetsWithSharedElementsIsASetOfTheSharedElements() {
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList('2', '3')));
        CustomSet<Character> actual = new CustomSet<>(Arrays.asList('1', '2', '3', '4'))
                .getIntersection(new CustomSet<>(Arrays.asList('3', '2', '5')));

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void differenceOfTwoEmptySetsIsAnEmptySet() {
        CustomSet<String> actual = new CustomSet<String>(Collections.emptyList())
                .getDifference(new CustomSet<>(Collections.emptyList()));

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void differenceOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<Integer>(Collections.emptyList())
                .getDifference(new CustomSet<>(Arrays.asList(3, 2, 5)));

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void differenceOfANonEmptySetAndAnEmptySetIsTheNonEmptySet() {
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(
                Arrays.asList('1', '2', '3', '4')));
        CustomSet<Character> actual = new CustomSet<>(Arrays.asList('1', '2', '3', '4'))
                .getDifference(new CustomSet<>(Collections.emptyList()));

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void differenceOfTwoNonEmptySetsIsASetOfElementsThatAreOnlyInTheFirstSet() {
        CustomSet<String> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList("1", "3")));
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("3", "2", "1"))
                .getDifference(new CustomSet<>(Arrays.asList("2", "4")));

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void unionOfTwoEmptySetsIsAnEmptySet() {
        CustomSet<Integer> actual = new CustomSet<Integer>(Collections.emptyList())
                .getUnion(new CustomSet<>(Collections.emptyList()));

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void unionOfAnEmptySetAndNonEmptySetIsTheNonEmptySet() {
        CustomSet<Character> expected = new CustomSet<>(Collections.unmodifiableList(Collections.singletonList('2')));
        CustomSet<Character> actual = new CustomSet<Character>(Collections.emptyList())
                .getUnion(new CustomSet<>(Collections.singletonList('2')));

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void unionOfANonEmptySetAndAnEmptySetIsTheNonEmptySet() {
        CustomSet<String> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList("1", "3")));
        CustomSet<String> actual = new CustomSet<>(Arrays.asList("1", "3"))
                .getUnion(new CustomSet<>(Collections.emptyList()));

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Ignore("Remove to run test")
    @Test
    public void unionOfTwoNonEmptySetsContainsAllUniqueElements() {
        CustomSet<Integer> expected = new CustomSet<>(Collections.unmodifiableList(Arrays.asList(3, 2, 1)));
        CustomSet<Integer> actual = new CustomSet<>(Arrays.asList(1, 3))
                .getUnion(new CustomSet<>(Arrays.asList(2, 3)));

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

}
