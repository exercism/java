package test;

import static org.junit.Assert.*;
import org.junit.Test;
import exemple.Isogram;

public class IsogramTest {

	@Test
	public void testIsogram() {
		Isogram iso = new Isogram("duplicates");
		assertTrue(iso.isogramChecker());
	}
	
	@Test
	public void testNotIsogram() {
		Isogram iso = new Isogram("eleven");
		assertFalse(iso.isogramChecker());
	}
	
	@Test
	public void testMediumLongIsogram() {
		Isogram iso = new Isogram("subdermatoglyphic");
		assertTrue(iso.isogramChecker());
	}
	
	@Test
	public void testCaseInsensitive() {
		Isogram iso = new Isogram("Alphabet");
		assertFalse(iso.isogramChecker());
	}
	
	@Test
	public void testIsogramWithHyphen() {
		Isogram iso = new Isogram("thumbscrew-japingly");
		assertTrue(iso.isogramChecker());
	}
	
	@Test
	public void testIgnoresMultipleHyphens() {
		Isogram iso = new Isogram("Hjelmqvist-Gryb-Zock-Pfund-Wax");
		assertTrue(iso.isogramChecker());
	}
	
	@Test
	public void testWorksWithGermanLetters() {
		Isogram iso = new Isogram("Heizölrückstoßabdämpfung");
		assertTrue(iso.isogramChecker());
	}
	
	@Test
	public void testIgnoresSpaces() {
		Isogram iso = new Isogram("the quick brown fox");
		assertFalse(iso.isogramChecker());
	}
	
	@Test
	public void testIgnoresSpaces2() {
		Isogram iso = new Isogram("Emily Jung Schwartzkopf");
		assertTrue(iso.isogramChecker());
	}
	
	@Test
	public void testDuplicateAccentedLetters() {
		Isogram iso = new Isogram("éléphant");
		assertFalse(iso.isogramChecker());
	}

}
