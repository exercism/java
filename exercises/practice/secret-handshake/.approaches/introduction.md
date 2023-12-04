# Introduction

There are at least a couple of idiomatic ways to solve Secret Handshake.
One approach is to use an `IntStream` to iterate to the result.
Another approach can use a `for` loop to iterate to the result.

## General guidance

Regardless of the approach used, one thing to consider is the use of bitwise operations for comparing the binary values.

## Approach: `IntStream`

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

For more information, check the [`IntStream` approach][approach-intstream].

## Approach: `for` loop

```java
import java.util.List;
import java.util.Vector;

class HandshakeCalculator {

    List < Signal > calculateHandshake(int number) {

        final List < Signal > output = new Vector < Signal > ();
        int action = 0, action_incr = 1, end = Signal.values().length;

        if ((number & 16) != 0) {
            action = 3;
            action_incr = -1;
            end = -1;
        }

        for (; action != end; action += action_incr)
            if ((number & (1 << action)) != 0)
                output.add(Signal.values()[action]);

        return output;
    }
}
```

For more information, check the [`for` loop approach][approach-for-loop].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between the various approaches can be made by perceived readability.
Since the `for` loop does not reverse the list, it may be a bit more performant, but the list is so small
it does not matter much.

[approach-intstream]:  https://exercism.org/tracks/java/exercises/secret-handshake/approaches/intstream
[approach-for-loop]:  https://exercism.org/tracks/java/exercises/secret-handshake/approaches/for-loop
[jmh]: https://github.com/openjdk/jmh
