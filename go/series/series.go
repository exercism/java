package series

func All(n int, s string) []string {
	var res []string

	for i := 0; i <= len(s)-n; i++ {
		res = append(res, s[i:i+n])
	}

	return res
}

func UnsafeFirst(n int, s string) string {
	return s[:n]
}

func First(n int, s string) (string, bool) {
	if n > len(s) {
		return "", false
	}
	return s[:n], true
}
