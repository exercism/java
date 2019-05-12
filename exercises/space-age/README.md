# Space Age

Given an age in seconds, calculate how old someone would be on:

   - Earth: orbital period 365.25 Earth days, or 31557600 seconds
   - Mercury: orbital period 0.2408467 Earth years
   - Venus: orbital period 0.61519726 Earth years
   - Mars: orbital period 1.8808158 Earth years
   - Jupiter: orbital period 11.862615 Earth years
   - Saturn: orbital period 29.447498 Earth years
   - Uranus: orbital period 84.016846 Earth years
   - Neptune: orbital period 164.79132 Earth years

So if you were told someone were 1,000,000,000 seconds old, you should
be able to say that they're 31.69 Earth-years old.

If you're wondering why Pluto didn't make the cut, go watch [this
youtube video](http://www.youtube.com/watch?v=Z_2gbGXzFbs).

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

## Source

Partially inspired by Chapter 1 in Chris Pine's online Learn to Program tutorial. [http://pine.fm/LearnToProgram/?Chapter=01](http://pine.fm/LearnToProgram/?Chapter=01)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
