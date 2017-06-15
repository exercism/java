
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RotationalCipherTest {

    private RotationalCipher rotationalCipher;

    @Before
    public void setUp() {
        rotationalCipher = new RotationalCipher();
    }

    @Test
    public void rotateSingleCharacterBy1() {
        Assert.assertEquals("b", rotationalCipher.rotate("a", 1));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterBy26() {
        Assert.assertEquals("a", rotationalCipher.rotate("a", 26));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterBy0() {
        Assert.assertEquals("a", rotationalCipher.rotate("a", 0));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterBy13() {
        Assert.assertEquals("z", rotationalCipher.rotate("m", 13));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterWithWrapAround() {
        Assert.assertEquals("a", rotationalCipher.rotate("n", 13));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateCapitalLetters() {
        Assert.assertEquals("TRL", rotationalCipher.rotate("OMG", 5));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSpaces() {
        Assert.assertEquals("T R L", rotationalCipher.rotate("O M G", 5));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateNumbers() {
        Assert.assertEquals("Xiwxmrk 1 2 3 xiwxmrk", rotationalCipher.rotate("Testing 1 2 3 testing", 4));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotatePunctuation() {
        Assert.assertEquals("Gzo'n zvo, Bmviyhv!", rotationalCipher.rotate("Let's eat, Grandma!", 21));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateAllLetters() {
        Assert.assertEquals("The quick brown fox jumps over the lazy dog.",
         rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt.", 13));
    }

}
