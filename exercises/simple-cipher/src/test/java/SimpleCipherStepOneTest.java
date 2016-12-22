import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Step 1: Make a simple shift cipher
 */
public class SimpleCipherStepOneTest {
    private Cipher cipherWithDefaultKey;

    @Before
    public void setup() {
        cipherWithDefaultKey = new Cipher();
    }

    /**
     * Here we take advantage of the fact that plaintext of "aaa..." doesn't output the key. This is a critical problem
     * with shift ciphers, some characters will always output the key verbatim.
     */
    @Test
    public void cipherCanEncode() {
        String expectedOutput = cipherWithDefaultKey.getKey().substring(0, 10);
        assertEquals(expectedOutput, cipherWithDefaultKey.encode("aaaaaaaaaa"));
    }

    @Ignore
    @Test
    public void cipherCanDecode() {
        String expectedOutput = "aaaaaaaaaa";
        assertEquals(expectedOutput, cipherWithDefaultKey.decode(cipherWithDefaultKey.getKey().substring(0, 10)));
    }

    @Ignore
    @Test
    public void cipherIsReversible() {
        String plainText = "abcdefghij";
        assertEquals(plainText, cipherWithDefaultKey.decode(cipherWithDefaultKey.encode(plainText)));
    }
}
