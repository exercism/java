import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RemoteControlCarTest {
    @Test
    public void Buy_new_car_returns_instance() {
        RemoteControlCar car = RemoteControlCar.buy();
        Assert.assertNotNull(car);
    }

    @Ignore("Remove to run test")
    @Test
    public void Buy_new_car_returns_new_car_each_time() {
        RemoteControlCar car1 = RemoteControlCar.buy();
        RemoteControlCar car2 = RemoteControlCar.buy();
        Assert.assertNotSame(car2, car1);
    }

    @Ignore("Remove to run test")
    @Test
    public void New_car_distance_display() {
        RemoteControlCar car = new RemoteControlCar();
        Assert.assertEquals("Driven 0 meters", car.distanceDisplay());
    }

    @Ignore("Remove to run test")
    @Test
    public void New_car_battery_display() {
        RemoteControlCar car = new RemoteControlCar();
        Assert.assertEquals("Battery at 100%", car.batteryDisplay());
    }

    @Ignore("Remove to run test")
    @Test
    public void Distance_display_after_driving_once() {
        RemoteControlCar car = new RemoteControlCar();
        car.drive();
        Assert.assertEquals("Driven 20 meters", car.distanceDisplay());
    }

    @Ignore("Remove to run test")
    @Test
    public void Distance_display_after_driving_multiple_times() {
        RemoteControlCar car = new RemoteControlCar();

        for (int i = 0; i < 17; i++) {
            car.drive();
        }

        Assert.assertEquals("Driven 340 meters", car.distanceDisplay());
    }

    @Ignore("Remove to run test")
    @Test
    public void Battery_display_after_driving_once() {
        RemoteControlCar car = new RemoteControlCar();
        car.drive();
        Assert.assertEquals("Battery at 99%", car.batteryDisplay());
    }

    @Ignore("Remove to run test")
    @Test
    public void Battery_display_after_driving_multiple_times() {
        RemoteControlCar car = new RemoteControlCar();

        for (int i = 0; i < 23; i++) {
            car.drive();
        }

        Assert.assertEquals("Battery at 77%", car.batteryDisplay());
    }

    @Ignore("Remove to run test")
    @Test
    public void Battery_display_when_battery_empty() {
        RemoteControlCar car = new RemoteControlCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        Assert.assertEquals("Battery empty", car.batteryDisplay());
    }

    @Ignore("Remove to run test")
    @Test
    public void Distance_display_when_battery_empty() {
        RemoteControlCar car = new RemoteControlCar();

        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }

        // Attempt to drive one more time (should not work)
        car.drive();

        Assert.assertEquals("Driven 2000 meters", car.distanceDisplay());
    }
}
