# Freelancer Rates

Welcome to Freelancer Rates on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Numbers

Many programming languages have specific numeric types to represent different types of numbers, but JavaScript only has two:

- `number`: a numeric data type in the double-precision 64-bit floating-point format (IEEE 754).
  Examples are `-6`, `-2.4`, `0`, `0.1`, `1`, `3.14`, `16.984025`, `25`, `976`, `1024.0` and `500000`.
- `bigint`: a numeric data type that can represent _integers_ in the arbitrary precision format.
  Examples are `-12n`, `0n`, `4n`, and `9007199254740991n`.

If you require arbitrary precision or work with extremely large numbers, use the `bigint` type.
Otherwise, the `number` type is likely the better option.

### Rounding

There is a built-in global object called `Math` that provides various [rounding functions][ref-math-object-rounding]. For example, you can round down (`floor`) or round up (`ceil`) decimal numbers to the nearest whole numbers.

```javascript
Math.floor(234.34); // => 234
Math.ceil(234.34); // => 235
```

## Arithmetic Operators

JavaScript provides 6 different operators to perform basic arithmetic operations on numbers.

- `+`: The addition operator is used to find the sum of numbers.
- `-`: The subtraction operator is used to find the difference between two numbers
- `*`: The multiplication operator is used to find the product of two numbers.
- `/`: The division operator is used to divide two numbers.

```javascript
2 - 1.5; //=> 0.5
19 / 2; //=> 9.5
```

- `%`: The remainder operator is used to find the remainder of a division performed.

  ```javascript
  40 % 4; // => 0
  -11 % 4; // => -3
  ```

- `**`: The exponentiation operator is used to raise a number to a power.

  ```javascript
  4 ** 3; // => 64
  4 ** 1 / 2; // => 2
  ```

### Order of Operations

When using multiple operators in a line, JavaScript follows an order of precedence as shown in [this precedence table][mdn-operator-precedence].
To simplify it to our context, JavaScript uses the PEDMAS (Parentheses, Exponents, Division/Multiplication, Addition/Subtraction) rule we've learnt in elementary math classes.

<!-- prettier-ignore-start -->
```javascript
const result = 3 ** 3 + 9 * 4 / (3 - 1);
// => 3 ** 3 + 9 * 4/2
// => 27 + 9 * 4/2
// => 27 + 18
// => 45
```
<!-- prettier-ignore-end -->

### Shorthand Assignment Operators

Shorthand assignment operators are a shorter way of writing code conducting arithmetic operations on a variable, and assigning the new value to the same variable.
For example, consider two variables `x` and `y`.
Then, `x += y` is same as `x = x + y`.
Often, this is used with a number instead of a variable `y`.
The 5 other operations can also be conducted in a similar style.

```javascript
let x = 5;
x += 25; // x is now 30

let y = 31;
y %= 3; // y is now 1
```

[mdn-operator-precedence]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_Precedence#table
[ref-math-object-rounding]: https://javascript.info/number#rounding

## Instructions

In this exercise you will be writing code to help a freelancer communicate with their clients about the prices of certain projects. You will write a few utility functions to quickly calculate the costs for the clients.

## 1. Calculate the day rate given an hourly rate

A client contacts the freelancer to enquire about their rates.
The freelancer explains that they **_work 8 hours a day._**
However, the freelancer knows only their hourly rates for the project.
Help them estimate a day rate given an hourly rate.

```javascript
dayRate(89);
// => 712
```

The day rate does not need to be rounded or changed to a "fixed" precision.

## 2. Calculate the number of workdays given a fixed budget

Another day, a project manager offers the freelancer to work on a project with a fixed budget.
Given the fixed budget and the freelancer's hourly rate, help them calculate the number of days they would work until the budget is exhausted.
The result _must_ be **rounded down** to the nearest whole number.

```javascript
daysInBudget(20000, 89);
// => 28
```

## 3. Calculate the discounted rate for large projects

Often, the freelancer's clients hire them for projects spanning over multiple months.
In these cases, the freelancer decides to offer a discount for every full month, and the remaining days are billed at day rate.
**_Every month has 22 billable days._**
Help them estimate their cost for such projects, given an hourly rate, the number of days the project spans, and a monthly discount rate.
The discount is always passed as a number, where `42%` becomes `0.42`. The result _must_ be **rounded up** to the nearest whole number.

```javascript
priceWithMonthlyDiscount(89, 230, 0.42);
// => 97972
```

## Source

### Created by

- @SleeplessByte
- @JaPatGitHub

### Contributed to by

- @junedev