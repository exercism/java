import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class LedgerTest {

    private static final String US_LOCALE = "en-US";
    private static final String NL_LOCALE = "nl-NL";

    private static final String USD_CURRENCY = "USD";
    private static final String EUR_CURRENCY = "EUR";

    private Ledger ledger;

    @Before
    public void setUp() throws Exception {
        ledger = new Ledger();
    }

    @Ignore("Remove to run test")
    @Test
    public void emptyLedgerUS() {
        // given
        var entries = new Ledger.LedgerEntry[]{};

        // when
        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        // then
        String expected = "Date       | Description               | Change       ";
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptyLedgerNL() {
        // given
        var entries = new Ledger.LedgerEntry[]{};

        // when
        String actual = ledger.format(EUR_CURRENCY, NL_LOCALE, entries);

        // then
        String expected = "Datum      | Omschrijving              | Verandering  ";
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneEntry() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-02-01", "Buy present", -10.00)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        // then
        String expected = "Date       | Description               | Change       \n"
                + "02/01/2015 | Buy present               |       -$10.00";
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void creditAndDebit() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-02", "Get present", 10.00),
                ledger.createLedgerEntry("2015-01-01", "Buy present", -10.00)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        // then
        String expected = "Date       | Description               | Change       \n" +
                "01/01/2015 | Buy present               |       -$10.00\n" +
                "01/02/2015 | Get present               |        $10.00";

        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleEntriesOnSameDateOrderedByDescription() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Get present", 10.00),
                ledger.createLedgerEntry("2015-01-01", "Buy present", -10.00)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        // then
        String expected = "Date       | Description               | Change       \n" +
                "01/01/2015 | Buy present               |       -$10.00\n" +
                "01/01/2015 | Get present               |        $10.00";

        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void finalOrderTieBreakerIsChange() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Something", 0),
                ledger.createLedgerEntry("2015-01-01", "Something", -0.01),
                ledger.createLedgerEntry("2015-01-01", "Something", 0.01)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        // then
        String expected = "Date       | Description               | Change       \n" +
                "01/01/2015 | Something                 |        -$0.01\n" +
                "01/01/2015 | Something                 |         $0.00\n" +
                "01/01/2015 | Something                 |         $0.01";
        ;
        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void overlongDescriptions() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Freude schoner Gotterfunken", -1234.56)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        // then
        String expected = "Date       | Description               | Change       \n" +
                "01/01/2015 | Freude schoner Gotterf... |    -$1,234.56";

        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void euros() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Buy present", -10.00)
        };

        // when
        String actual = ledger.format(EUR_CURRENCY, US_LOCALE, entries);

        // then
        var expected = "Date       | Description               | Change       \n" +
                "01/01/2015 | Buy present               |       -€10.00";

        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void dutchLocale() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-03-12", "Buy present", 1234.56)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, NL_LOCALE, entries);

        // then
        var expected = "Datum      | Omschrijving              | Verandering  \n" +
                "12/03/2015 | Buy present               |     $1.234,56";

        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void dutchNegativeNumberWith3DigitsBeforeDecimalPoint() {
        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-03-12", "Buy present", -123.45)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, NL_LOCALE, entries);

        // then
        var expected = "Datum      | Omschrijving              | Verandering  \n" +
                "12/03/2015 | Buy present               |      -$123,45";

        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void americanNegativeNumberWith3DigitsBeforeDecimalPoint() {

        // given
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-03-12", "Buy present", -123.45)
        };

        // when
        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        // then
        var expected = "Date       | Description               | Change       \n" +
                "03/12/2015 | Buy present               |      -$123.45";

        assertThat(actual).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void givenInvalidLocale_ThenException() {
        // given
        var entries = new Ledger.LedgerEntry[0];
        var locale = "it-IT";

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ledger.format(EUR_CURRENCY, locale, entries))
                .withMessage("Invalid locale");

    }

    @Ignore("Remove to run test")
    @Test
    public void givenInvalidCurrency_ThenException() {
        // given
        var entries = new Ledger.LedgerEntry[0];
        var currency = "Pieces o' Eight";

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ledger.format(currency, US_LOCALE, entries))
                .withMessage("Invalid currency");
    }
}
