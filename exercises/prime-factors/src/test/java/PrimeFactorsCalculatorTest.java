import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class PrimeFactorsCalculatorTest {

    private PrimeFactorsCalculator primeFactorsCalculator;

    @Before
    public void setUp() {
        primeFactorsCalculator = new PrimeFactorsCalculator();
    }

    @Test
    public void testEmptyListResult() {
        assertEquals(Collections.emptyList(), primeFactorsCalculator.calculatePrimeFactorsOf(1L));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleTonListResult() {
        assertEquals(Collections.singletonList(2L), primeFactorsCalculator.calculatePrimeFactorsOf(2L));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSquareNumberPrimeFactorResult() {
        assertEquals(Arrays.asList(3L, 3L), primeFactorsCalculator.calculatePrimeFactorsOf(9L));
    }

    @Ignore("Remove to run test")
    @Test
    public void test8LPrimeFactorResult() {
        assertEquals(Arrays.asList(2L, 2L, 2L), primeFactorsCalculator.calculatePrimeFactorsOf(8L));
    }

    @Ignore("Remove to run test")
    @Test
    public void test12LPrimeFactorResult() {
        assertEquals(Arrays.asList(2L, 2L, 3L), primeFactorsCalculator.calculatePrimeFactorsOf(12L));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMedianLargeNumberPrimeFactorResult() {
        assertEquals(Arrays.asList(5L, 17L, 23L, 461L), primeFactorsCalculator.calculatePrimeFactorsOf(901255L));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeNumberPrimeFactorResult() {
        assertEquals(Arrays.asList(11L, 9539L, 894119L), primeFactorsCalculator.calculatePrimeFactorsOf(93819012551L));
    }

}
