# Introduction

In this exercise, we’re working on a program to determine Bob’s responses based on the tone and style of given messages.
Bob responds differently depending on whether a message is a question, a shout, both, or silence.
Various approaches can be used to implement this logic efficiently and cleanly, ensuring the code remains readable and easy to maintain.

## General guidance

When implementing your solution, consider the following tips to keep your code optimized and idiomatic:

- **Trim the Input Once**: Use [`trim()`][trim] only once at the start to remove any unnecessary whitespace.
- **Use Built-in Methods**: For checking if a message is a question, prefer [`endsWith("?")`][endswith] instead of manually checking the last character.
- **Single Determinations**: Use variables for `questioning` and `shouting` rather than calling these checks multiple times to improve efficiency.
- **DRY Code**: Avoid duplicating code by combining the logic for determining a shout and a question when handling shouted questions. Following the [DRY][dry] principle helps maintain clear and maintainable code.
- **Return Statements**: An early return in an `if` statement eliminates the need for additional `else` blocks, making the code more readable.
- **Curly Braces**: While optional for single-line statements, some teams may require them for readability and consistency.

## Approach: method-based `if` statements

```java
class Bob {
    String hey(String input) {
        var inputTrimmed = input.trim();
        
        if (isSilent(inputTrimmed)) {
           return "Fine. Be that way!";
        }
        if (isShouting(inputTrimmed) && isQuestioning(inputTrimmed)) {
            return "Calm down, I know what I'm doing!";
        }
        if (isShouting(inputTrimmed)) {
            return "Whoa, chill out!";
        }
        if (isQuestioning(inputTrimmed)) {
            return "Sure.";
        }
            
        return "Whatever.";
    }

    private boolean isShouting(String input) {
        return input.chars()
                    .anyMatch(Character::isLetter) &&
                input.chars()
                    .filter(Character::isLetter)
                    .allMatch(Character::isUpperCase);
    }

    private boolean isQuestioning(String input) {
        return input.endsWith("?");
    }

    private boolean isSilent(String input) {
        return input.length() == 0;
    }
}
```

This approach defines helper methods for each type of message—silent, shouting, and questioning—to keep each condition clean and easily testable.
For more details, refer to the [method-based `if` Statements Approach][approach-method-if].

## Approach: variable-based `if` statements

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

This approach uses variables to avoid rechecking whether Bob is silent, shouting or questioning.
For more details, refer to the [variable-based `if` Statements Approach][approach-variable-if].

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

This approach uses an array of answers and calculates the appropriate index based on flags for shouting and questioning.
For more details, refer to the [Answer Array Approach][approach-answer-array].

## Which Approach to Use?

The choice between the **Method-Based `if` Statements Approach**, **Variable-Based `if` Statements Approach**, and the **Answer Array Approach** depends on readability, maintainability, and efficiency:

- **Method-Based `if` Statements Approach**: This is clear and easy to follow but checks conditions multiple times, potentially affecting performance. Storing results in variables like `questioning` and `shouting` can improve efficiency but may reduce clarity slightly.
- **Variable-Based `if` Statements Approach**: This approach can be more efficient by avoiding redundant checks, but its nested structure can reduce readability and maintainability.
- **Answer Array Approach**: Efficient and compact, this method uses an array of responses based on flags for questioning and shouting. However, it may be less intuitive and harder to modify if more responses are needed.

Each approach offers a balance between readability and performance, with trade-offs in flexibility and clarity.

[trim]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim()
[endswith]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#endsWith(java.lang.String)
[dry]: https://en.wikipedia.org/wiki/Don%27t_repeat_yourself
[approach-method-if]: https://exercism.org/tracks/java/exercises/bob/approaches/method-based-if-statements
[approach-variable-if]: https://exercism.org/tracks/java/exercises/bob/approaches/variable-based-if-statements
[approach-answer-array]: https://exercism.org/tracks/java/exercises/bob/approaches/answer-array
