# Introduction

There are several idiomatic ways to solve Raindrops.
One is to use a series of `if` statements.
Another way is to use a `Map`.

## General guidance

The key to solving Raindrops is to know if the input is evenly divisible by `3`, `5` and/or `7`.
For determining that, you will use the [remainder operator][remainder-operator], also known as the modulo operator.

## Approach: `if` statements

```java
class RaindropConverter {
    String convert(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number % 3 == 0) {
            stringBuilder.append("Pling");
        }
        if (number % 5 == 0) {
            stringBuilder.append("Plang");
        }
        if (number % 7 == 0) {
            stringBuilder.append("Plong");
        }
        return stringBuilder.length() != 0 ? stringBuilder.toString() : Integer.toString(number);
    }
}
```

For more information, check the [`if` statements approach][approach-if-statements].

## Approach: `Map`

```java
import java.util.Map;
import java.util.TreeMap;

class RaindropConverter {
    private static final TreeMap < Integer, String > lookup = new TreeMap < Integer, String > (
        Map.of(3, "Pling", 5, "Plang", 7, "Plong"));
        
    String convert(int number) {
        var output = new StringBuilder("");
        lookup.forEach((divisor, drop) -> {
            if (number % divisor == 0)
                output.append(drop);
        });
        return output.length() != 0 ? output.toString() : Integer.toString(number);
    }
}
```

For more information, check the [`Map` approach][approach-map].

## Which approach to use?

Benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
but it's likely that the series of `if` statements is faster than creating and iterating a `Map`.
An advantage for `Map` is that, if another type of raindrop were to be added, only another entry would be added to the `Map`,
and no other code would need to be added.

[remainder-operator]: https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/
[approach-if-statements]: https://exercism.org/tracks/java/exercises/raindrops/approaches/if-statements
[approach-map]: https://exercism.org/tracks/java/exercises/raindrops/approaches/map
[jmh]: https://github.com/openjdk/jmh
