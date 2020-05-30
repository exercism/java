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
	validNuc := map[rune]bool{
		'G': true,
		'C': true,
		'T': true,
		'A': true,
	}

	h := make(Histogram)

	for n := range validNuc {
		h[n] = 0
	}

	for i, n := range d {
		if _, ok := validNuc[n]; !ok {
			return h, fmt.Errorf("found '%v' at pos %v, which is not a valid nucleotide", n, i)
		}
		h[n]++
	}

	return h, nil
}
