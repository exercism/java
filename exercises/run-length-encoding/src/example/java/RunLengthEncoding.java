import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoding {
    public String encode(String data) {

        StringBuilder encodedData = new StringBuilder();

        if (data.length() == 0) {
            return data;
        }

        int charCount = 0;
        char beforeChar = data.charAt(0);

        for (int i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);

            if (beforeChar == currentChar) {
                charCount++;

                if (i != data.length() - 1) {
                    continue;
                }
            }

            if (charCount != 1) {
                encodedData.append(charCount);
            }

            encodedData.append(beforeChar);

            if (beforeChar != currentChar && i == data.length() - 1) {
                encodedData.append(currentChar);
            }

            beforeChar = currentChar;
            charCount = 1;
        }

        return encodedData.toString();
    }

    public String decode(String encodedData) {
        StringBuilder decodedData = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z\\s]");
        Matcher matcher = pattern.matcher(encodedData);

        while (matcher.find()) {
            try {
                int number = Integer.parseInt(matcher.group());

                matcher.find();

                for (; number != 0; --number) {
                    decodedData.append(matcher.group());
                }
            } catch (NumberFormatException e) {
                decodedData.append(matcher.group());
            }
        }

        return decodedData.toString();
    }
}