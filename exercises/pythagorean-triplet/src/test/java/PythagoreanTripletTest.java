
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
        PythagoreanTriplet sut = new PythagoreanTriplet(3, 4, 5);
        final int expected = 12;
        final int actual = sut.calculateSum();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldCalculateProduct() {
        PythagoreanTriplet sut = new PythagoreanTriplet(3, 4, 5);
        final long expected = 60l;
        final long actual = sut.calculateProduct();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void testIsPythagoreanOK() {
        PythagoreanTriplet sut = new PythagoreanTriplet(3, 4, 5);
        assertTrue(sut.isPythagorean());
    }

    @Test
    @Ignore
    public void testIsPythagoreanFail() {
        PythagoreanTriplet sut = new PythagoreanTriplet(5, 6, 7);
        assertFalse(sut.isPythagorean());
    }

    @Test
    @Ignore
    public void shouldMakeTripletsUpToTen() {
        final Map<String, Integer> searchData
                = new HashMap<>();
        searchData.put(PythagoreanTriplet.MAX_FACTOR, 10);
        final List<Long> actual
                = PythagoreanTriplet.createTripletsList(searchData)
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted((p1, p2) -> Double.compare(p1, p2))
                        .collect(Collectors.toList());
        final List<Long> expected = Arrays.asList(60l, 480l);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldMakeTripletsElevenToTwenty() {
        final Map<String, Integer> searchData
                = new HashMap<>();
        searchData.put(PythagoreanTriplet.MAX_FACTOR, 20);
        searchData.put(PythagoreanTriplet.MIN_FACTOR, 11);
        final List<Long> actual
                = PythagoreanTriplet.createTripletsList(searchData)
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted((p1, p2) -> Double.compare(p1, p2))
                        .collect(Collectors.toList());
        final List<Long> expected = Arrays.asList(3840l);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void shouldMakeTripletsAndFilterOnSum() {
        final Map<String, Integer> searchData
                = new HashMap<>();
        searchData.put(PythagoreanTriplet.MAX_FACTOR, 100);
        searchData.put(PythagoreanTriplet.SUM, 180);
        final List<Long> actual
                = PythagoreanTriplet.createTripletsList(searchData)
                        .stream()
                        .map(t -> t.calculateProduct())
                        .sorted((p1, p2) -> Double.compare(p1, p2))
                        .collect(Collectors.toList());
        final List<Long> expected = Arrays.asList(118080l, 168480l, 202500l);
        assertEquals(expected, actual);
    }
}
