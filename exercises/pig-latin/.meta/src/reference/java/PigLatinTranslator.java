import java.util.Arrays;
import java.util.stream.Collectors;

class PigLatinTranslator {

    private static final String AY = "ay";
    private static final String THR = "thr";
    private static final String SCH = "sch";
    private static final String CH = "ch";
    private static final String QU = "qu";
    private static final String TH = "th";
    private static final String QUAY = "quay";
    private static final String XR = "xr";
    private static final String YT = "yt";
    private static final String VOWELS_REGEX = "[aeiou]";

    String translate(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(this::translateWord)
                .collect(Collectors.joining(" "));
    }

    private String translateWord(String word) {
        if (wordStartsWithVowelLike(word)) {
            return word + AY;
        }

        if (getLocationOfYAfterConsonantCluster(word) != -1) {
            int yPos = getLocationOfYAfterConsonantCluster(word);
            return word.substring(yPos) + word.substring(0, yPos) + AY;
        }

        if (wordStartsWithPrefixes(word, THR, SCH)) {
            return word.substring(3) + word.substring(0, 3) + AY;
        }

        if (wordStartsWithPrefixes(word, CH, QU, TH)) {
            return word.substring(2) + word.substring(0, 2) + AY;
        }

        if (wordStartsWithConsonantAndQu(word)) {
            return word.substring(3) + word.toCharArray()[0] + QUAY;
        }

        return word.substring(1) + word.toCharArray()[0] + AY;
    }

    private static int getLocationOfYAfterConsonantCluster(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if ((Character.toString(word.charAt(i)).matches(VOWELS_REGEX))) {
                return -1;
            } else if ((i != 0) && word.charAt(i) == 'y') {
                return i;
            }
        }
        return -1;
    }

    private boolean wordStartsWithVowelLike(String word) {
        return word.startsWith(YT) || word.startsWith(XR) || word.substring(0, 1).matches(VOWELS_REGEX);
    }

    private boolean wordStartsWithPrefixes(String word, String... prefixes) {
        return Arrays.stream(prefixes)
                .anyMatch(word::startsWith);
    }

    private boolean wordStartsWithConsonantAndQu(String word) {
        return word.substring(1).startsWith(QU);
    }
}
