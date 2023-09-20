import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class React {

    interface Cell<T> {
        T getValue();
        default T getTentativeValue() {
            return getValue();
        }
        void addDependent(ComputeCell<T> dependent);
    }

    interface InputCell<T> extends Cell<T> {
        void setValue(T newValue);
    }

    interface ComputeCell<T> extends Cell<T> {
        void prepareTentativeUpdate();
        void commitTentativeUpdate();
        void addCallback(Consumer<T> callback);
        void removeCallback(Consumer<T> callback);
    }

    static class CellImpl<T> implements Cell<T> {
        private T value;

        final Collection<ComputeCell<T>> dependentCells = new ArrayList<>();

        final Collection<Consumer<T>> callbacks = new ArrayList<>();

        public CellImpl(T initialValue) {
            this.value = initialValue;
        }

        public T getValue() {
            return value;
        }

        void setValue(T newValue) {
            if (!Objects.equals(value, newValue)) {
                value = newValue;

                dependentCells.forEach(ComputeCell::prepareTentativeUpdate);
                dependentCells.forEach(ComputeCell::commitTentativeUpdate);
                callbacks.forEach(cb -> cb.accept(newValue));
            }
        }

        @Override
        public void addDependent(ComputeCell<T> dependent) {
            dependentCells.add(dependent);
        }

        public void addCallback(Consumer<T> callback) {
            callbacks.add(callback);
        }

        public void removeCallback(Consumer<T> callback) {
            callbacks.remove(callback);
        }
    }

    static class InputCellImpl<T> extends CellImpl<T> implements InputCell<T> {
        InputCellImpl(T initialValue) {
            super(initialValue);
        }

        @Override
        public void setValue(T newValue) {
            super.setValue(newValue);
        }
    }

    static class ComputeCellImpl<T> extends CellImpl<T> implements ComputeCell<T> {

        private final Supplier<T> formula;

        private Optional<T> tentativeValue = Optional.empty();

        ComputeCellImpl(Supplier<T> formula) {
            super(formula.get());
            this.formula = formula;
        }

        @Override
        public void prepareTentativeUpdate() {
            tentativeValue = Optional.of(formula.get());
            dependentCells.forEach(ComputeCell::prepareTentativeUpdate);
        }

        @Override
        public void commitTentativeUpdate() {
            dependentCells.forEach(ComputeCell::commitTentativeUpdate);
            tentativeValue.ifPresent(this::setValue);
            tentativeValue = Optional.empty();
        }

        @Override
        public T getTentativeValue() {
            return tentativeValue.orElseGet(this::getValue);
        }

    }

    public static <T> InputCell<T> inputCell(T initialValue) {
        return new InputCellImpl<>(initialValue);
    }


    public static <T> ComputeCell<T> computeCell(Function<List<T>, T> function, List<Cell<T>> cells) {
        Supplier<T> formula = () -> {
            List<T> cellValues = cells.stream().map(Cell::getTentativeValue).collect(Collectors.toList());
            return function.apply(cellValues);
        };

        var computeCell = new ComputeCellImpl<T>(formula);
        cells.forEach(cell -> cell.addDependent(computeCell));
        return computeCell;
    }
}
