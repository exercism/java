import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCountTest {

    private WordCount wordCount;
    private Map<String, Integer> actualWordCount;
    private Map<String, Integer> expectedWordCount;

    @BeforeEach
    public void setup() {
        wordCount = new WordCount();
        expectedWordCount = new HashMap<>();
    }


    @Test
    @DisplayName("count one word")
    public void countOneWord() {
        expectedWordCount.put("word", 1);

        actualWordCount = wordCount.phrase("word");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("count one of each word")
    public void countOneOfEachWord() {
        expectedWordCount.put("one", 1);
        expectedWordCount.put("of", 1);
        expectedWordCount.put("each", 1);

        actualWordCount = wordCount.phrase("one of each");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple occurrences of a word")
    public void multipleOccurrencesOfAWord() {
        expectedWordCount.put("one", 1);
        expectedWordCount.put("fish", 4);
        expectedWordCount.put("two", 1);
        expectedWordCount.put("red", 1);
        expectedWordCount.put("blue", 1);

        actualWordCount = wordCount.phrase("one fish two fish red fish blue fish");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("handles cramped lists")
    public void handlesCrampedLists() {
        expectedWordCount.put("one", 1);
        expectedWordCount.put("two", 1);
        expectedWordCount.put("three", 1);

        actualWordCount = wordCount.phrase("one,two,three");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("handles expanded lists")
    public void handlesExpandedLists() {
        expectedWordCount.put("one", 1);
        expectedWordCount.put("two", 1);
        expectedWordCount.put("three", 1);

        actualWordCount = wordCount.phrase("one,\ntwo,\nthree");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ignore punctuation")
    public void ignorePunctuation() {
        expectedWordCount.put("car", 1);
        expectedWordCount.put("carpet", 1);
        expectedWordCount.put("as", 1);
        expectedWordCount.put("java", 1);
        expectedWordCount.put("javascript", 1);

        actualWordCount = wordCount.phrase("car : carpet as java : javascript!!&@$%^&");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("include numbers")
    public void includeNumbers() {
        expectedWordCount.put("testing", 2);
        expectedWordCount.put("1", 1);
        expectedWordCount.put("2", 1);

        actualWordCount = wordCount.phrase("testing, 1, 2 testing");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("normalize case")
    public void normalizeCase() {
        expectedWordCount.put("go", 3);
        expectedWordCount.put("stop", 2);

        actualWordCount = wordCount.phrase("go Go GO Stop stop");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("with apostrophes")
    public void withApostrophes() {
        expectedWordCount.put("first", 1);
        expectedWordCount.put("don't", 2);
        expectedWordCount.put("laugh", 1);
        expectedWordCount.put("then", 1);
        expectedWordCount.put("cry", 1);
        expectedWordCount.put("you're", 1);
        expectedWordCount.put("getting", 1);
        expectedWordCount.put("it", 1);

        actualWordCount = wordCount.phrase("'First: don't laugh. Then: don't cry. You're getting it.'");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("substrings from the beginning")
    public void substringsFromTheBeginning() {
        expectedWordCount.put("joe", 1);
        expectedWordCount.put("can't", 1);
        expectedWordCount.put("tell", 1);
        expectedWordCount.put("between", 1);
        expectedWordCount.put("app", 1);
        expectedWordCount.put("apple", 1);
        expectedWordCount.put("and", 1);
        expectedWordCount.put("a", 1);

        actualWordCount = wordCount.phrase("Joe can't tell between app, apple and a.");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("with quotations")
    public void withQuotations() {
        expectedWordCount.put("joe", 1);
        expectedWordCount.put("can't", 1);
        expectedWordCount.put("tell", 1);
        expectedWordCount.put("between", 1);
        expectedWordCount.put("large", 2);
        expectedWordCount.put("and", 1);

        actualWordCount = wordCount.phrase("Joe can't tell between 'large' and large.");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple spaces not detected as a word")
    public void multipleSpacesNotDetectedAsAWord() {
        expectedWordCount.put("multiple", 1);
        expectedWordCount.put("whitespaces", 1);

        actualWordCount = wordCount.phrase(" multiple   whitespaces");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("alternating word separators not detected as a word")
    public void alternatingWordSeperatorsNotDetectedAsAWord() {
        expectedWordCount.put("one", 1);
        expectedWordCount.put("two", 1);
        expectedWordCount.put("three", 1);

        actualWordCount = wordCount.phrase(",\n,one,\n ,two \n 'three'");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("quotation for word with apostrophe")
    public void quotationForWordWithApostrophe() {
        expectedWordCount.put("can", 1);
        expectedWordCount.put("can't", 2);

        actualWordCount = wordCount.phrase("can, can't, 'can't'");
        assertThat(actualWordCount).isEqualTo(expectedWordCount);
    }

}
