import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AtbashTest {

    private String input;
    private String expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"no", "ml"},
                {"yes", "bvh"},
                {"OMG", "lnt"},
                {"mindblowingly", "nrmwy oldrm tob"},
                {"Testing, 1 2 3, testing.", "gvhgr mt123 gvhgr mt"},
                {"Truth is fiction.", "gifgs rhurx grlm"},
                {"The quick brown fox jumps over the lazy dog.", "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"}
        });
    }

    public AtbashTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void test() {
        assertEquals(expectedOutput, Atbash.encode(input));
    }
}
