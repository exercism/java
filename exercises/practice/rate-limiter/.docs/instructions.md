# Instructions

Your task is to build a fixed‑window rate limiter.

Imagine a single server connected to one or more clients.
A client sends a request, the server does some work, and returns a response.
But processing takes time.
If a client sends too many requests too quickly, the server can become overwhelmed — everything slows down or fails.

A rate limiter is a small component that decides whether to allow or reject a request based on how frequently that client has been making requests.
Different strategies exist; in this exercise you’ll implement a fixed‑window rate limiter.

Fixed‑window rate limiting groups time into equal‑length windows (for example, every 10 seconds) and allows up to a certain number of requests within each window for each client.
Once the window resets, the allowance refreshes for the next window.
Each client is tracked separately, so another client can make requests within that same period.

For example, consider a rate limiter configured to limit 2 requests per 10 seconds per client.
Lets say a client sends a request:

- Being its first request, the request is permitted.
- A second request within 10 seconds after the first one is also permitted.
- However, further requests after that would be denied _until_ at least 10 seconds has elapsed since the first request.
- If a second client sends its first request within 10 seconds with of the first client's first request, it would also be permitted, _regardless_ of whether the first client has sent a second request.
