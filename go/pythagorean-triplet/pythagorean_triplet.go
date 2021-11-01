package pythagorean

type Triplet [3]int

// Sum returns a list of all Pythagorean triplets where the sum a+b+c
// (the perimeter) is equal to p.
// The three elements of each returned triplet must be in order,
// t[0] <= t[1] <= t[2], and the list of triplets must be in lexicographic
// order.
func Sum(p int) []Triplet {
	var triplets []Triplet
	for i := 1; 3*i+3 <= p; i++ {
		for j := i + 1; 2*j+1 <= p; j++ {
			for k := j + 1; k <= p; k++ {
				if i+j+k == p && IsPythagorean(i, j, k) {
					triplets = append(triplets, Triplet{i, j, k})
				}
			}
		}
	}
	return triplets
}

// Range returns a list of all Pythagorean triplets with sides in the
// range min to max inclusive.
func Range(min, max int) []Triplet {
	var triplets []Triplet
	for i := min; i <= max-2; i++ {
		for j := i + 1; j <= max-1; j++ {
			for k := j + 1; k <= max; k++ {
				if IsPythagorean(i, j, k) {
					triplets = append(triplets, Triplet{i, j, k})
				}
			}
		}
	}
	return triplets
}

// IsPythagorean checks if the given triplet is a Pythagorean triplet.
func IsPythagorean(a, b, c int) bool {
	return a*a+b*b == c*c
}
