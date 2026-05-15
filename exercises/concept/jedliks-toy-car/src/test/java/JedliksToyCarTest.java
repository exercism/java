import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JedliksToyCarTest {
    @Test
    @Tag("task:1")
    @DisplayName("The static buy method returns a new remote controlled car instance")
    public void buyNewCarReturnsInstance() {
        JedliksToyCar car = JedliksToyCar.buy();
        assertThat(car).isNotNull();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The static buy method returns each time a new remote controlled car instance")
    public void buyNewCarReturnsNewCarEachTime() {
        JedliksToyCar car1 = JedliksToyCar.buy();
        JedliksToyCar car2 = JedliksToyCar.buy();
        assertThat(car1).isNotEqualTo(car2);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The distanceDisplay method shows 0 meters message on a new car")
    public void newCarDistanceDisplay() {
        JedliksToyCar car = new JedliksToyCar();
        assertThat(car.distanceDisplay()).isEqualTo("Driven 0 meters");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The batteryDisplay method shows full battery message on a new car")
    public void newCarBatteryDisplay() {
        JedliksToyCar car = new JedliksToyCar();
        assertThat(car.batteryDisplay()).isEqualTo("Battery at 100%");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The distanceDisplay method shows the correct message after driving once")
    public void distanceDisplayAfterDrivingOnce() {
        JedliksToyCar car = new JedliksToyCar();
        car.drive();
        assertThat(car.distanceDisplay()).isEqualTo("Driven 20 meters");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The distanceDisplay method shows the correct message after driving multiple times")
    public void distanceDisplayAfterDrivingMultipleTimes() {
        JedliksToyCar car = new JedliksToyCar();

        for (int i = 0; i < 17; i++) {
            car.drive();
        }

        assertThat(car.distanceDisplay()).isEqualTo("Driven 340 meters");
    }

    @Test
    @Tag("task:5")
    @DisplayName("The batteryDisplay method shows the correct message after driving once")
    public void batteryDisplayAfterDrivingOnce() {
        JedliksToyCar car = new JedliksToyCar();
        car.drive();
        
        assertThat(car.batteryDisplay()).isEqualTo("Battery at 99%");
    }

    @Test
    @Tag("task:5")
    @DisplayName("The batteryDisplay method shows the correct battery percentage after driving multiple times")
    public void batteryDisplayAfterDrivingMultipleTimes() {
        JedliksToyCar car = new JedliksToyCar();

        for (int i = 0; i < 23; i++) {
            car.drive();
        }

        assertThat(car.batteryDisplay()).isEqualTo("Battery at 77%");
    }

    @Test
    @Tag("task:5")
    @DisplayName("The batteryDisplay method shows battery empty after draining all battery")
    public void batteryDisplayWhenBatteryEmpty() {
        JedliksToyCar car = new JedliksToyCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        assertThat(car.batteryDisplay()).isEqualTo("Battery empty");
    }

    @Test
    @Tag("task:6")
    @DisplayName("The distanceDisplay method shows the correct message after driving and draining all battery")
    public void distanceDisplayWhenBatteryEmpty() {
        JedliksToyCar car = new JedliksToyCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        assertThat(car.distanceDisplay()).isEqualTo("Driven 2000 meters");
    }
}
