# `for-each` loop

```java
class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        int sum = 0;
        int pos = 0;
        
        for (var chr: stringToVerify.toCharArray()) {
            if (Character.isDigit(chr)) {
                sum += (chr - '0') * (10 - pos);
                pos++;
                continue;
            }
            if (chr == '-')
                continue;
            if (chr == 'X' && pos == 9) {
                sum += 10;
                pos++;
                continue;
            }
            return false;
        }
        
        return pos == 10 && sum % 11 == 0;
    }

}
```

This variant of validating as you go begins with initializing its `sum` and `pos` variables to `0`.

A [`for-each`][for-each] loop is used to iterate the characters of the string to be verified.

A series of `if` statements begins by checking if the  `char` is a digit, which is the most likely condition.
If so, it gets the digit value of the `char` by subtracting the [ASCII][ascii] value of `0` from its own ASCII value.
So, if the `char` is a `0`, then subtracting the ASCII value of `0` from itself results in `0`.
If the `char` is a `1`, then subtracting the ASCII value of `0` from the ASCII value of `1` results in `1`, and so on.

~~~~exercism/note/
Another way to convert the `char` to a digit is to use the built-in
[`Character.digit()`](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isDigit-char-)
method, which also works for [Unicode](https://docs.oracle.com/javase/tutorial/i18n/text/unicode.html) `char`s.
Since for this exercise all of the `chars` are ASCII, simple ASCII math will do. 
~~~~

The digit is multiplied by 10 minus the position, with the position starting at `0`.
So, for the position furthest to the left, the digit is multiplied by `10 - 0` (`10`).
For the position furthest to the right of a string whose length is `10`, the digit is multiplied by `10 - 9` (`1`).
The result of the multiplication is added to the `sum` variable.

The `pos` variable is incremented and the loop [`continue`][continue]s.

If the `char` is not a digit but a dash, the loop continues without incrementing the `pos` variable.

If the `char` is an `X` and the position is `9` (position `9` being at the end of a string whose length is `10`),
then `10` is added to the `sum`, `pos` is incremented, and the loop continues.

If none of those legal conditions apply, then the `char` is illegal and the function immediately returns false.

After the `for-each` is done, the `pos` variable is checked if the position is `10`.
If not, then the `&&` operator [short circuits][short-circuit] and returns false from the function.
If it is `true`, the function then returns if the `sum` is evenly divisible by `11`.

[for-each]: https://www.geeksforgeeks.org/for-each-loop-in-java/
[ascii]: https://www.asciitable.com/
[continue]: https://www.geeksforgeeks.org/continue-statement-in-java/
[short-circuit]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
