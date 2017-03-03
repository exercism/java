import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class BookStoreTest{

	@Test
	public void Basket_with_single_book(){
		Integer[] p = {1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(8,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Basket_with_two_of_same_book(){
		Integer[] p = {1,1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(16,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Empty_basket(){
		ArrayList<Integer> books = new ArrayList<>();
		assertEquals(0,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Basket_with_two_different_books(){
		Integer[] p = {1,2};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));

		assertEquals(15.20,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Basket_with_three_different_books(){
		Integer[] p = {1,2,3};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(21.6,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Basket_with_four_different_books(){
		Integer[] p = {1,2,3,4};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(25.6,BookStore.CalculateTotalCost(books),2);

	}


	@Test
	public void Basket_with_five_different_books(){
		Integer[] p = {1,2,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(30,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Basket_with_eight_books(){
		Integer[] p = {1,1,2,2,3,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(51.20,BookStore.CalculateTotalCost(books),2);
	}



	@Test
	public void Basket_with_nine_books(){
		Integer[] p = {1,1,2,2,3,3,4,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(55.60,BookStore.CalculateTotalCost(books),2);
	}

	@Test
	public void Basket_with_ten_books(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(60,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Basket_with_eleven_books(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(68,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void  Basket_with_twelve_books(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1,2};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(75.20,BookStore.CalculateTotalCost(books),2);
	}
}

