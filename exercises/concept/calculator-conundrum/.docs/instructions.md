# Instructions

In this exercise you will be building error handling for a simple integer calculator. To make matters simple, methods for calculating addition, multiplication and division are provided.

The goal is to have a working calculator that returns a string with the following pattern: `16 + 51 = 67`, when provided with arguments `16`, `51` and `+`.

<!---
TODO
-->
```csharp
CalculatorConundrum.calc(16, 51, "+"); // => returns "16 + 51 = 67"

CalculatorConundrum.calc(32, 6, "*"); // => returns "32 * 6 = 192"

CalculatorConundrum.calculate(512, 4, "/"); // => returns "512 / 4 = 128"
```

## 1. Handle the code that may throw errors within the method Calculate

The main method for implementation in this task will be the (_static_) `SimpleCalculator.Calculate()` method. It takes three arguments. The first two arguments are integer numbers on which an operation is going to be conducted. The third argument is of type string and for this exercise it is necessary to implement the following operations:

- addition using the `+` string
- multiplication using the `*` string
- division using the `/` string

## 2. Handle illegal operations

Any other operation symbol should throw the `ArgumentOutOfRangeException` exception. If the operation argument is an empty string, then the method should throw the `ArgumentException` exception. When `null` is provided as an operation argument, then the method should throw the `ArgumentNullException` exception. This functionality and handling of operations should be contained in a `try` block.

## 3. Handle the thrown DivideByZero exceptions

When a `ArithmeticException` exception gets thrown, the handling code should return the string with the content `Division by zero is not allowed.`. Any other exception should not be handled by the `SimpleCalculator.Calculate()` method.

```csharp
SimpleCalculator.Calculate(512, 0, "/"); // => returns "Division by zero is not allowed."
```
