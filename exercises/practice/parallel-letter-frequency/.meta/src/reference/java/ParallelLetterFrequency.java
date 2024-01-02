import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class ParallelLetterFrequency {
    private Map<Character, Integer> letterFrequencyMap;
    private String letter;

    ParallelLetterFrequency(String[] letters) {
        this.letterFrequencyMap = new HashMap<>();
        this.letter = Arrays.stream(letters)
                .collect(Collectors.joining())
                .replaceAll("[^\\p{L}a-zA-Z]", "");
    }

    Map<Character, Integer> letterCounts() {

        if (letter.length() == 0) {
            return letterFrequencyMap;
        }

        for (char ch : letter.toCharArray()) {
            ch = Character.toLowerCase(ch);
            letterFrequencyMap.put(ch, letterFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        return letterFrequencyMap;
    }

}
