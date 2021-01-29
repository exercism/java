import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleCipherStepTwoSubsitutionTest {

    private Cipher cipherWithDefaultKey = new Cipher("abcdefghij");

    @Ignore("Remove to run test")
    @Test
    public void cipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        String cipherText = "abcdefghij";
        assertEquals(cipherText, cipherWithDefaultKey.encode(plainText));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDecode() {
        String plainText = "abcdefghij";
        String cipherText = "aaaaaaaaaa";
        assertEquals(cipherText, cipherWithDefaultKey.decode(plainText));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherIsReversibleGivenKey() {
        String plainText = "abcdefghij";
        assertEquals(plainText, cipherWithDefaultKey.decode(cipherWithDefaultKey.encode(plainText)));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        String cipherText = "qayaeaagaciai";
        assertEquals(cipherText, new Cipher(plainText).encode(plainText));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanWrapEncode() {
        String plainText = "zzzzzzzzzz";
        String cipherText = "zabcdefghi";
        assertEquals(cipherText, cipherWithDefaultKey.encode(plainText));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherCanWrapDecode() {
        String plainText = "zabcdefghi";
        String cipherText = "zzzzzzzzzz";
        assertEquals(cipherText, cipherWithDefaultKey.decode(plainText));
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherMessageLongerThanKey() {
        String plainText = "iamapandabear";
        String key = "abc";
        String cipherText = "iboaqcnecbfcr";
        assertEquals(cipherText, new Cipher(key).encode(plainText));
    }

}
