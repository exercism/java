import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoferTest {

    private Twofer twofer;

    @Before
    public void setup() {
        twofer = new Twofer();
    }

    @Test
    public void noNameGiven() {
        String input = null;
        String expected = "One for you, one for me.";

        assertEquals(expected, twofer.twofer(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void aNameGiven() {
        String input = "Alice";
        String expected = "One for Alice, one for me.";

        assertEquals(expected, twofer.twofer(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void anotherNameGiven() {
        String input = "Bob";
        String expected = "One for Bob, one for me.";

        assertEquals(expected, twofer.twofer(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void emptyStringGiven() {
        String input = "";
        String expected = "One for , one for me.";

        assertEquals(expected, twofer.twofer(input) );
    }
}
