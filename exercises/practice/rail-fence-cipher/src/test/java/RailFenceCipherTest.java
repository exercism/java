import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RailFenceCipherTest {

    private RailFenceCipher railFenceCipher;

    @Test
    public void encodeWithTwoRails() {
        railFenceCipher = new RailFenceCipher(2);
        assertThat(railFenceCipher.getEncryptedData("XOXOXOXOXOXOXOXOXO"))
            .isEqualTo("XXXXXXXXXOOOOOOOOO");
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeWithThreeRails() {
        railFenceCipher = new RailFenceCipher(3);
        assertThat(railFenceCipher.getEncryptedData("WEAREDISCOVEREDFLEEATONCE"))
            .isEqualTo("WECRLTEERDSOEEFEAOCAIVDEN");
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeWithEndingInTheMiddle() {
        railFenceCipher = new RailFenceCipher(4);
        assertThat(railFenceCipher.getEncryptedData("EXERCISES"))
            .isEqualTo("ESXIEECSR");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithThreeRails() {
        railFenceCipher = new RailFenceCipher(3);
        assertThat(railFenceCipher.getDecryptedData("TEITELHDVLSNHDTISEIIEA"))
            .isEqualTo("THEDEVILISINTHEDETAILS");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithFiveRails() {
        railFenceCipher = new RailFenceCipher(5);
        assertThat(railFenceCipher.getDecryptedData("EIEXMSMESAORIWSCE"))
            .isEqualTo("EXERCISMISAWESOME");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithSixRails() {
        railFenceCipher = new RailFenceCipher(6);
        assertThat(railFenceCipher.getDecryptedData("133714114238148966225439541018335470986172518171757571896261"))
            .isEqualTo("112358132134558914423337761098715972584418167651094617711286");
    }
}
