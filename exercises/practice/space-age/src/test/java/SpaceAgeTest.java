import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.within;

public class SpaceAgeTest {

    private static final double MAXIMUM_DELTA = 1E-02;

    @Test
    public void ageOnEarth() {
        SpaceAge age = new SpaceAge(1000000000, "Earth");

        assertThat(age.calculateAge()).isEqualTo(31.69, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnMercury() {
        SpaceAge age = new SpaceAge(2134835688, "Mercury");

        assertThat(age.calculateAge()).isEqualTo(280.88, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnVenus() {
        SpaceAge age = new SpaceAge(189839836, "Venus");

        assertThat(age.calculateAge()).isEqualTo(9.78, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnMars() {
        SpaceAge age = new SpaceAge(2129871239L, "Mars");

        assertThat(age.calculateAge()).isEqualTo(35.88, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnJupiter() {
        SpaceAge age = new SpaceAge(901876382, "Jupiter");

        assertThat(age.calculateAge()).isEqualTo(2.41, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnSaturn() {
        SpaceAge age = new SpaceAge(2000000000L, "Saturn");

        assertThat(age.calculateAge()).isEqualTo(2.15, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnUranus() {
        SpaceAge age = new SpaceAge(1210123456L, "Uranus");

        assertThat(age.calculateAge()).isEqualTo(0.46, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void ageOnNeptune() {
        SpaceAge age = new SpaceAge(1821023456L, "Neptune");

        assertThat(age.calculateAge()).isEqualTo(0.35, within(MAXIMUM_DELTA));
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidPlanetCausesError() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new SpaceAge(680804807L, "Sun"))
                .withMessage("not a planet");
    }
}
