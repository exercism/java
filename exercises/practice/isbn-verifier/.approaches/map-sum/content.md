# `map()` with `sum()`

```java
import java.util.stream.IntStream;

class IsbnVerifier {

    public boolean isValid(String s) {
        String scrubbed = s.replace("-", "");

        return scrubbed.matches("^([0-9]{10}|[0-9]{9}X)$") &&
            IntStream.range(0, scrubbed.length())
            .map(pos -> {
                var chr = scrubbed.charAt(pos);
                return (chr != 'X' ? chr - '0' : 10) * (10 - pos);
            })
            .sum() % 11 == 0;
    }
}
```

This variant of scrubbing and validating the data first starts by importing from packages for what is needed.

The `isValid()` method starts by calling [`replace()`][replace] to scrub out any dash characters.

The [`matches()`][matches] method is then called on the scrubbed string and is passed a [pattern][pattern]
which checks for a string of exactly ten digits or nine digits ending in an `X`.
If the string doesn't match the pattern, then the `&&` operator [short circuits][short-circuit] and returns false from the function.

If the string matches the pattern, then the [`IntStream`][intstream] [`range()`][range] method is called to generate
numbers from 0 up to but not including the length of the scrubbed string.
Each number is passed into a [lambda][lambda] which gets the character in the string at the position of the number.

If the character is not `X` then it is a digit whose value is determined by subtracting the [ASCII][ascii] value
of `0` from its own ASCII value.
So, if the character is a `0`, then subtracting the ASCII value of `0` from itself results in `0`.
If the character is a `1`, then subtracting the ASCII value of `0` from the ASCII value of `1` results in `1`,
and so on.

~~~~exercism/note/
Another way to convert the character to a digit is to use the built-in
[`Character.digit()`](https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#digit(char,%20int))
method, which also works for [Unicode](https://docs.oracle.com/javase/tutorial/i18n/text/unicode.html) digits.
Since for this exercise all of the digits are ASCII, simple ASCII math will do. 
~~~~

The digit is multiplied by 10 minus the position, with the position starting at `0`.
So, for the position furthest to the left, the digit is multiplied by `10 - 0` (`10`).
For the position furthest to the right of a string whose length is `10`, the digit is multiplied by `10 - 9` (`1`).

Each mapped value is passed into the [`sum()`][sum] method to be added up.
The function returns whether the `sum()` is evenly divisible by `11` or not.

[sum]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#sum--
[replace]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#replace(java.lang.CharSequence,%20java.lang.CharSequence)
[pattern]: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
[matches]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#matches(java.lang.String)
[short-circuit]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[range]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
[ascii]: https://www.asciitable.com/
