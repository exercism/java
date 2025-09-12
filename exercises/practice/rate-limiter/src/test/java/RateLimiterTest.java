import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateLimiterTest {

    @Test
    void allowsUpToLimitThenDeniesUntilBoundary() {
        TimeSource.Fake clock = new TimeSource.Fake(0L);
        RateLimiter<String> limiter = new FixedWindowRateLimiter<>(3, 10_000L, clock);

        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("A")).isFalse();

        // Just before boundary: still same window
        clock.advance(9_999L);
        assertThat(limiter.allow("A")).isFalse();

        // At exact boundary: new window
        clock.advance(1L);
        assertThat(limiter.allow("A")).isTrue();
    }

    @Test
    void continuesCountingWithinWindowAfterBoundaryReset() {
        TimeSource.Fake clock = new TimeSource.Fake(0L);
        RateLimiter<String> limiter = new FixedWindowRateLimiter<>(2, 5_000L, clock);

        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isFalse();

        // Jump to next window
        clock.advance(5_000L);
        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isTrue();
        assertThat(limiter.allow("key")).isFalse();
    }

    @Test
    void separateKeysHaveIndependentCountersAndWindows() {
        TimeSource.Fake clock = new TimeSource.Fake(42L);
        RateLimiter<String> limiter = new FixedWindowRateLimiter<>(1, 100L, clock);

        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("B")).isTrue(); // independent key
        assertThat(limiter.allow("A")).isFalse();
        assertThat(limiter.allow("B")).isFalse();

        clock.advance(100L); // new window for both at boundary
        assertThat(limiter.allow("A")).isTrue();
        assertThat(limiter.allow("B")).isTrue();
    }

    @Test
    void longGapsResetWindowDeterministically() {
        TimeSource.Fake clock = new TimeSource.Fake(1_000L);
        RateLimiter<String> limiter = new FixedWindowRateLimiter<>(2, 50L, clock);

        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isFalse();

        // Advance several windows worth
        clock.advance(1_000L);
        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isTrue();
        assertThat(limiter.allow("X")).isFalse();
    }

    @Test
    void exactBoundaryIsNewWindowEveryTime() {
        TimeSource.Fake clock = new TimeSource.Fake(0L);
        RateLimiter<String> limiter = new FixedWindowRateLimiter<>(1, 10L, clock);

        assertThat(limiter.allow("k")).isTrue();
        assertThat(limiter.allow("k")).isFalse();

        // Move exactly to boundary repeatedly; each time should allow once
        for (int i = 0; i < 5; i++) {
            clock.advance(10L);
            assertThat(limiter.allow("k")).isTrue();
            assertThat(limiter.allow("k")).isFalse();
        }
    }
}
