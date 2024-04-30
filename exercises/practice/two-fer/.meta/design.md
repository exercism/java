# Design

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: Verify that the solution does not hard-code the names used by the tests (`Alice`, `Bob`).
- `actionable`: If the solution contains more than one `return` statement, instruct the student to try and only use one.
  Using multiple `return` statements in this exercise could be an indication of code duplication, as it probably contains the sentence twice:

  ```java
  String twofer(String name) {
      if (name == null) {
          return "One for you, one for me."
      }

      return "One for " + name + ", one for me."
  }
  ```

- `actionable`: If the solution uses an `if` statement, instruct the student to use a ternary expression instead.
- `informative`: If the solution uses `String.format`, instruct the student to use simple string concatenation instead.
  Explain that `String.format` is significantly slower than concatenating strings and should be used in more complex scenarios.

[analyzer]: https://github.com/exercism/java-analyzer
