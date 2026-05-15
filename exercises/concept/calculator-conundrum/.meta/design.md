# Design

## Learning Objectives

- Know the concept of exception handling in Java.
- Know how and when to throw an exception.
- Know how to catch an exception.

## Out of scope

- The `finally` keyword.

## Concepts

- `exceptions`: know what exceptions are, how and when to throw an exception, know how to catch an exception.

## Prerequisites

- `conditionals-if`: know how to do conditional logic.
- `switch-statement`: know how to work with a `switch` statement.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: Verify that the solution is using the try catch statement for the division.
- `actionable`: If the solution is wrapping all the code in a try catch statement, instruct the student to only use the `try catch` for the division statement
- `actionable`: If the solution uses only `if` statement, instruct the student that he/she can use the `switch case` statement to perform the operations.
- `informative`: If the solution does not throw the exception for `Operation cannot be null` and `Operation cannot be empty` at the beginning, suggest the fail-fast approach to the student.
  Inform this way of implementation can be less error-prone and more readable as suggested by Martin Fowler: <https://martinfowler.com/ieeeSoftware/failFast.pdf>

[analyzer]: https://github.com/exercism/java-analyzer
