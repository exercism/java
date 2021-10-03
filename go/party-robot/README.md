# Party Robot

Welcome to Party Robot on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

Go programs are organized into packages. 
A package is a collection of source files in the same directory that are compiled together. 
Functions, types, variables, and constants defined in one source file are visible to all other source files within the same package. 
Go determines if an item can be called by code in other packages through how it is declared.
To make a function, type, variable, constant or struct field externally visible (known as `exported`) the name must start with a capital letter.

For example:

```go
package greeting
// Hello is a public function (callable from other packages)
func Hello(name string) string {
    return "Hello " + name
}
// hello is a private function (not callable from other packages)
func hello(name string) string {
    return "Hello " + name
}
```

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

`fmt` contains other functions for working with strings, such as `Println` which simply prints the arguments it receives to the console and `Printf` which formats the input in the same way as `Sprintf` before printing it.

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
// Output: Welcome to my party, Christiane!
```

## 2. Welcome a new guest to the party whose birthday is today

Implement the `HappyBirthday` function to return a birthday message using the given name and age of the person.
Unfortunately the programmer is a bit of a show-off, so the robot has to demonstrate its knowledge of every guest's birthday.

```go
HappyBirthday("Frank", 58)
// Output: Happy birthday Frank! You are now 58 years old!
```

## 3. Give directions

Implement the `AssignTable` function to give directions. The robot provides the table number in hex (uppercase)
due to a misalignment of its creator and the rest of the world. Fortunately the precision on the distance
was limited to 1 digit.

```go
AssignTable("Christiane", 27, "Frank", "on the left", 23.7834298)
// Output:
// Welcome to my party, Christiane!
// You have been assigned to table 1B. Your table is on the left, exactly 23.8 meters from here.
// You will be sitting next to Frank.
```

## Source

### Created by

- @tehsphinx

### Contributed to by

- @oanaOM
- @bobtfish