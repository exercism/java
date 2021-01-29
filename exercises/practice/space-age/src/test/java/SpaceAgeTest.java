import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class SpaceAgeTest {

    private static final double MAXIMUM_DELTA = 1E-02;

    @Test
    public void ageOnEarth() {
        SpaceAge age = new SpaceAge(1000000000);

        assertEquals(31.69, age.onEarth(), MAXIMUM_DELTA);
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnMercury() {
        SpaceAge age = new SpaceAge(2134835688);

        assertEquals(280.88, age.onMercury(), MAXIMUM_DELTA);
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnVenus() {
        SpaceAge age = new SpaceAge(189839836);

        assertEquals(9.78, age.onVenus(), MAXIMUM_DELTA);
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnMars() {
        SpaceAge age = new SpaceAge(2129871239L);

        assertEquals(35.88, age.onMars(), MAXIMUM_DELTA);
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnJupiter() {
        SpaceAge age = new SpaceAge(901876382);

        assertEquals(2.41, age.onJupiter(), MAXIMUM_DELTA);
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnSaturn() {
        SpaceAge age = new SpaceAge(2000000000L);

        assertEquals(2.15, age.onSaturn(), MAXIMUM_DELTA);
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnUranus() {
        SpaceAge age = new SpaceAge(1210123456L);

        assertEquals(0.46, age.onUranus(), MAXIMUM_DELTA);
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnNeptune() {
        SpaceAge age = new SpaceAge(1821023456L);

        assertEquals(0.35, age.onNeptune(), MAXIMUM_DELTA);
    }
}
