package isogram

import "strings"

func IsIsogram(input string) bool {
	str := strings.ToLower(input)
	m := make(map[byte]int)
	for i:=0; i<len(str); i++ {
		if str[i] == ' ' || str[i] == '-' {
			continue
		}
		m[str[i] - 'a']++
		if m[str[i] - 'a'] > 1 {
			return false
		}
	}
	return true
}
