import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SumOfMultiplesTest {
    
    
    @Test
    public void testSumOfMultiplesOf3and4UpToOne() {
        
        int[] set = {
            3,
            5
        };
        int output = SumOfMultiples.sum(1, set);
        assertEquals(0, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToFour() {
        
        int[] set = {
            3,
            5
        };
        int output = SumOfMultiples.sum(4, set);
        assertEquals(3, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToTen() {
        
        int[] set = {
            3,
            5
        };
        int output = SumOfMultiples.sum(10, set);
        assertEquals(23, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToOneHundred() {
        
        int[] set = {
            3,
            5
        };
        int output = SumOfMultiples.sum(100, set);
        assertEquals(2318, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf3and5UpToOneThousand() {
        
        int[] set = {
            3,
            5
        };
        int output = SumOfMultiples.sum(1000, set);
        assertEquals(233168, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf7and13and17UpToTwenty() {
        
        int[] set = {
            7,
            13,
            17
        };
        int output = SumOfMultiples.sum(20, set);
        assertEquals(51, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf4and6UpToFifteen() {
        
        int[] set = {
            4,
            6
        };
        int output = SumOfMultiples.sum(15, set);
        assertEquals(30, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf5and6and8UpToOneHundredFifty() {
        
        int[] set = {
            5,
            6,
            8
        };
        int output = SumOfMultiples.sum(150, set);
        assertEquals(4419, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf5and25UpToTwoHundredSeventyFive() {
        
        int[] set = {
            5,
            25
        };
        int output = SumOfMultiples.sum(51, set);
        assertEquals(275, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOf43and47UpToTenThousand() {
        
        int[] set = {
            43,
            47
        };
        int output = SumOfMultiples.sum(10000, set);
        assertEquals(2203160, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOfOneUpToOneHundred() {
        
        int[] set = {
            1
        };
        int output = SumOfMultiples.sum(100, set);
        assertEquals(4950, output);
        
    }
    
    
    @Test
    @Ignore
    public void testSumOfMultiplesOfNoneUpToTenThousand() {
        
        int[] set = {};
        int output = SumOfMultiples.sum(10000, set);
        assertEquals(0, output);
        
    }
    
    
    
}
