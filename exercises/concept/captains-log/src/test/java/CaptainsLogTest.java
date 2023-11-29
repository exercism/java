import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CaptainsLogTest {

    private Random random1;
    private Random random2;
    private Random random3;

    @BeforeEach
    public void setup() {
        random1 = new Random(47);
        random2 = new Random(474747);
        random3 = new Random(474747474747L);
    }

    @Test
    @Tag("task:1")
    @DisplayName("Generating a random planet class")
    public void testRandomPlanetClass() {
        assertThat(new CaptainsLog(random1).randomPlanetClass()).isEqualTo('T');
        assertThat(new CaptainsLog(random2).randomPlanetClass()).isEqualTo('K');
        assertThat(new CaptainsLog(random3).randomPlanetClass()).isEqualTo('J');
    }

    @Test
    @Tag("task:1")
    @DisplayName("Generated planet classes are valid")
    public void testRandomPlanetClassIsValid() {
        var captainsLog = new CaptainsLog(new Random());

        for (int i = 0; i < 100; i++) {
            assertThat(captainsLog.randomPlanetClass())
                    .isIn('D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y');
        }
    }

    @Test
    @Tag("task:2")
    @DisplayName("Generating a random ship registry number")
    public void testRandomShipRegistryNumber() {
        assertThat(new CaptainsLog(random1).randomShipRegistryNumber()).isEqualTo("NCC-6258");
        assertThat(new CaptainsLog(random2).randomShipRegistryNumber()).isEqualTo("NCC-1683");
        assertThat(new CaptainsLog(random3).randomShipRegistryNumber()).isEqualTo("NCC-4922");
    }

    @Test
    @Tag("task:2")
    @DisplayName("Generated ship registry numbers are valid")
    public void testRandomShipRegistryNumberIsValid() {
        var captainsLog = new CaptainsLog(new Random());

        for (int i = 0; i < 100; i++) {
            var shipRegistryNumber = captainsLog.randomShipRegistryNumber();
            var number = Integer.parseInt(shipRegistryNumber.substring(4));

            assertThat(number).isBetween(1000, 9999);
        }
    }

    @Test
    @Tag("task:3")
    @DisplayName("Generating a random stardate")
    public void testRandomStardate() {
        assertThat(new CaptainsLog(random1).randomStardate()).isEqualTo(41727.115786073);
        assertThat(new CaptainsLog(random2).randomStardate()).isEqualTo(41531.31240225019);
        assertThat(new CaptainsLog(random3).randomStardate()).isEqualTo(41283.50713600276);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Generated stardates are valid")
    public void testRandomStardateIsValid() {
        var captainsLog = new CaptainsLog(new Random());

        for (int i = 0; i < 100; i++) {
            assertThat(captainsLog.randomStardate()).isBetween(41000.0, 42000.0);
        }
    }
}
