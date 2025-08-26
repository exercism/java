import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AtbashTest {

    private Atbash atbash;

    @BeforeEach
    public void setup() {
        atbash = new Atbash();
    }

    @Test
    @DisplayName("encode yes")
    public void testEncodeYes() {
        assertThat(atbash.encode("yes")).isEqualTo("bvh");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("encode no")
    public void testEncodeNo() {
        assertThat(atbash.encode("no")).isEqualTo("ml");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("encode OMG")
    public void testEncodeOmgInCapital() {
        assertThat(atbash.encode("OMG")).isEqualTo("lnt");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("encode spaces")
    public void testEncodeOmgWithSpaces() {
        assertThat(atbash.encode("O M G")).isEqualTo("lnt");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("encode mindblowingly")
    public void testEncodeMindBlowingly() {
        assertThat(atbash.encode("mindblowingly")).isEqualTo("nrmwy oldrm tob");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("encode numbers")
    public void testEncodeNumbers() {
        assertThat(atbash.encode("Testing,1 2 3, testing."))
                .isEqualTo("gvhgr mt123 gvhgr mt");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("encode deep thought")
    public void testEncodeDeepThought() {
        assertThat(atbash.encode("Truth is fiction."))
                .isEqualTo("gifgs rhurx grlm");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("encode all the letters")
    public void testEncodeAllTheLetters() {
        assertThat(atbash.encode("The quick brown fox jumps over the lazy dog."))
                .isEqualTo("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("decode exercism")
    public void testDecodeExercism() {
        assertThat(atbash.decode("vcvix rhn")).isEqualTo("exercism");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("decode a sentence")
    public void testDecodeASentence() {
        assertThat(atbash.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v"))
                .isEqualTo("anobstacleisoftenasteppingstone");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("decode numbers")
    public void testDecodeNumbers() {
        assertThat(atbash.decode("gvhgr mt123 gvhgr mt"))
                .isEqualTo("testing123testing");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("decode all the letters")
    public void testDecodeAllTheLetters() {
        assertThat(atbash.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"))
                .isEqualTo("thequickbrownfoxjumpsoverthelazydog");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("decode with too many spaces")
    public void testDecodeWithTooManySpaces() {
        assertThat(atbash.decode("vc vix    r hn")).isEqualTo("exercism");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("decode with no spaces")
    public void testDecodeWithNoSpaces() {
        assertThat(atbash.decode("zmlyhgzxovrhlugvmzhgvkkrmthglmv"))
                .isEqualTo("anobstacleisoftenasteppingstone");
    }
}
