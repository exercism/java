# Lasagna

Welcome to Lasagna on Exercism's Ruby Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

This exercise will teach the fundamental building blocks of Ruby.
It covers a lot of ground, but do not worry if it feels overwhelming, we will go into everything in much more depth as we continue through the track.

One of the key things to understand about Ruby is that it is an [object-oriented language][object-oriented-programming], and that **everything in Ruby is an [object][object]**. Numbers, strings, arrays - they're all objects.

## Variables and Constants

We tend to make use of objects by assigning them names, either using variables or constants.

Variables are always written in [snake case][snake-case].
A variable can reference different objects over its lifetime.
For example, `my_first_variable` can be defined and redefined many times using the `=` operator:

```ruby
my_first_variable = 1
my_first_variable = "Some string"
my_first_variable = SomeComplexObject.new
```

Constants, however, are meant to be assigned once.
They must start with capital letters and are normally written in block capitals with words separated by underscores.
For example:

```ruby
MY_FIRST_CONSTANT = 10

# Redefining not allowed
# MY_FIRST_CONSTANT = "Some String"
```

## Classes

Ruby is organised into classes.
Classes are defined using the `class` keyword followed by the name of the class.
Objects are generally created by instantiating classes using the `.new` method.
For example:

```ruby
# Define the class
class Calculator
  #...
end

# Create an instance of it and assign it to a variable
my_first_calc = Calculator.new
```

## Methods

Units of functionality are encapsulated in methods - similar to _functions_ in other languages.

A method can be defined with positional arguments, keyword arguments (which are defined and called using the `:` syntax) or have no arguments at all.

Methods either implicitly return the result of the last evaluated statement, or can explicitly return an object via the `return` keyword.

```ruby
class Calculator

  # Positional arguments
  def add(num1, num2)
    return num1 + num2 # Explicit return
  end

  # Keyword arguments
  def multiply(num1:, num2:)
    num1 * num2 # Implicit return
  end
end
```

Methods are invoked using `.` syntax:

```ruby
calc = Calculator.new
calc.add(1, 3)
calc.multiply(num1: 2, num2: 5)
```

[object-oriented-programming]: https://ruby-doc.org/docs/ruby-doc-bundle/UsersGuide/rg/oothinking.html
[object]: https://github.com/exercism/v3/blob/main/reference/concepts/objects.md
[snake-case]: https://en.wikipedia.org/wiki/Snake_case

## Instructions

In this exercise you're going to write some code to help you cook a brilliant lasagna from your favorite cooking book.

You have four tasks, all related to the time spent cooking the lasagna.

## 1. Define the expected oven time in minutes

Define the `Lasagna::EXPECTED_MINUTES_IN_OVEN` constant that returns how many minutes the lasagna should be in the oven. According to the cooking book, the expected oven time in minutes is 40:

```ruby
Lasagna::EXPECTED_MINUTES_IN_OVEN
# => 40
```

## 2. Calculate the remaining oven time in minutes

Define the `Lasagna#remaining_minutes_in_oven` method that takes the actual minutes the lasagna has been in the oven as a parameter and returns how many minutes the lasagna still has to remain in the oven, based on the expected oven time in minutes from the previous task.

```ruby
lasagna = Lasagna.new
lasagna.remaining_minutes_in_oven(30)
# => 10
```

## 3. Calculate the preparation time in minutes

Define the `Lasagna#preparation_time_in_minutes` method that takes the number of layers you added to the lasagna as a parameter and returns how many minutes you spent preparing the lasagna, assuming each layer takes you 2 minutes to prepare.

```ruby
lasagna = Lasagna.new
lasagna.preparation_time_in_minutes(2)
# => 4
```

## 4. Calculate the total working time in minutes

Define the `Lasagna#total_time_in_minutes` method that takes two named parameters: the `number_of_layers` parameter is the number of layers you added to the lasagna, and the `actual_minutes_in_oven` parameter is the number of minutes the lasagna has been in the oven. The function should return how many minutes in total you've worked on cooking the lasagna, which is the sum of the preparation time in minutes, and the time in minutes the lasagna has spent in the oven at the moment.

```ruby
lasagna = Lasagna.new
lasagna.total_time_in_minutes(number_of_layers: 3, actual_minutes_in_oven: 20)
# => 26
```

## Source

### Created by

- @iHiD
- @pvcarrera