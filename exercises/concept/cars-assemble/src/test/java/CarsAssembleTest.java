import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class CarsAssembleTest {

    private CarsAssemble carsAssemble;
    private double epsilon = 0.0000001d;

    @BeforeEach
    public void setUp() {
        carsAssemble = new CarsAssemble();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result given line's speed")
    public void productionRatePerHourForSpeedZero() {
        assertThat(Math.abs(carsAssemble.productionRatePerHour(0) - 0.0) < epsilon).isTrue();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result given line's speed")
    public void productionRatePerHourForSpeedOne() {
        assertThat(Math.abs(carsAssemble.productionRatePerHour(1) - 221.0) < epsilon).isTrue();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result given line's speed")
    public void productionRatePerHourForSpeedFour() {
        assertThat(Math.abs(carsAssemble.productionRatePerHour(4) - 884.0) < epsilon).isTrue();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result given line's speed")
    public void productionRatePerHourForSpeedSeven() {
        assertThat(Math.abs(carsAssemble.productionRatePerHour(7) - 1392.3) < epsilon).isTrue();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result given line's speed")
    public void productionRatePerHourForSpeedNine() {
        assertThat(Math.abs(carsAssemble.productionRatePerHour(9) - 1591.2) < epsilon).isTrue();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result given line's speed")
    public void productionRatePerHourForSpeedTen() {
        assertThat(Math.abs(carsAssemble.productionRatePerHour(10) - 1701.7) < epsilon).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute method returns the correct result given line's speed")
    public void workingItemsPerMinuteForSpeedZero() {
        assertThat(carsAssemble.workingItemsPerMinute(0)).isEqualTo(0);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute method returns the correct result given line's speed")
    public void workingItemsPerMinuteForSpeedOne() {
        assertThat(carsAssemble.workingItemsPerMinute(1)).isEqualTo(3);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute method returns the correct result given line's speed")
    public void workingItemsPerMinuteForSpeedFive() {
        assertThat(carsAssemble.workingItemsPerMinute(5)).isEqualTo(16);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute method returns the correct result given line's speed")
    public void workingItemsPerMinuteForSpeedEight() {
        assertThat(carsAssemble.workingItemsPerMinute(8)).isEqualTo(26);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute method returns the correct result given line's speed")
    public void workingItemsPerMinuteForSpeedNine() {
        assertThat(carsAssemble.workingItemsPerMinute(9)).isEqualTo(26);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute method returns the correct result given line's speed")
    public void workingItemsPerMinuteForSpeedTen() {
        assertThat(carsAssemble.workingItemsPerMinute(10)).isEqualTo(28);
    }
}
