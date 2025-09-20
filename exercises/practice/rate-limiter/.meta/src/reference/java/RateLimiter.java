import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter<K> {

    private static final class WindowState {
        Instant windowStart;
        int usedCount;

        WindowState(Instant windowStart, int usedCount) {
            this.windowStart = windowStart;
            this.usedCount = usedCount;
        }
    }

    private final int limit;
    private final Duration windowSize;
    private final TimeSource timeSource;
    private final Map<K, WindowState> states = new HashMap<>();

    public RateLimiter(int limit, Duration windowSize, TimeSource timeSource) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.timeSource = timeSource;
    }

    public boolean allow(K key) {
        Instant now = timeSource.now();

        WindowState s = states.get(key);
        if (s == null) {
            s = new WindowState(now, 0);
            states.put(key, s);
        }

        if (!now.isBefore(s.windowStart.plus(windowSize))) {
            s.windowStart = now;
            s.usedCount = 0;
        }

        if (s.usedCount < limit) {
            s.usedCount += 1;
            return true;
        }
        return false;
    }
}
