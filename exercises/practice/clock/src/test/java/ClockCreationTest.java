import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockCreationTest {

    @Test
    @DisplayName("on the hour")
    public void canPrintTimeOnTheHour() {
        assertThat(new Clock(8, 0).toString()).isEqualTo("08:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("past the hour")
    public void canPrintTimeWithMinutes() {
        assertThat(new Clock(11, 9).toString()).isEqualTo("11:09");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("midnight is zero hours")
    public void midnightPrintsAsZero() {
        assertThat(new Clock(24, 0).toString()).isEqualTo("00:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("hour rolls over")
    public void hourRollsOver() {
        assertThat(new Clock(25, 0).toString()).isEqualTo("01:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("hour rolls over continuously")
    public void hourRollsOverContinuously() {
        assertThat(new Clock(100, 0).toString()).isEqualTo("04:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sixty minutes is next hour")
    public void sixtyMinutesIsNextHour() {
        assertThat(new Clock(1, 60).toString()).isEqualTo("02:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("minutes roll over")
    public void minutesRollOver() {
        assertThat(new Clock(0, 160).toString()).isEqualTo("02:40");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("minutes roll over continuously")
    public void minutesRollOverContinuously() {
        assertThat(new Clock(0, 1723).toString()).isEqualTo("04:43");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("hour and minutes roll over")
    public void hourAndMinutesRollOver() {
        assertThat(new Clock(25, 160).toString()).isEqualTo("03:40");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("hour and minutes roll over continuously")
    public void hourAndMinutesRollOverContinuously() {
        assertThat(new Clock(201, 3001).toString()).isEqualTo("11:01");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("hour and minutes roll over to exactly midnight")
    public void hourAndMinutesRollOverToExactlyMidnight() {
        assertThat(new Clock(72, 8640).toString()).isEqualTo("00:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative hour")
    public void negativeHour() {
        assertThat(new Clock(-1, 15).toString()).isEqualTo("23:15");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative hour rolls over")
    public void negativeHourRollsOver() {
        assertThat(new Clock(-25, 0).toString()).isEqualTo("23:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative hour rolls over continuously")
    public void negativeHourRollsOverContinuously() {
        assertThat(new Clock(-91, 0).toString()).isEqualTo("05:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative minutes")
    public void negativeMinutes() {
        assertThat(new Clock(1, -40).toString()).isEqualTo("00:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative minutes roll over")
    public void negativeMinutesRollOver() {
        assertThat(new Clock(1, -160).toString()).isEqualTo("22:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative minutes roll over continuously")
    public void negativeMinutesRollOverContinuously() {
        assertThat(new Clock(1, -4820).toString()).isEqualTo("16:40");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative sixty minutes is previous hour")
    public void negativeSixtyMinutesIsPreviousHour() {
        assertThat(new Clock(2, -60).toString()).isEqualTo("01:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative hour and minutes both roll over")
    public void negativeHourAndMinutesBothRollOver() {
        assertThat(new Clock(-25, -160).toString()).isEqualTo("20:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative hour and minutes both roll over continuously")
    public void negativeHourAndMinutesBothRollOverContinuously() {
        assertThat(new Clock(-121, -5810).toString()).isEqualTo("22:10");
    }
}
