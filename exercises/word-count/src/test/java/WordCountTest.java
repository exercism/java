import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {

    private WordCount wordCount;
    private Map<String, Integer> actualWordCount;
    private Map<String, Integer> expectedWordCount;

    @Before
    public void setup() {
        wordCount = new WordCount();
        expectedWordCount = new HashMap<String, Integer>();
    }


    @Test
    public void countOneWord() {
        expectedWordCount.put("word", 1);

        actualWordCount = wordCount.phrase("word");
        assertEquals(
            expectedWordCount, actualWordCount
        );
    }

    @Ignore
    @Test
    public void countOneOfEach() {
        expectedWordCount.put("one", 1);
        expectedWordCount.put("of", 1);
        expectedWordCount.put("each", 1);

        actualWordCount = wordCount.phrase("one of each");
        assertEquals(
            expectedWordCount, actualWordCount
        );
    }

    @Ignore
    @Test
    public void countMultipleOccurences() {
        expectedWordCount.put("one", 1);
        expectedWordCount.put("fish", 4);
        expectedWordCount.put("two", 1);
        expectedWordCount.put("red", 1);
        expectedWordCount.put("blue", 1);

        actualWordCount = wordCount.phrase("one fish two fish red fish blue fish");
        assertEquals(
            expectedWordCount, actualWordCount
        );
    }

    @Ignore
    @Test
    public void ignorePunctuation() {
        expectedWordCount.put("car", 1);
        expectedWordCount.put("carpet", 1);
        expectedWordCount.put("as", 1);
        expectedWordCount.put("java", 1);
        expectedWordCount.put("javascript", 1);

        actualWordCount = wordCount.phrase("car : carpet as java : javascript!!&@$%^&");
        assertEquals(
            expectedWordCount, actualWordCount
        );

    }

    @Ignore
    @Test
    public void includeNumbers() {
        expectedWordCount.put("testing", 2);
        expectedWordCount.put("1", 1);
        expectedWordCount.put("2", 1);

        actualWordCount = wordCount.phrase("testing, 1, 2 testing");
        assertEquals(
            expectedWordCount, actualWordCount
        );
    }

    @Ignore
    @Test
    public void normalizeCase() {
        expectedWordCount.put("go", 3);

        actualWordCount = wordCount.phrase("go Go GO");
        assertEquals(
            expectedWordCount, actualWordCount
        );
    }

}
