# `containsAll()`

```java
import java.util.Arrays;

public class PangramChecker {

    public boolean isPangram(String input) {
        return Arrays.asList(input.toLowerCase().split(""))
            .containsAll(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
    }
}
```

This approach starts by importing from packages for what is needed.

The input `String` is lowercased and chained into the [`split()`][split] method to create an array of `String`s.
The enclosing [`Arrays.asList()`][aslist] method converts the `String` array into a [`List`][list] of `String`s.

~~~~exercism/note
The `chars()` and `toCharArray()` methods won't work for `Arrays.asList()` because they produce primitive `int`s or `char`s
respectively.
For `Arrays.asList()` to work as desired, it must take an array of reference types.
The `split()` method is used here because it returns an array of `String`s, and `String` is a reference type.
~~~~

The `List` of input character `String`s is chained to the [`containsAll()`][containsall] method.
A `String` `List` of the English lowercase letters is passed to `containsAll()`.
If all letters in the English alphabet are contained in the input, then `containsAll()` returns `true`,
otherwise it returns `false`.
Because the condition is for all English letters being in the input, the input does not need to have non-letters filtered out.

[split]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String)
[aslist]: https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#asList-T...-
[list]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
[containsall]: https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html#containsAll-java.util.Collection-
