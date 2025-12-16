import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        //  throw new UnsupportedOperationException("Please implement the AppointmentScheduler.schedule() method");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(appointmentDateDescription, formatter);

        DateTimeFormatter printer = DateTimeFormatter.ofPattern("yyyy, MM, dd, HH, mm, ss");
        printer.format(date);
        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), date.getHour(), date.getMinute(), date.getSecond());
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        // throw new UnsupportedOperationException("Please implement the AppointmentScheduler.hasPassed() method");
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        //  throw new UnsupportedOperationException("Please implement the AppointmentScheduler.isAfternoonAppointment() method");
        return appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        //  throw new UnsupportedOperationException("Please implement the AppointmentScheduler.getDescription() method");
        DateTimeFormatter printer = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a'.'");
        return "You have an appointment on "+printer.format(appointmentDate);
    }

    public LocalDate getAnniversaryDate() {
        //  throw new UnsupportedOperationException("Please implement the AppointmentScheduler.getAnniversaryDate() method");
        return LocalDate.of(LocalDate.now().getYear(), 9,15);
    }
}
