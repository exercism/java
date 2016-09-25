import org.junit.Test;
import org.junit.Ignore;

public class IncorrectKeyCipherTest {


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
