package prime

func Nth(n int) (int, bool) {
	if n < 1 {
		return 0, false
	}
	var i, count int
	for i = 2; count < n; i++ {
		if isPrime(i) {
			count++
		}
	}
	return i - 1, true
}

func isPrime(n int) bool {
	if n < 2 {
		return false
	}
	for i := 2; i*i <= n; i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}
