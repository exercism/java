// Package acronym implements functionality to create acronyms
package acronym

import (
	"strings"
)

// ForbiddenRunes is a set of runes to be clean in a string before attempting to create
// an acronym for that string
var ForbiddenRunes map[rune]bool

func init() {
	ForbiddenRunes = map[rune]bool{
		'-': true,
		'_': true,
		':': true,
	}
}

// runeCleaner maps a rune to its replacement
func runeCleaner(r rune) rune {
	if _, ok := ForbiddenRunes[r]; ok {
		return ' '
	}
	return r
}

// Abbreviate creates an acronym from a string
func Abbreviate(s string) string {
	var acronyms []string
	s = strings.TrimSpace(s)
	s = strings.Map(runeCleaner, s)
	words := strings.Split(s, " ")
	for _, w := range words {
		w := strings.TrimSpace(w)
		if w != "" {
			letter := string(w[0])
			acronyms = append(acronyms, strings.ToUpper(letter))
		}
	}
	return strings.Join(acronyms, "")
}
