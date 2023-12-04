# `IntStream`

```java
import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = IntStream.rangeClosed(1, input).sum();
        return sum * sum;
    }
    
    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input)
            .map(num -> num * num)
            .sum();
    }
    
    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
```

This solution iterates using the [`rangeClosed()`][rangeclosed] method of the [`IntStream`][intstream] class.

~~~~exercism/note
The difference between `rangeClosed()` and [`range()`](https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-)
is that the ending bound is _inclusive_ for `rangeClosed()` and _exclusive_ for `range()`.
So, `IntStream.range(1, 10)` iterates from `1` up to but not including `10`,
and `IntStream.rangeClosed(1, 10)` iterates from `1` through `10`.
~~~~

In `computeSquareOfSumTo`, the numbers are added with the [`sum()`][sum] method.
The sum of the numbers is then multiplied by itself to get the square of the summed numbers.
Note it avoids using [`Math.pow()`][pow] here,
since multiplying a value by itself is usually more efficient than type-casting from `int`to `double` back to `int`.

In `computeSumOfSquaresTo`, each number is squared by multiplying it by itself inside the [`map()`][map] method.
Again, the number is multiplied by itself instead of using `pow()` and converting the `double` result back into an `int`.
All of the squared numbers are added using the [`sum()`][sum] method.

[rangeclosed]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#rangeClosed-int-int-
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[sum]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#sum--
[pow]: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#pow-double-double-
[map]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#map-java.util.function.IntUnaryOperator-
