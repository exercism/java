# Hints

## 1. Implement the method calculate to support a few basic operations

- Use a `switch` statement to match different operations.

## 2. Handle illegal operations

- You cannot check for `null` inside a `switch` statement.
- Use a `default` case for anything else at the end of the switch.

## 3. Handle the exception thrown when dividing by zero

- Use a `try-catch` block to catch the `ArithmeticException` thrown when dividing by zero.
- The `IllegalOperationException` class has a constructor that takes a message and a cause as its parameters.
