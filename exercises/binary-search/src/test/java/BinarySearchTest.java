
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void findsAValueInAnArrayWithOneElement() {
        List<Integer> listOfUnitLength = Collections.singletonList(6);

        BinarySearch<Integer> search = new BinarySearch<>(listOfUnitLength);

        assertEquals(0, search.indexOf(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInTheMiddleOfAnArray() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedList);

        assertEquals(3, search.indexOf(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueAtTheBeginningOfAnArray() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedList);

        assertEquals(0, search.indexOf(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueAtTheEndOfAnArray() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedList);

        assertEquals(6, search.indexOf(11));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfOddLength() {
        List<Integer> sortedListOfOddLength = Collections.unmodifiableList(
                Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedListOfOddLength);

        assertEquals(9, search.indexOf(144));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfEvenLength() {
        List<Integer> sortedListOfEvenLength = Collections.unmodifiableList(
                Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedListOfEvenLength);

        assertEquals(5, search.indexOf(21));
    }

    @Ignore("Remove to run test")
    @Test
    public void identifiesThatAValueIsNotIncludedInTheArray() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedList);

        assertEquals(-1, search.indexOf(7));
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueSmallerThanTheArraysSmallestValueIsNotIncluded() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedList);

        assertEquals(-1, search.indexOf(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueLargerThanTheArraysSmallestValueIsNotIncluded() {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch<Integer> search = new BinarySearch<>(sortedList);

        assertEquals(-1, search.indexOf(13));
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsIncludedInAnEmptyArray() {
        List<Integer> emptyList = Collections.emptyList();

        BinarySearch<Integer> search = new BinarySearch<>(emptyList);

        assertEquals(-1, search.indexOf(1));
    }
}
