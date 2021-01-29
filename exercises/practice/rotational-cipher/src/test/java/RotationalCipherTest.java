import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RotationalCipherTest {

    private RotationalCipher rotationalCipher;

    @Test
    public void rotateSingleCharacterBy0() {
        rotationalCipher = new RotationalCipher(0);
        Assert.assertEquals("a", rotationalCipher.rotate("a"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterBy1() {
        rotationalCipher = new RotationalCipher(1);
        Assert.assertEquals("b", rotationalCipher.rotate("a"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterBy26() {
        rotationalCipher = new RotationalCipher(26);
        Assert.assertEquals("a", rotationalCipher.rotate("a"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterBy13() {
        rotationalCipher = new RotationalCipher(13);
        Assert.assertEquals("z", rotationalCipher.rotate("m"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSingleCharacterWithWrapAround() {
        rotationalCipher = new RotationalCipher(13);
        Assert.assertEquals("a", rotationalCipher.rotate("n"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateCapitalLetters() {
        rotationalCipher = new RotationalCipher(5);
        Assert.assertEquals("TRL", rotationalCipher.rotate("OMG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateSpaces() {
        rotationalCipher = new RotationalCipher(5);
        Assert.assertEquals("T R L", rotationalCipher.rotate("O M G"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateNumbers() {
        rotationalCipher = new RotationalCipher(4);
        Assert.assertEquals("Xiwxmrk 1 2 3 xiwxmrk", rotationalCipher.rotate("Testing 1 2 3 testing"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotatePunctuation() {
        rotationalCipher = new RotationalCipher(21);
        Assert.assertEquals("Gzo'n zvo, Bmviyhv!", rotationalCipher.rotate("Let's eat, Grandma!"));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateAllLetters() {
        rotationalCipher = new RotationalCipher(13);
        Assert.assertEquals("The quick brown fox jumps over the lazy dog.",
                rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."));
    }
}
