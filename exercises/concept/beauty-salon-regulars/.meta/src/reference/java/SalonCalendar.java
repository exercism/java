import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class SalonCalendar {

    public LocalDate standingAppointment(int year, Month month, int occurrence, DayOfWeek dayOfWeek) {
        return LocalDate.of(year, month, 1).with(TemporalAdjusters.dayOfWeekInMonth(occurrence, dayOfWeek));
    }

    public LocalDate lastAppointment(int year, Month month, DayOfWeek dayOfWeek) {
        return LocalDate.of(year, month, 1).with(TemporalAdjusters.lastInMonth(dayOfWeek));
    }

    public LocalDate nextAvailable(LocalDate from, DayOfWeek dayOfWeek) {
        return from.with(TemporalAdjusters.nextOrSame(dayOfWeek));
    }

    public LocalDate bookkeepingDay(int year, Month month) {
        return LocalDate.of(year, month, 1)
            .with(TemporalAdjusters.lastDayOfMonth())
            .with(precedingWorkday());
    }

    public LocalDate payday(int year, Month month) {
        return LocalDate.of(year, month, 15).with(precedingWorkday());
    }

    public TemporalAdjuster precedingWorkday() {
        return temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.from(temporal);
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                return temporal.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            }
            return temporal;
        };
    }
}
