public class Lasagna {

    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int elasped) {
        return expectedMinutesInOven() - elasped;
    }

    public int preparationTimeInMinutes(int layers) {
        return layers * 2;
    }

    public int totalTimeInMinutes(int layers, int time) {
        return preparationTimeInMinutes(layers) + time;
    }
}
