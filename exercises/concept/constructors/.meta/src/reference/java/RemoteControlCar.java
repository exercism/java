class RemoteControlCar {
    private int speed;
    private int batteryDrain;
    private int distance = 0;
    private int battery = 100;

    public RemoteControlCar(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public static RemoteControlCar nitro() {
        return new RemoteControlCar(50, 4);
    }

    public boolean batteryDrained() {
        return battery == 0;
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (battery > 0) {
            battery -= batteryDrain;
            distance += speed;
        }
    }
}

class RaceTrack {
    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean carCanFinish(RemoteControlCar car) {
        while (!car.batteryDrained()) {
            car.drive();
        }
        return car.distanceDriven() >= this.distance;
    }
}
