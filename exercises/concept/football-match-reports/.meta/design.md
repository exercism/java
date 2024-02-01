# Design

## Learning objectives

- Know the existence of the `Switch` statement.
- Know how to use the switch statement.
- Recognize the keywords `switch`, `case`, `break` and `default`.

## Out of scope

- Nested switch statements
- Advanced switch statements features like using object as case values.

## Concepts

- `switch`: know the existence of the `Switch` statement, how to use it and how to apply the basic keywords.

## Prerequisites

This exercise's prerequisites Concepts are:

- `classes`: know how to work with classes.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: If the student resolved the exercise without using `switch`, instruct them to do so.
- `actionable`: If the solution returns the same value in different cases, instruct them that this could be simplified.

  ```java
  switch(shirtNum) {
      case 6, 7, 8:
          return "midfielder";
  }
  ```

- `actionable`: If the student does not directly return the answer from the case in the switch statement, instruct them to do so.
- `informative`: If the solution is returning the answer inside the cases, inform the student that it can be simplified by using a switch expression:

  ```java
  return switch(shirtNum) {
      case 6, 7, 8 -> "midfielder";
  }
  ```

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
