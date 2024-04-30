import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class BinarySearchTest {

    @Test
    public void findsAValueInAnArrayWithOneElement() throws ValueNotFoundException {
        List<Integer> listOfUnitLength = Collections.singletonList(6);

        BinarySearch search = new BinarySearch(listOfUnitLength);

        assertThat(search.indexOf(6)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void findsAValueInTheMiddleOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThat(search.indexOf(6)).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    public void findsAValueAtTheBeginningOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThat(search.indexOf(1)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void findsAValueAtTheEndOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThat(search.indexOf(11)).isEqualTo(6);
    }

    @Disabled("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfOddLength() throws ValueNotFoundException {
        List<Integer> sortedListOfOddLength = List.of(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634);

        BinarySearch search = new BinarySearch(sortedListOfOddLength);

        assertThat(search.indexOf(144)).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    public void findsAValueInAnArrayOfEvenLength() throws ValueNotFoundException {
        List<Integer> sortedListOfEvenLength = List.of(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377);

        BinarySearch search = new BinarySearch(sortedListOfEvenLength);

        assertThat(search.indexOf(21)).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    public void identifiesThatAValueIsNotFoundInTheArray() {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(7))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    public void aValueSmallerThanTheArraysSmallestValueIsNotFound() {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(0))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    public void aValueLargerThanTheArraysSmallestValueIsNotFound() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(13))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    public void nothingIsFoundInAnEmptyArray() throws ValueNotFoundException {
        List<Integer> emptyList = Collections.emptyList();

        BinarySearch search = new BinarySearch(emptyList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(1))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    public void nothingIsFoundWhenTheLeftAndRightBoundCross() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 2);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(0))
            .withMessage("Value not in array");
    }

}
