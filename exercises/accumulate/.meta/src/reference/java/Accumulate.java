import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.lang;

class Accumulate {

	static <T> List<T> accumulate(List<T> collection, Function<T, T> function) {
		List<T> newCollection = new ArrayList<>();

        add= n-> Math.pow(n,2);//method added

		for (T item : collection) {
			newCollection.add(function.apply(item));
		}

		return newCollection;
	}
}
