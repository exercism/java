# Variable-Based `if` statements

```java
import java.util.function.Predicate;
import java.util.regex.Pattern;

class Bob {

    final private static Pattern isAlpha = Pattern.compile("[a-zA-Z]");
    final private static Predicate < String > isShout = msg -> isAlpha.matcher(msg).find() && msg == msg.toUpperCase();

    public String hey(String message) {
        var speech = message.trim();
        if (speech.isEmpty()) {
            return "Fine. Be that way!";
        }
        var questioning = speech.endsWith("?");
        var shouting = isShout.test(speech);
        if (questioning) {
            if (shouting) {
                return "Calm down, I know what I'm doing!";
            }
            return "Sure.";
        }
        if (shouting) {
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }
}
```

In this approach you have a series of `if` statements using the private methods to evaluate the conditions.
As soon as the right condition is found, the correct response is returned.

Note that there are no `else if` or `else` statements.
If an `if` statement can return, then an `else if` or `else` is not needed.
Execution will either return or will continue to the next statement anyway.

The `String` [`trim()`][trim] method is applied to the input to eliminate any whitespace at either end of the input.
If the string has no characters left, it returns the response for saying nothing.

~~~~exercism/caution
Note that a `null` `string` would be different from a `String` of all whitespace.
A `null` `String` would throw a `NullPointerException` if `trim()` were applied to it.
~~~~

A [Pattern][pattern] is defined to look for at least one English alphabetic character.

The first half of the `isShout` [Predicate][predicate]

```java
isAlpha.matcher(msg).find() && msg == msg.toUpperCase();
```

is constructed from the `Pattern` [`matcher()`][matcher-method] method and the [`Matcher`][matcher]  [`find()`][find] method
to ensure there is at least one letter character in the `String`.
This is because the second half of the condition tests that the uppercased input is the same as the input.
If the input were only `"123"` it would equal itself uppercased, but without letters it would not be a shout.

A question is determined by use of the [`endsWith()`][endswith] method to see if the input ends with a question mark.

## Shortening

When the body of an `if` statement is a single line, both the test expression and the body _could_ be put on the same line, like so

```java
if (speech.isEmpty()) return "Fine. Be that way!";
```

or the body _could_ be put on a separate line without curly braces

```java
if (speech.isEmpty())
    return "Fine. Be that way!";
```

However, the [Java Coding Conventions][coding-conventions] advise to always use curly braces for `if` statements, which helps to avoid errors.
Your team may choose to overrule them at its own risk.

[trim]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim()
[pattern]: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
[predicate]: https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
[matcher]: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html
[matcher-method]: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#matcher-java.lang.CharSequence-
[find]: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html#find--
[endswith]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#endsWith(java.lang.String)
[coding-conventions]: https://www.oracle.com/java/technologies/javase/codeconventions-statements.html#449
