import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;

class SalonCalendar {

    public LocalDate standingAppointment(int year, Month month, int occurrence, DayOfWeek dayOfWeek) {
        throw new UnsupportedOperationException("Please implement the SalonCalendar.standingAppointment() method");
    }

    public LocalDate lastAppointment(int year, Month month, DayOfWeek dayOfWeek) {
        throw new UnsupportedOperationException("Please implement the SalonCalendar.lastAppointment() method");
    }

    public LocalDate nextAvailable(LocalDate from, DayOfWeek dayOfWeek) {
        throw new UnsupportedOperationException("Please implement the SalonCalendar.nextAvailable() method");
    }

    public LocalDate bookkeepingDay(int year, Month month) {
        throw new UnsupportedOperationException("Please implement the SalonCalendar.bookkeepingDay() method");
    }

    public LocalDate payday(int year, Month month) {
        throw new UnsupportedOperationException("Please implement the SalonCalendar.payday() method");
    }

    public TemporalAdjuster precedingWorkday() {
        throw new UnsupportedOperationException("Please implement the SalonCalendar.precedingWorkday() method");
    }
}
