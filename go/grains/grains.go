package grains

import "errors"

func Square(input int) (uint64, error) {
	if input <= 0 || input > 64 {
		return 0, errors.New("negative number or greater than 64 given")
	}
	return  1 << (input-1), nil
}

func Total() uint64 {
	return (1 << 64) - 1
}
