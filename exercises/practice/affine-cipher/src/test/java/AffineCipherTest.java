import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AffineCipherTest {

    private AffineCipher affineCipher = new AffineCipher();

    @Test
    public void testEncodeYes() {
        assertThat(affineCipher.encode("yes", 5, 7)).isEqualTo("xbt");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeNo() {
        assertThat(affineCipher.encode("no", 15, 18)).isEqualTo("fu");
    }


    @Disabled("Remove to run test")
    @Test
    public void testEncodeOMG() {
        assertThat(affineCipher.encode("OMG", 21, 3)).isEqualTo("lvz");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeO_M_G() {
        assertThat(affineCipher.encode("O M G", 25, 47)).isEqualTo("hjp");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeMindBlowingly() {
        assertThat(affineCipher.encode("mindblowingly", 11, 15)).isEqualTo("rzcwa gnxzc dgt");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeNumbers() {
        assertThat(affineCipher.encode("Testing,1 2 3, testing.", 3, 4))
                .isEqualTo("jqgjc rw123 jqgjc rw");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeDeepThought() {
        assertThat(affineCipher.encode("Truth is fiction.", 5, 17))
                .isEqualTo("iynia fdqfb ifje");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeAllTheLetters() {
        assertThat(affineCipher.encode("The quick brown fox jumps over the lazy dog.", 17, 33))
                .isEqualTo("swxtj npvyk lruol iejdc blaxk swxmh qzglf");
    }

    @Disabled("Remove to run test")
    @Test
    public void testEncodeThrowsMeaningfulException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> affineCipher.encode("This is a test", 6, 17))
            .withMessage("Error: keyA and alphabet size must be coprime.");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeExercism() {
        assertThat(affineCipher.decode("tytgn fjr", 3, 7))
                .isEqualTo("exercism");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeSentence() {
        assertThat(affineCipher.decode("qdwju nqcro muwhn odqun oppmd aunwd o", 19, 16))
                .isEqualTo("anobstacleisoftenasteppingstone");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeNumbers() {
        assertThat(affineCipher.decode("odpoz ub123 odpoz ub", 25, 7))
                .isEqualTo("testing123testing");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeAllTheLetters() {
        assertThat(affineCipher.decode("swxtj npvyk lruol iejdc blaxk swxmh qzglf", 17, 33))
                .isEqualTo("thequickbrownfoxjumpsoverthelazydog");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeWithNoSpaces() {
        assertThat(affineCipher.decode("swxtjnpvyklruoliejdcblaxkswxmhqzglf", 17, 33))
                .isEqualTo("thequickbrownfoxjumpsoverthelazydog");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeWithTooManySpaces() {
        assertThat(affineCipher.decode("vszzm    cly   yd cg    qdp", 15, 16))
                .isEqualTo("jollygreengiant");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDecodeThrowsMeaningfulException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> affineCipher.decode("Test", 13, 5))
            .withMessage("Error: keyA and alphabet size must be coprime.");
    }

}
