import org.junit.Test;
import org.junit.Ignore;
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
        private String plaintext;
        private String ciphertext;

        @Parameters(name = "{index}: expected plaintext \"{0}\" to encode to ciphertext \"{1}\".")
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

        public EncodeTest(String plaintext, String ciphertext) {
            this.plaintext = plaintext;
            this.ciphertext = ciphertext;
        }


    @Test
        public void test() {
            assertEquals(ciphertext, Atbash.encode(plaintext));
        }
    }

    @RunWith(Parameterized.class)
    public static class DecodeTest {
        private String ciphertext;
        private String plaintext;

        @Parameters(name = "{index}: expected ciphertext \"{0}\" to decode to plaintext \"{1}\".")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "vcvix rhn", "exercism" },
                    { "zmlyh gzxov rhlug vmzhg vkkrm thglm v", "anobstacleisoftenasteppingstone" },
                    { "gvhgr mt123 gvhgr mt", "testing123testing" }
            });
        }

        public DecodeTest(String ciphertext, String plaintext) {
            this.ciphertext = ciphertext;
            this.plaintext = plaintext;
        }

        @Ignore
    @Test
        public void test() {
            assertEquals(plaintext, Atbash.decode(ciphertext));
        }
    }
}
