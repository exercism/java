import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AnagramTest {


    @Test
    public void testNoMatches() {
        Anagram detector = new Anagram("diaper");
        assertTrue(detector.match(Arrays.asList("hello", "world", "zombies", "pants")).isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDetectSimpleAnagram() {
        Anagram detector = new Anagram("ant");
        List<String> anagram = detector.match(Arrays.asList("tan", "stand", "at"));
        assertThat(anagram, hasItem("tan"));
        assertThat(anagram.size(), is(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDetectLongerAnagram() {
        Anagram detector = new Anagram("listen");
        List<String> anagrams = detector.match(Arrays.asList("enlists", "google", "inlets", "banana"));
        assertThat(anagrams, hasItem("inlets"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDetectMultipleAnagramsForLongerWord() {
        Anagram detector = new Anagram("allergy");
        List<String> anagrams = detector.match(Arrays.asList("gallery", "ballerina", "regally", "clergy", "largely", "leading"));
        assertThat(anagrams, allOf(hasItem("gallery"), hasItem("largely"), hasItem("regally")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDoesNotConfuseDifferentDuplicates() {
        Anagram detector = new Anagram("galea");
        assertTrue(detector.match(Collections.singletonList("eagle")).isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void testIdenticalWordIsNotAnagram() {
        Anagram detector = new Anagram("cOrN");
        assertTrue(detector.match(Arrays.asList("corn", "Corn", "CORN")).isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitiveDetectAnagram() {
        Anagram detector = new Anagram("OrChEsTra");
        List<String> anagrams = detector.match(Arrays.asList("carthorse", "CarThorsE", "CARTHORSE"));
        assertThat(anagrams, allOf(hasItem("carthorse"), hasItem("CarThorsE"), hasItem("CARTHORSE")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEliminateAnagramsWithSameChecksum() {
        Anagram detector = new Anagram("mass");
        assertTrue(detector.match(Collections.singletonList("last")).isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void testEliminateAnagramSubsets() {
        Anagram detector = new Anagram("good");
        assertTrue(detector.match(Arrays.asList("dog", "goody")).isEmpty());
    }
}
