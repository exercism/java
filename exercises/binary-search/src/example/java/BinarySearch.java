
import java.util.List;

public class BinarySearch<T extends Comparable<T>> {

    public static String ARRAY_MUST_BE_SORTED = "Array should be sorted.";

    private List<T> array;
    private int arraySize;

    public BinarySearch(List<T> array) {
        if (!isSorted(array)) {
            throw new IllegalArgumentException(ARRAY_MUST_BE_SORTED);
        }
        this.array = array;
        this.arraySize = array.size();
    }

    public int indexOf(T value) {
        return search(value);
    }

    public List<T> getArray() {
        return array;
    }

    private boolean isSorted(List<T> list) {
        T previous, next;
        int listSize;

        if (list == null || list.isEmpty()) {
            return false;
        }

        listSize = list.size();
        if (listSize == 1) {
            return true;
        }

        previous = list.get(0);
        for (int i = 0, n = listSize - 1; i < n; i++) {
            next = list.get(i + 1);
            if (previous.compareTo(next) > 0) {
                return false;
            }
            previous = next;
        }
        return true;
    }

    private int search(T value) {
        int left = 0;
        int right = this.arraySize - 1;
        int middle;
        T element;
        while (left <= right) {
            middle = (int) Math.floor(0.5 * (left + right));
            element = this.array.get(middle);
            if (value.compareTo(element) > 0) {
                left = middle + 1;
            } else if (value.compareTo(element) < 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}

