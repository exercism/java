
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void findsAValueInAnArrayWithOneElement() throws NoSuchElementException {
        List<Integer> listOfUnitLength = Collections.singletonList(6);

        BinarySearch search = new BinarySearch(listOfUnitLength);

        assertEquals(0, search.indexOf(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInTheMiddleOfAnArray() throws NoSuchElementException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        assertEquals(3, search.indexOf(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueAtTheBeginningOfAnArray() throws NoSuchElementException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        assertEquals(0, search.indexOf(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueAtTheEndOfAnArray() throws NoSuchElementException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        assertEquals(6, search.indexOf(11));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfOddLength() throws NoSuchElementException {
        List<Integer> sortedListOfOddLength = Collections.unmodifiableList(
                Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634)
        );

        BinarySearch search = new BinarySearch(sortedListOfOddLength);

        assertEquals(9, search.indexOf(144));
    }

    @Ignore("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfEvenLength() throws NoSuchElementException {
        List<Integer> sortedListOfEvenLength = Collections.unmodifiableList(
                Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        );

        BinarySearch search = new BinarySearch(sortedListOfEvenLength);

        assertEquals(5, search.indexOf(21));
    }

    @Ignore("Remove to run test")
    @Test
    public void identifiesThatAValueIsNotIncludedInTheArray() throws NoSuchElementException {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("value not in array");
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        search.indexOf(7);
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueSmallerThanTheArraysSmallestValueIsNotIncluded() throws NoSuchElementException {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("value not in array");
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        search.indexOf(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueLargerThanTheArraysSmallestValueIsNotIncluded() throws NoSuchElementException {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("value not in array");
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        search.indexOf(13);
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsIncludedInAnEmptyArray() throws NoSuchElementException {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("value not in array");
        List<Integer> emptyList = Collections.emptyList();

        BinarySearch search = new BinarySearch(emptyList);

        search.indexOf(1);
    }
}
