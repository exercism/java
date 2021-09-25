package pangram

import (
	"unicode"
)

const mask = ^uint32(0b111111 << 26)

func IsPangram(input string) bool {

	var set uint32

	for _, r := range input {

		if !unicode.IsLetter(r) {
			continue
		}

		d := unicode.ToLower(r) - 'a'
		set |= 1 << d
	}

	return (mask & set) == mask
}
