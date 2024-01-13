import java.util.Map;
import java.util.HashMap;

class SpaceAge {

    private Map<String, Double> planetsOrbitalPeriod = new HashMap<>() {{
            put("Mercury", 0.2408467);
            put("Venus", 0.61519726);
            put("Mars", 1.8808158);
            put("Jupiter", 11.862615);
            put("Saturn", 29.447498);
            put("Uranus", 84.016846);
            put("Neptune", 164.79132);
            put("Earth", 1.0);
        }};

    private static final double EARTH_ORBITAL_PERIOD_IN_SECONDS = 31557600.0;
    private double seconds;
    private String planet;

    SpaceAge(double seconds, String planet) {
        this.seconds = seconds;
        this.planet = planet;

        if (planetsOrbitalPeriod.get(planet) == null) {
            throw new IllegalArgumentException("not a planet");
        }
    }

    double calculateAge() {
        double earthyears = seconds / EARTH_ORBITAL_PERIOD_IN_SECONDS;
        double years = earthyears / planetsOrbitalPeriod.get(planet);
        
        return (double) Math.round(years * 100) / 100;
    }

}
