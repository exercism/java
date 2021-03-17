import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.*;


public class CarsAssembleTest {

    private CarsAssemble carsAssemble;

    @Before
    public void setUp() {
        carsAssemble = new CarsAssemble();
    }

    @Test
    public void productionRatePerHourForSpeedZero() {
        assertThat(carsAssemble.productionRatePerHour(0)).isEqualTo(0.0);
    }
    
    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedOne() {
        assertThat(carsAssemble.productionRatePerHour(1)).isEqualTo(221.0);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedFour() {
        assertThat(carsAssemble.productionRatePerHour(4)).isEqualTo(884.0);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedSeven() {
        assertThat(carsAssemble.productionRatePerHour(7)).isEqualTo(1392.3);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedNine() {
        assertThat(carsAssemble.productionRatePerHour(9)).isEqualTo(1591.2);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedTen() {
        assertThat(carsAssemble.productionRatePerHour(10)).isEqualTo(1701.7);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedZero() {
        assertThat(carsAssemble.workingItemsPerMinute(0)).isEqualTo(0);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedOne() {
        assertThat(carsAssemble.workingItemsPerMinute(1)).isEqualTo(3);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedFive() {
        assertThat(carsAssemble.workingItemsPerMinute(5)).isEqualTo(16);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedEight() {
        assertThat(carsAssemble.workingItemsPerMinute(8)).isEqualTo(26);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedNine() {
        assertThat(carsAssemble.workingItemsPerMinute(9)).isEqualTo(26);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedTen() {
        assertThat(carsAssemble.workingItemsPerMinute(10)).isEqualTo(28);
    }
}
