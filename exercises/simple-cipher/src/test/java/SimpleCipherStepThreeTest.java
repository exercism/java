import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Step 3: Generate random key if key isn't specified. Check key is right format
 */
public class SimpleCipherStepThreeTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Ignore("Remove to run test")
    @Test
    public void cipherKeyIsMadeOfLetters() {
        assertTrue(new Cipher().getKey().matches("[a-z]+"));
    }

    @Ignore("Remove to run test")
    @Test
    public void defaultCipherKeyIs100Characters() {
        assertEquals(100, new Cipher().getKey().length());
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherKeysAreRandomlyGenerated() {
        String newKey = new Cipher().getKey();
        assertFalse("Cipher constructor without argument should generate a random key. No two calls to the" +
                " constructor should generate the same key. Two calls to the constructor " +
                "both returned key: " + newKey, newKey.equals(new Cipher().getKey()));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithAllCapsKey() {
        expectedException.expect(IllegalArgumentException.class);
        new Cipher("ABCDEF");
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithAnyCapsKey() {
        expectedException.expect(IllegalArgumentException.class);
        new Cipher("abcdEFg");
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithNumericKey() {
        expectedException.expect(IllegalArgumentException.class);
        new Cipher("12345");
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithAnyNumericKey() {
        expectedException.expect(IllegalArgumentException.class);
        new Cipher("abcd345ef");
    }
}
