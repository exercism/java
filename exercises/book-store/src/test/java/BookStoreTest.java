import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class BookStoreTest{

	@Test
	public void OnlyASingleBook(){
		Integer[] p = {1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(8,BookStore.CalculateTotalCost(books),2);
	}
	
	@Ignore
	@Test
	public void TwoOfSameBook(){
		Integer[] p = {1,1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(16,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void EmptyBasket(){
		ArrayList<Integer> books = new ArrayList<>();
		assertEquals(0,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void TwoDifferentBooks(){
		Integer[] p = {1,2};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(15.20,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void ThreeDifferentBooks(){
		Integer[] p = {1,2,3};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(21.6,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void FourDifferentBooks(){
		Integer[] p = {1,2,3,4};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(25.6,BookStore.CalculateTotalCost(books),2);

	}

	@Ignore
	@Test
	public void FiveDifferentBooks(){
		Integer[] p = {1,2,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(30,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void TwoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree(){
		Integer[] p = {1,1,2,2,3,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(51.20,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void GroupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree(){
		Integer[] p = {1,1,2,2,3,4};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(40.8,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void TwoEachOfFirst4BooksAnd1CopyEachOfRest(){
		Integer[] p = {1,1,2,2,3,3,4,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(55.60,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void TwoCopiesOfEachBook(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(60.00,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void ThreeCopiesOfFirstBookAnd2EachOfRemaining(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(68.00,BookStore.CalculateTotalCost(books),2);
	}

	@Ignore
	@Test
	public void ThreeEachOFirst2BooksAnd2EachOfRemainingBooks(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1,2};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(75.20,BookStore.CalculateTotalCost(books),2);
	}

}

