
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class BinarySearchTest {

    public static final List<Integer> EMPTY_LIST
            = Collections.unmodifiableList(new ArrayList<Integer>(0));

    public static final List<Integer> LIST_OF_UNIT_LENGTH
            = Collections.unmodifiableList(
                    Arrays.asList(6)
            );

    private static final List<Integer> SORTED_LIST
            = Collections.unmodifiableList(
                    Arrays.asList(1, 3, 4, 6, 8, 9, 11)
            );

    public static final List<Integer> SORTED_LIST_OF_ODD_LENGTH
            = Collections.unmodifiableList(
                    Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55,
                            89, 144, 233, 377, 634)
            );

    public static final List<Integer> SORTED_LIST_OF_EVEN_LENGTH
            = Collections.unmodifiableList(
                    Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55,
                            89, 144, 233, 377)
            );

    @Test
    public void findsAValueInAnArrayWithOneElement() {
        BinarySearch<Integer> sut = new BinarySearch<>(LIST_OF_UNIT_LENGTH);
        final int value = 6;
        final int actual = sut.indexOf(value);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void findsAValueInTheMiddleOfAnArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int value = 6;
        final int actual = sut.indexOf(value);
        final int expected = 3;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void findsAValueAtTheBeginningOfAnArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int value = 1;
        final int actual = sut.indexOf(value);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void findsAValueAtTheEndOfAnArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int value = 11;
        final int actual = sut.indexOf(value);
        final int expected = 6;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void findsAValueInAnArrayOfOddLength() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST_OF_ODD_LENGTH);
        final int value = 144;
        final int actual = sut.indexOf(value);
        final int expected = 9;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void findsAValueInAnArrayOfEvenLength() {
        BinarySearch<Integer> sut
                = new BinarySearch<>(SORTED_LIST_OF_EVEN_LENGTH);
        final int value = 21;
        final int actual = sut.indexOf(value);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void identifiesThatAValueIsNotIncludedInTheArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int value = 7;
        final int actual = sut.indexOf(value);
        final int expected = -1;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void aValueSmallerThanTheArraysSmallestValueIsNotIncluded() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int value = 0;
        final int actual = sut.indexOf(value);
        final int expected = -1;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void aValueLargerThanTheArraysSmallestValueIsNotIncluded() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int value = 13;
        final int actual = sut.indexOf(value);
        final int expected = -1;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void nothingIsIncludedInAnEmptyArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(EMPTY_LIST);
        final int value = 1;
        final int actual = sut.indexOf(value);
        final int expected = -1;
        assertEquals(expected, actual);
    }
}
