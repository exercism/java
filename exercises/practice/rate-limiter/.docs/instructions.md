What this exercise is about

You will build a fixed‑window rate limiter: a small component that restricts how many
operations each key may perform within a fixed period of time (a “window”).

What you should implement

- Implement a single method in `src/main/java/FixedWindowRateLimiter.java`:
  - `public boolean allow(K key)` — decide whether to allow the operation for the key
    and update the limiter’s internal state accordingly.

Everything else (interfaces and constructor) is provided for you.
