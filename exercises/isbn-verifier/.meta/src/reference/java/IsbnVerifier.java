class IsbnVerifier {

    private String isbn;

    boolean isValid(String s) {

        this.isbn = s.replace("-", "");
        int total = 0;
        if (isbn.length() == 9 || isbn.length() == 10) {
            for (int i = 0; i < isbn.length() - 1; i++) {

                if(Character.isDigit(isbn.charAt(i))) {
                    int currentCharVal = Character.getNumericValue(isbn.charAt(i));
                    total += currentCharVal * (10 - i);
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }

        if (isbn.length() == 10) {
            if (Character.isDigit(isbn.charAt(9))) {
                total += Character.getNumericValue(isbn.charAt(9));
            } else if (isbn.charAt(9) == 'X') {
                total += 10;
            } else {
                return false;
            }
        }

        if (total % 11 == 0) {
            return true;
        } else {
            return false;
        }

    }

}