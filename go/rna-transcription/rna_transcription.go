// Package strand contains functionality to work with a DNA strands
package strand

var transTable = map[rune]rune{
	'G': 'C',
	'C': 'G',
	'T': 'A',
	'A': 'U',
}

// ToRNA converts a DNA string into a RNA string
func ToRNA(dna string) string {

	translation := ""
	for _, n := range dna {
		translation += string(transTable[n])
	}
	return translation
}
