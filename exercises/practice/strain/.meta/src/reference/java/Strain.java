import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Strain {

    public static <T> List<T> keep(List<T> collection, Predicate<T> predicate) {
        return filter(collection, predicate);
    }

    public static <T> List<T> discard(List<T> collection, Predicate<T> predicate) {
        return filter(collection, predicate.negate());
    }

    public static <T> List<T> filter(List<T> collection, Predicate<T> predicate) {
        List<T> filteredCollection = new ArrayList<>();

        for (T item : collection) {
            if (predicate.test(item)) {
                filteredCollection.add(item);
            }
        }

        return filteredCollection;
    }
}
