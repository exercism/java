package test;

import static org.junit.Assert.*;
import org.junit.Test;
import exemple.Isogram;

public class IsogramTest {

	@Test
	public void testIsogram() {
		assertTrue(Isogram.isIsogram("duplicates"));
	}
	
	@Test
	public void testNotIsogram() {
		assertFalse(Isogram.isIsogram("eleven"));
	}
	
	@Test
	public void testMediumLongIsogram() {
		assertTrue(Isogram.isIsogram("subdermatoglyphic"));
	}
	
	@Test
	public void testCaseInsensitive() {
		assertFalse(Isogram.isIsogram("Alphabet"));
	}
	
	@Test
	public void testIsogramWithHyphen() {
		assertTrue(Isogram.isIsogram("thumbscrew-japingly"));
	}
	
	@Test
	public void testIgnoresMultipleHyphens() {
		assertTrue(Isogram.isIsogram("Hjelmqvist-Gryb-Zock-Pfund-Wax"));
	}
	
	@Test
	public void testWorksWithGermanLetters() {
		assertTrue(Isogram.isIsogram("Heizölrückstoßabdämpfung"));
	}
	
	@Test
	public void testIgnoresSpaces() {
		assertFalse(Isogram.isIsogram("the quick brown fox"));
	}
	
	@Test
	public void testIgnoresSpaces2() {
		assertTrue(Isogram.isIsogram("Emily Jung Schwartzkopf"));
	}
	
	@Test
	public void testDuplicateAccentedLetters() {
		assertFalse(Isogram.isIsogram("éléphant"));
	}

}
