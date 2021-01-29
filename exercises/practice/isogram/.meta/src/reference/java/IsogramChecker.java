import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

class IsogramChecker {

    boolean isIsogram(String word) {

        Set<Character> charSet = new HashSet<>();

        String[] words = word.split(" ");
        String newWord = concat(words);

        words = newWord.split("-");
        newWord = concat(words).toLowerCase();

        for (int i = 0; i < newWord.length(); i++) {
            charSet.add(newWord.charAt(i));
        }

        return charSet.size() == newWord.length();
    }

    private String concat(String[] words) {
        return stream(words).collect(joining());
    }

}
