# Cook your lasagna

Welcome to Cook your lasagna on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

Java is a statically-typed language, which means that everything has a type at compile-time. Assigning a value to a name is referred to as defining a variable. A variable is defined by explicitly specifying its type.

```java
int explicitVar = 10;
```

Updating a variable's value is done through the `=` operator. Once defined, a variable's type can never change.

```java
int count = 1; // Assign initial value
count = 2;     // Update to new value

// Compiler error when assigning different type
// count = false;
```

Java is an [object-oriented language][object-oriented-programming] and requires all functions to be defined in a _class_. The `class` keyword is used to define a class.

```java
class Calculator {
    // ...
}
```

A function within a class is referred to as a _method_. Each method can have zero or more parameters. All parameters must be explicitly typed, there is no type inference for parameters. Similarly, the return type must also be made explicit. Values are returned from functions using the `return` keyword. To allow a method to be called by other classes, the `public` access modifier must be added.

```java
class Calculator {
    public int add(int x, int y) {
        return x + y;
    }
}
```

Invoking a method is done by specifying its class and method name and passing arguments for each of the method's parameters.

```java
int sum = new Calculator().add(1, 2);
```

Scope in Java is defined between the `{` and `}` characters.

Java supports two types of comments. Single line comments are preceded by `//` and multiline comments are inserted between `/*` and `*/`.

[object-oriented-programming]: https://docs.oracle.com/javase/tutorial/java/javaOO/index.html

## Instructions

In this exercise you're going to write some code to help you cook a brilliant lasagna from your favorite cooking book.

You have four tasks, all related to the time spent cooking the lasagna.

## 1. Define the expected oven time in minutes

Define the `expectedMinutesInOven()` method that does not take any parameters and returns how many minutes the lasagna should be in the oven. According to the cooking book, the expected oven time in minutes is 40:

```java
Lasagna lasagna = new Lasagna();
lasagna.expectedMinutesInOven();
// => 40
```

## 2. Calculate the remaining oven time in minutes

Define the `remainingMinutesInOven()` method that takes the actual minutes the lasagna has been in the oven as a parameter and returns how many minutes the lasagna still has to remain in the oven, based on the expected oven time in minutes from the previous task.

```java
Lasagna lasagna = new Lasagna();
lasagna.remainingMinutesInOven(30);
// => 10
```

## 3. Calculate the preparation time in minutes

Define the `preparationTimeInMinutes()` method that takes the number of layers you added to the lasagna as a parameter and returns how many minutes you spent preparing the lasagna, assuming each layer takes you 2 minutes to prepare.

```java
Lasagna lasagna = new Lasagna();
lasagna.preparationTimeInMinutes(2);
// => 4
```

## 4. Calculate the total working time in minutes

Define the `totalTimeInMinutes()` method that takes two parameters: the first parameter is the number of layers you added to the lasagna, and the second parameter is the number of minutes the lasagna has been in the oven. The function should return how many minutes in total you've worked on cooking the lasagna, which is the sum of the preparation time in minutes, and the time in minutes the lasagna has spent in the oven at the moment.

```java
Lasagna lasagna = new Lasagna();
lasagna.totalTimeInMinutes(3, 20);
// => 26
```

## Source

### Created by

- @mirkoperillo