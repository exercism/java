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
        return stringBuilder.length() != 0 ? stringBuilder.toString() : Integer.toString(number);
    }
}
```

This approach starts be defining a [`StringBuilder`][stringbuilder] to build the result `String`.

A series of `if` statements uses the [remainder operator][remainder-operator] to check if the number is evenly divisible
by `3`, `5` or `7`.
If so, the corresponding drop `String` is [appended][append] by the `StringBuilder`.

After the `if` statements, a [ternary operator][ternary-operator] is used to check the `StringBuilder`.[`length()`][length].
If it is not `0`, then the `StringBuilder`.[`toString()`][sb-tostring] method is called and its value is returned.
If the length is `0`, then the number is converted to a string using [Integer.toString()][int-tostring] and is returned.

The use of `StringBuilder` may not be as performant for so few appends, due to the time it takes to instantiate the `StringBuilder`.
Other ways of building the result may be faster.

[stringbuilder]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
[remainder-operator]: https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/
[append]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#append(java.lang.String)
[ternary-operator]: https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
[length]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#length()
[sb-tostring]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#toString()
[int-tostring]: https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#toString-int-
