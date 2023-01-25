# `if` statements

```java
class RaindropConverter {
    String convert(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number % 3 == 0) {
            stringBuilder.append("Pling");
        }
        if (number % 5 == 0) {
            stringBuilder.append("Plang");
        }
        if (number % 7 == 0) {
            stringBuilder.append("Plong");
        }
        if (stringBuilder.toString().isEmpty()) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
```

This approach starts be defining a [`StringBuilder`][stringbuilder] to concatenate the result.

A series of `if` statements uses the [remainder operator][remainder-operator] to check if the number is evenly divisible
by `3`, `5` or `7`.
If so, the corresponding drop `String` is [appended][append] by the `StringBuilder`.

After the `if` statements, the `StringBuilder`.[`toString()`][tostring] method is called and is checked if it [`isEmpty()`][isempty].
If so, the number is appended to the `StringBuilder`.
Finally, the `StringBuilder.toString()` is returned.

[stringbuilder]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
[remainder-operator]: https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/
[append]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#append(java.lang.String)
[tostring]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#toString()
[isempty]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#isEmpty()
