import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    public static final String AY = "ay";
    public static final String THR = "thr";
    public static final String SCH = "sch";
    public static final String CH = "ch";
    public static final String QU = "qu";
    public static final String TH = "th";
    public static final String QUAY = "quay";
    public static final String XR = "xr";
    public static final String YT = "yt";
    public static final String VOWELS_REGEX = "[aeiou]";

    public String translate(String sentence) {
        List<String> translatedWords = Arrays.asList(sentence.split(" "))
                .stream()
                .map(x -> translateWord(x))
                .collect(Collectors.toList());

        return String.join(" ", translatedWords);
    }

    private String translateWord(String word) {
        if (wordStartsWithVowelLike(word)) {
            return word + AY;
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
