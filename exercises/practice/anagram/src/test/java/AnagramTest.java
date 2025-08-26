import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramTest {

    @Test
    @DisplayName("no matches")
    public void testNoMatches() {
        Anagram detector = new Anagram("diaper");

        assertThat(
                detector.match(
                        Arrays.asList("hello", "world", "zombies", "pants")))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("detects two anagrams")
    public void testDetectsTwoAnagrams() {
        Anagram detector = new Anagram("solemn");

        assertThat(detector.match(Arrays.asList("lemons", "cherry", "melons")))
                .containsExactlyInAnyOrder("lemons", "melons");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("does not detect anagram subsets")
    public void testEliminateAnagramSubsets() {
        Anagram detector = new Anagram("good");

        assertThat(detector.match(Arrays.asList("dog", "goody"))).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("detects anagram")
    public void testDetectLongerAnagram() {
        Anagram detector = new Anagram("listen");

        assertThat(
                detector.match(
                        Arrays.asList("enlists", "google", "inlets", "banana")))
                .containsExactlyInAnyOrder("inlets");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("detects three anagrams")
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

    @Disabled("Remove to run test")
    @Test
    @DisplayName("detects multiple anagrams with different case")
    public void testDetectsMultipleAnagramsWithDifferentCase() {
        Anagram detector = new Anagram("nose");

        assertThat(detector.match(Arrays.asList("Eons", "ONES")))
                .containsExactlyInAnyOrder("Eons", "ONES");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("does not detect non-anagrams with identical checksum")
    public void testEliminateAnagramsWithSameChecksum() {
        Anagram detector = new Anagram("mass");

        assertThat(detector.match(Collections.singletonList("last")))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("detects anagrams case-insensitively")
    public void testCaseInsensitiveWhenBothAnagramAndSubjectStartWithUpperCaseLetter() {
        Anagram detector = new Anagram("Orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "Carthorse", "radishes")))
                .containsExactlyInAnyOrder("Carthorse");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("detects anagrams using case-insensitive subject")
    public void testCaseInsensitiveWhenSubjectStartsWithUpperCaseLetter() {
        Anagram detector = new Anagram("Orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "carthorse", "radishes")))
                .containsExactlyInAnyOrder("carthorse");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("detects anagrams using case-insensitive possible matches")
    public void testCaseInsensitiveWhenAnagramStartsWithUpperCaseLetter() {
        Anagram detector = new Anagram("orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "Carthorse", "radishes")))
                .containsExactlyInAnyOrder("Carthorse");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("does not detect an anagram if the original word is repeated")
    public void testIdenticalWordRepeatedIsNotAnagram() {
        Anagram detector = new Anagram("go");

        assertThat(detector.match(Collections.singletonList("goGoGO")))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("anagrams must use all letters exactly once")
    public void testAnagramMustUseAllLettersExactlyOnce() {
        Anagram detector = new Anagram("tapper");

        assertThat(detector.match(Collections.singletonList("patter")))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("words are not anagrams of themselves")
    public void testWordsAreNotAnagramsOfThemselvesCaseInsensitive() {
        Anagram detector = new Anagram("BANANA");

        assertThat(detector.match(Collections.singletonList("BANANA")))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("words are not anagrams of themselves even if letter case is partially different")
    public void testWordsAreNotAnagramsOfThemselvesEvenIfLetterCaseIsPartiallyDifferent() {
        Anagram detector = new Anagram("BANANA");

        assertThat(detector.match(Collections.singletonList("Banana")))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("words are not anagrams of themselves even if letter case is completely different")
    public void testWordsAreNotAnagramsOfThemselvesEvenIfLetterCaseIsCompletelyDifferent() {
        Anagram detector = new Anagram("BANANA");

        assertThat(detector.match(Collections.singletonList("banana")))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("words other than themselves can be anagrams")
    public void testWordsOtherThanThemselvesCanBeAnagrams() {
        Anagram detector = new Anagram("LISTEN");

        assertThat(detector.match(Arrays.asList("LISTEN", "Silent")))
                .containsExactlyInAnyOrder("Silent");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("handles case of greek letters")
    public void testHandlesCaseOfGreekLetters() {
        Anagram detector = new Anagram("ΑΒΓ");

        assertThat(detector.match(Arrays.asList("ΒΓΑ", "ΒΓΔ", "γβα", "αβγ")))
                .containsExactlyInAnyOrder("ΒΓΑ", "γβα");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("different characters may have the same bytes")
    public void testDifferentCharactersWithSameBytes() {
        Anagram detector = new Anagram("a⬂");

        assertThat(detector.match(Collections.singletonList("€a")))
                .isEmpty();
    }
}
