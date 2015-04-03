import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeFactorsTest {

    private double input;
    private List<Integer> expectedOutput;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, Arrays.asList(new Integer[0])},
                {2, Arrays.asList(new Integer[]{2})},
                {3, Arrays.asList(new Integer[]{3})},
                {4, Arrays.asList(new Integer[]{2, 2})},
                {6, Arrays.asList(new Integer[]{2, 3})},
                {8, Arrays.asList(new Integer[]{2, 2, 2})},
                {9, Arrays.asList(new Integer[]{3, 3})},
                {27, Arrays.asList(new Integer[]{3, 3, 3})},
                {625, Arrays.asList(new Integer[]{5, 5, 5, 5})},
                {901255, Arrays.asList(new Integer[]{5, 17, 23, 461})},
                {93819012551L, Arrays.asList(new Integer[]{11, 9539, 894119})}
        });
    }

    public PrimeFactorsTest(double input, List<Integer> expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void test() {
        assertEquals(expectedOutput, PrimeFactors.getForNumber(input));
    }
}
