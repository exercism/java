
import java.util.List;

class BinarySearch {

    private List<Integer> array;
    private int arraySize;

    BinarySearch(List<Integer> array) {
        this.array = array;
        this.arraySize = array.size();
    }

    int indexOf(Integer value) {
        return search(value);
    }

    private int search(Integer value) {
        int left = 0;
        int right = this.arraySize - 1;
        int middle;
        Integer element;
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
