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

## Converting between int and float64

Converting between types is done via a function with the name of the type to convert to.
For example:

```go
var x int = 42 // x has type int
f := float64(x) // f has type float64 (ie. 42.0)
var y float64 = 11.9 // y has type float64
i := int(y) // i has type int (ie. 11)
```

## If Statements

Conditionals in Go are similar to conditionals in other languages.
The underlying type of any conditional operation is the `bool` type, which can have the value of `true` or `false`.
Conditionals are often used as flow control mechanisms to check for various conditions.

For checking a particular case an `if` statement can be used, which executes its code if the underlying condition is `true` like this:

```go
var value string

if value == "val" {
    return "was val"
}
```

In scenarios involving more than one case many `if` statements can be chained together using the `else if` and `else` statements.

```go
var number int
result := "This number is "

if number > 0 {
    result += "positive"
} else if number < 0 {
    result += "negative"
} else {
    result += "zero"
}
```

If statements can also include a short initialization statement that can be used to initialize one or more variables for the if statement.
For example:

```go
num := 7
if v := 2 * num; v > 10 {
    fmt.Println(v)
} else {
    fmt.Println(num)
}
// Output: 7
```

> Note: any variables created in the initialization statement go out of scope after the end of the if statement.

## Instructions

In this exercise you'll be writing code to analyze the production of an assembly line in a car factory.
The assembly line's speed can range from `0` (off) to `10` (maximum).

At its default speed (`1`), `221` cars are produced each hour.
In principle, the production increases linearly.
So with the speed set to `4`, it should produce `4 * 221 = 884` cars per hour.
However, higher speeds increase the likelihood that faulty cars are produced, which then have to be discarded.

Also, there are times when the assembly line has an artificially imposed limit on the throughput (meaning no more than the limit can be produced per hour).

## 1. Calculate the success rate

Implement a function (`SuccessRate`) to calculate the ratio of an item being created without error for a given speed.
The following table shows how speed influences the success rate:

- `0`: 0% success rate.
- `1` - `4`: 100% success rate.
- `5` - `8`: 90% success rate.
- `9` - `10`: 77% success rate.

```go
rate := SuccessRate(6)
fmt.Println(rate)
// Output: 0.9
```

## 2. Calculate the production rate per hour

Implement a function to calculate the assembly line's production rate per hour:

```go
rate := CalculateProductionRatePerHour(7)
fmt.Println(rate)
// Output: 1392.3
```

> Note that the value returned is of type `float64`.

## 3. Calculate the number of working items produced per minute

Implement a function to calculate how many cars are produced each minute:

```go
rate := CalculateProductionRatePerMinute(5)
fmt.Println(rate)
// Output: 16
```

> Note that the value returned is of type `int`.

## 4. Calculate the artificially-limited production rate

Implement a function to calculate the assembly line's production rate per hour:

```go
rate := CalculateLimitedProductionRatePerHour(2, 1000.0)
fmt.Println(rate)
// Output: 442.0
rate := CalculateLimitedProductionRatePerHour(7, 1000.0)
fmt.Println(rate)
// Output: 1000.0
```

> Note that the value returned is of type `float64`.
  This should call the `CalculateProductionRatePerHour` function exactly once.

## Source

### Created by

- @DavyJ0nes

### Contributed to by

- @tehsphinx