import java.time.Instant;

public class RateLimiter<K> {

    public RateLimiter(int limit, long windowSizeNanos, TimeSource timeSource) {

    }

    public boolean allow(K key) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
