import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private final Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        var index = random.nextInt(PLANET_CLASSES.length);
        return PLANET_CLASSES[index];
    }

    String randomShipRegistryNumber() {
        var start = 1000;
        var end = 10000;


        return "NCC-" + String.valueOf(start + random.nextInt(end - start));
    }

    double randomStardate() {
        var start = 41000.0;
        var end = 42000.0;
        return start + random.nextDouble() * (end - start);
    }
}
