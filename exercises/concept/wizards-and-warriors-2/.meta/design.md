# Design

## Goal

The goal of this exercise is to teach the student the basics of the Concept of `Method Overloading` in Java.

## Learning objectives

- Know what method overloading is.
- Know how to overload a method with different number of parameters
- Know how to overload a method with different argument types

## Concepts

- `method-overloading`

## Prerequisites

This exercise's prerequisites Concepts are:

- `classes`
- `strings`
- `enums`

## Representer

This exercise does not require any specific representation logic to be added to the [representer][representer-java].

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the student does not reuse the methods `describe(Character)`, `describe(Destination)` or `describe(TravelMethod)` to solve the `describe(Character, Destination, TravelMethod)` method, instruct them to do so.
- `actionable`: If the student does not reuse the method `describe(Character)`, `describe(Destination)`, `describe(TravelMethod)` or `describe(Character, Destination, TravelMethod)` to solve the `describe(Character, Destination)` method, instruct them to do so.
- `informative`: If the solution uses `String.format` in any of the `describe` methods, inform the student that this cause a small performance penalty compared to string concatenation.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[representer-java]: https://github.com/exercism/java-representer
[analyzer]: https://github.com/exercism/java-analyzer
