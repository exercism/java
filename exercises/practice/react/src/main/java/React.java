import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class React {

    public static class Cell<T> {
        public T getValue() {
            throw new UnsupportedOperationException("Please implement the Cell.getValue() method");
        }
    }

    public static class InputCell<T> extends Cell<T> {
        public void setValue(T newValue) {
            throw new UnsupportedOperationException("Please implement the InputCell.setValue() method");
        }
    }

    public static class ComputeCell<T> extends Cell<T> {
        public void addCallback(Consumer<T> callback) {
            throw new UnsupportedOperationException("Please implement the ComputeCell.addCallback() method");
        }

        public void removeCallback(Consumer<T> callback) {
            throw new UnsupportedOperationException("Please implement the ComputeCell.removeCallback() method");
        }
    }

    public static <T> InputCell<T> inputCell(T initialValue) {
        throw new UnsupportedOperationException("Please implement the React.inputCell() method");
    }

    public static <T> ComputeCell<T> computeCell(Function<List<T>, T> function, List<Cell<T>> cells) {
        throw new UnsupportedOperationException("Please implement the React.computeCell() method");
    }
}
