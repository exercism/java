# Two Fer

`Two-fer` or `2-fer` is short for two for one. One for you and one for me.

Given a name, return a string with the message:

```text
One for X, one for me.
```

Where X is the given name.

However, if the name is missing, return the string:

```text
One for you, one for me.
```

Here are some examples:

|Name    |String to return 
|:-------|:------------------
|Alice   |One for Alice, one for me. 
|Bob     |One for Bob, one for me.
|        |One for you, one for me.
|Zaphod  |One for Zaphod, one for me.

# Tips

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

## Source

[https://github.com/exercism/problem-specifications/issues/757](https://github.com/exercism/problem-specifications/issues/757)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
