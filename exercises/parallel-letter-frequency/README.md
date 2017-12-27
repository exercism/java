# Parallel Letter Frequency

Count the frequency of letters in texts using parallel computation.

Parallelism is about doing things in parallel that can also be done
sequentially. A common example is counting the frequency of letters.
Create a function that returns the total frequency of each letter in a
list of texts and that employs parallelism.

# Java Tips

Single-threaded (non-concurrent) solutions can pass all tests [but the last.](https://www.youtube.com/watch?v=mJZZNHekEQw)  Your solution will be tested for concurrency by submitting it as a [Runnable](https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html) to an [ExecutorService.](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html) Your solution must leverage multiple [Threads](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html) to pass the final test.

Java documentation on [parallel streams](https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html) may provide some help.

As a stretch goal, consider if your implementation will work for characters with [diacritics or accents](https://en.wikipedia.org/wiki/Diacritic). For example, such solutions should not consider e and ë the same character. An example text for this case is [Wilhelmus](https://en.wikipedia.org/wiki/Wilhelmus), the Dutch national anthem.

# Running the tests

You can run all the tests for an exercise by entering

```sh
$ gradle test
```

in your terminal.


## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have completed the exercise.
