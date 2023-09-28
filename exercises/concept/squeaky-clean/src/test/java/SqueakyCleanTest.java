import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SqueakyCleanTest {

    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns empty string when invoked on empty string")
    public void empty() {
        assertThat(SqueakyClean.clean("")).isEmpty();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns the same string when invoked on a single letter string")
    public void single_letter() {
        assertThat(SqueakyClean.clean("A")).isEqualTo("A");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns the same string when invoked on a string of three letters")
    public void string() {
        assertThat(SqueakyClean.clean("àḃç")).isEqualTo("àḃç");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces whitespaces with underscores in the middle of the string")
    public void spaces() {
        assertThat(SqueakyClean.clean("my   Id")).isEqualTo("my___Id");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces leading and trailing whitespaces with underscores")
    public void leading_and_trailing_spaces() {
        assertThat(SqueakyClean.clean(" myId ")).isEqualTo("_myId_");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method replaces control characters with CTRL")
    public void ctrl() {
        assertThat(SqueakyClean.clean("my\0\r\u007FId")).isEqualTo("myCTRLCTRLCTRLId");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The clean method returns an empty string when invoked on a string with no letters")
    public void string_with_no_letters() {
        assertThat(SqueakyClean.clean("\uD83D\uDE00\uD83D\uDE00\uD83D\uDE00")).isEmpty();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method converts kebab to camel case after removing a dash")
    public void kebab_to_camel_case() {
        assertThat(SqueakyClean.clean("à-ḃç")).isEqualTo("àḂç");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method returns a string in camel case after removing a dash and a number")
    public void kebab_to_camel_case_no_letter() {
        assertThat(SqueakyClean.clean("a-1C")).isEqualTo("aC");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The clean method removes all characters that are not letters")
    public void keep_only_letters() {
        assertThat(SqueakyClean.clean("a1\uD83D\uDE002\uD83D\uDE003\uD83D\uDE00b")).isEqualTo("ab");
    }

    @Test
    @Tag("task:5")
    @DisplayName("The clean method removes all lowercase greek letters")
    public void omit_lower_case_greek_letters() {
        assertThat(SqueakyClean.clean("MyΟβιεγτFinder")).isEqualTo("MyΟFinder");
    }

    @Test
    @Tag("task:5")
    @DisplayName("The clean method returns the correct result after performing a few cleaning operations")
    public void combine_conversions() {
        assertThat(SqueakyClean.clean("9 -abcĐ\uD83D\uDE00ω\0")).isEqualTo("_AbcĐCTRL");
    }
}
