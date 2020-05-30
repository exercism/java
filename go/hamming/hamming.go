// Package hamming implements functionality related with the hamming distance
// of two strings
package hamming

import "fmt"

// Distance computes the hamming distance between 2 strings of equal length
func Distance(a, b string) (int, error) {
	size := len(a)
	if size != len(b) {
		return 0, fmt.Errorf("cannot compute hamming distance for strings with different lengths")
	}

	dist := 0

	for i := 0; i < size; i++ {
		if a[i] != b[i] {
			dist++
		}
	}

	return dist, nil
}
