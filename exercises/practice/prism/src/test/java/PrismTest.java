import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrismTest {
    @Test
    @DisplayName("zero prisms")
    public void testZeroPrisms() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);

        assertThat(Prism.findSequence(laser, List.of())).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("one prism one hit")
    public void testOnePrismOneHit() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);
        final List<Prism.PrismInfo> prisms = List.of(new Prism.PrismInfo(1, 10, 0, 0));

        assertThat(Prism.findSequence(laser, prisms)).containsExactly(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("one prism hits zero")
    public void testOnePrismHitsZero() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);
        final List<Prism.PrismInfo> prisms = List.of(new Prism.PrismInfo(1, -10, 0, 0));

        assertThat(Prism.findSequence(laser, prisms)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("going up zero hits")
    public void testGoingUpZeroHits() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 90);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(3, 0, -10, 0),
                new Prism.PrismInfo(1, -10, 0, 0),
                new Prism.PrismInfo(2, 10, 0, 0)
        );

        assertThat(Prism.findSequence(laser, prisms)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("going down zero hits")
    public void testGoingDownZeroHits() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, -90);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(1, 10, 0, 0),
                new Prism.PrismInfo(2, 0, 10, 0),
                new Prism.PrismInfo(3, -10, 0, 0)
        );

        assertThat(Prism.findSequence(laser, prisms)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("going left zero hits")
    public void testGoingLeftZeroHits() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 180);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(2, 0, 10, 0),
                new Prism.PrismInfo(3, 10, 0, 0),
                new Prism.PrismInfo(1, 0, -10, 0)
        );

        assertThat(Prism.findSequence(laser, prisms)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative angle")
    public void testNegativeAngle() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, -180);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(1, 0, -10, 0),
                new Prism.PrismInfo(2, 0, 10, 0),
                new Prism.PrismInfo(3, 10, 0, 0)
        );

        assertThat(Prism.findSequence(laser, prisms)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("large angle")
    public void testLargeAngle() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 2340);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(1, 10, 0, 0)
        );

        assertThat(Prism.findSequence(laser, prisms)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("upward reflection two hits")
    public void testUpwardReflectionTwoHits() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(1, 10, 10, 0),
                new Prism.PrismInfo(2, 10, 0, 90)
        );

        assertThat(Prism.findSequence(laser, prisms)).containsExactly(2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("downward reflection two hits")
    public void testDownwardReflectionTwoHits() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(1, 10, 0, -90),
                new Prism.PrismInfo(2, 10, -10, 0)
        );

        assertThat(Prism.findSequence(laser, prisms)).containsExactly(1, 2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("same prism twice")
    public void testSamePrismTwice() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(2, 10, 0, 0),
                new Prism.PrismInfo(1, 20, 0, -180)
        );

        assertThat(Prism.findSequence(laser, prisms)).containsExactly(2, 1, 2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("simple path")
    public void testSimplePath() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(3, 30, 10, 45),
                new Prism.PrismInfo(1, 10, 10, -90),
                new Prism.PrismInfo(2, 10, 0, 90),
                new Prism.PrismInfo(4, 20, 0, 0)
        );

        assertThat(Prism.findSequence(laser, prisms)).containsExactly(2, 1, 3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple prisms floating point precision")
    public void testMultiplePrismFloatingPointPrecision() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, -6.429);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(26, 5.8, 73.4, 6.555),
                new Prism.PrismInfo(24, 36.2, 65.2, -0.304),
                new Prism.PrismInfo(20, 20.4, 82.8, 45.17),
                new Prism.PrismInfo(31, -20.2, 48.8, 30.615),
                new Prism.PrismInfo(30, 24.0, 0.6, 28.771),
                new Prism.PrismInfo(29, 31.4, 79.4, 61.327),
                new Prism.PrismInfo(28, 36.4, 31.4, -18.157),
                new Prism.PrismInfo(22, 47.0, 57.8, 54.745),
                new Prism.PrismInfo(38, 36.4, 79.2, 49.05),
                new Prism.PrismInfo(10, 37.8, 55.2, 11.978),
                new Prism.PrismInfo(18, -26.0, 42.6, 22.661),
                new Prism.PrismInfo(25, 38.8, 76.2, 51.958),
                new Prism.PrismInfo(2, 0.0, 42.4, -21.817),
                new Prism.PrismInfo(35, 21.4, 44.8, -171.579),
                new Prism.PrismInfo(7, 14.2, -1.6, 19.081),
                new Prism.PrismInfo(33, 11.2, 44.4, -165.941),
                new Prism.PrismInfo(11, 15.4, 82.6, 66.262),
                new Prism.PrismInfo(16, 30.8, 6.6, 35.852),
                new Prism.PrismInfo(15, -3.0, 79.2, 53.782),
                new Prism.PrismInfo(4, 29.0, 75.4, 17.016),
                new Prism.PrismInfo(23, 41.6, 59.8, 70.763),
                new Prism.PrismInfo(8, -10.0, 15.8, -9.24),
                new Prism.PrismInfo(13, 48.6, 51.8, 45.812),
                new Prism.PrismInfo(1, 13.2, 77.0, 17.937),
                new Prism.PrismInfo(34, -8.8, 36.8, -4.199),
                new Prism.PrismInfo(21, 24.4, 75.8, 20.783),
                new Prism.PrismInfo(17, -4.4, 74.6, 24.709),
                new Prism.PrismInfo(9, 30.8, 41.8, -165.413),
                new Prism.PrismInfo(32, 4.2, 78.6, 40.892),
                new Prism.PrismInfo(37, -15.8, 47.0, 33.29),
                new Prism.PrismInfo(6, 1.0, 80.6, 51.295),
                new Prism.PrismInfo(36, -27.0, 47.8, 92.52),
                new Prism.PrismInfo(14, -2.0, 34.4, -52.001),
                new Prism.PrismInfo(5, 23.2, 80.2, 31.866),
                new Prism.PrismInfo(27, -5.6, 32.8, -75.303),
                new Prism.PrismInfo(12, -1.0, 0.2, 0.0),
                new Prism.PrismInfo(3, -6.6, 3.2, 46.72),
                new Prism.PrismInfo(19, -13.8, 24.2, -9.205)
        );

        assertThat(Prism.findSequence(laser, prisms)).containsExactly(
                7, 30, 16, 28, 13, 22, 23, 10, 9, 24, 25, 38, 29, 4, 35, 21, 5, 20,
                11, 1, 33, 26, 32, 6, 15, 17, 2, 14, 27, 34, 37, 31, 36, 18, 19, 8, 3, 12);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("complex path with multiple prisms floating point precision")
    public void testComplexPathWithMultiplePrismFloatingPointPrecision() {
        final Prism.LaserInfo laser = new Prism.LaserInfo(0, 0, 0);
        final List<Prism.PrismInfo> prisms = List.of(
                new Prism.PrismInfo(46, 37.4, 20.6, -88.332),
                new Prism.PrismInfo(72, -24.2, 23.4, -90.774),
                new Prism.PrismInfo(25, 78.6, 7.8, 98.562),
                new Prism.PrismInfo(60, -58.8, 31.6, 115.56),
                new Prism.PrismInfo(22, 75.2, 28.0, 63.515),
                new Prism.PrismInfo(2, 89.8, 27.8, 91.176),
                new Prism.PrismInfo(23, 9.8, 30.8, 30.829),
                new Prism.PrismInfo(69, 22.8, 20.6, -88.315),
                new Prism.PrismInfo(44, -0.8, 15.6, -116.565),
                new Prism.PrismInfo(36, -24.2, 8.2, -90.0),
                new Prism.PrismInfo(53, -1.2, 0.0, 0.0),
                new Prism.PrismInfo(52, 14.2, 24.0, -143.896),
                new Prism.PrismInfo(5, -65.2, 21.6, 93.128),
                new Prism.PrismInfo(66, 5.4, 15.6, 31.608),
                new Prism.PrismInfo(51, -72.6, 21.0, -100.976),
                new Prism.PrismInfo(65, 48.0, 10.2, 87.455),
                new Prism.PrismInfo(21, -41.8, 0.0, 68.352),
                new Prism.PrismInfo(18, -46.2, 19.2, -128.362),
                new Prism.PrismInfo(10, 74.4, 0.4, 90.939),
                new Prism.PrismInfo(15, 67.6, 0.4, 84.958),
                new Prism.PrismInfo(35, 14.8, -0.4, 89.176),
                new Prism.PrismInfo(1, 83.0, 0.2, 89.105),
                new Prism.PrismInfo(68, 14.6, 28.0, -29.867),
                new Prism.PrismInfo(67, 79.8, 18.6, -136.643),
                new Prism.PrismInfo(38, 53.0, 14.6, -90.848),
                new Prism.PrismInfo(31, -58.0, 6.6, -61.837),
                new Prism.PrismInfo(74, -30.8, 0.4, 85.966),
                new Prism.PrismInfo(48, -4.6, 10.0, -161.222),
                new Prism.PrismInfo(12, 59.0, 5.0, -91.164),
                new Prism.PrismInfo(33, -16.4, 18.4, 90.734),
                new Prism.PrismInfo(4, 82.6, 27.6, 71.127),
                new Prism.PrismInfo(75, -10.2, 30.6, -1.108),
                new Prism.PrismInfo(28, 38.0, 0.0, 86.863),
                new Prism.PrismInfo(11, 64.4, -0.2, 92.353),
                new Prism.PrismInfo(9, -51.4, 31.6, 67.249),
                new Prism.PrismInfo(26, -39.8, 30.8, 61.113),
                new Prism.PrismInfo(30, -34.2, 0.6, 111.33),
                new Prism.PrismInfo(56, -51.0, 0.2, 70.445),
                new Prism.PrismInfo(41, -12.0, 0.0, 91.219),
                new Prism.PrismInfo(24, 63.8, 14.4, 86.586),
                new Prism.PrismInfo(70, -72.8, 13.4, -87.238),
                new Prism.PrismInfo(3, 22.4, 7.0, -91.685),
                new Prism.PrismInfo(13, 34.4, 7.0, 90.0),
                new Prism.PrismInfo(16, -47.4, 11.4, -136.02),
                new Prism.PrismInfo(6, 90.0, 0.2, 90.415),
                new Prism.PrismInfo(54, 44.0, 27.8, 85.969),
                new Prism.PrismInfo(32, -9.0, 0.0, 91.615),
                new Prism.PrismInfo(8, -31.6, 30.8, 0.535),
                new Prism.PrismInfo(39, -12.0, 8.2, 90.0),
                new Prism.PrismInfo(14, -79.6, 32.4, 92.342),
                new Prism.PrismInfo(42, 65.8, 20.8, -85.867),
                new Prism.PrismInfo(40, -65.0, 14.0, 87.109),
                new Prism.PrismInfo(45, 10.6, 18.8, 23.697),
                new Prism.PrismInfo(71, -24.2, 18.6, -88.531),
                new Prism.PrismInfo(7, -72.6, 6.4, -89.148),
                new Prism.PrismInfo(62, -32.0, 24.8, -140.8),
                new Prism.PrismInfo(49, 34.4, -0.2, 89.415),
                new Prism.PrismInfo(63, 74.2, 12.6, -138.429),
                new Prism.PrismInfo(59, 82.8, 13.0, -140.177),
                new Prism.PrismInfo(34, -9.4, 23.2, -88.238),
                new Prism.PrismInfo(76, -57.6, 0.0, 1.2),
                new Prism.PrismInfo(43, 7.0, 0.0, 116.565),
                new Prism.PrismInfo(20, 45.8, -0.2, 1.469),
                new Prism.PrismInfo(37, -16.6, 13.2, 84.785),
                new Prism.PrismInfo(58, -79.0, -0.2, 89.481),
                new Prism.PrismInfo(50, -24.2, 12.8, -86.987),
                new Prism.PrismInfo(64, 59.2, 10.2, -92.203),
                new Prism.PrismInfo(61, -72.0, 26.4, -83.66),
                new Prism.PrismInfo(47, 45.4, 5.8, -82.992),
                new Prism.PrismInfo(17, -52.2, 17.8, -52.938),
                new Prism.PrismInfo(57, -61.8, 32.0, 84.627),
                new Prism.PrismInfo(29, 47.2, 28.2, 92.954),
                new Prism.PrismInfo(27, -4.6, 0.2, 87.397),
                new Prism.PrismInfo(55, -61.4, 26.4, 94.086),
                new Prism.PrismInfo(73, -40.4, 13.4, -62.229),
                new Prism.PrismInfo(19, 53.2, 20.6, -87.181)
        );

        assertThat(Prism.findSequence(laser, prisms)).containsExactly(
                43, 44, 66, 45, 52, 35, 49, 13, 3, 69, 46, 28, 20, 11, 24, 38, 19, 42,
                15, 10, 63, 25, 59, 1, 6, 2, 4, 67, 22, 29, 65, 64, 12, 47, 54, 68,
                23, 75, 8, 26, 18, 9, 60, 17, 31, 7, 70, 40, 5, 51, 61, 55, 57, 14,
                58, 76, 56, 16, 21, 30, 73, 62, 74, 41, 39, 36, 50, 37, 33, 71, 72,
                34, 32, 27, 48, 53
        );
    }
}
