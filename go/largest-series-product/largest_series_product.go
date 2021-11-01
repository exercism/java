package lsproduct

import "errors"

func LargestSeriesProduct(digits string, span int) (int64, error) {
	if span < 0 || span > len(digits) {
		return 0, errors.New("span must be greater than 0 and less than the size of the string")
	}

	if span == 0 {
		return 1, nil
	}

	var largest int64
	for i := 0; i <= len(digits)-span; i++ {

		product := int64(1)
		for j := 0; j < span; j++ {
			if digits[i+j] < '0' || digits[i+j] > '9' {
				return 0, errors.New("string must contain only digits")
			}
			product *= int64(digits[i+j] - '0')
		}
		if product > largest {
			largest = product
		}
	}
	return largest, nil
}
