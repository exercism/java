import java.util.ArrayList;
import java.util.List;

public class Atbash {

    private static final int GROUP_SIZE = 5;
    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";

    public String encode(String input) {
        String encoded = stripInvalidCharacters(input).toLowerCase();
        String cyphered = "";

        for (char c : encoded.toCharArray()) {
            cyphered += applyCipher(c);
        }

        return splitIntoFiveLetterWords(cyphered);
    }

    public String decode(String input) {
        String encoded = stripInvalidCharacters(input).toLowerCase();
        String deciphered = "";

        for (char c : encoded.toCharArray()) {
            deciphered += applyCipher(c);
        }

        return deciphered;
    }

    private String stripInvalidCharacters(String input) {
        String filteredValue = "";

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredValue += c;
            }
        }

        return filteredValue;
    }

    private char applyCipher(char input) {
        int idx = PLAIN.indexOf(input);

        return idx >= 0 ? CIPHER.toCharArray()[idx] : input;
    }

    private String splitIntoFiveLetterWords(String value) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < value.length(); i += GROUP_SIZE) {
            words.add(i + GROUP_SIZE <= value.length() ? value.substring(i, i + GROUP_SIZE) : value.substring(i));
        }

        return String.join(" ", words);
    }
}
