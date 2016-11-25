
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BinarySearchTest {

    private static final List<Integer> SORTED_LIST
            = Collections.unmodifiableList(
                    Arrays.asList(1, 2, 3, 4, 5, 6)
            );

    public static final List<Integer> SORTED_LIST_OF_ODD_LENGTH
            = Collections.unmodifiableList(
                    Arrays.asList(0, 1, 2, 2, 3, 10, 12)
            );

    public static final List<Integer> UNSORTED_LIST
            = Collections.unmodifiableList(
                    Arrays.asList(10, 2, 5, 1)
            );

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldRequireASortedListOK() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        List<Integer> actual = sut.getArray();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.size(), SORTED_LIST.size());
        assertEquals(actual, SORTED_LIST);
    }

    @Ignore
    @Test
    public void shouldRequireASortedListButNotSorted() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(BinarySearch.ARRAY_MUST_BE_SORTED);
        new BinarySearch<Integer>(UNSORTED_LIST);
    }

    @Ignore
    @Test
    public void shouldFindTheCorrectIndexInTheMiddleOfArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int number = 3;
        final int actual = sut.indexOf(number);
        final int expected = 2;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void shouldFindTheCorrectIndexAtTheBeginningOfArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int number = 1;
        final int actual = sut.indexOf(number);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void shouldFindTheCorrectIndexAtTheEndOfArray() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int number = 6;
        final int actual = sut.indexOf(number);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void shouldFindTheCorrectIndexInTheMiddleOfArrayOfOddLength() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST_OF_ODD_LENGTH);
        final int number = 2;
        final int actual = sut.indexOf(number);
        final int expected = 3;
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void shouldReturnMinusOneIfNotFound() {
        BinarySearch<Integer> sut = new BinarySearch<>(SORTED_LIST);
        final int number = 10;
        final int actual = sut.indexOf(number);
        final int expected = -1;
        assertEquals(expected, actual);
    }
}
