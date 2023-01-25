# `Map`

```java
import java.util.Map;
import java.util.TreeMap;

class RaindropConverter {
    private static final TreeMap < Integer, String > lookup = new TreeMap < Integer, String > (
        Map.of(3, "Pling", 5, "Plang", 7, "Plong"));
        
    String convert(int number) {
        var output = new StringBuilder("");
        lookup.forEach((divisor, drop) -> {
            if (number % divisor == 0)
                output.append(drop);
        });
        return output.length() != 0 ? output.toString() : Integer.toString(number);
    }
}
```

This approach begins by importing `Map` and `TreeMap`.

A [`private`][private] [`static`][static] [`final`][final] [`TreeMap`][treemap] is defined for efficient sorting of keys.
It is `private` because it doesn't need to be seen outside the class.
It is `static` because it doesn't need to differ between object instantiations, so it can belong to the class itself.
It is `final` because it does not need to be changed after it is created.
The [`Map.of()`][mapof] method is used to populate the map.

A [`StringBuilder`][stringbuilder] is defined to build the result `String`.

The [`forEach()`][foreach] method is used to iterate the map entries.
The [remainder operator][remainder-operator] is used to check if the number is evenly divisible
by the key of the map entry.
If so, the value of the map entry is [appended][append] by the `StringBuilder`.

After the `forEach()` is done, a [ternary operator][ternary-operator] is used to check the `StringBuilder`.[`length()`][length].
If it is not `0`, then the `StringBuilder`.[`toString()`][sb-tostring] method is called and its value is returned.
If the length is `0`, then the number is converted to a string using [Integer.toString()][int-tostring] and is returned.

The use of `StringBuilder` may not be as performant for so few appends, due to the time it takes to instantiate the `StringBuilder`.
Other ways of building the result may be faster.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
[treemap]: https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
[stringbuilder]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
[foreach]: https://docs.oracle.com/javase/9/docs/api/java/util/Map.html#forEach-java.util.function.BiConsumer-
[remainder-operator]: https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/
[append]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#append(java.lang.String)
[ternary-operator]: https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
[length]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#length()
[sb-tostring]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#toString()
[int-tostring]: https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#toString-int-
[mapof]: https://docs.oracle.com/javase/9/docs/api/java/util/Map.html#of-K-V-K-V-K-V-
