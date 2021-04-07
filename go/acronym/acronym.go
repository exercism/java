// Package acronym implements functionality to create acronyms
package acronym

import (
	"unicode"
)

// Abbreviate creates an acronym from a string
func Abbreviate(s string) string {

	acronyms := ""
	lookingForInitial := true
	for _, char := range s {
		isLetter := unicode.IsLetter(char)

		if lookingForInitial && isLetter {
			// Start of a word, save initial and stop looking for initials
			// until the end of the word
			acronyms += string(unicode.ToUpper(char))
			lookingForInitial = false
			continue
		}

		if !lookingForInitial && !isLetter && char != '\'' {
			// End of the word, start looking for initial
			lookingForInitial = true
		}
	}
	return acronyms
}
