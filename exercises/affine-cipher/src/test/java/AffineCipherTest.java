import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AffineCipherTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEncodeYes() {
        AffineCipher affineCipher = new AffineCipher();

        assertEquals("xbt", affineCipher.encode("yes", 5, 7)
        );
    }

    @Ignore("Remove to run test.")
    @Test
    public void testEncodeNo() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("fu", affineCipher.encode("no", 15, 18));
    }


    @Ignore("Remove to run test.")
    @Test
    public void testEncodeOMG() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("lvz", affineCipher.encode("OMG", 21, 3));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testEncodeO_M_G() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("hjp", affineCipher.encode("O M G", 25, 47));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testEncodeMindBlowingly() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("rzcwa gnxzc dgt", affineCipher.encode("mindblowingly", 11, 15));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testEncodeNumbers() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("jqgjc rw123 jqgjc rw",
                affineCipher.encode("Testing,1 2 3, testing.", 3, 4));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testEncodeDeepThought() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("iynia fdqfb ifje",
                affineCipher.encode("Truth is fiction.", 5, 17));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testEncodeAllTheLetters() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("swxtj npvyk lruol iejdc blaxk swxmh qzglf",
                affineCipher.encode("The quick brown fox jumps over the lazy dog.", 17, 33));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testEncodeRaisesMeaningfulException() throws IllegalArgumentException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Error: keyA and alphabet size must be coprime.");

        AffineCipher affineCipher = new AffineCipher();
        affineCipher.encode("This is a test", 6, 17);
    }

    @Ignore("Remove to run test.")
    @Test
    public void testDecodeExercism() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("exercism", affineCipher.decode("tytgn fjr", 3, 7));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testDecodeSentence() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("anobstacleisoftenasteppingstone",
                affineCipher.decode("qdwju nqcro muwhn odqun oppmd aunwd o", 19, 16));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testDecodeNumbers() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("testing123testing", affineCipher.decode("odpoz ub123 odpoz ub", 25, 7));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testDecodeAllTheLetters() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("thequickbrownfoxjumpsoverthelazydog", affineCipher.decode("swxtj npvyk lruol iejdc blaxk swxmh qzglf", 17, 33));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testDecodeWithNoSpaces() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("thequickbrownfoxjumpsoverthelazydog", affineCipher.decode("swxtjnpvyklruoliejdcblaxkswxmhqzglf", 17, 33));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testDecodeWithTooManySpaces() {
        AffineCipher affineCipher = new AffineCipher();
        assertEquals("jollygreengiant", affineCipher.decode("vszzm    cly   yd cg    qdp", 15, 16));
    }

    @Ignore("Remove to run test.")
    @Test
    public void testDecodeRaisesMeaningfulException() throws IllegalArgumentException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Error: keyA and alphabet size must be coprime.");

        AffineCipher affineCipher = new AffineCipher();
        affineCipher.decode("Test", 13, 5);
    }
}
