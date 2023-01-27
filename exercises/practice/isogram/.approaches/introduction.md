# Introduction

There are at least a couple of idiomatic approaches to solving Isogram.
One is to use [`filter()`][filter] and [`map()`][map] with [`allMatch()`][allMatch].
Another is to use [`filter()`][filter] and [`mapToObj()`][maptoobj] with [`distinct()`][distinct].

## General guidance

The key to solving Isogram is to determine if any of the letters in the `String` being checked are repeated.
A repeated letter means the `String` is not an Isogram.
The occurrence of the letter `a` and the letter `A` count as a repeated letter, so `Alpha` would not be an isogram.

## Approach: `filter()` and `map()` with `allMatch()`

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

For more information, check the [`filter()` and `map()` with `allMatch()` approach][approach-filter-map-allmatch].

## Approach: `filter()` and `mapToObj()` with `distinct()`


```java
import java.util.stream.Collectors;

public class IsogramChecker {

    public boolean isIsogram(String input) {
        final var scrubbed = input.chars()
            .filter(Character::isLetter)
            .mapToObj(c -> Character.toLowerCase((char) c))
            .collect(Collectors.toList());

        return scrubbed.size() == scrubbed.stream().distinct().count();
    }
}
```

For more information, check the [`filter()` and `mapToObj()` with `distinct()` approach][approach-filter-maptoobj-distinct].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between the various approaches can be made by perceived readability.

Due to the short-circuiting of the `allMatch()` method, it is probably more performant than the `distinct()` method,
unless constructing the `HashSet` takes more time than constructing a short list and a short stream.

[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[map]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#map-java.util.function.IntUnaryOperator-
[allmatch]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#allMatch-java.util.function.IntPredicate-
[tolowercase-codepoint]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toLowerCase-int-
[tolowercase-char]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toLowerCase-char-
[distinct]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#distinct--
[count]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#count--
[maptoobj]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#mapToObj-java.util.function.IntFunction-
[char]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
[boxed]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#boxed--
[collect]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#collect-java.util.stream.Collector-
[size]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html#size--
[approach-filter-map-allmatch]: https://exercism.org/tracks/java/exercises/isogram/approaches/filter-map-allmatch
[approach-filter-maptoobj-distinct]: https://exercism.org/tracks/java/exercises/isogram/approaches/filter-maptoobj-distinct
[jmh]: https://github.com/openjdk/jmh
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[short-circuiting]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
[hashset]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashSet.html
[list]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
