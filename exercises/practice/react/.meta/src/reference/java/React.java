import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class React {

    public static class Cell<T> {

        T value;

        public T getValue() {
            return value;
        }

        final Collection<ComputeCell<T>> dependentCells = new ArrayList<>();
    }

    public static class InputCell<T> extends Cell<T> {

        InputCell(T initialValue) {
            this.value = initialValue;
        }

        public void setValue(T newValue) {
            this.value = newValue;
            dependentCells.forEach(cell -> cell.propagateUpdate());
            dependentCells.forEach(cell -> cell.fireCallbacks());
        }
    }

    public static class ComputeCell<T> extends Cell<T> {

        private T lastFiredValue;

        private final Supplier<T> formula;

        final Collection<Consumer<T>> callbacks = new ArrayList<>();

        ComputeCell(Supplier<T> formula) {
            this.formula = formula;
            this.value = formula.get();
            this.lastFiredValue = value;
        }

        private void propagateUpdate() {
            value = formula.get();
            dependentCells.forEach(cell -> cell.propagateUpdate());
        }

        private void fireCallbacks() {
            if (!Objects.equals(value, lastFiredValue)) {
                callbacks.forEach(callback -> callback.accept(value));
                dependentCells.forEach(cell -> cell.fireCallbacks());
                lastFiredValue = value;
            }
        }

        public void addCallback(Consumer<T> callback) {
            callbacks.add(callback);
        }

        public void removeCallback(Consumer<T> callback) {
            callbacks.remove(callback);
        }
    }

    public static <T> InputCell<T> inputCell(T initialValue) {
        return new InputCell<>(initialValue);
    }


    public static <T> ComputeCell<T> computeCell(Function<List<T>, T> function, List<Cell<T>> cells) {
        Supplier<T> formula = () -> {
            List<T> cellValues = cells.stream().map(Cell::getValue).collect(Collectors.toList());
            return function.apply(cellValues);
        };

        var computeCell = new ComputeCell<>(formula);
        cells.forEach(cell -> cell.dependentCells.add(computeCell));
        return computeCell;
    }
}
