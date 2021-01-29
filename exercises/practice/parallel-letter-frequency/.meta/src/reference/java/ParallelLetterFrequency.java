import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


class ParallelLetterFrequency {

    private static Map<Integer, Integer> letterFrequencyMap;
    private static final String NOT_A_LETTER = "\\P{L}+";


    ParallelLetterFrequency(String letters) {
        letterFrequencyMap = getMapFromLetters(letters.toLowerCase().replaceAll(NOT_A_LETTER, ""));
    }

    Map<Integer, Integer> getMapFromLetters(String letters) {
        return letters
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

    Map<Integer, Integer> letterCounts() {
        return letterFrequencyMap;
    }
}
