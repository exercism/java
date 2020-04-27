import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class ResistorColorTrioTest {
    private ResistorColorTrio resistorColorTrio = new ResistorColorTrio();

    @Test
    public void testOrangeOrangeBlack() {
        String[] input = { "orange", "orange", "black" };
        String expected = "33 ohms";
        String actual = resistorColorTrio.value(input);

        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void testBlueGreyBrown() {
        String[] input = { "blue", "grey", "brown" };
        String expected = "680 ohms";
        String actual = resistorColorTrio.value(input);

        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void testRedBlackRed() {
        String[] input = { "red", "black", "red" };
        String expected = "2 kiloohms";
        String actual = resistorColorTrio.value(input);

        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void testGreenBrownOrange() {
        String[] input = { "green", "brown", "orange" };
        String expected = "51 kiloohms";
        String actual = resistorColorTrio.value(input);

        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void testYellowVioletYellow() {
        String[] input = { "yellow", "violet", "yellow" };
        String expected = "470 kiloohms";
        String actual = resistorColorTrio.value(input);

        assertEquals(expected, actual);
    }
}
