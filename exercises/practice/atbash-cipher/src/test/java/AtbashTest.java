import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AtbashTest {

    private Atbash atbash;

    @BeforeEach
    public void setup() {
        atbash = new Atbash();
    }

    @Test
    public void testEncodeYes() {
        assertThat(atbash.encode("yes")).isEqualTo("bvh");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeNo() {
        assertThat(atbash.encode("no")).isEqualTo("ml");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeOmgInCapital() {
        assertThat(atbash.encode("OMG")).isEqualTo("lnt");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeOmgWithSpaces() {
        assertThat(atbash.encode("O M G")).isEqualTo("lnt");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeMindBlowingly() {
        assertThat(atbash.encode("mindblowingly")).isEqualTo("nrmwy oldrm tob");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeNumbers() {
        assertThat(atbash.encode("Testing,1 2 3, testing."))
                .isEqualTo("gvhgr mt123 gvhgr mt");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeDeepThought() {
        assertThat(atbash.encode("Truth is fiction."))
                .isEqualTo("gifgs rhurx grlm");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeAllTheLetters() {
        assertThat(atbash.encode("The quick brown fox jumps over the lazy dog."))
                .isEqualTo("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeExercism() {
        assertThat(atbash.decode("vcvix rhn")).isEqualTo("exercism");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeASentence() {
        assertThat(atbash.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v"))
                .isEqualTo("anobstacleisoftenasteppingstone");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeNumbers() {
        assertThat(atbash.decode("gvhgr mt123 gvhgr mt"))
                .isEqualTo("testing123testing");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeAllTheLetters() {
        assertThat(atbash.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"))
                .isEqualTo("thequickbrownfoxjumpsoverthelazydog");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeWithTooManySpaces() {
        assertThat(atbash.decode("vc vix    r hn")).isEqualTo("exercism");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeWithNoSpaces() {
        assertThat(atbash.decode("zmlyhgzxovrhlugvmzhgvkkrmthglmv"))
                .isEqualTo("anobstacleisoftenasteppingstone");
    }
}
