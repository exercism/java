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
        String cipherText = cipherWithDefaultKey.getKey().substring(0, 10);
        assertEquals(cipherText, cipherWithDefaultKey.encode("aaaaaaaaaa"));
    }

    @Ignore
    @Test
    public void cipherCanDecode() {
        String cipherText = "aaaaaaaaaa";
        assertEquals(cipherText, cipherWithDefaultKey.decode(cipherWithDefaultKey.getKey().substring(0, 10)));
    }

    @Ignore
    @Test
    public void cipherIsReversible() {
        String plainText = "abcdefghij";
        assertEquals(plainText, cipherWithDefaultKey.decode(cipherWithDefaultKey.encode(plainText)));
    }
}
