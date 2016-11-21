import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SumOfMultiplesTest {
    
    
    @Test
    public void testSumOfMultiplesOf3and4UpToOne() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            3,
            5
        };
        int output = mySum.Sum(1, set);
        assertEquals(0, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToFour() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            3,
            5
        };
        int output = mySum.Sum(4, set);
        assertEquals(3, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToTen() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            3,
            5
        };
        int output = mySum.Sum(10, set);
        assertEquals(23, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToOneHundred() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            3,
            5
        };
        int output = mySum.Sum(100, set);
        assertEquals(2318, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToOneThousand() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            3,
            5
        };
        int output = mySum.Sum(1000, set);
        assertEquals(233168, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf7and13and17UpToTwenty() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            7,
            13,
            17
        };
        int output = mySum.Sum(20, set);
        assertEquals(51, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf4and6UpToFifteen() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            4,
            6
        };
        int output = mySum.Sum(15, set);
        assertEquals(30, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf5and6and8UpToOneHundredFifty() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            5,
            6,
            8
        };
        int output = mySum.Sum(150, set);
        assertEquals(4419, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf5and25UpToTwoHundredSeventyFive() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            5,
            25
        };
        int output = mySum.Sum(51, set);
        assertEquals(275, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf43and47UpToTenThousand() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            43,
            47
        };
        int output = mySum.Sum(10000, set);
        assertEquals(2203160, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOfOneUpToOneHundred() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {
            1
        };
        int output = mySum.Sum(100, set);
        assertEquals(4950, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOfNoneUpToTenThousand() {
        
        SumOfMultiples mySum = new SumOfMultiples();
        int[] set = {};
        int output = mySum.Sum(10000, set);
        assertEquals(0, output);
        
    }
    
    
    
}
