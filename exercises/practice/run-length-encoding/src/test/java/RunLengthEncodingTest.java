import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RunLengthEncodingTest {
    private RunLengthEncoding runLengthEncoding;

    @BeforeEach
    public void setUp() {
        runLengthEncoding = new RunLengthEncoding();
    }

    @Test
    public void encodeEmpty() {
        assertThat(runLengthEncoding.encode("")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeWithOnlySingleValues() {
        assertThat(runLengthEncoding.encode("XYZ")).isEqualTo("XYZ");
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeWithNoSingleValues() {
        assertThat(runLengthEncoding.encode("AABBBCCCC")).isEqualTo("2A3B4C");
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeWithMixedValues() {
        assertThat(runLengthEncoding.encode(
            "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))
            .isEqualTo("12WB12W3B24WB");
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeWithWhitespaceValues() {
        assertThat(runLengthEncoding.encode("  hsqq qww  "))
            .isEqualTo("2 hs2q q2w2 ");
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeWithLowercaseValues() {
        assertThat(runLengthEncoding.encode("aabbbcccc")).isEqualTo("2a3b4c");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeEmpty() {
        assertThat(runLengthEncoding.decode("")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithOnlySingleValues() {
        assertThat(runLengthEncoding.decode("XYZ")).isEqualTo("XYZ");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithNoSingleValues() {
        assertThat(runLengthEncoding.decode("2A3B4C")).isEqualTo("AABBBCCCC");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithMixedValues() {
        assertThat(runLengthEncoding.decode("12WB12W3B24WB"))
            .isEqualTo("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithWhitespaceValues() {
        assertThat(runLengthEncoding.decode("2 hs2q q2w2 ")).isEqualTo("  hsqq qww  ");
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWithLowercaseValues() {
        assertThat(runLengthEncoding.decode("2a3b4c")).isEqualTo("aabbbcccc");
    }

    @Disabled("Remove to run test")
    @Test
    public void encodeThenDecode() {
        String inOut = "zzz ZZ  zZ";
        String encoded = runLengthEncoding.encode(inOut);
        assertThat(runLengthEncoding.decode(encoded)).isEqualTo(inOut);
    }
}
