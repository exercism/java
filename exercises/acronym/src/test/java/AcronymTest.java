import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class AcronymTest {


    @Test
    public void fromTitleCasedPhrases() {
        final String phrase = "Portable Network Graphics";
        final String expected = "PNG";
        assertEquals(expected, Acronym.generate(phrase));
    }

    @Ignore
    @Test
    public void fromOtherTitleCasedPhrases() {
        final String phrase = "Ruby on Rails";
        final String expected = "ROR";
        assertEquals(expected, Acronym.generate(phrase));
    }

    @Ignore
    @Test
    public void fromInconsistentlyCasedPhrases() {
        final String phrase = "HyperText Markup Language";
        final String expected = "HTML";
        assertEquals(expected, Acronym.generate(phrase));
    }

    @Ignore
    @Test
    public void fromPhrasesWithPunctuation() {
        final String phrase = "First In, First Out";
        final String expected = "FIFO";
        assertEquals(expected, Acronym.generate(phrase));
    }

    @Ignore
    @Test
    public void fromOtherPhrasesWithPunctuation() {
        final String phrase = "PHP: Hypertext Preprocessor";
        final String expected = "PHP";
        assertEquals(expected, Acronym.generate(phrase));
    }

    @Ignore
    @Test
    public void fromPhrasesWithPunctuationAndSentenceCasing() {
        final String phrase = "Complementary metal-oxide semiconductor";
        final String expected = "CMOS";
        assertEquals(expected, Acronym.generate(phrase));
    }

    @Ignore
    @Test
    public void fromPhraseWithSingleLetterWord() {
        final String phrase = "Cat in a Hat";
        final String expected = "CIAH";
        assertEquals(expected, Acronym.generate(phrase));
    }

}
