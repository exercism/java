class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distance = 0;
    private int battery = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public boolean batteryDrained() {
        return battery < batteryDrain;
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (!batteryDrained()) {
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

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (car.distanceDriven() < distance) {
            if (car.batteryDrained()) {
                return false;
            }

            car.drive();
        }

        return true;
    }
}
