import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class BookstoreTest{

	@Test
	public void onlyASingleBook(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(8,bookstore.calculateTotalCost(),2);
	}
	
	@Ignore
	@Test
	public void twoOfSameBook(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,1));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(16,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void emptyBasket(){
		List<Integer> books = new ArrayList<>();
		Bookstore bookstore = new Bookstore(books);
		assertEquals(0,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void twoDifferentBooks(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,2));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(15.20,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void threeDifferentBooks(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,2,3));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(21.6,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void fourDifferentBooks(){
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(1,2,3,4));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(25.6,bookstore.calculateTotalCost(),2);

	}

	@Ignore
	@Test
	public void fiveDifferentBooks(){
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(30,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void twoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,5));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(51.20,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void groupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,1,2,2,3,4));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(40.8,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void twoEachOfFirst4BooksAnd1CopyEachOfRest(){
		Integer[] p = {1,1,2,2,3,3,4,4,5};
		List<Integer> books = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(55.60,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void twoCopiesOfEachBook(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(60.00,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void threeCopiesOfFirstBookAnd2EachOfRemaining(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5,1));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(68.00,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void threeEachOFirst2BooksAnd2EachOfRemainingBooks(){
		List<Integer> books = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5,1,2));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(75.20,bookstore.calculateTotalCost(),2);
	}

}

