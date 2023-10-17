import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CarsAssembleTest {

    private CarsAssemble carsAssemble;
    private double epsilon = 0.0000001d;

    @BeforeEach
    public void setUp() {
        carsAssemble = new CarsAssemble();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 0")
    public void productionRatePerHourForSpeedZero() {
        assertEquals(0.0, carsAssemble.productionRatePerHour(0), epsilon);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 1")
    public void productionRatePerHourForSpeedOne() {
        assertEquals(221.0, carsAssemble.productionRatePerHour(1), epsilon);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 4")
    public void productionRatePerHourForSpeedFour() {
        assertEquals(884.0, carsAssemble.productionRatePerHour(4), epsilon);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 7")
    public void productionRatePerHourForSpeedSeven() {
        assertEquals(1392.3, carsAssemble.productionRatePerHour(7), epsilon);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 9")
    public void productionRatePerHourForSpeedNine() {
        assertEquals(1591.2, carsAssemble.productionRatePerHour(9), epsilon);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 10")
    public void productionRatePerHourForSpeedTen() {
        assertEquals(1701.7, carsAssemble.productionRatePerHour(10), epsilon);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute should be 0 when line's speed is 0")
    public void workingItemsPerMinuteForSpeedZero() {
        assertThat(carsAssemble.workingItemsPerMinute(0)).isEqualTo(0);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute should be 3 when line's speed is 1")
    public void workingItemsPerMinuteForSpeedOne() {
        assertThat(carsAssemble.workingItemsPerMinute(1)).isEqualTo(3);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute should be 16 when line's speed is 5")
    public void workingItemsPerMinuteForSpeedFive() {
        assertThat(carsAssemble.workingItemsPerMinute(5)).isEqualTo(16);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute should be 26 when line's speed is 8")
    public void workingItemsPerMinuteForSpeedEight() {
        assertThat(carsAssemble.workingItemsPerMinute(8)).isEqualTo(26);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute should be 26 when line's speed is 9")
    public void workingItemsPerMinuteForSpeedNine() {
        assertThat(carsAssemble.workingItemsPerMinute(9)).isEqualTo(26);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The workingItemsPerMinute should be 28 when line's speed is 10")
    public void workingItemsPerMinuteForSpeedTen() {
        assertThat(carsAssemble.workingItemsPerMinute(10)).isEqualTo(28);
    }
}
