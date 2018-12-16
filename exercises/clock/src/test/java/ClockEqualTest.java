import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class ClockEqualTest {

    @Ignore("Remove to run test")
    @Test
    public void clocksWithSameTimeAreEqual() {
        assertEquals(new Clock(15, 37), new Clock(15, 37));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksAMinuteApartAreNotEqual() {
        assertNotEquals(new Clock(15, 36), new Clock(15, 37));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksAnHourApartAreNotEqual() {
        assertNotEquals(new Clock(14, 37), new Clock(15, 37));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithHourOverflow() {
        assertEquals(new Clock(10, 37), new Clock(34, 37));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithHourOverflowBySeveralDays() {
        assertEquals(new Clock(3, 11), new Clock(99, 11));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegateHour() {
        assertEquals(new Clock(22, 40), new Clock(-2, 40));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegativeHourThatWraps() {
        assertEquals(new Clock(17, 3), new Clock(-31, 3));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegativeHourThatWrapsMultipleTimes() {
        assertEquals(new Clock(13, 49), new Clock(-83, 49));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithMinuteOverflow() {
        assertEquals(new Clock(0, 1), new Clock(0, 1441));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithMinuteOverflowBySeveralDays() {
        assertEquals(new Clock(2, 2), new Clock(2, 4322));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegativeMinutes() {
        assertEquals(new Clock(2, 40), new Clock(3, -20));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegativeMinutesThatWraps() {
        assertEquals(new Clock(4, 10), new Clock(5, -1490));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegativeMinutesThatWrapsMultipleTimes() {
        assertEquals(new Clock(6, 15), new Clock(6, -4305));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegativeHoursAndMinutes() {
        assertEquals(new Clock(7, 32), new Clock(-12, -268));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithNegativeHoursAndMinutesThatWrap() {
        assertEquals(new Clock(18, 7), new Clock(-54, -11513));
    }

    @Ignore("Remove to run test")
    @Test
    public void clocksWithFullClockAndZeroedClockAreEqual() {
        assertEquals(new Clock(24, 0), new Clock(0, 0));
    }

}
