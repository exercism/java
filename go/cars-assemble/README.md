# Cars Assemble

Welcome to Cars Assemble on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Numbers

Go contains basic numeric types that can represent sets of either integer or floating-point values.
There are different types depending on the size of value you require and the architecture of the computer where the application is running (e.g. 32-bit and 64-bit).

For the sake of this exercise you will only be dealing with:

- `int`: e.g. `0`, `255`, `2147483647`. A signed integer that is at least 32 bits in size (value range of: -2147483648 through 2147483647).
  But this will depend on the systems architecture.
  Most modern computers are 64 bit, therefore `int` will be 64 bits in size (value rate of: -9223372036854775808 through 9223372036854775807).

- `float64`: e.g. `0.0`, `3.14`. Contains the set of all 64-bit floating-point numbers.

## Arithmetic Operators

Go supports many standard arithmetic operators:

| Operator | Example        |
| -------- | -------------- |
| `+`      | `4 + 6 == 10`  |
| `-`      | `15 - 10 == 5` |
| `*`      | `2 * 3 == 6`   |
| `/`      | `13 / 3 == 4`  |
| `%`      | `13 % 3 == 1`  |

For integer division, the remainder is dropped (eg. `5 / 2 == 2`).

Go has shorthand assignment for the operators above (e.g. `a += 5` is short for `a = a + 5`).
Go also supports the increment and decrement statements `++` and `--` (e.g. `a++`).

## Type Conversion

In Go, assignment of a value between different types requires explicit conversion.
Converting between types is done via a function with the name of the type to convert to.
For example, to convert an `int` to a `float64` you would need to do the following:

```go
var x int = 42 // x has type int
f := float64(x) // f has type float64 (ie. 42.0)
```

## Conditionals If

Conditionals in Go are similar to conditionals in other languages.
The underlying type of any conditional operation is the `bool` type, which can have the value of `true` or `false`.
Conditionals are often used as flow control mechanisms to check for various conditions.

For checking a particular case an `if` statement can be used, which executes its code if the underlying condition is `true` like this:

```go
var value string

if value == "val" {
    // conditional code
}
```

In scenarios involving more than one case many `if` statements can be chained together using the `else if` and `else` statements.

```go
if value == "val" {
    // conditional code
} else if value == "val2" {
    // conditional code
} else {
    // default code
}
```

## Instructions

In this exercise you'll be writing code to analyse the production of an
assembly line in a car factory. The assembly line's speed can range from `0`
(off) to `10` (maximum).

At its default speed (`1`), `221` cars are produced each hour. In principle,
the production increases linearly. So with the speed set to `4`, it should
produce `4 * 221 = 884` cars per hour. However, higher speeds increase the
likelihood that faulty cars are produced, which then have to be discarded. The
following table shows how speed influences the success rate:

- `0`: 0% success rate.
- `1` - `4`: 100% success rate.
- `5` - `8`: 90% success rate.
- `9` - `10`: 77% success rate.

> Note that the calculation of the success rate has been provided already.

You have two tasks:

## 1. Calculate the production rate per hour

Implement a function to calculate the assembly line's production rate per hour.

```go
rate := CalculateProductionRatePerHour(7)
fmt.Println(rate)
// Output: 1392.3
```

> Note that the value returned is of type `float64`

## 2. Calculate the number of working items produced per minute

Implement a function to calculate how many cars are produced each minute:

```go
rate := CalculateProductionRatePerMinute(5)
fmt.Println(rate)
// Output: 16
```

> Note that the value returned is of type `int`.

## Source

### Created by

- @DavyJ0nes

### Contributed to by

- @tehsphinx