import org.junit.Test;

public class SpaceAgeTest {

    private static final double MAXIMUM_DELTA = 1E-02;

    @Test
    public void ageInSeconds() {
        SpaceAge age = new SpaceAge(1000000);

        assertEquals(age.getSeconds(), 1000000, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnEarth() {
        SpaceAge age = new SpaceAge(1000000000);

        assertEquals(age.onEarth(), 31.69, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnMercury() {
        SpaceAge age = new SpaceAge(2134835688);

        assertEquals(age.onEarth(), 67.65, MAXIMUM_DELTA);
        assertEquals(age.onMercury(), 280.88, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnVenus() {
        SpaceAge age = new SpaceAge(189839836);

        assertEquals(age.onEarth(), 6.02, MAXIMUM_DELTA);
        assertEquals(age.onVenus(), 9.78, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnMars() {
        SpaceAge age = new SpaceAge(2329871239L);

        assertEquals(age.onEarth(), 73.83, MAXIMUM_DELTA);
        assertEquals(age.onMars(), 39.25, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnJupiter() {
        SpaceAge age = new SpaceAge(901876382);

        assertEquals(age.onEarth(), 28.58, MAXIMUM_DELTA);
        assertEquals(age.onJupiter(), 2.41, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnSaturn() {
        SpaceAge age = new SpaceAge(3000000000L);

        assertEquals(age.onEarth(), 95.06, MAXIMUM_DELTA);
        assertEquals(age.onSaturn(), 3.23, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnUranus() {
        SpaceAge age = new SpaceAge(3210123456L);

        assertEquals(age.onEarth(), 101.72, MAXIMUM_DELTA);
        assertEquals(age.onUranus(), 1.21, MAXIMUM_DELTA);
    }

    @Test
    public void ageOnNeptune() {
        SpaceAge age = new SpaceAge(8210123456L);

        assertEquals(age.onEarth(), 260.16, MAXIMUM_DELTA);
        assertEquals(age.onNeptune(), 1.58, MAXIMUM_DELTA);
    }
}
