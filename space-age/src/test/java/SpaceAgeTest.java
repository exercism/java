import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceAgeTest {

    private static final double MAXIMUM_DELTA = 1E-02;

    @Test
    public void ageInSeconds() {
        SpaceAge age = new SpaceAge(1000000);

        assertEquals(1000000, age.getSeconds(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnEarth() {
        SpaceAge age = new SpaceAge(1000000000);

        assertEquals(31.69, age.onEarth(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnMercury() {
        SpaceAge age = new SpaceAge(2134835688);

        assertEquals(67.65, age.onEarth(), MAXIMUM_DELTA);
        assertEquals(280.88, age.onMercury(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnVenus() {
        SpaceAge age = new SpaceAge(189839836);

        assertEquals(6.02, age.onEarth(), MAXIMUM_DELTA);
        assertEquals(9.78, age.onVenus(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnMars() {
        SpaceAge age = new SpaceAge(2329871239L);

        assertEquals(73.83, age.onEarth(), MAXIMUM_DELTA);
        assertEquals(39.25, age.onMars(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnJupiter() {
        SpaceAge age = new SpaceAge(901876382);

        assertEquals(28.58, age.onEarth(), MAXIMUM_DELTA);
        assertEquals(2.41, age.onJupiter(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnSaturn() {
        SpaceAge age = new SpaceAge(3000000000L);

        assertEquals(95.06, age.onEarth(), MAXIMUM_DELTA);
        assertEquals(3.23, age.onSaturn(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnUranus() {
        SpaceAge age = new SpaceAge(3210123456L);

        assertEquals(101.72, age.onEarth(), MAXIMUM_DELTA);
        assertEquals(1.21, age.onUranus(), MAXIMUM_DELTA);
    }

    @Test
    public void ageOnNeptune() {
        SpaceAge age = new SpaceAge(8210123456L);

        assertEquals(260.16, age.onEarth(), MAXIMUM_DELTA);
        assertEquals(1.58, age.onNeptune(), MAXIMUM_DELTA);
    }
}
