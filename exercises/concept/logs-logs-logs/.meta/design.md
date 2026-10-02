# Design

## Learning objectives

After completing this exercise, the student should:

- Know of the existence of the `enum` keyword.
- Know how to define enum members.
- Know how to add fields to enum types.
- Know how to add methods to enum types.

## Concepts

- `enums`: know of the existence of the `enum` keyword; know how to define enum members; know how to assign values to enum members.

## Prerequisites

This exercise's prerequisites Concepts are:

- `strings`
- `switch-statement`
- `constructors`

## Analyzer

This exercise could benefit from the following rules in the [analyzer][analyzer]:

1. Parse log level
    - `LogLine.getLogLevel()`
       - `actionable`: Verify that a switch statement was used. If they used if-else, comment that switch is better due to there being many cases.
2. Support unknown log level
    - `essential`: Verify that a default was used in a switch statement. Comment as previously stated in the case of an if-else.
3. Convert log line to short format
    - `essential`: Verify that there exists a field dedicated to the encoded log level.
    - `actionable`: Said field should be private and final (this will then require the use of a getter for the log level!).
    - `LogLine.getOutputForShortLog()`
        - `informative`: Let them know they can write it in one return statement.
- `celebratory`: Celebrate if the student's solution brought up no comments.

[analyzer]: https://github.com/exercism/java-analyzer
