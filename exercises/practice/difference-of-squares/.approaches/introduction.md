# Introduction

There are various ways to solve Difference of Squares.
One is to use an [`IntStream`][intstream] to iterate to a solution.
Another is to use a [formula][formula] to calculate the solution.

## Approach: `IntStream`

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

For more information, check the [`IntStream` approach][approach-intstream].

## Approach: Use formula

```java
class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = (input * (input + 1)) / 2;
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return (input * (input + 1) * ((input * 2) + 1)) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
```

For more information, check the [formula approach][approach-formula].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between using `IntStream` or formula may be based on the likelihood that using a formula of a few mathematical operations
will be faster than iterating many times to reach a solution.

[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[formula]: https://learnersbucket.com/examples/algorithms/difference-between-square-of-sum-of-numbers-and-sum-of-square-of-numbers/
[approach-intstream]: https://exercism.org/tracks/java/exercises/difference-of-squares/approaches/intstream
[approach-formula]: https://exercism.org/tracks/java/exercises/difference-of-squares/approaches/formula
[jmh]: https://github.com/openjdk/jmh
