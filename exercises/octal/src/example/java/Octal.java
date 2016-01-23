public class Octal {

    private String octal;
    private int decimal;

    public Octal(String octal) {
        this.octal = octal;
        this.decimal = getDecimalFromOctal(octal);
    }

    public int getDecimal() {
        return decimal;
    }

    private static int getDecimalFromOctal(String octal) {
        if (!isValid(octal)) {
            return 0;
        }

        int sum = 0;

        for (int index = 0; index < octal.length(); index++) {
            sum += Character.getNumericValue(octal.charAt(index)) * Math.pow(8, octal.length() - index - 1);
        }

        return sum;
    }

    private static boolean isValid(String binaryRepresentation) {
        return binaryRepresentation.chars()
                .allMatch(x -> Character.isDigit((char) x) && Character.getNumericValue((char) x) < 8);
    }
}
