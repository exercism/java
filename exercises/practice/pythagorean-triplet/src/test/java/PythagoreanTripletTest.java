
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

public class PythagoreanTripletTest {

    @Test
    public void tripletsWhoseSumIs12() {
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(12)
                        .thatSumTo(12)
                        .build();
        List<PythagoreanTriplet> expected
                = Collections.singletonList(new PythagoreanTriplet(3, 4, 5));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void tripletsWhoseSumIs108() {
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(108)
                        .thatSumTo(108)
                        .build();
        List<PythagoreanTriplet> expected
                = Collections.singletonList(new PythagoreanTriplet(27, 36, 45));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void tripletsWhoseSumIs1000() {
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(1000)
                        .thatSumTo(1000)
                        .build();
        List<PythagoreanTriplet> expected
                = Collections.singletonList(new PythagoreanTriplet(200, 375, 425));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void tripletsWhoseSumIs1001() {
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(1001)
                        .thatSumTo(1001)
                        .build();
        List<PythagoreanTriplet> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void tripletsWhoseSumIs90() {
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(90)
                        .thatSumTo(90)
                        .build();
        List<PythagoreanTriplet> expected
                = Arrays.asList(
                        new PythagoreanTriplet(9, 40, 41),
                        new PythagoreanTriplet(15, 36, 39));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void tripletsWhoseSumIs840() {
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(840)
                        .thatSumTo(840)
                        .build();
        List<PythagoreanTriplet> expected
                = Arrays.asList(
                        new PythagoreanTriplet(40, 399, 401),
                        new PythagoreanTriplet(56, 390, 394),
                        new PythagoreanTriplet(105, 360, 375),
                        new PythagoreanTriplet(120, 350, 370),
                        new PythagoreanTriplet(140, 336, 364),
                        new PythagoreanTriplet(168, 315, 357),
                        new PythagoreanTriplet(210, 280, 350),
                        new PythagoreanTriplet(240, 252, 348));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void tripletsWhoseSumIs30000() {
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(30000)
                        .thatSumTo(30000)
                        .build();
        List<PythagoreanTriplet> expected
                = Arrays.asList(
                        new PythagoreanTriplet(1200, 14375, 14425),
                        new PythagoreanTriplet(1875, 14000, 14125),
                        new PythagoreanTriplet(5000, 12000, 13000),
                        new PythagoreanTriplet(6000, 11250, 12750),
                        new PythagoreanTriplet(7500, 10000, 12500));
        assertEquals(expected, actual);
    }

}
