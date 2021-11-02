package allyourbase

import "errors"

func ConvertToBase(inputBase int, inputDigits []int, outputBase int) ([]int, error) {
	if inputBase < 2 {
		return nil, errors.New("input base must be >= 2")
	}

	if outputBase < 2 {
		return nil, errors.New("output base must be >= 2")
	}

	if !AllDigitsOfBase(inputBase, inputDigits) {
		return nil, errors.New("all digits must satisfy 0 <= d < input base")
	}

	if inputBase == outputBase {
		return inputDigits, nil
	}

	if len(inputDigits) == 0 {
		return []int{0}, nil
	}

	decimal := BaseToDecimal(inputBase, inputDigits)
	return DecimalToOtherBase(decimal, outputBase), nil
}

func BaseToDecimal(base int, digits []int) int {
	result := 0
	for i, digit := range digits {
		result += digit * Pow(base, len(digits)-i-1)
	}
	return result
}

func DecimalToOtherBase(decimal int, base int) []int {
	if decimal == 0 {
		return []int{0}
	}

	result := []int{}
	for decimal > 0 {
		result = append(result, decimal%base)
		decimal /= base
	}
	return ReverseDigits(result)
}

func ReverseDigits(digits []int) []int {
	result := make([]int, len(digits))
	for i, j := 0, len(digits)-1; i <= j; i, j = i+1, j-1 {
		result[i], result[j] = digits[j], digits[i]
	}
	return result
}

func AllDigitsOfBase(base int, digits []int) bool {
	for _, digit := range digits {
		if digit < 0 || digit >= base {
			return false
		}
	}
	return true
}

func Pow(a, b int) int {
	result := 1
	for i := 0; i < b; i++ {
		result *= a
	}
	return result
}
