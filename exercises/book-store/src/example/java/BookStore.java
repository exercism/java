import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookStore{

	private int bookPrice, maxGroupSize;
	private double discountIncrement;
	private List<Integer> books;	

	public BookStore (List<Integer> books){
		this.books = books;
		this.bookPrice = 8;
		this.maxGroupSize = 5;
		this.discountIncrement = 0.05;
	}	

	public double CalculateTotalCost(){
		return CalculateTotalCost(this.books,0);
	}

	private double CalculateTotalCost (List<Integer> books,double priceSoFar ){
		double minPrice = Double.MAX_VALUE;


		if(books.size() == 0)
			return priceSoFar;

		List<Integer> groups = (ArrayList<Integer>) books.stream().distinct().collect(Collectors.toList());


		double price = 0;

		for(int i = 0;i<groups.size();i++){
			books.remove(groups.get(i));	
		}


		try {
			price = CalculateTotalCost(books,priceSoFar + CostPerGroup(groups.size()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		minPrice = Math.min(minPrice, price);
		return minPrice;


	}

	private double CostPerGroup(int groupSize) throws Exception{

		double discountPercentage;
		switch (groupSize)
		{
		case 1:
			discountPercentage = 0;
			break;
		case 2:
			discountPercentage = 5;
			break;
		case 3:
			discountPercentage = 10;
			break;
		case 4:
			discountPercentage = 20;
			break;
		case 5:
			discountPercentage = 25;
			break;
		default:
			throw new Exception("Invalide group size : " + groupSize );
		}
		return 8 * groupSize * (100 - discountPercentage) / 100; 

	}
}
