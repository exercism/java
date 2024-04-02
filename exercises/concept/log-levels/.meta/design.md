# Design

## Learning objectives

- Know of the existence of the `String` type.
- Know how to create a string.
- Know of some basic string methods (like finding the index of a character at a position, or returning a part the string).
- Know how to do basic string formatting.

## Out of scope

- Using standard or custom format strings.
- Memory and performance characteristics.
- Strings can be enumerated.

## Concepts

- `strings`: know of the existence of the `String` type; know of some basic functions (like looking up a character at a position, or slicing the string); know how to do basic string formatting.

## Prerequisites

This exercise's prerequisites Concepts are:

- `basics`: know how to define methods.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: Verify that the solution does not hard-code the log levels (`[ERROR]:`, `[WARNING]:`, `[INFO]:`)
- `actionable`: If the student did not reuse the implementation of the `message` and `logLevel` methods in the `reformat` method, instruct them to do so.
- `actionable`: If the solution did not use `split` or `substring` in the methods `message` and `logLevel`, instruct the student to do so.
- `informative`: If the solution uses `String.format` in the `reformat` method, inform the student that this cause a small performance penalty compared to string concatenation.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
