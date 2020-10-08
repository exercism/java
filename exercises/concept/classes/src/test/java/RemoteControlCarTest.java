import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class RemoteControlCarTest {
    @Test
    public void buy_new_car_returns_instance() {
        RemoteControlCar car = RemoteControlCar.buy();
        assertThat(car).isNotNull();
    }

    @Ignore("Remove to run test")
    @Test
    public void buy_new_car_returns_new_car_each_time() {
        RemoteControlCar car1 = RemoteControlCar.buy();
        RemoteControlCar car2 = RemoteControlCar.buy();
        assertThat(car1).isNotEqualTo(car2);
    }

    @Ignore("Remove to run test")
    @Test
    public void new_car_distance_display() {
        RemoteControlCar car = new RemoteControlCar();
        assertThat(car.distanceDisplay()).isEqualTo("Driven 0 meters");
    }

    @Ignore("Remove to run test")
    @Test
    public void new_car_battery_display() {
        RemoteControlCar car = new RemoteControlCar();
        assertThat(car.batteryDisplay()).isEqualTo("Battery at 100%");
    }

    @Ignore("Remove to run test")
    @Test
    public void distance_display_after_driving_once() {
        RemoteControlCar car = new RemoteControlCar();
        car.drive();
        assertThat(car.distanceDisplay()).isEqualTo("Driven 20 meters");
    }

    @Ignore("Remove to run test")
    @Test
    public void distance_display_after_driving_multiple_times() {
        RemoteControlCar car = new RemoteControlCar();

        for (int i = 0; i < 17; i++) {
            car.drive();
        }

        assertThat(car.distanceDisplay()).isEqualTo("Driven 340 meters");
    }

    @Ignore("Remove to run test")
    @Test
    public void battery_display_after_driving_once() {
        RemoteControlCar car = new RemoteControlCar();
        car.drive();
        
        assertThat(car.batteryDisplay()).isEqualTo("Battery at 99%");
    }

    @Ignore("Remove to run test")
    @Test
    public void battery_display_after_driving_multiple_times() {
        RemoteControlCar car = new RemoteControlCar();

        for (int i = 0; i < 23; i++) {
            car.drive();
        }

        assertThat(car.batteryDisplay()).isEqualTo("Battery at 77%");
    }

    @Ignore("Remove to run test")
    @Test
    public void battery_display_when_battery_empty() {
        RemoteControlCar car = new RemoteControlCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        assertThat(car.batteryDisplay()).isEqualTo("Battery empty");
    }

    @Ignore("Remove to run test")
    @Test
    public void distance_display_when_battery_empty() {
        RemoteControlCar car = new RemoteControlCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        assertThat(car.distanceDisplay()).isEqualTo("Driven 2000 meters");
    }
}
