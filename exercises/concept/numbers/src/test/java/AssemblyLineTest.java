import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.*;


public class AssemblyLineTest {

    private AssemblyLine assemblyLine;

    @Before
    public void setUp() {
        assemblyLine = new AssemblyLine();
    }

    @Test
    public void productionRatePerHourForSpeedZero() {
        assertThat(assemblyLine.productionRatePerHour(0)).isEqualTo(0.0);
    }
    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedOne() {
        assertThat(assemblyLine.productionRatePerHour(1)).isEqualTo(221.0);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedFour() {
        assertThat(assemblyLine.productionRatePerHour(4)).isEqualTo(884.0);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedSeven() {
        assertThat(assemblyLine.productionRatePerHour(7)).isEqualTo(1392.3);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedNine() {
        assertThat(assemblyLine.productionRatePerHour(9)).isEqualTo(1591.2);
    }

    @Test
    @Ignore("Remove to run test")
    public void productionRatePerHourForSpeedTen() {
        assertThat(assemblyLine.productionRatePerHour(10)).isEqualTo(1701.7);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedZero() {
        assertThat(assemblyLine.workingItemsPerMinute(0)).isEqualTo(0);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedOne() {
        assertThat(assemblyLine.workingItemsPerMinute(1)).isEqualTo(3);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedFive() {
        assertThat(assemblyLine.workingItemsPerMinute(5)).isEqualTo(16);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedEight() {
        assertThat(assemblyLine.workingItemsPerMinute(8)).isEqualTo(26);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedNine() {
        assertThat(assemblyLine.workingItemsPerMinute(9)).isEqualTo(26);
    }

    @Test
    @Ignore("Remove to run test")
    public void workingItemsPerMinuteForSpeedTen() {
        assertThat(assemblyLine.workingItemsPerMinute(10)).isEqualTo(28);
    }
}
