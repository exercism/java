import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScrabbleScoreTest {

    private String scrabbleInput;
    private int scrabbleScore;

    @Parameterized.Parameters(name = "{index}: expected scrabble score for \"{0}\" to be {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", 0},
                {" \t\n", 0},
                {null, 0},
                {"a", 1},
                {"f", 4},
                {"street", 6},
                {"quirky", 22},
                {"OXYPHENBUTAZONE", 41},
                {"alacrity", 13},
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
