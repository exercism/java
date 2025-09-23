import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class MeetupTest {

    @Test
    @DisplayName("when teenth Monday is the 13th, the first day of the teenth week")
    public void testMonteenthOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 13);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Monday is the 19th, the last day of the teenth week")
    public void testMonteenthOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 19);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Monday is some day in the middle of the teenth week")
    public void testMonteenthOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 16);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Tuesday is the 19th, the last day of the teenth week")
    public void testTuesteenthOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 19);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Tuesday is some day in the middle of the teenth week")
    public void testTuesteenthOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 16);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Tuesday is the 13th, the first day of the teenth week")
    public void testTuesteenthOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 13);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Wednesday is some day in the middle of the teenth week")
    public void testWednesteenthOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 16);
        Meetup meetup = new Meetup(1, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Wednesday is the 13th, the first day of the teenth week")
    public void testWednesteenthOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 13);
        Meetup meetup = new Meetup(2, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Wednesday is the 19th, the last day of the teenth week")
    public void testWednesteenthOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 19);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Thursday is some day in the middle of the teenth week")
    public void testThursteenthOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 16);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Thursday is the 13th, the first day of the teenth week")
    public void testThursteenthOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 13);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Thursday is the 19th, the last day of the teenth week")
    public void testThursteenthOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 19);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Friday is the 19th, the last day of the teenth week")
    public void testFriteenthOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 19);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Friday is some day in the middle of the teenth week")
    public void testFriteenthOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 16);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Friday is the 13th, the first day of the teenth week")
    public void testFriteenthOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 13);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Saturday is some day in the middle of the teenth week")
    public void testSaturteenthOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 16);
        Meetup meetup = new Meetup(2, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Saturday is the 13th, the first day of the teenth week")
    public void testSaturteenthOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 13);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Saturday is the 19th, the last day of the teenth week")
    public void testSaturteenthOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 19);
        Meetup meetup = new Meetup(10, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Sunday is the 19th, the last day of the teenth week")
    public void testSunteenthOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 19);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Sunday is some day in the middle of the teenth week")
    public void testSunteenthOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 16);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when teenth Sunday is the 13th, the first day of the teenth week")
    public void testSunteenthOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 13);
        Meetup meetup = new Meetup(10, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.TEENTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Monday is some day in the middle of the first week")
    public void testFirstMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 4);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Monday is the 1st, the first day of the first week")
    public void testFirstMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 1);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Tuesday is the 7th, the last day of the first week")
    public void testFirstTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 7);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Tuesday is some day in the middle of the first week")
    public void testFirstTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 4);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Wednesday is some day in the middle of the first week")
    public void testFirstWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 3);
        Meetup meetup = new Meetup(7, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Wednesday is the 7th, the last day of the first week")
    public void testFirstWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 7);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Thursday is some day in the middle of the first wee")
    public void testFirstThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 5);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Thursday is another day in the middle of the first week")
    public void testFirstThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 3);
        Meetup meetup = new Meetup(10, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Friday is the 1st, the first day of the first week")
    public void testFirstFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 1);
        Meetup meetup = new Meetup(11, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Friday is some day in the middle of the first week")
    public void testFirstFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 6);
        Meetup meetup = new Meetup(12, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Saturday is some day in the middle of the first week")
    public void testFirstSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 5);
        Meetup meetup = new Meetup(1, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Saturday is another day in the middle of the first week")
    public void testFirstSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 2);
        Meetup meetup = new Meetup(2, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Sunday is some day in the middle of the first week")
    public void testFirstSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 3);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Sunday is the 7th, the last day of the first week")
    public void testFirstSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 7);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Monday is some day in the middle of the second week")
    public void testSecondMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 11);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Monday is the 8th, the first day of the second week")
    public void testSecondMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 8);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Tuesday is the 14th, the last day of the second week")
    public void testSecondTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 14);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Tuesday is some day in the middle of the second week")
    public void testSecondTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 11);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Wednesday is some day in the middle of the second week")
    public void testSecondWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 10);
        Meetup meetup = new Meetup(7, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Wednesday is the 14th, the last day of the second week")
    public void testSecondWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 14);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Thursday is some day in the middle of the second week")
    public void testSecondThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 12);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Thursday is another day in the middle of the second week")
    public void testSecondThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 10);
        Meetup meetup = new Meetup(10, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Friday is the 8th, the first day of the second week")
    public void testSecondFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 8);
        Meetup meetup = new Meetup(11, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Friday is some day in the middle of the second week")
    public void testSecondFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 13);
        Meetup meetup = new Meetup(12, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Saturday is some day in the middle of the second week")
    public void testSecondSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 12);
        Meetup meetup = new Meetup(1, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Saturday is another day in the middle of the second week")
    public void testSecondSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 9);
        Meetup meetup = new Meetup(2, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Sunday is some day in the middle of the second week")
    public void testSecondSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 10);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when second Sunday is the 14th, the last day of the second week")
    public void testSecondSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 14);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.SECOND)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Monday is some day in the middle of the third week")
    public void testThirdMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 18);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Monday is the 15th, the first day of the third week")
    public void testThirdMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 15);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Tuesday is the 21st, the last day of the third week")
    public void testThirdTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 21);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Tuesday is some day in the middle of the third week")
    public void testThirdTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 18);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Wednesday is some day in the middle of the third week")
    public void testThirdWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 17);
        Meetup meetup = new Meetup(7, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Wednesday is the 21st, the last day of the third week")
    public void testThirdWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 21);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Thursday is some day in the middle of the third week")
    public void testThirdThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 19);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Thursday is another day in the middle of the third week")
    public void testThirdThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 17);
        Meetup meetup = new Meetup(10, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Friday is the 15th, the first day of the third week")
    public void testThirdFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 15);
        Meetup meetup = new Meetup(11, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Friday is some day in the middle of the third week")
    public void testThirdFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 20);
        Meetup meetup = new Meetup(12, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Saturday is some day in the middle of the third week")
    public void testThirdSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 19);
        Meetup meetup = new Meetup(1, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Saturday is another day in the middle of the third week")
    public void testThirdSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 16);
        Meetup meetup = new Meetup(2, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Sunday is some day in the middle of the third week")
    public void testThirdSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 17);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when third Sunday is the 21st, the last day of the third week")
    public void testThirdSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 21);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.THIRD)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Monday is some day in the middle of the fourth week")
    public void testFourthMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 25);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Monday is the 22nd, the first day of the fourth week")
    public void testFourthMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 22);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Tuesday is the 28th, the last day of the fourth week")
    public void testFourthTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 28);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Tuesday is some day in the middle of the fourth week")
    public void testFourthTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 25);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Wednesday is some day in the middle of the fourth week")
    public void testFourthWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 24);
        Meetup meetup = new Meetup(7, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Wednesday is the 28th, the last day of the fourth week")
    public void testFourthWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 28);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Thursday is some day in the middle of the fourth week")
    public void testFourthThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 26);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Thursday is another day in the middle of the fourth week")
    public void testFourthThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 24);
        Meetup meetup = new Meetup(10, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Friday is the 22nd, the first day of the fourth week")
    public void testFourthFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 22);
        Meetup meetup = new Meetup(11, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Friday is some day in the middle of the fourth week")
    public void testFourthFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 27);
        Meetup meetup = new Meetup(12, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Saturday is some day in the middle of the fourth week")
    public void testFourthSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 26);
        Meetup meetup = new Meetup(1, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Saturday is another day in the middle of the fourth week")
    public void testFourthSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 23);
        Meetup meetup = new Meetup(2, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Sunday is some day in the middle of the fourth week")
    public void testFourthSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 24);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when fourth Sunday is the 28th, the last day of the fourth week")
    public void testFourthSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 28);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.FOURTH)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Monday in a month with four Mondays")
    public void testLastMondayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 25);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Monday in a month with five Mondays")
    public void testLastMondayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 29);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.MONDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Tuesday in a month with four Tuesdays")
    public void testLastTuesdayOfMay2013() {
        LocalDate expected = LocalDate.of(2013, 5, 28);
        Meetup meetup = new Meetup(5, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Tuesday in another month with four Tuesdays")
    public void testLastTuesdayOfJune2013() {
        LocalDate expected = LocalDate.of(2013, 6, 25);
        Meetup meetup = new Meetup(6, 2013);
        assertThat(meetup.day(DayOfWeek.TUESDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Wednesday in a month with five Wednesdays")
    public void testLastWednesdayOfJuly2013() {
        LocalDate expected = LocalDate.of(2013, 7, 31);
        Meetup meetup = new Meetup(7, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Wednesday in a month with four Wednesdays")
    public void testLastWednesdayOfAugust2013() {
        LocalDate expected = LocalDate.of(2013, 8, 28);
        Meetup meetup = new Meetup(8, 2013);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Thursday in a month with four Thursdays")
    public void testLastThursdayOfSeptember2013() {
        LocalDate expected = LocalDate.of(2013, 9, 26);
        Meetup meetup = new Meetup(9, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Thursday in a month with five Thursdays")
    public void testLastThursdayOfOctober2013() {
        LocalDate expected = LocalDate.of(2013, 10, 31);
        Meetup meetup = new Meetup(10, 2013);
        assertThat(meetup.day(DayOfWeek.THURSDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Friday in a month with five Fridays")
    public void testLastFridayOfNovember2013() {
        LocalDate expected = LocalDate.of(2013, 11, 29);
        Meetup meetup = new Meetup(11, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Friday in a month with four Fridays")
    public void testLastFridayOfDecember2013() {
        LocalDate expected = LocalDate.of(2013, 12, 27);
        Meetup meetup = new Meetup(12, 2013);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Saturday in a month with four Saturdays")
    public void testLastSaturdayOfJanuary2013() {
        LocalDate expected = LocalDate.of(2013, 1, 26);
        Meetup meetup = new Meetup(1, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Saturday in another month with four Saturdays")
    public void testLastSaturdayOfFebruary2013() {
        LocalDate expected = LocalDate.of(2013, 2, 23);
        Meetup meetup = new Meetup(2, 2013);
        assertThat(meetup.day(DayOfWeek.SATURDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Sunday in a month with five Sundays")
    public void testLastSundayOfMarch2013() {
        LocalDate expected = LocalDate.of(2013, 3, 31);
        Meetup meetup = new Meetup(3, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Sunday in a month with four Sundays")
    public void testLastSundayOfApril2013() {
        LocalDate expected = LocalDate.of(2013, 4, 28);
        Meetup meetup = new Meetup(4, 2013);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when last Wednesday in February in a leap year is the 29th")
    public void testLastWednesdayOfFebruary2012() {
        LocalDate expected = LocalDate.of(2012, 2, 29);
        Meetup meetup = new Meetup(2, 2012);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last Wednesday in December that is also the last day of the year")
    public void testLastWednesdayOfDecember2014() {
        LocalDate expected = LocalDate.of(2014, 12, 31);
        Meetup meetup = new Meetup(12, 2014);
        assertThat(meetup.day(DayOfWeek.WEDNESDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when last Sunday in February in a non-leap year is not the 29th")
    public void testLastSundayOfFebruary2015() {
        LocalDate expected = LocalDate.of(2015, 2, 22);
        Meetup meetup = new Meetup(2, 2015);
        assertThat(meetup.day(DayOfWeek.SUNDAY, MeetupSchedule.LAST)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("when first Friday is the 7th, the last day of the first week")
    public void testFirstFridayOfDecember2012() {
        LocalDate expected = LocalDate.of(2012, 12, 7);
        Meetup meetup = new Meetup(12, 2012);
        assertThat(meetup.day(DayOfWeek.FRIDAY, MeetupSchedule.FIRST)).isEqualTo(expected);
    }
}
