# Design

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: Verify that the solution is not wrapping all the code in a try catch statement
- `actionable`: If the solution uses an `if` statement, instruct the student to use the `switch case` statement instead.
- `informative`: If the solution does not use `HashMap`, instruct the student to use the operator as a key and a BiFunction implementing the calculation
  Explain that it is more efficient for performance, and it removes the cyclomatic complexity
- `informative`: If the solution does not throw the exception for `Operation cannot be null` and `Operation cannot be empty` at the beginning, instruct the student to do so
  Explain that it is better to fail fast, and it will make the code less error-prone and more readable

[analyzer]: https://github.com/exercism/java-analyzer