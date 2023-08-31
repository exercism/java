# Instructions

In this exercise you will be building error handling for a simple integer calculator.
To make matters simple, methods for calculating addition, multiplication and division are provided.

The goal is to have a working calculator that returns a String with the following pattern: `16 + 51 = 67`, when provided with arguments `16`, `51` and `+`.

```java
CalculatorConundrum calculator = new CalculatorConundrum();

calculator.calculate(16, 51, "+");
// => returns "16 + 51 = 67"

calculator.calculate(32, 6, "*");
// => returns "32 * 6 = 192"

calculator.calculate(512, 4, "/");
// => returns "512 / 4 = 128"
```

## 1. Implement the method calculate to support a few basic operations

The main method for implementation in this task will be the `CalculatorConundrum.calculate()` method.
It takes three arguments.
The first two arguments `operand1` and `operand2` are integer numbers on which an operation is going to operate.
The third argument `operation` is of type String and for this exercise it is necessary to implement the following operations:

- addition using the `+` String
- multiplication using the `*` String
- division using the `/` String

## 2. Handle illegal operations

Update the `CalculatorConundrum.calculate()` method to handle illegal operations:

- When the `operation` argument is `null`, an `IllegalArgumentException` should be thrown with the message `Operation cannot be null`.
- When the `operation` argument is `""`, an `IllegalArgumentException` should be thrown with the message `Operation cannot be empty`.
- When the `operation` argument is any operation other than `+`, `*`, or `/`, an `IllegalOperationException` should be thrown with the message `Operation '{operation}' does not exist`.

```java
calculator.calculate(10, 1, null);
// => throws IllegalArgumentException with message "Operation cannot be null"

calculator.calculate(10, 1, "");
// => throws IllegalArgumentException with message "Operation cannot be empty"

calculator.calculate(10, 1, "-");
// => throws IllegalOperationException with message "Operation '-' does not exist"
```

## 3. Handle the exception thrown when dividing by zero

In Java, attempting to divide by zero throws an `ArithmeticException`.
Update the `CalculatorConundrum.calculate()` method to catch this exception and then throw an `IllegalOperationException` with the message `Division by zero is not allowed` and the caught `ArithmeticException` as its cause.

```java
calculator.calculate(512, 0, "/");
// => throws IllegalOperationException with message "Division by zero is not allowed"
```
