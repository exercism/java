# Squeaky Clean

Welcome to Squeaky Clean on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

The Java `char` type represents the smallest addressable components of text.
Multiple `char`s can comprise a string such as `"word"` or `char`s can be
processed independently. Their literals have single quotes e.g. `'A'`.

Java `char`s support Unicode encoding so in addition to the Latin character set
pretty much all the writing systems in use worldwide can be represented,
e.g. the Greek letter `'β'`.

There are many builtin library methods to inspect and manipulate `char`s. These
can be found as static methods of the `java.lang.Character` class.

`char`s are sometimes used in conjunction with a `StringBuilder` object.
This object has methods that allow a string to be constructed
character by character and manipulated. At the end of the process
`toString` can be called on it to output a complete string.

## Instructions

In this exercise you will implement a partial set of utility routines to help a developer
clean up SqueakyClean names.

In the 4 tasks you will gradually build up the `clean` method.
A valid SqueakyClean name is comprised of zero or more letters and underscores.

In all cases the input string is guaranteed to be non-null. Note that the `clean` method should treat an empty string as valid.

## 1. Replace any spaces encountered with underscores

Implement the (_static_) `SqueakyClean.clean()` method to replace any spaces with underscores. This also applies to leading and trailing spaces.

```java
SqueakyClean.clean("my   Id");
// => "my___Id"
```

## 2. Replace control characters with the upper case string "CTRL"

Modify the (_static_) `SqueakyClean.clean()` method to replace control characters with the upper case string `"CTRL"`.

```java
SqueakyClean.clean("my\0Id");
// => "myCTRLId",
```

## 3. Convert kebab-case to camelCase

Modify the (_static_) `SqueakyClean.clean()` method to convert kebab-case to camelCase.

```java
SqueakyClean.clean("à-ḃç");
// => "àḂç"
```

## 4. Omit Greek lower case letters

Modify the (_static_) `SqueakyClean.clean()` method to omit any Greek letters in the range 'α' to 'ω'.

```java
SqueakyClean.clean("MyΟβιεγτFinder");
// => "MyΟFinder"
```

## Source

### Created by

- @ystromm