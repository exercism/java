import java.util.stream.IntStream;

public class Luhn {

    private long number;
    private long checkDigit;
    private int[] addends;
    private int checkSum;
    private boolean isValid;

    public Luhn(long number) {
        this.number = number;
        this.checkDigit = number % 10;
        this.addends = generateAddends();
        this.checkSum = IntStream.of(addends).sum();
        this.isValid = checkSum % 10 == 0;
    }

    public long getCheckDigit() {
        return checkDigit;
    }

    public int[] getAddends() {
        return addends;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public boolean isValid() {
        return isValid;
    }

    private int[] generateAddends() {
        int[] reversedIntArray = splitToReversedIntArray(number);

        for (int index = 1; index < reversedIntArray.length; index++) {
            if (index % 2 != 0) {
                reversedIntArray[index] = convertDigitForAddend(reversedIntArray[index]);
            }
        }

        return reverseIntArray(reversedIntArray);
    }

    private static int[] splitToReversedIntArray(long value) {
        int[] ints = new StringBuilder(Long.toString(value))
                .reverse()
                .toString()
                .chars()
                .map(x -> Character.getNumericValue(x))
                .toArray();

        return ints;
    }

    private static int convertDigitForAddend(int value) {
        int doubled = value * 2;

        return doubled < 10 ? doubled : doubled - 9;
    }

    public static long create(long number) {
        long zeroCheckDigitNumber = number * 10;
        Luhn luhn = new Luhn(zeroCheckDigitNumber);

        if (luhn.isValid()) {
            return zeroCheckDigitNumber;
        }

        return zeroCheckDigitNumber + createCheckDigit(luhn.getCheckSum());
    }

    private static int createCheckDigit(int value) {
        int nearestTen = (int) (Math.ceil(value / 10.0) * 10);

        return nearestTen - value;
    }

    private static int[] reverseIntArray(int[] array) {
        int[] reversed = new int[array.length];

        for (int index = 0; index < array.length; index++) {
            reversed[index] = array[array.length - 1 - index];
        }

        return reversed;
    }
}
