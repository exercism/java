import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class SubstitutionCipherTest {

    private static final String KEY = "abcdefghij";
    private Cipher cipher;

    @Before
    public void setup() {
        this.cipher = new Cipher(KEY);
    }


    @Test
    public void cipherKeepsTheSubmittedKey() {
        assertEquals(KEY, cipher.getKey());
    }

    @Ignore
    @Test
    public void cipherCanEncodeWithGivenKey() {
        String expectedOutput = "abcdefghij";

        assertEquals(expectedOutput, cipher.encode("aaaaaaaaaa"));
    }

    @Ignore
    @Test
    public void cipherCanDecodeWithGivenKey() {
        String expectedOutput = "aaaaaaaaaa";

        assertEquals(expectedOutput, cipher.decode("abcdefghij"));
    }

    @Ignore
    @Test
    public void cipherIsReversibleGivenKey() {
        String plainText = "abcdefghij";

        assertEquals(plainText, cipher.decode(cipher.encode("abcdefghij")));
    }

    @Ignore
    @Test
    public void cipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        String expectedOutput = "qayaeaagaciai";

        assertEquals(expectedOutput, new Cipher(plainText).encode(plainText));
    }

    @Ignore
    @Test
    public void cipherCanWrapEncode() {
        String expectedOutput = "zabcdefghi";

        assertEquals(expectedOutput, cipher.encode("zzzzzzzzzz"));
    }

    @Ignore
    @Test
    public void cipherCanEncodeMessageThatIsShorterThanTheKey() {
        String expectedOutput = "abcde";

        assertEquals(expectedOutput, cipher.encode("aaaaa"));
    }

    @Ignore
    @Test
    public void cipherCanDecodeMessageThatIsShorterThanTheKey() {
        String expectedOutput = "aaaaa";

        assertEquals(expectedOutput, cipher.decode("abcde"));
    }
}
