# Party Robot

Welcome to Party Robot on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Packages

In Go an application is organized in packages.
A package is a collection of source files located in the same folder.
All source files in a folder must have the same package name at the top of the file.
By convention packages are named to be the same as the folder they are located in.

```go
package greeting
```

Go provides an extensive standard library of packages which you can use in your program using the `import` keyword.
Standard library packages are imported using their name.

```go
package greeting

import "fmt"
```

An imported package is then addressed with the package name:

```go
world := "World"
fmt.Sprintf("Hello %s", world)
```

Go determines if an item can be called by code in other packages through how it is declared.
To make a function, type, variable, constant or struct field externally visible (known as _exported_) the name must start with a capital letter.

```go
package greeting

// Hello is a public function (callable from other packages).
func Hello(name string) string {
    return "Hello " + name
}

// hello is a private function (not callable from other packages).
func hello(name string) string {
    return "Hello " + name
}
```

## String Formatting

Go provides an in-built package called `fmt` (format package) which offers a variety of functions to manipulate the format of input and output.
The most commonly used function is `Sprintf`, which uses verbs like `%s` to interpolate values into a string and returns that string.

```go
import "fmt"

food := "taco"
fmt.Sprintf("Bring me a %s", food)
// Returns: Bring me a taco
```

In Go floating point values are conveniently formatted with Sprintf's verbs: `%g` (compact representation), `%e` (exponent) or `%f` (non exponent).
All three verbs allow the field's width and numeric position to be controlled.

```go
import "fmt"

number := 4.3242
fmt.Sprintf("%.2f", number)
// Returns: 4.32
```

You can find a full list of available verbs in the [format package documentation][fmt-docs].

`fmt` contains other functions for working with strings, such as `Println` which simply prints the arguments it receives to the console and `Printf` which formats the input in the same way as `Sprintf` before printing it.

[fmt-docs]: https://pkg.go.dev/fmt

## Instructions

Once there was an eccentric programmer living in a strange house with barred windows.
One day he accepted a job from an online job board to build a party robot. The
robot is supposed to greet people and help them to their seats. The first edition
was very technical and showed the programmer's lack of human interaction. Some of
which also made it into the next edition.

## 1. Welcome a new guest to the party

Implement the `Welcome` function to return a welcome message using the given name:

```go
Welcome("Christiane")
// => Welcome to my party, Christiane!
```

## 2. Welcome a new guest to the party whose birthday is today

Implement the `HappyBirthday` function to return a birthday message using the given name and age of the person.
Unfortunately the programmer is a bit of a show-off, so the robot has to demonstrate its knowledge of every guest's birthday.

```go
HappyBirthday("Frank", 58)
// => Happy birthday Frank! You are now 58 years old!
```

## 3. Give directions

Implement the `AssignTable` function to give directions.
It should accept 5 parameters.

- The name of the new guest to greet (`string`)
- The table number (`int`)
- The name of the seatmate (`string`)
- The direction where to find the table (`string`)
- The distance to the table (`float64`)

The exact result format can be seen in the example below.

The robot provides the table number in a 3 digits format.
If the number is less than 3 digits it gets extra leading zeroes to become 3 digits (e.g. 3 becomes 003).
The robot also mentions the distance of the table.
Fortunately only with a precision that's limited to 1 digit.

```go
AssignTable("Christiane", 27, "Frank", "on the left", 23.7834298)
// =>
// Welcome to my party, Christiane!
// You have been assigned to table 027. Your table is on the left, exactly 23.8 meters from here.
// You will be sitting next to Frank.
```

## Source

### Created by

- @tehsphinx

### Contributed to by

- @oanaOM
- @bobtfish