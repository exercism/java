import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SeriesTest {

    @Test
    public void slicesOfOneFromOne() {
        Series series = new Series("1");
        List<String> expected = Collections.singletonList("1");
        List<String> actual = series.slices(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void slicesOfOneFromTwo() {
        Series series = new Series("12");
        List<String> expected = Arrays.asList("1", "2");
        List<String> actual = series.slices(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void slicesOfTwo() {
        Series series = new Series("35");
        List<String> expected = Collections.singletonList("35");
        List<String> actual = series.slices(2);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void slicesOfTwoOverlap() {
        Series series = new Series("9142");
        List<String> expected = Arrays.asList("91", "14", "42");
        List<String> actual = series.slices(2);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
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
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
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
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void sliceLengthIsToolarge() {
        Series series = new Series("12345");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> series.slices(6))
                .withMessage("slice length cannot be greater than series length");
    }

    @Disabled("Remove to run test")
    @Test
    public void sliceLengthIsWayToolarge() {
        Series series = new Series("12345");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> series.slices(42))
                .withMessage("slice length cannot be greater than series length");
    }

    @Disabled("Remove to run test")
    @Test
    public void sliceLengthZero() {
        Series series = new Series("12345");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> series.slices(0))
                .withMessage("slice length cannot be negative or zero");
    }

    @Disabled("Remove to run test")
    @Test
    public void sliceLengthNegative() {
        Series series = new Series("123");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> series.slices(-1))
                .withMessage("slice length cannot be negative or zero");
    }

    @Disabled("Remove to run test")
    @Test
    public void emptySeries() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Series(""))
                .withMessage("series cannot be empty");
    }

}
