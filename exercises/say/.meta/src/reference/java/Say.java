import java.util.Arrays;

public class Say {

    public String say(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("input out of range");
        }
        char[] digits = String.valueOf(number).toCharArray();
        if (digits.length > 12) {
            throw new IllegalArgumentException("input out of range");
        }
        char[][] processedDigits = process(digits);

        String message = "";
        for (int index = 0; index < processedDigits.length; index++) {
            char[] blockDigits = processedDigits[index];
            message = concatWithSpace(message,
                    sayDigits(blockDigits, processedDigits.length - index));
        }
        return message;
    }

    private String sayDigits(char[] digits, int orderNumber) {
        String sentence = "";

        if (digits.length == 3) {
            digits = filterInitialZeros(digits);
        }

        boolean threeDigits = digits.length == 3;

        if (threeDigits) {
            char headDigit = digits[0];
            char[] tailDigits = new char[2];
            tailDigits[0] = digits[1];
            tailDigits[1] = digits[2];
            digits = filterInitialZeros(tailDigits);
            sentence = convertUnit(headDigit) + " hundred";
        }

        boolean oneDigit = digits.length == 1;
        boolean twoDigits = digits.length == 2;

        if (twoDigits) {
            sentence = concatWithSpace(sentence, sayTwoDigits(digits));
        }
        if (oneDigit) {
            sentence = concatWithSpace(sentence, convertUnit(digits[0]));
        }

        if (sentence.length() != 0) {
            return concatWithSpace(sentence, order(orderNumber));
        } else {
            return sentence;
        }
    }

    private String sayTwoDigits(char[] digits) {
        if (digits[0] == '1') {
            return convertTenUntilTwenty(new String(digits));
        } else {
            return convertTens(digits[0])
                    + (digits[1] != '0' ? "-" + convertUnit(digits[1]) : "");
        }
    }

    private String concatWithSpace(String prefix, String postfix) {
        String wordSeparator = "";
        if (prefix.length() > 0 && postfix.length() > 0) {
            wordSeparator = " ";
        }
        return prefix + wordSeparator + postfix;
    }

    private char[] filterInitialZeros(char[] digits) {
        int cursor = 0;
        while (cursor < digits.length && digits[cursor] == '0') {
            cursor++;
        }
        boolean almostADigit = cursor < digits.length;
        if (almostADigit) {
            return Arrays.copyOfRange(digits, cursor, digits.length);
        } else {
            return new char[0];
        }
    }

    private char[][] process(char[] digits) {
        final int digitsLength = digits.length;
        char[][] result = null;
        int rest = digitsLength % 3;
        int quotient = digitsLength / 3;
        int dimension = quotient + (rest == 0 ? 0 : 1);
        result = new char[dimension][];
        result[0] = new char[rest == 0 ? 3 : rest];
        for (int i = 0; i < dimension - 1; i++) {
            result[i + 1] = new char[3];
        }
        int cursor = digitsLength - 1;
        int dimensionCursor = dimension - 1;
        while (dimensionCursor >= 0) {
            for (int i = result[dimensionCursor].length - 1; i >= 0; i--) {
                result[dimensionCursor][i] = digits[cursor];
                cursor--;
            }
            dimensionCursor--;
        }
        return result;
    }

    private String order(int length) {
        switch (length) {
            case 2:
                return "thousand";
            case 3:
                return "million";
            case 4:
                return "billion";
            default:
                return "";
        }
    }

    private String convertUnit(char digit) {
        switch (digit) {
            case '0':
                return "zero";
            case '1':
                return "one";
            case '2':
                return "two";
            case '3':
                return "three";
            case '4':
                return "four";
            case '5':
                return "five";
            case '6':
                return "six";
            case '7':
                return "seven";
            case '8':
                return "eight";
            case '9':
                return "nine";
            default:
                throw new IllegalArgumentException("not supported value");
        }
    }

    private String convertTens(char digit) {
        switch (digit) {
            case '2':
                return "twenty";
            case '3':
                return "thirty";
            case '4':
                return "forty";
            case '5':
                return "fifty";
            case '6':
                return "sixty";
            case '7':
                return "seventy";
            case '8':
                return "eighty";
            case '9':
                return "ninety";
            default:
                throw new IllegalArgumentException("not supported value");
        }
    }

    private String convertTenUntilTwenty(String digit) {
        switch (digit) {
            case "10":
                return "ten";
            case "11":
                return "eleven";
            case "12":
                return "twelve";
            case "13":
                return "thirteen";
            case "14":
                return "fourteen";
            case "15":
                return "fifteen";
            case "16":
                return "sixteen";
            case "17":
                return "seventeen";
            case "18":
                return "eighteen";
            case "19":
                return "nineteen";
            case "20":
                return "twenty";
            default:
                throw new IllegalArgumentException("not supported value");
        }
    } 
}

