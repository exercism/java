public class JedliksToyCar {
    private int distance=0;
    private int battery=100;

    public static JedliksToyCar buy() {
        //    throw new UnsupportedOperationException("Please implement the (static) JedliksToyCar.buy()  method");
        JedliksToyCar car = new JedliksToyCar();
        return car;
    }

    public String distanceDisplay() {
        //  throw new UnsupportedOperationException("Please implement the JedliksToyCar.distanceDisplay()  method");


        String carDistanceDisplay = null;
        if (this.distance <= 2000) {
            carDistanceDisplay = "Driven " + this.distance + " meters";
        }
        else if(this.distance > 2000) {
            carDistanceDisplay = "Driven 2000 meters";
        }

            return carDistanceDisplay;
    }

    public String batteryDisplay() {
      //  throw new UnsupportedOperationException("Please implement the JedliksToyCar.batteryDisplay()  method");
        String carBatteryDisplay = null;
        if (this.battery <= 100 && this.battery >= 1) {
            carBatteryDisplay = "Battery at "+ this.battery +"%";
        }
        else if(this.battery <= 0) {
            carBatteryDisplay = "Battery empty";
        }
        return carBatteryDisplay;
    }

    public void drive() {
        //   throw new UnsupportedOperationException("Please implement the JedliksToyCar.drive()  method");
        this.distance += 20;
        this.battery -= 1;

    }
}
