public class ElonsToyCar {

    private int distance;
    private int battery = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distance);
    }

    public String batteryDisplay() {
        if (batteryEmpty()) {
            return String.format("Battery empty");
        }
        return String.format("Battery at %d%%", battery);
    }

    public boolean batteryEmpty() {
        return battery<=0;
    }

    public void drive() {
        if (!batteryEmpty()) {
            distance += 20;
            battery--;
        }
    }
}
