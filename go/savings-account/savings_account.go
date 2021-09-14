package savings

// FixedInterestRate has a value of 5% (5/100)
const FixedInterestRate = 0.05

// GetFixedInterestRate returns the FixedInterestRate constant
func GetFixedInterestRate() float32 {
	return FixedInterestRate
}

// DaysPerYear has a value of 365
const DaysPerYear = 365

// GetDaysPerYear returns the DaysPerYear constant
func GetDaysPerYear() int {
	return DaysPerYear
}

// Jan-Dec have values of 1-12

const (
	Jan = iota + 1
	Fev
	Mar
	Apr
	May
	Jun
	Jul
	Aug
	Sep
	Oct
	Nov
	Dec
)

// GetMonth returns the value for the given month
func GetMonth(month int) int {
	return month
}

// AccNo type for a string - this is a stub type included to demonstrate how the untyped string constant can be used where this type is required
type AccNo string

// AccountNo has a value of XF348IJ
const AccountNo = "XF348IJ"

// GetAccountNumber returns the AccountNo constant
func GetAccountNumber() AccNo {
	return AccountNo
}
