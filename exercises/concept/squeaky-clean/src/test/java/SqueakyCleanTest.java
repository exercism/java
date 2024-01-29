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
    @DisplayName("The clean method replaces numbers with underscores")
    public void numbers() {
        assertThat(SqueakyClean.clean("4bcd3")).isEqualTo("_bcd_");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces whitespaces with underscores in the middle of the string")
    public void spaces() {
        assertThat(SqueakyClean.clean("my   Id 1")).isEqualTo("my___Id__");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces leading and trailing whitespaces with underscores")
    public void leading_and_trailing_spaces() {
        assertThat(SqueakyClean.clean(" myId ")).isEqualTo("_myId_");
    }
    
    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces numbers and spaces with underscores")
    public void numbers_and_spaces() {
        assertThat(SqueakyClean.clean("my id 123")).isEqualTo("my_id____");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method converts kebab to camel case after removing a dash")
    public void kebab_to_camel_case() {
        assertThat(SqueakyClean.clean("à-ḃç")).isEqualTo("àḂç");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case after removing a dash and replacing the number")
    public void kebab_to_camel_case_and_number() {
        assertThat(SqueakyClean.clean("a-C1")).isEqualTo("aC_");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case after removing a dash and replaces whitespaces")
    public void kebab_to_camel_case_and_spaces() {
        assertThat(SqueakyClean.clean(" hello-world ")).isEqualTo("_helloWorld_");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method removes all characters that are not letters")
    public void special_characters() {
        assertThat(SqueakyClean.clean("a$#.b")).isEqualTo("ab");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method removes all characters that are not letters and replaces spaces and numbers")
    public void special_characters_with_numbers_and_spaces() {
        assertThat(SqueakyClean.clean("h3llo world!. ")).isEqualTo("h_llo_world_");
    }
}
