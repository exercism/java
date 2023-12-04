# `IntStream` with `filter()` and `count()`

```java
import java.util.stream.IntStream;

public class Hamming {

    final private long difference;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        difference = IntStream
            .range(0, leftStrand.length())
            .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
            .count();
    }

    public long getHammingDistance() {
        return difference;
    }
}
```

This approach starts by importing `java.util.stream.IntStream`.
It then defines a [`private`][private] [`final`][final] `long` variable to keep track of the difference between the strands.

After the validation code, the real work is done by the [`IntStream`][intstream].
It uses its [`range()`][range] method to iterate from `0` up to but not including the length of the left strand.
Each number is passed into the [`filter()`][filter] method.
For each value of `i`, the [lambda][lambda] function inside the `filter()` method compares the values of the elements in the two strands at the index of `i`.
The `filter()` method filters in only those indexes whose elements differ between the two strands.
The difference variable is set to the [`count()`][count] of the surviving indexes.

The `getHammingDistance()` method returns the difference variable, which is set to the correct value after the `IntStream` is done.

Note that the `count()` method returns a `long` value.
In this approach, the difference variable was defined as `long`, and the return type of the `getHammingDistance()` method was changed
from `int` to `long`.
This is to prevent an `incompatible types: possible lossy conversion from long to int` compilation error.
The tests accept that, but another approach could keep the `getHammingDistance()` return value as `int` by explicitly casting the value returned from `count()`
to an `int`, like so:

```java
difference = (int) IntStream
    .range(0, leftStrand.length())
    .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
    .count();
```

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[range]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[count]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#count--
