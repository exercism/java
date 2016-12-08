
import java.util.Arrays;
import java.util.Collections;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Ignore;

public class CustomSetTest {

    @Test
    public void setsWithNoElementsAreEmpty() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isEmpty();
        assertTrue(actual);
    }

    @Test
    @Ignore
    public void setsWithElementsAreNotEmpty() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1))
                        .isEmpty();

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void nothingIsContainedInAnEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .contains(1);

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void whenTheElementIsInTheSet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .contains(1);

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void whenTheElementIsNotInTheSet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .contains(4);

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void emptySetIsASubsetOfAnotherEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isSubset(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void emptySetIsASubsetOfNonEemptySet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1))
                        .isSubset(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void nonEmptySetIsNotASubsetOfEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1))
                        );

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void setIsASubsetOfSetWithExactSameElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void setIsASubsetOfLargerSetWithSameElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(4, 1, 2, 3))
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void setIsNotASubsetOfSetThatDoesNotContainItsElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(4, 1, 3))
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void theEmptySetIsDisjointWithItself() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isDisjoint(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void emptySetIsDisjointWithNonEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isDisjoint(
                                new CustomSet<>(Arrays.asList(1))
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void nonEmptySetIsDisjointWithEmptySet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1))
                        .isDisjoint(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void setsAreNotDisjointIfTheyShareAnElement() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2))
                        .isDisjoint(
                                new CustomSet<>(Arrays.asList(2, 3))
                        );

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void setsAreDisjointIfTheyShareNoElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2))
                        .isDisjoint(
                                new CustomSet<>(Arrays.asList(3, 4))
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void emptySetsAreEqual() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .equals(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void emptySetIsNotEqualToNonEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .equals(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void nonEmptySetIsNotEqualToEmptySet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .equals(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void setsWithTheSameElementsAreEqual() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2))
                        .equals(
                                new CustomSet<>(Arrays.asList(2, 1))
                        );

        assertTrue(actual);
    }

    @Test
    @Ignore
    public void setsWithDifferentElementsAreNotEqual() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .equals(
                                new CustomSet<>(Arrays.asList(1, 2, 4))
                        );

        assertFalse(actual);
    }

    @Test
    @Ignore
    public void addToEmptySet() {
        final int element = 3;
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(element))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST);

        actual.add(element);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void addToNonEmptySet() {
        final int element = 3;
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 4));

        actual.add(element);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void addingAnExistingElementDoesNotChangeTheSet() {
        final int element = 3;
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(1, 2, 3))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 3));

        actual.add(element);

        assertNotNull(actual);
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void intersectionOfTwoEmptySetsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getIntersection(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void intersectionOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getIntersection(
                                new CustomSet<>(Arrays.asList(3, 2, 5))
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void intersectionOfANonEmptySetAndAnEmptySetIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 3, 4))
                        .getIntersection(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());

    }

    @Test
    @Ignore
    public void intersectionOfTwoSetsWithNoSharedElementsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .getIntersection(
                                new CustomSet<>(Arrays.asList(4, 5, 6))
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void intersectionOfTwoSetsWithSharedElementsIsASetOfTheSharedElements() {
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(2, 3))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 3, 4))
                        .getIntersection(
                                new CustomSet<>(Arrays.asList(3, 2, 5))
                        );

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void differenceOfTwoEmptySetsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getDifference(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void differenceOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getDifference(
                                new CustomSet<>(Arrays.asList(3, 2, 5))
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void differenceOfANonEmptySetAndAnEmptySetIsTheNonEmptySet() {
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 3, 4))
                        .getDifference(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void differenceOfTwoNonEmptySetsIsASetOfElementsThatAreOnlyInTheFirstSet() {
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(1, 3))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(3, 2, 1))
                        .getDifference(
                                new CustomSet<>(Arrays.asList(2, 4))
                        );

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void unionOfTwoEmptySetsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getUnion(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void unionOfAnEmptySetAndNonEmptySetIsTheNonEmptySet() {
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(2))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getUnion(
                                new CustomSet<>(Arrays.asList(2))
                        );

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void unionOfANonEmptySetAndAnEmptySetIsTheNonEmptySet() {
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(1, 3))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 3))
                        .getUnion(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void unionOfTwoNonEmptySetsContainsAllUniqueElements() {
        final CustomSet<Integer> expected
                = new CustomSet<>(
                        Collections.unmodifiableList(Arrays.asList(3, 2, 1))
                );
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 3))
                        .getUnion(
                                new CustomSet<>(Arrays.asList(2, 3))
                        );

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertTrue(expected.equals(actual));
    }

}
