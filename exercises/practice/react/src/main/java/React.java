import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class React<T> {

    interface Cell<T> {
        T getValue();

        void addCallback(Consumer<T> consumer);

        void removeCallback(Consumer<T> callback);
    }

    static class InputCell<T> implements Cell<T> {

        void setValue(T newValue) {
            throw new UnsupportedOperationException("Please implement the InputCell.setValue() method");
        }

        @Override
        public T getValue() {
            throw new UnsupportedOperationException("Please implement the InputCell.getValue() method");
        }

        @Override
        public void addCallback(Consumer<T> consumer) {
            throw new UnsupportedOperationException("Please implement the InputCell.addCallback() method");
        }

        @Override
        public void removeCallback(Consumer<T> callback) {
            throw new UnsupportedOperationException("Please implement the InputCell.removeCallback() method");
        }
    }

    public static <T> InputCell<T> inputCell(T initialValue) {
        throw new UnsupportedOperationException("Please implement the React.inputCell() method");
    }

    public static <T> Cell<T> computeCell(Function<List<T>, T> function, List<Cell<T>> cells) {
        throw new UnsupportedOperationException("Please implement the React.computeCell() method");
    }
}
