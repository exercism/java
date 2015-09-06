import java.util.ArrayList;
import java.util.List;

public class Atbash {

    private static final int GROUP_SIZE = 5;
    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";

    public static String encode(String input) {
        String encoded = stripInvalidCharacters(input).toLowerCase();
        String cyphered = "";

        for (char c : encoded.toCharArray()) {
            cyphered += applyCipher(c);
        }

        return splitIntoFiveLetterWords(cyphered);
    }

    private static String stripInvalidCharacters(String input) {
        String filteredValue = "";

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredValue += c;
            }
        }

        return filteredValue;
    }

    private static char applyCipher(char input) {
        int idx = PLAIN.indexOf(input);

        return idx >= 0 ? CIPHER.toCharArray()[idx] : input;
    }

    private static String splitIntoFiveLetterWords(String value) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < value.length(); i += GROUP_SIZE) {
            words.add(i + GROUP_SIZE <= value.length() ? value.substring(i, i + GROUP_SIZE) : value.substring(i));
        }

        return String.join(" ", words);
    }
}
