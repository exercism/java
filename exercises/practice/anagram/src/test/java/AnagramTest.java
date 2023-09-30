import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class AnagramTest {

    @Test
    public void testNoMatches() {
        Anagram detector = new Anagram("diaper");

        assertThat(
            detector.match(
                Arrays.asList("hello", "world", "zombies", "pants")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testDetectsTwoAnagrams() {
        Anagram detector = new Anagram("solemn");

        assertThat(detector.match(Arrays.asList("lemons", "cherry", "melons")))
            .containsExactlyInAnyOrder("lemons", "melons");
    }

    @Ignore("Remove to run test")
    @Test
    public void testEliminateAnagramSubsets() {
        Anagram detector = new Anagram("good");

        assertThat(detector.match(Arrays.asList("dog", "goody"))).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testDetectLongerAnagram() {
        Anagram detector = new Anagram("listen");

        assertThat(
            detector.match(
                Arrays.asList("enlists", "google", "inlets", "banana")))
            .containsExactlyInAnyOrder("inlets");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDetectMultipleAnagramsForLongerWord() {
        Anagram detector = new Anagram("allergy");
        assertThat(
            detector.match(
                Arrays.asList(
                    "gallery",
                    "ballerina",
                    "regally",
                    "clergy",
                    "largely",
                    "leading")))
            .containsExactlyInAnyOrder("gallery", "regally", "largely");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDetectsMultipleAnagramsWithDifferentCase() {
        Anagram detector = new Anagram("nose");

        assertThat(detector.match(Arrays.asList("Eons", "ONES")))
            .containsExactlyInAnyOrder("Eons", "ONES");
    }

    @Ignore("Remove to run test")
    @Test
    public void testEliminateAnagramsWithSameChecksum() {
        Anagram detector = new Anagram("mass");

        assertThat(detector.match(Collections.singletonList("last")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitiveWhenBothAnagramAndSubjectStartWithUpperCaseLetter() {
        Anagram detector = new Anagram("Orchestra");

        assertThat(
            detector.match(
                Arrays.asList("cashregister", "Carthorse", "radishes")))
            .containsExactlyInAnyOrder("Carthorse");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitiveWhenSubjectStartsWithUpperCaseLetter() {
        Anagram detector = new Anagram("Orchestra");

        assertThat(
            detector.match(
                Arrays.asList("cashregister", "carthorse", "radishes")))
            .containsExactlyInAnyOrder("carthorse");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCaseInsensitiveWhenAnagramStartsWithUpperCaseLetter() {
        Anagram detector = new Anagram("orchestra");

        assertThat(
            detector.match(
                Arrays.asList("cashregister", "Carthorse", "radishes")))
            .containsExactlyInAnyOrder("Carthorse");
    }

    @Ignore("Remove to run test")
    @Test
    public void testIdenticalWordRepeatedIsNotAnagram() {
        Anagram detector = new Anagram("go");

        assertThat(detector.match(Collections.singletonList("goGoGO")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testAnagramMustUseAllLettersExactlyOnce() {
        Anagram detector = new Anagram("tapper");

        assertThat(detector.match(Collections.singletonList("patter")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsAreNotAnagramsOfThemselvesCaseInsensitive() {
        Anagram detector = new Anagram("BANANA");

        assertThat(detector.match(Collections.singletonList("BANANA")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsAreNotAnagramsOfThemselvesEvenIfLetterCaseIsPartiallyDifferent() {
        Anagram detector = new Anagram("BANANA");

        assertThat(detector.match(Collections.singletonList("Banana")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsAreNotAnagramsOfThemselvesEvenIfLetterCaseIsCompletelyDifferent() {
        Anagram detector = new Anagram("BANANA");

        assertThat(detector.match(Collections.singletonList("banana")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsOtherThanThemselvesCanBeAnagrams() {
        Anagram detector = new Anagram("LISTEN");

        assertThat(detector.match(Arrays.asList("LISTEN", "Silent")))
            .containsExactlyInAnyOrder("Silent");
    }

}
