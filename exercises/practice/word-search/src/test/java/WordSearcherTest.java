import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WordSearcherTest {

    private WordSearcher wordSearcher;

    @BeforeEach
    public void setUp() {
        wordSearcher = new WordSearcher();
    }

    @Test
    public void testAcceptsInitialGridAndTargetWord() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure", Optional.empty());

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesOneWordWrittenLeftToRight() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(1, 1), new Pair(7, 1))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateTheSameWordLeftToRightInDifferentPosition() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(3, 1), new Pair(9, 1))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'m', 't', 'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateADifferentLeftToRightWord() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("coffee", Optional.of(new WordLocation(new Pair(1, 1), new Pair(6, 1))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'c', 'o', 'f', 'f', 'e', 'e', 'l', 'p', 'l', 'x'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateThatDifferentLeftToRightWordInADifferentPosition() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("coffee", Optional.of(new WordLocation(new Pair(2, 1), new Pair(7, 1))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'x', 'c', 'o', 'f', 'f', 'e', 'e', 'z', 'l', 'p'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateLeftToRightWordInTwoLineGrid() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(2, 2), new Pair(8, 2))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'t', 'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateLeftToRightWordInThreeLineGrid() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(1, 3), new Pair(7, 3))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesWordWrittenLeftToRightInTenLineGrid() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesSameWordWrittenLeftToRightInDifferentTenLineGrid() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(1, 9), new Pair(7, 9))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesDifferentWordWrittenLeftToRightInTenLineGrid() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("fortran", Optional.of(new WordLocation(new Pair(1, 7), new Pair(7, 7))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'f', 'o', 'r', 't', 'r', 'a', 'n', 'f', 't', 'w'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateMultipleWords() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("fortran", Optional.of(new WordLocation(new Pair(1,  7), new Pair(7,  7))));
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'f', 'o', 'r', 't', 'r', 'a', 'n', 'f', 't', 'w'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateASingleWordRightToLeft() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("elixir", Optional.of(new WordLocation(new Pair(6, 1), new Pair(1, 1))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testShouldLocateMultipleWordsWrittenInDifferentHorizontalDirections() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("elixir",  Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("clojure", Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesWordsWrittenTopToBottom() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure",     Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));
        expectedLocations.put("elixir",      Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("ecmascript",  Optional.of(new WordLocation(new Pair(10,  1), new Pair(10, 10))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesWordsWrittenBottomToTop() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure",     Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));
        expectedLocations.put("elixir",      Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("ecmascript",  Optional.of(new WordLocation(new Pair(10,  1), new Pair(10, 10))));
        expectedLocations.put("rust",        Optional.of(new WordLocation(new Pair(9,  5), new Pair(9,  2))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesWordsWrittenTopLeftToBottomRight() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure",     Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));
        expectedLocations.put("elixir",      Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("ecmascript",  Optional.of(new WordLocation(new Pair(10,  1), new Pair(10, 10))));
        expectedLocations.put("rust",        Optional.of(new WordLocation(new Pair(9,  5), new Pair(9,  2))));
        expectedLocations.put("java",        Optional.of(new WordLocation(new Pair(1,  1), new Pair(4,  4))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesWordsWrittenBottomRightToTopLeft() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure",     Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));
        expectedLocations.put("elixir",      Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("ecmascript",  Optional.of(new WordLocation(new Pair(10,  1), new Pair(10, 10))));
        expectedLocations.put("rust",        Optional.of(new WordLocation(new Pair(9,  5), new Pair(9,  2))));
        expectedLocations.put("java",        Optional.of(new WordLocation(new Pair(1,  1), new Pair(4,  4))));
        expectedLocations.put("lua",         Optional.of(new WordLocation(new Pair(8,  9), new Pair(6,  7))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesWordsWrittenBottomLeftToTopRight() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure",     Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));
        expectedLocations.put("elixir",      Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("ecmascript",  Optional.of(new WordLocation(new Pair(10,  1), new Pair(10, 10))));
        expectedLocations.put("rust",        Optional.of(new WordLocation(new Pair(9,  5), new Pair(9,  2))));
        expectedLocations.put("java",        Optional.of(new WordLocation(new Pair(1,  1), new Pair(4,  4))));
        expectedLocations.put("lua",         Optional.of(new WordLocation(new Pair(8,  9), new Pair(6,  7))));
        expectedLocations.put("lisp",        Optional.of(new WordLocation(new Pair(3,  6), new Pair(6,  3))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLocatesWordsWrittenTopRightToBottomLeft() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure",     Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));
        expectedLocations.put("elixir",      Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("ecmascript",  Optional.of(new WordLocation(new Pair(10,  1), new Pair(10, 10))));
        expectedLocations.put("rust",        Optional.of(new WordLocation(new Pair(9,  5), new Pair(9,  2))));
        expectedLocations.put("java",        Optional.of(new WordLocation(new Pair(1,  1), new Pair(4,  4))));
        expectedLocations.put("lua",         Optional.of(new WordLocation(new Pair(8,  9), new Pair(6,  7))));
        expectedLocations.put("lisp",        Optional.of(new WordLocation(new Pair(3,  6), new Pair(6,  3))));
        expectedLocations.put("ruby",        Optional.of(new WordLocation(new Pair(8,  6), new Pair(5,  9))));

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFailsToLocateAWordsThatIsNotInThePuzzle() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("clojure",     Optional.of(new WordLocation(new Pair(1, 10), new Pair(7, 10))));
        expectedLocations.put("elixir",      Optional.of(new WordLocation(new Pair(6,  5), new Pair(1,  5))));
        expectedLocations.put("ecmascript",  Optional.of(new WordLocation(new Pair(10,  1), new Pair(10, 10))));
        expectedLocations.put("rust",        Optional.of(new WordLocation(new Pair(9,  5), new Pair(9,  2))));
        expectedLocations.put("java",        Optional.of(new WordLocation(new Pair(1,  1), new Pair(4,  4))));
        expectedLocations.put("lua",         Optional.of(new WordLocation(new Pair(8,  9), new Pair(6,  7))));
        expectedLocations.put("lisp",        Optional.of(new WordLocation(new Pair(3,  6), new Pair(6,  3))));
        expectedLocations.put("ruby",        Optional.of(new WordLocation(new Pair(8,  6), new Pair(5,  9))));
        expectedLocations.put("haskell",     Optional.empty());

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f', 'b', 'l', 'p', 'e', 'p', 'r', 'e'},
                        {'c', 'a', 'm', 'd', 'c', 'i', 'm', 'g', 't', 'c'},
                        {'o', 'i', 'v', 'o', 'k', 'p', 'r', 'j', 's', 'm'},
                        {'p', 'b', 'w', 'a', 's', 'q', 'r', 'o', 'u', 'a'},
                        {'r', 'i', 'x', 'i', 'l', 'e', 'l', 'h', 'r', 's'},
                        {'w', 'o', 'l', 'c', 'q', 'l', 'i', 'r', 'p', 'c'},
                        {'s', 'c', 'r', 'e', 'e', 'a', 'u', 'm', 'g', 'r'},
                        {'a', 'l', 'x', 'h', 'p', 'b', 'u', 'r', 'y', 'i'},
                        {'j', 'a', 'l', 'a', 'y', 'c', 'a', 'l', 'm', 'p'},
                        {'c', 'l', 'o', 'j', 'u', 'r', 'e', 'r', 'm', 't'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFailToLocateWordsThatAreNotOnHorizontalVerticalOrDiagonalLines() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("aef", Optional.empty());
        expectedLocations.put("ced", Optional.empty());
        expectedLocations.put("abf", Optional.empty());
        expectedLocations.put("cbd", Optional.empty());

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'j', 'e', 'f'},
                        {'c', 'a', 'm'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testNotConcatenateDifferentLinesToFindAHorizontalWord() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("elixir", Optional.empty());

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'a', 'b', 'c', 'e', 'l', 'i'},
                        {'x', 'i', 'r', 'd', 'f', 'g'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testNotWrapAroundHorizontallyToFindAWord() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("lisp", Optional.empty());

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'s', 'i', 'l', 'a', 'b', 'c', 'd', 'e', 'f', 'p'}
                }
        );

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

    @Disabled("Remove to run test")
    @Test
    public void testNotWrapAroundVerticallyToFindAWord() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("rust", Optional.empty());

        Set<String> searchWords = expectedLocations.keySet();

        Map<String, Optional<WordLocation>> actualLocations = wordSearcher.search(
                searchWords,
                new char[][]{
                        {'s'},
                        {'u'},
                        {'r'},
                        {'a'},
                        {'b'},
                        {'c'},
                        {'t'}});

        assertThat(actualLocations).isEqualTo(expectedLocations);
    }

}
