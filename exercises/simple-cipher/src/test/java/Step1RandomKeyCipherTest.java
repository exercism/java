import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

public class Step1RandomKeyCipherTest {
    private Cipher cipherWithDefaultKey;

    @Before
    public void setup() {
        cipherWithDefaultKey = new Cipher();
    }

    /**
     * Can encode
     */
    @Test
    public void cipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        String cipherText = cipherWithDefaultKey.getKey().substring(0, 10);
        assertEquals(cipherText, cipherWithDefaultKey.encode(plainText));
    }

    /**
     * Can decode
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherCanDecode() {
        String cipherText = "aaaaaaaaaa";
        assertEquals(cipherText, cipherWithDefaultKey.decode(cipherWithDefaultKey.getKey().substring(0, 10)));
    }

    /**
     * Is reversible. I.e., if you apply decode in a encoded result, you must see
     * the same plaintext encode parameter as a result of the decode method
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherIsReversible() {
        String plainText = "abcdefghij";
        assertEquals(plainText, cipherWithDefaultKey.decode(cipherWithDefaultKey.encode(plainText)));
    }
    
    /**
     * Key is made only of lowercase letters 
     */
    @Ignore("Remove to run test")
    @Test
    public void keyIsLowercaseLetters() {
        String key = cipherWithDefaultKey.getKey();
        assertTrue(Pattern.matches("^[a-z]+$", key));
    }
}
