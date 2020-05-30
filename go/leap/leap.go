// Package leap has a functions to work with leap years
package leap

// IsLeapYear checks if a year is a leap year or not
func IsLeapYear(year int) bool {
	return year%4 == 0 && year%100 != 0 || year%400 == 0
}
