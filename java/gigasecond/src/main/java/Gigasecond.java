import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Gigasecond {

    private LocalDateTime t;

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        t = moment;
    }

    public LocalDateTime getDateTime() {
        return t.plus(1_000_000_000, ChronoUnit.SECONDS);
    }
}
