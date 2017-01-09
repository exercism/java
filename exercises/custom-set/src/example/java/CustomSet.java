
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomSet<T> {

    private Set<T> set;

    public CustomSet() {
        this(Collections.EMPTY_LIST);
    }

    public CustomSet(Collection<T> data) {
        set = new HashSet<>(data.size());
        this.set.addAll(data);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(T element) {
        return set.contains(element);
    }

    public boolean isSubset(CustomSet<T> anotherSet) {
        return set.containsAll(anotherSet.set);
    }

    public boolean isDisjoint(CustomSet<T> anotherSet) {
        if (set.isEmpty() || anotherSet.set.isEmpty()) {
            return true;
        }
        return set.stream()
                .filter(elem -> anotherSet.set.contains(elem))
                .count() == 0;
    }

    public boolean equals(CustomSet<T> anotherSet) {
        return set.equals(anotherSet.set);
    }

    public boolean add(T element) {
        return set.add(element);
    }

    public CustomSet<T> getIntersection(CustomSet<T> anotherSet) {
        return new CustomSet<>(
                set.stream()
                        .filter(anotherSet.set::contains)
                        .collect(Collectors.toList())
        );
    }

    public CustomSet<T> getUnion(CustomSet<T> anotherSet) {
        final Set<T> union = new HashSet<>(set);
        union.addAll(anotherSet.set);
        return new CustomSet<>(union);
    }

    public CustomSet<T> getDifference(CustomSet<T> anotherSet) {
        final Predicate<T> predicate = anotherSet::contains;
        return new CustomSet<>(
                set.stream()
                        .filter(predicate.negate())
                        .collect(Collectors.toList())
        );
    }

}
