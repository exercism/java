// Package triangle contains utilities to work with triangles
package triangle

import "math"

// Kind represents a type of triangle
type Kind int

const (
	// NaT represents Not a triangle
	NaT Kind = iota
	// Equ is an Equilateral triangle
	Equ
	// Iso is an Isosceles triangle
	Iso
	// Sca is a Scalene triangle
	Sca
)

// IsTriangle determines if the 3 sides given can make a triangle
func IsTriangle(a, b, c float64) bool {
	pinf := math.Inf(1)
	ninf := math.Inf(-1)
	return a > 0 && b > 0 && c > 0 &&
		a != pinf && b != pinf && c != pinf && a != ninf && b != ninf && c != ninf &&
		a+b >= c && b+c >= a && a+c >= b
}

// KindFromSides returns the type of a triangle given the dimensions of its sides
func KindFromSides(a, b, c float64) Kind {

	if !IsTriangle(a, b, c) {
		return NaT
	}

	if a == b || b == c || c == a {
		if a == b && b == c {
			return Equ
		}
		return Iso
	}

	return Sca
}
