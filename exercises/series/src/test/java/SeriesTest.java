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
    public void hasDigitsShort() {
        Series series = new Series("01234");
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> actual = series.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void hasDigitsLong() {
        Series series = new Series("0123456789");
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> actual = series.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void keepsTheDigitOrderIfReversed() {
        Series series = new Series("9876543210");
        List<Integer> expected = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        List<Integer> actual = series.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void keepsArbitraryDigitOrder() {
        Series series = new Series("936923468");
        List<Integer> expected = Arrays.asList(9, 3, 6, 9, 2, 3, 4, 6, 8);
        List<Integer> actual = series.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void canSliceByOne() {
        Series series = new Series("01234");
        List<List<Integer>> expected = Arrays.asList(
		 Collections.singletonList(0),
                Collections.singletonList(1),
                Collections.singletonList(2),
                Collections.singletonList(3),
                Collections.singletonList(4)
        );
        List<List<Integer>> actual = series.slices(1);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void canSliceByTwo() {
        Series series = new Series("98273463");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(9, 8),
                Arrays.asList(8, 2),
                Arrays.asList(2, 7),
                Arrays.asList(7, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 6),
                Arrays.asList(6, 3)
        );
        List<List<Integer>> actual = series.slices(2);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void canSliceByThree() {
        Series series = new Series("01234");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 3, 4)
        );
        List<List<Integer>> actual = series.slices(3);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void canSliceByThreeWithDuplicateDigits() {
        Series series = new Series("31001");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3, 1, 0),
                Arrays.asList(1, 0, 0),
                Arrays.asList(0, 0, 1)
        );
        List<List<Integer>> actual = series.slices(3);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void canSliceByFour() {
        Series series = new Series("91274");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(9, 1, 2, 7),
                Arrays.asList(1, 2, 7, 4)
        );
        List<List<Integer>> actual = series.slices(4);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void canSliceByFive() {
        Series series = new Series("81228");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(8, 1, 2, 2, 8)
        );
        List<List<Integer>> actual = series.slices(5);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void throwsAnErrorIfNotEnoughDigitsToSlice() {
        expectedException.expect(IllegalArgumentException.class);
        new Series("01032987583").slices(12);
    }
}
