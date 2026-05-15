import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockEqualTest {

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with same time")
    public void clocksWithSameTimeAreEqual() {
        assertThat(new Clock(15, 37))
                .isEqualTo(new Clock(15, 37));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks a minute apart")
    public void clocksAMinuteApartAreNotEqual() {
        assertThat(new Clock(15, 36))
                .isNotEqualTo(new Clock(15, 37));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks an hour apart")
    public void clocksAnHourApartAreNotEqual() {
        assertThat(new Clock(14, 37))
                .isNotEqualTo(new Clock(15, 37));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with hour overflow")
    public void clocksWithHourOverflow() {
        assertThat(new Clock(34, 37))
                .isEqualTo(new Clock(10, 37));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with hour overflow by several days")
    public void clocksWithHourOverflowBySeveralDays() {
        assertThat(new Clock(99, 11))
                .isEqualTo(new Clock(3, 11));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative hour")
    public void clocksWithNegateHour() {
        assertThat(new Clock(-2, 40))
                .isEqualTo(new Clock(22, 40));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative hour that wraps")
    public void clocksWithNegativeHourThatWraps() {
        assertThat(new Clock(-31, 3))
                .isEqualTo(new Clock(17, 3));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative hour that wraps multiple times")
    public void clocksWithNegativeHourThatWrapsMultipleTimes() {
        assertThat(new Clock(-83, 49))
                .isEqualTo(new Clock(13, 49));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with minute overflow")
    public void clocksWithMinuteOverflow() {
        assertThat(new Clock(0, 1441))
                .isEqualTo(new Clock(0, 1));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with minute overflow by several days")
    public void clocksWithMinuteOverflowBySeveralDays() {
        assertThat(new Clock(2, 4322))
                .isEqualTo(new Clock(2, 2));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative minute")
    public void clocksWithNegativeMinutes() {
        assertThat(new Clock(3, -20))
                .isEqualTo(new Clock(2, 40));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative minute that wraps")
    public void clocksWithNegativeMinutesThatWraps() {
        assertThat(new Clock(5, -1490))
                .isEqualTo(new Clock(4, 10));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative minute that wraps multiple times")
    public void clocksWithNegativeMinutesThatWrapsMultipleTimes() {
        assertThat(new Clock(6, -4305))
                .isEqualTo(new Clock(6, 15));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative hours and minutes")
    public void clocksWithNegativeHoursAndMinutes() {
        assertThat(new Clock(-12, -268))
                .isEqualTo(new Clock(7, 32));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clocks with negative hours and minutes that wrap")
    public void clocksWithNegativeHoursAndMinutesThatWrap() {
        assertThat(new Clock(-54, -11513))
                .isEqualTo(new Clock(18, 7));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("full clock and zeroed clock")
    public void clocksWithFullClockAndZeroedClockAreEqual() {
        assertThat(new Clock(24, 0))
                .isEqualTo(new Clock(0, 0));
    }

}
