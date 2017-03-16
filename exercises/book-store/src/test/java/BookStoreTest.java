import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class BookStoreTest{

	@Test
	public void OnlyASingleBook(){
		Integer[] p = {1};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(8,bookStore.CalculateTotalCost(),2);
	}
	
	@Ignore
	@Test
	public void TwoOfSameBook(){
		Integer[] p = {1,1};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(16,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void EmptyBasket(){
		List<Integer> books = new ArrayList<>();
		BookStore bookStore = new BookStore(books);
		assertEquals(0,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void TwoDifferentBooks(){
		Integer[] p = {1,2};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(15.20,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void ThreeDifferentBooks(){
		Integer[] p = {1,2,3};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(21.6,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void FourDifferentBooks(){
		Integer[] p = {1,2,3,4};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(25.6,bookStore.CalculateTotalCost(),2);

	}

	@Ignore
	@Test
	public void FiveDifferentBooks(){
		Integer[] p = {1,2,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(30,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void TwoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree(){
		Integer[] p = {1,1,2,2,3,3,4,5};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(51.20,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void GroupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree(){
		Integer[] p = {1,1,2,2,3,4};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(40.8,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void TwoEachOfFirst4BooksAnd1CopyEachOfRest(){
		Integer[] p = {1,1,2,2,3,3,4,4,5};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(55.60,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void TwoCopiesOfEachBook(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(60.00,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void ThreeCopiesOfFirstBookAnd2EachOfRemaining(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(68.00,bookStore.CalculateTotalCost(),2);
	}

	@Ignore
	@Test
	public void ThreeEachOFirst2BooksAnd2EachOfRemainingBooks(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1,2};
		List<Integer> books = new ArrayList<>(Arrays.asList(p));
		BookStore bookStore = new BookStore(books);
		assertEquals(75.20,bookStore.CalculateTotalCost(),2);
	}

}

