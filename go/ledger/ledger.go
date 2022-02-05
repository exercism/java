package ledger

import (
	"errors"
	"fmt"
	"sort"
	"strconv"
	"strings"
	"time"
)

type Entry struct {
	Date        string // "Y-m-d"
	Description string
	Change      int // in cents
}

type Locale struct {
	Translations   map[string]string
	DateFormat     string
	DecimalPlace   string
	ThousandsPlace string
	FormatCurrency func(c Currency, cents int) string
}

var localeMap = map[string]Locale{
	"en-US": {
		Translations: map[string]string{
			"date":        "Date",
			"description": "Description",
			"change":      "Change",
		},
		DateFormat:     "01/02/2006",
		DecimalPlace:   ".",
		ThousandsPlace: ",",
		FormatCurrency: func(c Currency, cents int) string {
			absCurr := Abs(cents)

			if cents < 0 {
				return fmt.Sprintf("(%s%s.%02d)",
					c.Symbol,
					formatThousands(absCurr/100, ","),
					absCurr%100,
				)
			}

			return fmt.Sprintf("%s%s.%02d ",
				c.Symbol,
				formatThousands(absCurr/100, ","),
				absCurr%100,
			)
		},
	},
	"nl-NL": {
		Translations: map[string]string{
			"date":        "Datum",
			"description": "Omschrijving",
			"change":      "Verandering",
		},
		DateFormat:     "02-01-2006",
		DecimalPlace:   ",",
		ThousandsPlace: ".",
		FormatCurrency: func(c Currency, cents int) string {
			absCurr := Abs(cents)
			if cents < 0 {
				return fmt.Sprintf("%s %s,%02d-",
					c.Symbol,
					formatThousands(absCurr/100, "."),
					absCurr%100,
				)
			}

			return fmt.Sprintf("%s %s,%02d ",
				c.Symbol,
				formatThousands(absCurr/100, "."),
				absCurr%100,
			)
		},
	},
}

type Currency struct {
	Symbol string
}

var currenciesMap = map[string]Currency{
	"USD": {
		Symbol: "$",
	},
	"EUR": {
		Symbol: "€",
	},
}

func divideThousands(n int) []int {
	var parts []int
	var thousands, underThousands int

	for {
		thousands = n / 1000
		underThousands = n % 1000

		parts = append(parts, underThousands)
		if thousands == 0 {
			break
		}

		n = thousands
	}
	return parts
}

func formatThousands(n int, sep string) string {

	thousands := divideThousands(n)

	var parts []string

	parts = append(parts, strconv.Itoa(thousands[len(thousands)-1]))
	for i := len(thousands) - 2; i >= 0; i-- {
		parts = append(parts, fmt.Sprintf("%03d", thousands[i]))
	}

	return strings.Join(parts, sep)
}

func GetHeader(l Locale) string {
	return fmt.Sprintf("%-10s | %-25s | %s\n",
		l.Translations["date"],
		l.Translations["description"],
		l.Translations["change"])
}

func FormatLedger(currency string, locale string, entries []Entry) (string, error) {

	c, ok := currenciesMap[currency]
	if !ok {
		return "", errors.New("unsupported currency")
	}

	l, ok := localeMap[locale]
	if !ok {
		return "", errors.New("unsupported locale")
	}

	es := make([]Entry, len(entries))
	copy(es, entries)

	sort.Slice(es, func(i, j int) bool {
		if es[i].Date == es[j].Date {
			return es[i].Change < es[j].Change
		}
		return es[i].Date < es[j].Date
	})

	var sb strings.Builder

	sb.WriteString(GetHeader(l))

	for _, e := range es {
		date, err := time.Parse("2006-01-02", e.Date)
		if err != nil {
			return "", errors.New("invalid date")
		}

		dateInLocale := date.Format(l.DateFormat)

		description := limitDescription(e.Description)
		changeFormat := l.FormatCurrency(c, e.Change)
		sb.WriteString(fmt.Sprintf("%-10s | %-25s | %13s\n",
			dateInLocale,
			description,
			changeFormat))

	}

	return sb.String(), nil
}

func limitDescription(description string) string {
	if len(description) > 25 {
		return description[:22] + "..."
	}
	return description
}

func Abs(n int) int {
	if n < 0 {
		return -n
	}
	return n
}
