import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapTest {

    private Leap leap;

    @BeforeEach
    public void setup() {
        leap = new Leap();
    }

    @Test
    @DisplayName("year not divisible by 4 in common year")
    public void testYearNotDivBy4InCommonYear() {
        assertThat(leap.isLeapYear(2015)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 2, not divisible by 4 in common year\"")
    public void testYearDivBy2NotDivBy4InCommonYear() {
        assertThat(leap.isLeapYear(1970)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 4, not divisible by 100 in leap year")
    public void testYearDivBy4NotDivBy100InLeapYear() {
        assertThat(leap.isLeapYear(1996)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 4 and 5 is still a leap year")
    public void testYearDivBy4And5InLeapYear() {
        assertThat(leap.isLeapYear(1960)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 100, not divisible by 400 in common year")
    public void testYearDivBy100NotDivBy400InCommonYear() {
        assertThat(leap.isLeapYear(2100)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 100 but not by 3 is still not a leap year")
    public void testYearDivBy100NotDivBy3IsNotLeapYear() {
        assertThat(leap.isLeapYear(1900)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 400 is leap year")
    public void testYearDivBy400InLeapYear() {
        assertThat(leap.isLeapYear(2000)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 400 but not by 125 is still a leap year")
    public void testYearDivBy400NotDivBy125IsLeapYear() {
        assertThat(leap.isLeapYear(2400)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("year divisible by 200, not divisible by 400 in common year")
    public void testYearDivBy200NotDivBy400InCommonYear() {
        assertThat(leap.isLeapYear(1800)).isFalse();
    }

}
