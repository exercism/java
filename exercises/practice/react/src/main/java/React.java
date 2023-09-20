import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class React {

    interface Cell<T> {
        T getValue();
    }

    interface InputCell<T> extends Cell<T> {
        void setValue(T newValue);
    }

    interface ComputeCell<T> extends Cell<T> {
        void addCallback(Consumer<T> callback);
        void removeCallback(Consumer<T> callback);
    }

    public static <T> InputCell<T> inputCell(T initialValue) {
        throw new UnsupportedOperationException("Please implement the React.inputCell() method");
    }

    public static <T> ComputeCell<T> computeCell(Function<List<T>, T> function, List<Cell<T>> cells) {
        throw new UnsupportedOperationException("Please implement the React.computeCell() method");
    }
}
