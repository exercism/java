# Introduction

There are several idiomatic ways to solve Hamming.
One way is to use a [`for`][for] loop to iterate to a solution.
Other ways to iterate can use [`IntStream`][intstream].
`IntStream` can be used with its [`filter()`][filter] and [`count()`][count] methods.
Or `IntStream` could be used with its [`map()`][map] and [`sum()`][sum] methods.
`IntStream` could also be used with its [`reduce()`][reduce] method.

## Approach: `for ` loop

```java
public class Hamming {

    private int difference = 0;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
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
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
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
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
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
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
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
