# Weather Forecast

Welcome to Weather Forecast on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In the previous exercise, we saw that there are two ways to write comments in Go: single-line comments that are preceded by `//`, and multiline comment blocks that are wrapped with `/*` and `*/`.

## Documentation comments

In Go, comments play an important role in documenting code. They are used by the `godoc` command, which extracts these comments to create documentation about Go packages. A documentation comment should be a complete sentence that starts with the name of the thing being described and ends with a period.

Comments should precede packages as well as exported identifiers, for example exported functions, methods, package variables, constants, and structs, which you will learn more about in the next exercises.

A package-level variable can look like this:

```go
// TemperatureCelsius represents a certain temperature in degrees Celsius.
var TemperatureCelsius float64
```

## Package comments

Package comments should be written directly before a package clause (`package x`) and begin with `Package x ...` like this:

```go
// Package kelvin provides tools to convert
// temperatures to and from Kelvin.
package kelvin
```

## Function comments

A function comment should be written directly before the function declaration. It should be a full sentence that starts with the function name. For example, an exported comment for the function `Calculate` should take the form `Calculate  ...`. It should also explain what arguments the function takes, what it does with them, and what its return values mean, ending in a period):

```go
// CelsiusFreezingTemp returns an integer value equal to the temperature at which water freezes in degrees Celsius.
func CelsiusFreezingTemp() int {
	return 0
}
```

## Instructions

Being hired by a big weather forecast company, your job is to maintain their code base. Scrolling through the code, you find it hard to follow what the code is actually doing. Good thing you know just the right thing to do!

## 1. Document package weather

Write a package comment for `package weather` that describes its contents. The package comment should introduce the package and provide information relevant to the package as a whole.

## 2. Document the CurrentCondition variable

Write a comment for the package variable `CurrentCondition`.

This should tell any user of the package what information the variable stores, and what they can do with it.

## 3. Document the CurrentLocation variable

Just like the previous step, write a comment for `CurrentLocation`.

## 4. Document the Forecast() function

Write a function comment for `Forecast()`. Your comments must describe what the function does, but not how it does it.

## Source

### Created by

- @nikimanoledaki
- @micuffaro