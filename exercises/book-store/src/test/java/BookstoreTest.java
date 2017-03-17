import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class BookstoreTest{

	@Test
	public void onlyASingleBook(){
		Integer[] p = {1};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(8,bookstore.calculateTotalCost(),2);
	}
	
	@Ignore
	@Test
	public void twoOfSameBook(){
		Integer[] p = {1,1};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
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
		Integer[] p = {1,2};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(15.20,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void threeDifferentBooks(){
		Integer[] p = {1,2,3};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(21.6,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void fourDifferentBooks(){
		Integer[] p = {1,2,3,4};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(25.6,bookstore.calculateTotalCost(),2);

	}

	@Ignore
	@Test
	public void fiveDifferentBooks(){
		Integer[] p = {1,2,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(30,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void twoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree(){
		Integer[] p = {1,1,2,2,3,3,4,5};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(51.20,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void groupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree(){
		Integer[] p = {1,1,2,2,3,4};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(40.8,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void twoEachOfFirst4BooksAnd1CopyEachOfRest(){
		Integer[] p = {1,1,2,2,3,3,4,4,5};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(55.60,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void twoCopiesOfEachBook(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(60.00,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void threeCopiesOfFirstBookAnd2EachOfRemaining(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(68.00,bookstore.calculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void threeEachOFirst2BooksAnd2EachOfRemainingBooks(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1,2};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		Bookstore bookstore = new Bookstore(books);
		assertEquals(75.20,bookstore.calculateTotalCost(),2);
	}

}

