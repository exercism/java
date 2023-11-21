# `IntStream.iterate()`

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

This approach starts by importing from packages for what is needed.

The real work begins by calling the [`IntStream.iterate()`][intstream-iterate] method which is passed the input number
as the initial element.
Before each iteration a [lambda][lambda] is used to check if the input number is not the value of `1`.
If the value is not `1`, the iteration runs.
If the value is `1`, then all iteration stops.

Another lambda is used to process the input number.
[Bitwise operators][bitwise-operators] are used to check if the number is odd and to divide it in half if it is even.
The bitwise AND operator (`&`) compares the number with `1` to see if it is odd.

~~~~exercism/note
Another way to go about checking if the number is even or odd is to see if it is evenly divided by `2`
by using the [modulo (also know as the remainder) operator](https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/).
So, to see if it is even we could use `start % 2 == 0`.
That might be slightly less performant but perhaps more readable for intent, especially for those who don't "speak binary".
~~~~

If the number is even, then the right shift operator (`>>`) shifts all of the bits once to the right, which is the equivalent
of dividing the number by `2`.
Another way would be to use the division operator `start \ 2` which might be slighly less performant but more readable
for intent, especially for those who don't "speak binary".

When the input number is the value of `1`, then the [`count()`][count] method is called to count the number of iteratons for the
[`IntStream`][intstream].
The function returns the result of the `count()` method.

[intstream-iterate]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/stream/IntStream.html#iterate(int,java.util.function.IntPredicate,java.util.function.IntUnaryOperator)
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[bitwise-operators]: https://www.geeksforgeeks.org/java-logical-operators-with-examples/
[count]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/stream/IntStream.html#count()
[intstream]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/stream/IntStream.html
