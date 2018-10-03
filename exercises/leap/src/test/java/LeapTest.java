import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeapTest {

    // Tests adapted from `problem-specifications//canonical-data.json` @ v1.3.0

    @Test
    public void testYearNotDivisibleBy4() {
        boolean expected = false;
        assertEquals(expected, new Leap(2015).isLeapYear());
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivisibleBy4NotDivisibleBy100() {
        boolean expected = true;
        assertEquals(expected, new Leap(1996).isLeapYear());
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivisibleBy100NotDivisibleBy400() {
        boolean expected = false;
        assertEquals(expected, new Leap(2100).isLeapYear());
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivisibleBy400() {
        boolean expected = true;
        assertEquals(expected, new Leap(2000).isLeapYear());
    }

}