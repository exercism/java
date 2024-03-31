# Design

## Learning objectives

- Know of the existence of the two most commonly used number types, `int` and `double`.
- Understand that an `int` represents whole numbers, and a `double` represents floating-point numbers.
- Know of basic operators such as multiplication, comparison and equality.
- Know how to convert from one numeric type to another; know what implicit and explicit conversions are.
- Know how to conditionally execute code using an `if` statement.

## Out of scope

- Any other numeric types besides `int` and `double` (so no `float`, `byte`, etc.).
- Parsing a `string` to an `int` or `double`.
- Converting an `int` or `double` to a `string`.

## Concepts

- `numbers`: know of the existence of the two most commonly used number types, `int` and `double`; understand that the former represents whole numbers, and the latter floating-point numbers; know of basic operators such as multiplication, comparison and equality; know how to convert from one numeric type to another; know what implicit and explicit conversions are.
- `if-else-statements`: know how to conditionally execute code using an `if` statement.

## Prerequisites

This exercise's prerequisites Concepts are:

- `basics`: know how to define methods.
- `booleans`: know how to use boolean operators.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the student did not reuse the implementation of the `productionRatePerHour` method in the `workingItemsPerMinute` method, instruct them to do so.
- `informative`: If the solution is repeatedly hard-coding the value `221`, inform the student that they could store this value in a field to make the code easier to maintain.
- `informative`: If the solution has `if/else-if` statements in the `productionRatePerHour` method, inform the student that creating a helper method to calculate the succes rate might make their code easier to understand.
- `informative`: If the solution is using `if/else-if` logic that contains return statements, inform the students that the `else` keywords are redundant and that their code can become more clear by omitting them.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
