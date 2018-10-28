import java.util.ArrayList;
import java.util.List;

class AffineCipher {
    private static final int GROUP_SIZE = 5;
    private static final int ALPHABET_SIZE = 26;
    private static final int ALPHABET_START_UNICODE = 97;

    private enum Mode {
        ENCODE,
        DECODE
    }

    String encode(String plainMessage, int keyA, int keyB) {
        return splitIntoFiveLetterWords(
                translate(plainMessage, keyA, keyB, Mode.ENCODE));
    }

    String decode(String cipheredMessage, int keyA, int keyB) {
        return translate(cipheredMessage, keyA, keyB, Mode.DECODE);
    }

    private static int modInverse(int keyA) {
        int keyAMod = Math.floorMod(keyA, ALPHABET_SIZE);
        for (int n = 1; n < ALPHABET_SIZE; n++) {
            if (Math.floorMod(keyAMod * n, ALPHABET_SIZE) == 1) {
                return n;
            }
        }
        return 1;
    }

    private static String splitIntoFiveLetterWords(String text) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < text.length(); i += GROUP_SIZE) {
            words.add(text.substring(i, Math.min(text.length(), i + GROUP_SIZE)));
        }

        return String.join(" ", words);
    }

    private static String translate(String text, int keyA, int keyB, Mode mode) {
        int inv = modInverse(keyA);
        if (inv == 1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }

        StringBuilder stringBuilder = new StringBuilder();

        text.chars()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .forEach(c -> {
                    int orig = c - ALPHABET_START_UNICODE;
                    if (orig < 0) {
                        stringBuilder.appendCodePoint(c);
                    } else {
                        if (mode == Mode.ENCODE) {
                            stringBuilder.appendCodePoint(
                                    ALPHABET_START_UNICODE + Math.floorMod(keyA * orig + keyB, ALPHABET_SIZE)
                            );
                        } else if (mode == Mode.DECODE) {
                            stringBuilder.appendCodePoint(
                                    ALPHABET_START_UNICODE + Math.floorMod(inv * (orig - keyB), ALPHABET_SIZE)
                            );
                        }
                    }
                });

        return stringBuilder.toString();
    }

}
