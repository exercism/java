// Package strand contains functionality to work with a DNA strands
package strand

import "strings"

// ToRNA converts a DNA string into a RNA string
func ToRNA(dna string) string {

	var translation strings.Builder
	for _, n := range dna {
		switch n {
		case 'G':
			translation.WriteRune('C')
		case 'C':
			translation.WriteRune('G')
		case 'T':
			translation.WriteRune('A')
		case 'A':
			translation.WriteRune('U')
		}
	}
	return translation.String()
}
