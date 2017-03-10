import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class BookStoreTest{

	@Test
	public void Only_a_single_book(){
		Integer[] p = {1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(8,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Two_of_same_book(){
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
	public void Two_different_books(){
		Integer[] p = {1,2};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(15.20,BookStore.CalculateTotalCost(books),2);
	}





	@Test
	public void Three_different_books(){
		Integer[] p = {1,2,3};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(21.6,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Four_different_books(){
		Integer[] p = {1,2,3,4};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(25.6,BookStore.CalculateTotalCost(books),2);

	}


	@Test
	public void Five_different_books(){
		Integer[] p = {1,2,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(30,BookStore.CalculateTotalCost(books),2);
	}




	@Test
	public void Two_groups_of_four_is_cheaper_than_group_of_five_plus_group_of_three(){
		Integer[] p = {1,1,2,2,3,3,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(51.20,BookStore.CalculateTotalCost(books),2);
	}

	@Test
	public void Group_of_four_plus_group_of_two_is_cheaper_than_two_groups_of_three(){
		Integer[] p = {1,1,2,2,3,4};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(40.8,BookStore.CalculateTotalCost(books),2);
	}



	@Test
	public void Two_each_of_first_4_books_and_1_copy_each_of_rest(){
		Integer[] p = {1,1,2,2,3,3,4,4,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(55.60,BookStore.CalculateTotalCost(books),2);
	}


	

	@Test
	public void Two_copies_of_each_book(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(60.00,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Three_copies_of_first_book_and_2_each_of_remaining(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(68.00,BookStore.CalculateTotalCost(books),2);
	}


	@Test
	public void Three_each_of_first_2_books_and_2_each_of_remaining_books(){
		Integer[] p = {1,1,2,2,3,3,4,4,5,5,1,2};
		ArrayList<Integer> books = new ArrayList<>(Arrays.asList(p));
		assertEquals(75.20,BookStore.CalculateTotalCost(books),2);
	}








}

