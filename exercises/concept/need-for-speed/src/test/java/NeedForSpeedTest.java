import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NeedForSpeedTest {
    @Test
    public void new_remote_control_car_has_not_driven_any_distance() {
        int speed = 10;
        int batteryDrain = 2;
        var car = new NeedForSpeed(speed, batteryDrain);

        assertThat(car.distanceDriven()).isEqualTo(0);
    }

    @Test
    public void drive_increases_distance_driven_with_speed() {
        int speed = 5;
        int batteryDrain = 1;
        var car = new NeedForSpeed(speed, batteryDrain);

        car.drive();

        assertThat(car.distanceDriven()).isEqualTo(5);
    }

    @Test
    public void drive_does_not_increase_distance_driven_when_battery_drained() {
        int speed = 9;
        int batteryDrain = 50;
        var car = new NeedForSpeed(speed, batteryDrain);

        // Drain the battery
        car.drive();
        car.drive();

        // One extra drive attempt (should not succeed)
        car.drive();

        assertThat(car.distanceDriven()).isEqualTo(18);
    }

    @Test
    public void new_remote_control_car_battery_is_not_drained() {
        int speed = 15;
        int batteryDrain = 3;
        var car = new NeedForSpeed(speed, batteryDrain);

        assertThat(car.batteryDrained()).isFalse();
    }

    @Test
    public void drive_to_almost_drain_battery() {
        int speed = 2;
        int batteryDrain = 1;
        var car = new NeedForSpeed(speed, batteryDrain);

        // Almost drain the battery
        for (var i = 0; i < 99; i++) {
            car.drive();
        }

        assertThat(car.batteryDrained()).isFalse();
    }

    @Test
    public void drive_until_battery_is_drained() {
        int speed = 2;
        int batteryDrain = 1;
        var car = new NeedForSpeed(speed, batteryDrain);

        // Drain the battery
        for (var i = 0; i < 100; i++) {
            car.drive();
        }

        assertThat(car.batteryDrained()).isTrue();
    }

    @Test
    public void nitro_car_has_not_driven_any_distance() {
        var car = NeedForSpeed.nitro();
        assertThat(car.distanceDriven()).isEqualTo(0);
    }

    @Test
    public void nitro_car_has_battery_not_drained() {
        var car = NeedForSpeed.nitro();
        assertThat(car.batteryDrained()).isFalse();
    }

    @Test
    public void nitro_car_has_correct_speed() {
        var car = NeedForSpeed.nitro();
        car.drive();
        assertThat(car.distanceDriven()).isEqualTo(50);
    }

    @Test
    public void nitro_has_correct_battery_drain() {
        var car = NeedForSpeed.nitro();

        // The battery is almost drained
        for (var i = 0; i < 24; i++) {
            car.drive();
        }

        assertThat(car.batteryDrained()).isFalse();

        // Drain the battery
        car.drive();

        assertThat(car.batteryDrained()).isTrue();
    }

    @Test
    public void car_can_finish_with_car_that_can_easily_finish() {
        int speed = 10;
        int batteryDrain = 2;
        var car = new NeedForSpeed(speed, batteryDrain);

        int distance = 100;
        var race = new RaceTrack(distance);

        assertThat(race.tryFinishTrack(car)).isTrue();
    }

    @Test
    public void car_can_finish_with_car_that_can_just_finish() {
        int speed = 2;
        int batteryDrain = 10;
        var car = new NeedForSpeed(speed, batteryDrain);

        int distance = 20;
        var race = new RaceTrack(distance);

        assertThat(race.tryFinishTrack(car)).isTrue();
    }

    @Test
    public void car_can_finish_with_car_that_just_cannot_finish() {
        int speed = 3;
        int batteryDrain = 20;
        var car = new NeedForSpeed(speed, batteryDrain);

        int distance = 16;
        var race = new RaceTrack(distance);

        assertThat(race.tryFinishTrack(car)).isFalse();
    }

    @Test
    public void car_can_finish_with_car_that_cannot_finish() {
        int speed = 1;
        int batteryDrain = 20;
        var car = new NeedForSpeed(speed, batteryDrain);

        int distance = 678;
        var race = new RaceTrack(distance);

        assertThat(race.tryFinishTrack(car)).isFalse();
    }
}

