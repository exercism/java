# Two Fer

`Two-fer` or `2-fer` is short for two for one. One for you and one for me.

```
"One for X, one for me."
```

When X is a name or "you".

If the given name is "Alice", the result should be "One for Alice, one for me."
If no name is given, the result should be "One for you, one for me."


## Test-Driven Development

As programmers mature, they eventually want to test their code.

Here at Exercism we simulate [Test-Driven
Development](http://en.wikipedia.org/wiki/Test-driven_development) (TDD), where
you write your tests before writing any functionality. The simulation comes in
the form of a pre-written test suite, which will signal that you have solved
the problem.

It will also provide you with a safety net to explore other solutions without
breaking the functionality.

### A typical TDD workflow on Exercism:

1. Run the test file and pick one test that's failing.
2. Write some code to fix the test you picked.
3. Re-run the tests to confirm the test is now passing.
4. Repeat from step 1.
5. Submit your solution (`exercism submit /path/to/file`)

## Instructions

Submissions are encouraged to be general, within reason. Having said that, it's
also important not to over-engineer a solution.

It's important to remember that the goal is to make code as expressive and
readable as we can.

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



To run the tests:

```sh
$ gradle test
```

For more detailed info about the Java track see the [help page](http://exercism.io/languages/java).


## Source

This is an exercise to introduce users to basic programming constructs, just after hello World. [https://en.wikipedia.org/wiki/Two-fer](https://en.wikipedia.org/wiki/Two-fer)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
