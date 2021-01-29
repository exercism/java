import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.Ignore;

public class SeriesTest {

    @Test
    public void slicesOfOneFromOne() {
        Series series = new Series("1");
        List<String> expected = Collections.singletonList("1");
        List<String> actual = series.slices(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesOfOneFromTwo() {
        Series series = new Series("12");
        List<String> expected = Arrays.asList("1", "2");
        List<String> actual = series.slices(1);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesOfTwo() {
        Series series = new Series("35");
        List<String> expected = Collections.singletonList("35");
        List<String> actual = series.slices(2);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesOfTwoOverlap() {
        Series series = new Series("9142");
        List<String> expected = Arrays.asList("91", "14", "42");
        List<String> actual = series.slices(2);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesIncludeDuplicates() {
        Series series = new Series("777777");
        List<String> expected = Arrays.asList(
                "777",
                "777",
                "777",
                "777"
        );
        List<String> actual = series.slices(3);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void slicesOfLongSeries() {
        Series series = new Series("918493904243");
        List<String> expected = Arrays.asList(
                "91849",
                "18493",
                "84939",
                "49390",
                "93904",
                "39042",
                "90424",
                "04243"
        );
        List<String> actual = series.slices(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sliceLengthIsToolarge() {
        Series series = new Series("12345");

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> series.slices(6));

        assertThat(expected)
            .hasMessage("Slice size is too big.");
    }

    @Ignore("Remove to run test")
    @Test
    public void sliceLengthZero() {
        Series series = new Series("12345");

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> series.slices(0));

        assertThat(expected)
            .hasMessage("Slice size is too small.");
    }

    @Ignore("Remove to run test")
    @Test
    public void sliceLengthNegative() {
        Series series = new Series("123");

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> series.slices(-1));

        assertThat(expected)
            .hasMessage("Slice size is too small.");
    }

    @Ignore("Remove to run test")
    @Test
    public void emptySeries() {
        Series series = new Series("");

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> series.slices(1));

        assertThat(expected)
            .hasMessage("Slice size is too big.");
    }

}
