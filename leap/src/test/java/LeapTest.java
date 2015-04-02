import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeapTest {

    @Test
    public void leapYear() {
        assertEquals(
                Year.isLeap(1996),
                true
        );
    }

    @Test
    public void nonLeapYear() {
        assertEquals(
                Year.isLeap(1997),
                false
        );
    }

    @Test
    public void nonLeapEvenYear() {
        assertEquals(
                Year.isLeap(1998),
                false
        );
    }

    @Test
    public void century() {
        assertEquals(
                Year.isLeap(1900),
                false
        );
    }

    @Test
    public void fourthCentury() {
        assertEquals(
                Year.isLeap(2400),
                true
        );
    }

    @Test
    public void year2000() {
        assertEquals(
                Year.isLeap(2000),
                true
        );
    }
}
