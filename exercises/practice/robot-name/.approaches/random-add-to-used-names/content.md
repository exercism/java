# Randomly add to used names

```java
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Robot {
    private static final Set < String > usedNames = new HashSet();
    private static final Random random = new Random();

    private String name;

    public Robot() {
        reset();
    }
    public String getName() {
        return name;
    }
    public void reset() {
        usedNames.remove(this.name);
        String name;
        while (usedNames.contains(name = generateName())) {
            continue;
        }
        usedNames.add(name);
        this.name = name;
    }
    private static String randomString(char fromChar, char toChar, int len) {
        return random.ints(fromChar, toChar + 1).limit(len)
            .mapToObj(ch -> Character.toString((char) ch))
            .collect(Collectors.joining());
    }
    private static String generateName() {
        return randomString('A', 'Z', 2) + randomString('0', '9', 3);
    }
}
```

This approach starts by importing from packages for what will be needed.

A [`HashSet`][hashset] to hold the used names is defined as [`private`][private] [`static`][static] and [`final`][final].
It is `private` because it doesn't need to be seen outside the class.
It is `static` because it doesn't need to differ between object instantiations, so it can belong to the class itself.
It is `final` because it does not need to be redefined after it is created.
A [`Random`][random] object is instantiated the same way.

The high-level work is done in the `reset()` method.
At the time of this writing the tests don't specify if names can be re-used.
However, they do test that a reset name is not the same as the old name.
By removing the used name first, a slight possibility exists that the new randomly generated name could be the same as the old name
and fail the test.
If removing a name from the used names, it might be best to delay doing it until after the new name is generated.

`reset()` will keep randomly generating a new name until it is not contained in the used names.
As the collection of used names increases in size, the chance for collision between a new name and a used name also increases.
After thousands of names have been generated, a lot of processing time can be spent generating names
that have already been used.
It will take more and more tries before generating a name that hasn't been used.

The low-level work is done by the `randomString()` method.
It uses the [`Random.ints()`][random-ints] method which takes a lower bound (inclusive) and upper bound (exclusive).
For example, if passed in a `fromChar` of `A` and a `toChar` of `Z`, `1` is added to `toChar` so that the random int
will be an [`ASCII`][ascii] value picked from `A` through `Z`.

The [`mapToObj()`][maptoobj] method is used to convert the `ASCII` value for the `char` into a `String`.

The [`joining`][joining] [`Collector`][collector] is passed to the [`collect()`][collect] method to assemble the returned `String`.

`randomString()` is called by the `generateName()` method to return two letters from `A` through `Z` and three digits from `0` through `9`.

A possible optimization could be to generate the numeric part of the name as one number instead of three separate digits.
`String.format("%03d")` would come in handy for that.
The `%03d` [format specifier][format-specifiers] indicates having leading zeros for a number up to three places,
so the number `1` would be formated as `001` and the number `999`, already taking three places, would have no leading zeroes.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[hashset]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashSet.html
[random]: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
[random-ints]: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#ints-int-int-
[ascii]: https://www.asciitable.com/
[maptoobj]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#mapToObj-java.util.function.IntFunction-
[joining]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#joining--
[collector]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
[collect]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#collect-java.util.stream.Collector-
[format-specifiers]: https://www.geeksforgeeks.org/format-specifiers-in-java/
