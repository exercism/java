import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockTest {

    @Test
    @DisplayName("Create a new clock with an initial time -> on the hour")
    public void createANewClockWithAnInitialTimeOnTheHour() {
        assertThat(new Clock(8, 0).toString()).isEqualTo("08:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> past the hour")
    public void createANewClockWithAnInitialTimePastTheHour() {
        assertThat(new Clock(11, 9).toString()).isEqualTo("11:09");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> midnight is zero hours")
    public void createANewClockWithAnInitialTimeMidnightIsZeroHours() {
        assertThat(new Clock(24, 0).toString()).isEqualTo("00:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> hour rolls over")
    public void createANewClockWithAnInitialTimeHourRollsOver() {
        assertThat(new Clock(25, 0).toString()).isEqualTo("01:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> hour rolls over continuously")
    public void createANewClockWithAnInitialTimeHourRollsOverContinuously() {
        assertThat(new Clock(100, 0).toString()).isEqualTo("04:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> sixty minutes is next hour")
    public void createANewClockWithAnInitialTimeSixtyMinutesIsNextHour() {
        assertThat(new Clock(1, 60).toString()).isEqualTo("02:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> minutes roll over")
    public void createANewClockWithAnInitialTimeMinutesRollOver() {
        assertThat(new Clock(0, 160).toString()).isEqualTo("02:40");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> minutes roll over continuously")
    public void createANewClockWithAnInitialTimeMinutesRollOverContinuously() {
        assertThat(new Clock(0, 1723).toString()).isEqualTo("04:43");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> hour and minutes roll over")
    public void createANewClockWithAnInitialTimeHourAndMinutesRollOver() {
        assertThat(new Clock(25, 160).toString()).isEqualTo("03:40");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> hour and minutes roll over continuously")
    public void createANewClockWithAnInitialTimeHourAndMinutesRollOverContinuousl() {
        assertThat(new Clock(201, 3001).toString()).isEqualTo("11:01");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> hour and minutes roll over "
            + "to exactly midnight")
    public void createANewClockWithAnInitialTimeHourAndMinutesRollOverToExactlyMi() {
        assertThat(new Clock(72, 8640).toString()).isEqualTo("00:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative hour")
    public void createANewClockWithAnInitialTimeNegativeHour() {
        assertThat(new Clock(-1, 15).toString()).isEqualTo("23:15");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative hour rolls over")
    public void createANewClockWithAnInitialTimeNegativeHourRollsOver() {
        assertThat(new Clock(-25, 0).toString()).isEqualTo("23:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative hour rolls over continuously")
    public void createANewClockWithAnInitialTimeNegativeHourRollsOverContinuously() {
        assertThat(new Clock(-91, 0).toString()).isEqualTo("05:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative minutes")
    public void createANewClockWithAnInitialTimeNegativeMinutes() {
        assertThat(new Clock(1, -40).toString()).isEqualTo("00:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative minutes roll over")
    public void createANewClockWithAnInitialTimeNegativeMinutesRollOver() {
        assertThat(new Clock(1, -160).toString()).isEqualTo("22:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative minutes roll over continuously")
    public void createANewClockWithAnInitialTimeNegativeMinutesRollOverContinuous() {
        assertThat(new Clock(1, -4820).toString()).isEqualTo("16:40");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative sixty minutes is previous hour")
    public void createANewClockWithAnInitialTimeNegativeSixtyMinutesIsPreviousHou() {
        assertThat(new Clock(2, -60).toString()).isEqualTo("01:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative hour and minutes both roll over")
    public void createANewClockWithAnInitialTimeNegativeHourAndMinutesBothRollOve() {
        assertThat(new Clock(-25, -160).toString()).isEqualTo("20:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create a new clock with an initial time -> negative hour and minutes "
            + "both roll over continuously")
    public void createANewClockWithAnInitialTimeNegativeHourAndMinutesBothRollOve2() {
        assertThat(new Clock(-121, -5810).toString()).isEqualTo("22:10");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add minutes")
    public void addMinutesAddMinutes() {
        Clock clock = new Clock(10, 0);
        clock.add(3);
        assertThat(clock.toString()).isEqualTo("10:03");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add no minutes")
    public void addMinutesAddNoMinutes() {
        Clock clock = new Clock(6, 41);
        clock.add(0);
        assertThat(clock.toString()).isEqualTo("06:41");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add to next hour")
    public void addMinutesAddToNextHour() {
        Clock clock = new Clock(0, 45);
        clock.add(40);
        assertThat(clock.toString()).isEqualTo("01:25");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add more than one hour")
    public void addMinutesAddMoreThanOneHour() {
        Clock clock = new Clock(10, 0);
        clock.add(61);
        assertThat(clock.toString()).isEqualTo("11:01");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add more than two hours with carry")
    public void addMinutesAddMoreThanTwoHoursWithCarry() {
        Clock clock = new Clock(0, 45);
        clock.add(160);
        assertThat(clock.toString()).isEqualTo("03:25");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add across midnight")
    public void addMinutesAddAcrossMidnight() {
        Clock clock = new Clock(23, 59);
        clock.add(2);
        assertThat(clock.toString()).isEqualTo("00:01");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add more than one day (1500 min = 25 hrs)")
    public void addMinutesAddMoreThanOneDay1500Min25Hrs() {
        Clock clock = new Clock(5, 32);
        clock.add(1500);
        assertThat(clock.toString()).isEqualTo("06:32");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add minutes -> add more than two days")
    public void addMinutesAddMoreThanTwoDays() {
        Clock clock = new Clock(1, 1);
        clock.add(3500);
        assertThat(clock.toString()).isEqualTo("11:21");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract minutes")
    public void subtractMinutesSubtractMinutes() {
        Clock clock = new Clock(10, 3);
        clock.add(-3);
        assertThat(clock.toString()).isEqualTo("10:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract to previous hour")
    public void subtractMinutesSubtractToPreviousHour() {
        Clock clock = new Clock(10, 3);
        clock.add(-30);
        assertThat(clock.toString()).isEqualTo("09:33");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract more than an hour")
    public void subtractMinutesSubtractMoreThanAnHour() {
        Clock clock = new Clock(10, 3);
        clock.add(-70);
        assertThat(clock.toString()).isEqualTo("08:53");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract across midnight")
    public void subtractMinutesSubtractAcrossMidnight() {
        Clock clock = new Clock(0, 3);
        clock.add(-4);
        assertThat(clock.toString()).isEqualTo("23:59");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract more than two hours")
    public void subtractMinutesSubtractMoreThanTwoHours() {
        Clock clock = new Clock(0, 0);
        clock.add(-160);
        assertThat(clock.toString()).isEqualTo("21:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract more than two hours with borrow")
    public void subtractMinutesSubtractMoreThanTwoHoursWithBorrow() {
        Clock clock = new Clock(6, 15);
        clock.add(-160);
        assertThat(clock.toString()).isEqualTo("03:35");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract more than one day (1500 min = 25 hrs)")
    public void subtractMinutesSubtractMoreThanOneDay1500Min25Hrs() {
        Clock clock = new Clock(5, 32);
        clock.add(-1500);
        assertThat(clock.toString()).isEqualTo("04:32");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract minutes -> subtract more than two days")
    public void subtractMinutesSubtractMoreThanTwoDays() {
        Clock clock = new Clock(2, 20);
        clock.add(-3000);
        assertThat(clock.toString()).isEqualTo("00:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with same time")
    public void compareTwoClocksForEqualityClocksWithSameTime() {
        Clock clock1 = new Clock(15, 37);
        Clock clock2 = new Clock(15, 37);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks a minute apart")
    public void compareTwoClocksForEqualityClocksAMinuteApart() {
        Clock clock1 = new Clock(15, 36);
        Clock clock2 = new Clock(15, 37);
        assertThat(clock1).isNotEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks an hour apart")
    public void compareTwoClocksForEqualityClocksAnHourApart() {
        Clock clock1 = new Clock(14, 37);
        Clock clock2 = new Clock(15, 37);
        assertThat(clock1).isNotEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with hour overflow")
    public void compareTwoClocksForEqualityClocksWithHourOverflow() {
        Clock clock1 = new Clock(10, 37);
        Clock clock2 = new Clock(34, 37);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with hour overflow by several days")
    public void compareTwoClocksForEqualityClocksWithHourOverflowBySeveralDays() {
        Clock clock1 = new Clock(3, 11);
        Clock clock2 = new Clock(99, 11);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative hour")
    public void compareTwoClocksForEqualityClocksWithNegativeHour() {
        Clock clock1 = new Clock(22, 40);
        Clock clock2 = new Clock(-2, 40);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative hour that wraps")
    public void compareTwoClocksForEqualityClocksWithNegativeHourThatWraps() {
        Clock clock1 = new Clock(17, 3);
        Clock clock2 = new Clock(-31, 3);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative hour that "
            + "wraps multiple times")
    public void compareTwoClocksForEqualityClocksWithNegativeHourThatWrapsMultipl() {
        Clock clock1 = new Clock(13, 49);
        Clock clock2 = new Clock(-83, 49);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with minute overflow")
    public void compareTwoClocksForEqualityClocksWithMinuteOverflow() {
        Clock clock1 = new Clock(0, 1);
        Clock clock2 = new Clock(0, 1441);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with minute overflow by several days")
    public void compareTwoClocksForEqualityClocksWithMinuteOverflowBySeveralDays() {
        Clock clock1 = new Clock(2, 2);
        Clock clock2 = new Clock(2, 4322);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative minute")
    public void compareTwoClocksForEqualityClocksWithNegativeMinute() {
        Clock clock1 = new Clock(2, 40);
        Clock clock2 = new Clock(3, -20);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative minute that wraps")
    public void compareTwoClocksForEqualityClocksWithNegativeMinuteThatWraps() {
        Clock clock1 = new Clock(4, 10);
        Clock clock2 = new Clock(5, -1490);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative minute that "
            + "wraps multiple times")
    public void compareTwoClocksForEqualityClocksWithNegativeMinuteThatWrapsMulti() {
        Clock clock1 = new Clock(6, 15);
        Clock clock2 = new Clock(6, -4305);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative hours and minutes")
    public void compareTwoClocksForEqualityClocksWithNegativeHoursAndMinutes() {
        Clock clock1 = new Clock(7, 32);
        Clock clock2 = new Clock(-12, -268);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> clocks with negative hours and minutes that wrap")
    public void compareTwoClocksForEqualityClocksWithNegativeHoursAndMinutesThatW() {
        Clock clock1 = new Clock(18, 7);
        Clock clock2 = new Clock(-54, -11513);
        assertThat(clock1).isEqualTo(clock2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Compare two clocks for equality -> full clock and zeroed clock")
    public void compareTwoClocksForEqualityFullClockAndZeroedClock() {
        Clock clock1 = new Clock(24, 0);
        Clock clock2 = new Clock(0, 0);
        assertThat(clock1).isEqualTo(clock2);
    }

}
