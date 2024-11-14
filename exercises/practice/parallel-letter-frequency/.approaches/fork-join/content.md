# `Fork/Join`

```java
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

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

        ForkJoinPool forkJoinPool = new ForkJoinPool(); 
        forkJoinPool.invoke(new LetterCountTask(texts, 0, texts.size(), letterCount));
        forkJoinPool.shutdown();

        return letterCount;
    }

    private static class LetterCountTask extends RecursiveTask<Void> {
        private static final int THRESHOLD = 10; 
        private final List<String> texts;
        private final int start;
        private final int end;
        private final ConcurrentMap<Character, Integer> letterCount;

        LetterCountTask(List<String> texts, int start, int end, ConcurrentMap<Character, Integer> letterCount) {
            this.texts = texts;
            this.start = start;
            this.end = end;
            this.letterCount = letterCount;
        }

        @Override
        protected Void compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    for (char c : texts.get(i).toLowerCase().toCharArray()) {
                        if (Character.isAlphabetic(c)) {
                            letterCount.merge(c, 1, Integer::sum);
                        }
                    }
                }
            } else {
                int mid = (start + end) / 2;
                LetterCountTask leftTask = new LetterCountTask(texts, start, mid, letterCount);
                LetterCountTask rightTask = new LetterCountTask(texts, mid, end, letterCount);
                invokeAll(leftTask, rightTask); 
            }
            return null;
        }
    }
}
```

Using [`ConcurrentHashMap`][ConcurrentHashMap] ensures that frequency counting and updates are safely handled in a parallel environment.

If there are no strings, a validation step prevents unnecessary processing.

A [`ForkJoinPool`][ForkJoinPool] is then created.
The core of [`ForkJoinPool`][ForkJoinPool] is the Fork/Join mechanism, which divides tasks into smaller units and processes them in parallel.

`THRESHOLD` is the criterion for task division.
If the range of texts exceeds the `THRESHOLD`, the task is divided into two subtasks, and [`invokeAll(leftTask, rightTask)`][invokeAll] is called to execute both tasks in parallel.
Each subtask in `LetterCountTask` will continue calling `compute()` (via `invokeAll(leftTask, rightTask)`) to divide itself further until the range is smaller than or equal to the `THRESHOLD`.
For tasks that are within the `THRESHOLD`, letter frequency is calculated.  

The [`Character.isAlphabetic`][isAlphabetic] method identifies all characters classified as alphabetic in Unicode, covering characters from various languages like English, Korean, Japanese, Chinese, etc., returning `true`.
Non-alphabetic characters, including numbers, special characters, and spaces, return `false`.

Additionally, since uppercase and lowercase letters are treated as the same character (e.g., `A` and `a`), each character is converted to lowercase.

After updating letter frequencies, the final map is returned.

[ConcurrentHashMap]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html
[ForkJoinPool]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html
[isAlphabetic]: https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isAlphabetic-int-
[invokeAll]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html
