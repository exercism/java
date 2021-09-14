# Hints

### 1. Implementing operations

* Use a `switch-case` block to match different operations and implement them using `SimpleOperation` class.

### 2. Handling invalid operation

* Check for `null` operation beforehand and the rest along-with the `switch-case` block.
* Throw an `IllegalOpertionException` with appropriate messages in different cases.

### 3. Handling Division by zero

* Use a `try-catch` block to catch `ArithmeticException`
* Pass both message and cause as argument when throwing exception.