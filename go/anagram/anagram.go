package anagram

import (
	"strings"
)

func Detect(subject string, candidates []string) []string {

	subjectLower := strings.ToLower(subject)
	subjectMap := letterMap(subjectLower)

	var l []string

	for _, c := range candidates {
		if len(subject) != len(c) {
			continue
		}

		cLower := strings.ToLower(c)
		cMap := letterMap(cLower)

		if equalMaps(subjectMap, cMap) && cLower != subjectLower {
			l = append(l, c)
		}

	}

	return l
}

func equalMaps(a, b map[rune]int) bool {

	if len(a) != len(b) {
		return false
	}

	for l, va := range a {

		vb, ok := b[l]

		if !ok || va != vb {
			return false
		}

	}

	return true
}

func letterMap(s string) map[rune]int {

	res := make(map[rune]int)

	for _, l := range s {
		res[l]++
	}

	return res
}
