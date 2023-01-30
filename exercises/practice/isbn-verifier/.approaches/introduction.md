# Introduction

There ae at least a couple general ways to solve ISBN Verifier.
One approach is to scrub and validate the input first.
A variation of that aproach could then use [`map()`][map] and [`sum()`][sum] to iterate to the result.
Another approach is to validate as you go.
A variation of that approach could use [`chars()`][chars] and [`forEach()`][foreach] to iterate to the result.

## Approaches: `map()` with `sum()`

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

For more information, check the [`map()` with `sum()` approach][approach-map-sum].

## Approach: `chars()` with `forEach()`

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

For more information, check the [`chars()` with `forEach()` approach][approach-chars-foreach].


## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
the choice between the approaches can be made by perceived readability.

It might be thought that iterating to [`replace()`][replace] dash characters and then iterating again to check
a [regular expression patttern][pattern] might be less efficient than validating as you go,
but the string to be iterated is so short that it may not matter much.

[map]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#map-java.util.function.IntUnaryOperator-
[sum]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#sum--
[replace]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#replace(java.lang.CharSequence,%20java.lang.CharSequence)
[pattern]: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
[matches]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#matches(java.lang.String)
[chars]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#chars()
[foreach]: https://www.geeksforgeeks.org/for-each-loop-in-java/
[intstream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
[approach-map-sum]: https://exercism.org/tracks/java/exercises/isbn-verifier/approaches/map-sum
[approach-chars-foreach]: https://exercism.org/tracks/java/exercises/isbn-verifier/approaches/foreach
[jmh]: https://github.com/openjdk/jmh
