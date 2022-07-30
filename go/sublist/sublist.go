package sublist

type Relation string

const (
	EqualLists   Relation = "equal"
	SubList      Relation = "sublist"
	SuperList    Relation = "superlist"
	UnequalLists Relation = "unequal"
)

func Sublist(a, b []int) Relation {
    
	if len(b) <= len(a) {
		isSub := subList(b, a)
		if len(a) == len(b) {
			if isSub {
				return EqualLists
			}
			return UnequalLists
		}

		if isSub {
			if subList(b, a) {
				return SuperList
			}
		}
	} else {
		if subList(a, b) {
			return SubList
		}
	}
	return UnequalLists
}

func subList(a, b []int) bool {
	if len(a) > len(b) {
		return false
	}

	if len(a) == 0 {
		return true
	}

	for i := 0; i <= len(b)-len(a); i++ {
		for j := 0; j < len(a); j++ {
			if a[j] != b[i+j] {
				break
			}
			if j == len(a)-1 {
				return true
			}
		}
	}
	return false
}
