import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RunLengthEncodingTest {
    private RunLengthEncoding runLengthEncoding;

    @Before
    public void setUp() {
        runLengthEncoding = new RunLengthEncoding();
    }

    @Test
    public void encodeEmpty() {
        Assert.assertEquals("", runLengthEncoding.encode(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithOnlySingleValues() {
        Assert.assertEquals("XYZ", runLengthEncoding.encode("XYZ"));
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithNoSingleValues() {
        Assert.assertEquals(
                "2A3B4C",
                runLengthEncoding.encode("AABBBCCCC"));
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithMixedValues() {
        Assert.assertEquals(
                "12WB12W3B24WB",
                runLengthEncoding.encode(
                        "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"));
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithWhitespaceValues() {
        Assert.assertEquals(
                "2 hs2q q2w2 ",
                runLengthEncoding.encode("  hsqq qww  "));
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeWithLowercaseValues() {
        Assert.assertEquals(
                "2a3b4c",
                runLengthEncoding.encode("aabbbcccc"));
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeEmpty() {
        Assert.assertEquals("", runLengthEncoding.decode(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithOnlySingleValues() {
        Assert.assertEquals(
                "XYZ",
                runLengthEncoding.decode("XYZ"));
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithNoSingleValues() {
        Assert.assertEquals(
                "AABBBCCCC",
                runLengthEncoding.decode("2A3B4C"));
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithMixedValues() {
        Assert.assertEquals(
                "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB",
                runLengthEncoding.decode("12WB12W3B24WB"));
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithWhitespaceValues() {
        Assert.assertEquals(
                "  hsqq qww  ",
                runLengthEncoding.decode("2 hs2q q2w2 "));
    }

    @Ignore("Remove to run test")
    @Test
    public void decodeWithLowercaseValues() {
        Assert.assertEquals(
                "aabbbcccc",
                runLengthEncoding.decode("2a3b4c"));
    }

    @Ignore("Remove to run test")
    @Test
    public void encodeThenDecode() {
        String inOut = "zzz ZZ  zZ";
        String encoded = runLengthEncoding.encode(inOut);
        Assert.assertEquals(inOut, runLengthEncoding.decode(encoded));
    }
}
