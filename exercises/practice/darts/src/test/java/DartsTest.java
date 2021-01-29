import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DartsTest {

    @Test
    public void missedTarget() {
        Darts darts = new Darts(-9, 9);
        assertEquals(0, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void onTheOuterCircle() {
        Darts darts = new Darts(0, 10);
        assertEquals(1, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void onTheMiddleCircle() {
        Darts darts = new Darts(-5, 0);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void onTheInnerCircle() {
        Darts darts = new Darts(0, -1);
        assertEquals(10, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void exactlyOnCentre() {
        Darts darts = new Darts(0, 0);
        assertEquals(10, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void nearTheCentre() {
        Darts darts = new Darts(-0.1, -0.1);
        assertEquals(10, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void justWithinTheInnerCircle() {
        Darts darts = new Darts(0.7, 0.7);
        assertEquals(10, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void justOutsideTheInnerCircle() {
        Darts darts = new Darts(0.8, -0.8);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void justWithinTheMiddleCirlce() {
        Darts darts = new Darts(-3.5, 3.5);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void justOutsideTheMiddleCircle() {
        Darts darts = new Darts(-3.6, -3.6);
        assertEquals(1, darts.score());
    }


    @Ignore("Remove to run test")
    @Test
    public void justWithinTheOuterCirlce() {
        Darts darts = new Darts(-7.0, 7.0);
        assertEquals(1, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void justOutsideTheOuterCircle() {
        Darts darts = new Darts(7.1, -7.1);
        assertEquals(0, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void asymmetricPositionBetweenTheInnerAndMiddleCircles() {
        Darts darts = new Darts(0.5, -4);
        assertEquals(5, darts.score());
    }

}
