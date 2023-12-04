# Introduction

There are many ways to solve Pythagorean Triplet.
One approach could use a [`for` loop][for-loop] nested inside another `for` loop.
Another approach could use an [`IntStream`][intstream] with [`parallel()`][parallel], [`flatMap()`][flatmap] and [`filter()`][filter].

## General Guidance

An important consideration to solving Pythagoren Triplet is to calculate efficiently enough so that the tests don't time out.

## Approach: `for` loops

```java
import java.util.*;

public class PythagoreanTriplet {

    private final int a;
    private final int b;
    private final int c;

    private PythagoreanTriplet() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTriplet().createBuilder();
    }

    private PythagoreanTripletBuilder createBuilder() {
        return new PythagoreanTripletBuilder();
    }

    public class PythagoreanTripletBuilder {
        private final List < PythagoreanTriplet > triplets = new ArrayList < > ();
        private int limit = 0;
        private int sum = 0;

        public PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int limit) {
            this.limit = limit;
            return this;
        }

        public PythagoreanTripletBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }

        public List < PythagoreanTriplet > build() {
            if (limit == 0)
                limit = sum / 2;
            int start = (int) Math.sqrt(sum);
            for (int a = start; a <= limit; a++) {
                for (int b = a; b <= limit; b++) {
                    double c = Math.sqrt(a * a + b * b);
                    if (c % 1 == 0 && c <= limit && a + b + c == sum) {
                        triplets.add(new PythagoreanTriplet(a, b, (int) c));
                    }
                }
            }

            return triplets;
        }
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
```

For more information, check the [`for` loops approach][approach-for-loops].

## Approach: `IntStream` with `parallel()`, `flatMap()` and `filter()`

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

For more information, check the [`IntStream` with `parallel()`, `flatmap()` and `filter()` approach][approach-intstream-parallel-flatmap-filter].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between `for` loops and `IntStream` with `parallel()`, `flatmap()` and `filter()` can be made by perceived readability.

However, depending on the amount of cores available in the machine being run, running `IntStream`s in parallel has a good chance
of being considerably faster than nested `for` loops.
But the nested `for` loops may be more readable than the more functional approach, especially for those not used to functional programming.
So if the nested `for` loops approach is fast enough, it may be preferred for readability.

[for-loop]: https://www.geeksforgeeks.org/java-for-loop-with-examples/
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[parallel]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#parallel--
[flatmap]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#flatMap-java.util.function.IntFunction-
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[approach-for-loops]: https://exercism.org/tracks/java/exercises/pythagorean-triplets/approaches/for-loops
[approach-intstream-parallel-flatmap-filter]: https://exercism.org/tracks/java/exercises/pythagorean-triplets/approaches/if-intstream-parallel-flatmap-filter
[jmh]: https://github.com/openjdk/jmh
