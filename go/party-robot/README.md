# Party Robot

Welcome to Party Robot on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

A `string` in Go is an immutable sequence of bytes. Strings may contain arbitrary bytes but usually they contain human-readable text.
Text strings are conventionally interpreted as UTF-8 encoded sequence of Unicode code points (runes) which will be explained in a future exercise.
A `string` value can be written as a string literal, which is a sequence of bytes enclosed in double quotes:

```go
s := "Hello World!"
```

Go provides an in-built package called `fmt` (format package) which offers a variety of functions to manipulate the format of input and output. The most common used functions to print output are `Println` and `Printf`.
`Println` simply prints the input received on the console screen while `Printf` formats the input, using verbs like `%s` for strings, before printing it on the console.

In Go floating point values are conveniently printed with Printf's verbs: `%g` (compact representation), `%e` (exponent) or `%f` (non exponent). All three verbs allow the field's width and numeric position to be controlled.

```go
f := 4.3242
fmt.Printf("%.4", f)
// Output: 4.32
```

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