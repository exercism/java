
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Series {

    private final int digitsSize;
    private List<Integer> digits;

    Series(String string) {
        this.digits = Arrays.stream(string.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        this.digitsSize = this.digits.size();
    }

    List<List<Integer>> slices(int num) {
        if (num > this.digitsSize) {
            throw new IllegalArgumentException("Slice size is too big.");
        }
        final int limit = this.digitsSize - num + 1;
        List<List<Integer>> result = new ArrayList<>(limit);
        List<Integer> tmp;
        for (int i = 0; i < limit; i++) {
            tmp = this.digits.subList(i, i + num);
            result.add(tmp);
        }
        return result;
    }

    List<Integer> getDigits() {
        return digits;
    }

}
