# Introduction

There are several ways to solve Pig Latin.
Some use regular expressions or replacing characters or a combination of both.
The regular expressions may be more or less readable (often less), and replacing characters can be expensive.
Another approach could use [`charAt()`][charat] and [`substring()`][substring-two] for both a readable and reasonably efficient way.

## General guidance

At the time of writing only four rules need to be handled, but if they have similar output, they don't need to be handled completely separately.

## Approach: `charAt()` and `substring()`

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class PigLatinTranslator {

    private static final HashSet < Character > vowels = new HashSet < Character > (Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final HashSet < String > specials = new HashSet < String > (Arrays.asList("xr", "yt"));

    public String translate(String phrase) {
        ArrayList < String > piggyfied = new ArrayList < String > ();
        var words = phrase.split(" ");

        for (String word: words) {
            if (vowels.contains(word.charAt(0)) || specials.contains(word.substring(0, 2))) {
                piggyfied.add(word + "ay");
                continue;
            }

            var length = word.length();
            
            for (int pos = 1; pos < length; pos++) {
                var letter = word.charAt(pos);
                if (vowels.contains(letter) || letter == 'y') {
                    if (letter == 'u' && word.charAt(pos - 1) == 'q') pos += 1;
                    piggyfied.add(word.substring(pos) + word.substring(0, pos) + "ay");
                    break;
                }
            }
        }
        return String.join(" ", piggyfied);
    }
}
```

For more information, check the [`charAt()` and `substring()` statements approach][approach-charat-substring].

[charat]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#charAt(int)
[substring-two]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#substring(int,%20int)
[approach-charat-substring]: https://exercism.org/tracks/java/exercises/pig-latin/approaches/charat-substring
