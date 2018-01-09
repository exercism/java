import org.junit.Ignore;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class MeetupTest {

    @Test
    public void testMonteenthOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 13);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMonteenthOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 19);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMonteenthOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 16);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTuesteenthOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 19);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTuesteenthOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 16);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTuesteenthOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 13);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWednesteenthOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 16);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWednesteenthOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 13);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWednesteenthOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 19);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThursteenthOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 16);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThursteenthOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 13);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThursteenthOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 19);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFriteenthOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 19);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFriteenthOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 16);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFriteenthOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 13);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSaturteenthOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 16);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSaturteenthOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 13);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSaturteenthOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 19);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSunteenthOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 19);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSunteenthOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 16);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSunteenthOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 13);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 4);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 1);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 7);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 4);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 3);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 7);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 5);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 3);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 1);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 6);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 5);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 2);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 3);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 7);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FIRST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 11);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 8);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 14);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 11);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 10);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 14);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 12);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 10);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 8);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 13);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 12);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 9);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 10);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecondSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 14);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.SECOND));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 18);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 15);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 21);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 18);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 17);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 21);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 19);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 17);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 15);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 20);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 19);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 16);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 17);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThirdSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 21);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.THIRD));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 25);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 22);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 28);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 25);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 24);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 28);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 26);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 24);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 22);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 27);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 26);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 23);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 24);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFourthSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 28);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FOURTH));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 25);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 29);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 28);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 25);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 31);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 28);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 26);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 31);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 29);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 27);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 26);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 23);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 31);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 28);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastWednesdayOfFebruary2012() {
        LocalDate expected = LocalDate.of(2012, 2, 29);
        Meetup meetup = new Meetup(2, 2012);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastWednesdayOfDecember2014() {
        LocalDate expected = LocalDate.of(2014, 12, 31);
        Meetup meetup = new Meetup(12, 2014);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLastSundayOfFebruary2015() {
        LocalDate expected = LocalDate.of(2015, 2, 22);
        Meetup meetup = new Meetup(2, 2015);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFirstFridayOfDecember2012() {
        LocalDate expected = LocalDate.of(2012, 12, 7);
        Meetup meetup = new Meetup(12, 2012);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST));
    }
}
