# Instructions

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

## 2. Convert kebab-case to camelCase

Modify the (_static_) `SqueakyClean.clean()` method to convert kebab-case to camelCase.

```java
SqueakyClean.clean("a-bc");
// => "aBc"
```

## 3. Convert leetspeak to normal text

Modify the (_static_) `SqueakyClean.clean()` method to convert [leetspeak][leet-speak] to normal text.

For simplicity we will only be replacing `4`, `3`, `0`, `1` and `7` with `a`, `e`, `o`, `l`, and `t`, respectively.

```java
SqueakyClean.clean("H3ll0 W0rld");
// => "Hello_World"
SqueakyClean.clean("4 73s7");
// => "a_test"
```

## 4. Omit characters that are not letters

Modify the (_static_) `SqueakyClean.clean()` method to omit any characters that are not letters.

```java
SqueakyClean.clean("a$#.b");
// => "ab"
```

[leet-speak]: https://en.wikipedia.org/wiki/Leet
