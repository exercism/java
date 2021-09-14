# Savings Account

Welcome to Savings Account on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Go, a constant is a simple, unchanging value assigned to a name with the `const` keyword:

```go
const myWebsite = "Exercism"
```

Such constants are untyped, but they are given a default type based on their syntax when a type is required, such as when they are passed to a method. Typed constants can be created by explicitly adding a type:

```go
const myWebsite string = "Exercism"
```

Go does not have enums like some other languages, but does have a predeclared identifier called `iota` for creating enumerated constants. Constants in a block are implicitly repeated:

```go
const (
    a = 9
    b
    c
    d = iota
    e
    f
    g
)
fmt.Print(a, b, c, d, e, f, g)
// Output: 9 9 9 3 4 5 6
```

## Instructions

In this exercise you will establish some constants to be used in the operation of a bank.

You have five tasks:

## 1. Represent the fixed interest rate on a loan

Create the `FixedInterestRate` untyped numeric constant to hold the value of 5% (5/100), then implement the `GetFixedInterestRate` function to return it:

```go
GetFixedInterestRate()
// Output: 0.05
```

## 2. Represent the number of days in a year

Create the `DaysPerYear` constant with type `int` to hold the value 365, then implement the `GetDaysPerYear` function to return it:

```go
GetDaysPerYear()
// Output: 365
```

## 3. Represent the months of the year

In a block, use the Go enumerator to create twelve untyped numeric constants to hold the values 1 through 12 for the months of the year. Name them `Jan`, `Feb`, `Mar`, etc., then implement the `GetMonth` function to return the value for a given month:

```go
GetMonth(Jan)
// Output: 1
```

## 4. Represent an account number

Create the `AccountNo` untyped string constant to hold the value XF348IJ, then implement the `GetAccountNumber` function to return it:

```go
GetAccountNumber()
// Output: "XF348IJ"
```

## Source

### Created by

- @jamessouth