# `HashMap` with `reduce()`

```java
import java.util.HashMap;
import java.util.stream.IntStream;

class Scrabble {

    private final int savedScore;
    private final static HashMap < Integer, Integer > lookup = new HashMap(26);
    private final static String[] letters = {
        "AEIOULNRST",
        "DG",
        "BCMP",
        "FHVWY",
        "K",
        "JX",
        "QZ"
    };
    private final static int[] scores = {
        1,
        2,
        3,
        4,
        5,
        8,
        10
    };

    static {
        IntStream.range(0, letters.length)
            .forEach(index -> letters[index].chars().forEach(letter -> lookup.put(letter, scores[index])));
    }

    Scrabble(String word) {
        savedScore = word.toUpperCase().chars().reduce(0, (score, letter) -> score + lookup.get(letter));
    }

    int getScore() {
        return savedScore;
    }

}
```

This approach starts by importing from packages for what is needed.

A [`private`][private] [`final`][final] variable is defined to be returned by the `getScore()` method.
It is `private` because it does not need to be directly accessed from outside the class, and it is `final` because its value does not need to be changed once it is set.

Several `private` `final` [`static`][static] variables are then defined:

- a [`HashMap`][hashmap] to hold the lookups of the scores for the letters
- a `String` array of the letters grouped by their common score
- an `int` array of the scores for the letters

They are `static` because they don't need to differ between object instantiations, so they can belong to the class itself.

In a [static block][static-block], the [`IntStream.range()`][range] method is called to iterate an index from `0` up to but including the length of the array of letters.
In a [`forEach()`][foreach] method, each index value is passed into a [lambda][lambda] which calls the [`chars{}`][chars] method on each string at the index of the letters array.
In another `forEach`, each letter is passed into a lambda that adds the letter and its corresponding score to the `HashMap`.
This works because the groups of letters and their scores are at the same index in their respective arrays.

In the constructor, `chars()` is called on the uppercased word and chained to the [`reduce()`][reduce] method.
The accumulator is initialized to `0`, and the accumulator and each letter is passed to a lambda that adds the score looked up from the `HashMap` for the letter.
The score variable is set to the value returned from `reduce()`, which is the value of its accumulator.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
[hashmap]: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
[static-block]: https://www.geeksforgeeks.org/static-blocks-in-java/
[range]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
[foreach]: https://docs.oracle.com/javase/9/docs/api/java/util/Map.html#forEach-java.util.function.BiConsumer-
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[reduce]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#reduce-int-java.util.function.IntBinaryOperator-
