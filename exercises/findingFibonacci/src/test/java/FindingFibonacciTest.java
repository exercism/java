import org.junit.Test;
import org.junit.Ignore;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindingFibonacciTest {
    @Ignore("Remove to run test")
    @Test
    public void getResults() {
        int[] input = { 1, 3, 5, 7, 9 , 13, 17, 20, 35};
        int[] expectedOutput = {1, 2, 5, 13, 34, 233, 1597, 6765, 9227465};
        assertEquals(expectedOutput, FindingFibonacci.getResults(input));
    }
}