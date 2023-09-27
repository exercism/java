# `chars()` with `forEach()`

```java
class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        var acc = new IsbnAcc();
        stringToVerify.chars().forEach(acc::calc);
        return acc.isIsbn();
    }

}

class IsbnAcc {
    int sum = 0;
    int pos = 0;
    boolean allValidChars = true;

    boolean isIsbn() {
        return allValidChars && pos == 10 && sum % 11 == 0;
    }

    void calc(int codePoint) {
        if (Character.isDigit(codePoint)) {
            sum += (codePoint - '0') * (10 - pos);
            pos++;
            return;
        }
        if (codePoint == '-')
            return;
        if (codePoint == 'X' && pos == 9) {
            sum += 10;
            pos++;
            return;
        }
        allValidChars = false;
    }
}
```

This variant of validating as you go begins with instantiating an object which does the work of validating the letters and accumulating
their values for the ISBN string to be verified.
The object initializes its `sum` and `pos` variables to `0`, and its `allValidChars` variable to `true`.

The [`chars()`][chars] method is then called on the string.
Each [`Character`][char] is a Unicode codepoint that is passed into the [`forEach()`][foreach]method.
The `forEach` method passes the codepoint into the `calc()` method of the validating/accumulating object.

The `calc()` method starts by checking if the codepoint is a digit, which is the most likely condition.
If so, it gets the digit value of the codepoint by subtracting the [ASCII][ascii] value of `0` from its own ASCII value.
So, if the codepoint is a `0`, then subtracting the ASCII value of `0` from itself results in `0`.
If the codepoint is a `1`, then subtracting the ASCII value of `0` from the ASCII value of `1` results in `1`, and so on.

~~~~exercism/note/
Another way to convert the codepoint to a digit is to use the built-in
[`Character.digit()`](https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#digit(char,%20int))
method, which also works for [Unicode](https://docs.oracle.com/javase/tutorial/i18n/text/unicode.html) codepoints.
Since for this exercise all of the codepoints are ASCII, simple ASCII math will do. 
~~~~

The digit is multiplied by 10 minus the position, with the position starting at `0`.
So, for the position furthest to the left, the digit is multiplied by `10 - 0` (`10`).
For the position furthest to the right of a string whose length is `10`, the digit is multiplied by `10 - 9` (`1`).
The result of the multiplication is added to the `sum` variable.

The `pos` variable is incremented and the function returns.

If the codepoint is not a digit but a dash, the function returns without incrementing the `pos` variable.

If the codepoint is an `X` and the position is `9` (position `9` being at the end of a string whose length is `10`),
then `10` is added to the `sum`, `pos` is incremented, and the function returns.

If none of those legal conditions apply, then the codepoint is illegal and `allValidChars` is set to false.

After the `forEach()` is done, the `isValid()` function returns a call to the object's `isIsbn()` method.
The `isIsbn()` method first checks if all chars are valid.
If not, then the `&&` operator [short circuits][short-circuit] and returns false from the function.
If it is `true`, it then checks if the position is `10`.
If not, then the `&&` operator [short circuits][short-circuit] and returns false from the function.
If `true`, then the last check is if the `sum` is evenly divisible by `11`.
If all of the checks are `true`, the function returns `true`.

[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[char]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#unicode
[foreach]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#forEach-java.util.function.IntConsumer-
[ascii]: https://www.asciitable.com/
[short-circuit]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
