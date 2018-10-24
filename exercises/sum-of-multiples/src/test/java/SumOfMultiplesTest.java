import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfMultiplesTest {

    @Test
    public void testSumOfMultiplesOf3and5UpToOne() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(1, set).getSum();
        assertEquals(0, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf3and5UpToFour() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(4, set).getSum();
        assertEquals(3, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf3aUpToSeven() {

        int[] set = {
            3
        };
        int output = new SumOfMultiples(7, set).getSum();
        assertEquals(9, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf3and5UpToTen() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(10, set).getSum();
        assertEquals(23, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf3and5UpToOneHundred() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(100, set).getSum();
        assertEquals(2318, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf3and5UpToOneThousand() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(1000, set).getSum();
        assertEquals(233168, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf7and13and17UpToTwenty() {

        int[] set = {
            7,
            13,
            17
        };
        int output = new SumOfMultiples(20, set).getSum();
        assertEquals(51, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf4and6UpToFifteen() {

        int[] set = {
            4,
            6
        };
        int output = new SumOfMultiples(15, set).getSum();
        assertEquals(30, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf5and6and8UpToOneHundredFifty() {

        int[] set = {
            5,
            6,
            8
        };
        int output = new SumOfMultiples(150, set).getSum();
        assertEquals(4419, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf5and25UpToFiftyOne() {

        int[] set = {
            5,
            25
        };
        int output = new SumOfMultiples(51, set).getSum();
        assertEquals(275, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOf43and47UpToTenThousand() {

        int[] set = {
            43,
            47
        };
        int output = new SumOfMultiples(10000, set).getSum();
        assertEquals(2203160, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOfOneUpToOneHundred() {

        int[] set = {
            1
        };
        int output = new SumOfMultiples(100, set).getSum();
        assertEquals(4950, output);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOfNoneUpToTenThousand() {

        int[] set = {};
        int output = new SumOfMultiples(10000, set).getSum();
        assertEquals(0, output);

    }
}
