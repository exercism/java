import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {

    @Test
    public void findsAValueInAnArrayWithOneElement() throws ValueNotFoundException {
        List<Integer> listOfUnitLength = Collections.singletonList(6);

        BinarySearch search = new BinarySearch(listOfUnitLength);

        assertEquals(0, search.indexOf(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInTheMiddleOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        assertEquals(3, search.indexOf(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueAtTheBeginningOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        assertEquals(0, search.indexOf(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueAtTheEndOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        assertEquals(6, search.indexOf(11));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfOddLength() throws ValueNotFoundException {
        List<Integer> sortedListOfOddLength = Collections.unmodifiableList(
                Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634)
        );

        BinarySearch search = new BinarySearch(sortedListOfOddLength);

        assertEquals(9, search.indexOf(144));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfEvenLength() throws ValueNotFoundException {
        List<Integer> sortedListOfEvenLength = Collections.unmodifiableList(
                Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        );

        BinarySearch search = new BinarySearch(sortedListOfEvenLength);

        assertEquals(5, search.indexOf(21));
    }

    @Ignore("Remove to run test")
    @Test
    public void identifiesThatAValueIsNotFoundInTheArray() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        ValueNotFoundException expected =
            assertThrows(
                ValueNotFoundException.class,
                () -> search.indexOf(7));

        assertThat(expected).hasMessage("Value not in array");
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueSmallerThanTheArraysSmallestValueIsNotFound() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        ValueNotFoundException expected =
            assertThrows(
                ValueNotFoundException.class,
                () -> search.indexOf(0));

        assertThat(expected).hasMessage("Value not in array");
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueLargerThanTheArraysSmallestValueIsNotFound() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        ValueNotFoundException expected =
            assertThrows(
                ValueNotFoundException.class,
                () -> search.indexOf(13));

        assertThat(expected).hasMessage("Value not in array");
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsFoundInAnEmptyArray() throws ValueNotFoundException {
        List<Integer> emptyList = Collections.emptyList();

        BinarySearch search = new BinarySearch(emptyList);

        ValueNotFoundException expected =
            assertThrows(
                ValueNotFoundException.class,
                () -> search.indexOf(1));

        assertThat(expected).hasMessage("Value not in array");
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsFoundWhenTheLeftAndRightBoundCross() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 2)
        );

        BinarySearch search = new BinarySearch(sortedList);

        ValueNotFoundException expected =
            assertThrows(
                ValueNotFoundException.class,
                () -> search.indexOf(0));

        assertThat(expected).hasMessage("Value not in array");
    }

}
