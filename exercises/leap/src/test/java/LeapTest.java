import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeapTest {

    @Test
    public void testYearNotDivBy4InCommonYear() {
        assertEquals(false, Leap.leapYear(2015));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy2NotDivBy4InCommonYear() {
        assertEquals(false, Leap.leapYear(1970));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy4NotDivBy100InLeapYear() {
        assertEquals(true, Leap.leapYear(1996));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy4And5InLeapYear() {
        assertEquals(true, Leap.leapYear(1960));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy100NotDivBy400InCommonYear() {
        assertEquals(false, Leap.leapYear(2100));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy100NotDivBy3IsNotLeapYear() {
        assertEquals(false, Leap.leapYear(1900));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy400InLeapYear() {
        assertEquals(true, Leap.leapYear(2000));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy400NotDivBy125IsLeapYear() {
        assertEquals(true, Leap.leapYear(2400));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYearDivBy200NotDivBy400InCommonYear() {
        assertEquals(false, Leap.leapYear(1800));
    }

}
