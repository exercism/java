import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    private String word;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> candidates) {
        ArrayList<String> result = new ArrayList<>();

        char[] word_chars = word.toCharArray();
        Arrays.sort(word_chars);

        for(String candidate: candidates) {
            String candidate_lower = candidate.toLowerCase();

            if (candidate_lower.length() != word.length() || (word.equals(candidate_lower))) {
                continue;
            }

            char[] candidate_chars = candidate_lower.toCharArray();
            Arrays.sort(candidate_chars);

            boolean equal = true;

            for(int i =0; i < candidate.length() && equal; i++) {
                if (candidate_chars[i] != word_chars[i]) {
                    equal = false;
                }
            }
            if(equal) result.add(candidate);
        }

        return result;
    }
}