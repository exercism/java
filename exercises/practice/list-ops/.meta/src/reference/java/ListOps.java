
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

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
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    static <T> int size(final List<T> list) {
        return list.size();
    }

    static <T, U> List<U> map(final List<T> list, Function<T, U> transform) {
        return list.stream().map(transform).collect(Collectors.toList());
    }

    static <T> List<T> reverse(final List<T> list) {
        final List<T> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

    static <T, U> U foldLeft(final List<T> list, final U initial, final BiFunction<U, T, U> f) {
        if (list.isEmpty()) {
            return initial;
        }

        return foldLeft(
                new ArrayList<>(list.subList(1, list.size())),
                f.apply(
                        initial,
                        list.get(0)),
                f);
    }

    static <T, U> U foldRight(final List<T> list, final U initial, final BiFunction<T, U, U> f) {
        if (list.isEmpty()) {
            return initial;
        }

        return f.apply(
                list.get(0),
                foldRight(
                        new ArrayList<>(list.subList(1, list.size())),
                        initial,
                        f));
    }

    private ListOps() {
        // No instances.
    }

}
