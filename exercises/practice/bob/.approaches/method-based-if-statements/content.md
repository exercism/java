# Method-Based `if` statements

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

In this approach, the different conditions for Bob’s responses are separated into dedicated private methods within the `Bob` class.
This method-based approach improves readability and modularity by organizing each condition check into its own method, making the main response method easier to understand and maintain.

## Explanation

This approach simplifies the main method `hey` by breaking down each response condition into helper methods:

### Trimming the Input

The `input` is trimmed using the `String` [`trim()`][trim] method to remove any leading or trailing whitespace.
This helps to accurately detect if the input is empty and should prompt a `"Fine. Be that way!"` response.

~~~~exercism/caution
Note that a `null` `string` would be different from a `String` of all whitespace.
A `null` `String` would throw a `NullPointerException` if `trim()` were applied to it.
~~~~

### Delegating to Helper Methods

Each condition is evaluated using the following helper methods:

1. **`isSilent`**: Checks if the trimmed input has no characters.
2. **`isShouting`**: Checks if the input is all uppercase and contains at least one alphabetic character, indicating shouting.
3. **`isQuestioning`**: Verifies if the trimmed input ends with a question mark.

This modular approach keeps each condition encapsulated, enhancing code clarity.

### Order of Checks

The order of checks within `hey` is important:

1. Silence is evaluated first, as it requires an immediate response.
2. Shouted questions take precedence over individual checks for shouting and questioning.
3. Shouting comes next, requiring its response if not combined with a question.
4. Questioning (a non-shouted question) is checked afterward.

This ordering ensures that Bob’s response matches the expected behavior without redundancy.

## Shortening

When the body of an `if` statement is a single line, both the test expression and the body _could_ be put on the same line, like so:

```java
if (isSilent(inputTrimmed)) return "Fine. Be that way!";
```

or the body _could_ be put on a separate line without curly braces:

```java
if (isSilent(inputTrimmed))
    return "Fine. Be that way!";
```

However, the [Java Coding Conventions][coding-conventions] advise always using curly braces for `if` statements, which helps to avoid errors.
Your team may choose to overrule them at its own risk.

[trim]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim()  
[coding-conventions]: https://www.oracle.com/java/technologies/javase/codeconventions-statements.html#449
