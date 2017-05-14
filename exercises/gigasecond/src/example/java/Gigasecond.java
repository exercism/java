import java.time.LocalDateTime;
import java.time.LocalDate;

class Gigasecond {

    private LocalDateTime initialDateTime;

    Gigasecond(LocalDate initialDate) {
        this.initialDateTime = initialDate.atTime(0, 0);
    }

    Gigasecond(LocalDateTime initialDateTime) {
        this.initialDateTime = initialDateTime;
    }

    LocalDateTime getDate() {
        return initialDateTime.plusSeconds(1000000000);
    }

}
