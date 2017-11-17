class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        String isbn;
        isbn = stringToVerify.replace("-", "");
        int total = 0;

        if (isbn.length() != 10) {
            return false;
        }

        for (int i = 0; i < isbn.length() - 1; i++) {
            char currentDigit = isbn.charAt(i);
            if(Character.isDigit(currentDigit)) {
                int currentCharVal = Character.getNumericValue(currentDigit);
                total += currentCharVal * (10 - i);
            } else {
                return false;
            }
        }

        char finalCharacter = isbn.charAt(isbn.length() - 1);
        if (Character.isDigit(finalCharacter)) {
            total += Character.getNumericValue(finalCharacter);
        } else if (finalCharacter == 'X') {
            total += 10;
        } else {
            return false;
        }

        return total % 11 == 0;

    }

}
