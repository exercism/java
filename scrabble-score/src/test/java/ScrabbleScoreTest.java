import org.junit.Test;

public class ScrabbleScoreTest {

    @Test
    public void emptyWordScoresZero() {
        Scrabble scrabble = new Scrabble("");

        assertEquals(scrabble.getScore(), 0);
    }

    @Test
    public void whitespaceWordScoresZero() {
        Scrabble scrabble = new Scrabble(" \t\n");

        assertEquals(scrabble.getScore(), 0);
    }

    @Test
    public void nullScoresZero() {
        Scrabble scrabble = new Scrabble(null);

        assertEquals(scrabble.getScore(), 0);
    }

    @Test
    public void scoresVeryShortWord() {
        Scrabble scrabble = new Scrabble("a");

        assertEquals(scrabble.getScore(), 1);
    }

    @Test
    public void scoresAnotherVeryShortWord() {
        Scrabble scrabble = new Scrabble("f");

        assertEquals(scrabble.getScore(), 4);
    }

    @Test
    public void simpleWordScoresTheNumberOfLetters() {
        Scrabble scrabble = new Scrabble("street");

        assertEquals(scrabble.getScore(), 6);
    }

    @Test
    public void complicatedWordScoresMore() {
        Scrabble scrabble = new Scrabble("quirky");

        assertEquals(scrabble.getScore(), 22);
    }

    @Test
    public void scoresAreCaseInsensitive() {
        Scrabble scrabble = new Scrabble("MULTIBILLIONAIRE");

        assertEquals(scrabble.getScore(), 20);
    }

    @Test
    public void convenientScoring() {
        Scrabble scrabble = new Scrabble("alacrity");

        assertEquals(scrabble.getScore(), 13);
    }
}
