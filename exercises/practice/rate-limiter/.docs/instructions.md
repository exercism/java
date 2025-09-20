Your task is to build a fixed‑window rate limiter.

Imagine a single server connected to one or more clients.
A client sends a request, the server does some work, and returns a response.
But processing takes time.
If a client sends too many requests too quickly, the server can become overwhelmed — everything slows down or fails.

A rate limiter is a small component that decides whether to allow or reject a request based on how frequently that client has been making requests.
Different strategies exist; in this exercise you’ll implement a fixed‑window rate limiter.

Fixed‑window rate limiting groups time into equal‑length windows (for example, every 10 seconds) and allows up to a certain number of requests within each window for each client.
Once the window resets, the allowance refreshes for the next window.
Each client is tracked separately.

Examples:
- Limit: 3 requests per 10 seconds per client.
  - A client’s first three requests in the same window are allowed; a fourth is rejected.
  - After the window resets, the next request is allowed again and the counting starts fresh.
