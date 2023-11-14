# `IntStream` with `map()` and `sum()`

```java
import java.util.stream.IntStream;

public class Hamming {

    final private int difference;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        difference = IntStream
            .range(0, leftStrand.length())
            .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0)
            .sum();
    }

    public int getHammingDistance() {
        return difference;
    }
}
```

This approach starts by importing `java.util.stream.IntStream`.
It then defines a [`private`][private] [`final`][final] `int` variable to keep track of the difference between the strands.

After the validation code, the real work is done by the [`IntStream`][intstream].
It uses its [`range()`][range] method to iterate from `0` up to but not including the length of the left strand.
Each number is passed into the [`map()`][map] method.
For each value of `i`, the [lambda][lambda] function inside the `map()` method compares the values of the elements in the two strands at the index of `i`.
Using a [ternary operator][ternary], the `map()` method converts the index to `1` for only those indexes whose elements differ between the two strands.
Otherwise it converts the index value to `0`.
The difference variable is set to the [`sum()`][sum] of the converted indexes.

The `getHammingDistance()` method returns the difference variable, which is set to the correct value after the `IntStream` is done.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[range]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
[map]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#map-java.util.function.IntUnaryOperator-
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[ternary]: https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
[sum]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#sum--
