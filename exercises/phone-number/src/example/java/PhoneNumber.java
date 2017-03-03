public class PhoneNumber {

    private final String number;

    public PhoneNumber(String phoneNumber) {
        number = normalize(extractDigits(phoneNumber));
    }

    private String extractDigits(String dirtyNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : dirtyNumber.toCharArray()) {
            if (c == ' ' || c == '.' || c == '(' || c == ')' || c == '-') {
                // Remove spaces, dots, parentheses and hyphens
                continue;
            }
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Illegal character in phone number. "
                        + "Only digits, spaces, parentheses, hyphens or dots accepted.");
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private String normalize(String number) {
        if (number.length() > 11 || number.length() < 10) {
            throw new IllegalArgumentException("Number must be 10 or 11 digits");
        }

        if (number.length() == 11) {
            if (number.startsWith("1")) {
                number = number.substring(1, number.length());
            } else {
                throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");
            }
        }

        return number;
    }

    public String getNumber() {
        return number;
    }
}
