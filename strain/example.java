import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Strain {

	public static <T> Collection<T> keep(Collection<T> coll, Predicate<T> func)
	{
		return coll.stream().filter(func).collect(Collectors.toList());
	}

	public static <T> Collection<T> discard(Collection<T> coll, Predicate<T> func)
	{
		return coll.stream().filter(func.negate()).collect(Collectors.toList());
	}
}
