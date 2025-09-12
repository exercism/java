import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter<K> implements RateLimiter<K> {

    private static final class WindowState {
        long windowStartNanos;
        int usedCount;

        WindowState(long windowStartNanos, int usedCount) {
            this.windowStartNanos = windowStartNanos;
            this.usedCount = usedCount;
        }
    }

    private final int limit;
    private final long windowSizeNanos;
    private final TimeSource timeSource;
    private final Map<K, WindowState> states = new HashMap<>();

    public FixedWindowRateLimiter(int limit, long windowSizeNanos, TimeSource timeSource) {
        this.limit = limit;
        this.windowSizeNanos = windowSizeNanos;
        this.timeSource = timeSource;
    }

    @Override
    public boolean allow(K key) {
        long now = timeSource.nowNanos();
        WindowState s = states.get(key);
        if (s == null) {
            s = new WindowState(now, 0);
            states.put(key, s);
        }

        long elapsed = now - s.windowStartNanos;
        if (elapsed >= windowSizeNanos) {
            s.windowStartNanos = now;
            s.usedCount = 0;
        }

        if (s.usedCount < limit) {
            s.usedCount += 1;
            return true;
        }
        return false;
    }
}

