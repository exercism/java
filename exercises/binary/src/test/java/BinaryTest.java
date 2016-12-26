import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinaryTest {

    private String binaryNumberAsString;
    private int decimalNumber;

    @Parameters(name = "{index}: expected {1} when converting \"{0}\" from binary to decimal.")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1", 1},
                {"10", 2},
                {"11", 3},
                {"100", 4},
                {"1001", 9},
                {"11010", 26},
                {"10001101000", 1128},
                {"2", 0},
                {"5", 0},
                {"9", 0},
                {"134678", 0},
                {"abc10z", 0},
                {"011", 3}
        });
    }

    public BinaryTest(String binaryNumberAsString, int decimalNumber) {
        this.binaryNumberAsString = binaryNumberAsString;
        this.decimalNumber = decimalNumber;
    }


    @Test
    public void test() {
        Binary binary = new Binary(binaryNumberAsString);

        assertEquals(decimalNumber, binary.getDecimal());
    }
}
