// Package summultiples for sum of multiples
package summultiples

// SumMultiples is a variadic function to calculate sum of multiples. It takes a limit number and
// a variable number of integers for which multiples will be taken and then summed
//as the return value
func SumMultiples(limit int, divisors ...int) int {
	sum := 0
	for i := 1; i < limit; i++ {
		for _, d := range divisors {
			if d == 0 {
				continue
			}
			if i%d == 0 {
				sum += i
				break
			}
		}
	}
	return sum
}
