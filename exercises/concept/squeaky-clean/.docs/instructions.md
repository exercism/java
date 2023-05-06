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

## 2. Replace control characters with the upper case string "CTRL"

Modify the (_static_) `SqueakyClean.clean()` method to replace control characters with the upper case string `"CTRL"`.

```java
SqueakyClean.clean("my\0Id");
// => "myCTRLId",
```

## 3. Convert kebab-case to camelCase

Modify the (_static_) `SqueakyClean.clean()` method to convert kebab-case to camelCase.

```java
SqueakyClean.clean("à-ëç");
// => "àËç"
```

## 4. Omit characters that are not letters

Modify the (_static_) `SqueakyClean.clean()` method to omit any characters that are not letters.

```java
SqueakyClean.clean("a1<2?3@b");
// => "ab"
```


