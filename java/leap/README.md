# Leap

Welcome to Leap on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Given a year, report if it is a leap year.

The tricky thing here is that a leap year in the Gregorian calendar occurs:

```text
on every year that is evenly divisible by 4
  except every year that is evenly divisible by 100
    unless the year is also evenly divisible by 400
```

For example, 1997 is not a leap year, but 1996 is.  1900 is not a leap
year, but 2000 is.

## Notes

Though our exercise adopts some very simple rules, there is more to
learn!

For a delightful, four minute explanation of the whole leap year
phenomenon, go watch [this youtube video][video].

[video]: http://www.youtube.com/watch?v=xX96xng7sAE

Before you start, make sure you understand how to write code that can pass the test cases.
For more context, check out this [tutorial](https://github.com/exercism/java/blob/master/exercises/hello-world/TUTORIAL.md).

Most Java exercises include multiple test cases. These cases are structured to
support a useful process known as
[test-driven development (TDD)](https://en.wikipedia.org/wiki/Test-driven_development).
TDD involves repeating a structured cycle that helps programmers build complex
functionality piece by piece rather than all at once. That cycle can be
described as follows:

1. Add a test that describes one piece of desired functionality your code is
currently missing.
2. Run the tests to verify that this newly-added test fails.
3. Update your existing code until:
    - All the old tests continue to pass;
    - The new test also passes.
4. [Clean up](https://en.wikipedia.org/wiki/Code_refactoring) your code, making
sure that all tests continue to pass. This typically involves renaming
variables, removing duplicated chunks of logic, removing leftover logging, etc.
5. Return to step 1 until all desired functionality has been built!

The test files in this track contain _all_ the tests your solution should pass
to be considered valid. That doesn't immediately seem to be compatible with the
cycle described above, in which tests are written one by one. However, the
tool that we use to write our tests, [JUnit](http://junit.org), provides an
[@Ignore](http://junit.sourceforge.net/javadoc/org/junit/Ignore.html)
[annotation](https://docs.oracle.com/javase/tutorial/java/annotations/) that
can be used to temporarily skip an already-written test. Using this annotation,
we make sure that the test files we deliver to you satisfy the following rules:

- The first test in any test file is _not_ skipped by default.
- All but the first test in any test file _are_ skipped by default.

This allows you to simulate the TDD cycle by following these slightly-modified
steps:

1. Run the tests to verify that _at most one_ test currently fails.
2. Update your existing code until all the non-skipped tests pass.
3. Clean up your code, making sure that all non-skipped tests continue to pass.
4. Remove the topmost `@Ignore` annotation in the test file.
5. Return to step 1 until no tests are skipped and all tests pass!

## Source

### Created by

- @sonapraneeth-a

### Contributed to by

- @jmrunkle
- @lemoncurry
- @msomji
- @muzimuzhi
- @sshine

### Based on

JavaRanch Cattle Drive, exercise 3 - http://www.javaranch.com/leap.jsp