import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PrimeCalculatorTest {
    private PrimeCalculator primeCalculator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        primeCalculator = new PrimeCalculator();
    }

    @Test
    public void testFirstPrime() {
        assertEquals(primeCalculator.nth(1), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondPrime() {
        assertEquals(primeCalculator.nth(2), 3);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSixthPrime() {
        assertEquals(primeCalculator.nth(6), 13);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBigPrime() {
        assertEquals(primeCalculator.nth(10001), 104743);
    }

    @Ignore("Remove to run test")
    @Test
    public void testUndefinedPrime() {
        expectedException.expect(IllegalArgumentException.class);
        primeCalculator.nth(0);
    }

}
