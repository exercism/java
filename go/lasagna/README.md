# Gopher's Gorgeous Lasagna

Welcome to Gopher's Gorgeous Lasagna on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

[Go](https://golang.org) is a statically typed, compiled programming language.
This exercise introduces three major language features: Packages, Functions, and Variables.

## Packages

Go applications are organized in packages.
A package is a collection of source files located in the same directory.
All source files in a directory must share the same package name.
When a package is imported, only entities (functions, types, variables, constants) whose names start with a capital letter can be used / accessed.
The recommended style of naming in Go is that identifiers will be named using `camelCase`, except for those meant to be accessible across packages which should be `PascalCase`.

```go
package lasagna
```

## Variables

Go is statically-typed, which means all variables [must have a defined type](https://en.wikipedia.org/wiki/Type_system) at compile-time.

Variables can be defined by explicitly specifying a type:

```go
var explicit int // Explicitly typed
```

You can also use an initializer, and the compiler will assign the variable type to match the type of the initializer.

```go
implicit := 10   // Implicitly typed as an int
```

Once declared, variables can be assigned values using the `=` operator.
Once declared, a variable's type can never change.

```go
count := 1 // Assign initial value
count = 2  // Update to new value

count = false // This throws a compiler error due to assigning a non `int` type
```

## Constants

Constants hold a piece of data just like variables, but their value cannot change during the execution of the program.

Constants are defined using the `const` keyword and can be numbers, characters, strings or booleans:

```go
const Age = 21 // Defines a numeric constant 'Age' with the value of 21
```

## Functions

Go functions accept zero or more parameters.
Parameters must be explicitly typed, there is no type inference.

Values are returned from functions using the `return` keyword.

A function is invoked by specifying the function name and passing arguments for each of the function's parameters.

Note that Go supports two types of comments.
Single line comments are preceded by `//` and multiline comments are inserted between `/*` and `*/`.

```go
package greeting

// Hello is a public function.
func Hello (name string) string {
    return hi(name)
}

// hi is a private function.
func hi (name string) string {
    return "hi " + name
}
```

## Instructions

In this exercise you're going to write some code to help you cook a brilliant lasagna from your favorite cooking book.

You have four tasks, all related to the time spent cooking the lasagna.

## 1. Define the expected oven time in minutes

Define the `OvenTime` constant with how many minutes the lasagna should be in the oven. According to the cooking book, the expected oven time in minutes is 40:

```go
OvenTime
// => 40
```

## 2. Calculate the remaining oven time in minutes

Define the `RemainingOvenTime()` function that takes the actual minutes the lasagna has been in the oven as a parameter and returns how many minutes the lasagna still has to remain in the oven, based on the expected oven time in minutes from the previous task.

```go
func RemainingOvenTime(actual int) int {
    // TODO
}

RemainingOvenTime(30)
// => 10
```

## 3. Calculate the preparation time in minutes

Define the `PreparationTime` function that takes the number of layers you added to the lasagna as a parameter and returns how many minutes you spent preparing the lasagna, assuming each layer takes you 2 minutes to prepare.

```go
func PreparationTime(numberOfLayers int) int {
    // TODO
}

PreparationTime(2)
// => 4
```

## 4. Calculate the elapsed working time in minutes

Define the `ElapsedTime` function that takes two parameters: the first parameter is the number of layers you added to the lasagna, and the second parameter is the number of minutes the lasagna has been in the oven.
The function should return how many minutes in total you've worked on cooking the lasagna, which is the sum of the preparation time in minutes, and the time in minutes the lasagna has spent in the oven at the moment.

```go
func ElapsedTime(numberOfLayers, actualMinutesInOven int) int {
    // TODO
}

ElapsedTime(3, 20)
// => 26
```

## Source

### Created by

- @tehsphinx

### Contributed to by

- @ekingery
- @andrerfcsantos
- @bobtfish