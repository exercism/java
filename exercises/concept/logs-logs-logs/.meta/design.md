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
    - `LogLevel`
        - `essential`: Verify that necessary and sufficient constants are present in enum declaration (minus unknown, for now) and that the constructor is present.
        - `actionable`: The enum should be public; prompt the student to think of encapsulation.
    - `LogLine.getLogLevel()`
       - `essential`: Verify that a switch statement was used. If they used if-else, comment that switch is better due to there being many cases.
       - `actionable`: The function should be public.
2. Support unknown log level
    - `essential`: Verify that an unknown constant is present in the enum declaration.
    - `essential`: Verify that a default was used in a switch statement. Comment as previously stated in the case of an if-else.
3. Convert log line to short format
    - `essential`: Verify that the constructor is appropriately updated.
    - `essential`: Verify that there exists a field dedicated to the encoded log level.
    - `actionable`: Said field should be private and final (this will then require the use of a getter for the log level!).
    - `LogLine.getOutputForShortLog()`
        - `celebratory`: Celebrate if this was written in one line.
        - `informative`: Let them know they can write it in one line.

[analyzer]: https://github.com/exercism/java-analyzer
