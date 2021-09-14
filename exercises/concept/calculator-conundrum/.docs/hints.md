# Hints

## 1. Implement the method calculate to support a few basic operations

* Use a `switch-case` block to match different operations and implement them using the `SimpleOperation` class.

## 2. Handle illegal operations


* Check for `null` operations before the switch.
* Add a case to the switch for the empty String.
* Use a default for anything else at the end of the switch.
* Throw an `IllegalOpertionException` with appropriate messages in different cases.

## 3. Handle the thrown DivideByZero exceptions

* Use a `try-catch` block to catch `ArithmeticException`
* Pass both the `message` and the `ArithmeticException` as the `cause` parameter when throwing the exception.