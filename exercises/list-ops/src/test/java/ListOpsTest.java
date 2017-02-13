
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import org.junit.Ignore;
import org.junit.Test;

public class ListOpsTest {

    private static final List<Integer> EMPTY_LIST
            = Collections.emptyList();

    @Test
    public void lengthOfAnEmptyListShouldBeZero() {
        final int expected = 0;
        final int actual = ListOps.length(EMPTY_LIST);

        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldReturnTheCorrectLengthOfAnNonEmptyList() {
        final List<Integer> list = Collections.unmodifiableList(
                Arrays.asList(0, 1, 2, 3, 4)
        );
        final int actual = ListOps.length(list);
        final int expected = list.size();

        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldReverseAnEmptyList() {
        final List<Integer> actual = ListOps.reverse(EMPTY_LIST);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldReverseANonEmptyList() {
        final List<Integer> list = Collections.unmodifiableList(
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8)
        );
        final List<Integer> actual
                = ListOps.reverse(list);
        final List<Integer> expected
                = Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1, 0);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldMapAnEmptyListAndReturnAnEmptyList() {
        final List<Integer> actual = ListOps.map(EMPTY_LIST, x -> x + 1);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldMapNonEmptyList() {
        final List<Integer> list
                = Collections.unmodifiableList(Arrays.asList(1, 3, 5, 7));
        final List<Integer> actual = ListOps.map(list, x -> x + 1);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(Arrays.asList(2, 4, 6, 8), actual);
    }

    @Test
    @Ignore
    public void shouldFilterAnEmptyListanddReturnAnEmptyList() {
        final List<Integer> actual = ListOps.filter(EMPTY_LIST, x -> x > 0);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldFilterNonEmptyList() {
        Predicate<Integer> predicate = x -> x % 2 > 0;
        final List<Integer> list = Collections.unmodifiableList(
                IntStream.range(0, 100).boxed().collect(Collectors.toList())
        );
        final List<Integer> actual = ListOps.filter(list, predicate);
        final List<Integer> expected = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateZeroLists() {
        List<Integer> actual = ListOps.concat();

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldConcatenateOneNonEmptyList() {
        final List<Integer> list
                = Collections.unmodifiableList(
                        Arrays.asList(0, 1, 2, 3, 4)
                );
        final List<Integer> actual = ListOps.concat(list);
        final List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateOneEmptyList() {
        final List<Integer> actual = ListOps.concat(EMPTY_LIST);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldConcatenateTwoEmptyLists() {
        final List<Integer> actual = ListOps.concat(EMPTY_LIST, EMPTY_LIST);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldConcatenateOneEmptyAndOneNonEmptyLists() {
        final List<Integer> list
                = Collections.unmodifiableList(
                        Arrays.asList(0, 1, 2, 3, 4)
                );
        final List<Integer> actual = ListOps.concat(list, EMPTY_LIST);
        final List<Integer> expected
                = Arrays.asList(0, 1, 2, 3, 4);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateOneNonEmptyAndOneEmptyLists() {
        final List<Integer> list
                = Collections.unmodifiableList(
                        Arrays.asList(0, 1, 2, 3, 4)
                );
        final List<Integer> actual = ListOps.concat(EMPTY_LIST, list);
        final List<Integer> expected
                = Arrays.asList(0, 1, 2, 3, 4);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateTwoListsWithSameElements() {
        final List<Integer> list1 = Collections.unmodifiableList(
                Arrays.asList(0, 1, 2, 3, 4)
        );
        final List<Integer> list2 = Collections.unmodifiableList(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        final List<Integer> expected
                = Arrays.asList(0, 1, 2, 3, 4, 1, 2, 3, 4, 5, 6);
        final List<Integer> actual = ListOps.concat(list1, list2);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateSeveralLists() {
        final List<Integer> list1 = Collections.unmodifiableList(
                Arrays.asList(0, 1, 2, 3)
        );
        final List<Integer> list2 = Collections.unmodifiableList(
                Arrays.asList(4, 5, 6, 7)
        );
        final List<Integer> list3 = Collections.unmodifiableList(
                Arrays.asList(8, 9, 10, 11)
        );
        final List<Integer> list4 = Collections.unmodifiableList(
                Arrays.asList(12, 13, 14, 15)
        );
        final List<Integer> expected
                = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                        14, 15);

        final List<Integer> actual
                = ListOps.concat(list1, list2, EMPTY_LIST, list3, list4);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldReturnIdentityWhenAnEmptyListIsReduced() {
        final int expected = 0;
        final int actual
                = ListOps.reduce(EMPTY_LIST, 0, (x, y) -> x + y, Integer::sum);

        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldCalculateTheSumOfANonEmptyIntegerList() {
        final List<Integer> list = Collections.unmodifiableList(
                Arrays.asList(0, 1, 2, 3, 4)
        );
        final int actual = ListOps.reduce(list, 0,
                (x, y) -> x + y,
                Integer::sum);

        assertEquals(10, actual);
    }

    /*
    https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
    https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#reduce-U-java.util.function.BiFunction-java.util.function.BinaryOperator-
     */
    private BiFunction<List<Integer>, Integer, List<Integer>> accumulator
            = (List<Integer> partial, Integer elem) -> {
                List<Integer> result = new ArrayList<>(partial);
                result.add(elem);
                return result;
            };

    private BinaryOperator<List<Integer>> combiner
            = (list1, list2) -> {
                List<Integer> result = new ArrayList<>(list1);
                result.addAll(list2);
                return result;
            };

    @Test
    @Ignore
    public void shouldReduceAnEmptyListAndANonEmptyListAndReturnConcatenation() {
        final List<Integer> list = Collections.unmodifiableList(
                Arrays.asList(0, 1, 2, 3, 4, 5)
        );
        final List<Integer> actual
                = ListOps.reduce(list,
                        new ArrayList<Integer>(),
                        accumulator,
                        combiner);
        final List<Integer> expected
                = Arrays.asList(0, 1, 2, 3, 4, 5);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldReduceTwoNonEmptyListsAndReturnConcatenation() {
        final List<Integer> listOne = Collections.unmodifiableList(
                Arrays.asList(0, 1, 2, 3, 4)
        );
        final List<Integer> listTwo = Collections.unmodifiableList(
                Arrays.asList(5, 6, 7, 8, 9)
        );
        final List<Integer> actual
                = ListOps.reduce(listTwo,
                        listOne,
                        accumulator,
                        combiner);
        final List<Integer> expected
                = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

}
