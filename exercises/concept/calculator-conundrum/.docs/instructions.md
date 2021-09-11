# Instructions

In this exercise you will be building error handling for a simple integer calculator. To make matters simple, methods for calculating addition, multiplication and division are provided.

The goal is to have a working calculator that returns a string with the following pattern: `16 + 51 = 67`, when provided with arguments `16`, `51` and `+`.


```java
CalculatorConundrum obj = new CalculatorConundrum();

CalculatorConundrum.calculate(16, 51, "+"); // => returns "16 + 51 = 67"

obj.calculate(32, 6, "*"); // => returns "32 * 6 = 192"

obj.calculate(512, 4, "/"); // => returns "512 / 4 = 128"
```

## 1. Handle the code that may throw errors within the method Calculate

The main method for implementation in this task will be the `CalculatorConundrum.calculate()` method. It takes three arguments. The first two arguments are integer numbers on which an operation is going to be conducted. The third argument is of type string and for this exercise it is necessary to implement the following operations:

- addition using the `+` string
- multiplication using the `*` string
- division using the `/` string

## 2. Handle illegal operations

Any other operation symbol, or if the operation argument is an empty string, or when `null` is provided as an operation argument, then the method should throw the custom provided `IllegalOperationException` exception.

## 3. Handle the thrown DivideByZero exceptions

When an `ArithmeticException` exception gets thrown, the handling code should throw `IllegalOperationException` with the message `Divide by zero operation illegal` and `ArithmeticException` as cause. This should be handled using `try-catch` block. Any other exception should not be handled by the `CalulatorConundrum.calculate()` method.

```java
CalculatorConundrum.calculate(512, 0, "/"); // => returns "Division by zero is not allowed."
```
