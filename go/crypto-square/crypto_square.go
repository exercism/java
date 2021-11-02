package cryptosquare

import (
	"math"
	"strings"
	"unicode"
)

func normalize(s string) string {
	var res string
	for _, c := range strings.ToLower(s) {
		c = unicode.ToLower(c)
		if unicode.IsLetter(c) || unicode.IsDigit(c) {
			res += string(c)
		}
	}
	return res
}

func makeSquare(encoded string) []string {
	size := len(encoded)
	c := int(math.Round(math.Sqrt(float64(size))))
	r := c
	if r*c < size {
		c++
	}

	// pad encoded string with spaces
	encoded += strings.Repeat(" ", c*r-size)

	square := make([]string, r)
	for i := 0; i < r; i++ {
		square[i] = encoded[i*c : (i+1)*c]
	}

	return square
}

func codeFromSquare(square []string) string {
	if len(square) == 0 {
		return ""
	}

	l := len(square)
	c := len(square[0])

	var chunks []string
	for i := 0; i < c; i++ {
		var chunk string
		for j := 0; j < l; j++ {
			chunk += string(square[j][i])
		}
		chunks = append(chunks, chunk)
	}

	return strings.Join(chunks, " ")
}

func Encode(pt string) string {
	pt = normalize(pt)
	sq := makeSquare(pt)
	return codeFromSquare(sq)
}
