# Design

## Goal

The goal of this exercise is to teach the student the basics of programming in Java.

## Learning objectives

- Know what a variable is.
- Know how to define a variable.
- Know how to update a variable.
- Know how to define a method.
- Know how to return a value from a method.
- Know how to call a method.
- Know that methods must be defined in classes.
- Know about the `public` access modifier.
- Know how to define an integer.
- Know how to use mathematical operators on integers.
- Know how to define single and multiline comments.

## Out of scope

- Naming rules for identifiers.
- Generic values.
- Memory and performance characteristics.
- Method overloads.
- Nested methods.
- Lambda's.
- Named parameters.
- Optional parameters.
- Classes.
- Visibility.

## Concepts

The Concepts this exercise unlocks are:

- `basics`: know what a variable is; know how to define a variable; know how to update a variable; know how to define a method; know how to return a value from a method; know how to call a method; know that methods must be defined in classes; know about the `public` access modifier; know how to define an integer; know how to use mathematical operators on integers; know how to define single- and multiline comments.

## Prerequisites

There are no prerequisites.

## Representer

This exercise does not require any specific representation logic to be added to the [representer][representer].

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the student did not reuse the implementation of the `expectedMinutesInOven` method in the `remainingMinutesInOven` method, instruct them to do so.
  Explain that reusing existing code instead of copy-pasting can help make code easier to maintain.
- `actionable`: If the student did not reuse the implementation of the `preparationTimeInMinutes` method in the `totalTimeInMinutes` method, instruct them to do so.
  Explain that reusing existing code instead of copy-pasting can help make code easier to maintain.
- `actionable`: If the student left any `// TODO: ...` comments in the code, instruct them to remove these.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
[representer]: https://github.com/exercism/java-representer
