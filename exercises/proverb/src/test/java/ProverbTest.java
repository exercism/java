import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProverbTest {

    @Test
    public void testSingleConsequence() {
        String proverb  = new Proverb("nail", "shoe").getProverb(),
               expected = "For want of a nail the shoe was lost.\n" +
                          "And all for the want of a nail.";

        assertThat(proverb, is(expected));
    }

    @Ignore("Remove to run test")
    @Test
    public void testShortChainOfConsequences() {
        String proverb  = new Proverb("nail", "shoe", "horse").getProverb(),
               expected = "For want of a nail the shoe was lost.\n" +
                          "For want of a shoe the horse was lost.\n" +
                          "And all for the want of a nail.";

        assertThat(proverb, is(expected));
    }
}
