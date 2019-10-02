# Hangman

Implement the logic of the hangman game using functional reactive programming.

[Hangman][] is a simple word guessing game.

[Functional Reactive Programming][frp] is a way to write interactive
programs. It differs from the usual perspective in that instead of
saying "when the button is pressed increment the counter", you write
"the value of the counter is the sum of the number of times the button
is pressed."

Implement the basic logic behind hangman using functional reactive
programming.  You'll need to install an FRP library for this, this will
be described in the language/track specific files of the exercise.

[Hangman]: https://en.wikipedia.org/wiki/Hangman_%28game%29
[frp]: https://en.wikipedia.org/wiki/Functional_reactive_programming

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
