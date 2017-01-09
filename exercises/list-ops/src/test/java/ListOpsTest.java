
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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
    public void shouldReturnCorrectLengthOfAnNonEmptyList() {
        final int expected = 4;
        final List<Integer> list = Collections.unmodifiableList(
                IntStream.range(0, expected)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final int actual = ListOps.length(list);

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
    public void shouldReverseNonEmptyList() {
        final int length = 100;
        final int startValue = 0;
        final List<Integer> reversedList
                = IntStream.range(startValue, length)
                        .boxed()
                        .collect(Collectors.toList());
        Collections.reverse(reversedList);
        final List<Integer> expected
                = Collections.unmodifiableList(reversedList);
        final List<Integer> list = Collections.unmodifiableList(
                IntStream.range(startValue, length)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final List<Integer> actual
                = ListOps.reverse(list);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void mapOfAnEmptyListShouldBeAnEmptyList() {
        final List<Integer> actual = ListOps.map(EMPTY_LIST, x -> x + 1);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldMapNonEmptyList() {
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(2, 4, 6, 8));
        final List<Integer> list
                = Collections.unmodifiableList(Arrays.asList(1, 3, 5, 7));
        final List<Integer> actual = ListOps.map(list, x -> x + 1);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void fileteredEmptyListShouldBeAnEmptyList() {
        final List<Integer> actual = ListOps.filter(EMPTY_LIST, x -> x > 0);

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldFilterNonEmptyList() {
        final List<Integer> expected
                = Collections.unmodifiableList(Arrays.asList(1, 3));
        final List<Integer> list = Collections.unmodifiableList(
                IntStream.range(0, 4).boxed().collect(Collectors.toList())
        );
        final List<Integer> actual = ListOps.filter(list, x -> x % 2 > 0);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldReturnAnEmptyListWhenAnEmptyListIsAppendedToAnEmptyList() {
        List<Integer> listTo = Collections.emptyList();
        assertFalse(ListOps.append(listTo, EMPTY_LIST));
        final List<Integer> actual = listTo;

        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Ignore
    public void shouldAppendAnEmptyListToANonEmptyList() {
        final List<Integer> expected
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> listTo
                = IntStream.range(0, 4)
                        .boxed()
                        .collect(Collectors.toList());
        assertFalse(ListOps.append(listTo, EMPTY_LIST));
        final List<Integer> actual = listTo;

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldAppendANonEmptyListToAnEmptyList() {
        final List<Integer> expected
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        List<Integer> listTo = new ArrayList<>();
        final List<Integer> listFrom
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        assertTrue(ListOps.append(listTo, listFrom));
        final List<Integer> actual = listTo;

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldAppendNonEmptyLists() {
        final List<Integer> expected
                = Collections.unmodifiableList(
                        IntStream.range(0, 8)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> listTo
                = IntStream.range(0, 4)
                        .boxed()
                        .collect(Collectors.toList());
        final List<Integer> listFrom
                = Collections.unmodifiableList(
                        IntStream.range(4, 8)
                                .boxed()
                                .collect(Collectors.toList())
                );
        assertTrue(ListOps.append(listTo, listFrom));
        final List<Integer> actual = listTo;

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
        final List<Integer> expected
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> list
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> actual = ListOps.concat(list);

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
        final List<Integer> expected
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> list
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> actual = ListOps.concat(list, EMPTY_LIST);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateOneNonEmptyAndOneEmptyLists() {
        final List<Integer> expected
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> list
                = Collections.unmodifiableList(
                        IntStream.range(0, 4)
                                .boxed()
                                .collect(Collectors.toList())
                );
        final List<Integer> actual = ListOps.concat(EMPTY_LIST, list);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateTwoListsWithSameElements() {
        final List<Integer> list1 = Collections.unmodifiableList(
                IntStream.range(0, 4).boxed().collect(Collectors.toList())
        );
        final List<Integer> list2 = Collections.unmodifiableList(
                IntStream.range(1, 6).boxed().collect(Collectors.toList())
        );
        final List<Integer> sortedCancatenatedList
                = Stream.concat(list1.stream(), list2.stream())
                        .collect(Collectors.toList());
        Collections.sort(sortedCancatenatedList);
        final List<Integer> expected = Collections.unmodifiableList(
                sortedCancatenatedList);
        final List<Integer> actual = ListOps.concat(list1, list2);
        Collections.sort(actual);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldConcatenateSeveralLists() {
        final List<Integer> list1 = Collections.unmodifiableList(
                IntStream.range(0, 4).boxed().collect(Collectors.toList())
        );
        final List<Integer> list2 = Collections.unmodifiableList(
                IntStream.range(4, 8).boxed().collect(Collectors.toList())
        );
        final List<Integer> list3 = Collections.unmodifiableList(
                IntStream.range(8, 12).boxed().collect(Collectors.toList())
        );
        final List<Integer> list4 = Collections.unmodifiableList(
                IntStream.range(12, 16).boxed().collect(Collectors.toList())
        );
        final List<Integer> sortedCancatenatedList
                = new ArrayList<>(list1);
        sortedCancatenatedList.addAll(list2);
        sortedCancatenatedList.addAll(list3);
        sortedCancatenatedList.addAll(list4);
        Collections.sort(sortedCancatenatedList);
        final List<Integer> expected = Collections.unmodifiableList(
                sortedCancatenatedList
        );
        final List<Integer> actual
                = ListOps.concat(list1, list2, EMPTY_LIST, list3, list4);
        Collections.sort(actual);

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
        final int expected = 10;
        final List<Integer> list = Collections.unmodifiableList(
                IntStream.range(0, 5)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final int actual = ListOps.reduce(list, 0,
                (x, y) -> x + y,
                Integer::sum);

        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldReduceWithAnticommutativeAccumulator() {
        final int expected = 0;
        final List<Integer> list = Collections.unmodifiableList(
                IntStream.range(0, 5)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final int actual
                = ListOps.reduce(list, 10, (x, y) -> x - y, (x, y)
                        -> {
                    throw new IllegalStateException(
                            "Operation cannot be parallelyzed.");
                });

        assertEquals(expected, actual);
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
    public void reduceShouldConcatenateAnEmptyListAndANonEmptyList() {
        final List<Integer> expected = Collections.unmodifiableList(
                IntStream.range(0, 5)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final List<Integer> list = Collections.unmodifiableList(
                IntStream.range(0, 5)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final List<Integer> actual
                = ListOps.reduce(list,
                        new ArrayList<Integer>(),
                        accumulator,
                        combiner);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void reduceShouldConcatenateTwoNonEmptyLists() {
        final List<Integer> expected = Collections.unmodifiableList(
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final List<Integer> listOne = Collections.unmodifiableList(
                IntStream.range(0, 5)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final List<Integer> listTwo = Collections.unmodifiableList(
                IntStream.range(5, 10)
                        .boxed()
                        .collect(Collectors.toList())
        );
        final List<Integer> actual
                = ListOps.reduce(listTwo,
                        listOne,
                        accumulator,
                        combiner);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }
}
