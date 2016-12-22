import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Step 3: Generate random key if key isn't specified. Check key is right format
 */
public class SimpleCipherStepThreeTest {

    @Ignore
    @Test
    public void cipherKeyIsMadeOfLetters() {
        assertTrue(new Cipher().getKey().matches("[a-z]+"));
    }

    @Ignore
    @Test
    public void defaultCipherKeyIs100Characters() {
        assertEquals(100, new Cipher().getKey().length());
    }

    @Ignore
    @Test
    public void cipherKeysAreRandomlyGenerated() {
        String newKey = new Cipher().getKey();
        assertFalse("Cipher constructor without argument should generate a random key. No two calls to the" +
                " constructor should generate the same key. Two calls to the constructor " +
                "both returned key: " + newKey, newKey.equals(new Cipher().getKey()));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithAllCapsKey() {
        new Cipher("ABCDEF");
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithAnyCapsKey() {
        new Cipher("abcdEFg");
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithNumericKey() {
        new Cipher("12345");
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithAnyNumericKey() {
        new Cipher("abcd345ef");
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithEmptyKey() {
        new Cipher("");
    }
}
