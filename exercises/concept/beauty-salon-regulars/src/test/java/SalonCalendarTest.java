import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class SalonCalendarTest {

    private final SalonCalendar calendar = new SalonCalendar();

    @Test
    @Tag("task:1")
    @DisplayName("Second Tuesday of August 2024")
    public void testStandingAppointmentSecondTuesday() {
        var expected = LocalDate.of(2024, 8, 13);

        assertThat(calendar.standingAppointment(2024, Month.AUGUST, 2, DayOfWeek.TUESDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("First Monday of September 2024")
    public void testStandingAppointmentFirstMonday() {
        var expected = LocalDate.of(2024, 9, 2);

        assertThat(calendar.standingAppointment(2024, Month.SEPTEMBER, 1, DayOfWeek.MONDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("Fourth Friday of November 2024")
    public void testStandingAppointmentFourthFriday() {
        var expected = LocalDate.of(2024, 11, 22);

        assertThat(calendar.standingAppointment(2024, Month.NOVEMBER, 4, DayOfWeek.FRIDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Last Friday of August 2024")
    public void testLastAppointmentFriday() {
        var expected = LocalDate.of(2024, 8, 30);

        assertThat(calendar.lastAppointment(2024, Month.AUGUST, DayOfWeek.FRIDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Last Monday of May 2024")
    public void testLastAppointmentMonday() {
        var expected = LocalDate.of(2024, 5, 27);

        assertThat(calendar.lastAppointment(2024, Month.MAY, DayOfWeek.MONDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Last Sunday of February in a leap year")
    public void testLastAppointmentSundayInLeapFebruary() {
        var expected = LocalDate.of(2024, 2, 25);

        assertThat(calendar.lastAppointment(2024, Month.FEBRUARY, DayOfWeek.SUNDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Next Saturday later in the same week")
    public void testNextAvailableLaterInWeek() {
        var thursday = LocalDate.of(2024, 8, 15);
        var expected = LocalDate.of(2024, 8, 17);

        assertThat(calendar.nextAvailable(thursday, DayOfWeek.SATURDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Next Saturday when asked on a Saturday is the same day")
    public void testNextAvailableSameDay() {
        var saturday = LocalDate.of(2024, 8, 17);

        assertThat(calendar.nextAvailable(saturday, DayOfWeek.SATURDAY)).isEqualTo(saturday);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Next Saturday when asked on a Sunday is in the following week")
    public void testNextAvailableNextWeek() {
        var sunday = LocalDate.of(2024, 8, 18);
        var expected = LocalDate.of(2024, 8, 24);

        assertThat(calendar.nextAvailable(sunday, DayOfWeek.SATURDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Next Monday crosses into the following month")
    public void testNextAvailableCrossesMonth() {
        var friday = LocalDate.of(2024, 8, 30);
        var expected = LocalDate.of(2024, 9, 2);

        assertThat(calendar.nextAvailable(friday, DayOfWeek.MONDAY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Bookkeeping day is the last day of the month when it is a weekday")
    public void testBookkeepingDayOnWeekday() {
        var expected = LocalDate.of(2024, 9, 30);

        assertThat(calendar.bookkeepingDay(2024, Month.SEPTEMBER)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Bookkeeping day moves to Friday when the month ends on a Saturday")
    public void testBookkeepingDayOnSaturday() {
        var expected = LocalDate.of(2024, 8, 30);

        assertThat(calendar.bookkeepingDay(2024, Month.AUGUST)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Bookkeeping day moves to Friday when the month ends on a Sunday")
    public void testBookkeepingDayOnSunday() {
        var expected = LocalDate.of(2024, 6, 28);

        assertThat(calendar.bookkeepingDay(2024, Month.JUNE)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Bookkeeping day in February of a leap year")
    public void testBookkeepingDayInLeapFebruary() {
        var expected = LocalDate.of(2024, 2, 29);

        assertThat(calendar.bookkeepingDay(2024, Month.FEBRUARY)).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Preceding workday adjuster keeps a weekday")
    public void testPrecedingWorkdayKeepsWeekday() {
        var thursday = LocalDate.of(2024, 8, 15);

        assertThat(thursday.with(calendar.precedingWorkday())).isEqualTo(thursday);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Preceding workday adjuster moves a Saturday to Friday")
    public void testPrecedingWorkdayMovesSaturday() {
        var saturday = LocalDate.of(2024, 6, 15);
        var expected = LocalDate.of(2024, 6, 14);

        assertThat(saturday.with(calendar.precedingWorkday())).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Preceding workday adjuster moves a Sunday to Friday")
    public void testPrecedingWorkdayMovesSunday() {
        var sunday = LocalDate.of(2024, 9, 15);
        var expected = LocalDate.of(2024, 9, 13);

        assertThat(sunday.with(calendar.precedingWorkday())).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Payday is the 15th when it is a weekday")
    public void testPaydayOnWeekday() {
        var expected = LocalDate.of(2024, 8, 15);

        assertThat(calendar.payday(2024, Month.AUGUST)).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Payday moves to Friday when the 15th is a Saturday")
    public void testPaydayOnSaturday() {
        var expected = LocalDate.of(2024, 6, 14);

        assertThat(calendar.payday(2024, Month.JUNE)).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Payday moves to Friday when the 15th is a Sunday")
    public void testPaydayOnSunday() {
        var expected = LocalDate.of(2024, 9, 13);

        assertThat(calendar.payday(2024, Month.SEPTEMBER)).isEqualTo(expected);
    }
}
