# Instructions append

Single-threaded (non-concurrent) solutions can pass all tests [but the last.](https://www.youtube.com/watch?v=mJZZNHekEQw)  Your solution will be tested for concurrency by submitting it as a [Runnable](https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html) to an [ExecutorService.](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html) Your solution must leverage multiple [Threads](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html) to pass the final test.

Java documentation on [parallel streams](https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html) may provide some help.

As a stretch goal, consider if your implementation will work for characters with [diacritics or accents](https://en.wikipedia.org/wiki/Diacritic). For example, such solutions should not consider e and ë the same character. An example text for this case is [Wilhelmus](https://en.wikipedia.org/wiki/Wilhelmus), the Dutch national anthem.
