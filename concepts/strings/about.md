The key thing to remember about Java strings is that they are immutable objects representing text as a sequence of Unicode characters (letters, digits, punctuation, etc.). Double quotes are used to define a `String` instance:

```java
String fruit = "Apple";
```

Manipulating a string can be done using method of class [`String`][string-class]. As string values can never change after having been defined, all string manipulation methods will return a new string.

A string is delimited by double quote (`"`) characters. Some special characters need escaping using the backslash (`\`) character.
Characters to be escaped in Java:

- `"`
- `\`

```java
String escaped = "c:\\test.txt";
// => c:\test.txt
```

Finally, there are many ways to concatenate a string. The simplest one is the `+` operator

```java
String name = "Jane";
"Hello " + name + "!";
// => "Hello Jane!"
```

For any string formatting more complex than simple concatenation, `String.format` method is preferred.

```java
String name = "Jane";
String.format("Hello %s!",name);
// => "Hello Jane!"
```

Other possibilities are:

- use [`StringBuilder` class][string-builder]
- use [`String.concat` method][string-concat]

[string-class]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
[string-builder]: https://docs.oracle.com/javase/tutorial/java/data/buffers.html
[string-concat]: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#concat-java.lang.String-
