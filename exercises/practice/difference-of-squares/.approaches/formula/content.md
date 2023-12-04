# Use formula

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

In this solution a [formula][formula] is used to solve the `computeSquareOfSumTo` and `computeSumOfSquaresTo` functions.

At the time of this writing the instructions state:

>You are not expected to discover an efficient solution to this yourself from first principles;
>research is allowed, indeed, encouraged. Finding the best algorithm for the problem is a key skill in software engineering.

It is fine to search for an algorithm on the internet.
This is also sometimes referred to as ["Google is your friend"][google-friend], although you don't have to search with Google.

It is okay if you don't understand how the algorithm works.
What is important is that it obviously is not introducing malware and that it passes the tests.

Note that this avoids using [`Math.pow()`][pow] in `computeSquareOfSumTo`,
since multiplying a value by itself is usually more efficient than type-casting from `int`to `double` back to `int`.

[formula]: https://learnersbucket.com/examples/algorithms/difference-between-square-of-sum-of-numbers-and-sum-of-square-of-numbers/
[google-friend]: https://en.wiktionary.org/wiki/Google_is_your_friend
[pow]: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#pow-double-double-
