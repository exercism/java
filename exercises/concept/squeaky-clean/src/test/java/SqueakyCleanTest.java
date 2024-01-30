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
        assertThat(SqueakyClean.clean("abc")).isEqualTo("abc");
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
    @DisplayName("The clean method converts kebab to camel case after removing a dash")
    public void kebab_to_camel_case() {
        assertThat(SqueakyClean.clean("a-bc")).isEqualTo("aBc");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case after removing a dash and replaces a whitespace")
    public void kebab_to_camel_case_and_number() {
        assertThat(SqueakyClean.clean("a-C ")).isEqualTo("aC_");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case and replaces leading and trailing whitespaces")
    public void kebab_to_camel_case_and_spaces() {
        assertThat(SqueakyClean.clean(" hello-world ")).isEqualTo("_helloWorld_");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method converts leetspeak to normal text after replacing numbers with chars")
    public void leetspeak_to_normal_text() {
        assertThat(SqueakyClean.clean("H3ll0 W0rld")).isEqualTo("Hello_World");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method converts leetspeak to normal text with spaces and special characters")
    public void leetspeak_to_normal_text_with_spaces_and_special_characters() {
        assertThat(SqueakyClean.clean("¡1337sp34k is fun!")).isEqualTo("leetspeak_is_fun");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The clean method removes all characters that are not letters")
    public void special_characters() {
        assertThat(SqueakyClean.clean("a$#.b")).isEqualTo("ab");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The clean method removes all characters that are not letters and replaces spaces")
    public void special_characters_and_spaces() {
        assertThat(SqueakyClean.clean("¡hello world!. ")).isEqualTo("hello_world_");
    }
}
