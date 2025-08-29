import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookStoreTest {

    // This is sufficient accuracy since we're handling currency values, which should be equal
    // to within 2 decimal places.
    private static final double EQUALITY_TOLERANCE = 0.001;

    private BookStore bookStore;

    @BeforeEach
    public void setUp() {
        bookStore = new BookStore();
    }

    @Test
    @DisplayName("Only a single book")
    public void onlyASingleBook() {
        List<Integer> books = Collections.singletonList(1);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(8.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two of the same book")
    public void twoOfSameBook() {
        List<Integer> books = Arrays.asList(2, 2);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(16.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Empty basket")
    public void emptyBasket() {
        List<Integer> books = Collections.emptyList();
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(0.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two different books")
    public void twoDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(15.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Three different books")
    public void threeDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(21.60, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Four different books")
    public void fourDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(25.60, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Five different books")
    public void fiveDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(30.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two groups of four is cheaper than group of five plus group of three")
    public void twoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(51.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two groups of four is cheaper than groups of five and three")
    public void twoGroupsOfFourIsCheaperThanGroupsOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(51.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Group of four plus group of two is cheaper than two groups of three")
    public void groupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(40.80, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two each of first four books and one copy each of rest")
    public void twoEachOfFirst4BooksAnd1CopyEachOfRest() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(55.60, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two copies of each book")
    public void twoCopiesOfEachBook() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(60.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Three copies of first book and two each of remaining")
    public void threeCopiesOfFirstBookAndTwoEachOfRemaining() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(68.00, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Three each of first two books and two each of remaining books")
    public void threeEachOFirst2BooksAnd2EachOfRemainingBooks() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 2);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(75.20, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Four groups of four are cheaper than two groups each of five and three")
    public void fourGroupsOfFourAreCheaperThanTwoGroupsEachOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 1, 1, 2, 2, 3, 3, 4, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(102.4, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Check that groups of four are created properly even when there are more groups of three than groups of five")
    public void groupsOfFourAreCreatedEvenWhenThereAreMoreGroupsOfThreeThanGroupsOfFive() {
        List<Integer> books = Arrays.asList(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(145.6, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("One group of one and four is cheaper than one group of two and three")
    public void oneGroupOfOneAndFourIsCheaperThanOneGroupOfTwoAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(33.6, Assertions.offset(EQUALITY_TOLERANCE));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("One group of one and two plus three groups of four is cheaper than one group of each size")
    public void oneGroupOfOneAndTwoPlusThreeGroupsOfFourIsCheaperThanOneGroupOfEachSize() {
        List<Integer> books = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5);
        assertThat(bookStore.calculateBasketCost(books))
                .isCloseTo(100.0, Assertions.offset(EQUALITY_TOLERANCE));
    }
}
