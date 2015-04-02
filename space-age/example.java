public class SpaceAge {

    private enum Planet {
        EARTH, MERCURY, VENUS, MARS, JUPITER, SATURN, URANUS, NEPTUNE
    }

    private double seconds;

    private static final double EARTH_ORBITAL_PERIOD_IN_SECONDS = 31557600.0;
    private static final int PRECISION = 2;
    private static final Map<Planet, Double> relativeOrbitalPeriods = new HashMap<>();

    static {
        relativeOrbitalPeriods.put(Planet.EARTH, 1.0);
        relativeOrbitalPeriods.put(Planet.MERCURY, 0.2408467);
        relativeOrbitalPeriods.put(Planet.VENUS, 0.61519726);
        relativeOrbitalPeriods.put(Planet.MARS, 1.8808158);
        relativeOrbitalPeriods.put(Planet.JUPITER, 11.862615);
        relativeOrbitalPeriods.put(Planet.SATURN, 29.447498);
        relativeOrbitalPeriods.put(Planet.URANUS, 84.016846);
        relativeOrbitalPeriods.put(Planet.NEPTUNE, 164.79132);
    }

    public SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    public double getSeconds() {
        return seconds;
    }

    public double onEarth() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.EARTH));
    }

    public double onMercury() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.MERCURY));
    }

    public double onVenus() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.VENUS));
    }

    public double onMars() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.MARS));
    }

    public double onJupiter() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.JUPITER));
    }

    public double onSaturn() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.SATURN));
    }

    public double onUranus() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.URANUS));
    }

    public double onNeptune() {
        return calculateAge(relativeOrbitalPeriods.get(Planet.NEPTUNE));
    }

    private double calculateAge(double relativeOrbitalPeriod) {
        double age = seconds / (EARTH_ORBITAL_PERIOD_IN_SECONDS * relativeOrbitalPeriod);

        return new BigDecimal(age).setScale(PRECISION, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
