# Introduction

There are various idiomatic approaches to solve Grains.
You can use `BigInteger.pow()` to calculate the number on grains on a square.
Or you can use bit-shifting.

## General guidance

The key to solving Grains is to focus on each square having double the amount of grains as the square before it.
This means that the amount of grains grows exponentially.
The first square has one grain, which is `2` to the power of `0`.
The second square has two grains, which is `2` to the power of `1`.
The third square has four grains, which is `2` to the power of `2`.
You can see that the exponent, or power, that `2` is raised by is always one less than the square number.

| Square | Power | Value                   |
| ------ | ----- | ----------------------- |
| 1      | 0     | 2 to the power of 0 = 1 |
| 2      | 1     | 2 to the power of 1 = 2 |
| 3      | 2     | 2 to the power of 2 = 4 |
| 4      | 3     | 2 to the power of 3 = 8 |

## Approach: `BigInteger.pow()`

```java
import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if ((square <= 0) || (square >= 65)) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.valueOf(2).pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        return BigInteger.valueOf(2).pow(64).subtract(BigInteger.ONE);
    }
}
```

For more information, check the [`BigInteger.pow()` approach][approach-pow].

## Approach: Bit-shifting

```java
import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.ONE.shiftLeft(square - 1);
    }

    BigInteger grainsOnBoard() {
        return BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);
    }
}
```

For more information, check the [Bit-shifting approach][approach-bit-shifting].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between `pow` and bit-shifting can be made by perceived readability.

[approach-pow]: https://exercism.org/tracks/java/exercises/grains/approaches/pow
[approach-bit-shifting]: https://exercism.org/tracks/java/exercises/grains/approaches/bit-shifting
[jmh]: https://github.com/openjdk/jmh
