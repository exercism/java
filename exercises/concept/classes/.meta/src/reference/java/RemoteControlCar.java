class RemoteControlCar {
    private int batteryPercentage = 100;
    private int distanceDrivenInMeters = 0;

    public void drive() {
        if (batteryPercentage > 0) {
            batteryPercentage--;
            distanceDrivenInMeters += 20;
        }
    }

    public String distanceDisplay() {
        return "Driven " + distanceDrivenInMeters + " meters";
    }

    public String batteryDisplay() {
        if (batteryPercentage == 0) {
            return "Battery empty";
        }

        return "Battery at " + batteryPercentage + "%";
    }

    public static RemoteControlCar buy() {
        return new RemoteControlCar();
    }
}
