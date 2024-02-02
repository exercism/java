# Design

## Learning objectives

- Know of the existence of the `boolean` type and its two values.
- Know about boolean operators and how to build logical expressions with them.
- Know of the boolean operator precedence rules.

## Out of scope

Nothing to report

## Concepts

- `booleans`: know of the existence of the `boolean` type and its two values; know about boolean operators and how to build logical expressions with them; know of the boolean operator precedence rules.

## Prerequisites

- `basics`: know how to define methods.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: If student returns a boolean literal, tell them it is possible to directly return the result of a expression. For example:

  ```java
  // instead of
  if (knightIsAwake) {
    return true;
  } else {
    return false;
  }

  // ... return the expression directly
  return knightIsAwake;
  ```

- `essential`: If the student compares a boolean variable with a boolean literal (e.g. `knightIsAwake == true` or `archerIsAwake == false`), tell them this can be simplified to just the variables (e.g. `knightIsAwake` or `archerIsAwake`).
- `essential`: If the student uses an `if` statement or the ternary operator, tell them this exercise was to explore booleans and boolean operators and this exercise can be solved without them.
- `informative`: If the student uses an `||` expression to OR two smaller expressions and either expression is surrounded by parentheses and only ANDs some terms together (e.g. `knightIsAwake || (archerIsAwake && !prisonerIsAwake)`), tell them the parentheses is unnecessary because `&&` has the higher precedence over `||`.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
