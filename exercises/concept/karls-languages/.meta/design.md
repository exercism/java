# Design

## Goal

The goal of this exercise is to teach the student the basics of the Concept of Lists in Java.
We will use the list type to teach the student about generics too.
We should be using the list with more than one data type to show that is possible.

The list collection type was chosen as the first generic type for the following reasons:

- It is the most commonly used generic type.
- They are a common data type in many language.

## Learning objectives

- Know what generic types are.
- Know of the existence of the `List<T>` type.
- Know how a list is different from an array.
- Know how to define a list.
- Know how to add and remove elements from a list.
- Know how to access elements in a list by index.
- Know how to iterate over elements in a list.
- Know some basic list functions (like finding the index of an element in a list or sorting a list).

## Out of scope

- Generic functions.
- Generic constraints.
- Memory and performance characteristics.
- Concurrency issues.
- Co-/contravariance.
- Equality.
- List resizing due to it using an array as its data type.

## Concepts

This Concepts Exercise's Concepts are:

- `lists`: know of the existence of the `List<T>` type; know how a list is different from an array; know how to define a list; know how to add and remove elements from a list; know how to access elements in a list by index; know how to iterate over elements in a list; know some basic list functions (like finding the index of an element in a list).
- `generic-types`: know what generic types are.

## Prerequisites

This Concept Exercise's prerequisites Concepts are:

- `arrays`: know of the array collection type and that it has a fixed length.
- `strings`: data types used in this exercise

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the solution did not use `contains` in the method `containsLanguage`, instruct the student to do so.
- `actionable`: If the solution did not use `isEmpty` in the method `isEmpty`, instruct the student to do so.
- `informative`: If the student did not reuse the implementation of the `containsLanguage` method in the `isExciting` method, instruct them to do so.
  Explain that reusing existing code instead of copy-pasting can help make code easier to maintain.
- `informative`: If the solution uses an `if statement` in the `containsLanguage` method, instruct the student to return directly the `contains` method.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
