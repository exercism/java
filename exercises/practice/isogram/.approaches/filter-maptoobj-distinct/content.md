# `filter()` and `mapToObj()` with `distinct()`

```java
import java.util.stream.Collectors;

public class IsogramChecker {

    public boolean isIsogram(String input) {
        final var scrubbed = input.chars()
            .filter(Character::isLetter)
            .mapToObj(Character::toLowerCase)
            .collect(Collectors.toList());

        return scrubbed.size() == scrubbed.stream().distinct().count();
    }
}
```

This approach starts by importing [`Collectors`][collectors].

In the `isIsogram()` method, the [`chars()`][chars] method is called on the input `String`.
Each character is passed as a primitive `int` representing its [Unicode codepoint][char] to the [`filter()`][filter] method.
The `filter()` passes each codepoint to the [`IsLetter()`][isletter-codepoint] method to filter in only letter characters.

~~~~exercism/note
Another method that could be used is [`isAlphabetic()`](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isAlphabetic-int-).
For the difference between `isAlphabetic()` and `isLetter()`, see [here](https://www.baeldung.com/java-character-isletter-isalphabetic).
~~~~

The surviving codepoints are passed to the [`mapToObj()`][maptoobj] method which converts each codepoint to a lowercased codepoint.

The `collect()` method assembles the lowercased codepoints into a [`List`][list] of codepoint `Integer`s.
The [`size()`][size] of the `List` is compared with the [`count()`][count] of the [`distinct()`][distinct] letters in the `List`.
If they are equal, then there are no duplicate letters and the comparison returns `true` from the `isIsogram()` method.
If they are not equal, then there are one or more duplicate letters and the comparison returns `false` from the `isIsogram()` method.

[collectors]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[isletter-codepoint]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isLetter-int-
[maptoobj]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#mapToObj-java.util.function.IntFunction-
[char]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
[list]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
[size]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html#size--
[distinct]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#distinct--
[count]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#count--
