import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Accumulate {

	public static <T> Collection<T> accumulate(Collection<T> collection, Function<T, T> function) {
		List<T> newCollection = new ArrayList<>();

		for (T item : collection) {
			newCollection.add(function.apply(item));
		}

		return newCollection;
	}
}
