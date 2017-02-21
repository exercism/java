
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOps {

    private ListOps() {
    }

    public static <T> int length(final List<T> list) {
        return list.size();
    }

    public static <T> List<T> reverse(final List<T> list) {
        List<T> result = new ArrayList(list);
        Collections.reverse(result);
        return result;
    }

    public static <T> List<T> map(final List<T> list,
            UnaryOperator<T> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T> List<T> filter(final List<T> list,
            Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <U, T> U reduce(final List<T> list,
            U identity,
            BiFunction<U, T, U> accumulator,
            BinaryOperator<U> combiner) {
        return list.stream().reduce(identity, accumulator, combiner);
    }

    public static <T> List<T> concat(final List<T>... lists) {
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
