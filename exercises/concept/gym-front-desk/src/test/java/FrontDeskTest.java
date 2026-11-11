import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

public class FrontDeskTest {

    private final FrontDesk frontDesk = new FrontDesk();

    @Test
    @Tag("task:1")
    @DisplayName("A one-month membership ends on the same day next month")
    public void testMembershipEndOneMonth() {
        var expected = LocalDate.of(2024, 4, 10);

        assertThat(frontDesk.membershipEnd(LocalDate.of(2024, 3, 10), 1)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("A twelve-month membership ends on the same day next year")
    public void testMembershipEndTwelveMonths() {
        var expected = LocalDate.of(2025, 3, 10);

        assertThat(frontDesk.membershipEnd(LocalDate.of(2024, 3, 10), 12)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("A membership starting on January 31st ends on the last day of February")
    public void testMembershipEndClampedToEndOfFebruary() {
        var expected = LocalDate.of(2025, 2, 28);

        assertThat(frontDesk.membershipEnd(LocalDate.of(2025, 1, 31), 1)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("A membership starting on January 31st ends on February 29th in a leap year")
    public void testMembershipEndClampedToEndOfFebruaryInLeapYear() {
        var expected = LocalDate.of(2024, 2, 29);

        assertThat(frontDesk.membershipEnd(LocalDate.of(2024, 1, 31), 1)).isEqualTo(expected);
    }

    @Test
    @Tag("task:1")
    @DisplayName("A three-month membership starting on August 31st ends on November 30th")
    public void testMembershipEndClampedToEndOfNovember() {
        var expected = LocalDate.of(2024, 11, 30);

        assertThat(frontDesk.membershipEnd(LocalDate.of(2024, 8, 31), 3)).isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Membership length in years, months and days")
    public void testMembershipLengthYearsMonthsAndDays() {
        var expected = Period.of(1, 2, 15);

        assertThat(frontDesk.membershipLength(LocalDate.of(2023, 3, 10), LocalDate.of(2024, 5, 25)))
            .isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Membership length in months and days")
    public void testMembershipLengthMonthsAndDays() {
        var expected = Period.of(0, 2, 5);

        assertThat(frontDesk.membershipLength(LocalDate.of(2024, 1, 15), LocalDate.of(2024, 3, 20)))
            .isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Membership length of exactly one year")
    public void testMembershipLengthExactlyOneYear() {
        var expected = Period.ofYears(1);

        assertThat(frontDesk.membershipLength(LocalDate.of(2024, 3, 10), LocalDate.of(2025, 3, 10)))
            .isEqualTo(expected);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Membership length is zero when it starts and ends on the same day")
    public void testMembershipLengthZero() {
        assertThat(frontDesk.membershipLength(LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 10)))
            .isEqualTo(Period.ZERO);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Days left within the same month")
    public void testDaysLeftSameMonth() {
        assertThat(frontDesk.daysLeft(LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 25))).isEqualTo(15);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Days left counts every day across several months")
    public void testDaysLeftAcrossMonths() {
        assertThat(frontDesk.daysLeft(LocalDate.of(2024, 1, 15), LocalDate.of(2024, 3, 20))).isEqualTo(65);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Days left across the end of the year")
    public void testDaysLeftAcrossYearEnd() {
        assertThat(frontDesk.daysLeft(LocalDate.of(2024, 12, 20), LocalDate.of(2025, 1, 10))).isEqualTo(21);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Days left includes February 29th in a leap year")
    public void testDaysLeftInLeapYear() {
        assertThat(frontDesk.daysLeft(LocalDate.of(2024, 2, 1), LocalDate.of(2024, 3, 1))).isEqualTo(29);
    }

    @Test
    @Tag("task:3")
    @DisplayName("No days left on the day the membership ends")
    public void testDaysLeftOnEndDate() {
        assertThat(frontDesk.daysLeft(LocalDate.of(2024, 3, 20), LocalDate.of(2024, 3, 20))).isEqualTo(0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("No days left after the membership has ended")
    public void testDaysLeftAfterEndDate() {
        assertThat(frontDesk.daysLeft(LocalDate.of(2024, 4, 2), LocalDate.of(2024, 3, 20))).isEqualTo(0);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Duration of an evening visit")
    public void testVisitDurationEvening() {
        var expected = Duration.ofMinutes(95);

        assertThat(frontDesk.visitDuration(
            LocalDateTime.of(2024, 3, 10, 18, 5),
            LocalDateTime.of(2024, 3, 10, 19, 40))).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Duration of a visit that goes past midnight")
    public void testVisitDurationPastMidnight() {
        var expected = Duration.ofMinutes(105);

        assertThat(frontDesk.visitDuration(
            LocalDateTime.of(2024, 3, 10, 23, 30),
            LocalDateTime.of(2024, 3, 11, 1, 15))).isEqualTo(expected);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Duration of a visit includes seconds")
    public void testVisitDurationWithSeconds() {
        var expected = Duration.ofMinutes(45).plusSeconds(59);

        assertThat(frontDesk.visitDuration(
            LocalDateTime.of(2024, 3, 10, 7, 0, 0),
            LocalDateTime.of(2024, 3, 10, 7, 45, 59))).isEqualTo(expected);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Format a visit of more than an hour")
    public void testFormatVisitHoursAndMinutes() {
        assertThat(frontDesk.formatVisit(Duration.ofMinutes(95))).isEqualTo("1h 35m");
    }

    @Test
    @Tag("task:5")
    @DisplayName("Format a visit with fewer than ten minutes past the hour")
    public void testFormatVisitPadsMinutes() {
        assertThat(frontDesk.formatVisit(Duration.ofHours(2).plusMinutes(5))).isEqualTo("2h 05m");
    }

    @Test
    @Tag("task:5")
    @DisplayName("Format a visit of less than an hour, ignoring seconds")
    public void testFormatVisitIgnoresSeconds() {
        assertThat(frontDesk.formatVisit(Duration.ofMinutes(45).plusSeconds(59))).isEqualTo("0h 45m");
    }

    @Test
    @Tag("task:5")
    @DisplayName("Format a visit of more than a day")
    public void testFormatVisitLongerThanADay() {
        assertThat(frontDesk.formatVisit(Duration.ofHours(26).plusMinutes(10))).isEqualTo("26h 10m");
    }

    @Test
    @Tag("task:5")
    @DisplayName("Format an empty visit")
    public void testFormatVisitZero() {
        assertThat(frontDesk.formatVisit(Duration.ZERO)).isEqualTo("0h 00m");
    }
}
