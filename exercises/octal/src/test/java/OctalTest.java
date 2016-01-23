import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OctalTest {

    private String input;
    private int expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1", 1},
                {"10", 8},
                {"17", 15},
                {"11", 9},
                {"130", 88},
                {"2047", 1063},
                {"7777", 4095},
                {"1234567", 342391},
                {"carrot", 0},
                {"8", 0},
                {"9", 0},
                {"6789", 0},
                {"abc1z", 0},
                {"011", 9}
        });
    }

    public OctalTest(String input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void test() {
        Octal octal = new Octal(input);

        assertEquals(expectedOutput, octal.getDecimal());
    }
}
