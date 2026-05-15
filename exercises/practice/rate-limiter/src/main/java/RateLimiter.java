import java.time.Duration;
import java.time.Instant;

public class RateLimiter<K> {

    public RateLimiter(int limit, Duration windowSize, TimeSource timeSource) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public boolean allow(K clientId) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
