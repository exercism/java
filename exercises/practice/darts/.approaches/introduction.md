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

    private static final double INNER_RING = 1.0;
    private static final double MIDDLE_RING = 5.0;
    private static final double OUTER_RING = 10.0;

    int score(double x, double y) {
        var pointRadius = (Math.sqrt((x * x) + (y * y)));
        DoublePredicate thrownOutside = ring -> pointRadius > ring;

        if (thrownOutside.test(OUTER_RING))
            return 0;
        if (thrownOutside.test(MIDDLE_RING))
            return 1;
        if (thrownOutside.test(INNER_RING))
            return 5;
        return 10;
    }
}
```

For more information, check the [`DoublePredicate` approach][approach-doublepredicate].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between `if` statements and `DoublePredicate` can be made by perceived readability.

[magic-numbers]: https://en.wikipedia.org/wiki/Magic_number_(programming)
[jmh]: https://github.com/openjdk/jmh
[approach-if-staements]: https://exercism.org/tracks/java/exercises/darts/approaches/if-statements
[approach-doublepredicate]: https://exercism.org/tracks/java/exercises/darts/approaches/doublepredicate
