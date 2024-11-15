# `if` statements

```java
class Scrabble {
    private final int score;
    
    Scrabble(String word) {
        word = word.toUpperCase();
        int score = 0;
        
        for (int i = 0; i < word.length(); i++) {
            var ltr = word.substring(i, i + 1);
            if ("AEIOULNRST".contains(ltr))
                score += 1;
            else if ("DG".contains(ltr))
                score += 2;
            else if ("BCMP".contains(ltr))
                score += 3;
            else if ("FHVWY".contains(ltr))
                score += 4;
            else if ("K".contains(ltr))
                score += 5;
            else if ("JX".contains(ltr))
                score += 8;
            else if ("QZ".contains(ltr))
                score += 10;
        }
        this.score = score;
    }
    
    int getScore() {
        return score;
    }
}
```

This approach defines a [`private`][private] [`final`][final] variable to be returned by the `getScore()` method.
It is `private` because it does not need to be directly accessed from outside the class, and it is `final` because its value does not need to be changed once it is set.

In the constructor, a local variable is defined for being updated in the [`for` loop][for-loop].

~~~~exercism/note
Using the same for a variable in a nested local scope that is used in its enclosing higher scope is called [variable shadowing](https://www.geeksforgeeks.org/shadowing-in-java/).
~~~~

The variable is updated  by a series of `if` statements that checks each letter of the uppercased word.
The letter is selected as a `String` by the [`substring()`][substring] method and is passed to the [`contains()`][contains] method for the `String` representing the letters for a particular score.
The first `if` statement checks for the most common letters, and each succeeding `if` statement checks for letters less common than the statement before it.
When the loop is done, the class-level `score` variable is set to the value of the local `score` variable.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[for-loop]: https://www.geeksforgeeks.org/java-for-loop-with-examples/
[substring]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#substring(int,%20int)
[contains]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#contains(java.lang.CharSequence)
