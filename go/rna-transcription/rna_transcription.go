// Package strand contains functionality to work with a DNA strands
package strand

import "strings"

// ToRNA converts a DNA string into a RNA string
func ToRNA(dna string) string {
	transTable := map[rune]rune{
		'G': 'C',
		'C': 'G',
		'T': 'A',
		'A': 'U',
	}

	var translation []string

	for _, n := range dna {
		translation = append(translation, string(transTable[n]))
	}

	return strings.Join(translation, "")
}
