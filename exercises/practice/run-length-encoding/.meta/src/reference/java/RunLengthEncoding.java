import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RunLengthEncoding {
    String encode(String data) {

        StringBuilder encodedDataBuilder = new StringBuilder();

        if (data.length() == 0) {
            return data;
        }

        int previousCharCount = 1;
        char previousChar = data.charAt(0);

        for (int i = 1; i < data.length(); i++) {
            char currentChar = data.charAt(i);

            if (previousChar == currentChar) {
                previousCharCount++;
            }

            if (previousChar != currentChar || i == data.length() - 1) {
                addChars(encodedDataBuilder, previousChar, previousCharCount);

                if (previousChar != currentChar && i == data.length() - 1) {
                    addChars(encodedDataBuilder, currentChar, 1);
                }

                previousChar = currentChar;
                previousCharCount = 1;
            }
        }

        return encodedDataBuilder.toString();
    }

    void addChars(StringBuilder toAddTo, char toAdd, int countOfChar) {
        if (countOfChar != 1) {
            toAddTo.append(countOfChar);
        }

        toAddTo.append(toAdd);
    }

    String decode(String encodedData) {
        StringBuilder decodedData = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z\\s]");
        Matcher matcher = pattern.matcher(encodedData);

        while (matcher.find()) {
            try {
                int number = Integer.parseInt(matcher.group());

                matcher.find();

                for (int i = 0; i < number; i++) {
                    decodedData.append(matcher.group());
                }
            } catch (NumberFormatException e) {
                decodedData.append(matcher.group());
            }
        }

        return decodedData.toString();
    }
}
