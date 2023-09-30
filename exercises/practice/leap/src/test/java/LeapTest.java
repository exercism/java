import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapTest {

    private Leap leap;

    @Before
    public void setup() {
        leap = new Leap();
    }

    @Test
    public void testYearNotDivBy4InCommonYear() {
        assertThat(leap.isLeapYear(2015)).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy2NotDivBy4InCommonYear() {
        assertThat(leap.isLeapYear(1970)).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy4NotDivBy100InLeapYear() {
        assertThat(leap.isLeapYear(1996)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy4And5InLeapYear() {
        assertThat(leap.isLeapYear(1960)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy100NotDivBy400InCommonYear() {
        assertThat(leap.isLeapYear(2100)).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy100NotDivBy3IsNotLeapYear() {
        assertThat(leap.isLeapYear(1900)).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy400InLeapYear() {
        assertThat(leap.isLeapYear(2000)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy400NotDivBy125IsLeapYear() {
        assertThat(leap.isLeapYear(2400)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy200NotDivBy400InCommonYear() {
        assertThat(leap.isLeapYear(1800)).isFalse();
    }

}
