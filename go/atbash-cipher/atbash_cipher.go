package atbash

import (
	"strings"
	"unicode"
)

// Atbash ciphers a given string using the Atbash cipher.
func Atbash(s string) string {

	var result []string
	var partial string
	for _, c := range s {
		switch {
		case unicode.IsDigit(c):
			partial += string(c)
		case unicode.IsUpper(c):
			partial += string('A' + 'Z' - c - ('A' - 'a'))
		case unicode.IsLower(c):
			partial += string('a' + 'z' - c)
		}

		if len(partial) == 5 {
			result = append(result, partial)
			partial = ""
		}
	}

	if len(partial) > 0 {
		result = append(result, partial)
	}

	return strings.Join(result, " ")
}
