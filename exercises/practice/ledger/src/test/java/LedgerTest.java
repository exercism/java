import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(LocaleExtension.class)
public class LedgerTest {

    private static final String US_LOCALE = "en-US";
    private static final String NL_LOCALE = "nl-NL";

    private static final String USD_CURRENCY = "USD";
    private static final String EUR_CURRENCY = "EUR";

    private Ledger ledger;

    @BeforeEach
    public void setUp() throws Exception {
        ledger = new Ledger();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty ledger")
    public void emptyLedgerUS() {
        var entries = new Ledger.LedgerEntry[] {};

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected = "Date       | Description               | Change       ";
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("one entry")
    public void oneEntry() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-01-01", "Buy present", -1000)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected = "Date       | Description               | Change       \n"
                        + "01/01/2015 | Buy present               |      ($10.00)";
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("credit and debit")
    public void creditAndDebit() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-01-02", "Get present", 1000),
                        ledger.createLedgerEntry("2015-01-01", "Buy present", -1000)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected = "Date       | Description               | Change       \n"
                        + "01/01/2015 | Buy present               |      ($10.00)\n"
                        + "01/02/2015 | Get present               |       $10.00 ";

        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple entries on same date ordered by description")
    public void multipleEntriesOnSameDateOrderedByDescription() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-01-01", "Get present", 1000),
                        ledger.createLedgerEntry("2015-01-01", "Buy present", -1000)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected = "Date       | Description               | Change       \n"
                        + "01/01/2015 | Buy present               |      ($10.00)\n"
                        + "01/01/2015 | Get present               |       $10.00 ";

        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("final order tie breaker is change")
    public void finalOrderTieBreakerIsChange() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-01-01", "Something", 0),
                        ledger.createLedgerEntry("2015-01-01", "Something", -1),
                        ledger.createLedgerEntry("2015-01-01", "Something", 1)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected = "Date       | Description               | Change       \n"
                        + "01/01/2015 | Something                 |       ($0.01)\n"
                        + "01/01/2015 | Something                 |        $0.00 \n"
                        + "01/01/2015 | Something                 |        $0.01 ";
        
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("overlong description is truncated")
    public void overlongDescriptions() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-01-01", "Freude schoner Gotterfunken", -123456)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        String expected = "Date       | Description               | Change       \n"
                        + "01/01/2015 | Freude schoner Gotterf... |   ($1,234.56)";

        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("euros")
    public void euros() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-01-01", "Buy present", -1000)
        };

        String actual = ledger.format(EUR_CURRENCY, US_LOCALE, entries);

        var expected = "Date       | Description               | Change       \n"
                     + "01/01/2015 | Buy present               |      (€10.00)";

        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Dutch locale")
    public void dutchLocale() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-03-12", "Buy present", 123456)
        };

        String actual = ledger.format(USD_CURRENCY, NL_LOCALE, entries);

        var expected = "Datum      | Omschrijving              | Verandering  \n"
                     + "12/03/2015 | Buy present               |   $ 1.234,56 ";

        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Dutch locale and euros")
    public void dutchLocaleAndEuros() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-03-12", "Buy present", 123456)
        };

        String actual = ledger.format(EUR_CURRENCY, NL_LOCALE, entries);

        var expected = "Datum      | Omschrijving              | Verandering  \n"
                     + "12/03/2015 | Buy present               |   € 1.234,56 ";

        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Dutch negative number with 3 digits before decimal point")
    public void dutchNegativeNumberWith3DigitsBeforeDecimalPoint() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-03-12", "Buy present", -12345)
        };

        String actual = ledger.format(USD_CURRENCY, NL_LOCALE, entries);

        var expected = "Datum      | Omschrijving              | Verandering  \n"
                     + "12/03/2015 | Buy present               |    $ -123,45 ";

        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("American negative number with 3 digits before decimal point")
    public void americanNegativeNumberWith3DigitsBeforeDecimalPoint() {
        var entries = new Ledger.LedgerEntry[] {
                        ledger.createLedgerEntry("2015-03-12", "Buy present", -12345)
        };

        String actual = ledger.format(USD_CURRENCY, US_LOCALE, entries);

        var expected = "Date       | Description               | Change       \n"
                     + "03/12/2015 | Buy present               |     ($123.45)";

        assertThat(actual).isEqualTo(expected);
    }
}
