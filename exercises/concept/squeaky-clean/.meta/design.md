# Design

## Learning objectives

- Know of the existence of the `char` type.
- Know what a char represents (a Unicode character).
- Know how to define a `char`.
- Know that a `char` is not the same as a single character string
- Know how to access a `char` in a string by index.
- Know of some basic `char` methods (like converting to uppercase).
- Know that `char`s are immutable.
- Know how to compare characters.
- Know how to use a `StringBuilder`.

## Out of scope

- Handling control characters and unicode characters.
- Advanced unicode issues such as surrogates, text normalization, combining characters.
- Cultural considerations and invariants.

## Concepts

- `chars`: know of the existence of the `char` type; know that a `char` represents; know how to define a `char`; know how to access a `char` in a string by index; know of some basic `char` methods (like converting to uppercase).
- `StringBuilder`: know how to use this.

## Prerequisites

- `strings`: know of the `string` type that will be iterated over and accessed by index.
- `for-loop` for loops (rather than foreach) are the best means of highlighting the relationship between strings and `char`s

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the solution did not use `Character.isWhitespace`, instruct the student to do so, because this concept intends to teach the character concept and methods.
- `actionable`: If the solution did not use `Character.isDigit`, instruct the student to do so.
- `actionable`: If the solution did not use `Character.isLetter`, instruct the student to do so.
- `actionable`: If the solution did not use `Character.toUpperCase`, instruct the student to do so.
- `informative`: If the solution uses string concatenation instead of `StringBuilder`, inform the student that this cause a small performance and memory penalty compared to `StringBuilder`.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
