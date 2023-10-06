import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

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
        String plainText = "aaaaaaaaaa";
        String cipherText = cipherWithDefaultKey.getKey().substring(0, 10);
        assertThat(cipherWithDefaultKey.encode(plainText)).isEqualTo(cipherText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDecode() {
        String cipherText = "aaaaaaaaaa";
        assertThat(cipherWithDefaultKey.decode(cipherWithDefaultKey.getKey().substring(0, 10))).isEqualTo(cipherText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherIsReversible() {
        String plainText = "abcdefghij";
        assertThat(cipherWithDefaultKey.decode(cipherWithDefaultKey.encode(plainText))).isEqualTo(plainText);
    }

    @Ignore("Remove to run test")
    @Test
    public void keyIsLowercaseLetters() {
        String key = cipherWithDefaultKey.getKey();
        assertThat(Pattern.matches("^[a-z]+$", key)).isTrue();
    }
}
