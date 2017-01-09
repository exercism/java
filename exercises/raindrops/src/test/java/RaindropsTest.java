import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RaindropsTest {

    private int inputNumber;
    private String outputFromRaindropConversion;

    @Parameters(name = "{index}: expected input number {0} to be converted to \"{1}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Non-primes
                {1, "1"},
                {52, "52"},
                {12121, "12121"},

                // Numbers with 3 as a prime factor
                {3, "Pling"},
                {6, "Pling"},
                {9, "Pling"},

                // Numbers with 5 as a prime factor
                {5, "Plang"},
                {10, "Plang"},
                {25, "Plang"},

                // Numbers with 7 as a prime factor
                {7, "Plong"},
                {14, "Plong"},
                {49, "Plong"},

                // Numbers with multiple activating prime factors
                {15, "PlingPlang"},
                {21, "PlingPlong"},
                {35, "PlangPlong"},
                {105, "PlingPlangPlong"},
        });
    }

    public RaindropsTest(int inputNumber, String outputFromRaindropConversion) {
        this.inputNumber = inputNumber;
        this.outputFromRaindropConversion = outputFromRaindropConversion;
    }


    @Test
    public void test() {
        assertEquals(outputFromRaindropConversion, Raindrops.convert(inputNumber));
    }
}
