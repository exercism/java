import java.util.ArrayList;
import java.util.List;

class CryptoSquare {

    private String ciphertext;

    CryptoSquare(String plaintext) {
        this.ciphertext = calculateCiphertext(plaintext);
    }

    String getCiphertext() {
        return ciphertext;
    }

    private String calculateCiphertext(String plaintext) {
        String normalizedPlaintext = normalizeText(plaintext);
        StringBuilder ciphertext = new StringBuilder(normalizedPlaintext.length());
        int squareSize = calculateSquareSize(normalizedPlaintext);

        for (int i = 0; i < squareSize; i++) {
            for (String segment : getSegments(normalizedPlaintext, squareSize)) {
                if (i < segment.length()) {
                    ciphertext.append(segment.charAt(i));
                } else {
                    ciphertext.append(" ");
                }
            }

            if (i < squareSize - 1) {
                ciphertext.append(" ");
            }
        }

        return ciphertext.toString();
    }

    private String normalizeText(String plaintext) {
        return plaintext.toLowerCase().codePoints()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private int calculateSquareSize(String normalizedPlaintext) {
        return (int) Math.ceil(Math.sqrt(normalizedPlaintext.length()));
    }

    private List<String> getSegments(String normalizedPlaintext, int squareSize) {
        List<String> segments = new ArrayList<>();

        for (int i = 0; i < normalizedPlaintext.length(); i += squareSize) {
            if (i + squareSize < normalizedPlaintext.length()) {
                segments.add(normalizedPlaintext.substring(i, i + squareSize));
            } else {
                segments.add(normalizedPlaintext.substring(i));
            }
        }

        return segments;
    }
}
