import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class React {

    interface Cell<T> {
        T getValue();

        T getTentativeValue();

        void addDependent(ComputeCell<T> dependent);

        void addCallback(Consumer<T> consumer);

        void removeCallback(Consumer<T> callback);
    }

    abstract static class BaseCell<T> implements Cell<T> {
        T value;

        final List<ComputeCell<T>> dependents = new ArrayList<>();

        final List<Consumer<T>> callbacks = new ArrayList<>();

        BaseCell(T initialValue) {
            this.value = initialValue;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public T getTentativeValue() {
            return value;
        }

        @Override
        public void addCallback(Consumer<T> consumer) {
            callbacks.add(consumer);
        }

        @Override
        public void removeCallback(Consumer<T> consumer) {
            callbacks.remove(consumer);
        }

        public void addDependent(ComputeCell<T> dependent) {
            dependents.add(dependent);
        }

        void setValue(T newValue) {
            if (!Objects.equals(value, newValue)) {
                value = newValue;

                callbacks.forEach(callback -> callback.accept(newValue));
                dependents.forEach(ComputeCell::prepareTentativeUpdate);
                dependents.forEach(ComputeCell::commitTentativeValue);
            }
        }
    }

    static class ComputeCell<T> extends BaseCell<T> {

        private final Supplier<T> formula;

        private Optional<T> tentativeValue = Optional.empty();

        ComputeCell(Supplier<T> formula) {
            super(formula.get());
            this.formula = formula;
        }

        void prepareTentativeUpdate() {
            tentativeValue = Optional.of(formula.get());
            dependents.forEach(ComputeCell::prepareTentativeUpdate);
        }

        void commitTentativeValue() {
            dependents.forEach(ComputeCell::commitTentativeValue);
            tentativeValue.ifPresent(this::setValue);
            tentativeValue = Optional.empty();
        }

        public T getTentativeValue() {
            return tentativeValue.orElseGet(this::getValue);
        }
    }

    static class InputCell<T> extends BaseCell<T> {
        InputCell(T initialValue) {
            super(initialValue);
        }

        public void setValue(T newValue) {
            super.setValue(newValue);
        }
    }

    public static <T> InputCell<T> inputCell(T initialValue) {
        return new InputCell<>(initialValue);
    }


    public static <T> Cell<T> computeCell(Function<List<T>, T> function, List<Cell<T>> cells) {
        Supplier<T> formula = () -> {
            List<T> cellValues = cells.stream().map(Cell::getTentativeValue).collect(Collectors.toList());
            return function.apply(cellValues);
        };

        var computeCell = new ComputeCell<T>(formula);
        cells.forEach(cell -> cell.addDependent(computeCell));
        return computeCell;
    }
}
