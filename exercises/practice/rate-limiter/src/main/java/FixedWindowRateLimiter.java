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
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}

