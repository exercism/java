package encode

import (
	"strconv"
	"strings"
	"unicode"
)

func RunLengthEncode(input string) string {
	runes := []rune(input)

	if len(runes) == 0 {
		return ""
	}

	var sb strings.Builder
	prev, current := '-', 0

	for i, r := range runes {
		if prev != r && i != 0 {
			sb.WriteString(formatRuneCount(prev, current))
			current = 0
		}
		current++
		prev = r
	}

	sb.WriteString(formatRuneCount(prev, current))
	return sb.String()
}

func RunLengthDecode(input string) string {
	runes := []rune(input)

	if len(runes) == 0 {
		return ""
	}

	var sb strings.Builder
	for i:=0; i< len(runes); i++ {
		r := runes[i]
		if unicode.IsDigit(r) {
			n, c, next := parseNumber(runes[i:])
			sb.WriteString(strings.Repeat(string(c), n))
			i += next
		} else {
			sb.WriteRune(r)
		}
	}

	return sb.String()
}

func formatRuneCount(r rune, count int) string {
	res := ""
	if count > 1 {
		res += strconv.Itoa(count)
	}
	res += string(r)
	return res
}

func parseNumber(runes []rune) (int, rune, int) {
	var numberStr string

	for i, r := range runes {
		if !unicode.IsDigit(r) {
			n, _ := strconv.Atoi(numberStr)
			return n, r, i
		}
		numberStr += string(r)
	}

	return 0, '-', 0
}
