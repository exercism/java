import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collections;

class ParallelLetterFrequency {
    private String letters;

    ParallelLetterFrequency(String[] texts) {
        this.letters = Arrays.stream(texts)
                .collect(Collectors.joining())
                .replaceAll("[^\\p{L}a-zA-Z]", "")
                .toLowerCase();
    }

    Map<Integer, Integer> letterCounts() {
        return this.letters
                .chars()
                .parallel()
                .collect(Counts::new, Counts::increment, Counts::combine)
                .buildMap();
    }

    private static class Counts {
        private Map<Integer, Integer> letterCounts = new HashMap<>();

        private void increment(int letter) {
            letterCounts.put(letter, letterCounts.getOrDefault(letter, 0) + 1);
        }

        private void combine(Counts other) {
            other.letterCounts.keySet()
                    .forEach(letter -> letterCounts.merge(letter, other.letterCounts.get(letter), Integer::sum));
        }

        private Map<Integer, Integer> buildMap() {
            return Collections.unmodifiableMap(letterCounts);
        }
    }
}
