// Package hamming implements functionality related with the hamming distance
// of two strings
package hamming

import (
	"errors"
)

// Distance computes the hamming distance between 2 strings of equal length
func Distance(a, b string) (int, error) {

	runesA, runesB := []rune(a), []rune(b)
	if len(runesA) != len(runesB) {
		return 0, errors.New("cannot compute hamming distance for strings with different lengths")
	}

	dist := 0
	for i := 0; i < len(runesA); i++ {
		if a[i] != b[i] {
			dist++
		}
	}
	return dist, nil
}
