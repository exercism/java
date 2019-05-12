import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DartsTest {

    @Test
    public void testDartOutsideTarget() {
        Darts darts = new Darts(-9, 9);
        assertEquals(0, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsOnBorderOfTarget() {
        Darts darts = new Darts(0, 10);
        assertEquals(1, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsInOuterCircle() {
        Darts darts = new Darts(4, 4);
        assertEquals(1, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsInBorderBetweenOuterAndMiddleCircles() {
        Darts darts = new Darts(5, 0);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsOnMiddleOfCircle() {
        Darts darts = new Darts(0.8, -0.8);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsOnBorderBetweenMiddleAndInnerCircles() {
        Darts darts = new Darts(0, -1);
        assertEquals(10, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDartLandsInTheInnerCircle() {
        Darts darts = new Darts(-0.1, -0.1);
        assertEquals(10, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCoordinatesSumLargerOneWithRadiusToOriginSmallerOrEqualOneScoredInnerCircle() {
        Darts darts = new Darts(0.4, 0.8);
        assertEquals(10, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCoordinatesSumLargerFiveWithRadiusToOriginSmallerOrEqualFiveScoredMiddleCircle() {
        Darts darts = new Darts(2, 4);
        assertEquals(5, darts.score());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCoordinatesSumLargerTenWithRadiusToOriginSmallerOrEqualTenScoredOuterCircle() {
        Darts darts = new Darts(4, 8);
        assertEquals(1, darts.score());
    }

}
