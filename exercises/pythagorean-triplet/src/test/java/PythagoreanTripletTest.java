
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Ignore;

public class PythagoreanTripletTest {

    @Test
    public void shouldCalculateSum() {
        PythagoreanTriplet triplet = new PythagoreanTriplet(3, 4, 5);
        final int expected = 12;
        final int actual = triplet.calculateSum();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void shouldCalculateProduct() {
        PythagoreanTriplet triplet = new PythagoreanTriplet(3, 4, 5);
        final long expected = 60l;
        final long actual = triplet.calculateProduct();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void testIsPythagoreanOK() {
        PythagoreanTriplet triplet = new PythagoreanTriplet(3, 4, 5);
        assertTrue(triplet.isPythagorean());
    }

    @Test
    @Ignore("Remove to run test")
    public void testIsPythagoreanFail() {
        PythagoreanTriplet triplet = new PythagoreanTriplet(5, 6, 7);
        assertFalse(triplet.isPythagorean());
    }

    @Test
    @Ignore("Remove to run test")
    public void shouldMakeTripletsUpToTen() {
        final List<Long> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(10)
                        .build()
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted()
                        .collect(Collectors.toList());
        final List<Long> expected = Arrays.asList(60l, 480l);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void shouldMakeTripletsElevenToTwenty() {
        final List<Long> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsGreaterThanOrEqualTo(11)
                        .withFactorsLessThanOrEqualTo(20)
                        .build()
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted((p1, p2) -> Double.compare(p1, p2))
                        .collect(Collectors.toList());
        final List<Long> expected = Arrays.asList(3840l);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void shouldMakeTripletsAndFilterOnSum() {
        final List<Long> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(100)
                        .thatSumTo(180)
                        .build()
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted((p1, p2) -> Double.compare(p1, p2))
                        .collect(Collectors.toList());
        final List<Long> expected = Arrays.asList(118080l, 168480l, 202500l);
        assertEquals(expected, actual);
    }
}
