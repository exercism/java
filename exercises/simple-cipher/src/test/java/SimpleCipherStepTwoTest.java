import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Step 2: Specify key and use that for shift distance : substitution cipher
 */
public class SimpleCipherStepTwoTest {
    private Cipher cipherWithSetKey;
    private static final String key = "abcdefghij";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        cipherWithSetKey = new Cipher(key);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherKeepsTheSubmittedKey() {
        assertEquals(key, cipherWithSetKey.getKey());
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithEmptyKey() {
        expectedException.expect(IllegalArgumentException.class);
        new Cipher("");
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanEncodeWithGivenKey() {
        String cipherText = "abcdefghij";
        assertEquals(cipherText, cipherWithSetKey.encode("aaaaaaaaaa"));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDecodeWithGivenKey() {
        String cipherText = "aaaaaaaaaa";
        assertEquals(cipherText, cipherWithSetKey.decode("abcdefghij"));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherIsReversibleGivenKey() {
        String plainText = "abcdefghij";
        assertEquals(plainText, cipherWithSetKey.decode(cipherWithSetKey.encode("abcdefghij")));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanWrapEncode() {
        String cipherText = "zabcdefghi";
        assertEquals(cipherText, cipherWithSetKey.encode("zzzzzzzzzz"));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanEncodeMessageThatIsShorterThanTheKey() {
        String cipherText = "abcde";
        assertEquals(cipherText, cipherWithSetKey.encode("aaaaa"));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDecodeMessageThatIsShorterThanTheKey() {
        String cipherText = "aaaaa";
        assertEquals(cipherText, cipherWithSetKey.decode("abcde"));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        String cipherText = "qayaeaagaciai";
        assertEquals(cipherText, new Cipher(plainText).encode(plainText));
    }
}
