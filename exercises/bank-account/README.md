# Bank Account

Simulate a bank account supporting opening/closing, withdrawals, and deposits
of money. Watch out for concurrent transactions!

A bank account can be accessed in multiple ways. Clients can make
deposits and withdrawals using the internet, mobile phones, etc. Shops
can charge against the account.

Create an account that can be accessed from multiple threads/processes
(terminology depends on your programming language).

It should be possible to close an account; operations against a closed
account must fail.

## Instructions

Run the test file, and fix each of the errors in turn. When you get the
first test to pass, go to the first pending or skipped test, and make
that pass as well. When all of the tests are passing, feel free to
submit.

Remember that passing code is just the first step. The goal is to work
towards a solution that is as readable and expressive as you can make
it.

Have fun!

# Tips

This exercise introduces [concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html). 
To pass the last test you might find the 
[`synchronized` keyword or locks](https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html) useful.

Problems arising from running code concurrently are often intermittent because they depend on the order the code is
executed. Therefore the last test runs many [threads](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) 
several times to increase the chances of catching a bug. That means this test should fail if your implementation is not
[thread safe](https://en.wikipedia.org/wiki/Thread_safety), but there is a chance it will pass just because there was 
no concurrent modification attempt. It is unlikely that this will occur several times 
in a row since the order the code is executed should vary every time you run the test. So if you run the last test a 
couple of times and it passes every time then you can be reasonably sure that your implementation is correct.

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

> Use `gradlew.bat` if you're on Windows

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore("Remove to run test")` annotation.


## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
