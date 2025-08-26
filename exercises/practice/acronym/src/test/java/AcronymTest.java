import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class AcronymTest {

    
    @Test
    @DisplayName("basic")
    public void basic() {
        assertThat(new Acronym("Portable Network Graphics").get())
                .isEqualTo("PNG");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("lowercase words")
    public void lowercaseWords() {
        assertThat(new Acronym("Ruby on Rails").get())
                .isEqualTo("ROR");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("punctuation")
    public void punctuation() {
        assertThat(new Acronym("First In, First Out").get())
                .isEqualTo("FIFO");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("all caps word")
    public void nonAcronymAllCapsWord() {
        assertThat(new Acronym("GNU Image Manipulation Program").get())
                .isEqualTo("GIMP");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("punctuation without whitespace")
    public void punctuationWithoutWhitespace() {
        assertThat(new Acronym("Complementary metal-oxide semiconductor").get())
                .isEqualTo("CMOS");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("very long abbreviation")
    public void veryLongAbbreviation() {
        assertThat(new Acronym("Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me").get())
                .isEqualTo("ROTFLSHTMDCOALM");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("consecutive delimiters")
    public void consecutiveDelimiters() {
        assertThat(new Acronym("Something - I made up from thin air").get())
                .isEqualTo("SIMUFTA");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("apostrophes")
    public void apostrophes() {
        assertThat(new Acronym("Halley's Comet").get())
                .isEqualTo("HC");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("underscore emphasis")
    public void underscoreEmphasis() {
        assertThat(new Acronym("The Road _Not_ Taken").get())
                .isEqualTo("TRNT");
    }


}
