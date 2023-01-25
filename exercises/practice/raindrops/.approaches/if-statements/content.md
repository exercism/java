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

TODO
