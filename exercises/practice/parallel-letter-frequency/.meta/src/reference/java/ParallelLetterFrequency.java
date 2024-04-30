import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ParallelLetterFrequency {
    private String letters;

    ParallelLetterFrequency(String[] texts) {
        this.letters = String.join("", texts)
                .replaceAll("[^\\p{L}a-zA-Z]", "")
                .toLowerCase();
    }

    Map<Character, Integer> countLetters() {
        return this.letters
                .chars()
                .mapToObj(i -> (char) i)
                .parallel()
                .collect(Counts::new, Counts::increment, Counts::combine)
                .buildMap();
    }

    private static class Counts {
        private Map<Character, Integer> letterCounts = new HashMap<>();

        private void increment(char letter) {
            letterCounts.put(letter, letterCounts.getOrDefault(letter, 0) + 1);
        }

        private void combine(Counts other) {
            other.letterCounts.keySet()
                    .forEach(letter -> letterCounts.merge(letter, other.letterCounts.get(letter), Integer::sum));
        }

        private Map<Character, Integer> buildMap() {
            return Collections.unmodifiableMap(letterCounts);
        }
    }
}
