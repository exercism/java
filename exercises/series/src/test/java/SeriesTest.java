
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;

public class SeriesTest {

    @Test
    public void hasDigitsShort() {
        Series sut = new Series("01234");
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> actual = sut.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void hasDigitsLong() {
        Series sut = new Series("0123456789");
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> actual = sut.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void keepsTheDigitOrderIfReversed() {
        Series sut = new Series("9876543210");
        List<Integer> expected = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        List<Integer> actual = sut.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void keepsArbitraryDigitOrder() {
        Series sut = new Series("936923468");
        List<Integer> expected = Arrays.asList(9, 3, 6, 9, 2, 3, 4, 6, 8);
        List<Integer> actual = sut.getDigits();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void canSliceByOne() {
        Series sut = new Series("01234");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4)
        );
        List<List<Integer>> actual = sut.slices(1);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void canSliceByTwo() {
        Series sut = new Series("98273463");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(9, 8),
                Arrays.asList(8, 2),
                Arrays.asList(2, 7),
                Arrays.asList(7, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 6),
                Arrays.asList(6, 3)
        );
        List<List<Integer>> actual = sut.slices(2);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void canSliceByThree() {
        Series sut = new Series("01234");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 3, 4)
        );
        List<List<Integer>> actual = sut.slices(3);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void canSliceByThreeWithDuplicateDigits() {
        Series sut = new Series("31001");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3, 1, 0),
                Arrays.asList(1, 0, 0),
                Arrays.asList(0, 0, 1)
        );
        List<List<Integer>> actual = sut.slices(3);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void canSliceByFour() {
        Series sut = new Series("91274");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(9, 1, 2, 7),
                Arrays.asList(1, 2, 7, 4)
        );
        List<List<Integer>> actual = sut.slices(4);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void canSliceByFive() {
        Series sut = new Series("81228");
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(8, 1, 2, 2, 8)
        );
        List<List<Integer>> actual = sut.slices(5);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void throwsAnErrorIfNotEnoughDigitsToSlice() {
        new Series("01032987583").slices(12);
    }
}
