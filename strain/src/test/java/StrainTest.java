package strain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StrainTest {

	@Test
	public void emptyKeep() {
		List<Integer> expected = new LinkedList<>();
		List<Integer> test = new LinkedList<>();
		Assert.assertEquals(expected, Strain.keep(test, x -> x < 10));
	}

	@Test
	public void keepEverything() {
		List<Integer> expected = Arrays.asList(1, 2, 3);
		List<Integer> test = Arrays.asList(1, 2, 3);
		Assert.assertEquals(expected, Strain.keep(test, x -> x < 10));
	}

	@Test
	public void keepFirstAndLast() {
		List<Integer> expected = Arrays.asList(1, 3);
		List<Integer> test = Arrays.asList(1, 2, 3);
		Assert.assertEquals(expected, Strain.keep(test, x -> x % 2 != 0));
	}

	@Test
	public void keepNeitherFirstNorLast() {
		List<Integer> expected = Arrays.asList(2, 4);
		List<Integer> test = Arrays.asList(1, 2, 3, 4, 5);
		Assert.assertEquals(expected, Strain.keep(test, x -> x % 2 == 0));
	}

	@Test
	public void KeepStrings() {
		List<String> words = Arrays
				.asList("apple zebra banana zombies cherimoya zelot".split(" "));
		List<String> expected = Arrays.asList("zebra", "zombies", "zelot");
		Assert.assertEquals(expected,
				Strain.keep(words, x -> x.startsWith("z")));
	}

	@Test
	public void KeepArrays() {
		List<List<Integer>> actual = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(5, 5, 5), 
				Arrays.asList(5, 1, 2),
				Arrays.asList(2, 1, 2), 
				Arrays.asList(1, 5, 2),
				Arrays.asList(2, 2, 1), 
				Arrays.asList(1, 2, 5));
		List<List<Integer>> expected = Arrays.asList(
				Arrays.asList(5, 5, 5),
				Arrays.asList(5, 1, 2), 
				Arrays.asList(1, 5, 2),
				Arrays.asList(1, 2, 5));
		Assert.assertEquals(expected,
				Strain.keep(actual, col -> col.contains(5)));
	}

	@Test
	public void emptyDiscard() {
		List<Integer> expected = new LinkedList<>();
		List<Integer> test = new LinkedList<>();
		Assert.assertEquals(expected, Strain.discard(test, x -> x < 10));
	}

	@Test
	public void discardNothing() {
		List<Integer> expected = Arrays.asList(1, 2, 3);
		List<Integer> test = Arrays.asList(1, 2, 3);
		Assert.assertEquals(expected, Strain.discard(test, x -> x > 10));
	}

	@Test
	public void discardFirstAndLast() {
		List<Integer> expected = Arrays.asList(2);
		List<Integer> test = Arrays.asList(1, 2, 3);
		Assert.assertEquals(expected, Strain.discard(test, x -> x % 2 != 0));

	}

	@Test
	public void discardNeitherFirstNorLast() {
		List<Integer> expected = Arrays.asList(1, 3, 5);
		List<Integer> test = Arrays.asList(1, 2, 3, 4, 5);
		Assert.assertEquals(expected, Strain.discard(test, x -> x % 2 == 0));
	}

	@Test
	public void discardStrings() {
		List<String> words = Arrays
				.asList("apple zebra banana zombies cherimoya zelot".split(" "));
		List<String> expected = Arrays.asList("apple", "banana", "cherimoya");
		Assert.assertEquals(expected,
				Strain.discard(words, x -> x.startsWith("z")));
	}

	@Test
	public void discardArrays() {
		List<List<Integer>> actual = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(5, 5, 5),
				Arrays.asList(5, 1, 2),
				Arrays.asList(2, 1, 2),
				Arrays.asList(1, 5, 2),
				Arrays.asList(2, 2, 1),
				Arrays.asList(1, 2, 5));
		List<List<Integer>> expected = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(2, 1, 2),
				Arrays.asList(2, 2, 1));
		Assert.assertEquals(expected,
				Strain.discard(actual, col -> col.contains(5)));
	}
}
