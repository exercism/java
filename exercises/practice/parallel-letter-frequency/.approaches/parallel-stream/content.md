# `parallelStream`

```java
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

class ParallelLetterFrequency {

    List<String> texts;
    ConcurrentMap<Character, Integer> letterCount;

    ParallelLetterFrequency(String[] texts) {
        this.texts = List.of(texts);
        letterCount = new ConcurrentHashMap<>();
    }

    Map<Character, Integer> countLetters() {
        if (texts.isEmpty()) {
            return letterCount;
        }
        texts.parallelStream().forEach(text -> {
            for (char c: text.toLowerCase().toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    letterCount.merge(c, 1, Integer::sum);
                }
            }
        });
        return letterCount;
    }

}
```

Using [`ConcurrentHashMap`][ConcurrentHashMap] ensures that frequency counting and updates are safely handled in a parallel environment.

If there are no strings to process, a validation step avoids unnecessary computation.

To calculate letter frequency, a parallel stream is used.  
The [`Character.isAlphabetic`][isAlphabetic] method identifies all characters classified as alphabetic in Unicode, covering characters from various languages like English, Korean, Japanese, Chinese, etc., returning `true`.
Non-alphabetic characters, including numbers, special characters, and spaces, return `false`.

Since we treat uppercase and lowercase letters as the same character (e.g., `A` and `a`), characters are converted to lowercase.

After updating letter frequencies, the final map is returned.

[ConcurrentHashMap]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html
[isAlphabetic]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isAlphabetic-int-
