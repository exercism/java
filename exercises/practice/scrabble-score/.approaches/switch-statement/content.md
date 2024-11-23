# `switch` statement

```java
class Scrabble {
    private final int score;
    
    Scrabble(String word) {
        word = word.toLowerCase();
        int score = 0;
        
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
            case 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't':
                score += 1;
                break;
            case 'd', 'g':
                score += 2;
                break;
            case 'b', 'c', 'm', 'p':
                score += 3;
                break;
            case 'f', 'h', 'v', 'w', 'y':
                score += 4;
                break;
            case 'k':
                score += 5;
                break;
            case 'j', 'x':
                score += 8;
                break;
            case 'q', 'z':
                score += 10;
                break;
            default:
                break;
            }
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
Using the same name for a variable in a nested local scope that is used in its enclosing higher scope is called [variable shadowing](https://www.geeksforgeeks.org/shadowing-in-java/).
~~~~

The variable is updated  by a [`switch`][switch] statement that checks each letter of the lowercased word.

~~~~exercism/note
If most of the input will already be lower case, it is a bit more performant to normalize the input as lowercased, since fewer characters will need to be changed.
However, it may be considered that to use upper case letters is more readable.
~~~~

The letter is selected as a `char` by the [`charAt()`][charat] method and is passed to the `switch`, with each case representing the letters for a particular score.
When the loop is done, the class-level `score` variable is set to the value of the local `score` variable.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[for-loop]: https://www.geeksforgeeks.org/java-for-loop-with-examples/
[charat]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#charAt(int)
[switch]: https://www.geeksforgeeks.org/switch-statement-in-java/
