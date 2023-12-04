# `for` loop

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

This approach starts by importing from packages for what will be needed.

In the `calculateHandshake()` method, a [`final`][final] [`List`][list ] is defined to hold the signals.
It is `final` because it does not need to be reassigned after it is created.

A series of variables are defined and initialized for normal looping through the `Signal` values collection.
Normal looping would start at index `0` and proceed by adding `1` to the index up to but not including
the length of the `Signal` values collection.

The number is then compared with `16` by using the [bitwise AND operator][and].

For example, given the bitwise value is `16` (binary `10000`) and the input is `24` (binary `11000`),
then `AND`ing `10000` with `11000` results in `10000`, which is not `0`, so the number contains bitwise`16`.

Given the bitwise value is `16` (binary `10000`) and the input is `8` (binary `01000`),
then `AND`ing `10000` with `01000` results in `00000`, which is `0`, so the number does not contain bitwise`16`.

If the number contains bitwise `16`, then the looping variables are set to iterate in reverse.

The `for` loop is set up with the looping variables.

In the body of the `for` loop, the [left shift operator][left-shift] is used
to shift `1` to the left for the number of places of the value of the `action` variable.
(The `action` variable is for the index in the `Signals` values collection.)
The bitwise AND operator is used to compare the bitwise value of the `Signals` index with the number.

For example, if the index is `2` (binary `010`) and the input is `6` (binary `110`),
then `AND`ing `010` with `110` results in `010`, which is not `0`, so the input contains bitwise`2`.

If the index value is `2` (binary `010`) and the input is `4` (binary `100`),
then `AND`ing `010` with `100` results in `000`, which is `0`, so the input does not contain bitwise `2`.

If the number contains the bitwise value of the index, then the `Signal` value at that index is added to the `List`.

After the `for` loop is done, the `List` is returned from `calculateHandshake()`.

[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[list]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
[and]: https://www.geeksforgeeks.org/java-logical-operators-with-examples/
[left-shift]: https://www.geeksforgeeks.org/left-shift-operator-in-java/
