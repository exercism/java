# Introduction

There are at east a couple of ways to solve Collatz Conjecture.
One approach is to use a [`while`][while-loop] loop to iterate to the answer.
Another approach is to use `IntStream.iterate()` to iterate to the answer.

## Approach: `while` loop

```java
class CollatzCalculator {

    int computeStepCount(int start) {
        if (start < 1) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        
        int steps = 0;

        while (start > 1) {
            if ((start & 1) == 1) {
                start = start * 3 + 1;
            } else {
                start >>= 1;
            }
            steps++;
        }
        return steps;
    }
}
```

For more information, check the [`while` loop approach][approach-while-loop].

## Approach: `IntStream.iterate()`

```java
import java.util.stream.IntStream;

class CollatzCalculator {

    long computeStepCount(int start) {
        if (start < 1) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }

        return IntStream.iterate(start, num -> num != 1, num -> (num & 1) == 1 ? 3 * num + 1 : num >> 1).count();
    }
}
```

For more information, check the [`IntStream.iterate()` approach][approach-intstream-iterate].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between the `while` loop and `IntStream.iterate()` can be made by perceived readability.

[while-loop]: https://www.geeksforgeeks.org/java-while-loop-with-examples/
[approach-while-loop]: https://exercism.org/tracks/java/exercises/collatz-conjecture/approaches/while-loop
[approach-intstream-iterate]: https://exercism.org/tracks/java/exercises/collatz-conjecture/approaches/intstream-iterate
[jmh]: https://github.com/openjdk/jmh
