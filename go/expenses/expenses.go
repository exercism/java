package expenses

import "errors"

// Record represents an expense record.
type Record struct {
	Day      int
	Amount   float64
	Category string
}

// DaysPeriod represents a period of days for expenses.
type DaysPeriod struct {
	From int
	To   int
}

// Filter returns the records for which the predicate function returns true.
func Filter(in []Record, predicate func(Record) bool) []Record {
	var out []Record
	for _, r := range in {
		if predicate(r) {
			out = append(out, r)
		}
	}
	return out
}

// ByDaysPeriod returns predicate function that returns true when
// the day of the record is inside the period of day and false otherwise
func ByDaysPeriod(period DaysPeriod) func(Record) bool {
	return func(rec Record) bool {
		return period.From <= rec.Day && rec.Day <= period.To
	}
}

// ByCategory returns predicate function that returns true when
// the category of the record is the same as the provided category
// and false otherwise
func ByCategory(category string) func(Record) bool {
	return func(r Record) bool {
		return r.Category == category
	}
}

// TotalByPeriod returns total amount of expenses for records
// inside the period p
func TotalByPeriod(in []Record, period DaysPeriod) float64 {
	periodExpenses := Filter(in, ByDaysPeriod(period))
	var total float64
	for _, rec := range periodExpenses {
		total += rec.Amount
	}
	return total
}

// CategoryExpenses returns total amount of expenses for records
// in category c that are also inside the period p.
// An error must be returned only if there are no records in the list that belong
// to the given category, regardless of period of time.
func CategoryExpenses(in []Record, period DaysPeriod, cat string) (float64, error) {
	categoryExpenses := Filter(in, ByCategory(cat))
	if len(categoryExpenses) == 0 {
		return 0, errors.New("unknown category")
	}
	return TotalByPeriod(categoryExpenses, period), nil
}

