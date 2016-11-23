
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Series {

    private final int digitsSize;
    private List<Integer> digits;

    public Series(String string) {
        this.digits = Arrays
                .asList(string.split(("")))
                .stream()
                .map(digit -> Integer.parseInt(digit))
                .collect(Collectors.toList());
        this.digitsSize = this.digits.size();
    }

    public List<List<Integer>> slices(int num) {
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

    public List<Integer> getDigits() {
        return digits;
    }

}
