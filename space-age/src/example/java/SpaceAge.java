import java.math.BigDecimal;

public class SpaceAge {

    private enum Planet {
        EARTH(1.0),
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        private final double relativeOrbitalPeriod;

        Planet(double relativeOrbitalPeriod) {
            this.relativeOrbitalPeriod = relativeOrbitalPeriod;
        }

        public double getRelativeOrbitalPeriod() {
            return relativeOrbitalPeriod;
        }
    }

    private static final double EARTH_ORBITAL_PERIOD_IN_SECONDS = 31557600.0;
    private static final int PRECISION = 2;

    private double seconds;

    public SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    public double getSeconds() {
        return seconds;
    }

    public double onEarth() {
        return calculateAge(Planet.EARTH);
    }

    public double onMercury() {
        return calculateAge(Planet.MERCURY);
    }

    public double onVenus() {
        return calculateAge(Planet.VENUS);
    }

    public double onMars() {
        return calculateAge(Planet.MARS);
    }

    public double onJupiter() {
        return calculateAge(Planet.JUPITER);
    }

    public double onSaturn() {
        return calculateAge(Planet.SATURN);
    }

    public double onUranus() {
        return calculateAge(Planet.URANUS);
    }

    public double onNeptune() {
        return calculateAge(Planet.NEPTUNE);
    }

    private double calculateAge(Planet planet) {
        double age = seconds / (EARTH_ORBITAL_PERIOD_IN_SECONDS * planet.getRelativeOrbitalPeriod());

        return new BigDecimal(age).setScale(PRECISION, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
