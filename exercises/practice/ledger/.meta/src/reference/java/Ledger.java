import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ledger {

    private static final int DESCRIPTION_MAX_LENGTH = 25;
    private static final String TRUNCATED_SUFFIX = "...";

    public LedgerEntry createLedgerEntry(String date, String description, int change) {
        var parsedDate = LocalDate.parse(date);
        var parsedChange = change / 100.0f;
        return new LedgerEntry(parsedDate, description, parsedChange);
    }

    public String format(String currency, String locale, LedgerEntry... entries) {
        var currentLocale = getLocale(locale);
        var formattedEntries = formatEntries(currency, currentLocale, entries);
        var header = formatHeader(currentLocale);

        return Stream.of(header, formattedEntries)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    private static Locale getLocale(String locale) {
        return switch (locale) {
            case "en-US" -> Locale.US;
            case "nl-NL" -> new Locale("nl", "NL");
            default -> throw new IllegalArgumentException("Invalid locale");
        };
    }

    private static DecimalFormat getCurrencyFormatter(String currencyCode, Locale locale) {
        var currencySymbol = getCurrencySymbol(currencyCode);
        var currencyByLocale = Currency.getInstance(locale);

        var currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);

        if (!currencyByLocale.getSymbol().equals(currencySymbol)) {
            var decimalFormatSymbols = currencyFormatter.getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol(currencySymbol);

            currencyFormatter.setDecimalFormatSymbols(decimalFormatSymbols);
        }

        return currencyFormatter;

    }

    private static String getCurrencySymbol(String currencyCode) {
        return switch (currencyCode) {
            case "USD" -> "$";
            case "EUR" -> "€";
            default -> throw new IllegalArgumentException("Invalid currency");
        };
    }

    private static String formatEntries(String currency, Locale currentLocale, LedgerEntry... entries) {

        var currencyFormatter = getCurrencyFormatter(currency, currentLocale);

        Comparator<LedgerEntry> ledgerEntryComparator = Comparator.comparing(LedgerEntry::date)
                .thenComparing(LedgerEntry::description)
                .thenComparing(LedgerEntry::change);


        return Arrays.stream(entries)
                .sorted(ledgerEntryComparator)
                .map(ledgerEntry -> formatLedgerEntry(ledgerEntry, currencyFormatter, currentLocale))
                .collect(Collectors.joining("\n"));
    }

    private static String formatLedgerEntry(LedgerEntry ledgerEntry, DecimalFormat currencyFormatter, Locale locale) {
        var formattedDate = getFormattedDate(ledgerEntry.date(), locale);
        var formattedDescription = getFormattedDescription(ledgerEntry.description());
        var formattedChange = currencyFormatter.format(ledgerEntry.change());


        return String.format("%s | %-25s | %13s",
                formattedDate,
                formattedDescription,
                formattedChange);
    }

    private static String getFormattedDate(LocalDate date, Locale locale) {
        var dateFormat = getDateFormat(locale);
        var dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        return date.format(dateFormatter);
    }

    private static String getDateFormat(Locale locale) {
        if (locale.toString().equals("nl_NL")) {
            return "dd/MM/yyyy";
        }

        return "MM/dd/yyyy";
    }

    private static String getFormattedDescription(String description) {
        return (description.length() <= DESCRIPTION_MAX_LENGTH)
                ? description
                : description.substring(0, DESCRIPTION_MAX_LENGTH - TRUNCATED_SUFFIX.length()).concat(TRUNCATED_SUFFIX);
    }

    private static String formatHeader(Locale locale) {
        if (locale.toString().equals("nl_NL")) {
            return "Datum      | Omschrijving              | Verandering  ";
        }

        return "Date       | Description               | Change       ";
    }

    public record LedgerEntry(LocalDate date, String description, float change) {
    }
}