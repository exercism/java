import java.time.Duration;
import java.time.Instant;

public class TimeSource {
    private Instant now;

    public TimeSource(Instant start) {
        this.now = start;
    }

    public Instant now() {
        return now;
    }

    public void advance(Duration d) {
        this.now = this.now.plus(d);
    }
}
