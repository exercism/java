# Log Levels

Welcome to Log Levels on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

A `String` in Java is an object that represents immutable text as a sequence of Unicode characters (letters, digits, punctuation, etc.). Double quotes are used to define a `String` instance:

```java
String fruit = "Apple";
```

Strings are manipulated by calling the string's methods. Once a string has been constructed, its value can never change. Any methods that appear to modify a string will actually return a new string.
The `String` class provides some _static_ methods to transform the strings.

## Instructions

In this exercise you'll be processing log-lines.

Each log line is a string formatted as follows: `"[<LEVEL>]: <MESSAGE>"`.

There are three different log levels:

- `INFO`
- `WARNING`
- `ERROR`

You have three tasks, each of which will take a log line and ask you to do something with it.

## 1. Get message from a log line

Implement the (_static_) `LogLevels.message()` method to return a log line's message:

```java
LogLevels.message("[ERROR]: Invalid operation")
// => "Invalid operation"
```

Any leading or trailing white space should be removed:

```java
LogLevels.message("[WARNING]:  Disk almost full\r\n")
// => "Disk almost full"
```

## 2. Get log level from a log line

Implement the (_static_) `LogLevels.logLevel()` method to return a log line's log level, which should be returned in lowercase:

```java
LogLevels.logLevel("[ERROR]: Invalid operation")
// => "error"
```

## 3. Reformat a log line

Implement the (_static_) `LogLevels.reformat()` method that reformats the log line, putting the message first and the log level after it in parentheses:

```java
LogLevels.reformat("[INFO]: Operation completed")
// => "Operation completed (info)"
```

## Source

### Created by

- @mirkoperillo