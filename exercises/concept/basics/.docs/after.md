Java is a statically-typed language, which means that everything has a type at compile-time. Assigning a value to a name is referred to as defining a variable.

```java
int explicitVar = 10; // Explicitly typed
```

The value of a variable can be assigned and updated using the [`=` operator][assignment]. Once defined, a variable's type can never change.

```java
int count = 1; // Assign initial value
count = 2;     // Update to new value

// Compiler error when assigning different type
// count = false;
```

Java is an object-oriented language and requires all functions to be defined in a _class_, which are defined using the [`class` keyword][classes]. A function within a class is referred to as a _method_. Each [method][methods] can have zero or more parameters. All parameters must be explicitly typed, there is no type inference for parameters. Similarly, the return type must also be made explicit. Values are returned from functions using the [`return` keyword][return]. To allow a method to be called by other classes, the `public` access modifier must be added.

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

If a method does not use any class _state_ (which is the case in this exercise), the method can be made _static_ using the `static` modifier. Similarly, if a class only has static methods, it too can be made static using the `static` modifier.

```java
static class Calculator {
    public static int multiply(int x, int y) {
        return x * y;
    }
}
```

Scope in Java is defined between the `{` and `}` characters.

Java supports two types of [comments][comments]. Single line comments are preceded by `//` and multiline comments are inserted between `/*` and `*/`.

Integer values are defined as one or more (consecutive) digits and support the [default mathematical operators][operators].

[assignment]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html
[classes]: https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html
[methods]: https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
[return]: https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html
[operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
[comments]: https://www.javatpoint.com/java-comments
