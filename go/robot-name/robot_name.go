package robotname

import (
	"errors"
	"fmt"
)

var MAX_NAMES = 26 * 26 * 10 * 10 * 10

type Robot struct {
	name string
}

// total contains the total of robots created so far
var total int

// alpha controls the generation of the 2 letters of the robot name
var alpha int

// num controls the generation of the 3 digits of the robot name
var num int = -1

func (r *Robot) Name() (string, error) {
	if total == MAX_NAMES {
		return "", errors.New("max amount of names reached")
	}

	if r.name == "" {
		num += 1
		total += 1

		a1, a2 := alpha/26, alpha%26
		if num%1000 == 0 {
			// last number generated ended in 999
			// reset num back to 0 and
			// increase alpha to move on to the next set of letters
			num = 0
			alpha++
		}

		r.name = fmt.Sprintf("%c%c%03d", 'A'+a1, 'A'+a2, num)
	}

	return r.name, nil
}

func (r *Robot) Reset() {
	r.name = ""
}
