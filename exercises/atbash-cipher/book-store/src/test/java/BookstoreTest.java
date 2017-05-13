import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class BookstoreTest {

  // This is sufficient accuracy since we're handling currency values, which should be equal to within 2 decimal places.
  private static final double EQUALITY_TOLERANCE = 0.001;

  @Test
  public void onlyASingleBook() {
    List<Integer> books = new ArrayList<>(Collections.singletonList(1));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(8, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void twoOfSameBook() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 1));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(16, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void emptyBasket() {
    List<Integer> books = new ArrayList<>();
    Bookstore bookstore = new Bookstore(books);
    assertEquals(0, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void twoDifferentBooks() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 2));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(15.20, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void threeDifferentBooks() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 2, 3));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(21.6, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void fourDifferentBooks() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(25.6, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void fiveDifferentBooks() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(30, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void twoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(51.20, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void groupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 4));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(40.8, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void twoEachOfFirst4BooksAnd1CopyEachOfRest() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(55.60, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void twoCopiesOfEachBook() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(60.00, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void threeCopiesOfFirstBookAnd2EachOfRemaining() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(68.00, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

  @Ignore("Remove to run test")
  @Test
  public void threeEachOFirst2BooksAnd2EachOfRemainingBooks() {
    List<Integer> books = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 2));
    Bookstore bookstore = new Bookstore(books);
    assertEquals(75.20, bookstore.calculateTotalCost(), EQUALITY_TOLERANCE);
  }

}
