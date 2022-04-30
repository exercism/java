import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BookStoreTest {

    // This is sufficient accuracy since we're handling currency values, which should be equal
    // to within 2 decimal places.
    private static final double EQUALITY_TOLERANCE = 0.001;

    private BookStore bookStore;

    @Before
    public void setUp() {
        bookStore = new BookStore();
    }

    @Test
    public void onlyASingleBook() {
        List<Integer> books = Collections.singletonList(1);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(8.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoOfSameBook() {
        List<Integer> books = Arrays.asList(2, 2);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(16.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void emptyBasket() {
        List<Integer> books = Collections.emptyList();
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(0.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(15.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(21.60, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(25.60, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void fiveDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(30.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(51.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoGroupsOfFourIsCheaperThanGroupsOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(51.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void groupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(40.80, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoEachOfFirst4BooksAnd1CopyEachOfRest() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(55.60, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoCopiesOfEachBook() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(60.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void threeCopiesOfFirstBookAnd2EachOfRemaining() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(68.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void threeEachOFirst2BooksAnd2EachOfRemainingBooks() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 2);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(75.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Ignore("Remove to run test")
    @Test
    public void fourGroupsOfFourAreCheaperThanTwoGroupsEachOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 1, 1, 2, 2, 3, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
            .isCloseTo(102.4, Assertions.offset(EQUALITY_TOLERANCE));
    }
}
