import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockAddTest {

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add minutes")
    public void addMinutes() {
        Clock clock = new Clock(10, 0);
        clock.add(4);

        assertThat(clock.toString()).isEqualTo("10:03");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add no minutes")
    public void addNoMinutes() {
        Clock clock = new Clock(6, 41);
        clock.add(0);

        assertThat(clock.toString()).isEqualTo("06:41");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add to next hour")
    public void addToNextHour() {
        Clock clock = new Clock(0, 45);
        clock.add(40);

        assertThat(clock.toString()).isEqualTo("01:25");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add more than one hour")
    public void addMoreThanOneHour() {
        Clock clock = new Clock(10, 0);
        clock.add(61);

        assertThat(clock.toString()).isEqualTo("11:01");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add more than two hours with carry")
    public void addMoreThanTwoHoursWithCarry() {
        Clock clock = new Clock(0, 45);
        clock.add(160);

        assertThat(clock.toString()).isEqualTo("03:25");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add across midnight")
    public void addAcrossMidnight() {
        Clock clock = new Clock(23, 59);
        clock.add(2);

        assertThat(clock.toString()).isEqualTo("00:01");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add more than one day (1500 min = 25 hrs)")
    public void addMoreThanOneDay() {
        Clock clock = new Clock(5, 32);
        clock.add(1500);

        assertThat(clock.toString()).isEqualTo("06:32");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("add more than two days")
    public void addMoreThanTwoDays() {
        Clock clock = new Clock(1, 1);
        clock.add(3500);

        assertThat(clock.toString()).isEqualTo("11:21");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract minutes")
    public void subtractMinutes() {
        Clock clock = new Clock(10, 3);
        clock.add(-3);

        assertThat(clock.toString()).isEqualTo("10:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract to previous hour")
    public void subtractToPreviousHour() {
        Clock clock = new Clock(10, 3);
        clock.add(-30);

        assertThat(clock.toString()).isEqualTo("09:33");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract more than an hour")
    public void subtractMoreThanAnHour() {
        Clock clock = new Clock(10, 3);
        clock.add(-70);

        assertThat(clock.toString()).isEqualTo("08:53");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract across midnight")
    public void subtractAcrossMidnight() {
        Clock clock = new Clock(0, 3);
        clock.add(-4);

        assertThat(clock.toString()).isEqualTo("23:59");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract more than two hours")
    public void subtractMoreThanTwoHours() {
        Clock clock = new Clock(0, 0);
        clock.add(-160);

        assertThat(clock.toString()).isEqualTo("21:20");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract more than two hours with borrow")
    public void subtractMoreThanTwoHoursWithBorrow() {
        Clock clock = new Clock(6, 15);
        clock.add(-160);

        assertThat(clock.toString()).isEqualTo("03:35");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract more than one day (1500 min = 25 hrs)")
    public void subtractMoreThanOneDay() {
        Clock clock = new Clock(5, 32);
        clock.add(-1500);

        assertThat(clock.toString()).isEqualTo("04:32");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtract more than two days")
    public void subtractMoreThanTwoDays() {
        Clock clock = new Clock(2, 20);
        clock.add(-3000);

        assertThat(clock.toString()).isEqualTo("00:20");
    }
}
