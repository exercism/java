
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Converter {

    private static final int MIN_BASE = 2;
    public static final String ERROR_LIST_NULL
            = "Input List Should Not Be null";
    public static final String ERROR_LIST_EMPTY
            = "Input List Should Not Be Empty";
    public static final String ERROR_INPUT_BASE
            = "Input Base Should Not Be Less Than 2";
    public static final String ERROR_OUTPUT_BASE
            = "Output Base Should Not Be Less Than 2";
    public static final String ERROR_LIST_LEADING_ZEROES
            = "Input List Should Not Contain Leading Zeroes";
    public static final String ERROR_LIST_WRONG_DIGITS
            = "Input List Should Not Contain WRONG DIGITS";

    public static List<Integer> convert(List<Integer> data,
            int inputBase,
            int outputBase) {
        if (inputBase < MIN_BASE) {
            throw new IllegalArgumentException(ERROR_INPUT_BASE);
        }
        if (outputBase < MIN_BASE) {
            throw new IllegalArgumentException(ERROR_OUTPUT_BASE);
        }
        if (data == null) {
            throw new IllegalArgumentException(ERROR_LIST_NULL);
        }
        if (data.isEmpty()) {
            throw new IllegalArgumentException(ERROR_LIST_EMPTY);
        }
        if (data.size() == 1) {
            final int element = data.get(0);
            if (element == 0) {
                return Collections.unmodifiableList(Arrays.asList(0));
            }
            if (element == 1) {
                return Collections.unmodifiableList(Arrays.asList(1));
            }
        } else if (data.get(0) == 0) {
            throw new IllegalArgumentException(ERROR_LIST_LEADING_ZEROES);
        }
        if (!isDataValid(data, inputBase)) {
            throw new IllegalArgumentException(ERROR_LIST_WRONG_DIGITS);
        }
        return convertDecimalToBase(
                convertToDecimal(data, inputBase), outputBase);
    }

    private Converter() {
    }

    private static int convertToDecimal(List<Integer> data,
            int inputBase) {
        return data.stream()
                .reduce(0, (accumulator, value)
                        -> accumulator * inputBase + value);
    }

    private static List<Integer> convertDecimalToBase(
            int number, int base) {
        final Deque<Integer> result = new LinkedList<>();
        int tmp = number;
        while (tmp > 0) {
            result.addFirst(tmp % base);
            tmp /= base;
        }
        return Collections.unmodifiableList(new ArrayList<Integer>(result));
    }

    private static boolean isDataValid(List<Integer> data, int base) {
        final int limit = base - 1;
        for (int val : data) {
            if (val < 0 || val > limit) {
                return false;
            }
        }
        return true;
    }
}
