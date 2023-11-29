# Introduction

## Basics

Java is a statically-typed language, which means that the type of a variable is known at compile-time.
Assigning a value to a name is referred to as defining a variable.
A variable is defined by explicitly specifying its type.

```java
int explicitVar = 10;
```

Updating a variable's value is done through the `=` operator.
Here, `=` does not represent mathematical equality.
It simply assigns a value to a variable.
Once defined, a variable's type can never change.

```java
int count = 1; // Assign initial value
count = 2;     // Update to new value

// Compiler error when assigning a different type
// count = false;
```

Java is an [object-oriented language][object-oriented-programming] and requires all functions to be defined in a _class_.
The `class` keyword is used to define a class.

```java
class Calculator {
    // ...
}
```

A function within a class is referred to as a _method_.
Each method can have zero or more parameters.
All parameters must be explicitly typed, there is no type inference for parameters.
Similarly, the return type must also be made explicit.
Values are returned from methods using the `return` keyword.
To allow a method to be called by other classes, the `public` access modifier must be added.

```java
class Calculator {
    public int add(int x, int y) {
        return x + y;
    }
}
```

Invoking/calling a method is done by specifying its class and method name and passing arguments for each of the method's parameters.

```java
int sum = new Calculator().add(1, 2);  // here the  "add" method has been called to perform the task of addition
```

Scope in Java is defined between the `{` and `}` characters.

Java supports two types of comments.
Single line comments are preceded by `//` and multiline comments are inserted between `/*` and `*/`.

[object-oriented-programming]: https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
