package romannumerals

import (
	"errors"
	"strings"
)

type ConversionEntry struct {
	Value int
	Digit string
}

var conversions = []ConversionEntry{
	{Value: 1000, Digit: "M"},
	{Value: 900, Digit: "CM"},
	{Value: 500, Digit: "D"},
	{Value: 400, Digit: "CD"},
	{Value: 100, Digit: "C"},
	{Value: 90, Digit: "XC"},
	{Value: 50, Digit: "L"},
	{Value: 40, Digit: "XL"},
	{Value: 10, Digit: "X"},
	{Value: 9, Digit: "IX"},
	{Value: 5, Digit: "V"},
	{Value: 4, Digit: "IV"},
	{Value: 1, Digit: "I"},
}

func ToRomanNumeral(number int) (string, error) {
	if number > 3000 {
		return "", errors.New("arabic number is bigger than 3000")
	}

	if number <= 0 {
		return "", errors.New("arabic number is zero or negative")
	}

	var roman strings.Builder

	for _, conversion := range conversions {
		for number >= conversion.Value {
			roman.WriteString(conversion.Digit)
			number -= conversion.Value
		}
	}

	return roman.String(), nil
}
