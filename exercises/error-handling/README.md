# Error Handling

Implement various kinds of error handling and resource management.

An important point of programming is how to handle errors and close
resources even if errors occur.

This exercise requires you to handle various errors. Because error handling
is rather programming language specific you'll have to refer to the tests
for your track to see what's exactly required.

# Java Tips

This exercise requires you to handle exceptions. An [exception](https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html) is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.

In Java, there are two types of exceptions: checked and unchecked exceptions.

- [Checked vs Unchecked Exceptions in Java](https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/)

- [Unchecked Exceptions — The Controversy](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html)

## Checked exceptions

Checked exceptions are the exceptions that are checked at [compile time](https://en.wikipedia.org/wiki/Compile_time).

### Practical implications

You have to declare them in the [method signature](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html) of any method that can [throw](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html) a checked exception and handle or rethrow them when calling any method that can throw a checked exception.

This is because checked exceptions are meant to be handled at runtime, i.e. they are errors you can recover from.

### Examples of where they are used

They're often used when a method can't return any valid result, for example a search method which hasn't found the item it was searching for.

It's an alternative to returning null or a error code. A checked exception is better than those alternatives because it forces the user of the method to consider the error case.

## Unchecked exceptions

Unchecked exceptions are the exceptions that are not checked at [compile time](https://en.wikipedia.org/wiki/Compile_time).

### Practical implications

You don't have to declare them in the [method signature](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html) of methods that can [throw](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html) an unchecked exception and handle or rethrow them when calling any method that can throw an unchecked exception.

### Examples of where they are used

Unchecked exceptions are mean to be used for any error than can't be handled at runtime, e.g. running out of memory.

# Running the tests

You can run all the tests for an exercise by entering

```sh
$ gradle test
```

in your terminal.

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have completed the exercise.
