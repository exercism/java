import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RunLengthEncodingTest {
    private RunLengthEncoding runLengthEncoding;

    @Before
    public void setUp() {
        runLengthEncoding = new RunLengthEncoding();
    }

    @Test
    public void encodeEmpty() {
        assertThat(runLengthEncoding.encode("")).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithOnlySingleValues() {
        assertThat(runLengthEncoding.encode("XYZ")).isEqualTo("XYZ");
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithNoSingleValues() {
        assertThat(runLengthEncoding.encode("AABBBCCCC")).isEqualTo("2A3B4C");
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithMixedValues() {
        assertThat(runLengthEncoding.encode(
            "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))
            .isEqualTo("12WB12W3B24WB");
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithWhitespaceValues() {
        assertThat(runLengthEncoding.encode("  hsqq qww  "))
            .isEqualTo("2 hs2q q2w2 ");
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithLowercaseValues() {
        assertThat(runLengthEncoding.encode("aabbbcccc")).isEqualTo("2a3b4c");
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeEmpty() {
        assertThat(runLengthEncoding.decode("")).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithOnlySingleValues() {
        assertThat(runLengthEncoding.decode("XYZ")).isEqualTo("XYZ");
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithNoSingleValues() {
        assertThat(runLengthEncoding.decode("2A3B4C")).isEqualTo("AABBBCCCC");
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithMixedValues() {
        assertThat(runLengthEncoding.decode("12WB12W3B24WB"))
            .isEqualTo("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB");
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithWhitespaceValues() {
        assertThat(runLengthEncoding.decode("2 hs2q q2w2 ")).isEqualTo("  hsqq qww  ");
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithLowercaseValues() {
        assertThat(runLengthEncoding.decode("2a3b4c")).isEqualTo("aabbbcccc");
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeThenDecode() {
        String inOut = "zzz ZZ  zZ";
        String encoded = runLengthEncoding.encode(inOut);
        assertThat(runLengthEncoding.decode(encoded)).isEqualTo(inOut);
    }
}
