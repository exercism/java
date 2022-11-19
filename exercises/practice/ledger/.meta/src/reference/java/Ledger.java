import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ledger {

    private static final int DESCRIPTION_MAX_LENGTH = 25;
    private static final String TRUNCATED_SUFFIX = "...";

    private String header;
    private String currencySymbol;
    private String thousandsSeparator;
    private String decimalSeparator;
    private String datePattern;

    public LedgerEntry createLedgerEntry(String date, String description, double change) {
        return new LedgerEntry(LocalDate.parse(date), description, change);
    }

    public String format(String currency, String locale, LedgerEntry... entries) {
        setFormats(currency, locale);
        var formattedEntries = formatEntries(entries);

        return Stream.of(this.header, formattedEntries)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("\n"));
    }


    private void setFormats(String currency, String locale) {
        setCurrencySymbolByCurrencyCode(currency);
        setFormatsByLocale(locale);
    }

    private void setCurrencySymbolByCurrencyCode(String currencyCode) {
        this.currencySymbol = switch (currencyCode) {
            case "USD" -> "$";
            case "EUR" -> "€";
            default -> throw new IllegalArgumentException("Invalid currency");
        };
    }

    private void setFormatsByLocale(String locale) {
        if (locale.equals("en-US")) {
            this.datePattern = "MM/dd/yyyy";
            this.thousandsSeparator = ",";
            this.decimalSeparator = ".";
            this.header = "Date       | Description               | Change       ";
        } else if (locale.equals("nl-NL")) {
            this.datePattern = "dd/MM/yyyy";
            this.thousandsSeparator = ".";
            this.decimalSeparator = ",";
            this.header = "Datum      | Omschrijving              | Verandering  ";
        } else {
            throw new IllegalArgumentException("Invalid locale");
        }
    }

    private String formatEntries(LedgerEntry... entries) {
        Comparator<LedgerEntry> ledgerEntryComparator = Comparator.comparing(LedgerEntry::date)
                .thenComparing(LedgerEntry::description)
                .thenComparing(LedgerEntry::change);

        return Arrays.stream(entries)
                .sorted(ledgerEntryComparator)
                .map(this::formatLedgerEntry)
                .collect(Collectors.joining("\n"));
    }

    private String formatLedgerEntry(LedgerEntry ledgerEntry) {
        var formattedDate = getFormattedDate(ledgerEntry.date());
        var formattedDescription = getFormattedDescription(ledgerEntry.description());
        var formattedChange = getFormattedChange(ledgerEntry.change());

        return String.format("%s | %-25s | %13s",
                formattedDate,
                formattedDescription,
                formattedChange);
    }

    private String getFormattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(this.datePattern));
    }

    private String getFormattedDescription(String description) {
        return (description.length() <= DESCRIPTION_MAX_LENGTH)
                ? description
                : description.substring(0, DESCRIPTION_MAX_LENGTH - TRUNCATED_SUFFIX.length()).concat(TRUNCATED_SUFFIX);
    }

    private String getFormattedChange(double change) {
        boolean isChangeNegative = (change < 0.0);
        String changeToString = getChangeToString(change, isChangeNegative);
        return formatChangeToCurrency(changeToString, isChangeNegative);
    }

    private String getChangeToString(double change, boolean isNegative) {
        if (isNegative) {
            return String.format("%.02f", change * -1);
        }
        return String.format("%.02f", change);
    }

    private String formatChangeToCurrency(String change, boolean isNegative) {
        String[] splitChange = change.split("\\.");
        String integerPart = splitChange[0];
        String decimalPart = splitChange[1];

        if (integerPart.length() <= 3) {
            return formatCurrency(integerPart, decimalPart, isNegative);
        }

        String changeWithThousandsSeparator = formatChangeWithThousandsSeparator(integerPart);
        return formatCurrency(changeWithThousandsSeparator, decimalPart, isNegative);
    }

    private String formatCurrency(String integerPart, String decimalPart, boolean isNegative) {
        String sign = isNegative ? "-" : "";
        return sign + this.currencySymbol + integerPart + this.decimalSeparator + decimalPart;
    }

    private String formatChangeWithThousandsSeparator(String integerPart) {
        StringBuilder stringBuilder = new StringBuilder("");
        int count = 1;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            char currentChar = integerPart.charAt(i);

            if (i > 0 && (count % 3) == 0) {
                stringBuilder.append(currentChar).append(this.thousandsSeparator);
            } else {
                stringBuilder.append(currentChar);
            }

            count++;
        }

        return stringBuilder.reverse().toString();
    }

    public record LedgerEntry(LocalDate date, String description, double change) {
    }


}