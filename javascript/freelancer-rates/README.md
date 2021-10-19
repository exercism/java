# Freelancer Rates

Welcome to Freelancer Rates on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Numbers

Many programming languages have specific numeric types to represent different types of numbers, but JavaScript only has two:

- `number`: a numeric data type in the double-precision 64-bit floating point format (IEEE 754).
  Examples are `-6`, `-2.4`, `0`, `0.1`, `1`, `3.14`, `16.984025`, `25`, `976`, `1024.0` and `500000`.
- `bigint`: a numeric data type that can represent _integers_ in the arbitrary precision format.
  Examples are `-12n`, `0n`, `4n`, and `9007199254740991n`.

If you require arbitrary precision or work with extremely large numbers, use the `bigint` type.
Otherwise, the `number` type is likely the better option.

## Arithmetic Operators

JavaScript provides 6 different operators to perform basic arithmetic operations on numbers.

- `+`: The addition operator is used to find sum of numbers.
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
  4 ** 3; // => 62
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

## Instructions

In this exercise you will be writing code to help a freelancer communicate with a project manager by providing a few utility functions to quickly calculate day- and month rates, optionally with a given discount.

We first establish a few rules between the freelancer and the project manager:

- The daily rate is 8 times the hourly rate;
- A month has 22 billable days.

If the freelancer bills the project manager per month or more, there is a discount applied. This can be handy if the project manager has a fixed budget.

Discounts are modeled as fractional numbers (percentage) between `0.0` (`0%`, no discount) and `0.90` (`90%`, maximum discount).

## 1. Calculate the day rate given an hourly rate

Implement a function to calculate the day rate given an hourly rate:

```javascript
dayRate(89);
// => 712
```

The day rate does not need to be rounded or changed to a "fixed" precision.

## 2. Calculate the month rate, given an hourly rate and a discount

Implement a function to calculate the month rate, and apply a discount:

```javascript
monthRate(89, 0.42);
// => 9086
```

The discount is always passed as a number, where `42%` becomes `0.42`. The result _must_ be rounded up to the nearest whole number.

## 3. Calculate the number of workdays given a budget, rate and discount

Implement a function that takes a budget, a rate per hour and a discount, and calculates how many full days of work that covers.

```javascript
daysInBudget(20000, 89, 0.2002);
// => 35
```

The discount is always passed as a `number`. `20.02%` is passed as `0.2002`. The result is the number of days should be rounded down to full days of work.

## Source

### Created by

- @SleeplessByte