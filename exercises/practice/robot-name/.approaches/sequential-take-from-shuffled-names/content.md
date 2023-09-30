# Sequentially take from shuffled names

```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

class Robot {
    private String name = RobotNameGen.GetName();
    
    public void reset() {
        name = RobotNameGen.GetName();
    }
    
    public String getName() {
        return name;
    }

    static class RobotNameGen {
        private static int namesIndex = -1;
        private static List < String > names = new ArrayList();
        
        static {
            IntStream.rangeClosed('A', 'Z')
                .forEach(letter1 -> IntStream.rangeClosed('A', 'Z').forEach(letter2 ->
                    IntStream.range(0, 1000).forEach(num ->
                        names.add(String.format("%c%c%03d", (char) letter1, (char) letter2, num)))));
            Collections.shuffle(names, new Random(System.currentTimeMillis()));
        }
        
        public static String GetName() {
            return names.get(++namesIndex);
        }
    }
}
```

This approach starts by importing from packages for what will be needed.

The work of generating the names is done by the nested [`static`][static] class `RobotNameGen` inside the `Robot` class.
It is `static` because it doesn't need to differ between object instantiations, so it can belong to the `Robot` class itself.

It defines an [`ArrayList`][arraylist] to hold the names, defined as [`private`][private], since it doesn't need to be seen outside the class.
It also defines an index to be used for getting an element from the `ArrayList`.

A [static initialization block][static-block] is used for populating the `ArrayList`.
The [`IntStream.rangeClosed()`][rangeclosed] method is used for generating an [`ASCII`][ascii] value from `A` through `Z`.
In a [`forEach()`][foreach] method, the first letter is passed to a [lambda][lambda] function which in turn calls `IntStream.rangeClosed()`
to generate the second letter.
In another `forEach()`, the second letter is passed in a lambda function that calls [`IntStream.range()`][range] to generate
a number from `0` up to but not including `1000`.

~~~~exercism/note
Note that the difference between `IntStream range()` and `IntStream rangeClosed()` is that the upper bound is _exclusive_
for `range()` and is _inclusive_ for `rangeClosed()`.
So, `IntStream.range(1, 10)` iterates from `1` up to but not including `10`,
and `IntStream.rangeClosed(1, 10)` iterates from `1` through `10`.
~~~~

The number is passed to a lambda which formats the two ASCII values and the number into a string.
The `%03d` [format specifier][format-specifiers] indicates having leading zeros for a number up to three places,
so the number `1` would be formated as `001` and the number `999`, already taking three places, would have no leading zeroes.
The formatted string is added to the `ArrayList`.

After all possible names are in the `ArrayList`, the `ArrayList` is [shuffled][shuffle],
seeding it with a new [`Random`][random] object initialized with the [current time in milliseconds][currenttimemillis].

Whenever a `Robot` object needs a new name, it calls the `RobotNameGen.GetName()` method.
The method increments the index and gets the name from the `ArrayList` at that index.
Since the index is initialized with `-1`, the first name will be taken from index `0`.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
[arraylist]: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
[static-block]: https://www.geeksforgeeks.org/static-blocks-in-java/
[ascii]: https://www.asciitable.com/
[rangeclosed]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#rangeClosed-int-int-
[foreach]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#forEach-java.util.function.IntConsumer-
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[range]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
[format-specifiers]: https://www.geeksforgeeks.org/format-specifiers-in-java/
[shuffle]: https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#shuffle(java.util.List)
[random]: https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
[currenttimemillis]: https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#currentTimeMillis--
