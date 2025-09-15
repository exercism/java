# About

The Java `char` primitive type is a 16 bit representation of a single Unicode character.

~~~~exercism/note
The `char` type is based on the [original Unicode specification][unicode-specification], which used 16 bits to represent characters.
This is enough to cover most of the common letters and covers characters in the range 0x0000 to 0xFFFF.
The specification has since expanded the range of possible characters up to 0x01FFFF.

[unicode-specification]: https://www.unicode.org/versions/Unicode1.0.0/
~~~~

Multiple `char`s can comprise a string, such as `"word"`, or `char`s can be processed independently.
A `char` literal is surrounded by single quotes (e.g. `'A'`).

```java
char lowerA = 'a';
char upperB = 'B';
```

## Getting the `char`s of a `String`

The `String.toCharArray` method returns a String's chars as an array.
As mentioned in [arrays][concept-arrays], you can use a `for` loop to iterate over the array.

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

## The [Character][docs-character] class

There are many builtin library methods to inspect and manipulate `char`s.
These can be found as static methods of the [`java.lang.Character`][docs-character] class.
Here are some examples:

```java
Character.isWhitespace(' ');    // true
Character.isWhitespace('#');    // false

Character.isLetter('a');        // true
Character.isLetter('3');        // false

Character.isDigit('6');         // true
Character.isDigit('?');         // false
```

~~~~exercism/note
Some methods in the Character class have an overload so that it can take either an `char` or `int`.
For example, `isDigit` has one that accepts a [`char`][is-digit-char] and another an [`int`][is-digit-int].
As mentioned earlier, the `char` type can only represent the characters in the range from 0x0000 to 0xFFFF.
The `int`, however, can represent all characters, hence the `int` overloads.

[is-digit-char]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isDigit(char)
[is-digit-int]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isDigit(int)
~~~~

## Adding a `char` to a `String`

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

However, when there are many characters to be added, it can be more efficient to use a [`StringBuilder`][docs-stringBuilder] instead:

```java
StringBuilder builder = new StringBuilder();
builder.append('a');
builder.append('b');
builder.append('c');

String builtString = builder.toString();
// => abc
```

[concept-arrays]: https://exercism.org/tracks/java/concepts/arrays
[docs-character]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html
[docs-stringBuilder]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/StringBuilder.html
