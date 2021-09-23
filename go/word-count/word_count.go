// Package wordcount provides function to calculate count
// of words
package wordcount

import (
	"strings"
	"unicode"
)

type Frequency map[string]int

// WordCount returns Frequency map with counts of words from input
func WordCount(input string) Frequency {
	splitFn := func(c rune) bool {
		return !unicode.IsNumber(c) && !unicode.IsLetter(c) && c != '\''
	}

	wordCandidates := strings.FieldsFunc(input, splitFn)

	res := make(Frequency)

	for _, candidate := range wordCandidates {
		word := strings.Trim(strings.ToLower(candidate), "'")
		res[word]++
	}

	return res
}
