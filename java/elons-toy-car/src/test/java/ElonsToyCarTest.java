import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ElonsToyCarTest {
    @Test
    public void buy_new_car_returns_instance() {
        ElonsToyCar car = ElonsToyCar.buy();
        assertThat(car).isNotNull();
    }

    @Test
    public void buy_new_car_returns_new_car_each_time() {
        ElonsToyCar car1 = ElonsToyCar.buy();
        ElonsToyCar car2 = ElonsToyCar.buy();
        assertThat(car1).isNotEqualTo(car2);
    }

    @Test
    public void new_car_distance_display() {
        ElonsToyCar car = new ElonsToyCar();
        assertThat(car.distanceDisplay()).isEqualTo("Driven 0 meters");
    }

    @Test
    public void new_car_battery_display() {
        ElonsToyCar car = new ElonsToyCar();
        assertThat(car.batteryDisplay()).isEqualTo("Battery at 100%");
    }

    @Test
    public void distance_display_after_driving_once() {
        ElonsToyCar car = new ElonsToyCar();
        car.drive();
        assertThat(car.distanceDisplay()).isEqualTo("Driven 20 meters");
    }

    @Test
    public void distance_display_after_driving_multiple_times() {
        ElonsToyCar car = new ElonsToyCar();

        for (int i = 0; i < 17; i++) {
            car.drive();
        }

        assertThat(car.distanceDisplay()).isEqualTo("Driven 340 meters");
    }

    @Test
    public void battery_display_after_driving_once() {
        ElonsToyCar car = new ElonsToyCar();
        car.drive();
        
        assertThat(car.batteryDisplay()).isEqualTo("Battery at 99%");
    }

    @Test
    public void battery_display_after_driving_multiple_times() {
        ElonsToyCar car = new ElonsToyCar();

        for (int i = 0; i < 23; i++) {
            car.drive();
        }

        assertThat(car.batteryDisplay()).isEqualTo("Battery at 77%");
    }

    @Test
    public void battery_display_when_battery_empty() {
        ElonsToyCar car = new ElonsToyCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        assertThat(car.batteryDisplay()).isEqualTo("Battery empty");
    }

    @Test
    public void distance_display_when_battery_empty() {
        ElonsToyCar car = new ElonsToyCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        assertThat(car.distanceDisplay()).isEqualTo("Driven 2000 meters");
    }
}
