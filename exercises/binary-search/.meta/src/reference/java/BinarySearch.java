
import java.util.List;

public class BinarySearch<T extends Comparable<T>> {

    private List<T> array;
    private int arraySize;

    public BinarySearch(List<T> array) {
        this.array = array;
        this.arraySize = array.size();
    }

    public int indexOf(T value) {
        return search(value);
    }

    public List<T> getArray() {
        return array;
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
