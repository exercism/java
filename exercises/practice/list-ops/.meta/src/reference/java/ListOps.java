import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class ListOps {

    static <T> List<T> append(final List<T> list1, final List<T> list2) {
        final List<T> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    static <T> List<T> concat(final List<List<T>> listOfLists) {
        final List<T> result = new ArrayList<>();
        listOfLists.forEach(result::addAll);
        return result;
    }

    static <T> List<T> filter(final List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    static <T> int size(final List<T> list) {
        return list.size();
    }

    static <T, U> List<U> map(final List<T> list, Function<T, U> transform) {
        final List<U> result = new ArrayList<>();
        for (T item : list) {
            result.add(transform.apply(item));
        }
        return result;
    }

    static <T> List<T> reverse(final List<T> list) {
        final List<T> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    static <T, U> U foldLeft(final List<T> list, final U initial, final BiFunction<U, T, U> f) {
        U acc = initial;

        for (T item : list) {
            acc = f.apply(acc, item);
        }

        return acc;
    }

    static <T, U> U foldRight(final List<T> list, final U initial, final BiFunction<T, U, U> f) {
        U acc = initial;

        for (int i = list.size() - 1; i >= 0; i--) {
            acc = f.apply(list.get(i), acc);
        }

        return acc;
    }

    private ListOps() {
        // No instances.
    }

}
