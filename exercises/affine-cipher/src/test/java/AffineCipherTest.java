import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class AffineCipherTest {

    private AffineCipher affineCipher = new AffineCipher();

    @Test
    public void testEncodeYes() {
        assertEquals("xbt", affineCipher.encode("yes", 5, 7));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodeNo() {
        assertEquals("fu", affineCipher.encode("no", 15, 18));
    }


    @Ignore("Remove to run test")
    @Test
    public void testEncodeOMG() {
        assertEquals("lvz", affineCipher.encode("OMG", 21, 3));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodeO_M_G() {
        assertEquals("hjp", affineCipher.encode("O M G", 25, 47));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodeMindBlowingly() {
        assertEquals("rzcwa gnxzc dgt", affineCipher.encode("mindblowingly", 11, 15));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodeNumbers() {
        assertEquals("jqgjc rw123 jqgjc rw",
                affineCipher.encode("Testing,1 2 3, testing.", 3, 4));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodeDeepThought() {
        assertEquals("iynia fdqfb ifje",
                affineCipher.encode("Truth is fiction.", 5, 17));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodeAllTheLetters() {
        assertEquals("swxtj npvyk lruol iejdc blaxk swxmh qzglf",
                affineCipher.encode("The quick brown fox jumps over the lazy dog.", 17, 33));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodeThrowsMeaningfulException() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> affineCipher.encode("This is a test", 6, 17));

        assertThat(expected)
            .hasMessage("Error: keyA and alphabet size must be coprime.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeExercism() {
        assertEquals("exercism", affineCipher.decode("tytgn fjr", 3, 7));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeSentence() {
        assertEquals("anobstacleisoftenasteppingstone",
                affineCipher.decode("qdwju nqcro muwhn odqun oppmd aunwd o", 19, 16));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeNumbers() {
        assertEquals("testing123testing", affineCipher.decode("odpoz ub123 odpoz ub", 25, 7));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeAllTheLetters() {
        assertEquals("thequickbrownfoxjumpsoverthelazydog",
                affineCipher.decode("swxtj npvyk lruol iejdc blaxk swxmh qzglf", 17, 33));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeWithNoSpaces() {
        assertEquals("thequickbrownfoxjumpsoverthelazydog",
                affineCipher.decode("swxtjnpvyklruoliejdcblaxkswxmhqzglf", 17, 33));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeWithTooManySpaces() {
        assertEquals("jollygreengiant", affineCipher.decode("vszzm    cly   yd cg    qdp", 15, 16));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecodeThrowsMeaningfulException() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> affineCipher.decode("Test", 13, 5));

        assertThat(expected)
            .hasMessage("Error: keyA and alphabet size must be coprime.");
    }

}
