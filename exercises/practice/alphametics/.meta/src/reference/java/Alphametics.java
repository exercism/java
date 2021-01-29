import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Alphametics {
    private final List<String> wordsToSum;
    private final String wordResult;

    Alphametics(String userInput) {
        String[] questionAndAnswer = userInput.split("==");
        wordsToSum = Arrays.stream(questionAndAnswer[0].split("\\+"))
                .map(String::new)
                .map(String::trim)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        wordResult = questionAndAnswer[1].trim();
    }

    Map<Character, Integer> solve() throws UnsolvablePuzzleException {
        AlphameticsRecursion solver = new AlphameticsRecursion(getDistinctCharacters());
        solver.generate();
        return solver.get().orElseThrow(UnsolvablePuzzleException::new);
    }

    /**
     * Returns the list of distinct characters in this alphametic puzzle.
     */
    private List<Character> getDistinctCharacters() {
        Set<Character> distinctCharacters = new LinkedHashSet<>();
        wordsToSum.forEach(word -> distinctCharacters.addAll(toChar(word)));
        distinctCharacters.addAll(toChar(wordResult));

        return new ArrayList<>(distinctCharacters);
    }

    private List<Character> toChar(String toChar) {
        return toChar.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    private class AlphameticsRecursion {
        private final List<Character> characters;
        private LinkedHashMap<Character, Integer> validPermutation;

        private AlphameticsRecursion(List<Character> characters) {
            this.characters = characters;
        }

        private void generate() {
            generate(new LinkedHashMap<>(), 0, new boolean[10]);
        }

        private void generate(LinkedHashMap<Character, Integer> permutation, int index, boolean[] isDigitsUsed) {
            // base case
            if (index == characters.size()) {
                if (!isLeadingDigitZero(permutation) && isSumTally(permutation)) {
                    validPermutation = new LinkedHashMap<>(permutation);
                }
                return;
            }

            for (int i = 0; i <= 9; i++) { // loop through digits 0 to 9
                if (isDigitsUsed[i]) {
                    continue;
                }

                permutation.put(characters.get(index), i);
                isDigitsUsed[i] = true;
                generate(permutation, index + 1, isDigitsUsed);
                isDigitsUsed[i] = false;
            }
        }

        private Optional<LinkedHashMap<Character, Integer>> get() {
            return Optional.ofNullable(validPermutation);
        }

        /**
         * Returns true if the mapping letters to digits using {@code letterToDigit} will result in having zero as a
         * leading digit.
         */
        private boolean isLeadingDigitZero(Map<Character, Integer> letterToDigit) {
            return letterToDigit.keySet().stream()
                    .filter(key -> letterToDigit.get(key) == 0) // Find the character that is mapped to digit 0
                    .filter(charMappedToZero -> wordResult.charAt(0) == charMappedToZero // If the first character in
                                                                                         // wordResult is mapped to 0
                            || wordsToSum.stream() // If the first character in any of wordsToSum is mapped to 0
                            .map(word -> word.charAt(0))
                            .anyMatch(character -> character == charMappedToZero))
                    .count() == 1; // One letter maps to zero and is a leading character
        }

        /**
         * Returns true if the {@code letterToDigit} solves the alphametic puzzle.
         */
        private boolean isSumTally(Map<Character, Integer> letterToDigit) {
            long actualSum = wordsToSum.stream()
                    .mapToLong(word -> mapToNumber(letterToDigit, word))
                    .sum();
            long expectedSum = mapToNumber(letterToDigit, wordResult);
            return actualSum == expectedSum;
        }

        /**
         * Returns the long value of {@code word}, mapped using {@code letterToDigit}.
         */
        private long mapToNumber(Map<Character, Integer> letterToDigit, String word) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                int digit = letterToDigit.get(word.charAt(i));
                builder.append(digit);
            }

            return Long.parseLong(builder.toString());
        }
    }
}
