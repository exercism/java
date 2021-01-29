import java.time.LocalDateTime;
import java.time.LocalDate;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(1000000000);
    }

}
