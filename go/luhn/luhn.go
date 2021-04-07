package luhn

import "unicode"

func Valid(number string) bool {
	if len(number) < 2 {
		return false
	}

	rNumber := []rune(number)
	size := len(rNumber)
	checksum := 0
	n := 0

	for i:= size-1; i>=0; i-- {
		if !unicode.IsNumber(rNumber[i]) {
			if rNumber[i] != ' ' {
				return false
			}
			continue
		}

		d := rNumber[i] - '0'
		if n%2 != 0 {
			d *= 2
			if d > 9 {
				d -= 9
			}
		}

		checksum += int(d)
		n++
	}

	return checksum%10 == 0 && n > 1

}
