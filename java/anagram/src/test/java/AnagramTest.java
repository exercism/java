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
    public void testDetectMultipleAnagrams() {
        Anagram detector = new Anagram("master");

        assertThat(detector.match(Arrays.asList("stream", "pigeon", "maters")))
            .containsExactlyInAnyOrder("maters", "stream");
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

        assertThat(detector.match(Collections.singletonList("go Go GO")))
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

        assertThat(detector.match(Arrays.asList("BANANA", "Banana", "banana")))
            .isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsOtherThanThemselvesCanBeAnagrams() {
        Anagram detector = new Anagram("LISTEN");

        assertThat(detector.match(Arrays.asList("Listen", "Silent", "LISTEN")))
            .containsExactlyInAnyOrder("Silent");
    }

}
