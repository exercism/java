package clock

import "fmt"

const MinutesDay = 60 * 24

type Clock struct {
	minutes int
}

func (c Clock) Subtract(minutes int) Clock {
	return New(0, c.minutes-minutes)
}

func (c Clock) Add(minutes int) Clock {
	return New(0, c.minutes+minutes)
}

func (c Clock) String() string {
	return fmt.Sprintf("%02d:%02d", c.minutes/60, c.minutes%60)
}

func New(hours int, minutes int) Clock {

	timeToAdd := (hours*60 + minutes) % MinutesDay
	var finalMinutes int
	if timeToAdd < 0 {
		finalMinutes = MinutesDay + timeToAdd
	} else {
		finalMinutes = timeToAdd
	}
	return Clock{minutes: finalMinutes}
}
