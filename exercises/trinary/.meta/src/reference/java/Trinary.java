public class Trinary {

    private static final int RADIX = 3;

    public static int toDecimal(String trinary) {
        if (!validTrinary(trinary)) {
            return 0;
        }

        int result = 0;
        int power = 1;

        for (int i = trinary.toCharArray().length - 1; i >= 0; i--) {
            int digit = Character.digit(trinary.charAt(i), RADIX);
            result += digit * power;
            power *= RADIX;
        }

        return result;
    }

    private static boolean validTrinary(String trinary) {
        return trinary.matches("[012]+");
    }
}
