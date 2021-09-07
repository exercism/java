import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockAddTest {

    @Ignore("Remove to run test")
    @Test
    public void addMinutes() {
        Clock clock = new Clock(10, 0);
        clock.add(3);

        assertThat(clock.toString()).isEqualTo("10:03");
    }

    @Ignore("Remove to run test")
    @Test
    public void addNoMinutes() {
        Clock clock = new Clock(6, 41);
        clock.add(0);

        assertThat(clock.toString()).isEqualTo("06:41");
    }

    @Ignore("Remove to run test")
    @Test
    public void addToNextHour() {
        Clock clock = new Clock(0, 45);
        clock.add(40);

        assertThat(clock.toString()).isEqualTo("01:25");
    }

    @Ignore("Remove to run test")
    @Test
    public void addMoreThanOneHour() {
        Clock clock = new Clock(10, 0);
        clock.add(61);

        assertThat(clock.toString()).isEqualTo("11:01");
    }

    @Ignore("Remove to run test")
    @Test
    public void addMoreThanTwoHoursWithCarry() {
        Clock clock = new Clock(0, 45);
        clock.add(160);

        assertThat(clock.toString()).isEqualTo("03:25");
    }

    @Ignore("Remove to run test")
    @Test
    public void addAcrossMidnight() {
        Clock clock = new Clock(23, 59);
        clock.add(2);

        assertThat(clock.toString()).isEqualTo("00:01");
    }

    @Ignore("Remove to run test")
    @Test
    public void addMoreThanOneDay() {
        Clock clock = new Clock(5, 32);
        clock.add(1500);

        assertThat(clock.toString()).isEqualTo("06:32");
    }

    @Ignore("Remove to run test")
    @Test
    public void addMoreThanTwoDays() {
        Clock clock = new Clock(1, 1);
        clock.add(3500);

        assertThat(clock.toString()).isEqualTo("11:21");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractMinutes() {
        Clock clock = new Clock(10, 3);
        clock.add(-3);

        assertThat(clock.toString()).isEqualTo("10:00");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractToPreviousHour() {
        Clock clock = new Clock(10, 3);
        clock.add(-30);

        assertThat(clock.toString()).isEqualTo("09:33");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractMoreThanAnHour() {
        Clock clock = new Clock(10, 3);
        clock.add(-70);

        assertThat(clock.toString()).isEqualTo("08:53");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractAcrossMidnight() {
        Clock clock = new Clock(0, 3);
        clock.add(-4);

        assertThat(clock.toString()).isEqualTo("23:59");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractMoreThanTwoHours() {
        Clock clock = new Clock(0, 0);
        clock.add(-160);

        assertThat(clock.toString()).isEqualTo("21:20");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractMoreThanTwoHoursWithBorrow() {
        Clock clock = new Clock(6, 15);
        clock.add(-160);

        assertThat(clock.toString()).isEqualTo("03:35");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractMoreThanOneDay() {
        Clock clock = new Clock(5, 32);
        clock.add(-1500);

        assertThat(clock.toString()).isEqualTo("04:32");
    }

    @Ignore("Remove to run test")
    @Test
    public void subtractMoreThanTwoDays() {
        Clock clock = new Clock(2, 20);
        clock.add(-3000);

        assertThat(clock.toString()).isEqualTo("00:20");
    }
}
