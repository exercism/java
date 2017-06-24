import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/*
 * version: 1.0.0
 */
@RunWith(Parameterized.class)
public class ScrabbleScoreTest {

    private String scrabbleInput;
    private int scrabbleScore;

    @Parameterized.Parameters(name = "{index}: expected scrabble score for \"{0}\" to be {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"a", 1},
                {"A", 1},
                {"f", 4},
                {"at", 2},
                {"zoo", 12},
                {"street", 6},
                {"quirky", 22},
                {"OxyphenButazone", 41},
                {"pinata", 8},
                {"", 0},
                {"abcdefghijklmnopqrstuvwxyz", 87},
        });
    }

    public ScrabbleScoreTest(String scrabbleInput, int scrabbleScore) {
        this.scrabbleInput = scrabbleInput;
        this.scrabbleScore = scrabbleScore;
    }

    @Test
    public void test() {
        Scrabble scrabble = new Scrabble(scrabbleInput);
        assertEquals(scrabbleScore, scrabble.getScore());
    }

}
