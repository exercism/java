import java.time.Duration;
import java.time.Instant;

/**
 * NOTE: There is no need to change this file and is treated as read only by the Exercism test runners.
 */
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
