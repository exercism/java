# `BigInteger.pow()`

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

Other languages may have an exponential operator such as `**` or `^` to raise a number by a specified power.
Java does not have an exponential operator, but can use the [`BigInteger.pow()`][pow] method.

The `pow` method is nicely suited to the problem, since we start with one grain and keep doubling the number of grains on each successive square.
`1` grain is `BigIntger.valueOf(2).pow(0)`, `2` grains is `BigIntger.valueOf(2).pow(1)`, `4` grains is `BigIntger.valueOf(2).pow(2)`, and so on.
So, to get the right exponent, we subtract `1` from the `square` number.
The [`valueOf`][valueof] method is used to get `2` as a `BigInteger`.

For `grainsOnBoard`, the easiest way to get the total grains on all 64 squares is to get the value for an imaginary 65th square,
and then subtract 1 from it.
To understand how that works, consider a board that has only two squares.
If we could grow the board to three squares, then we could get the number of grains on the imaginary third square, which would be 4.
You could then [subtract][subtract] 4 by 1 (i.e. [`BigInteger.ONE`][one]) to get 3, which is the number of grains on the first square (1) and the second square (2).
Remembering that the exponent must be one less than the square you want,
you can call `BigIntger.valueOf(2).pow(64)` to get the number of grains on the imaginary 65th square.
Subtracting that value by 1 gives the values on all 64 squares.

[pow]: https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#pow(int)
[valueof]: https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#valueOf(long)
[subtract]: https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#subtract(java.math.BigInteger)
[one]: https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#ONE
