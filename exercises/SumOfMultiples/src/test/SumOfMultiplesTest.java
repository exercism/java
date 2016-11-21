import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfMultiplesTest {

	@Test
	public void test1() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(1,set);
		assertEquals(0,output);	
	}
	@Test
    public void test2() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(4,set);
		assertEquals(3,output);
	}
	@Test
     public void test3() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(10,set);
		assertEquals(23,output);	
	}
	@Test
     public void test4() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(100,set);
		assertEquals(2318,output);
	}
	@Test
     public void test5() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={3,5};
		int output = mySum.Sum(1000,set);
		assertEquals(233168,output);
	}
	@Test
     public void test6() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={7,13,17};
		int output = mySum.Sum(20,set);
		assertEquals(51,output);
	}
	@Test
     public void test7() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={4,6};
		int output = mySum.Sum(15,set);
		assertEquals(30,output);
	}
	@Test
     public void test8() {
		SumOfMultiples mySum = new SumOfMultiples();
		int[] set={5,6,8};
		int output = mySum.Sum(150,set);
		assertEquals(4419,output);
	}
	
	@Test
     public void test9() {
 		SumOfMultiples mySum = new SumOfMultiples();
 		int[] set={5,25};
 		int output = mySum.Sum(51,set);
 		assertEquals(275,output);
 	}
	@Test
     public void test10() {
  		SumOfMultiples mySum = new SumOfMultiples();
  		int[] set={43,47};
  		int output = mySum.Sum(10000,set);
  		assertEquals(2203160,output);
  	}
	@Test
     public void test11() {
   		SumOfMultiples mySum = new SumOfMultiples();
   		int[] set={1};
   		int output = mySum.Sum(100,set);
   		assertEquals(4950,output);	
   	}
	@Test
     public void test12() {	
    		SumOfMultiples mySum = new SumOfMultiples();
    		int[] set={};
    		int output = mySum.Sum(10000,set);
    		assertEquals(0,output);
    	}
}
