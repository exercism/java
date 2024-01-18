import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class SpaceAgeTest {

    private static final double MAXIMUM_DELTA = 1E-02;

    @Test
    public void ageOnEarth() {
        SpaceAge age = new SpaceAge(1000000000);

        assertThat(age.onEarth()).isEqualTo(31.69, offset(MAXIMUM_DELTA));
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnMercury() {
        SpaceAge age = new SpaceAge(2134835688);

        assertThat(age.onMercury()).isEqualTo(280.88, offset(MAXIMUM_DELTA));
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnVenus() {
        SpaceAge age = new SpaceAge(189839836);

        assertThat(age.onVenus()).isEqualTo(9.78, offset(MAXIMUM_DELTA));
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnMars() {
        SpaceAge age = new SpaceAge(2129871239L);

        assertThat(age.onMars()).isEqualTo(35.88, offset(MAXIMUM_DELTA));
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnJupiter() {
        SpaceAge age = new SpaceAge(901876382);

        assertThat(age.onJupiter()).isEqualTo(2.41, offset(MAXIMUM_DELTA));
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnSaturn() {
        SpaceAge age = new SpaceAge(2000000000L);

        assertThat(age.onSaturn()).isEqualTo(2.15, offset(MAXIMUM_DELTA));
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnUranus() {
        SpaceAge age = new SpaceAge(1210123456L);

        assertThat(age.onUranus()).isEqualTo(0.46, offset(MAXIMUM_DELTA));
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnNeptune() {
        SpaceAge age = new SpaceAge(1821023456L);

        assertThat(age.onNeptune()).isEqualTo(0.35, offset(MAXIMUM_DELTA));
    }
}
