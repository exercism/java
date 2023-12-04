import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentSchedulerTest {

    private final AppointmentScheduler scheduler = new AppointmentScheduler();

    @Test
    @Tag("task:1")
    @DisplayName("Scheduling a date")
    public void testSchedule() {
        var description = "07/25/2019 13:45:00";
        var expected = LocalDateTime.of(2019, 7, 25, 13, 45, 0);

        assertThat(scheduler.schedule(description)).isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment from one year ago has passed")
    public void testHasPassedOneYearAgo() {
        var oneYearAgo = LocalDateTime.now().minusYears(1).plusHours(2);

        assertThat(scheduler.hasPassed(oneYearAgo)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment from months ago has passed")
    public void testHasPassedMonthsAgo() {
        var monthsAgo = LocalDateTime.now().minusMonths(8);

        assertThat(scheduler.hasPassed(monthsAgo)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment from days ago has passed")
    public void testHasPassedDaysAgo() {
        var daysAgo = LocalDateTime.now().minusDays(23);

        assertThat(scheduler.hasPassed(daysAgo)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment from hours ago has passed")
    public void testHasPassedHoursAgo() {
        var hoursAgo = LocalDateTime.now().minusHours(12);

        assertThat(scheduler.hasPassed(hoursAgo)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment from minutes ago has passed")
    public void testHasPassedMinutesAgo() {
        var minutesAgo = LocalDateTime.now().minusMinutes(55);

        assertThat(scheduler.hasPassed(minutesAgo)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment from one minute ago has passed")
    public void testHasPassedOneMinuteAgo() {
        var oneMinuteAgo = LocalDateTime.now().minusMinutes(1);

        assertThat(scheduler.hasPassed(oneMinuteAgo)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment minutes from now has not passed")
    public void testHasPassedMinutesFromNow() {
        var minutesAgo = LocalDateTime.now().plusMinutes(5);

        assertThat(scheduler.hasPassed(minutesAgo)).isFalse();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment hours from now has not passed")
    public void testHasPassedHoursFromNow() {
        var hoursFromNow = LocalDateTime.now().plusHours(3);

        assertThat(scheduler.hasPassed(hoursFromNow)).isFalse();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment days from now has not passed")
    public void testHasPassedDaysFromNow() {
        var daysFromNow = LocalDateTime.now().plusDays(19);

        assertThat(scheduler.hasPassed(daysFromNow)).isFalse();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment months from now has not passed")
    public void testHasPassedMonthsFromNow() {
        var monthsFromNow = LocalDateTime.now().plusMonths(10);

        assertThat(scheduler.hasPassed(monthsFromNow)).isFalse();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Appointment years from now has not passed")
    public void testHasPassedYearsFromNow() {
        var yearsFromNow = LocalDateTime.now().plusYears(2).plusMonths(3).plusDays(6);

        assertThat(scheduler.hasPassed(yearsFromNow)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("Early morning appointment is not an afternoon appointment")
    public void testIsAfternoonAppointmentForEarlyMorningAppointment() {
        var appointment = LocalDateTime.of(2019, 6, 17, 8, 15, 0);

        assertThat(scheduler.isAfternoonAppointment(appointment)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("Late morning appointment is not an afternoon appointment")
    public void testIsAfternoonAppointmentForLateMorningAppointment() {
        var appointment = LocalDateTime.of(2019, 2, 23, 11, 59, 59);

        assertThat(scheduler.isAfternoonAppointment(appointment)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("Noon appointment is an afternoon appointment")
    public void testIsAfternoonAppointmentForNoonAppointment() {
        var appointment = LocalDateTime.of(2019, 8, 9, 12, 0, 0);

        assertThat(scheduler.isAfternoonAppointment(appointment)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("Early afternoon appointment is an afternoon appointment")
    public void testIsAfternoonAppointmentForEarlyAfternoonAppointment() {
        var appointment = LocalDateTime.of(2019, 8, 9, 12, 0, 1);

        assertThat(scheduler.isAfternoonAppointment(appointment)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("Late morning appointment is an afternoon appointment")
    public void testIsAfternoonAppointmentForLateAfternoonAppointment() {
        var appointment = LocalDateTime.of(2019, 9, 1, 17, 59, 59);

        assertThat(scheduler.isAfternoonAppointment(appointment)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("Early evening appointment is not an afternoon appointment")
    public void testIsAfternoonAppointmentForEarlyEveningAppointment() {
        var appointment = LocalDateTime.of(2019, 9, 1, 18, 0, 0);

        assertThat(scheduler.isAfternoonAppointment(appointment)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("Late evening appointment is not an afternoon appointment")
    public void testIsAfternoonAppointmentForLateEveningAppointment() {
        var appointment = LocalDateTime.of(2019, 9, 1, 23, 59, 59);

        assertThat(scheduler.isAfternoonAppointment(appointment)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("Description on Friday afternoon")
    public void testDescriptionOnFridayAfternoon() {
        var appointment = LocalDateTime.of(2019, 3, 29, 15, 0, 0);
        var expected = "You have an appointment on Friday, March 29, 2019, at 3:00 PM.";

        assertThat(scheduler.getDescription(appointment)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Description on Thursday afternoon")
    public void testDescriptionOnThursdayAfternoon() {
        var appointment = LocalDateTime.of(2019, 7, 25, 13, 45, 0);
        var expected = "You have an appointment on Thursday, July 25, 2019, at 1:45 PM.";

        assertThat(scheduler.getDescription(appointment)).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Description on Wednesday morning")
    public void testDescriptionOnWednesdayMorning() {
        var appointment = LocalDateTime.of(2020, 9, 9, 9, 9, 9);
        var expected = "You have an appointment on Wednesday, September 9, 2020, at 9:09 AM.";

        assertThat(scheduler.getDescription(appointment)).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The anniversary date")
    public void testAnniversaryDate() {
        var expected = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);

        assertThat(scheduler.getAnniversaryDate()).isEqualTo(expected);
    }
}
