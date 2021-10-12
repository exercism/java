import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AcronymTest {

    @Test
    public void basic() {
        assertThat(new Acronym("Portable Network Graphics").get())
                .isEqualTo("PNG");
    }

    @Ignore("Remove to run test")
    @Test
    public void lowercaseWords() {
        assertThat(new Acronym("Ruby on Rails").get())
                .isEqualTo("ROR");
    }

    @Ignore("Remove to run test")
    @Test
    public void punctuation() {
        assertThat(new Acronym("First In, First Out").get())
                .isEqualTo("FIFO");
    }

    @Ignore("Remove to run test")
    @Test
    public void nonAcronymAllCapsWord() {
        assertThat(new Acronym("GNU Image Manipulation Program").get())
                .isEqualTo("GIMP");
    }

    @Ignore("Remove to run test")
    @Test
    public void punctuationWithoutWhitespace() {
        assertThat(new Acronym("Complementary metal-oxide semiconductor").get())
                .isEqualTo("CMOS");
    }

    @Ignore("Remove to run test")
    @Test
    public void veryLongAbbreviation() {
        assertThat(new Acronym("Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me").get())
                .isEqualTo("ROTFLSHTMDCOALM");
    }

    @Ignore("Remove to run test")
    @Test
    public void consecutiveDelimiters() {
        assertThat(new Acronym("Something - I made up from thin air").get())
                .isEqualTo("SIMUFTA");
    }

    @Ignore("Remove to run test")
    @Test
    public void apostrophes() {
        assertThat(new Acronym("Halley's Comet").get())
                .isEqualTo("HC");
    }

    @Ignore("Remove to run test")
    @Test
    public void underscoreEmphasis() {
        assertThat(new Acronym("The Road _Not_ Taken").get())
                .isEqualTo("TRNT");
    }


}
