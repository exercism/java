# Answer array

```java
import java.util.function.Predicate;
import java.util.regex.Pattern;

class Bob {
    final private static String[] answers = {
        "Whatever.",
        "Sure.",
        "Whoa, chill out!",
        "Calm down, I know what I'm doing!"
    };
    final private static Pattern isAlpha = Pattern.compile("[a-zA-Z]");
    final private static Predicate < String > isShout = msg -> isAlpha.matcher(msg).find() && msg == msg.toUpperCase();

    public String hey(String message) {
        var speech = message.trim();
        if (speech.isEmpty()) {
            return "Fine. Be that way!";
        }
        var questioning = speech.endsWith("?") ? 1 : 0;
        var shouting = isShout.test(speech) ? 2 : 0;
        return answers[questioning + shouting];
    }
}
```

In this approach you define an array that contains Bob’s answers, and each condition is given a score.
The correct answer is selected from the array by using the score as the array index.

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

The conditions of being a question and being a shout are assigned scores through the use of the [ternary operator][ternary].
For example, giving a question a score of `1` would use an index of `1` to get the element from the answers array, which is `"Sure."`.

| isShout | isQuestion | Index     | Answer                                |
| ------- | ---------- | --------- | ------------------------------------- |
| `false` | `false`    | 0 + 0 = 0 | `"Whatever."`                         |
| `false` | `true`     | 0 + 1 = 1 | `"Sure."`                             |
| `true`  | `false`    | 2 + 0 = 2 | `"Whoa, chill out!"`                  |
| `true`  | `true`     | 2 + 1 = 3 | `"Calm down, I know what I'm doing!"` |

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
[ternary]: https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
[endswith]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#endsWith(java.lang.String)
[coding-conventions]: https://www.oracle.com/java/technologies/javase/codeconventions-statements.html#449
