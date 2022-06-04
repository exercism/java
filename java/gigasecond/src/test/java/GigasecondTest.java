import org.junit.Test;
import org.junit.Ignore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class GigasecondTest {

    @Test
    public void modernTime() {
        Gigasecond gigaSecond = new Gigasecond(LocalDate.of(2011, Month.APRIL, 25));

        assertEquals(LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40), gigaSecond.getDateTime());
    }

    @Test
    public void afterEpochTime() {
        Gigasecond gigaSecond = new Gigasecond(LocalDate.of(1977, Month.JUNE, 13));

        assertEquals(LocalDateTime.of(2009, Month.FEBRUARY, 19, 1, 46, 40), gigaSecond.getDateTime());
    }

    @Test
    public void beforeEpochTime() {
        Gigasecond gigaSecond = new Gigasecond(LocalDate.of(1959, Month.JULY, 19));

        assertEquals(LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40), gigaSecond.getDateTime());
    }

    @Test
    public void withFullTimeSpecified() {
        Gigasecond gigaSecond = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0));

        assertEquals(LocalDateTime.of(2046, Month.OCTOBER, 2, 23, 46, 40), gigaSecond.getDateTime());
    }

    @Test
    public void withFullTimeSpecifiedAndDayRollover() {
        Gigasecond gigaSecond = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59));

        assertEquals(LocalDateTime.of(2046, Month.OCTOBER, 3, 1, 46, 39), gigaSecond.getDateTime());
    }
}
