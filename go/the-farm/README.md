# The Farm

Welcome to The Farm on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Interfaces

An **interface type** is effectively a set of method signatures.
Any type that defines those methods "implements" the interface implicitly.
There is no `implements` keyword in Go.
Here is what an interface definition might look like:

```go
type InterfaceName interface {
    MethodOne() MethodOneReturnType
    MethodTwo(paramOne ParamOneType, paramTwo ParamTwoType) MethodTwoReturnType
    ...
}
```

For example, here is the built-in `error` interface:

```go
type error interface {
    Error() string
}
```

This means that any type which implements an `Error()` method which returns a `string` implements the `error` interface.
This allows a function with return type `error` to return values of different types as long as all of them satisfy the `error` interface.

There is one very special interface type in Go: the **empty interface** type that contains zero methods.
The empty interface type is written like this: `interface{}`.
Since it has no methods, every type implements the empty interface type.
This is helpful for defining a function that can generically accept any value.
In that case, the function parameter uses the empty interface type.

## Errors

Error handling is **not** done via exceptions in Go.
Instead, errors are normal values of the interface type `error`.

### Creating and Returning Errors

You do not have to always implement the error interface yourself.
To create a simple error, you can use the `errors.New()` function that is part of the standard library package `errors`.
These error variables are also called _sentinel errors_ and by convention their names should start with `Err` or `err` (depending on whether they are exported or not).
You should use error variables instead of directly writing `errors.New` in cases where you use an error multiple times or where you want the consumer of your package to be able to check for the specific error.

```go
import "errors"

var ErrSomethingWrong = errors.New("something went wrong")
ErrSomethingWrong.Error() // returns "something went wrong"
```

An error is by convention the last value returned in a function with multiple return values.
If the function returns an error, it should always return the zero value for other returned values:

```go
import "errors"

// Do this:
func GoodFoo() (int, error) {
  return 0, errors.New("Error")
}

// Not this:
func BadFoo() (int, error) {
  return 10, errors.New("Error")
}
```

Return `nil` for the error when there are no errors:

```go
func Foo() (int, error) {
  return 10, nil
}
```

### Custom Error Types

If you want your error to include more information than just the error message string, you can create a custom error type.
As mentioned before, everything that implements the `error` interface (i.e. has an `Error() string` method) can serve as an error in Go.

Usually, a struct is used to create a custom error type.
By convention, custom error type names should end with `Error`.
Also, it is best to set up the `Error() string` method with a pointer receiver, see this [Stackoverflow comment][stackoverflow-errors] to learn about the reasoning.
Note that this means you need to return a pointer to your custom error otherwise it will not count as `error` because the non-pointer value does not provide the `Error() string` method.

```go
type MyCustomError struct {
  message string
  details string
}

func (e *MyCustomError) Error() string {
  return fmt.Sprintf("%s, Details: %s", e.message, e.details)
}

func someFunction() error {
  // ...
  return &MyCustomError{
    message: "...",
    details: "...",
  }
}
```

### Checking for Errors

Errors can be checked against `nil`.
It is recommended to return early in case of an error to avoid nesting the "happy path" of your code.

```go
func myFunc() error {
	file, err := os.Open("./users.csv")
	if err != nil {
		// handle the error
		return err // or e.g. log it and continue
	}
	// do something with file
}
```

Since most functions in Go include an error as one of the return values, you will see/use this `if err != nil` pattern all over the place in Go code.

You can compare error variables with the equality operator `==`:

```go
var ErrResourceNotFound = errors.New("resource not found")
// ...
if err == ErrResourceNotFound {
  // do something about the resource-not-found error
}
```

How to check for errors of a specific custom error type will be covered in later concepts.

[stackoverflow-errors]: https://stackoverflow.com/a/50333850
[line-of-sight]: https://medium.com/@matryer/line-of-sight-in-code-186dd7cdea88

## Instructions

The day you waited so long finally came and you are now the proud owner of a beautiful farm in the Alps.

You still do not like to wake up too early in the morning to feed your cows and because you are an excellent engineer, you build a food dispenser, the `FEED-M-ALL`.

The last thing required in order to finish your project, is a piece of code that, given the number of cows and the amount of fodder for the day, does a division so each cow has the same quantity: you need to avoid conflicts, cows are very sensitive.

Depending on the day, some cows prefer to eat fresh grass instead of fodder, sometime no cows at all want to eat fodder.
While this is good for your pocket, you want to catch the division by zero returning an error.

Also, your silly nephew (who has just learned about negative numbers) sometimes will say that there are a negative number of cows.
You love your nephew so you want to return a helpful error when he does that.

## 1. Get the amount of fodder from the `FodderAmount` method

You will be passed a value that fulfills the `WeightFodder` interface.
`WeightFodder` includes a method called `FodderAmount` that returns the amount of fodder available and possibly an error.

```go
// twentyFodderNoError says there are 20.0 fodder
fodder, err := DivideFood(twentyFodderNoError, 10)
// fodder == 2.0
// err == nil
```

If `ErrScaleMalfunction` is returned by `FodderAmount` and the fodder amount is positive, double the fodder amount returned by `FodderAmount` before dividing it equally between the cows.
For any other error besides `ErrScaleMalfunction`, return 0 and the error.

```go
// twentyFodderWithErrScaleMalfunction says there are 20.0 fodder and a ErrScaleMalfunction
fodder, err := DivideFood(twentyFodderWithErrScaleMalfunction, 10)
// fodder == 4.0
// err == nil
```

## 2. Return an error for negative fodder

If the scale is broken and returning negative amounts of fodder, return an error saying "negative fodder" only if `FodderAmount` returned `ErrScaleMalfunction` or nil :

```go
// negativeFiveFodder says there are -5.0 fodder
fodder, err := DivideFood(negativeFiveFodder, 10)
// fodder == 0.0
// err.Error() == "negative fodder"
```

## 3. Prevent division by zero

After getting the fodder amount from `weightFodder`, prevent a division by zero when there are no cows at all by returning an error saying "division by zero":

```go
// twentyFodderNoError says there are 20.0 fodder
fodder, err := DivideFood(twentyFodderNoError, 0)
// fodder == 0.0
// err.Error() == "division by zero"
```

## 4. Handle negative cows

Define a custom error type called `SillyNephewError`.
It should be returned in case the number of cows is negative.

The error message should include the number of cows that was passed as argument.
You can see the format of the error message in the example below.

Note that if both a "negative fodder" error and a `SillyNephewError` could be returned, the "negative fodder" error takes precedence.

```go
// twentyFodderNoError says there are 20.0 fodder
fodder, err := DivideFood(twentyFodderNoError, -5)
// fodder == 0.0
// err.Error() == "silly nephew, there cannot be -5 cows"
```

## Source

### Created by

- @brugnara
- @jmrunkle

### Contributed to by

- @junedev