package etl

import "strings"

func Transform(oldformat map[int][]string) map[string]int {
	newformat := make(map[string]int)

	for score, words := range oldformat {
		for _, word := range words {
			newformat[strings.ToLower(word)] = score
		}
	}

	return newformat
}
