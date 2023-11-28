import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {

    private static final LocalDate OPENING_DATE = LocalDate.of(2015, Month.SEPTEMBER, 15);

    public LocalDateTime schedule(String appointmentDateDescription) {
        var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH);
        return LocalDateTime.parse(appointmentDateDescription, formatter);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        var formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a", Locale.ENGLISH);
        return String.format("You have an appointment on %s.", formatter.format(appointmentDate));
    }

    public LocalDate getAnniversaryDate() {
        return OPENING_DATE.withYear(LocalDate.now().getYear());
    }
}
