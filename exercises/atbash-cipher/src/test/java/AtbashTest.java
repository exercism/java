import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class AtbashTest {

    @RunWith(Parameterized.class)
    public static class EncodeTest {
        private String input;
        private String expectedOutput;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "no", "ml" },
                    { "yes", "bvh" },
                    { "OMG", "lnt" },
                    { "mindblowingly", "nrmwy oldrm tob" },
                    { "Testing, 1 2 3, testing.", "gvhgr mt123 gvhgr mt" },
                    { "Truth is fiction.", "gifgs rhurx grlm" },
                    { "The quick brown fox jumps over the lazy dog.", "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt" }
            });
        }

        public EncodeTest(String input, String expectedOutput) {
            this.input = input;
            this.expectedOutput = expectedOutput;
        }

        @Test
        public void test() {
            assertEquals(expectedOutput, Atbash.encode(input));
        }
    }

    @RunWith(Parameterized.class)
    public static class DecodeTest {
        private String input;
        private String expectedOutput;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "vcvix rhn", "exercism" },
                    { "zmlyh gzxov rhlug vmzhg vkkrm thglm v", "anobstacleisoftenasteppingstone" },
                    { "gvhgr mt123 gvhgr mt", "testing123testing" }
            });
        }

        public DecodeTest(String input, String expectedOutput) {
            this.input = input;
            this.expectedOutput = expectedOutput;
        }

        @Test
        public void test() {
            assertEquals(expectedOutput, Atbash.decode(input));
        }
    }
}
