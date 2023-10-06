import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCipherStepTwoSubsitutionTest {

    private Cipher cipherWithDefaultKey = new Cipher("abcdefghij");

    @Ignore("Remove to run test")
    @Test
    public void cipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        String cipherText = "abcdefghij";
        assertThat(cipherWithDefaultKey.encode(plainText)).isEqualTo(cipherText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDecode() {
        String plainText = "abcdefghij";
        String cipherText = "aaaaaaaaaa";
        assertThat(cipherWithDefaultKey.decode(plainText)).isEqualTo(cipherText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherIsReversibleGivenKey() {
        String plainText = "abcdefghij";
        assertThat(cipherWithDefaultKey.decode(cipherWithDefaultKey.encode(plainText))).isEqualTo(plainText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        String cipherText = "qayaeaagaciai";
        assertThat(new Cipher(plainText).encode(plainText)).isEqualTo(cipherText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanWrapEncode() {
        String plainText = "zzzzzzzzzz";
        String cipherText = "zabcdefghi";
        assertThat(cipherWithDefaultKey.encode(plainText)).isEqualTo(cipherText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanWrapDecode() {
        String plainText = "zabcdefghi";
        String cipherText = "zzzzzzzzzz";
        assertThat(cipherWithDefaultKey.decode(plainText)).isEqualTo(cipherText);
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherMessageLongerThanKey() {
        String plainText = "iamapandabear";
        String key = "abc";
        String cipherText = "iboaqcnecbfcr";
        assertThat(new Cipher(key).encode(plainText)).isEqualTo(cipherText);
    }

}
