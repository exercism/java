import java.time.Instant;

// Students: implement a fixed-window rate limiter here.
// Intentionally minimal starter: you will choose state and logic.
public class RateLimiter<K> {

    // Provide a blank constructor so the class compiles.
    public RateLimiter(int limit, long windowSizeNanos, TimeSource timeSource) {
        // students implement
    }

    public boolean allow(K key) {
        throw new UnsupportedOperationException("Please implement RateLimiter.allow()");
    }
}
