# Introduction

There are at least a couple ways to solve Pangram.
One approach is to use [`filter()`][filter] and [`distinct()`][distinct] with [`count()`][count].
Another approach is to use [`containsAll()`][containsall].

## General Guidance

- One way to look the problem can be "Does the input string have all of the letters in the alphabet?"
- Another way to look at the problem is "Are all of the letters in the alphabet in the input string?"

# Approach: `filter()` and `distinct()` with `count()`

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
For more information, check the [`filter()` and `distinct()` with `count()` approach][approach-filter-distinct-count].

## Approach: `containsAll()`

```java
import java.util.Arrays;

public class PangramChecker {

    public boolean isPangram(String input) {
        return Arrays.asList(input.toLowerCase().split(""))
            .containsAll(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
    }
}
```

For more information, check the [`containsAll()` approach][approach-containsall].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between the various approaches can be made by perceived readability.

[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[aslist]: https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#asList-T...-
[tolowercase-codepoint]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toLowerCase-int-
[tolowercase-char]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toLowerCase-char-
[distinct]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#distinct--
[count]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#count--
[containsall]: https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html#containsAll-java.util.Collection-
[char]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
[approach-filter-distinct-count]: https://exercism.org/tracks/java/exercises/pangram/approaches/filter-distinct-count
[approach-containsall]: https://exercism.org/tracks/java/exercises/pangram/approaches/containsall
[jmh]: https://github.com/openjdk/jmh
[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
[short-circuiting]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
[list]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
