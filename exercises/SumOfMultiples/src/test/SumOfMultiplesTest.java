import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SumOfMultiplesTest {

	
	@Test
	public void testSumOfMultiplesInputOne() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(1,set);
		assertEquals(0,output);
		
	}
	
	
	@Test
	@Ignore
    public void testSumOfMultiplesInputFour() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(4,set);
		assertEquals(3,output);
		
	}
    
    
	@Test
	@Ignore
     public void testSumOfMultiplesInputTen() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(10,set);
		assertEquals(23,output);
		
	}
     
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputOneHundred() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(100,set);
		assertEquals(2318,output);
		
	}
    
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputOneThousand() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(1000,set);
		assertEquals(233168,output);
		
	}
     
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputTwenty() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={7,13,17};
		int output = mySum.Sum(20,set);
		assertEquals(51,output);
		
	}
     
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputThirty() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={4,6};
		int output = mySum.Sum(15,set);
		assertEquals(30,output);
		
	}
     
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputOneHundredFifty() {
		
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={5,6,8};
		int output = mySum.Sum(150,set);
		assertEquals(4419,output);
		
	}
	
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputFiftyOne() {
 		
 		SumOfMultiples mySum = new SumOfMultiples();
 		int[] set={5,25};
 		int output = mySum.Sum(51,set);
 		assertEquals(275,output);
 		
 	}
	
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputTenThousand() {
  		
  		SumOfMultiples mySum = new SumOfMultiples();
  		int[] set={43,47};
  		int output = mySum.Sum(10000,set);
  		assertEquals(2203160,output);
  		
  	}
	
	
	@Test
	@Ignore
     public void testSumOfMultiplesInputOneNumberArray() {
   		
   		SumOfMultiples mySum = new SumOfMultiples();
   		int[] set={1};
   		int output = mySum.Sum(100,set);
   		assertEquals(4950,output);
   		
   	}
	
	
	@Test
	@Ignore
     public void testSumOfMultiplesEmptyArray() {
    		
    		SumOfMultiples mySum = new SumOfMultiples();
    		int[] set={};
    		int output = mySum.Sum(10000,set);
    		assertEquals(0,output);
    		
    	}
	
	

}
