import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotationalCipherTest {

    private RotationalCipher rotationalCipher;

    @Test
    public void rotateSingleCharacterBy0() {
        rotationalCipher = new RotationalCipher(0);
        assertThat(rotationalCipher.rotate("a")).isEqualTo("a");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateSingleCharacterBy1() {
        rotationalCipher = new RotationalCipher(1);
        assertThat(rotationalCipher.rotate("a")).isEqualTo("b");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateSingleCharacterBy26() {
        rotationalCipher = new RotationalCipher(26);
        assertThat(rotationalCipher.rotate("a")).isEqualTo("a");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateSingleCharacterBy13() {
        rotationalCipher = new RotationalCipher(13);
        assertThat(rotationalCipher.rotate("m")).isEqualTo("z");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateSingleCharacterWithWrapAround() {
        rotationalCipher = new RotationalCipher(13);
        assertThat(rotationalCipher.rotate("n")).isEqualTo("a");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateCapitalLetters() {
        rotationalCipher = new RotationalCipher(5);
        assertThat(rotationalCipher.rotate("OMG")).isEqualTo("TRL");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateSpaces() {
        rotationalCipher = new RotationalCipher(5);
        assertThat(rotationalCipher.rotate("O M G")).isEqualTo("T R L");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateNumbers() {
        rotationalCipher = new RotationalCipher(4);
        assertThat(rotationalCipher.rotate("Testing 1 2 3 testing")).isEqualTo("Xiwxmrk 1 2 3 xiwxmrk");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotatePunctuation() {
        rotationalCipher = new RotationalCipher(21);
        assertThat(rotationalCipher.rotate("Let's eat, Grandma!")).isEqualTo("Gzo'n zvo, Bmviyhv!");
    }

    @Disabled("Remove to run test")
    @Test
    public void rotateAllLetters() {
        rotationalCipher = new RotationalCipher(13);
        assertThat(rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."))
            .isEqualTo("The quick brown fox jumps over the lazy dog.");
    }
}
