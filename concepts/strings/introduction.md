# Introduction

A `String` in Java is an object that represents immutable text as a sequence of Unicode characters (letters, digits, punctuation, etc.).
Double quotes are used to define a `String` instance:

```java
String fruit = "Apple";
```

## Common string operations

Strings expose a rich set of methods. Here are the ones you'll reach for most often:

```java
String s = "Hello, World!";

s.length();             // 13
s.toLowerCase();        // "hello, world!"
s.toUpperCase();        // "HELLO, WORLD!"
s.trim();               // removes leading/trailing whitespace
s.contains("World");    // true
s.startsWith("Hello");  // true
s.endsWith("!");        // true
s.indexOf("World");     // 7
s.substring(7, 12);     // "World"
s.replace("World", "Java"); // "Hello, Java!"
s.split(", ");          // ["Hello", "World!"]
```

## Strings are immutable

Once a string is created, its value never changes.
Any method that appears to modify a string actually returns a new one — the original is untouched:

```java
String original = "hello";
String upper = original.toUpperCase();
// original is still "hello", upper is "HELLO"
```

## Comparing strings

Use `.equals()` to compare string values — never `==`, which only checks if two variables point to the same object:

```java
String a = "hello";
String b = "hello";
a.equals(b);            // true  (correct)
a.equalsIgnoreCase(b);  // true  (case-insensitive version)
```

## Building strings dynamically

When you need to construct a string piece by piece (e.g. inside a loop), use `StringBuilder` instead of concatenating with `+`.
Each `+` on a `String` creates a new object, which gets expensive fast:

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(", ");
sb.append("World!");
String result = sb.toString(); // "Hello, World!"
```

For simple one-liner formatting, `String.format` is handy:

```java
String.format("Hello, %s! You are %d years old.", "Alice", 30);
// "Hello, Alice! You are 30 years old."
```
