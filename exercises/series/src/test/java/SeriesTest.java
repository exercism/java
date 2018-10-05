import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class SeriesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void slicesOfOneFromOne() {
        Series series = new Series("1");
        List<List<String>> expected = Arrays.asList(Arrays.asList("1"));
        List<List<String>> actual = series.slices(1);
        assertEquals(expected, actual);
    }
    
    @Ignore("Remove to run test")
    @Test
    public void slicesOfOneFromTwo() {
        Series series = new Series("12");
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("1"), 
                Arrays.asList("2")
        );
        List<List<String>> actual = series.slices(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesOfTwo() {
        Series series = new Series("35");
        List<List<String>> expected = Arrays.asList(Arrays.asList("3", "5"));
        List<List<String>> actual = series.slices(2);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesOfTwoOverlap() {
        Series series = new Series("9142");
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("9", "1"), 
                Arrays.asList("1", "4"), 
                Arrays.asList("4", "2")
        );
        List<List<String>> actual = series.slices(2);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesIncludeDuplicates() {
        Series series = new Series("777777");
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("7", "7", "7"), 
                Arrays.asList("7", "7", "7"),
                Arrays.asList("7", "7", "7"), 
                Arrays.asList("7", "7", "7")
        );
		List<List<String>> actual = series.slices(3);
		assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesOfLongSeries() {
        Series series = new Series("918493904243");
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("9", "1", "8", "4", "9"),
                Arrays.asList("1", "8", "4", "9", "3"),
                Arrays.asList("8", "4", "9", "3", "9"),
                Arrays.asList("4", "9", "3", "9", "0"),
                Arrays.asList("9", "3", "9", "0", "4"),
                Arrays.asList("3", "9", "0", "4", "2"),
                Arrays.asList("9", "0", "4", "2", "4"),
                Arrays.asList("0", "4", "2", "4", "3")
        );
        List<List<String>> actual = series.slices(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sliceLengthIsToolarge() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Slice size is too big.");
        
        Series series = new Series("12345");
        series.slices(6);
    }

    @Ignore("Remove to run test")
    @Test
    public void sliceLengthZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Slice size is too small.");
        Series series = new Series("12345");
        series.slices(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void sliceLengthNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Slice size is too small.");
        Series series = new Series("123");
        series.slices(-1);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySeries() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Slice size is too big.");
        Series series = new Series("");
        List<List<String>> slices = series.slices(1);
    }

}
