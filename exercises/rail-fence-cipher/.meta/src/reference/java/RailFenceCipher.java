import java.util.Arrays;

class RailFenceCipher {

    private int key;

    RailFenceCipher(int key) {
        this.key = key;
    }

    String getEncryptedData(String message) {
        String[] lines = splitIntoLines(message, false);
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            result.append(line);
        }
        return result.toString();
    }

    String getDecryptedData(String message) {
        String[] lines = splitIntoLines(message, true);

        int charCount = 0;
        for (int i = 0; i < key; ++i) {
            while (lines[i].contains("?")) {
                String letter = String.valueOf(message.charAt(charCount));
                lines[i] = lines[i].replaceFirst("\\?", letter);
                charCount++;
            }
        }

        StringBuilder result = new StringBuilder();
        int lineCount = 0;
        int direction = -1;
        for (int i = 0; i < message.length(); ++i) {
            String letter = String.valueOf(lines[lineCount].charAt(0));
            lines[lineCount] = lines[lineCount].substring(1);
            result.append(letter);
            direction *= lineCount == 0 || lineCount == key - 1 ? -1 : 1;
            lineCount += direction;
        }
        return result.toString();
    }

    private String[] splitIntoLines(String message, boolean encrypted) {
        String[] result = generateEmptyStrings(key);
        int lineCount = 0;
        int direction = -1;
        for (char c : message.toCharArray()) {
            String letter = String.valueOf(c);
            result[lineCount] += encrypted ? "?" : letter;
            direction *= lineCount == 0 || lineCount == key - 1 ? -1 : 1;
            lineCount += direction;
        }
        return result;
    }

    private String[] generateEmptyStrings(int num) {
        String[] strings = new String[num];
        Arrays.fill(strings, "");
        return strings;
    }

}
