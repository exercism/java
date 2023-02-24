# `IntStream` with `parallel()`, `flatMap()` and `filter()`

```java
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class PythagoreanTriplet {
    public final Integer a;
    public final int b;
    public final double c;

    public PythagoreanTriplet(Integer a, int b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Triplets makeTripletsList() {
        return new Triplets();
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PythagoreanTriplet other)
            return this.hashCode() == other.hashCode();
        return false;
    }

}

class Triplets {
    private double num;
    private int limit = 0;

    public Triplets thatSumTo(double num) {
        this.num = num;
        return this;
    }

    public Triplets withFactorsLessThanOrEqualTo(int limit) {
        this.limit = limit;
        return this;
    }

    public List < PythagoreanTriplet > build() {
        int start = (int) Math.sqrt(num);
        if (limit == 0)
            limit = (int) num / 2;
        return IntStream.rangeClosed(start, limit).parallel().boxed()
            .flatMap(a -> IntStream.rangeClosed(a, limit).parallel()
                .filter(b -> {
                    var c = Math.sqrt(a * a + b * b);
                    return c % 1 == 0 && c <= limit && a + b + c == num;
                })
                .mapToObj(b -> new PythagoreanTriplet(a, b, Math.sqrt(a * a + b * b))))
            .toList();
    }
}
```

Many approaches will return an object of some kind of separate "builder" `class` from the `makeTripletsList()` method of the `PythagoreanTriplet` class.
This particular code does this by instantiating and returning a new object from its sibling `Triplets` `class`.

`Triplets` makes use of the [Fluent API][fluent-api] design so that its `withFactorsLessThanOrEqualTo()` and
`thatSumTo()` methods can be chained together.

The real work is done in its `build()` method.
If the `limit` has not been set by the `withFactorsLessThanOrEqualTo()` method, it is set to half of the desired sum.
Any higher limit would result in factors whose combined squared values would exceed the desired sum.
The starting value is set to be the square root of the desired sum, since any valid factor will be no less than the square root of the desired sum.
Constraining the starting and limit values instead of using `2` through the desired sum is a way of minimizing unneccesary calculations.

The [IntStream][intstream].[rangeClosed()][rangeclosed] method is used to generate numbers for `a` from the `start` value through the `limit` value.
The `IntStream` is chained to the [`parallel()`][parallel] method so that the calculations can take advantage of multiple processors.

The parallel `IntStream` is [`boxed()`][boxed] to convert the `IntStream` to a `Stream<Integer>` so its mapped `Stream`
can later be chained to [`toList()`][tolist].
The `Stream` of `Integers` is chained to the [`flatMap()`][flatmap] method that will flatten the `a` values with the `b` values into a `Stream`
of `PythagoreanTriplet`s (instead of being a `Stream` of a `Stream` of `PythagoreanTriplet`s).
This takes place in a [lambda] that is passed the `a` value.

The `b` values are generated from an `IntStream.rangeClosed()` that starts with the value for `a` and goes through the `limit` value.
The `IntStream` for the `b` values is also chained to the `parallel()` method.

The `b` stream is then chained to the [`filter()`][filter] method to be run through some checks.
To prepare for the checks, the `c` value is calculated from the square root of `a` squared plus `b` squared.
The first check is for determing if `c` is a whole number. If it is not, then the logical AND operator (`&&`)
[short circuits][short-circuit].
The second check is for determining that `c` is less than or equal to the `limit`.
The final check is for determing that the sum of `a`, `b`, and `c` is equal to the desired sum.

The surviving `b` values are chained to the [`mapToObj()`][maptoobj] method, in which a `PythagoreanTriplet`object is instantiated
from `a`, `b`, and the recalculated value for `c`, which is computed from the square root of `a` squared plus `b` squared.

It is possible that the filtering of the `b` values and the mapping to a `PythagoreanTriplet` object could happen in the same iteration
due to [loop fusion][loop-fusion].

The `Stream` of `PythagoreanTriplet` objects is finally chained to [`toList()`][tolist], whose result is returned from the `build()` method.

[fluent-api]: https://dzone.com/articles/java-fluent-api-design
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[parallel]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#parallel--
[rangeclosed]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#rangeClosed-int-int-
[boxed]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#boxed--
[flatmap]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#flatMap-java.util.function.IntFunction-
[maptoobj]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#mapToObj-java.util.function.IntFunction-
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[short-circuit]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
[loop-fusion]: https://stackoverflow.com/questions/42804226/loop-fusion-of-stream-in-java-8-how-it-works-internally
[toList]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#toList--
