package armstrong

func Pow(a, b int) int {
	res := 1
	for i := 0; i < b; i++ {
		res *= a
	}
	return res
}

func IsNumber(number int) bool {
	var parts []int

	n := number
	for n > 0 {
		parts = append(parts, n%10)
		n /= 10
	}

	ndigits := len(parts)
	sum := 0
	for _, part := range parts {
		sum += Pow(part, ndigits)
	}

	return sum == number
}
