package listops

type IntList []int

type binFunc func(int, int) int
type predFunc func(int) bool
type unaryFunc func(int) int

func (l IntList) Append(l2 IntList) IntList {
	ret := IntList([]int{})
	ret = append(ret, l...)
	ret = append(ret, l2...)
	return ret
}

func (l IntList) Concat(lists []IntList) IntList {
	ret := IntList([]int{})

	ret = append(ret, l...)
	for _, list := range lists {
		ret = append(ret, list...)
	}

	return ret
}

func (l IntList) Filter(fn predFunc) IntList {
	ret := IntList([]int{})

	for _, elem := range l {
		if fn(elem) {
			ret = append(ret, elem)
		}
	}

	return ret
}

func (l IntList) Length() int {
	return len(l)
}

func (l IntList) Map(fn unaryFunc) IntList {
	ret := IntList([]int{})

	for _, elem := range l {
		ret = append(ret, fn(elem))
	}

	return ret
}

func (l IntList) Foldl(fn binFunc, acc int) int {
	ret := acc

	for _, elem := range l {
		ret = fn(ret, elem)
	}

	return ret
}

func (l IntList) Foldr(fn binFunc, acc int) int {
	ret := acc
	size := len(l)

	for i := size - 1; i >= 0; i-- {
		ret = fn(l[i], ret)
	}

	return ret
}

func (l IntList) Reverse() IntList {
	ret := IntList([]int{})
	size := len(l)
	for i := size - 1; i >= 0; i-- {
		ret = append(ret, l[i])
	}
	return ret
}
