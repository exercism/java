# Instructions

In this exercise you will be building error handling for a simple integer calculator. 
To make matters simple, methods for calculating addition, multiplication and division are provided.

The goal is to have a working calculator that returns a String with the following pattern: `16 + 51 = 67`, when provided with arguments `16`, `51` and `+`.

```java
CalculatorConundrum obj = new CalculatorConundrum();

obj.calculate(16, 51, "+"); // => returns "16 + 51 = 67"

obj.calculate(32, 6, "*"); // => returns "32 * 6 = 192"

obj.calculate(512, 4, "/"); // => returns "512 / 4 = 128"
```

## 1. Implement the method calculate to support a few basic operations 

The main method for implementation in this task will be the `CalculatorConundrum.calculate()` method. 
It takes three arguments. 
The first two arguments are integer numbers on which an operation is going to operate. 
The third argument is of type String and for this exercise it is necessary to implement the following operations:

- addition using the `+` String
- multiplication using the `*` String
- division using the `/` String

## 2. Handle illegal operations

All the following cases need to throw an `IllegalOperationException`:

* when the `operation` argument is `null`, with the String `Operation cannot be null` as the`message` parameter 
* when the `operation` is the empty String, with the String `Operation cannot be empty` as the `message` parameter
* when the `operation` argument is anything other than `+`, `*`, or `/`,  with the String `{invalidOperation} operation does not exist` as the `message` parameter

## 3. Handle the thrown DivideByZero exceptions

Dividing by zero throws an `ArithmeticException` which the calculator needs to catch and then throw an `IllegalOperationException` with the message `Divide by zero operation illegal` and the `ArithmeticException` as its cause.
This should be handled using a `try-catch` block. 
Any other exception should not be handled by the `CalulatorConundrum.calculate()` method.

```java
CalculatorConundrum.calculate(512, 0, "/"); // => throws IllegalOperationException with message "Division by zero is not allowed."
```
