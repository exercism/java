package collatzconjecture

import "fmt"

func CollatzConjecture(n int) (int, error) {
	times := 0
	if n <= 0 {
		return 0, fmt.Errorf("zero or negative value given")
	}

	for n != 1 {
		if n%2 == 0 {
			n = n / 2
		} else {
			n = n*3 + 1
		}
		times += 1
	}

	return times, nil
}
