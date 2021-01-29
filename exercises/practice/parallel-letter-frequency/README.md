# Parallel Letter Frequency

Count the frequency of letters in texts using parallel computation.

Parallelism is about doing things in parallel that can also be done
sequentially. A common example is counting the frequency of letters.
Create a function that returns the total frequency of each letter in a
list of texts and that employs parallelism.

# Tips

Single-threaded (non-concurrent) solutions can pass all tests but you should try to implement the solution using parallelism.
You can do this by using multiple [Threads](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html).

Java documentation on [parallel streams](https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html) may provide some help.

As a stretch goal, consider if your implementation will work for characters with [diacritics or accents](https://en.wikipedia.org/wiki/Diacritic). For example, such solutions should not consider e and ë the same character. An example text for this case is [Wilhelmus](https://en.wikipedia.org/wiki/Wilhelmus), the Dutch national anthem.


## Setup

Go through the setup instructions for Java to install the necessary
dependencies:

[https://exercism.io/tracks/java/installation](https://exercism.io/tracks/java/installation)

# Running the tests

You can run all the tests for an exercise by entering the following in your
terminal:

```sh
$ gradle test
```

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore("Remove to run test")` annotation.


## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
