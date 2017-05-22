import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RotationalCipherTest {
    private  RotationalCipher rotationalCipher;

    @Before
    public void setUp() {
        rotationalCipher = new RotationalCipher();
    }

    @Test
    public void rotateEmpty() {
        Assert.assertEquals("", rotationalCipher.rotate("", 13));
    }


    @Ignore("Remove to run test")
    @Test
    public void rotateLowerCaseWithoutSpaces() {
        Assert.assertEquals("nopqrstuvwxyzabcdefghijklm", rotationalCipher.rotate("abcdefghijklmnopqrstuvwxyz", 13));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateBy5() {
        Assert.assertEquals("trl", rotationalCipher.rotate("omg", 5));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateLowerCaseWithSpaces(){
        Assert.assertEquals("nopqr stuvw xyzab cdefg hijkl m", rotationalCipher.rotate("abcde fghij klmno pqrst uvwxy z", 13));
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateUpperCaseWithoutSpaces(){
        Assert.assertEquals("NOP", rotationalCipher.rotate("ABC", 13));    
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateUpperCaseWithSpaces(){
        Assert.assertEquals("NOP QRST", rotationalCipher.rotate("ABC DEFG", 13));    
    }   

    @Ignore("Remove to run test")
    @Test
    public void rotateSpecialCharacter(){
        Assert.assertEquals("$$", rotationalCipher.rotate("$$", 13));    
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateMixedCase1(){
        Assert.assertEquals("The quick brown fox jumps over the lazy dog.", rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt.", 13));        
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateMixedCase2(){
        Assert.assertEquals("Gur dhvpx oebja sbk whzcf bire gur ynml qbt.", rotationalCipher.rotate("The quick brown fox jumps over the lazy dog.", 13));        
    }

    @Ignore("Remove to run test")
    @Test
    public void rotateNumbers(){
        Assert.assertEquals("Xiwxmrk 1 2 3 xiwxmrk", rotationalCipher.rotate("Testing 1 2 3 testing", 4));            
    }

    @Ignore("Remove to run test")
    @Test
    public void rotatePunctuation(){
        Assert.assertEquals("Gzo'n zvo, Bmviyhv!", rotationalCipher.rotate("Let's eat, Grandma!", 21));                
    }

}