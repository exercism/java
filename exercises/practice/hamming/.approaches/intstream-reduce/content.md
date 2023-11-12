# `IntStream` with `reduce()`

```java
import java.util.stream.IntStream;

public class Hamming {

    final private int difference;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        difference = IntStream.range(0, leftStrand.length()).reduce(0,
            (hamcount, index) -> hamcount + (leftStrand.charAt(index) != rightStrand.charAt(index) ? 1 : 0));
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
Each number is passed into the [`reduce()`][reduce] method, whose accumulator is initialized to `0`.
For each value of `index`,
the [lambda][lambda] function inside the `reduce()` method compares the values of the elements in the two strands at the index of `index`.
Using a [ternary operator][ternary], the `reduce()` method adds `1` to the accumulator for only those indexes whose elements differ between the two strands.
Otherwise it adds `0`.
The difference variable is set to the value returned from the `reduce()` method, which is the value of its accumulator.

The `getHammingDistance()` method returns the difference variable, which is set to the correct value after the `IntStream` is done.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[range]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
[reduce]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#reduce-int-java.util.function.IntBinaryOperator-
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[ternary]: https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
