import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SqueakyCleanTest {

    @Test
    public void empty() {
        assertThat(SqueakyClean.clean("")).isEmpty();
    }

    @Test
    public void single_letter() {
        assertThat(SqueakyClean.clean("A")).isEqualTo("A");
    }

    @Test
    public void string() {
        assertThat(SqueakyClean.clean("àḃç")).isEqualTo("àḃç");
    }

    @Test
    public void spaces() {
        assertThat(SqueakyClean.clean("my   Id")).isEqualTo("my___Id");
    }

    @Test
    public void leading_and_trailing_spaces() {
        assertThat(SqueakyClean.clean(" myId ")).isEqualTo("_myId_");
    }

    @Test
    public void ctrl() {
        assertThat(SqueakyClean.clean("my\0Id")).isEqualTo("myCTRLId");
    }

    @Test
    public void string_with_no_letters() {
        assertThat(SqueakyClean.clean("\uD83D\uDE00\uD83D\uDE00\uD83D\uDE00")).isEmpty();
    }

    @Test
    public void kebab_to_camel_case() {
        assertThat(SqueakyClean.clean("à-ḃç")).isEqualTo("àḂç");
    }

    @Test
    public void omit_lower_case_greek_letters() {
        assertThat(SqueakyClean.clean("MyΟβιεγτFinder")).isEqualTo("MyΟFinder");
    }

    @Test
    public void combine_conversions() {
        assertThat(SqueakyClean.clean("9 -abcĐ\uD83D\uDE00ω\0")).isEqualTo("_AbcĐCTRL");
    }
}
