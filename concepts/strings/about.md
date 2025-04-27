# About

The key thing to remember about Java strings is that they are immutable objects representing text as a sequence of Unicode characters (letters, digits, punctuation, etc.).
Double quotes are used to define a `String` instance:

```java
String fruit = "Apple";
```

Manipulating a string can be done using method of class [`String`][string-class].
As string values can never change after having been defined, all string manipulation methods will return a new string.

A string is delimited by double quote (`"`) characters.
Some special characters need escaping using the backslash (`\`) character.
Characters to be escaped in Java:

- `"`
- `\`

```java
String escaped = "c:\\test.txt";
// => c:\test.txt
```

To put a newline character in a string, use the `\n` escape code (`\r\n` on Windows):

```java
"<html>\n    <body>\n        <h1>Hello, World!</h1>\n    </body>\n</html>\n"
```

For code that should work on varying operating systems Java offers [`System.lineSeparator()`][system-line-separator], which returns the system-dependent line separator string.

To comfortable work with texts that contain a lot of newlines you can use [Text Blocks][text-blocks].
These multi-line strings are delimited by triple double quote (`"`) characters.

```java
String multilineHtml = """
<html>
    <body>
        <h1>Hello, World!</h1>
    </body>
</html>
""";
// => "<html>\n    <body>\n        <h1>Hello, World!</h1>\n    </body>\n</html>\n"
```

Finally, there are many ways to concatenate a string.
The simplest one is the `+` operator:

```java
String name = "Jane";
"Hello " + name + "!";
// => "Hello Jane!"
```

For any string formatting more complex than simple concatenation, `String.format` method is preferred.

```java
String name = "Jane";
String.format("Hello %s!", name);
// => "Hello Jane!"
```

The conversion `%n` in a format string inserts a system-dependent line separator.

```java
String name = "Jane";
String.format("Hello,%n%s!", name);
// => "Hello,\nJane!" (Linux, macOS)
// => "Hello,\r\nJane!" (Windows)
```

Other possibilities to build more complex strings are:

- use [`StringBuilder` class][string-builder]
- use [`String.concat` method][string-concat]

[string-class]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
[text-blocks]: https://openjdk.org/projects/amber/guides/text-blocks-guide
[string-builder]: https://docs.oracle.com/javase/tutorial/java/data/buffers.html
[string-concat]: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#concat-java.lang.String-
[system-line-separator]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#lineSeparator()
