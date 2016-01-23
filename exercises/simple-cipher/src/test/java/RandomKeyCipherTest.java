import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomKeyCipherTest {

    private Cipher cipher;

    @Before
    public void setup() {
        this.cipher = new Cipher();
    }

    @Test
    public void cipherKeyIsMadeOfLetters() {
        assertTrue(cipher.getKey().matches("[a-z]+"));
    }

    @Test
    public void defaultCipherKeyIs100Characters() {
        assertEquals(100, cipher.getKey().length());
    }

    @Test
    public void cipherKeysAreRandomlyGenerated() {
        assertTrue(!(new Cipher().getKey().equals(cipher.getKey())));
    }

    /**
     * Here we take advantage of the fact that plaintext of "aaa..." doesn't output the key. This is a critical problem
     * with shift ciphers, some characters will always output the key verbatim.
     */
    @Test
    public void cipherCanEncode() {
        String expectedOutput = cipher.getKey().substring(0, 10);

        assertEquals(expectedOutput, cipher.encode("aaaaaaaaaa"));
    }

    @Test
    public void cipherCanDecode() {
        String expectedOutput = "aaaaaaaaaa";

        assertEquals(expectedOutput, cipher.decode(cipher.getKey().substring(0, 10)));
    }

    @Test
    public void cipherIsReversible() {
        String plainText = "abcdefghij";

        assertEquals(plainText, cipher.decode(cipher.encode(plainText)));
    }
}
