public class RailFenceCipher {

    private static int key;

    public RailFenceCipher(int key) {
        RailFenceCipher.key = key;
    }

    public static String getEncryptedData(String message) {
        String[] lines = splitIntoLines(message, false);
        String result = "";
        for (String line : lines) {
            result += line;
        }
        return result;
    }

    public static String getDecryptedData(String message) {
        String[] lines = splitIntoLines(message, true);

        int charCount = 0;
        for (int i = 0; i < key; ++i) {
            while (lines[i].contains("?")) {
                String letter = String.valueOf(message.charAt(charCount));
                lines[i] = lines[i].replaceFirst("\\?", letter);
                charCount++;
            }
        }

        String result = "";
        int lineCount = 0;
        int direction = -1;
        for (int i = 0; i < message.length(); ++i) {
            String letter = String.valueOf(lines[lineCount].charAt(0));
            lines[lineCount] = lines[lineCount].substring(1);
            result += letter;
            direction *= lineCount == 0 || lineCount == key - 1 ? -1 : 1;
            lineCount += direction;
        }
        return result;
    }

    private static String[] splitIntoLines(String message, boolean encrypted) {
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

    private static String[] generateEmptyStrings(int num) {
        String[] strings = new String[num];
        for (int i = 0; i < num; ++i) {
            strings[i] = "";
        }
        return strings;
    }

}
