# Lasagna

Welcome to Lasagna on Exercism's Elixir Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Basics

### Variables

Elixir is a dynamically-typed language, meaning that the type of a variable is only checked at runtime. Using the match `=` operator, we can bind a value of any type to a variable name:

```elixir
count = 1 # Bound an integer value of 1
count = 2 # You may re-bind variables

count = false # You may re-bind any type to a variable

message = "Success!" # Strings can be created by enclosing characters within double quotes
```

### Modules

Elixir is a [functional-programming language][functional-programming] and requires all named functions to be defined in a _module_. The `defmodule` keyword is used to define a module. All modules are available to all other modules at runtime and do not require an _access modifier_ to make them visible to other parts of the program. A _module_ is analogous to a _class_ in other programming languages.

```elixir
defmodule Calculator do
  # ...
end
```

### Named functions

_Named Functions_ must be defined in a module. The `def` keyword is used to define a _public_ named function.

Each function can have zero or more arguments. The value of the last expression in a function is always _implicitly returned_.

```elixir
defmodule Calculator do
  def add(x, y) do
    x + y
  end
end
```

Invoking a function is done by specifying its module and function name and passing arguments for each of the function's arguments.

```elixir
sum = Calculator.add(1, 2)
# => 3
```

The `defp` keyword can be used instead of `def` to define a _private_ function. Private functions can only be used from within the same module that defined them.

When invoking a function inside the same module where it's defined, the module name can be omitted.

You may also write short functions using a one-line syntax (note the comma `,` and the colon `:` around the keyword `do`).

```elixir
defmodule Calculator do
  def subtract(x, y) do
    private_subtract(x, y)
  end

  defp private_subtract(x, y), do: x - y
end

difference = Calculator.subtract(7, 2)
# => 5

difference = Calculator.private_subtract(7, 2)
# => ** (UndefinedFunctionError) function Calculator.private_subtract/2 is undefined or private
#       Calculator.private_subtract(7, 2)
```

### Arity of functions

It is common to refer to functions with their _arity_. The _arity_ of a function is the number of arguments it accepts.

```elixir
# add/3 because this function has three arguments, thus an arity of 3
def add(x, y, z) do
  x + y + z
end
```

### Standard library

Elixir has a very rich and well-documented standard library. The documentation is available online at [hexdocs.pm/elixir][docs]. Save this link somewhere - you will use it a lot!

Most built-in data types have a corresponding module that offers functions for working with that data type, e.g. there's the `Integer` module for integers, `String` module for strings, `List` module for lists and so on.

A notable module is the `Kernel` module. It provides the basic capabilities on top of which the rest of the standard library is built, like arithmetic operators, control-flow macros, and much more. Functions for the `Kernel` module are automatically imported, so you can use them without the `Kernel.` prefix.

### Code comments

Comments can be used to leave notes for other developers reading the source code. Single line comments in Elixir are preceded by `#`.

[functional-programming]: https://en.wikipedia.org/wiki/Functional_programming
[docs]: https://hexdocs.pm/elixir/Kernel.html#content

## Instructions

In this exercise you're going to write some code to help you cook a brilliant lasagna from your favorite cooking book.

You have five tasks, all related to the time spent cooking the lasagna.

## 1. Define the expected oven time in minutes

Define the `Lasagna.expected_minutes_in_oven/0` function that does not take any arguments and returns how many minutes the lasagna should be in the oven. According to the cooking book, the expected oven time in minutes is 40:

```elixir
Lasagna.expected_minutes_in_oven()
# => 40
```

## 2. Calculate the remaining oven time in minutes

Define the `Lasagna.remaining_minutes_in_oven/1` function that takes the actual minutes the lasagna has been in the oven as an argument and returns how many minutes the lasagna still has to remain in the oven, based on the expected oven time in minutes from the previous task.

```elixir
Lasagna.remaining_minutes_in_oven(30)
# => 10
```

## 3. Calculate the preparation time in minutes

Define the `Lasagna.preparation_time_in_minutes/1` function that takes the number of layers you added to the lasagna as an argument and returns how many minutes you spent preparing the lasagna, assuming each layer takes you 2 minutes to prepare.

```elixir
Lasagna.preparation_time_in_minutes(2)
# => 4
```

## 4. Calculate the total working time in minutes

Define the `Lasagna.total_time_in_minutes/2` function that takes two arguments: the first argument is the number of layers you added to the lasagna, and the second argument is the number of minutes the lasagna has been in the oven. The function should return how many minutes in total you've worked on cooking the lasagna, which is the sum of the preparation time in minutes, and the time in minutes the lasagna has spent in the oven at the moment.

```elixir
Lasagna.total_time_in_minutes(3, 20)
# => 26
```

## 5. Create a notification that the lasagna is ready

Define the `Lasagna.alarm/0` function that does not take any arguments and returns a message indicating that the lasagna is ready to eat.

```elixir
Lasagna.alarm()
# => "Ding!"
```

## Source

### Created by

- @neenjaw

### Contributed to by

- @angelikatyborska