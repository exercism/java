# `filter()` and `distinct()` with `count()`

```java
public class PangramChecker {
    private final static int LETTERS_IN_ALPHABET = 26;

    public boolean isPangram(String input) {
        return input.toLowerCase().chars()
            .filter(Character::isLetter)
            .distinct()
            .count() == LETTERS_IN_ALPHABET;
    }
}
```

This approach starts be defining a [`private`][private] [`final`][final] [`static`][static] value for all `26` letters in the English alphabet.
It is `private` because it does not need to be directly accessed from outside the class,
and it is `final` because its value does not need to be changed once it is set.
It is `static` because it doesn't need to differ between object instantiations, so it can belong to the class itself.

The input `String` is lowercased and chained into the [`chars()`][chars] method.
Each character is passed as a primitive `int` representing its [Unicode codepoint][char] to the [`filter()`][filter] method.
The `filter()` passes each codepoint to the [`IsLetter()`][isletter-codepoint] method to filter in only letter characters.

~~~~exercism/note
Another method that could be used is [`isAlphabetic()`](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isAlphabetic-int-).
For the difference between `isAlphabetic()` and `isLetter()`, see [here](https://www.baeldung.com/java-character-isletter-isalphabetic).
~~~~

The the [`count()`][count] of the [`distinct()`][distinct] surviving codepoints are compared with the number of letters expected,
which for the English alphabet is `26`.

This works as long as the only letters in the input are in the English alphabet.
If the input was missing `a` but had `α`, then the distinct letters would be `26` but it would not be a Pangram for English.

[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[isletter-codepoint]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isLetter-int-
[distinct]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#distinct--
[count]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#count--
[char]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
