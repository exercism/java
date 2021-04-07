package strain

type Lists []Ints

func (ls Lists) Keep(predicate func([]int) bool) Lists {
	var res Lists
	for _, list := range ls {
		if predicate(list) {
			res = append(res, list)
		}
	}
	return res
}

type Ints []int

func (l Ints) Keep(predicate func(x int) bool) Ints {
	var res Ints
	for _, elem := range l {
		if predicate(elem) {
			res = append(res, elem)
		}
	}
	return res
}

func (l Ints) Discard(predicate func(int) bool) Ints {
	var res Ints
	for _, elem := range l {
		if !predicate(elem) {
			res = append(res, elem)
		}
	}
	return res
}

type Strings []string

func (l Strings) Keep(predicate func(string) bool) Strings {
	var res Strings
	for _, elem := range l {
		if predicate(elem) {
			res = append(res, elem)
		}
	}
	return res
}
