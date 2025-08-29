import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class BinarySearchTest {

    @Test
    @DisplayName("finds a value in an array with one element")
    public void findsAValueInAnArrayWithOneElement() throws ValueNotFoundException {
        List<Integer> listOfUnitLength = Collections.singletonList(6);

        BinarySearch search = new BinarySearch(listOfUnitLength);

        assertThat(search.indexOf(6)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("finds a value in the middle of an array")
    public void findsAValueInTheMiddleOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThat(search.indexOf(6)).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("finds a value at the beginning of an array")
    public void findsAValueAtTheBeginningOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThat(search.indexOf(1)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("finds a value at the end of an array")
    public void findsAValueAtTheEndOfAnArray() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThat(search.indexOf(11)).isEqualTo(6);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("")
    public void findsAValueInAnArrayOfOddLength() throws ValueNotFoundException {
        List<Integer> sortedListOfOddLength = List.of(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634);

        BinarySearch search = new BinarySearch(sortedListOfOddLength);

        assertThat(search.indexOf(144)).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("finds a value in an array of even length")
    public void findsAValueInAnArrayOfEvenLength() throws ValueNotFoundException {
        List<Integer> sortedListOfEvenLength = List.of(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377);

        BinarySearch search = new BinarySearch(sortedListOfEvenLength);

        assertThat(search.indexOf(21)).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("identifies that a value is not included in the array")
    public void identifiesThatAValueIsNotFoundInTheArray() {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(7))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a value smaller than the array's smallest value is not found")
    public void aValueSmallerThanTheArraysSmallestValueIsNotFound() {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(0))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a value larger than the array's largest value is not found")
    public void aValueLargerThanTheArraysLargestValueIsNotFound() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(13))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("nothing is found in an empty array")
    public void nothingIsFoundInAnEmptyArray() throws ValueNotFoundException {
        List<Integer> emptyList = Collections.emptyList();

        BinarySearch search = new BinarySearch(emptyList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(1))
            .withMessage("Value not in array");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("nothing is found when the left and right bounds cross")
    public void nothingIsFoundWhenTheLeftAndRightBoundCross() throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 2);

        BinarySearch search = new BinarySearch(sortedList);

        assertThatExceptionOfType(ValueNotFoundException.class)
            .isThrownBy(() -> search.indexOf(0))
            .withMessage("Value not in array");
    }

}
