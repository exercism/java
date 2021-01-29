class Binary {

    private String binary;
    private int decimal;

    Binary(String binary) {
        this.binary = binary;
        this.decimal = getDecimalFromBinary(binary);
    }

    int getDecimal() {
        return decimal;
    }

    private static int getDecimalFromBinary(String binary) {
        if (!isValid(binary)) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < binary.length(); i++) {
            sum += Character.getNumericValue(binary.charAt(i)) * (int) Math.pow(2, binary.length() - i - 1);
        }

        return sum;
    }

    private static boolean isValid(String binaryRepresentation) {
        boolean isValid = binaryRepresentation.chars()
                .allMatch(x -> Character.isDigit((char) x) && Character.getNumericValue((char) x) < 2);

        return isValid;
    }
}
