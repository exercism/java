class Lasagna
{
    public int ExpectedMinutesInOven() {
        return 40;
    }

    public int RemainingMinutesInOven(int elapsed) {
        return ExpectedMinutesInOven() - elapsed;
    }

    public int PreparationTimeInMinutes(int layers) {
        return layers * 2;
    }

    public int ElapsedTimeInMinutes(int layers, int mins) {
        return PreparationTimeInMinutes(layers) +  mins;
    }

}
