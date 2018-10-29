
import java.util.Arrays;
import java.util.List;
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
        int expected = 12;
        int actual = triplet.calculateSum();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void shouldCalculateProduct() {
        PythagoreanTriplet triplet = new PythagoreanTriplet(3, 4, 5);
        long expected = 60L;
        long actual = triplet.calculateProduct();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testIsPythagoreanOK() {
        PythagoreanTriplet triplet = new PythagoreanTriplet(3, 4, 5);
        assertTrue(triplet.isPythagorean());
    }

    @Ignore("Remove to run test")
    @Test
    public void testIsPythagoreanFail() {
        PythagoreanTriplet triplet = new PythagoreanTriplet(5, 6, 7);
        assertFalse(triplet.isPythagorean());
    }

    @Ignore("Remove to run test")
    @Test
    public void shouldMakeTripletsUpToTen() {
        List<Long> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(10)
                        .build()
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted()
                        .collect(Collectors.toList());
        List<Long> expected = Arrays.asList(60L, 480L);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void shouldMakeTripletsElevenToTwenty() {
        List<Long> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsGreaterThanOrEqualTo(11)
                        .withFactorsLessThanOrEqualTo(20)
                        .build()
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted((p1, p2) -> Double.compare(p1, p2))
                        .collect(Collectors.toList());
        List<Long> expected = Arrays.asList(3840L);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void shouldMakeTripletsAndFilterOnSum() {
        List<Long> actual
                = PythagoreanTriplet
                        .makeTripletsList()
                        .withFactorsLessThanOrEqualTo(100)
                        .thatSumTo(180)
                        .build()
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted((p1, p2) -> Double.compare(p1, p2))
                        .collect(Collectors.toList());
        List<Long> expected = Arrays.asList(118080L, 168480L, 202500L);
        assertEquals(expected, actual);
    }
}
