import java.util.*;
import java.util.stream.Collectors;

class Anagram {

    private final AnagramSubject anagramSubject;

    Anagram(String word) {
        anagramSubject = new AnagramSubject(word);
    }

    List<String> match(List<String> candidates) {
        return candidates.stream()
                .filter(anagramSubject::anagramOf)
                .collect(Collectors.toList());
    }

    static final class AnagramSubject {

        private final String word;
        private final char[] fingerprint;

        AnagramSubject(String other) {
            this.word = other;
            this.fingerprint = canonicalize(other);
        }

        boolean anagramOf(String other) {
            return !duplicate(other) && Arrays.equals(fingerprint, canonicalize(other));
        }

        private boolean duplicate(String other) {
            return word.equalsIgnoreCase(other);
        }

        private char[] canonicalize(String other) {
            char[] chars = other.toLowerCase().toCharArray();
            Arrays.sort(chars);
            return chars;
        }
    }
}

