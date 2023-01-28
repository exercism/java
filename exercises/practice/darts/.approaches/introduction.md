# Introduction

There are at least a couple ways to solve Darts.
One approach can use a series of `if` statements.
Another approach could use a `DoublePredicate`.

## General guidance

Regardless of which approach is used, one consideration can be whether to use [magic numbers][magic-numbers] for some values
as opposed to variables with meaningful names.

## Approach: `if`  statements

```java
import java.lang.Math;

class Darts {

    int score(double x, double y) {
        var radius = (Math.sqrt((x * x) + (y * y)));
        
        if (radius > 10)
            return 0;
        if (radius > 5)
            return 1;
        if (radius > 1)
            return 5;
        return 10;
    }
}
```

For more information, check the [`if` statements approach][approach-if-staements].

## Approach: `DoublePredicate`

```java
import java.util.function.DoublePredicate;

class Darts {

    final private static double innerRing = 1.0;
    final private static double middleRing = 5.0;
    final private static double outerRing = 10.0;

    int score(double x, double y) {
        var pointRadius = (Math.sqrt((x * x) + (y * y)));
        DoublePredicate outside = ring -> pointRadius > ring;

        if (outside.test(outerRing))
            return 0;
        if (outside.test(middleRing))
            return 1;
        if (outside.test(innerRing))
            return 5;
        return 10;
    }
}
```

For more information, check the [`DoublePredicate` approach][approach-doublepredicate].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between `if` statements and `DoublePredicate` can be made by perceived readability.

[doublepredicate]: https://docs.oracle.com/javase/9/docs/api/java/util/function/DoublePredicate.html
[magic-numbers]: https://en.wikipedia.org/wiki/Magic_number_(programming)
[jmh]: https://github.com/openjdk/jmh
[approach-if-staements]: https://exercism.org/tracks/java/exercises/dart/approaches/if-statements
[approach-doublepredicate]: https://exercism.org/tracks/java/exercises/dart/approaches/doublepredicate
