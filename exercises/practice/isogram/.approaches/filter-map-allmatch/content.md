# `filter()` and `map()` with `allMatch()`

```java
import java.util.HashSet;

final class IsogramChecker {

    boolean isIsogram(final String phrase) {
        return phrase.chars()
            .filter(Character::isLetter)
            .map(Character::toLowerCase)
            .allMatch(new HashSet < > ()::add);
    }
}
```

This approach starts by importing [`HashSet`][hashset].

In the `isIsogram()` method, the [`chars()`][chars] method is called on the input `String`.
Each character is passed as a primitive `int` representing its [Unicode codepoint][char] to the [`filter()`][filter] method.
The `filter()` passes each codepoint to the [`IsLetter()`][isletter-codepoint] method to filter in only letter characters.

~~~~exercism/note
Another method that could be used is [`isAlphabetic()`](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isAlphabetic-int-).
For the difference between `isAlphabetic()` and `isLetter()`, see [here](https://www.baeldung.com/java-character-isletter-isalphabetic).
~~~~

The surviving codepoints are passed to the [`map()`][map] method which converts the codepoints to lower case.

The lowercased codepoints are passed into the [`allMatch()`][allmatch] method which passes each codepoint
into the `HashSet`'s [`add()`][add] method.
The `add()` method returns `true` if the value is not already in the `HashSet` and `false` if the value is already in the `HashSet`.
If `add()` returns `false`, then the `allMatch()` method can know that it will never be `true` and [short-circuit][short-circuiting]
with a result of `false`.
If `add()` always returns `true`, then `allMatch()` will return `true`.

Finally, the result of `allMatch()` is returned from the `IsIsogram()` function.

[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[char]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
[isletter-codepoint]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isLetter-int-
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[map]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#map-java.util.function.IntUnaryOperator-
[allmatch]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#allMatch-java.util.function.IntPredicate-
[add]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashSet.html#add(E)
[short-circuiting]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
[hashset]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashSet.html
