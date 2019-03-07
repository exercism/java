
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
    public void identifiesThatAValueIsNotFoundInTheArray() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        expectedException.expect(ValueNotFoundException.class);
        expectedException.expectMessage("Value not in array");

        search.indexOf(7);
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueSmallerThanTheArraysSmallestValueIsNotFound() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        expectedException.expect(ValueNotFoundException.class);
        expectedException.expectMessage("Value not in array");

        search.indexOf(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void aValueLargerThanTheArraysSmallestValueIsNotFound() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 3, 4, 6, 8, 9, 11)
        );

        BinarySearch search = new BinarySearch(sortedList);

        expectedException.expect(ValueNotFoundException.class);
        expectedException.expectMessage("Value not in array");

        search.indexOf(13);
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsFoundInAnEmptyArray() throws ValueNotFoundException {
        List<Integer> emptyList = Collections.emptyList();

        BinarySearch search = new BinarySearch(emptyList);

        expectedException.expect(ValueNotFoundException.class);
        expectedException.expectMessage("Value not in array");

        search.indexOf(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void nothingIsFoundWhenTheLeftAndRightBoundCross() throws ValueNotFoundException {
        List<Integer> sortedList = Collections.unmodifiableList(
                Arrays.asList(1, 2)
        );

        BinarySearch search = new BinarySearch(sortedList);

        expectedException.expect(ValueNotFoundException.class);
        expectedException.expectMessage("Value not in array");

        search.indexOf(0);
    }

}
