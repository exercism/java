# Design

## Learning objectives

- Know of the existence of the `null` literal.
- Know what a `NullPointerException` is and when it is thrown.
- Know how to compare a value to `null`.

## Out of scope

- `java.util.Optional`

## Concepts

- `nullability`

## Prerequisites

- `strings`: strings will be compared to null and basic methods from strings will be called.
- `if-else-statements`: using a conditional statement.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the solution uses `Optionals` to solve the exercise, encourage the student to try solving it using `null` instead.
- `informative`: If the solution uses `String.format`, instruct the student to use simple string concatenation instead.
  Explain that `String.format` is significantly slower than concatenating strings and should be used in more complex scenarios.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
