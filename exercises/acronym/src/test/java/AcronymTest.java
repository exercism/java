import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class AcronymTest {

    @Test
    public void basic() {
        String phrase = "Portable Network Graphics";
        String expected = "PNG";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void lowercaseWords() {
        String phrase = "Ruby on Rails";
        String expected = "ROR";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void punctuation() {
        String phrase = "First In, First Out";
        String expected = "FIFO";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void nonAcronymAllCapsWord() {
        String phrase = "GNU Image Manipulation Program";
        String expected = "GIMP";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void punctuationWithoutWhitespace() {
        String phrase = "Complementary metal-oxide semiconductor";
        String expected = "CMOS";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void veryLongAbbreviation() {
        String phrase = "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me";
        String expected = "ROTFLSHTMDCOALM";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void consecutiveDelimiters() {
        String phrase = "Something - I made up from thin air";
        String expected = "SIMUFTA";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void apostrophes() {
        String phrase = "Halley's Comet";
        String expected = "HC";
        assertEquals(expected, new Acronym(phrase).get());
    }

    @Ignore("Remove to run test")
    @Test
    public void underscoreEmphasis() {
        String phrase = "The Road _Not_ Taken";
        String expected = "TRNT";
        assertEquals(expected, new Acronym(phrase).get());
    }


}
