import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCipherTest {
    private Cipher randomKeyCipher;
    private Cipher substitutionCipher = new Cipher("abcdefghij");

    @BeforeEach
    public void setup() {
        randomKeyCipher = new Cipher();
    }

    /**
     * Here we take advantage of the fact that plaintext of "aaa..." doesn't output the key. This is a critical
     * problem with shift ciphers, some characters will always output the key verbatim.
     */
    @Test
    @DisplayName("Can encode")
    public void randomKeyCipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        String cipherText = randomKeyCipher.getKey().substring(0, 10);
        assertThat(randomKeyCipher.encode(plainText)).isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Can decode")
    public void randomKeyCipherCanDecode() {
        String cipherText = "aaaaaaaaaa";
        assertThat(randomKeyCipher.decode(randomKeyCipher.getKey().substring(0, 10)))
            .isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName(
            "Is reversible. I.e., if you apply decode in a encoded result, " +
                    "you must see the same plaintext encode parameter as a result of the decode method"
    )
    public void randomKeyCipherIsReversible() {
        String plainText = "abcdefghij";
        assertThat(randomKeyCipher.decode(randomKeyCipher.encode(plainText))).isEqualTo(plainText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Key is made only of lowercase letters")
    public void randomKeyCipherKeyIsLowercaseLetters() {
        assertThat(randomKeyCipher.getKey()).matches("^[a-z]+$");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Can encode")
    public void substitutionCipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        String cipherText = "abcdefghij";
        assertThat(substitutionCipher.encode(plainText)).isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Can decode")
    public void substitutionCipherCanDecode() {
        String plainText = "abcdefghij";
        String cipherText = "aaaaaaaaaa";
        assertThat(substitutionCipher.decode(plainText)).isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Is reversible. I.e., if you apply decode in a encoded result, \n" +
            "you must see the same plaintext encode parameter as a result of the decode method")
    public void substitutionCipherIsReversibleGivenKey() {
        String plainText = "abcdefghij";
        assertThat(substitutionCipher.decode(substitutionCipher.encode(plainText))).isEqualTo(plainText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Can double shift encode")
    public void substitutionCipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        String cipherText = "qayaeaagaciai";
        assertThat(new Cipher(plainText).encode(plainText)).isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Can wrap on encode")
    public void substitutionCipherCanWrapEncode() {
        String plainText = "zzzzzzzzzz";
        String cipherText = "zabcdefghi";
        assertThat(substitutionCipher.encode(plainText)).isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Can wrap on decode")
    public void substitutionCipherCanWrapDecode() {
        String plainText = "zabcdefghi";
        String cipherText = "zzzzzzzzzz";
        assertThat(substitutionCipher.decode(plainText)).isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Can decode messages longer than the key")
    public void substitutionCipherMessageLongerThanKey() {
        String plainText = "iamapandabear";
        String key = "abc";
        String cipherText = "iboaqcnecbfcr";
        assertThat(new Cipher(key).encode(plainText)).isEqualTo(cipherText);
    }
}

