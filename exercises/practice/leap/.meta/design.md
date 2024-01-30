# Design

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: Verify that the solution does not use `java.time.Year.isLeap(int)` or `new java.util.GregorianCalendar().isLeapYear(int)`.
- `essential`: Verify that the solution does not contain hard-coded years used in the tests.
- `actionable`: If the solution uses conditional statements like `if/else` or ternary expressions, instruct the student to use simple boolean logic instead.
- `actionable`: If the solution contains more than 3 checks, instruct the student that their solution can be simplified.

[analyzer]: https://github.com/exercism/java-analyzer
