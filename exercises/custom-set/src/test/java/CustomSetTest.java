
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

    @Ignore("Remove to run test")
    @Test
    public void setsWithElementsAreNotEmpty() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1))
                        .isEmpty();

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsContainedInAnEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .contains(1);

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void whenTheElementIsInTheSet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .contains(1);

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void whenTheElementIsNotInTheSet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .contains(4);

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsASubsetOfAnotherEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isSubset(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsASubsetOfNonEemptySet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1))
                        .isSubset(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void nonEmptySetIsNotASubsetOfEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1))
                        );

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void setIsASubsetOfSetWithExactSameElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void setIsASubsetOfLargerSetWithSameElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(4, 1, 2, 3))
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void setIsNotASubsetOfSetThatDoesNotContainItsElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(4, 1, 3))
                        .isSubset(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void theEmptySetIsDisjointWithItself() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isDisjoint(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsDisjointWithNonEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .isDisjoint(
                                new CustomSet<>(Arrays.asList(1))
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void nonEmptySetIsDisjointWithEmptySet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1))
                        .isDisjoint(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void setsAreNotDisjointIfTheyShareAnElement() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2))
                        .isDisjoint(
                                new CustomSet<>(Arrays.asList(2, 3))
                        );

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void setsAreDisjointIfTheyShareNoElements() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2))
                        .isDisjoint(
                                new CustomSet<>(Arrays.asList(3, 4))
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetsAreEqual() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .equals(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySetIsNotEqualToNonEmptySet() {
        final boolean actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .equals(
                                new CustomSet<>(Arrays.asList(1, 2, 3))
                        );

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void nonEmptySetIsNotEqualToEmptySet() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .equals(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void setsWithTheSameElementsAreEqual() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2))
                        .equals(
                                new CustomSet<>(Arrays.asList(2, 1))
                        );

        assertTrue(actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void setsWithDifferentElementsAreNotEqual() {
        final boolean actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .equals(
                                new CustomSet<>(Arrays.asList(1, 2, 4))
                        );

        assertFalse(actual);
    }

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfTwoEmptySetsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getIntersection(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getIntersection(
                                new CustomSet<>(Arrays.asList(3, 2, 5))
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfANonEmptySetAndAnEmptySetIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 3, 4))
                        .getIntersection(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());

    }

    @Ignore("Remove to run test")
    @Test
    public void intersectionOfTwoSetsWithNoSharedElementsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Arrays.asList(1, 2, 3))
                        .getIntersection(
                                new CustomSet<>(Arrays.asList(4, 5, 6))
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
    public void differenceOfTwoEmptySetsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getDifference(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void differenceOfAnEmptySetAndNonEmptySetIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getDifference(
                                new CustomSet<>(Arrays.asList(3, 2, 5))
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
    public void unionOfTwoEmptySetsIsAnEmptySet() {
        final CustomSet<Integer> actual
                = new CustomSet<>(Collections.EMPTY_LIST)
                        .getUnion(
                                new CustomSet<>(Collections.EMPTY_LIST)
                        );

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
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
