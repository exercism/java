# Introduction

## Chars

### chars

The Java `char` primitive type is a 16 bit representation of a single character.
Multiple `char`s can comprise a string, such as `"word"`, or `char`s can be processed independently.
A `char` literal is surrounded by single quotes (e.g. `'A'`).

```java
char lowerA = 'a';
char upperB = 'B';
```

### Getting the `char`s of a `String`

The `String.toCharArray` method returns a String's chars as an array.
As mentioned in arrays, you can use a `for` loop to iterate over the array.

```java
String text = "Hello";
char[] asArray = text.toCharArray();

for (char ch: asArray) {
    System.out.println(ch);
}

// Outputs:
// H
// e
// l
// l
// o
```

### The Character class

There are many builtin library methods to inspect and manipulate `char`s.
These can be found as static methods of the `java.lang.Character` class.
Here are some examples:

```java
Character.isWhitespace(' ');    // true
Character.isWhitespace('#');    // false

Character.isLetter('a');        // true
Character.isLetter('3');        // false

Character.isDigit('6');         // true
Character.isDigit('?');         // false
```

### Adding a `char` to a `String`

The `+` operator can be used to add a `char` to a `String`.

```java
'a' + " banana"     // => "a banana"
"banana " + 'a'     // => "banana a"
```

~~~~exercism/caution
Becareful _not_ to use `+` to join two `char`s together to form a `String`!
Adding two `char`s this way gives an `int`, _not_ a `String`!
For example:

```java
'b' + 'c';
// => 197 (not the String "bc")
```

This is because Java promotes the `char` to an `int` (see [4.2 Primitive Types and Values ][jls-primitives] of the [Java Language Specification][jls-main]).

[jls-main]: https://docs.oracle.com/javase/specs/jls/se21/html/
[jls-primitives]: https://docs.oracle.com/javase/specs/jls/se21/html/jls-4.html#jls-4.2
~~~~

However, when there are many characters to be added, it can be more efficient to use a `StringBuilder` instead:

```java
StringBuilder builder = new StringBuilder();
builder.append('a');
builder.append('b');
builder.append('c');

String builtString = builder.toString();
// => abc
```
