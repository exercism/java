class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        String isbn = stringToVerify.replace("-", "");
        int total = 0;

        if (isbn.length() != 10) {
            return false;
        }

        for (int i = 0; i < isbn.length() - 1; i++) {
            char currentChar = isbn.charAt(i);
            if (Character.isDigit(currentChar)) {
                int currentCharVal = Character.getNumericValue(currentChar);
                total += currentCharVal * (10 - i);
            } else {
                return false;
            }
        }

        char finalChar = isbn.charAt(isbn.length() - 1);
        if (Character.isDigit(finalChar)) {
            total += Character.getNumericValue(finalChar);
        } else if (finalChar == 'X') {
            total += 10;
        } else {
            return false;
        }

        return total % 11 == 0;

    }

}
