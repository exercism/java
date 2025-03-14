# Design

## Goal

The goal of this exercise is to teach the student how to use the Optional API.
We will use the most common methods: `ifPresent`, `orElse`, `ifPresentOrElse`, `orElseThrow`.
The `isPresent` and `get` methods are not presented, since they do not provide any value over an ordinary null check.

## Learning objectives

- Know what optional types are.
- Know how to use Optional<T> fields.
- Know how to use methods that return an Optional<T> type.
- See the utility of some Stream methods, `flatMap` specifically.

## Out of scope

- Streams API.

## Concepts

This Concepts Exercise's Concepts are:

- `Optional<T>` class and some methods that mimic a null check.

## Prerequisites

This Concept Exercise's prerequisites Concepts are:

- `custom classes`.
- `lists`.
- `generic-types`.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: If the solution uses `null` in any method, encourage the student to use `Optional<T>` instead.
- `actionable`: If the solution uses the `get` or `isPresent` methods of the Optional<T> API, encourage the student to use `orElse`, `orElseThrow` or `ifPresentOrElse` instead.
- `informative`: TODO.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
