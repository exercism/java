package reverse

import "strings"

func Reverse(input string) string {
	iRunes := []rune(input)
	size := len(iRunes)

	var result strings.Builder

	for i := size - 1; i >= 0; i-- {
		result.WriteRune(iRunes[i])
	}

	return result.String()
}
