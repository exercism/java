import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LedgerTest {

    private final static String US_LOCALE = "en-US";
    private final static String NL_LOCALE = "nl-NL";

    private final static String USD_CURRENCY = "USD";
    private final static String EUR_CURRENCY = "EUR";

    private Ledger ledger;

    @Before
    public void setUp() {
        ledger = new Ledger();
    }

    @Test
    public void emptyLedgerUS() {
        var entries = new Ledger.LedgerEntry[]{};

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected = "Date       | Description               | Change       ";
        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void emptyLedgerNL() {
        var entries = new Ledger.LedgerEntry[]{};

        String actual = ledger.format(EUR_CURRENCY, NL_LOCALE, entries);

        String expected = "Datum      | Omschrijving              | Verandering  ";
        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void oneEntry() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-02-01", "Buy present", -1000)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected =
                "Date       | Description               | Change       \n"
                        + "02/01/2015 | Buy present               |       -$10.00";
        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void creditAndDebit() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-02", "Get present", 1000),
                ledger.createLedgerEntry("2015-01-01", "Buy present", -1000)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected =
                """
                        Date       | Description               | Change      \s
                        01/01/2015 | Buy present               |       -$10.00
                        01/02/2015 | Get present               |        $10.00""";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleEntriesOnSameDateOrderedByDescription() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Get present", 1000),
                ledger.createLedgerEntry("2015-01-01", "Buy present", -1000)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected =
                """
                        Date       | Description               | Change      \s
                        01/01/2015 | Buy present               |       -$10.00
                        01/01/2015 | Get present               |        $10.00""";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void finalOrderTieBreakerIsChange() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Something", 0),
                ledger.createLedgerEntry("2015-01-01", "Something", -1),
                ledger.createLedgerEntry("2015-01-01", "Something", 1)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected =
                """
                        Date       | Description               | Change      \s
                        01/01/2015 | Something                 |        -$0.01
                        01/01/2015 | Something                 |         $0.00
                        01/01/2015 | Something                 |         $0.01""";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void overlongDescriptions() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Freude schoner Gotterfunken", -123456)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected =
                "Date       | Description               | Change       \n" +
                        "01/01/2015 | Freude schoner Gotterf... |    -$1,234.56";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void euros() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-01-01", "Buy present", -1000)
        };

        String actual = ledger.format(EUR_CURRENCY, US_LOCALE, entries);

        var expected =
                "Date       | Description               | Change       \n" +
                        "01/01/2015 | Buy present               |       -€10.00";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void dutchLocale() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-03-12", "Buy present", 123456)
        };

        String actual = ledger.format(USD_CURRENCY, NL_LOCALE, entries);

        var expected =
                "Datum      | Omschrijving              | Verandering  \n" +
                        "12/03/2015 | Buy present               |    $ 1.234,56";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void dutchNegativeNumberWith3DigitsBeforeDecimalPoint() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-03-12", "Buy present", -12345)
        };

        String actual = ledger.format(USD_CURRENCY, NL_LOCALE, entries);

        var expected =
                "Datum      | Omschrijving              | Verandering  \n" +
                        "12/03/2015 | Buy present               |     $ -123,45";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void americanNegativeNumberWith3DigitsBeforeDecimalPoint() {
        var entries = new Ledger.LedgerEntry[]{
                ledger.createLedgerEntry("2015-03-12", "Buy present", -12345)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        var expected =
                "Date       | Description               | Change       \n" +
                        "03/12/2015 | Buy present               |      -$123.45";

        Assert.assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void givenInvalidLocale_ThenException() {
        var entries = new Ledger.LedgerEntry[0];
        var locale = "it-IT";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> ledger.format(EUR_CURRENCY, locale, entries));

        assertEquals("Invalid locale", illegalArgumentException.getMessage());
    }

    @Ignore("Remove to run test")
    @Test
    public void givenInvalidCurrency_ThenException() {
        var entries = new Ledger.LedgerEntry[0];
        var currency = "Pieces o' Eight";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> ledger.format(currency, US_LOCALE, entries));

        assertEquals("Invalid currency", illegalArgumentException.getMessage());
    }
}
