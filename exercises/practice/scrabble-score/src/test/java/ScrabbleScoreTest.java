import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScrabbleScoreTest {

    @Test
    public void testALowerCaseLetter() {
        Scrabble scrabble = new Scrabble("a");
        assertThat(scrabble.getScore()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAUpperCaseLetter() {
        Scrabble scrabble = new Scrabble("A");
        assertThat(scrabble.getScore()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAValuableLetter() {
        Scrabble scrabble = new Scrabble("f");
        assertThat(scrabble.getScore()).isEqualTo(4);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAShortWord() {
        Scrabble scrabble = new Scrabble("at");
        assertThat(scrabble.getScore()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAShortValuableWord() {
        Scrabble scrabble = new Scrabble("zoo");
        assertThat(scrabble.getScore()).isEqualTo(12);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAMediumWord() {
        Scrabble scrabble = new Scrabble("street");
        assertThat(scrabble.getScore()).isEqualTo(6);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAMediumValuableWord() {
        Scrabble scrabble = new Scrabble("quirky");
        assertThat(scrabble.getScore()).isEqualTo(22);
    }

    @Disabled("Remove to run test")
    @Test
    public void testALongMixCaseWord() {
        Scrabble scrabble = new Scrabble("OxyphenButazone");
        assertThat(scrabble.getScore()).isEqualTo(41);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAEnglishLikeWord() {
        Scrabble scrabble = new Scrabble("pinata");
        assertThat(scrabble.getScore()).isEqualTo(8);
    }

    @Disabled("Remove to run test")
    @Test
    public void testAnEmptyInput() {
        Scrabble scrabble = new Scrabble("");
        assertThat(scrabble.getScore()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testEntireAlphabetAvailable() {
        Scrabble scrabble = new Scrabble("abcdefghijklmnopqrstuvwxyz");
        assertThat(scrabble.getScore()).isEqualTo(87);
    }

}
