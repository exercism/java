# Introduction

There are multiple ways to solve the Parallel Letter Frequency problem.
One approach is to use [`Stream.parallelStream`][stream], and another involves using [`ForkJoinPool`][ForkJoinPool].

## General guidance

To count occurrences of items, a map data structure is often used, though arrays and lists can work as well.
A [`map`][map], being a key-value pair structure, is suitable for recording frequency by incrementing the value for each key.
If the data being counted has a limited range (e.g., `Characters` or `Integers`), an `int[] array` or [`List<Integer>`][list] can be used to record frequencies.

Parallel processing typically takes place in a multi-[`thread`][thread] environment.
The Java 8 [`stream`][stream] API provides methods that make parallel processing easier, including the [`parallelStream()`][stream] method.
With [`parallelStream()`][stream], developers can use the [`ForkJoinPool`][ForkJoinPool] model for workload division and parallel execution, without the need to manually manage threads or create custom thread pools.

The [`ForkJoinPool`][ForkJoinPool] class, optimized for dividing and managing tasks, makes parallel processing efficient.
However, [`parallelStream()`][stream] uses the common [`ForkJoinPool`][ForkJoinPool] by default, meaning multiple [`parallelStream`][stream] instances share the same thread pool unless configured otherwise.  

As a result, parallel streams may interfere with each other when sharing this thread pool, potentially affecting performance.
Although this doesn’t directly impact solving the Parallel Letter Frequency problem, it may introduce issues when thread pool sharing causes conflicts in other applications.  
Therefore, a custom [`ForkJoinPool`][ForkJoinPool] approach is also provided below.

## Approach: `parallelStream`

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
        if (!letterCount.isEmpty() || texts.isEmpty()) {
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

For more information, check the [`parallelStream` approach][approach-parallel-stream].

## Approach: `Fork/Join`

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
        if (!letterCount.isEmpty() || texts.isEmpty()) {
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

For more information, check the [`fork/join` approach][approach-fork-join].

## Which approach to use?

When tasks are simple or do not require a dedicated thread pool (such as in this case), the [`parallelStream`][stream] approach is recommended.
However, if the work is complex or there is a need to isolate thread pools from other concurrent tasks, the [`ForkJoinPool`][ForkJoinPool] approach is preferable.

[thread]: https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
[stream]: https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
[ForkJoinPool]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html
[map]: https://docs.oracle.com/javase/8/docs/api/?java/util/Map.html
[list]: https://docs.oracle.com/javase/8/docs/api/?java/util/List.html
[approach-parallel-stream]:  https://exercism.org/tracks/java/exercises/parallel-letter-frequency/approaches/parallel-stream
[approach-fork-join]:  https://exercism.org/tracks/java/exercises/parallel-letter-frequency/approaches/fork-join
