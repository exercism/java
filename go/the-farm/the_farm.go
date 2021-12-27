package thefarm

import (
	"errors"
	"fmt"
)

// SillyNephewError represents an error in the number of cows made by the nephew.
type SillyNephewError struct {
	cows int
}


// Error returns the string associated with the error.
func (e SillyNephewError) Error() string {
	return fmt.Sprintf("silly nephew, there cannot be %d cows", e.cows)
}

// DivideFood computes the fodder amount per cow for the given cows.
func DivideFood(weightFodder WeightFodder, cows int) (float64, error) {

	f, err := weightFodder.FodderAmount()
	if err != nil {
		if err != ErrScaleMalfunction {
			return 0, err
		}
		f *= 2
	}

	switch {
	case cows == 0:
		return 0, errors.New("division by zero")
	case f < 0:
		return 0, errors.New("negative fodder")
	case cows < 0:
		return 0, SillyNephewError{cows: cows}
	}

	return f / float64(cows), nil
}
