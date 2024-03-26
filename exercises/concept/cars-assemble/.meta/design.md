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
- `informative`: If the solution is hardcoding the value `221`, inform the student that it could be great to extrapolate this value to a `private final` field to make a more readable code.
- `informative`: If the solution has `if/else-if` statements in the `productionRatePerHour` method, inform the student that it could be great to create a helper method to calculate the succes rate.
- `informative`: If the solution is using `if/else-if` logic that contain a return statements, inform the students that with separate if blocks you will achieve the same making the code more clear.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
