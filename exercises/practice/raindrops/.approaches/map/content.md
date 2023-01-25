# `Map`

```java
import java.util.function.BiFunction;
import java.util.Map;
import java.util.TreeMap;

class RaindropConverter {
    final private static BiFunction < String, Integer, String > Default = (val, defaultVal) -> (!val.isEmpty()) ? val :
        String.valueOf(defaultVal);
    final private static TreeMap < Integer, String > lookup = new TreeMap < Integer, String > (
        Map.of(3, "Pling", 5, "Plang", 7, "Plong"));
        
    String convert(int number) {
        var output = new StringBuilder("");
        lookup.forEach((divisor, drop) -> {
            if (number % divisor == 0)
                output.append(drop);
        });
        return Default.apply(output.toString(), number);
    }
}
```

TODO
