import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class RateLimiterTest {

    @Test
    void allowsUpToLimit() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter = new RateLimiter<>(3, Duration.ofNanos(10_000L), clock);

        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    void denyCloseToBoundary() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter = new RateLimiter<>(2, Duration.ofNanos(10_000L), clock);

        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isFalse();

        // Just before boundary: still same window
        clock.advance(Duration.ofNanos(9_999L));
        assertThat(limiter.allow("A")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    void allowsNewBoundary() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter = new RateLimiter<>(2, Duration.ofNanos(10_000L), clock);

        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isFalse();

        // At exact boundary: new window
        clock.advance(Duration.ofNanos(10_000L));
        assertThat(limiter.allow("A")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    void continuesCountingWithinWindowAfterBoundaryReset() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter = new RateLimiter<>(2, Duration.ofNanos(5_000L), clock);

        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isFalse();

        // Jump to next window
        clock.advance(Duration.ofNanos(5_000L));
        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    void separateKeysHaveIndependentCountersAndWindows() {
        TimeSource clock = new TimeSource(Instant.EPOCH.plusNanos(42L));
        RateLimiter<String> limiter = new RateLimiter<>(1, Duration.ofNanos(100L), clock);

        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isFalse();
        assertThat(limiter.allow("B")).isTrue(); // independent key
        assertThat(limiter.allow("B")).isFalse();

        clock.advance(Duration.ofNanos(100L)); // new window for both at boundary
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("B")).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    void longGapsResetWindow() {
        TimeSource clock = new TimeSource(Instant.EPOCH.plusNanos(1_000L));
        RateLimiter<String> limiter = new RateLimiter<>(2, Duration.ofNanos(50L), clock);

        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isFalse();

        // Advance several windows worth
        clock.advance(Duration.ofNanos(1_000L));
        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    void exactBoundaryIsNewWindowEveryTime() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter = new RateLimiter<>(1, Duration.ofNanos(10L), clock);

        assertThat(limiter.allow("k")).isTrue();
        assertThat(limiter.allow("k")).isFalse();

        // Move exactly to boundary repeatedly; each time should allow once
        for (int i = 0; i < 5; i++) {
            clock.advance(Duration.ofNanos(10L));
            assertThat(limiter.allow("k")).isTrue();
            assertThat(limiter.allow("k")).isFalse();
        }
    }


    @Disabled("Remove to run test")
    @Test
    void supportsUuidKeys() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<UUID> limiter = new RateLimiter<>(1, Duration.ofNanos(100L), clock);

        UUID a = UUID.fromString("00000000-0000-0000-0000-000000000001");
        UUID b = UUID.fromString("00000000-0000-0000-0000-000000000002");

        assertThat(limiter.allow(a)).isTrue();
        assertThat(limiter.allow(a)).isFalse();
        assertThat(limiter.allow(b)).isTrue();
        assertThat(limiter.allow(b)).isFalse();

        clock.advance(Duration.ofNanos(100L));
        assertThat(limiter.allow(a)).isTrue();
        assertThat(limiter.allow(b)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    void supportsIntegerKeys() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<Integer> limiter = new RateLimiter<>(1, Duration.ofNanos(100L), clock);

        assertThat(limiter.allow(42)).isTrue();
        assertThat(limiter.allow(42)).isFalse();
        assertThat(limiter.allow(84)).isTrue(); // independent key of different type
        assertThat(limiter.allow(84)).isFalse();

        clock.advance(Duration.ofNanos(100L)); // boundary resets both
        assertThat(limiter.allow(42)).isTrue();
        assertThat(limiter.allow(84)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    void supportsLongKeys() {
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<Long> limiter = new RateLimiter<>(2, Duration.ofNanos(50L), clock);

        assertThat(limiter.allow(1L)).isTrue();
        assertThat(limiter.allow(1L)).isTrue();
        assertThat(limiter.allow(1L)).isFalse();

        assertThat(limiter.allow(2L)).isTrue(); // independent key
        assertThat(limiter.allow(2L)).isTrue();
        assertThat(limiter.allow(2L)).isFalse();

        clock.advance(Duration.ofNanos(50L));
        assertThat(limiter.allow(1L)).isTrue();
        assertThat(limiter.allow(2L)).isTrue();
    }
}
