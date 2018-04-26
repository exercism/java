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
    public void NonAcronymAllCapsWord() {
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

}
