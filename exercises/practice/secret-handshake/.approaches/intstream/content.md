# `IntStream`

```java
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class HandshakeCalculator {

    public List < Signal > calculateHandshake(int n) {
        IntPredicate isBitOn = bitIndex -> ((1 << bitIndex) & n) > 0;

        List < Signal > signals = IntStream.range(0, Signal.values().length)
            .filter(isBitOn)
            .mapToObj(i -> Signal.values()[i])
            .collect(Collectors.toList());

        if (isBitOn.test(Signal.values().length)) {
            Collections.reverse(signals);
        }
        
        return signals;
    }
}
```

This approach starts by importing from packages for what will be needed.

In the `calculateHandshake()` method, an [`IntPredicate`][intpredicate] is defined which takes an `int` argument and returns a `bool` value.
The `int` argument is passed to a [lambda][lambda] which shifts `1` to the left for the number of places of the value of the `int` index.
It does this by use of the [left shift operator][left-shift].
So, if the bit index is `2`, then `1` would be shifted left two places for a binary value of `0100`, which is decimal `4`.
It then compares the bitwise value with the `int` argument to the `calculateHandshake()` method by using the [bitwise AND operator][and].

~~~~exercism/note
Although the argument to `calculateHandshake()` is not directly passed to the lambda, the lambda can use it.
To do so is called [capturing](https://www.geeksforgeeks.org/java-lambda-expression-variable-capturing-with-examples/) the variable.
To capture a variable, it must be in the enclosing [scope](https://www.geeksforgeeks.org/variable-scope-in-java/)
of the lambda, and it must be effectively `final`,
meaning that is is not changed in the course of the program.
~~~~

If comparing the bitwise value with the input results in a non-zero bitwise value, then the input contains the value of the bitwise value.

For example, if the bitwise value is `2` (binary `010`) and the input is `6` (binary `110`),
then `AND`ing `010` with `110` results in `010`, which is not `0`, so the input contains bitwise`2`.

If the bitwise value is `2` (binary `010`) and the input is `4` (binary `100`),
then `AND`ing `010` with `100` results in `000`, which is `0`, so the input does not contain bitwise `2`.

An [`IntStream`][intstream] is defined which uses its [`range()`][range] method to iterate from `0` up to but not including
the length of the values collection in the `Signals` enum.
The numbers correspond with the indexes of the `Signal` values.

Each index is passed to the [`filter()`][filter] method, where it is passed to the `IntPredicate` for filtering in
only those indexes that are contained in the input number.

The surviving index numbers are passed into the [`mapToObj()`][maptoobj] method which takes the index in its lambda
and returns the `Signal` value at that index.

The [`collect()`][collect] method assembles the matching `Signal` values into a [`List`][list].

The `IntPredicate` is used once more to compare the input number with the bitwise value `16` (binary `10000`).
The bit index of `4` to pass in happens to be the length of the `Signal` values collection.
If the input contains bitwise `16`, then the `List` is [reversed][reverse].

Finally, the `List` is returned from `calculateHandshake()`.

[intpredicate]: https://docs.oracle.com/javase/9/docs/api/java/util/function/IntPredicate.html
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[left-shift]: https://www.geeksforgeeks.org/left-shift-operator-in-java/
[and]: https://www.geeksforgeeks.org/java-logical-operators-with-examples/
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[range]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
[filter]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#filter-java.util.function.IntPredicate-
[maptoobj]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#mapToObj-java.util.function.IntFunction-
[collect]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#mapToObj-java.util.function.IntFunction-
[list]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
[reverse]: https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#reverse(java.util.List)
