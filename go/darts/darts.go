package darts

import "math"

func insideCircle(x, y, radius float64) bool {
	return (x*x + y*y) <= radius*radius
}

type RadiusPoints struct {
	Radius float64
	Points int
}

var pontuationTable = []RadiusPoints{
	{Radius: 1, Points: 10},
	{Radius: 5, Points: 5},
	{Radius: 10, Points: 1},
	{Radius: math.Inf(1), Points: 0},
}

func Score(x, y float64) int {
	for _, pEntry := range pontuationTable {
		if insideCircle(x, y, pEntry.Radius) {
			return pEntry.Points
		}
	}
	return 0
}
