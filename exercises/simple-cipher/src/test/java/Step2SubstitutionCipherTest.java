import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import org.junit.Before;

public class Step2SubstitutionCipherTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    private Cipher cipherWithDefaultKey;
    private static final String key = "abcdefghij";

    @Before
    public void setup() {
        cipherWithDefaultKey = new Cipher(key);
    }
    
    /**
     * Can encode
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        String cipherText = "abcdefghij";
        assertEquals(cipherText, cipherWithDefaultKey.encode(plainText));
    }
    
    /**
     * Can decode
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherCanDecode() {
        String plainText = "abcdefghij";
        String cipherText = "aaaaaaaaaa";
        assertEquals(cipherText, cipherWithDefaultKey.decode(plainText));
    }
    
    /**
     * Is reversible. I.e., if you apply decode in a encoded result, you must see
     * the same plaintext encode parameter as a result of the decode method
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherIsReversibleGivenKey() {
        String plainText = "abcdefghij";
        assertEquals(plainText, cipherWithDefaultKey.decode(cipherWithDefaultKey.encode(plainText)));
    }
    
    /**
     * Can double shift encode
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        String cipherText = "qayaeaagaciai";
        assertEquals(cipherText, new Cipher(plainText).encode(plainText));
    }
    
    /**
     * Can wrap on encode
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherCanWrapEncode() {
        String plainText = "zzzzzzzzzz";
        String cipherText = "zabcdefghi";
        assertEquals(cipherText, cipherWithDefaultKey.encode(plainText));
    }
    
    /**
     * Can wrap on decode
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherCanWrapDecode() {
        String plainText = "zabcdefghi";
        String cipherText = "zzzzzzzzzz";
        assertEquals(cipherText, cipherWithDefaultKey.decode(plainText));
    }
    
    /**
     * Can handle messages longer than the key
     */
    @Ignore("Remove to run test")
    @Test
    public void cipherMessageLongerThanKey() {
        String plainText = "iamapandabear";
        String key = "abc";
        String cipherText = "iboaqcnecbfcr";
        assertEquals(cipherText, new Cipher(key).encode(plainText));
    }
    
}
