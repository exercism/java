import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DartsTest {

    @Test
    public void testDartOutsideTarget() {
        Darts darts = new Darts(15.3, 13.2);
        assertEquals(0, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsOnBorderOfTarget() {
        Darts darts = new Darts(10, 0);
        assertEquals(1, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsOnMiddleOfCircle() {
        Darts darts = new Darts(3, 3.7);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsOnBorderBetweenOutsideAndMiddleCircles() {
        Darts darts = new Darts(0, 5);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsInTheInnerCircle() {
        Darts darts = new Darts(0, 0);
        assertEquals(10, darts.score());
    }

}
