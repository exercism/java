# Introduction

There are various idiomatic approaches to solve Bob.
A basic approach can use a series of `if` statements to test the conditions.
An array can contain answers from which the right response is selected by an index calculated from scores given to the conditions.

## General guidance

Regardless of the approach used, some things you could look out for include

- If the input is trimmed, [`trim()`][trim] only once.

- Use the [`endsWith()`][endswith] `String` method instead of checking the last character by index for `?`.

- Don't copy/paste the logic for determining a shout and for determining a question into determining a shouted question.
  Combine the two determinations instead of copying them.
  Not duplicating the code will keep the code [DRY][dry].

- Perhaps consider making `questioning` and `shouting` values set once instead of functions that are possibly called twice.

- If an `if` statement can return, then an `else if` or `else` is not needed.
  Execution will either return or will continue to the next statement anyway.

- If the body of an `if` statement is only one line, curly braces aren't needed.
  Some teams may still require them in their style guidelines, though.

## Approach: `if` statements

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

For more information, check the [`if` statements approach][approach-if].

## Approach: answer array

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

For more information, check the [Answer array approach][approach-answer-array].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between `if` statements and answers array can be made by perceived readability.

[trim]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim()
[endswith]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#endsWith(java.lang.String)
[dry]: https://en.wikipedia.org/wiki/Don%27t_repeat_yourself
[approach-if]: https://exercism.org/tracks/java/exercises/bob/approaches/if-statements
[approach-answer-array]: https://exercism.org/tracks/java/exercises/bob/approaches/answer-array
[jmh]: https://github.com/openjdk/jmh
