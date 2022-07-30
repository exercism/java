package isbn

import "unicode"

func IsValidISBN(isbn string) bool {
	ndigits, checksum := 0, 0

	for _, ch := range isbn {
		multiplier := 10 - ndigits

		switch {
		case unicode.IsDigit(ch):
			number := int(ch - '0')
			checksum += number * multiplier
			ndigits++
		case ch == 'X':
			if ndigits != 9 {
				return false
			}
			checksum += 10 * multiplier
			ndigits++
        case ch == '-':
        	continue
    	default:
        	return false
		}

	}

	return checksum%11 == 0 && ndigits == 10
}
