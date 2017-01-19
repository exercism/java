import org.junit.Ignore;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MeetupTest {

    @Test
    public void test_monteenth_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 13);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_monteenth_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 19);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_monteenth_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 16);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_tuesteenth_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 19);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_tuesteenth_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 16);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_tuesteenth_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 13);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_wednesteenth_of_january_2013() {
        LocalDate expected = LocalDate.of(2013, 1, 16);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_wednesteenth_of_february_2013() {
        LocalDate expected = LocalDate.of(2013, 2, 13);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_wednesteenth_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 19);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_thursteenth_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 16);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_thursteenth_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 13);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_thursteenth_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 19);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_friteenth_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 19);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_friteenth_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 16);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_friteenth_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 13);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_saturteenth_of_february_2013() {
        LocalDate expected = LocalDate.of(2013, 2, 16);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_saturteenth_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 13);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_saturteenth_of_october_2013() {
        LocalDate expected = LocalDate.of(2013, 10, 19);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_sunteenth_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 19);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_sunteenth_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 16);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_sunteenth_of_october_2013() {
        LocalDate expected = LocalDate.of(2013, 10, 13);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH));
    }

    @Ignore
    @Test
    public void test_first_monday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 4);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_monday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 1);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_tuesday_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 7);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_tuesday_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 4);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_wednesday_of_july_2013() {
        LocalDate expected = LocalDate.of(2013, 7, 3);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_wednesday_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 7);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_thursday_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 5);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_thursday_of_october_2013() {
        LocalDate expected = LocalDate.of(2013, 10, 3);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_friday_of_november_2013() {
        LocalDate expected = LocalDate.of(2013, 11, 1);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_friday_of_december_2013() {
        LocalDate expected = LocalDate.of(2013, 12, 6);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_saturday_of_january_2013() {
        LocalDate expected = LocalDate.of(2013, 1, 5);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_saturday_of_february_2013() {
        LocalDate expected = LocalDate.of(2013, 2, 2);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_sunday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 3);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_first_sunday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 7);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FIRST));
    }

    @Ignore
    @Test
    public void test_second_monday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 11);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_monday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 8);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_tuesday_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 14);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_tuesday_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 11);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_wednesday_of_july_2013() {
        LocalDate expected = LocalDate.of(2013, 7, 10);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_wednesday_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 14);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_thursday_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 12);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_thursday_of_october_2013() {
        LocalDate expected = LocalDate.of(2013, 10, 10);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_friday_of_november_2013() {
        LocalDate expected = LocalDate.of(2013, 11, 8);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_friday_of_december_2013() {
        LocalDate expected = LocalDate.of(2013, 12, 13);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_saturday_of_january_2013() {
        LocalDate expected = LocalDate.of(2013, 1, 12);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_saturday_of_february_2013() {
        LocalDate expected = LocalDate.of(2013, 2, 9);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_sunday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 10);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_second_sunday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 14);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.SECOND));
    }

    @Ignore
    @Test
    public void test_third_monday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 18);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_monday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 15);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_tuesday_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 21);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_tuesday_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 18);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_wednesday_of_july_2013() {
        LocalDate expected = LocalDate.of(2013, 7, 17);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_wednesday_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 21);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_thursday_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 19);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_thursday_of_october_2013() {
        LocalDate expected = LocalDate.of(2013, 10, 17);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_friday_of_november_2013() {
        LocalDate expected = LocalDate.of(2013, 11, 15);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_friday_of_december_2013() {
        LocalDate expected = LocalDate.of(2013, 12, 20);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_saturday_of_january_2013() {
        LocalDate expected = LocalDate.of(2013, 1, 19);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_saturday_of_february_2013() {
        LocalDate expected = LocalDate.of(2013, 2, 16);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_sunday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 17);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_third_sunday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 21);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.THIRD));
    }

    @Ignore
    @Test
    public void test_fourth_monday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 25);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_monday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 22);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_tuesday_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 28);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_tuesday_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 25);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_wednesday_of_july_2013() {
        LocalDate expected = LocalDate.of(2013, 7, 24);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_wednesday_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 28);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_thursday_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 26);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_thursday_of_october_2013() {
        LocalDate expected = LocalDate.of(2013, 10, 24);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_friday_of_november_2013() {
        LocalDate expected = LocalDate.of(2013, 11, 22);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_friday_of_december_2013() {
        LocalDate expected = LocalDate.of(2013, 12, 27);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_saturday_of_january_2013() {
        LocalDate expected = LocalDate.of(2013, 1, 26);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_saturday_of_february_2013() {
        LocalDate expected = LocalDate.of(2013, 2, 23);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_sunday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 24);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_fourth_sunday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 28);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FOURTH));
    }

    @Ignore
    @Test
    public void test_last_monday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 25);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_monday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 29);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.MONDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_tuesday_of_may_2013() {
        LocalDate expected = LocalDate.of(2013, 5, 28);
        Meetup meetup = new Meetup(5, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_tuesday_of_june_2013() {
        LocalDate expected = LocalDate.of(2013, 6, 25);
        Meetup meetup = new Meetup(6, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_wednesday_of_july_2013() {
        LocalDate expected = LocalDate.of(2013, 7, 31);
        Meetup meetup = new Meetup(7, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_wednesday_of_august_2013() {
        LocalDate expected = LocalDate.of(2013, 8, 28);
        Meetup meetup = new Meetup(8, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_thursday_of_september_2013() {
        LocalDate expected = LocalDate.of(2013, 9, 26);
        Meetup meetup = new Meetup(9, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_thursday_of_october_2013() {
        LocalDate expected = LocalDate.of(2013, 10, 31);
        Meetup meetup = new Meetup(10, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_friday_of_november_2013() {
        LocalDate expected = LocalDate.of(2013, 11, 29);
        Meetup meetup = new Meetup(11, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_friday_of_december_2013() {
        LocalDate expected = LocalDate.of(2013, 12, 27);
        Meetup meetup = new Meetup(12, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_saturday_of_january_2013() {
        LocalDate expected = LocalDate.of(2013, 1, 26);
        Meetup meetup = new Meetup(1, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_saturday_of_february_2013() {
        LocalDate expected = LocalDate.of(2013, 2, 23);
        Meetup meetup = new Meetup(2, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_sunday_of_march_2013() {
        LocalDate expected = LocalDate.of(2013, 3, 31);
        Meetup meetup = new Meetup(3, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST));
    }

    @Ignore
    @Test
    public void test_last_sunday_of_april_2013() {
        LocalDate expected = LocalDate.of(2013, 4, 28);
        Meetup meetup = new Meetup(4, 2013);
        assertEquals(expected, meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST));
    }
}
