import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Step 2: Specify key and use that for shift distance : substitution cipher
 */
public class SimpleCipherStepTwoTest {
    private Cipher cipherWithSetKey;
    private static final String KEY = "abcdefghij";

    @Before
    public void setup() {
        cipherWithSetKey = new Cipher(KEY);
    }

    @Ignore
    @Test
    public void cipherKeepsTheSubmittedKey() {
        assertEquals(KEY, cipherWithSetKey.getKey());
    }

    @Ignore
    @Test
    public void cipherCanEncodeWithGivenKey() {
        String expectedOutput = "abcdefghij";
        assertEquals(expectedOutput, cipherWithSetKey.encode("aaaaaaaaaa"));
    }

    @Ignore
    @Test
    public void cipherCanDecodeWithGivenKey() {
        String expectedOutput = "aaaaaaaaaa";
        assertEquals(expectedOutput, cipherWithSetKey.decode("abcdefghij"));
    }

    @Ignore
    @Test
    public void cipherIsReversibleGivenKey() {
        String plainText = "abcdefghij";
        assertEquals(plainText, cipherWithSetKey.decode(cipherWithSetKey.encode("abcdefghij")));
    }

    @Ignore
    @Test
    public void cipherCanWrapEncode() {
        String expectedOutput = "zabcdefghi";
        assertEquals(expectedOutput, cipherWithSetKey.encode("zzzzzzzzzz"));
    }

    @Ignore
    @Test
    public void cipherCanEncodeMessageThatIsShorterThanTheKey() {
        String expectedOutput = "abcde";
        assertEquals(expectedOutput, cipherWithSetKey.encode("aaaaa"));
    }

    @Ignore
    @Test
    public void cipherCanDecodeMessageThatIsShorterThanTheKey() {
        String expectedOutput = "aaaaa";
        assertEquals(expectedOutput, cipherWithSetKey.decode("abcde"));
    }

    @Ignore
    @Test
    public void cipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        String expectedOutput = "qayaeaagaciai";
        assertEquals(expectedOutput, new Cipher(plainText).encode(plainText));
    }
}
