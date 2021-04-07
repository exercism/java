package dna

import (
	"fmt"
)

// Histogram is a mapping from nucleotide to its count in given DNA.
type Histogram map[rune]int

// DNA is a list of nucleotides.
type DNA string

// Counts generates a histogram of valid nucleotides in the given DNA.
// Returns an error if d contains an invalid nucleotide.
func (d DNA) Counts() (Histogram, error) {
	h := Histogram{
		'G': 0,
		'C': 0,
		'T': 0,
		'A': 0,
	}

	for i, n := range d {
		if _, ok := h[n]; !ok {
			return nil, fmt.Errorf("found '%v' at pos %v, which is not a valid nucleotide", n, i)
		}
		h[n]++
	}

	return h, nil
}
