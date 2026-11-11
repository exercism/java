import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class FrontDesk {

    public LocalDate membershipEnd(LocalDate start, int months) {
        return start.plus(Period.ofMonths(months));
    }

    public Period membershipLength(LocalDate start, LocalDate end) {
        return Period.between(start, end);
    }

    public long daysLeft(LocalDate today, LocalDate end) {
        return Math.max(0, ChronoUnit.DAYS.between(today, end));
    }

    public Duration visitDuration(LocalDateTime checkIn, LocalDateTime checkOut) {
        return Duration.between(checkIn, checkOut);
    }

    public String formatVisit(Duration visit) {
        return String.format("%dh %02dm", visit.toHours(), visit.toMinutesPart());
    }
}
