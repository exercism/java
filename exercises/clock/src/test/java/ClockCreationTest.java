import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClockCreationTest {

    @Test
    public void canPrintTimeOnTheHour() {
        assertEquals("08:00", new Clock(8, 0).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void canPrintTimeWithMinutes() {
        assertEquals("11:09", new Clock(11, 9).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void midnightPrintsAsZero() {
        assertEquals("00:00", new Clock(24, 0).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void hourRollsOver() {
        assertEquals("01:00", new Clock(25, 0).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void hourRollsOverContinuously() {
        assertEquals("04:00", new Clock(100, 0).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void sixtyMinutesIsNextHour() {
        assertEquals("02:00", new Clock(1, 60).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void minutesRollOver() {
        assertEquals("02:40", new Clock(0, 160).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void minutesRollOverContinuously() {
        assertEquals("04:43", new Clock(0, 1723).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void hourAndMinutesRollOver() {
        assertEquals("03:40", new Clock(25, 160).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void hourAndMinutesRollOverContinuously() {
        assertEquals("11:01", new Clock(201, 3001).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void hourAndMinutesRollOverToExactlyMidnight() {
        assertEquals("00:00", new Clock(72, 8640).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeHour() {
        assertEquals("23:15", new Clock(-1, 15).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeHourRollsOver() {
        assertEquals("23:00", new Clock(-25, 0).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeHourRollsOverContinuously() {
        assertEquals("05:00", new Clock(-91, 0).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeMinutes() {
        assertEquals("00:20", new Clock(1, -40).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeMinutesRollOver() {
        assertEquals("22:20", new Clock(1, -160).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeMinutesRollOverContinuously() {
        assertEquals("16:40", new Clock(1, -4820).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeSixtyMinutesIsPreviousHour() {
        assertEquals("01:00", new Clock(2, -60).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeHourAndMinutesBothRollOver() {
        assertEquals("20:20", new Clock(-25, -160).toString());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativeHourAndMinutesBothRollOverContinuously() {
        assertEquals("22:10", new Clock(-121, -5810).toString());
    }
}
