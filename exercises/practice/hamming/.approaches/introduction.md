# Introduction

There are several idiomatic ways to solve Hamming.
One way is to use a [`for`][for] loop to iterate to a solution.
Another way to iterate can use [`IntStream`][intstream].
`IntStream` can be used with its [`filter()`][filter] and [`count()`][count] methods.
Or `IntStream` could be used with its [`map()`][map] and [`sum()`][sum] methods.
`IntStream` could also be used with its [`reduce()`][reduce] method.

## General guidance

Regardless of the approach used, one thing to look out for is to whether to calculate the hamming distance
in the constructor (or a method called by the constructor) or in the `getHammingDistance()` method.
A benefit to calculating in the constructor is that the distance is calculated only once,
no matter how many times `getHammingDistance()` is called.
A benefit to calculating in `getHammingDistance()` is that, if it is not called,
then the calculation never has to be performed.
But then, in that case, why instantiate the `Hamming` object at all?

## Approach: `for` loop

```java
public class Hamming {

    private int difference = 0;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        for (int i = 0; i < leftStrand.length(); i++){
            if (leftStrand.charAt(i) != rightStrand.charAt(i)){
                difference++;
            }
        }
    }

    public int getHammingDistance() {
        return difference;
    }
}
```

For more information, check the [`for` loop approach][approach-for-loop].

## Approach: `IntStream` with `filter()` and `count()`

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

For more information, check the [`IntStream` with `filter()` and `count()` approach][approach-intstream-filter-count].

## Approach: `IntStream` with `map()` and `sum()`

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

For more information, check the [`IntStream` with `map()` and `sum()` approach][approach-intstream-map-sum].

## Approach: `IntStream` with `reduce()`

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

For more information, check the [`IntStream` with `reduce()` approach][approach-intstream-reduce].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between the various approaches can be made by perceived readability.

Of the `IntStream` approaches, the `reduce()` approach likely might be fastest, as it is only one iteration
instead of an iteration for `filter()` or `map()` and another iteration for `count()` or `sum()`.

The `for` loop may also be fast, but it leaves a mutable member variable for the distance, instead of one marked [`final`][final].

[for]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[count]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#count--
[map]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#map-java.util.function.IntUnaryOperator-
[sum]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#sum--
[reduce]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#reduce-int-java.util.function.IntBinaryOperator-
[approach-for-loop]:  https://exercism.org/tracks/java/exercises/hamming/approaches/for-loop
[approach-intstream-filter-count]:  https://exercism.org/tracks/java/exercises/hamming/approaches/intstream-filter-count
[approach-intstream-map-sum]:  https://exercism.org/tracks/java/exercises/hamming/approaches/intstream-map-sum
[approach-intstream-reduce]:  https://exercism.org/tracks/java/exercises/hamming/approaches/intstream-reduce
[jmh]: https://github.com/openjdk/jmh
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
