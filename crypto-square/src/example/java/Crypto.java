import java.util.ArrayList;
import java.util.List;

public class Crypto {

    private String normalizedPlaintext;
    private int squareSize;

    public Crypto(String text) {
        this.normalizedPlaintext = normalizeText(text);
        this.squareSize = calculateSquareSize(normalizedPlaintext);
    }

    public String getNormalizedPlaintext() {
        return normalizedPlaintext;
    }

    public int getSquareSize() {
        return squareSize;
    }

    private static String normalizeText(String text) {
        return text.toLowerCase().codePoints()
                .filter(x -> Character.isLetterOrDigit(x))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int calculateSquareSize(String text) {
        return (int) Math.ceil(Math.sqrt(text.length()));
    }

    public List<String> getPlaintextSegments() {
        return getSegmentText(normalizedPlaintext, squareSize);
    }

    private static List<String> getSegmentText(String text, int squareSize) {
        List<String> segments = new ArrayList<>();
        int index = 0;

        while (index < text.length()) {
            if (index + squareSize < text.length()) {
                segments.add(text.substring(index, index + squareSize));
            } else {
                segments.add(text.substring(index));
            }
            index += squareSize;
        }

        return segments;
    }

    public String getCipherText() {
        StringBuilder cipherText = new StringBuilder(normalizedPlaintext.length());

        for (int index = 0; index < squareSize; index++) {
            for (String segment : getPlaintextSegments()) {
                if (index < segment.length()) {
                    cipherText.append(segment.charAt(index));
                }
            }
        }

        return cipherText.toString();
    }

    public String getNormalizedCipherText() {
        String cipher = getCipherText();

        return String.join(" ", getSegmentText(cipher, squareSize - 1));
    }
}
