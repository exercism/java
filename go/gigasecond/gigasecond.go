// Package gigasecond constains functionality to add a gigasecond
// to a period of time
package gigasecond

import "time"

// GIGASECOND is a duration representing a gigasecond
var GIGASECOND time.Duration

func init() {
	GIGASECOND, _ = time.ParseDuration("1000000000s")
}

// AddGigasecond adds a Gigasecond to the given time
func AddGigasecond(t time.Time) time.Time {
	return t.Add(GIGASECOND)
}
