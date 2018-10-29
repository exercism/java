import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class WordSearcherTest {

    private WordSearcher wordSearcher;

    @Before
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
    @Test
    public void testShouldLocateMultipleWords() {
        Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();
        expectedLocations.put("fortran",  Optional.of(new WordLocation(new Pair(1,  7), new Pair(7,  7))));
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

    @Ignore("Remove to run test")
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

        assertEquals(expectedLocations, actualLocations);
    }

}
