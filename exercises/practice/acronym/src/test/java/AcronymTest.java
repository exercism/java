import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class AcronymTest {

    
    @DisplayName("basic")
    @Test
    public void basic() {
        assertThat(new Acronym("Portable Network Graphics").get())
                .isEqualTo("PNG");
    }

    @DisplayName("lowercase words")
    @Disabled("Remove to run test")
    @Test
    public void lowercaseWords() {
        assertThat(new Acronym("Ruby on Rails").get())
                .isEqualTo("ROR");
    }

    @DisplayName("punctuation")
    @Disabled("Remove to run test")
    @Test
    public void punctuation() {
        assertThat(new Acronym("First In, First Out").get())
                .isEqualTo("FIFO");
    }

    @DisplayName("all caps word")
    @Disabled("Remove to run test")
    @Test
    public void nonAcronymAllCapsWord() {
        assertThat(new Acronym("GNU Image Manipulation Program").get())
                .isEqualTo("GIMP");
    }

    @DisplayName("punctuation without whitespace")
    @Disabled("Remove to run test")
    @Test
    public void punctuationWithoutWhitespace() {
        assertThat(new Acronym("Complementary metal-oxide semiconductor").get())
                .isEqualTo("CMOS");
    }

    @DisplayName("very long abbreviation")
    @Disabled("Remove to run test")
    @Test
    public void veryLongAbbreviation() {
        assertThat(new Acronym("Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me").get())
                .isEqualTo("ROTFLSHTMDCOALM");
    }

    @DisplayName("consecutive delimiters")
    @Disabled("Remove to run test")
    @Test
    public void consecutiveDelimiters() {
        assertThat(new Acronym("Something - I made up from thin air").get())
                .isEqualTo("SIMUFTA");
    }

    @DisplayName("apostrophes")
    @Disabled("Remove to run test")
    @Test
    public void apostrophes() {
        assertThat(new Acronym("Halley's Comet").get())
                .isEqualTo("HC");
    }

    @DisplayName("underscore emphasis")
    @Disabled("Remove to run test")
    @Test
    public void underscoreEmphasis() {
        assertThat(new Acronym("The Road _Not_ Taken").get())
                .isEqualTo("TRNT");
    }


}
