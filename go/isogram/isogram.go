// Package isogram contains functions related to isograms
package isogram

import (
	"strings"
	"unicode"
)

// IsIsogram determines if a string is an isogram
func IsIsogram(input string) bool {

	rs := []rune(strings.ToLower(input))
	runeSet := make(map[rune]bool)

	// regular loop just to shut up staticcheck S1029
	for i := 0; i < len(rs); i++ {
		r := rs[i]
		if runeSet[r] && unicode.IsLetter(r) {
			return false
		}
		runeSet[r] = true
	}

	return true
}
